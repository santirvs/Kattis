package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias._1_EstucturasDeDatosParaGrafos;

import Utils.Kattio;


// Test case #4: WA -> Error en el módulo 1_000_000_007
//               TLE -> Usar Fast I/O -> AC
// Test case #6: TLE -> Las operaciones transponer y complemento son O(V^2)
//                      mantener la matriz transpuesta, la matriz complemento y la matriz de transpuesta y complemento
// Test case #2: RTE -> ArrayIndexOutOfBoundsException -> MAX_V = 4 -> MAX_V = 4000 -> AC
// Test case #11: TLE -> Hay que optimizar aún más....
//                       No veo por donde optimizar más
// Adaptar desde https://github.com/BrandonTang89/Competitive_Programming_4_Solutions/blob/main/Chapter_2_Data_Structures/Data_Structures_With_Our_Own_Libraries/kattis_abinitio.cpp
// ya que no veo diferencias significativas en la implementación


public class AbInitio {
    static int v, e, q, op, u, n;
    static boolean w;
    static final long mod = 1_000_000_007;
    static boolean[][] G = new boolean[4001][4001];
    static boolean[][] G_t = new boolean[4001][4001];
    static boolean[][] G_c = new boolean[4001][4001];
    static boolean[][] G_ct = new boolean[4001][4001];
    static boolean tranpose = false, complement = false;

    // Assign w to G(u,v)
    static void assign(int u, int v, boolean w) {
        G[u][v] = w;
        G_t[v][u] = w;
        G_c[u][v] = !w;
        G_ct[v][u] = !w;
    }

    static void print_G(boolean[][] Ga) {

        for (int u = 0; u < n; u++) {
            int numAdjacency = 0;
            long ans = 0, multiplier = 1;
            for (int v = 0; v < n; v++) {
                if (u == v) continue;

                if (Ga[u][v]) {
                    numAdjacency++;
                    ans += multiplier * v;
                    ans %= mod;
                    multiplier *= 7;
                    multiplier %= mod;
                }

            }

            System.out.println(numAdjacency + " " + ans);
        }
    }

    public static void main(String[] args) {
        Kattio scan = new Kattio(System.in, System.out);

        n = scan.getInt();
        e = scan.getInt();
        q = scan.getInt();

        for (int i = 0; i < 4000; i++) {
            for (int j = 0; j < 4000; j++) {
                G_c[i][j] = true;
                G_ct[i][j] = true;
            }
        }


        for (int i = 0; i < e; i++) {
            u = scan.getInt();
            v = scan.getInt();
            assign(u, v, true);
        }

        for (int t = 0; t < q; t++) {
            op = scan.getInt();

            if (op == 1) {
                n++;
                w = false;
                if (complement) {
                    w = !w;
                }
                for (int v = 0; v < n - 1; v++) {
                    assign(n - 1, v, w);
                    assign(v, n - 1, w);
                }
            } else if (op == 2) {
                u = scan.getInt();
                v = scan.getInt();
                w = true;
                if (complement) {
                    w = !w;
                }
                if (tranpose) {
                    //swap(u,v);
                    int temp = u;
                    u = v;
                    v = temp;
                }
                assign(u, v, w);
            } else if (op == 3) {
                u = scan.getInt();
                w = false;
                if (complement) {
                    w = !w;
                }
                for (int v = 0; v < n; v++) {
                    if (u == v) continue;
                    assign(u, v, w);
                    assign(v, u, w);
                }
            } else if (op == 4) {
                u = scan.getInt();
                v = scan.getInt();
                w = false;
                if (complement) {
                    w = !w;
                }
                if (tranpose) {
                    int temp = u;
                    u = v;
                    v = temp;
                }
                assign(u, v, w);
            } else if (op == 5) {
                tranpose = !tranpose;
            } else if (op == 6) {
                complement = !complement;
            }

        }

        //print adjmat hash
        System.out.println(n);
        if (complement && tranpose) {
            print_G(G_ct);
        } else if (complement) {
            print_G(G_c);
        } else if (tranpose) {
            print_G(G_t);
        } else {
            print_G(G);
        }
    }
}