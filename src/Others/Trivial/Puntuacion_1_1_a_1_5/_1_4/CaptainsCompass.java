package Others.Trivial.Puntuacion_1_1_a_1_5._1_4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CaptainsCompass {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Lectura del punto de origen (x1, y1)
        String line1 = br.readLine();
        if (line1 == null || line1.trim().isEmpty()) return;
        StringTokenizer st = new StringTokenizer(line1);
        long x1 = Long.parseLong(st.nextToken());
        long y1 = Long.parseLong(st.nextToken());

        // Lectura del punto de destino (x2, y2)
        String line2 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(line2);
        long x2 = Long.parseLong(st2.nextToken());
        long y2 = Long.parseLong(st2.nextToken());

        /* =========================================================================
         * PLANTEAMIENTO GEOMÉTRICO (DISTANCIA MÍNIMA):
         *
         * 1. Cálculo del Desplazamiento Vectorial:
         *    dx = x2 - x1 (Desplazamiento horizontal)
         *    dy = y2 - y1 (Desplazamiento vertical)
         *
         * 2. Propiedad de la Distancia Mínima en Rejilla con Diagonales:
         *    Moverse en diagonal (NE, NW, SE, SW) avanza 1 unidad en X y 1 unidad en Y
         *    simultáneamente. Por lo tanto, para minimizar la distancia euclidiana total,
         *    debemos MAXIMIZAR el tramo diagonal posible:
         *
         *    - Cantidad de tramo diagonal = min(|dx|, |dy|)
         *    - Cantidad de tramo ortogonal = ||dx| - |dy||
         *
         * 3. Selección de Direcciones:
         *    - Dirección X: "E" si dx > 0, "W" si dx < 0.
         *    - Dirección Y: "N" si dy > 0, "S" si dy < 0.
         *    - Dirección Diagonal: Combinación de Y + X (ej. "N" + "E" = "NE").
         *
         * 4. Descomposición del Camino:
         *    - Si |dx| == |dy|: Basta con 1 dirección DIAGONAL.
         *    - Si dx == 0: Basta con 1 dirección VERTICAL (N o S).
         *    - Si dy == 0: Basta con 1 dirección HORIZONTAL (E o W).
         *    - Si |dy| > |dx|: La distancia vertical es mayor. El camino mínimo combina
         *      la dirección VERTICAL pura con la dirección DIAGONAL.
         *    - Si |dx| > |dy|: La distancia horizontal es mayor. El camino mínimo combina
         *      la dirección HORIZONTAL pura con la dirección DIAGONAL.
         * =========================================================================
         */

        long dx = x2 - x1;
        long dy = y2 - y1;

        // Determinar componentes cardinales
        String dirY = (dy > 0) ? "N" : "S";
        String dirX = (dx > 0) ? "E" : "W";
        String dirDiag = dirY + dirX;

        long absDx = Math.abs(dx);
        long absDy = Math.abs(dy);

        // Caso 1: Movimiento perfectamente diagonal
        if (absDx == absDy) {
            System.out.println(dirDiag);
        }
        // Caso 2: Movimiento puramente vertical
        else if (dx == 0) {
            System.out.println(dirY);
        }
        // Caso 3: Movimiento puramente horizontal
        else if (dy == 0) {
            System.out.println(dirX);
        }
        // Caso 4: Componente vertical predominante (|dy| > |dx|)
        else if (absDy > absDx) {
            System.out.println(dirY);
            System.out.println(dirDiag);
        }
        // Caso 5: Componente horizontal predominante (|dx| > |dy|)
        else {
            System.out.println(dirX);
            System.out.println(dirDiag);
        }
    }
}