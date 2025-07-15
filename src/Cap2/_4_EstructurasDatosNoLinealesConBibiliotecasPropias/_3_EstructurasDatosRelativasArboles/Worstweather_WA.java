package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias._3_EstructurasDatosRelativasArboles;

import java.io.*;
import java.util.*;

// Usar un Segment Tree para consultar el máximo en un rango
// y un Fenwick Tree para contar los años con lluvia conocida.

//v1.- TLE Caso #2 --> Usar BufferedReader y StringTokenizer
//v2.- AC Caso #2, pero WA Caso #4

// creo que falla en el caso que no hay datos de lluvia conocidos pero sí que hayan consultas

public class Worstweather_WA {

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st = new StringTokenizer("");

        static String next() throws IOException {
            while (!st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        //Clase para el Segment Tree
        static class SegmentTree {
            int[] tree;
            int size;

            SegmentTree(int[] data) {
                size = data.length;
                tree = new int[4 * size];
                build(1, 0, size - 1, data);
            }

            void build(int node, int l, int r, int[] data) {
                if (l == r) {
                    tree[node] = data[l];
                } else {
                    int mid = (l + r) / 2;
                    build(2 * node, l, mid, data);
                    build(2 * node + 1, mid + 1, r, data);
                    tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
                }
            }

            int query(int node, int l, int r, int ql, int qr) {
                if (qr < l || ql > r) return -1;
                if (ql <= l && r <= qr) return tree[node];
                int mid = (l + r) / 2;
                return Math.max(query(2 * node, l, mid, ql, qr),
                        query(2 * node + 1, mid + 1, r, ql, qr));
            }

            int query(int l, int r) {
                if (l > r) return -1;
                return query(1, 0, size - 1, l, r);
            }
        }

        // Clase para el Fenwick Tree (Binary Indexed Tree)
        static class FenwickTree {
            int[] bit;
            int size;

            FenwickTree(int n) {
                size = n;
                bit = new int[n + 2];
            }

            void update(int idx, int val) {
                for (++idx; idx < bit.length; idx += idx & -idx)
                    bit[idx] += val;
            }

            int query(int idx) {
                int res = 0;
                for (++idx; idx > 0; idx -= idx & -idx)
                    res += bit[idx];
                return res;
            }

            int rangeQuery(int l, int r) {
                if (l > r) return 0;
                return query(r) - query(l - 1);
            }
        }

        public static void main(String[] args) throws IOException {
            StringBuilder out = new StringBuilder();

            boolean firstCase = true;
            while (true) {
                // Control para leer lineas en blanco (separadores de casos)
                String line = br.readLine();
                if (line == null) break;
                line = line.trim();
                if (line.isEmpty()) continue;

                // Control para comprobar si es el final de la entrada (doble 0)
                int n = Integer.parseInt(line);
                if (n == 0) {
                    // leer siguiente línea para comprobar si es 0 y terminar
                    line = br.readLine();
                    if (line == null || line.trim().equals("0")) break;
                    else {
                        n = Integer.parseInt(line.trim());
                        if (n == 0) break;
                    }
                }

                Map<Integer, Integer> rain = new HashMap<>();
                TreeSet<Integer> yearSet = new TreeSet<>();

                int minYear = Integer.MAX_VALUE;
                int maxYear = Integer.MIN_VALUE;

                for (int i = 0; i < n; i++) {
                    int year = nextInt();
                    int amt = nextInt();
                    rain.put(year, amt);
                    yearSet.add(year);
                    minYear = Math.min(minYear, year);
                    maxYear = Math.max(maxYear, year);
                }

                int q = nextInt();
                int[] queriesY = new int[q];
                int[] queriesX = new int[q];

                for (int i = 0; i < q; i++) {
                    int y = nextInt();
                    int x = nextInt();
                    queriesY[i] = y;
                    queriesX[i] = x;
                    yearSet.add(y);
                    yearSet.add(x);
                    minYear = Math.min(minYear, Math.min(y, x));
                    maxYear = Math.max(maxYear, Math.max(y, x));
                }

                int length = maxYear - minYear + 1;

                int[] rainData = new int[length];
                Arrays.fill(rainData, -1);

                FenwickTree fenw = new FenwickTree(length);
                for (Map.Entry<Integer, Integer> e : rain.entrySet()) {
                    int idx = e.getKey() - minYear;
                    rainData[idx] = e.getValue();
                    fenw.update(idx, 1);
                }

                SegmentTree segTree = new SegmentTree(rainData);

                if (!firstCase) out.append("\n");
                firstCase = false;

                for (int i = 0; i < q; i++) {
                    int y = queriesY[i];
                    int x = queriesX[i];
                    if (y > x) {
                        int tmp = y; y = x; x = tmp;
                    }

                    int knownCount = fenw.rangeQuery(y - minYear, x - minYear);
                    boolean allKnown = (knownCount == (x - y + 1));
                    boolean knownY = rain.containsKey(y);
                    boolean knownX = rain.containsKey(x);

                    if (allKnown) {
                        boolean valid = true;
                        if (rainData[x - minYear] > rainData[y - minYear]) valid = false;
                        if (y + 1 <= x - 1) {
                            int maxMid = segTree.query(y - minYear + 1, x - minYear - 1);
                            if (maxMid >= rainData[x - minYear]) valid = false;
                        }
                        out.append(valid ? "true\n" : "false\n");
                    } else {
                        boolean contradiction = false;
                        if (knownY && knownX && rainData[x - minYear] > rainData[y - minYear])
                            contradiction = true;
                        if (knownX && y + 1 <= x - 1) {
                            int maxMid = segTree.query(y - minYear + 1, x - minYear - 1);
                            if (maxMid >= rainData[x - minYear]) contradiction = true;
                        }
                        out.append(contradiction ? "false\n" : "maybe\n");
                    }
                }
            }
            System.out.print(out);
        }
    }
