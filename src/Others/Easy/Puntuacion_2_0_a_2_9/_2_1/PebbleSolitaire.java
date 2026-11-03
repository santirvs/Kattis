package Others.Easy.Puntuacion_2_0_a_2_9._2_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class PebbleSolitaire {
    // Array de memorización para los 2^23 estados posibles
    private static final int MAX_STATES = 1 << 23;
    private static final int[] memo = new int[MAX_STATES];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(memo, -1);

        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;
        int t = Integer.parseInt(line.trim());

        while (t-- > 0) {
            String board = br.readLine().trim();
            int mask = 0;
            for (int i = 0; i < 23; i++) {
                if (board.charAt(i) == 'o') {
                    mask |= (1 << i);
                }
            }
            System.out.println(minPebbles(mask));
        }
    }

    private static int minPebbles(int mask) {
        if (memo[mask] != -1) {
            return memo[mask];
        }

        int minRemaining = Integer.bitCount(mask);

        // Probar todos los movimientos posibles en el tablero de 23 posiciones
        for (int i = 0; i < 21; i++) {
            // Patrón 1: 'o o -' (bits en i e i+1 encendidos, bit en i+2 apagado)
            if (((mask >> i) & 7) == 0b011) {
                int nextMask = mask ^ (7 << i); // Invierte los tres bits: 011 -> 100
                minRemaining = Math.min(minRemaining, minPebbles(nextMask));
            }
            // Patrón 2: '- o o' (bit en i apagado, bits en i+1 e i+2 encendidos)
            if (((mask >> i) & 7) == 0b110) {
                int nextMask = mask ^ (7 << i); // Invierte los tres bits: 110 -> 001
                minRemaining = Math.min(minRemaining, minPebbles(nextMask));
            }
        }

        return memo[mask] = minRemaining;
    }
}