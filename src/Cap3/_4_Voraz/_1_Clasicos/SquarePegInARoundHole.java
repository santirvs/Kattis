package Cap3._4_Voraz._1_Clasicos;

// Estrategia Voraz. Clásicos.

// Problema típico de emparejamiento bipartito
// Aplicar una estragegia voraz para asignar cada casa a una parcela.
// Se ordenan las casas por su lado decreciente.
// Se ordenan las parcelas por su diámetro decreciente.
// Se asigna cada casa a la primera parcela que la pueda cubrir.
// Si no hay ninguna parcela que pueda cubrir la casa, se descarta.
// El número de casas asignadas es el resultado.
// Si hay varias casas con el mismo lado, se pueden asignar en cualquier orden.
// Si hay varias parcelas con el mismo diámetro, se pueden usar en cualquier orden.
// El algoritmo es O(n log n) por la ordenación.

// Las casas cuadradas deben ser circunscritas en las parcelas circulares, por lo que habrá que
// calcular el radio de la parcela mínima que pueda contener la casa.
// Las casas no pueden tocar el borde de la parcela, por lo que el radio de la parcela
// debe ser mayor que el radio de la casa.

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class SquarePegInARoundHole {

    public static void main(String[] args) throws IOException {
        // Con 200.000 entradas, es necesario un scanner rápido
        FastScanner sc = new FastScanner();

        // Leer el número de parcelas, el número de casas circulares y el número de casas cuadradas
        int numParcelas = sc.nextInt();
        int numCasasCirculares = sc.nextInt();
        int numCasasCuadradas = sc.nextInt();
        // Aunque los datos son enteros, se usan double ya que hay que calcular el radio del círculo que contiene las casas cuadradas
        double[] parcelas = new double[numParcelas];
        double[] casasCirculares = new double[numCasasCirculares+numCasasCuadradas];
        //Leer el radio de las parcelas circulares
        for (int i = 0; i < numParcelas; i++) {
            parcelas[i] = sc.nextInt();
        }
        //Leer el radio de las casas circulares
        for (int i = 0; i < numCasasCirculares; i++) {
            casasCirculares[i] = sc.nextInt();
        }
        //Leer el lado de las casas cuadradas y calcular el radio del círculo que las contiene
        for (int i = 0; i < numCasasCuadradas; i++) {
            int lado = sc.nextInt();
            casasCirculares[numCasasCirculares + i] = (lado * Math.sqrt(2)) / 2.0;
        }
        // Ordenar las parcelas y las casas por radio decreciente
        Arrays.sort(parcelas);
        Arrays.sort(casasCirculares);
        // Asignar las casas a las parcelas
        // El recorrido se hace en orden decreciente para simular una ordenación decreciente
        // Si una casa no cabe en una parcela, ninguna parcela menor podrá asumirla. Se descarta la casa
        int casasAsignadas = 0;
        int j = numCasasCirculares + numCasasCuadradas - 1; // Puntero para las casas
        for (int i = numParcelas - 1; i >= 0; i--) {
            double radioParcela = parcelas[i];
            // Avanzar el puntero de casas hasta encontrar una que encaje en la parcela
            while (j >= 0 && casasCirculares[j] >= radioParcela) {
                j--;
            }
            if (j >= 0) {
                // Se ha encontrado una casa que se ajusta a la parcela
                casasAsignadas++;
                j--; // Usar esta casa y pasar a la siguiente
            } else {
                // No hay casas que puedan ajustarse a esta parcela o a parcelas menores
                break;
            }
        }

        // Imprimir el número de casas asignadas
        System.out.println(casasAsignadas);

    }

    // Scanner rápido
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = readByte()) != -1 && c <= ' ');
            if (c == -1) return null;
            do {
                sb.append((char)c);
            } while ((c = readByte()) != -1 && c > ' ');
            return sb.toString();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
