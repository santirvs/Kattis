package Others.Medium.Puntuacion_3_0_a_3_9._3_4;

/*
    Contar en una mapa de frecuencias las apariciones de la primera lista
    Al ver un numero en la secuencia 1, se incrementa la frecuencia
    Al ver un número en la secuencia 2, se decrementa la frecuencia
    Contamos las frecuencias desequilibradas, cuando llegue a cero es que tenemos las dos iguales
    Imprimir la lista donde guardamos los elementos de la lista 2 en orden
 */
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class PawnShop {


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

    public static void main(String[] args) throws IOException {
        //Scanner scan = new Scanner(System.in);
        FR_Int scan = new FR_Int();

        int n = scan.nextInt();

        int[] primera = new int[n];
        for (int i = 0; i < n; i++) {
            primera[i] = scan.nextInt();
        }

        // Mapa para llevar el balance de frecuencias
        // Balance > 0 : está más veces en la primera secuencia
        // Balance < 0 : está más veces en la segunda secuencia
        Map<Integer, Integer> balance = new HashMap<>();

        // Lista para mantener el orden original de los elementos de la segunda secuencia
        List<Integer> bloqueActual = new ArrayList<>();

        int desequilibrados = 0;
        boolean primerBloque = true;

        StringBuilder salida = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int num1 = primera[i];
            int num2 = scan.nextInt();

            bloqueActual.add(num2);

            // 1. Procesar elemento de la primera secuencia (+1)
            int freq1 = balance.getOrDefault(num1, 0);
            if (freq1 == 0) desequilibrados++; // Estaba en 0, ahora no lo estará
            freq1++;
            if (freq1 == 0) desequilibrados--; // Si volvió a 0, se equilibró
            balance.put(num1, freq1);

            // 2. Procesar elemento de la segunda secuencia (-1)
            int freq2 = balance.getOrDefault(num2, 0);
            if (freq2 == 0) desequilibrados++; // Estaba en 0, ahora no lo estará
            freq2--;
            if (freq2 == 0) desequilibrados--; // Si volvió a 0, se equilibró
            balance.put(num2, freq2);

            // 3. Si el contador de desequilibrados es 0, encontramos un corte óptimo
            if (desequilibrados == 0) {
                if (!primerBloque)
                    salida.append(" #");


                // Imprimimos manteniendo el orden exacto de la segunda secuencia
                for (int num : bloqueActual) {
                    if (!primerBloque) salida.append(" ");
                    else primerBloque = false;

                    salida.append(num);
                }

                bloqueActual.clear();
            }
        }
        System.out.println(salida);
    }
}