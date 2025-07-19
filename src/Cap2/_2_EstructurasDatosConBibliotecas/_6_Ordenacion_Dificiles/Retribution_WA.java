package Cap2._2_EstructurasDatosConBibliotecas._6_Ordenacion_Dificiles;

import java.util.*;

public class Retribution_WA {

    public static class Posicion {
        int x;
        int y;

        public Posicion(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Distancia implements Comparable<Distancia> {
        int juez;
        int deposito;
        double distancia;

        public Distancia(int juez, int deposito, double distancia) {
            this.juez = juez;
            this.deposito = deposito;
            this.distancia = distancia;
        }

        @Override
        public int compareTo(Distancia o) {
            if (this.distancia == o.distancia) {
                if (this.juez == o.juez) {
                    return this.deposito - o.deposito;
                } else {
                    return this.juez - o.juez;
                }
            } else {
                return (int)(this.distancia - o.distancia);
            }
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numJueces = scan.nextInt();
        int numDepositos = scan.nextInt();
        int numAlmacenes = scan.nextInt();

        //Leer jueces
        Posicion[] jueces = new Posicion[numJueces];
        for (int i=0; i<numJueces; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            jueces[i] = new Posicion(x,y);
        }

        //Leer depositos
        Posicion[] depositos = new Posicion[numDepositos];
        for (int i=0; i<numDepositos; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            depositos[i] = new Posicion(x,y);
        }

        //Leer almacenes
        Posicion[] almacenes = new Posicion[numAlmacenes];
        for (int i=0; i<numAlmacenes; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            almacenes[i] = new Posicion(x,y);
        }

        //Buscar las distancias entre jueces y depositos
        ArrayList<Distancia> distancias = new ArrayList<>();
        for (int i=0; i<numJueces; i++) {
            for (int j=0; j<numDepositos; j++) {
                double distancia = Math.sqrt(Math.pow(jueces[i].x-depositos[j].x,2) + Math.pow(jueces[i].y-depositos[j].y,2));
                distancias.add(new Distancia(i,j,distancia));
            }
        }
        //Ordenar las distancias
        Collections.sort(distancias);

        Double[] distanciasAlmacenesAsignados = new Double[numJueces];
        Arrays.fill(distanciasAlmacenesAsignados, -1.0);

        //Asignar los almacenes a los jueces
        for (Distancia d : distancias) {
            if (distanciasAlmacenesAsignados[d.juez] == -1.0) {
                distanciasAlmacenesAsignados[d.juez] = (double)d.distancia;
            }
        }

        //Buscar las distancias entre jueces y depositos
        distancias = new ArrayList<>();
        for (int i=0; i<numJueces; i++) {
            for (int j=0; j<numAlmacenes; j++) {
                int distancia = Math.abs(jueces[i].x-almacenes[j].x) + Math.abs(jueces[i].y-almacenes[j].y);
                distancias.add(new Distancia(i,j,distancia));
            }
        }
        //Ordenar las distancias
        Collections.sort(distancias);

        Double[] distanciasDepositosAsignados = new Double[numJueces];
        Arrays.fill(distanciasDepositosAsignados, -1.0);

        //Asignar los depositos a los jueces
        for (Distancia d : distancias) {
            if (distanciasDepositosAsignados[d.juez] == -1.0) {
                distanciasDepositosAsignados[d.juez] = (double)d.distancia;
            }
        }

        //Calcular la distancia total
        double distanciaTotal = 0;
        for (int i=0; i<numJueces; i++) {
            distanciaTotal += distanciasAlmacenesAsignados[i] + distanciasDepositosAsignados[i];
        }

        //Mostrar el resultado
        System.out.println(distanciaTotal);

    }


}


/*
// FROM:https://github.com/BrandonTang89/Competitive_Programming_4_Solutions/blob/main/Chapter_2_Data_Structures/Linear_DS_with_Built-in_Libraries/kattis_retribution.cpp



///**Kattis - retribution
// * Actually simple, idk why it is 6.0 difficulty. Clearly the problems for the feather and tar are
// * identical and independent. We would like a sorted(map(dist, cartesianProduct(judges, tar))) with
// * additional information about which judge and tar is in each tuple. Then just go through the list
// * and greedily take the smallest distance that has not been taken yet, use a direct address table
// * to keep track of what judges and what tars have been taken. Do the same for the feathers.
// * Time: O(nm' log nm'), Space: O(nm') where m' = m + p

#pragma GCC optimize("Ofast")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,avx2,fma")
#pragma GCC optimize("unroll-loops")
#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef vector<int> vi;
#define fast_cin()                    \
ios_base::sync_with_stdio(false); \
        cin.tie(NULL);                    \
        cout.tie(NULL);

        int n, m, p;
vector<tuple<double, int, int>> v;  // dist, judge, loc
        vector<tuple<int, int>> jud, tar, fea;
inline double dist(int x1, int y1, int x2, int y2)
{
    return sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
}
        vector<int> jtaken, ttaken, ftaken;
int main()
{
    fast_cin();
    cin >> n >> m >> p;
    jud.resize(n);
    tar.resize(m);
    fea.resize(p);
    for (int i = 0; i < n; i++) {
        int x, y;
        cin >> x >> y;
        jud[i] = {x, y};
    }
    for (int i = 0; i < m; i++) {
        int x, y;
        cin >> x >> y;
        tar[i] = {x, y};
    }
    for (int i = 0; i < p; i++) {
        int x, y;
        cin >> x >> y;
        fea[i] = {x, y};
    }
    jtaken.assign(n, 0);
    ttaken.assign(m, 0);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            v.emplace_back(dist(get<0>(jud[i]), get<1>(jud[i]), get<0>(tar[j]), get<1>(tar[j])), i,
                    j);
        }
    }
    sort(v.begin(), v.end());
    double ans = 0;
    for (auto [d, i, j] : v) {
    if (!jtaken[i] && !ttaken[j]) {
        ans += d;
        jtaken[i] = 1;
        ttaken[j] = 1;
    }
}

    jtaken.assign(n, 0);
    ftaken.assign(p, 0);
    v.clear();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < p; j++) {
            v.emplace_back(dist(get<0>(jud[i]), get<1>(jud[i]), get<0>(fea[j]), get<1>(fea[j])), i,
                    j);
        }
    }
    sort(v.begin(), v.end());
    for (auto [d, i, j] : v) {
    if (!jtaken[i] && !ftaken[j]) {
        ans += d;
        jtaken[i] = 1;
        ftaken[j] = 1;
    }
}

    cout << fixed << setprecision(10) << ans << endl;

    return 0;
}
 */