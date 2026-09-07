package Others.Trivial.Puntuacion_1_1_a_1_5._1_5;

// Comprobar si tenemos todas las piezas del puzzle
// Usar un set y comprobar al final si tenemos m piezas diferentes

// v1. TLE  - Añadir FastReader --> AC

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Pusluspil {

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

        FR_Int sc = new FR_Int();

        int numPuzzles = sc.nextInt();
        int numPiezas = sc.nextInt();

        Set<Integer> puzzle = new HashSet<>();

        for (int i=0; i<numPuzzles; i++) {
            int numPiezasPuzzle = sc.nextInt();

            for (int j=0; j<numPiezasPuzzle; j++) {
                int pieza = sc.nextInt();
                puzzle.add(pieza);
            }
        }

        //Comprobar si tenemos todas las piezas
        if (puzzle.size() == numPiezas) {
            System.out.println("Jebb");
        } else {
            System.out.println("Neibb");
        }
    }
}

