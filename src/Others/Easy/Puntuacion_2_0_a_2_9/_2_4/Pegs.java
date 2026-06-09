package Others.Easy.Puntuacion_2_0_a_2_9._2_4;

// Se puede mapear en un bitmask de 15 posiciones
// Hacer un BFS de las posibilidades y quedarnos con la mejor de ellas
// Hay 6 movimientos posibles:
//   horizontal: izq,der y viceversa
//   diagonal1:  arriba,abajo y viceversa
//   diagonal2:  arriba_izq-1,abajo_der+1 y viceversa
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Pegs {

    // Clase para representar un movimiento de salto
    static class Move {
        int from, over, to;

        Move(int from, int over, int to) {
            this.from = from;
            this.over = over;
            this.to = to;
        }
    }

    private static List<Move> moves = new ArrayList<Move>();
    private static int[] memo = new int[1 << 15]; // 2^15 = 32768 estados posibles

    public static void main(String[] args) throws IOException {
        // Inicializar la lista de movimientos válidos del tablero
        initializeMoves();

        // Inicializar el arreglo de memoización con -1 (no visitado)
        Arrays.fill(memo, -1);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int initialMask = 0;
        int bitIndex = 0;

        // Leer las 5 líneas del tablero triangular
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            if (line == null) break;
            StringTokenizer st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                if (token.equals("X")) {
                    // Si hay una clavija, encendemos el bit correspondiente
                    initialMask |= (1 << bitIndex);
                }
                bitIndex++;
            }
        }

        // Resolver usando DFS + Memoización
        int minPegsLeft = solve(initialMask);
        System.out.println(minPegsLeft);
    }

    /**
     * Función recursiva con memoización para encontrar el mínimo de clavijas.
     */
    private static int solve(int mask) {
        // Si ya calculamos este estado antes, devolvemos el resultado guardado
        if (memo[mask] != -1) {
            return memo[mask];
        }

        // El peor caso para el estado actual es no hacer más movimientos
        int minPegs = Integer.bitCount(mask);

        // Intentar cada uno de los 36 movimientos posibles
        for (int i = 0; i < moves.size(); i++) {
            Move m = moves.get(i);

            // Verificar si:
            // 1. Hay una clavija en 'from' (bit encendido)
            // 2. Hay una clavija en 'over' (bit encendido)
            // 3. El hueco 'to' está vacío (bit apagado)
            if (((mask & (1 << m.from)) != 0) &&
                    ((mask & (1 << m.over)) != 0) &&
                    ((mask & (1 << m.to)) == 0)) {

                // Generar la nueva máscara aplicando el salto
                int nextMask = mask;
                nextMask &= ~(1 << m.from); // Apagar origen
                nextMask &= ~(1 << m.over); // Apagar saltado
                nextMask |= (1 << m.to);    // Encender destino

                // Ramificar recursivamente y quedarnos con el mínimo global
                int result = solve(nextMask);
                if (result < minPegs) {
                    minPegs = result;
                }
            }
        }

        // Guardar el resultado en la tabla de memoización y retornar
        return memo[mask] = minPegs;
    }

    /**
     * Define de forma estática las líneas rectas de 3 posiciones en el triángulo de 15.
     * Añade automáticamente ambas direcciones (A sobre B hacia C) y (C sobre B hacia A).
     */
    private static void initializeMoves() {
        // Diagonales hacia la izquierda / abajo
        addBidirectionalMove(0, 1, 3);
        addBidirectionalMove(0, 2, 5);
        addBidirectionalMove(1, 3, 6);
        addBidirectionalMove(1, 4, 8);
        addBidirectionalMove(2, 4, 7);
        addBidirectionalMove(2, 5, 9);
        addBidirectionalMove(3, 6, 10);
        addBidirectionalMove(3, 7, 12);
        addBidirectionalMove(4, 7, 11);
        addBidirectionalMove(4, 8, 13);
        addBidirectionalMove(5, 8, 12);
        addBidirectionalMove(5, 9, 14);

        // Horizontales
        addBidirectionalMove(3, 4, 5);
        addBidirectionalMove(6, 7, 8);
        addBidirectionalMove(7, 8, 9);
        addBidirectionalMove(10, 11, 12);
        addBidirectionalMove(11, 12, 13);
        addBidirectionalMove(12, 13, 14);
    }

    private static void addBidirectionalMove(int a, int b, int c) {
        moves.add(new Move(a, b, c));
        moves.add(new Move(c, b, a));
    }
}