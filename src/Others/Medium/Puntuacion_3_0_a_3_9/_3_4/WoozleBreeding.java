package Others.Medium.Puntuacion_3_0_a_3_9._3_4;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class WoozleBreeding {
    static int m1, m2;
    static int numRequests;
    static int[] females = new int[10];
    static int[] requests;
    static int maxSales = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. Lectura de Macho 1, Macho 2 y el número de pedidos K
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        StringTokenizer st = new StringTokenizer(line);
        m1 = Integer.parseInt(st.nextToken());
        m2 = Integer.parseInt(st.nextToken());
        numRequests = Integer.parseInt(st.nextToken());

        // 2. Lectura de las tallas de las 10 hembras
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            females[i] = Integer.parseInt(st.nextToken());
        }

        // 3. Lectura de los pedidos de los clientes
        requests = new int[numRequests];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numRequests; i++) {
            requests[i] = Integer.parseInt(st.nextToken());
        }

        // Estructuras de control para el backtracking:
        // - usedRequests: indica qué pedidos ya han sido asignados a alguna cría
        boolean[] usedRequests = new boolean[numRequests];

        // Iniciamos la búsqueda recursiva comenzando por la hembra 0 y 0 ventas acumuladas
        backtrack(0, 0, usedRequests);

        // Imprimimos el resultado final
        System.out.println(maxSales);
    }

    /**
     * Función recursiva de Backtracking para explorar todas las combinaciones de apareamiento.
     *
     * @param femaleIdx    Índice de la hembra actual que estamos evaluando (0 a 10).
     * @param currentSales Cantidad de pedidos satisfechos hasta el momento en esta rama.
     * @param usedRequests Array booleano que marca los pedidos de clientes ya cubiertos.
     */
    private static void backtrack(int femaleIdx, int currentSales, boolean[] usedRequests) {
        // --- ACTUALIZACIÓN Y CASO BASE ---

        // Actualizamos la mejor respuesta global encontrada hasta ahora
        if (currentSales > maxSales) {
            maxSales = currentSales;
        }

        // PODA POR LÍMITE TEÓRICO: Si ya vendimos a todos los clientes posibles,
        // no tiene sentido seguir explorando esta rama.
        if (maxSales == numRequests) {
            return;
        }

        // CASO BASE: Ya tomamos decisiones para las 10 hembras
        if (femaleIdx == 10) {
            return;
        }

        // PODA POR POTENCIAL: Si el número de ventas actuales más todas las hembras
        // que quedan por procesar no supera a maxSales, cortamos esta rama.
        int remainingFemales = 10 - femaleIdx;
        if (currentSales + remainingFemales <= maxSales) {
            return;
        }

        // --- OPCIONES DE DECISIÓN PARA LA HEMBRA ACTUAL ---

        // Calculamos las dos tallas posibles de cría para la hembra actual
        int childSizeM1 = (m1 + females[femaleIdx]) / 2;
        int childSizeM2 = (m2 + females[femaleIdx]) / 2;

        // OPCIÓN 1: Aparear a femaleIdx con el Macho 1
        exploreMating(femaleIdx, childSizeM1, currentSales, usedRequests);

        // OPCIÓN 2: Aparear a femaleIdx con el Macho 2
        // Se explora únicamente si el Macho 2 genera una talla distinta al Macho 1
        // (evitamos llamadas redundantemente idénticas si m1 == m2)
        if (m1 != m2) {
            exploreMating(femaleIdx, childSizeM2, currentSales, usedRequests);
        }

        // OPCIÓN 3: No aparear a esta hembra (o no vender su cría a ningún cliente activo)
        backtrack(femaleIdx + 1, currentSales, usedRequests);
    }

    /**
     * Método auxiliar que intenta asignar la cría de una talla dada a un cliente no satisfecho.
     */
    private static void exploreMating(int femaleIdx, int childSize, int currentSales, boolean[] usedRequests) {
        boolean matchedAny = false;

        // Iteramos sobre todos los pedidos para ver a quién le sirve esta cría
        for (int i = 0; i < numRequests; i++) {
            // Si el cliente solicita exactamente esta talla y no ha sido atendido aún
            if (!usedRequests[i] && requests[i] == childSize) {
                matchedAny = true;

                // MARCAR (Hacer la elección): Reservamos este pedido
                usedRequests[i] = true;

                // AVANZAR: Procesamos la siguiente hembra incrementando las ventas
                backtrack(femaleIdx + 1, currentSales + 1, usedRequests);

                // DESMARCAR (Deshacer la elección / Backtrack): Liberamos el pedido para otras ramas
                usedRequests[i] = false;
            }
        }

        // Si la cría producida no coincide con ningún pedido pendiente de los clientes,
        // avanzamos a la siguiente hembra manteniendo las mismas ventas acumuladas.
        if (!matchedAny) {
            backtrack(femaleIdx + 1, currentSales, usedRequests);
        }
    }
}