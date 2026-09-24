package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class IntervalScheduling {

    // Clase auxiliar para representar un Intervalo con su inicio y fin
    static class Interval implements Comparable<Interval> {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval o) {
            // Compara los tiempos de finalización
            return Integer.compare(this.end, o.end);
        }
    }

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
            return negativo ? -res : res;
        }
    }

    public static void main(String[] args) throws IOException {

        // 1- Usar FastReader (hay 10.000 entradas)
        FR_Int scanner = new FR_Int();

        int n = scanner.nextInt();
        Interval[] intervals = new Interval[n];

        // 2. Leer los intervalos
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            intervals[i] = new Interval(start, end);
        }

        // 3. Ordenar los intervalos por su tiempo de finalización (end) de forma ascendente.
        // Utilizando una clase anónima de Comparator (compatible con Java 1.7 y anteriores).
        Arrays.sort(intervals);

        // 4. Algoritmo Greedy para seleccionar el máximo número de intervalos no solapados
        int count = 0;
        int lastEndTime = -1; // Almacena el fin del último intervalo seleccionado

        for (int i = 0; i < n; i++) {
            // Si el inicio del intervalo actual es mayor o igual al fin del último seleccionado,
            // significa que no se solapan y podemos elegirlo.
            // Nota: El enunciado especifica que tocarse en los extremos (ej. fin=4, inicio=4)
            // no se considera solapamiento, por lo que usamos '>='
            if (intervals[i].start >= lastEndTime) {
                count++;
                lastEndTime = intervals[i].end; // Actualizamos el tiempo de fin
            }
        }

        // 5. Imprimir el resultado final
        System.out.println(count);
    }
}