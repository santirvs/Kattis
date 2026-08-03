package Others.Medium.Puntuacion_3_0_a_3_9._3_5;


import java.util.Scanner;

public class RiddleOfTheSphinx {

    static Scanner sc = new Scanner(System.in);

    // Envía la pregunta e imprime con flush
    private static int ask(int x, int y, int z) {
        System.out.println(x + " " + y + " " + z);
        System.out.flush();
        return sc.nextInt();
    }

    public static void main(String[] args) {
        // Matriz de preguntas linealmente independiente
        int[][] q = new int[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {1, 2, 3}  // <-- Esta combinación (1, 2, 3) desempata sin ambigüedad
        };

        int[] r = new int[5];
        for (int i = 0; i < 5; i++) {
            r[i] = ask(q[i][0], q[i][1], q[i][2]);
        }

        // Probar cuál de las 5 preguntas fue la mentira (0 a 4) o si ninguna lo fue (5)
        for (int lie = 0; lie <= 5; lie++) {
            int a = -1, b = -1, c = -1;

            if (lie == 0) {
                // r[0] es la mentira. Usamos q[1], q[2], q[3]
                b = r[1];
                c = r[2];
                a = r[3] - b - c;
            } else if (lie == 1) {
                // r[1] es la mentira. Usamos q[0], q[2], q[3]
                a = r[0];
                c = r[2];
                b = r[3] - a - c;
            } else if (lie == 2) {
                // r[2] es la mentira. Usamos q[0], q[1], q[3]
                a = r[0];
                b = r[1];
                c = r[3] - a - b;
            } else if (lie == 3) {
                // r[3] es la mentira. Usamos q[0], q[1], q[2]
                a = r[0];
                b = r[1];
                c = r[2];
            } else if (lie == 4) {
                // r[4] es la mentira. Usamos q[0], q[1], q[2]
                a = r[0];
                b = r[1];
                c = r[2];
            } else {
                // Ninguna es mentira (lie == 5)
                a = r[0];
                b = r[1];
                c = r[2];
            }

            if (a < 0 || b < 0 || c < 0) continue;

            // Comprobamos que los valores a, b, c cumplen TODAS las 4 preguntas que asumimos verdaderas
            boolean valid = true;
            for (int i = 0; i < 5; i++) {
                if (i == lie) continue;
                int expected = q[i][0] * a + q[i][1] * b + q[i][2] * c;
                if (expected != r[i]) {
                    valid = false;
                    break;
                }
            }

            // Si la combinación pasa el test de consistencia completa, esa es la respuesta correcta
            if (valid) {
                System.out.println(a + " " + b + " " + c);
                System.out.flush();
                return;
            }
        }
    }
}