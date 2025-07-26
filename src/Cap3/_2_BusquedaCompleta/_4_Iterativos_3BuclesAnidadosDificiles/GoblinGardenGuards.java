package Cap3._2_BusquedaCompleta._4_Iterativos_3BuclesAnidadosDificiles;

// Fuerza bruta
// Probar las posiciones alcanzadas por los aspersores en el jardín
// Guardar las posiciones con duendes, teniendo en cuenta que puede haber varios duendes en la misma posición
// Guardar las posiciones de los aspersores y comprobar. Pueden haber varios aspersores en la misma posición,
// por lo que solo se usará un aspersor por posición que será el de mayor alcance.
// Para cada aspersor, se comprueban las posiciones alcanzadas y se eliminan los duendes.
// Al final, se comprueba el número de duendes restantes.

// v1. TLE en el caso #26
// v2. Usar Fast Input  --> TLE en el caso #26
// v3. Probar en C++ --> TLE en el caso #25 !!!
// v4. Eliminar los objetos Posicion y usar coordenadas enteras directamente (100_000 * x + y)  --> TLE en el caso #26
// v5. Cambiar estrategia
//     Almacenamos los duendes en un TreeMap por la coordenada x que mapea un Map de coordenadas y a la cantidad de duendes en esa posición.
//     Usar un submapa navegable para obtener las coordenadas x dentro del rango del aspersor.
//     Verificar las coordenadas y dentro del rango del aspersor y eliminar los duendes alcanzados.
//     TLE en caso #25 !!
// v6. Pruebo la nueva estrategia en C++  --> TLE en caso #25 !!
// v7. Envío solución en C++ original de https://github.com/donaldong/kattis/blob/main/solutions/goblingardenguards/goblingardenguards.cpp



import java.util.*;
import java.io.*;

public class GoblinGardenGuards {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        TreeMap<Integer, Map<Integer, Integer>> duendes = new TreeMap<>();

        // Leer el número de duendes
        int numDuendes = scan.nextInt();

        // Leer posiciones de los duendes
        while (numDuendes-- > 0) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            duendes.computeIfAbsent(x, k -> new HashMap<>());
            duendes.get(x).put(y, duendes.get(x).getOrDefault(y, 0) + 1);
        }

        int numAspersores = scan.nextInt(); // número de aspersores
        while (numAspersores-- > 0) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int r = scan.nextInt();

            // Determinar los límites del rango de aspersión en X
            int minX = x - r;
            int maxX = x + r;

            // Obtener submapa dentro del rango
            NavigableMap<Integer, Map<Integer, Integer>> sub = duendes.subMap(minX, true, maxX, true);
            List<Integer> keysToCheck = new ArrayList<>(sub.keySet());

            // Buscar en el cuadrado de alcance del aspersor
            // segun la formula r*r = dx*dx + dy*dy
            for (int xi : keysToCheck) {
                int dx = xi - x;
                int dx2 = dx * dx;
                int h2 = r * r - dx2;
                if (h2 < 0) continue;

                int h = (int) Math.sqrt(h2);
                int minY = y - h;
                int maxY = y + h;

                Map<Integer, Integer> mapY = duendes.get(xi);
                List<Integer> toDelete = new ArrayList<>();

                // Buscar las coordenadas con duendes dentro del rango
                for (int yi : mapY.keySet()) {
                    if (yi >= minY && yi <= maxY) {
                        toDelete.add(yi);
                    }
                }

                // Eliminar los duendes alcanzados
                for (int yi : toDelete) {
                    mapY.remove(yi);
                }
                if (mapY.isEmpty()) {
                    duendes.remove(xi);
                }
            }
        }

        // Contar duendes restantes
        int res = 0;
        for (Map<Integer, Integer> mapY : duendes.values()) {
            for (int count : mapY.values()) {
                res += count;
            }
        }

        System.out.println(res);
    }
}


/**  Código original en C++

#include <bits/stdc++.h>
using namespace std;

typedef vector<int> vi;

int main() {
    ios::sync_with_stdio(0), cin.tie(0);
    int n, x, y, r, res = 0;
    map<int, multiset<int>> G;
    cin >> n;
    while (n--) {
        cin >> x >> y;
        G[x].insert(y);
    }
    cin >> n;
    while (n--) {
        cin >> x >> y >> r;
        for (auto i = G.lower_bound(x - r); i != G.end();) {
            if (i->first > x + r) break;
            int dx = i->first - x;
            if (dx < 0) dx *= -1;
            int h = sqrt(r * r - dx * dx);
            auto &s = i->second;
            for (auto j = s.lower_bound(y - h); j != s.end();) {
                if (*j > y + h) break;
                j = s.erase(j);
            }
            if (s.empty()) i = G.erase(i);
            else ++i;
        }
    }
    for (auto i = G.begin(); i != G.end(); ++i) {
        res += i->second.size();
#ifdef DEBUG
        for (int y : i->second) printf("p: %d %d\n", i->first, y);
#endif
    }
    printf("%d\n", res);
    return 0;
}

*/