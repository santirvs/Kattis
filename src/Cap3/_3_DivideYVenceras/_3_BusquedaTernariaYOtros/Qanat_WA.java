package Cap3._3_DivideYVenceras._3_BusquedaTernariaYOtros;

/** Kattis - qanat
 *
 * Original de: https://github.com/BrandonTang89/Competitive_Programming_4_Solutions/blob/main/Chapter_3_Problem_Solving_Paradigms/Divide_and_Conquer/kattis_qanat.cpp
 *
 * La traducción a Java da WA en el caso #5. Posiblemente por el uso de long double en C++.
 *
 * Problema interesante. Si tenemos 0 pozos verticales, podemos calcular el costo mínimo en O(1)
 * moviendo cada porción de tierra al agujero más cercano de los 2.
 *
 * Si tenemos 1 pozo, podemos hacer búsqueda ternaria para ubicar el pozo. En cada iteración,
 * podemos calcular el costo de mover la tierra a la derecha del pozo hacia ese agujero o hacia
 * el agujero principal. Luego nos damos cuenta de que nos queda el caso de 0 pozos en el lado
 * izquierdo, aunque sea una versión más pequeña del triángulo, sigue siendo un triángulo similar.
 * Por lo tanto, podemos tratar este subproblema que ya hemos resuelto.
 *
 * En general, si hemos resuelto el subproblema de i-1 pozos, podemos resolver el de i pozos
 * mediante búsqueda ternaria para encontrar el i-ésimo agujero y usar la solución del subproblema
 * de i-1 agujeros.
 *
 * Tiempo: O(n * 100), Memoria: O(n)
 */

import java.util.*;

public class Qanat_WA {
    static double w, h, ah;
    static int n;
    static double[][] memo; // [posición, coste]

    static double rightCost(double pos) {
        double verticalHeight = pos * ah;
        double totalLength = verticalHeight + ah + (1.0 - pos);
        return (totalLength / 2.0) * (totalLength / 2.0)
                - (verticalHeight) * (verticalHeight) / 2.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        w = sc.nextDouble();
        h = sc.nextDouble();
        n = sc.nextInt();

        memo = new double[n + 1][2];

        ah = h / w; // altura ajustada
        // Caso base: ningún pozo
        memo[0][0] = 0.0;
        memo[0][1] = ((ah + 1.0) / 2.0) * ((ah + 1.0) / 2.0);

        for (int shaft = 1; shaft <= n; shaft++) {
            double lo = 0.0, hi = 1.0;
            for (int it = 0; it < 100; it++) {
                double midLo = lo + (hi - lo) / 3.0;
                double midHi = hi - (hi - lo) / 3.0;

                double costLo = rightCost(midLo) + memo[shaft - 1][1] * midLo * midLo;
                double costHi = rightCost(midHi) + memo[shaft - 1][1] * midHi * midHi;

                if (costLo < costHi) {
                    hi = midHi;
                } else {
                    lo = midLo;
                }
            }
            memo[shaft][0] = lo;
            memo[shaft][1] = rightCost(lo) + memo[shaft - 1][1] * lo * lo;
        }

        // coste mínimo
        System.out.printf("%.10f%n", memo[n][1] * w * w);

        // posiciones de los pozos
        double mul = w;
        double[] ans = new double[n];
        for (int i = n; i > 0; i--) {
            mul *= memo[i][0];
            ans[i - 1] = mul;
        }
        for (int i = 0; i < Math.min(n, 10); i++) {
            System.out.printf("%.10f%n", ans[i]);
        }
    }
}


/* Código original en C++

//#pragma GCC optimize("Ofast")
//#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,avx2,fma")
//#pragma GCC optimize("unroll-loops")
#include <bits/stdc++.h>
using namespace std;


typedef long double ld;

ld w, h, ah;
int n;
vector<pair<ld, ld>> memo;  // position of shift (assuming width 1), total cost

ld right_cost(ld pos) {
    ld vertical_height = pos * ah;
    ld total_length = vertical_height + ah + (1.0 - pos);
    return (total_length / 2.0) * (total_length / 2.0) -
            (vertical_height) * (vertical_height) / 2.0;
}
int main() {
    cin >> w >> h >> n;
    memo.assign(n + 1, {0, 0});

    ah = h / w;                                              // adjusted height
    memo[0] = {0, ((ah + 1.0) / 2.0) * ((ah + 1.0) / 2.0)};  // assume no vertical shafts needed

    for (int shaft = 1; shaft <= n; shaft++) {
        ld hi = 1.0, lo = 0.0;
        for (int i = 0; i < 100; i++) {
            ld mid_lo = lo + (hi - lo) / 3.0;
            ld mid_hi = hi - (hi - lo) / 3.0;

            ld mid_lo_cost = right_cost(mid_lo) + memo[shaft - 1].second * mid_lo * mid_lo;
            ld mid_hi_cost = right_cost(mid_hi) + memo[shaft - 1].second * mid_hi * mid_hi;

            if (mid_lo_cost < mid_hi_cost) {
                hi = mid_hi;
            } else {
                lo = mid_lo;
            }
        }
        memo[shaft] = {lo, right_cost(lo) + memo[shaft - 1].second * lo * lo};
    }
    cout << fixed << setprecision(10);
    cout << memo[n].second * w * w << endl;
    ld mul = w;
    vector<ld> ans(n);
    for (int i = n; i > 0; i--) {
        mul *= memo[i].first;
        ans[i - 1] = mul;
    }
    for (int i = 0; i < min(n, 10); i++) {
        cout << ans[i] << endl;
    }

    return 0;
}

 */