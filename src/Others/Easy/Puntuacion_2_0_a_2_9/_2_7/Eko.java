package Others.Easy.Puntuacion_2_0_a_2_9._2_7;

/**
 * Hacer una búsqueda binaria en el espacio de soluciones
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Eko {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long[] trees = new long[n];
        long maxHeight = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            trees[i] = Long.parseLong(st.nextToken());
            if (trees[i] > maxHeight) {
                maxHeight = trees[i];
            }
        }

        long low = 0;
        long high = maxHeight;
        long answer = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long wood = collectWood(trees, mid);

            if (wood >= m) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(answer);
    }

    private static long collectWood(long[] trees, long height) {
        long total = 0;
        for (int i = 0; i < trees.length; i++) {
            if (trees[i] > height) {
                total += (trees[i] - height);
            }
        }
        return total;
    }
}