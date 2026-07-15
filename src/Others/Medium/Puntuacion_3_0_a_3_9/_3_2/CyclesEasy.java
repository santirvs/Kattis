package Others.Medium.Puntuacion_3_0_a_3_9._3_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

    /**
     * PROBLEMA: Cycles (Easy)
     * * ============================================================================
     * EXPLICACIÓN DEL PLANTEAMIENTO (Principio de Inclusión-Exclusión + DSU)
     * ============================================================================
     * * 1. EL PROBLEMA ORIGINAL:
     * Queremos contar cuántos Ciclos Hamiltonianos en un grafo completo de 'n'
     * nodos NO utilizan ninguna de las 'k' aristas prohibidas.
     * * 2. EL RETO:
     * Evitar aristas es difícil de calcular de manera directa. Por ello, recurrimos
     * al PRINCIPIO DE INCLUSIÓN-EXCLUSIÓN (PIE).
     * - En lugar de evitar las aristas prohibidas, forzamos la inclusión de un
     * subconjunto 'S' de estas aristas.
     * - Si seleccionamos un número IMPAR de aristas prohibidas, RESTAMOS los ciclos resultantes.
     * - Si seleccionamos un número PAR de aristas prohibidas, SUMAMOS los ciclos resultantes.
     * * 3. CÓMO CONTAR CICLOS QUE OBLIGATORIAMENTE USAN UN SUBCONJUNTO 'S' DE ARISTAS:
     * Para que un conjunto de aristas 'S' pueda formar parte de un ciclo hamiltoniano:
     * - Ningún nodo puede tener más de 2 aristas incidentes en 'S' (Grado máximo <= 2).
     * - No se pueden formar ciclos cerrados de manera prematura (un ciclo que involucre
     * menos de los 'n' nodos).
     * * Si el subconjunto 'S' es válido, se reduce a un conjunto de caminos (cadenas) disjuntos
     * y nodos aislados.
     * * Aplicamos la "CONTRACCIÓN":
     * - Supongamos que tenemos 'c' componentes conexas en total (tratamos cada camino y nodo
     * aislado como un "super-nodo").
     * - El número de formas de ordenar estos 'c' super-nodos en un ciclo es: (c - 1)! / 2.
     * - Cada camino de longitud >= 1 (llamemos 'p' al número de estos caminos) tiene 2 posibles
     * direcciones de recorrido. Así que multiplicamos por 2^p.
     * - FÓRMULA FINAL para un subconjunto S:
     * [ (c - 1)! / 2 ] * 2^p  ===>  (c - 1)! * 2^(p - 1)
     * (Si p = 0, es decir, el conjunto vacío, la fórmula es simplemente (n - 1)! / 2).
     * * 4. COMPLEJIDAD:
     * Como k <= 15, hay 2^k = 32,768 subconjuntos posibles.
     * Para cada subconjunto, verificar la validez y contar componentes con DSU toma O(n + k).
     * Tiempo total aproximado por caso: ~32,768 * 25 operaciones, lo cual toma pocos milisegundos.
     */


    public class CyclesEasy {

        // Definimos el módulo según los requerimientos del problema
        private static final int MOD = 9901;

        // Clase interna para representar las aristas prohibidas del grafo
        static class Edge {
            int u, v;
            Edge(int u, int v) {
                this.u = u;
                this.v = v;
            }
        }

        /**
         * ESTRUCTURA DISJOINT SET UNION (DSU) / UNION-FIND
         * Nos permite agrupar los nodos en componentes conexas de manera eficiente,
         * detectar si al añadir una arista se forma un ciclo, y saber el tamaño de cada componente.
         */
        static class DSU {
            int[] parent;    // parent[i] guarda el nodo padre de 'i'
            int[] size;      // size[i] guarda el tamaño de la componente liderada por 'i'
            int components;  // Lleva el conteo de componentes conexas activas en el grafo

            DSU(int n) {
                parent = new int[n + 1];
                size = new int[n + 1];
                components = n; // Inicialmente, cada nodo es su propia componente independiente (n componentes)
                for (int i = 1; i <= n; i++) {
                    parent[i] = i;
                    size[i] = 1;
                }
            }

            // Encuentra el representante (raíz) de la componente de 'i' con compresión de caminos
            int find(int i) {
                if (parent[i] == i) {
                    return i;
                }
                return parent[i] = find(parent[i]); // Optimización: apunta directamente a la raíz
            }

            // Une las componentes de 'i' y 'j'. Retorna falso si ya pertenecían a la misma (ciclo detectado).
            boolean union(int i, int j) {
                int rootI = find(i);
                int rootJ = find(j);
                if (rootI != rootJ) {
                    parent[rootI] = rootJ;
                    size[rootJ] += size[rootI];
                    components--; // Al unir dos componentes, el total de componentes disminuye en 1
                    return true;
                }
                return false; // Retorna falso porque detectó que 'i' y 'j' ya estaban conectados (ciclo)
            }
        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = null;

            String line = br.readLine();
            if (line == null) return;
            st = new StringTokenizer(line);
            int t = Integer.parseInt(st.nextToken()); // Cantidad de casos de prueba

            // PRECOMPUTACIÓN: Factoriales módulo 9901 (n <= 10 o valores pequeños de componentes)
            long[] fact = new long[15];
            fact[0] = 1;
            for (int i = 1; i < 15; i++) {
                fact[i] = fact[i - 1] * i;
            }

            // PRECOMPUTACIÓN: Potencias de 2 módulo 9901
            int[] pow2 = new int[15];
            pow2[0] = 1;
            for (int i = 1; i < 15; i++) {
                pow2[i] = (pow2[i - 1] * 2) % MOD;
            }

            // Procesamos cada caso de prueba
            for (int tc = 1; tc <= t; tc++) {
                line = br.readLine();
                while (line != null && line.trim().isEmpty()) {
                    line = br.readLine(); // Saltarse líneas en blanco si las hay
                }
                if (line == null) break;
                st = new StringTokenizer(line);
                int n = Integer.parseInt(st.nextToken()); // Número de nodos
                int k = Integer.parseInt(st.nextToken()); // Número de aristas prohibidas

                // Lectura de las aristas prohibidas
                Edge[] forbiddenEdges = new Edge[k];
                for (int i = 0; i < k; i++) {
                    st = new StringTokenizer(br.readLine());
                    int u = Integer.parseInt(st.nextToken());
                    int v = Integer.parseInt(st.nextToken());
                    forbiddenEdges[i] = new Edge(u, v);
                }

                long totalCycles = 0;
                int numSubsets = 1 << k; // 2^k subconjuntos posibles de aristas prohibidas

                // ========================================================================
                // ITERACIÓN SOBRE TODOS LOS SUBCONJUNTOS (MÁSCARA DE BITS)
                // ========================================================================
                for (int mask = 0; mask < numSubsets; mask++) {
                    DSU dsu = new DSU(n);
                    int[] deg = new int[n + 1]; // Almacena el grado de cada nodo en el subconjunto actual
                    boolean invalid = false;    // Bandera para grados inválidos (> 2)
                    boolean hasCycle = false;   // Bandera para ciclos prematuros internos
                    int edgesCount = 0;         // Cuenta cuántas aristas prohibidas se activaron en esta máscara

                    for (int i = 0; i < k; i++) {
                        // Si el bit 'i' está encendido en la máscara, incluimos la arista i-ésima
                        if ((mask & (1 << i)) != 0) {
                            edgesCount++;
                            int u = forbiddenEdges[i].u;
                            int v = forbiddenEdges[i].v;

                            deg[u]++;
                            deg[v]++;

                            // REGLA DE VALIDEZ 1: Un ciclo hamiltoniano solo pasa una vez por nodo.
                            // Por tanto, ningún nodo en nuestro subconjunto puede estar conectado a más de 2 aristas.
                            if (deg[u] > 2 || deg[v] > 2) {
                                invalid = true;
                                break;
                            }

                            // REGLA DE VALIDEZ 2: Intentamos unir en el DSU. Si ya estaban unidos,
                            // significa que estas aristas prohibidas forman un ciclo cerrado.
                            if (!dsu.union(u, v)) {
                                hasCycle = true;
                            }
                        }
                    }

                    // Si el grado de algún nodo superó 2, este subconjunto no puede formar parte de un ciclo.
                    if (invalid) {
                        continue;
                    }

                    long ways = 0; // Guardará el número de ciclos válidos formados con este subconjunto

                    if (hasCycle) {
                        // Si detectamos un ciclo, la ÚNICA manera de que sea válido es que sea
                        // un ciclo hamiltoniano completo (es decir, que conecte a los 'n' nodos
                        // utilizando exactamente 'n' aristas).
                        if (dsu.components == 1 && edgesCount == n) {
                            ways = 1;
                        } else {
                            ways = 0; // Ciclo prematuro parcial descartado.
                        }
                    } else {
                        // El subconjunto es una colección válida de caminos disjuntos y nodos aislados.
                        int c = dsu.components; // Número total de "super-nodos" (cadenas + nodos aislados)

                        // Contamos 'p': número de componentes que son cadenas de longitud >= 1 (es decir, tamaño > 1)
                        int p = 0;
                        for (int i = 1; i <= n; i++) {
                            if (dsu.parent[i] == i && dsu.size[i] > 1) {
                                p++;
                            }
                        }

                        if (p == 0) {
                            // CASO BASE: No se seleccionó ninguna arista prohibida (máscara vacía).
                            // Se calcula la cantidad de ciclos normales de un grafo completo: (n - 1)! / 2.
                            ways = (fact[n - 1] / 2) % MOD;
                        } else {
                            // FÓRMULA DE CONTRACCIÓN: (c - 1)! * 2^(p - 1)
                            ways = (fact[c - 1] % MOD) * pow2[p - 1] % MOD;
                        }
                    }

                    // ========================================================================
                    // APLICACIÓN DEL PRINCIPIO DE INCLUSIÓN-EXCLUSIÓN (PIE)
                    // ========================================================================
                    int bits = Integer.bitCount(mask); // Cuenta cuántas aristas prohibidas usamos en este paso

                    if (bits % 2 == 0) {
                        // Cantidad PAR de aristas prohibidas: SUMAMOS al total.
                        totalCycles = (totalCycles + ways) % MOD;
                    } else {
                        // Cantidad IMPAR de aristas prohibidas: RESTAMOS del total.
                        // Sumamos MOD antes de aplicar la operación módulo para evitar números negativos en Java.
                        totalCycles = (totalCycles - ways + MOD) % MOD;
                    }
                }

                // Impresión del resultado con el formato requerido por el problema
                System.out.println("Case #" + tc + ": " + totalCycles);
            }
        }
    }