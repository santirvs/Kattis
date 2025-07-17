package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias._3_EstructurasDatosRelativasArboles;

import java.io.*;
import java.util.*;

// Usar un Segment Tree para consultar el máximo en un rango
// y un Fenwick Tree para contar los años con lluvia conocida.

//v1.- TLE Caso #2 --> Usar BufferedReader y StringTokenizer
//v2.- AC Caso #2, pero WA Caso #4

// creo que falla en el caso que no hay datos de lluvia conocidos pero sí que hayan consultas
//v3.- Ahora el Caso #4 da TLE, transformo a C++ y da WA


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
                int q = -1;
                if (n == 0) {
                    // leer siguiente línea para comprobar si es 0 y terminar
                    line = br.readLine();
                    if (line == null || line.trim().equals("0")) break;
                    else {
                        q = Integer.parseInt(line.trim());
                        if (q == 0) break;
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

                if (q==-1) {
                    // Si no se ha leído el número de consultas, leerlo ahora
                    q = nextInt();
                }
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

                // Control del salto de línea entre casos (excepto el primero)
                if (!firstCase) out.append("\n");
                else firstCase = false;

                // Construir el Segment Tree con los datos de lluvia
                SegmentTree segTree = new SegmentTree(rainData);

                // Procesar las consultas
                for (int i = 0; i < q; i++) {
                    int y = queriesY[i];
                    int x = queriesX[i];

                    // Consultar el rango de años informados entre x e y
                    int knownCount = fenw.rangeQuery(y - minYear, x - minYear);
                    boolean allKnown = (knownCount == (x - y + 1));
                    boolean knownY = rain.containsKey(y);
                    boolean knownX = rain.containsKey(x);

                    //Si todos los años entre x e y tienen datos de lluvia
                    if (allKnown) {
                        // Buscar que se cumplen las condiciones. Inicialmente se asume que es válido
                        boolean valid = true;
                        // La lluvia de x no puede ser mayor que la de y
                        if (rainData[x - minYear] > rainData[y - minYear]) valid = false;
                        // No puede haber un año intermedio con lluvia mayor o igual a la de x
                        if (y + 1 <= x - 1) {
                            int maxMid = segTree.query(y - minYear + 1, x - minYear - 1);
                            if (maxMid >= rainData[x - minYear]) valid = false;
                        }
                        out.append(valid ? "true\n" : "false\n");
                    } else {
                        // Si no todos los años tienen datos de lluvia, se busca alguna contradicción
                        boolean contradiction = false;
                        // La lluvia de y debe ser menor o igual a la de x
                        if (knownY && knownX && rainData[x - minYear] > rainData[y - minYear])
                            contradiction = true;
                        // No puede haber un año intermedio con lluvia mayor a la de x
                        if (knownX && y + 1 <= x - 1) {
                            int maxMid = segTree.query(y - minYear + 1, x - minYear - 1);
                            if (maxMid >= rainData[x - minYear]) contradiction = true;
                        }
                        //Si hay contradicción, se imprime "false", sino "maybe"
                        out.append(contradiction ? "false\n" : "maybe\n");
                    }
                }
            }
            System.out.print(out);
        }
    }


    /*

4
2002 4920
2003 5901
2004 2832
2005 3890
2
2002 2005
2003 2005

3
1985 5782
1995 3048
2005 4890
2
1985 2005
2005 2015

0
0

false
true

maybe
maybe
     */

/*
0
2
2002 2005
2003 2005

0
0

maybe
maybe
 */

/*
// From: https://github.com/donaldong/kattis/blob/main/solutions/worstweather/worstweather.cpp
#include <bits/stdc++.h>
using namespace std;

using vi = vector<int>;
vi st, V;

int left(int p) { return p << 1; }
int right(int p) { return (p << 1) + 1; }

void build(int p, int L, int R) {
  if (L == R) st[p] = V[L];
  else {
    int mid = (L + R) / 2;
    build(left(p), L, mid);
    build(right(p), mid + 1, R);
    st[p] = max(st[left(p)], st[right(p)]);
  }
}

int rmq(int p, int L, int R, int i, int j) {
  if (i > R || j < L) return 0;
  if (L >= i && R <= j) return st[p];
  int mid = (L + R) / 2;
  return max(
    rmq(left(p), L, mid, i, j),
    rmq(right(p), mid + 1, R, i, j)
  );
}

int main() {
  ios::sync_with_stdio(0);

  while (true) {
    int n, m, x, y;
    scanf("%d", &n);
    if (!n) break;

    vi Y(n);
    V.resize(n);
    st.assign(4 * n, 0);
    for (int i = 0; i < n; ++i) {
      scanf("%d %d", &Y[i], &V[i]);
    }
    build(1, 0, n - 1);

    scanf("%d", &m);
    while (m--) {
      int res;
      scanf("%d %d", &y, &x);
      auto a = lower_bound(Y.begin(), Y.end(), y);
      auto b = lower_bound(Y.begin(), Y.end(), y + 1);
      auto c = lower_bound(Y.begin(), Y.end(), x);
#ifdef DEBUG
      printf("a: %d, ", a == Y.end() ? -1 : *a);
      printf("b: %d, ", b == Y.end() ? -1 : *b);
      printf("c: %d\n", c == Y.end() ? -1 : *c);
#endif
      bool dne_a = a == Y.end() || *a != y;
      bool dne_b = b == Y.end() || b == c;
      bool dne_c = c == Y.end() || *c != x;
      int i = distance(Y.begin(), a);
      int j = distance(Y.begin(), b);
      int k = distance(Y.begin(), c);
      int va = dne_a ? INT_MAX : V[i];
      int vb = dne_b ? 0 : rmq(1, 0, n - 1, j, k - 1);
      int vc = dne_c ? va : V[k];

      if (dne_a) {
        if (dne_b || dne_c) res = 2;
        else res = vb < vc ? 2 : 0;
      } else {
        if (dne_b) {
          if (dne_c) res = 2;
          else {
            res = vc <= va ? 2 : 0;
            if (res && y + 1 == x) res = 1;
          }
        } else {
          if (dne_c) res = vb < va ? 2 : 0;
          else {
            res = vc <= va && vb < vc;
            if (res && k - i != x - y) res = 2;
          }
        }
      }

      if (res == 0) printf("false\n");
      else if (res == 1) printf("true\n");
      else printf("maybe\n");
    }
    printf("\n");
  }
  return 0;
}
 */