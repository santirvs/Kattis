package Others.Easy.Puntuacion_3_0_a_3_9._3_7;

import java.util.*;

public class TheDuckamyds {

    static long[] numPatosUsados;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numColores = scan.nextInt();
        int numNiveles = scan.nextInt();

        long[] numPatos = new long[numColores + 1];
        int[] colorNivel = new int[numNiveles + 1];

        for (int i = 1; i <= numColores; i++) {
            numPatos[i] = scan.nextLong();
        }

        for (int i = 1; i <= numNiveles; i++) {
            colorNivel[i] = scan.nextInt();
        }

        numPatosUsados = new long[numColores + 1];

        int lo = 0, hi = numNiveles;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (esPosible(mid, colorNivel, numPatos)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        System.out.println(hi);
        scan.close();
    }

    static boolean esPosible(int fin, int[] colorNivel, long[] numPatos) {
        Arrays.fill(numPatosUsados, 0);

        long nivelDesdeArriba = 1;

        for (int nivel = fin; nivel > 0; nivel--) {
            long usados = nivelDesdeArriba * nivelDesdeArriba;
            int color = colorNivel[nivel];

            // ✔ evitar overflow y resta peligrosa
            if (numPatosUsados[color] > numPatos[color] - usados) {
                return false;
            }

            numPatosUsados[color] += usados;
            nivelDesdeArriba++;
        }

        return true;
    }
}