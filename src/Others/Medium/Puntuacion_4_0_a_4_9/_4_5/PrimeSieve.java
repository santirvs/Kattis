package Others.Medium.Puntuacion_4_0_a_4_9._4_5;

//Precalcular los primos
//Contarlos y responder a las consultas en base a los precalculados
//Una criba de erastótenes no cumple las restricciones de memoria (50 MB)
//Usar un almacenamiento comprimido en bits y optimizado eliminando los pares

import java.io.IOException;
import java.io.InputStream;

public class PrimeSieve {

    static class FR_Int {
        private InputStream in = System.in;
        private byte[] buffer = new byte[1 << 16];
        private int head = 0;
        private int tail = 0;

        private int read() throws IOException {
            if (head >= tail) {
                head = 0;
                tail = in.read(buffer, 0, buffer.length);
                if (tail <= 0) return -1;   // Fin de archivo
            }
            return buffer[head++];
        }

        public int nextInt() throws IOException {
            int c = read();
            // Ignorar espacios en blanco o saltos de línea (ASCII <= 32)
            while (c != -1 && c <= 32) {
                c = read();
            }

            if (c == -1) return -1; // EOF
            boolean negativo = false;
            if (c == '-') {
                negativo = true;
                c = read();
            }
            int res = 0;
            // Construir el número mientras el carácter sea visible (> 32)
            while (c > 32) {
                res = res * 10 + (c - '0');
                c = read();
            }
            return res;
        }
    }

    static int[] cribaBits;

    public static void main(String[] args) throws IOException {
        FR_Int sc = new FR_Int();

        int maxN = sc.nextInt();  // valor máximo 10^8
        int numConsultas = sc.nextInt();

        //Precalcular la lista de números primos
        cribaOptimizada(maxN);

        // Recorremos la criba para contar los primos calculados "al vuelo"
        long contadorPrimos = contarPrimos(maxN);  // +1 para incluir el 2 que es el único primo par

        //Salida
        System.out.println(contadorPrimos);

        //Consultas
        for (int i=0; i<numConsultas; i++) {
            int num = sc.nextInt();
            boolean esPrimo = esNumeroPrimo(num);

            if (esPrimo) System.out.println(1);
            else System.out.println(0);
        }
    }

    private static int contarPrimos(int numMaximo) {
    int contador = 0;
        for (int i = 0; i <= numMaximo; i++) {
            if (esNumeroPrimo(i)) {
                contador++;
            }
        }
        return contador;
    }

    private static void cribaOptimizada(int maxN) {
        // Cantidad total de números impares
        int numImpares = (maxN - 3) / 2 + 1;

        // Cada int en Java almacena 32 bits. Determinamos el tamaño del array.
        int tamanoArray = (numImpares >> 5) + 1;
        cribaBits = new int[tamanoArray];

        // La raíz cuadrada de 10^8 es 10000. No necesitamos buscar factores más allá.
        int raizMax = (int) Math.sqrt(maxN);

        // --- FASE DE CRIBA ---
        // El bucle calcula dinámicamente el valor del número impar para no pasarse de la raíz
        for (int i = 0; i * i * 2 + i * 6 + 3 <= maxN; i++) {
            // Si el bit i está en 0, significa que el número (2 * i + 3) es primo
            if ((cribaBits[i >> 5] & (1 << (i & 31))) == 0) {
                int primo = 2 * i + 3;

                // Marcamos todos sus múltiplos impares empezando desde su cuadrado
                int inicioMultiplo = (primo * primo - 3) / 2;
                for (int j = inicioMultiplo; j < numImpares; j += primo) {
                    cribaBits[j >> 5] |= (1 << (j & 31)); // Encendemos el bit a 1 (No Primo)
                }
            }
        }
    }

    public static boolean esNumeroPrimo(int x) {
        // 1. El 2 es el único primo par y el 1 no se considera primo (ver ejemplo)
        if (x == 2) {
            return true;
        }

        // 2. Números menores que 2 o números pares mayores que 2 no son primos
        if (x < 2 || (x % 2 == 0)) {
            return false;
        }

        // 3. Calcular la posición del bit para números impares >= 3
        int indice = (x - 3) / 2;

        int posicionInt = indice >> 5; // Equivalente a indice / 32
        int posicionBit = indice & 31; // Equivalente a indice % 32

        // Extraemos el bit. Si el resultado de la operación AND es 0, el bit estaba apagado (es primo).
        int bit = (cribaBits[posicionInt] & (1 << posicionBit));

        return bit == 0;
    }
}