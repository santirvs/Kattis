package Others.Easy.Puntuacion_2_0_a_2_9._2_3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Permanent {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        int N = Integer.parseInt(line.trim());
        long[][] A = new long[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Long.parseLong(st.nextToken());
            }
        }

        long permanent = computePermanentRyser(A, N);
        System.out.println(permanent);
    }

    private static long computePermanentRyser(long[][] A, int N) {
        long totalSum = 0;
        int numSubsets = 1 << N; // 2^N subconjuntos de columnas

        long[] rowSums = new long[N];
        int gray = 0;

        for (int i = 0; i < numSubsets; i++) {
            int nextGray = i ^ (i >> 1); // Generar siguiente Gray Code
            int diff = gray ^ nextGray;   // Bit que cambia

            if (i > 0) {
                int col = Integer.numberOfTrailingZeros(diff);

                // Si el bit se enciende, sumamos la columna; si se apaga, la restamos
                if ((nextGray & diff) != 0) {
                    for (int r = 0; r < N; r++) {
                        rowSums[r] += A[r][col];
                    }
                } else {
                    for (int r = 0; r < N; r++) {
                        rowSums[r] -= A[r][col];
                    }
                }
            }

            gray = nextGray;

            // Calcular el producto de las sumas de las filas
            long prod = 1;
            for (int r = 0; r < N; r++) {
                prod *= rowSums[r];
            }

            // Aplicar el signo (-1)^(N - |S|)
            int card = Integer.bitCount(gray);
            if ((N - card) % 2 == 0) {
                totalSum += prod;
            } else {
                totalSum -= prod;
            }
        }

        return totalSum; // El signo total ya queda correctamente acumulado
    }
}