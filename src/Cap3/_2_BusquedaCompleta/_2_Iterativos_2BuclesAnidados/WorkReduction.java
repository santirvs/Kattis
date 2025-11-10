package Cap3._2_BusquedaCompleta._2_Iterativos_2BuclesAnidados;

// Para cada agencia, buscar el coste usando la estrategia de fuerza bruta:
//   - Tenemos la tarifa B que reduce la faena a la mitad
//   - Tenemos la tarifa A que reduce la faena en una unidad
// Se busca el menor coste que nos deje la faena pendiente en exactamente target y partimos de una cantidad inicial de faena.
//   - Se usará la tarifa B si:
//     - La mitad de la faena pendiente es mayor o igual que target
//     - El coste de usar la tarifa B es menor que el coste de usar la tarifa A para la reducción de faena estimada
//   - En caso contrario, se usará la tarifa A para reducir la faena en una unidad.
//  El número de agencias no supera los 100
//  La faena pendiente puede llegar a 100_000 y el coste puede ser de 10_000
//  En el peor de los casos, se aplicaría la tarifa B 50_000 veces, (50_000 * 10_000 = 500_000_000) que cabe en un int.

// El tiempo es O(log2(n) + 1) Uso de la tarifa B (log2(n) y O(1) uso de la tarifa A, inmediato.

// v1. TLE en Caso de pruebas #3
// v2 --> Traduccion a C++  --> AC

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class WorkReduction {

    public static class Agencia implements Comparable<Agencia> {
        String nombre;
        int tarifaA; // Coste de la tarifa A
        int tarifaB; // Coste de la tarifa B
        int costeTotal;

        Agencia(String nombre, int tarifaA, int tarifaB) {
            this.nombre = nombre;
            this.tarifaA = tarifaA;
            this.tarifaB = tarifaB;
            this.costeTotal = 0; // Inicialmente el coste total es 0
        }

        @Override
        public int compareTo(Agencia o) {
            if (this.costeTotal != o.costeTotal) {
                return Integer.compare(this.costeTotal, o.costeTotal);
            }
            else {
                return this.nombre.compareTo(o.nombre); // Si los costes son iguales, se ordena por nombre
            }
        }
    }

    // Scanner rápido
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = readByte()) != -1 && c <= ' ');
            if (c == -1) return null;
            do {
                sb.append((char)c);
            } while ((c = readByte()) != -1 && c > ' ');
            return sb.toString();
        }

        String nextLine() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = readByte()) != -1 && c <= '\n');
            if (c == -1) return null;
            do {
                sb.append((char)c);
            } while ((c = readByte()) != -1 && c > '\n');
            return sb.toString();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner scan = new FastScanner();

        int numCasos = scan.nextInt(); // Número de casos

        for (int caso = 1; caso <= numCasos; caso++) {
            int pendiente = scan.nextInt(); // Faena pendiente
            int objetivo = scan.nextInt(); // Faena objetivo
            int numAgencias = scan.nextInt(); // Número de agencias
            scan.nextLine();

            Agencia[] agencias = new Agencia[numAgencias]; // Array para almacenar las agencias
            for (int i = 0; i < numAgencias; i++) {
                // Leer la línea de entrada para cada agencia
                String[] line = scan.nextLine().trim().split(":"); // Dividir la línea por ":"
                String nombre = line[0]; // Nombre de la agencia
                int tarifaA = Integer.parseInt(line[1].split(",")[0]); // Coste de la tarifa A
                int tarifaB = Integer.parseInt(line[1].split(",")[1]); // Coste de la tarifa B
                agencias[i] = new Agencia(nombre, tarifaA, tarifaB); // Crear la agencia
            }

            // Calcular el coste total para cada agencia
            for (Agencia agencia : agencias) {
                int faenaPendiente = pendiente;
                int costeTotal = 0;

                while (faenaPendiente > objetivo) {
                    // Si la mitad de la faena pendiente es mayor o igual que el objetivo
                    if (faenaPendiente / 2 >= objetivo && agencia.tarifaB < agencia.tarifaA * (faenaPendiente - faenaPendiente / 2)) {
                        faenaPendiente /= 2; // Reducir la faena a la mitad
                        costeTotal += agencia.tarifaB; // Añadir el coste de la tarifa B
                    } else {
                        costeTotal += agencia.tarifaA * (faenaPendiente-objetivo); // Añadir el coste de la tarifa A
                        faenaPendiente = objetivo;
                    }
                }

                agencia.costeTotal = costeTotal; // Guardar el coste total para esta agencia
            }

            // Ordenar las agencias por coste total y nombre
            java.util.Arrays.sort(agencias);

            // Imprimir el resultado
            System.out.printf("Case %d\n", caso);
            for (Agencia agencia : agencias) {
                System.out.printf("%s %d\n", agencia.nombre, agencia.costeTotal); // Imprimir el nombre de la agencia y el coste total
            }
        }

    }
}

/* Traducción a C++ del código anterior:

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

struct Agencia {
    string nombre;
    int tarifaA;
    int tarifaB;
    int costeTotal;

    Agencia(const string& n, int a, int b) : nombre(n), tarifaA(a), tarifaB(b), costeTotal(0) {}
};

bool compare(const Agencia& a, const Agencia& b) {
    if (a.costeTotal != b.costeTotal)
        return a.costeTotal < b.costeTotal;
    return a.nombre < b.nombre;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int numCasos;
    cin >> numCasos;

    for (int caso = 1; caso <= numCasos; ++caso) {
        int pendiente, objetivo, numAgencias;
        cin >> pendiente >> objetivo >> numAgencias;
        cin.ignore(); // per llegir línies després d’enter

        vector<Agencia> agencias;

        for (int i = 0; i < numAgencias; ++i) {
            string linea;
            getline(cin, linea);

            size_t sep = linea.find(':');
            string nombre = linea.substr(0, sep);

            size_t coma = linea.find(',', sep + 1);
            int tarifaA = stoi(linea.substr(sep + 1, coma - sep - 1));
            int tarifaB = stoi(linea.substr(coma + 1));

            agencias.emplace_back(nombre, tarifaA, tarifaB);
        }

        for (auto& agencia : agencias) {
            int faena = pendiente;
            int cost = 0;

            while (faena > objetivo) {
                int mitad = faena / 2;
                int ahorro = faena - mitad;
                int costeA = ahorro * agencia.tarifaA;

                if (mitad >= objetivo && agencia.tarifaB < costeA) {
                    faena = mitad;
                    cost += agencia.tarifaB;
                } else {
                    cost += (faena - objetivo) * agencia.tarifaA;
                    faena = objetivo;
                }
            }

            agencia.costeTotal = cost;
        }

        sort(agencias.begin(), agencias.end(), compare);

        cout << "Case " << caso << "\n";
        for (const auto& ag : agencias)
            cout << ag.nombre << " " << ag.costeTotal << "\n";
    }

    return 0;
}

 */