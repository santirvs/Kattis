package Others.Easy.Puntuacion_1_1_a_1_9._1_6;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExclusiveDisplay {

    /*
     * Indices de bit (0 a 6) para los 7 segmentos en una cuadricula de 7 filas x 4 columnas:
     *
     *  fila 0:  .##.   -> bit 0: grid[0][1] y grid[0][2] (superior)
     *  fila 1:  #..#   -> bit 1: grid[1][0] y grid[2][0] (sup. izq.) | bit 2: grid[1][3] y grid[2][3] (sup. der.)
     *  fila 2:  #..#
     *  fila 3:  .##.   -> bit 3: grid[3][1] y grid[3][2] (central)
     *  fila 4:  #..#   -> bit 4: grid[4][0] y grid[5][0] (inf. izq.) | bit 5: grid[4][3] y grid[5][3] (inf. der.)
     *  fila 5:  #..#
     *  fila 6:  .##.   -> bit 6: grid[6][1] y grid[6][2] (inferior)
     */

    // Patron estandar de cada digito 0..9 (1 = segmento encendido en el digito)
    private static final int[] DIGIT_MASK = {
            // 0: top, top-left, top-right, bottom-left, bottom-right, bottom
            (1 << 0) | (1 << 1) | (1 << 2) | (1 << 4) | (1 << 5) | (1 << 6),
            // 1: top-right, bottom-right
            (1 << 2) | (1 << 5),
            // 2: top, top-right, middle, bottom-left, bottom
            (1 << 0) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 6),
            // 3: top, top-right, middle, bottom-right, bottom
            (1 << 0) | (1 << 2) | (1 << 3) | (1 << 5) | (1 << 6),
            // 4: top-left, top-right, middle, bottom-right
            (1 << 1) | (1 << 2) | (1 << 3) | (1 << 5),
            // 5: top, top-left, middle, bottom-right, bottom
            (1 << 0) | (1 << 1) | (1 << 3) | (1 << 5) | (1 << 6),
            // 6: top, top-left, middle, bottom-left, bottom-right, bottom
            (1 << 0) | (1 << 1) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6),
            // 7: top, top-right, bottom-right
            (1 << 0) | (1 << 2) | (1 << 5),
            // 8: todos los 7 segmentos
            (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6),
            // 9: top, top-left, top-right, middle, bottom-right, bottom
            (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 5) | (1 << 6)
    };

    // Extrae la mascara de 7 bits a partir de la cuadricula 7x4 leida
    private static int extractMask(char[][] g) {
        int mask = 0;

        // Bit 0: superior (fila 0, cols 1-2)
        if (g[0][1] == '#' && g[0][2] == '#') {
            mask |= (1 << 0);
        }
        // Bit 1: superior izquierdo (filas 1-2, col 0)
        if (g[1][0] == '#' && g[2][0] == '#') {
            mask |= (1 << 1);
        }
        // Bit 2: superior derecho (filas 1-2, col 3)
        if (g[1][3] == '#' && g[2][3] == '#') {
            mask |= (1 << 2);
        }
        // Bit 3: central (fila 3, cols 1-2)
        if (g[3][1] == '#' && g[3][2] == '#') {
            mask |= (1 << 3);
        }
        // Bit 4: inferior izquierdo (filas 4-5, col 0)
        if (g[4][0] == '#' && g[5][0] == '#') {
            mask |= (1 << 4);
        }
        // Bit 5: inferior derecho (filas 4-5, col 3)
        if (g[4][3] == '#' && g[5][3] == '#') {
            mask |= (1 << 5);
        }
        // Bit 6: inferior (fila 6, cols 1-2)
        if (g[6][1] == '#' && g[6][2] == '#') {
            mask |= (1 << 6);
        }

        return mask;
    }

    // Simula introducir el numero streak (sin ceros a la izquierda) sobre el display vacio (0)
    private static int simulateStreak(int streak) {
        if (streak < 10) {
            return DIGIT_MASK[streak];
        }
        int tens = streak / 10;
        int ones = streak % 10;
        return DIGIT_MASK[tens] ^ DIGIT_MASK[ones];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] grid = new char[7][4];
        int row = 0;

        while (row < 7) {
            String line = br.readLine();
            if (line == null) {
                return;
            }
            if (line.length() < 4) {
                continue;
            }
            for (int col = 0; col < 4; col++) {
                grid[row][col] = line.charAt(col);
            }
            row++;
        }

        int targetMask = extractMask(grid);
        List<Integer> matches = new ArrayList<Integer>();

        // Se evaluan las rachas en orden ascendente (0..99)
        for (int streak = 0; streak <= 99; streak++) {
            if (simulateStreak(streak) == targetMask) {
                matches.add(Integer.valueOf(streak));
            }
        }

        if (matches.isEmpty()) {
            System.out.println("impossible");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < matches.size(); i++) {
                if (i > 0) {
                    sb.append(' ');
                }
                sb.append(matches.get(i));
            }
            System.out.println(sb.toString());
        }
    }
}