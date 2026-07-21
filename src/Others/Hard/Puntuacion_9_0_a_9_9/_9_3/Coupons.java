package Others.Hard.Puntuacion_9_0_a_9_9._9_3;

import java.io.InputStream;
import java.io.IOException;

public class Coupons {

    /**
     * Lector rápido de datos de entrada personalizado.
     * Evita el overhead de Scanner/BufferedReader para procesar entradas masivas en tiempo récord.
     */
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[131072]; // Buffer de 128 KB
        private int head = 0;
        private int tail = 0;

        private int readByte() throws IOException {
            if (head >= tail) {
                head = 0;
                tail = in.read(buffer, 0, buffer.length);
                if (tail <= 0) return -1;
            }
            return buffer[head++];
        }

        public Integer nextInt() throws IOException {
            int c = readByte();
            while (c <= ' ') {
                if (c == -1) return null;
                c = readByte();
            }
            int res = 0;
            while (c > ' ') {
                if (c < '0' || c > '9') throw new IOException();
                res = res * 10 + c - '0';
                c = readByte();
            }
            return res;
        }

        public Long nextLong() throws IOException {
            int c = readByte();
            while (c <= ' ') {
                if (c == -1) return null;
                c = readByte();
            }
            long res = 0;
            while (c > ' ') {
                if (c < '0' || c > '9') throw new IOException();
                res = res * 10 + c - '0';
                c = readByte();
            }
            return res;
        }
    }

    // Valor infinito para invalidar billetes caducados (> 10,000 segundos)
    static final long INF = 100_000_000_000_000_000L;


    /**
     * Árbol de Segmentación con Lazy Propagation.
     *
     * Mantiene en la hoja 'j' el valor evaluado de la fórmula DP:
     *   tree[j] = DP[j - 1] + (maxZone(j..i) - minZone(j..i) + 2)
     *
     * Permite:
     *  1. Asignaciones/actualizaciones en puntos individuales en O(log N).
     *  2. Sumas/restas de rangos en O(log N) mediante Lazy Propagation (cuando max/min cambian).
     *  3. Consultar el mínimo valor en el rango de tiempo válido [earliestJ, i] en O(log N).
     */
    static class SegmentTree {
        int n;
        long[] tree;
        long[] lazy;

        public SegmentTree(int n) {
            this.n = n;
            tree = new long[4 * (n + 2)];
            lazy = new long[4 * (n + 2)];
        }

        // Propaga las actualizaciones diferidas hacia los hijos antes de descender
        private void push(int node) {
            if (lazy[node] != 0) {
                long val = lazy[node];

                // Pasa el valor diferido a los hijos izquierdo y derecho
                lazy[node << 1] += val;
                tree[node << 1] += val;
                lazy[(node << 1) | 1] += val;
                tree[(node << 1) | 1] += val;

                // Limpia el valor pendiente en el nodo actual
                lazy[node] = 0;
            }
        }

        /**
         * Suma 'val' a un rango completo [l, r].
         * Utilizado por las pilas monotónicas cuando una nueva zona altera el Máximo/Mínimo
         * de varios billetes pasados.
         */
        public void update(int node, int start, int end, int l, int r, long val) {
            if (l > end || r < start || l > r) return;
            if (l <= start && end <= r) {
                tree[node] += val;
                lazy[node] += val;
                return;
            }
            push(node);
            int mid = (start + end) >> 1;
            update(node << 1, start, mid, l, r, val);
            update((node << 1) | 1, mid + 1, end, l, r, val);
            tree[node] = Math.min(tree[node << 1], tree[(node << 1) | 1]);
        }

        /**
         * Asigna un valor puntual a una posición específica 'idx'.
         * Se utiliza para inicializar una nueva opción 'j' o para invalidarla con INF cuando vence.
         */
        public void setPoint(int node, int start, int end, int idx, long val) {
            if (start == end) {
                tree[node] = val;
                lazy[node] = 0;
                return;
            }
            push(node);
            int mid = (start + end) >> 1;
            if (idx <= mid) {
                setPoint(node << 1, start, mid, idx, val);
            } else {
                setPoint((node << 1) | 1, mid + 1, end, idx, val);
            }
            tree[node] = Math.min(tree[node << 1], tree[(node << 1) | 1]);
        }

        /**
         * Devuelve el mínimo valor almacenado dentro del rango [l, r].
         */
        public long query(int node, int start, int end, int l, int r) {
            if (l > end || r < start || l > r) return INF;
            if (l <= start && end <= r) {
                return tree[node];
            }
            push(node);
            int mid = (start + end) >> 1;
            long p1 = query(node << 1, start, mid, l, r);
            long p2 = query((node << 1) | 1, mid + 1, end, l, r);
            return Math.min(p1, p2);
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner();
        Integer nObj = scanner.nextInt();

        while (nObj != null) {
            int n = nObj;

            int[] zones = new int[n + 1];
            long[] times = new long[n + 1];

            // CONTEXTO INICIAL:
            // Johan arranca en la Zona 0 en el tiempo t = 0 (antes de su primer viaje).
            zones[0] = 0;
            times[0] = 0;

            for (int i = 1; i <= n; i++) {
                zones[i] = scanner.nextInt();
                times[i] = scanner.nextLong();
            }

            // Mantiene el valor máximo y mínimo que cubre un viaje j en su nacimiento (j=i).
            int[] curMax = new int[n + 1];
            int[] curMin = new int[n + 1];

            // Pilas monotónicas que almacenan los índices 'j' de los billetes
            int[] maxStack = new int[n + 2];
            int[] minStack = new int[n + 2];
            int maxTop = 0;
            int minTop = 0;

            // dp[i] = Mínimo costo en cupones para completar exitosamente los primeros 'i' viajes.
            long[] dp = new long[n + 1];
            dp[0] = 0; // Costo inicial sin viajes realizados = 0 cupones.

            SegmentTree st = new SegmentTree(n + 1);

            int earliestJ = 1; // Puntero al billete más antiguo que aún no ha expirado en tiempo.

            for (int i = 1; i <= n; i++) {

                // =========================================================================
                // PASO 1: INSERTAR LA OPCIÓN DE COMPRAR UN BILLETE EN EL VIAJE 'i' (j = i)
                // =========================================================================
                // Un billete comprado en j = i debe cubrir las zonas [zones[i-1], zones[i]].
                curMax[i] = Math.max(zones[i - 1], zones[i]);
                curMin[i] = Math.min(zones[i - 1], zones[i]);

                // Fórmula inicial para la hoja 'i' en el Árbol de Segmentación:
                // Base = dp[i - 1] + (máximoInicial - mínimoInicial + 2)
                long baseVal = dp[i - 1] + (curMax[i] - curMin[i]) + 2;
                st.setPoint(1, 1, n, i, baseVal);

                // =========================================================================
                // PASO 2: ACTUALIZAR MÁXIMOS MEDIANTE LA PILA MONOTÓNICA DE MÁXIMOS
                // =========================================================================
                // Si la zona de llegada actual 'zones[i]' es mayor que los máximos registrados
                // por billetes de compras anteriores j < i, esos billetes ahora requieren cubrir una zona mayor.
                while (maxTop > 0 && curMax[maxStack[maxTop - 1]] <= zones[i]) {
                    int idx = maxStack[--maxTop];
                    int prevIdx = (maxTop > 0) ? maxStack[maxTop - 1] : 0;
                    int l = prevIdx + 1;
                    int r = idx;

                    // Restamos el máximo viejo que ya no aplica en este rango
                    st.update(1, 1, n, l, r, -curMax[idx]);
                }
                int prevMaxIdx = (maxTop > 0) ? maxStack[maxTop - 1] : 0;
                int lMax = prevMaxIdx + 1;
                int rMax = i - 1;
                if (lMax <= rMax) {
                    // Sumamos la nueva zona máxima a todos los billetes afectados
                    st.update(1, 1, n, lMax, rMax, zones[i]);
                }
                maxStack[maxTop++] = i;
                curMax[i] = Math.max(curMax[i], zones[i]);

                // =========================================================================
                // PASO 3: ACTUALIZAR MÍNIMOS MEDIANTE LA PILA MONOTÓNICA DE MÍNIMOS
                // =========================================================================
                // Si la zona de llegada actual 'zones[i]' es menor que los mínimos registrados
                // por billetes de compras anteriores, debemos actualizar el coste de esos billetes.
                while (minTop > 0 && curMin[minStack[minTop - 1]] >= zones[i]) {
                    int idx = minStack[--minTop];
                    int prevIdx = (minTop > 0) ? minStack[minTop - 1] : 0;
                    int l = prevIdx + 1;
                    int r = idx;

                    // Al ser la fórmula (MAX - MIN), quitar un MIN equivale a SUMAR el MIN viejo
                    st.update(1, 1, n, l, r, curMin[idx]);
                }
                int prevMinIdx = (minTop > 0) ? minStack[minTop - 1] : 0;
                int lMin = prevMinIdx + 1;
                int rMin = i - 1;
                if (lMin <= rMin) {
                    // Y restar la nueva zona mínima
                    st.update(1, 1, n, lMin, rMin, -zones[i]);
                }
                minStack[minTop++] = i;
                curMin[i] = Math.min(curMin[i], zones[i]);

                // =========================================================================
                // PASO 4: CONTROL DE CADUCIDAD DE BILLETES (VENTANA DE 10,000 SEGUNDOS)
                // =========================================================================
                // Un billete comprado para el viaje 'j' solo es válido si no han transcurrido
                // más de 10,000 segundos hasta el momento de iniciar el viaje 'i'.
                while (earliestJ <= i && times[i] - times[earliestJ] > 10000) {
                    // Asignamos INF a la hoja descalificada para que jamás sea elegida por el query
                    st.setPoint(1, 1, n, earliestJ, INF);
                    earliestJ++;
                }

                // =========================================================================
                // PASO 5: CALCULAR Y GUARDAR LA MEJOR OPCIÓN PARA dp[i]
                // =========================================================================
                // Buscamos el mínimo costo global entre todos los billetes válidos activos [earliestJ, i].
                dp[i] = st.query(1, 1, n, earliestJ, i);
            }

            // Imprime la respuesta final: costo mínimo para cubrir los 'n' viajes.
            System.out.println(dp[n]);

            nObj = scanner.nextInt();
        }
    }
}


