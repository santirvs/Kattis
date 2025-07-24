package Cap3._2_BusquedaCompleta._2_Iterativos_2BuclesAnidados;

// Mirar las distancias entre los puntos de una regla de Golomb
// Calcular todas las combinaciones posibles de puntos (doble bucle anidado)
// Para cada distancia posible añadirla a una lista de soluciones (+1)
// Finalmente, recorrer la lista de soluciones:
// Todas las distancias son alcanzables una única vez --> perfect
// Alguna distancia se alcanza más de una vez --> not a ruler
// Alguna distancia no se alcanza --> missing y listar todas las distancias que no se alcanzan

//v1 - TLE en Caso de Prueba 6
//     La entrada consiste en una línea de enteros, como máximo 25
//     Eso significa que un bucle anidado de 25x24 = 600 iteraciones
//     El número más grande es 2000, por lo que el recorrido final también será de un máximo de 2000 iteraciones
//     para comprobar las distancias alcanzadas y clasificar la regla de Golomb
//v2 - Pruebo a optimizar el código para dejar de verificar si detecto que no es una regla de Golomb --> TLE
//v3 - No es necesario ordenar la lista de números, ya que no afecta al resultado final --> TLE
//v4 - Paso a C++ -> AC!


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GolombRulers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            //Leer la lista de números
            List<Integer> lista = new ArrayList<>();
            String[] linea = scan.nextLine().split(" ");
            int max = 0; // Variable para guardar el número más grande
            for (String numero : linea) {
                int num = Integer.parseInt(numero);
                lista.add(num);
                max = Math.max(max, num); // Guardar el número más grande
            }
            //Ordenar la lista --> no es necesario
            // lista.sort(Integer::compareTo);

            //Calcular las distancias
            boolean esRegla = true;
            int[] distancias = new int[max];

            for (int i = 0; i < lista.size() && esRegla; i++) {
                for (int j = i + 1; j < lista.size() && esRegla; j++) {
                    int distancia = Math.abs(lista.get(i) - lista.get(j));
                    distancias[distancia - 1]++;
                    if (distancias[distancia - 1] > 1) {
                        esRegla = false; // Si alguna distancia se repite, no es una regla de Golomb. Abortar
                    }
                }
            }

            //Comprobar las distancias
            boolean missing = false;
            List<Integer> missingDistances = new ArrayList<>();
            //Si es una regla de Golomb, comprobar si hay distancias que faltan
            if (esRegla) {
                for (int i = 0; i < distancias.length; i++) {
                    if (distancias[i] == 0) {
                        missing = true;
                        missingDistances.add(i + 1);
                    }
                }
            }

            //Imprimir el resultado
            if (esRegla && !missing) {
                System.out.println("perfect");
            } else if (esRegla && missing) {
                System.out.print("missing ");
                for (int i = 0; i < missingDistances.size(); i++) {
                    System.out.print(missingDistances.get(i));
                    if (i < missingDistances.size() - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            } else {
                System.out.println("not a ruler");
            }

        }

    }
}


// Versión en C++
/*
#include <iostream>
#include <vector>
#include <string>
#include <sstream>
#include <algorithm>
#include <cmath>
#include <set>

using namespace std;

int main() {
    string line;

    while (getline(cin, line)) {
        stringstream ss(line);
        vector<int> lista;
        int num, maxNum = 0;

        // Llegim i guardem els nombres
        while (ss >> num) {
            lista.push_back(num);
            maxNum = max(maxNum, num);
        }

        bool esRegla = true;
        vector<int> distancias(maxNum, 0);  // distàncies de 1 a maxNum - 1

        // Calcular les distàncies i veure si alguna es repeteix
        for (size_t i = 0; i < lista.size() && esRegla; ++i) {
            for (size_t j = i + 1; j < lista.size() && esRegla; ++j) {
                int distancia = abs(lista[i] - lista[j]);
                if (distancia == 0) {
                    esRegla = false; // mateixa posició, no vàlid
                    break;
                }
                distancias[distancia - 1]++;
                if (distancias[distancia - 1] > 1) {
                    esRegla = false;
                    break;
                }
            }
        }

        // Comprovar si falten distàncies
        bool missing = false;
        vector<int> missingDistances;

        if (esRegla) {
            for (size_t i = 0; i < distancias.size(); ++i) {
                if (distancias[i] == 0) {
                    missing = true;
                    missingDistances.push_back(i + 1);
                }
            }
        }

        // Imprimir resultat
        if (esRegla && !missing) {
            cout << "perfect" << endl;
        } else if (esRegla && missing) {
            cout << "missing ";
            for (size_t i = 0; i < missingDistances.size(); ++i) {
                cout << missingDistances[i];
                if (i < missingDistances.size() - 1) cout << " ";
            }
            cout << endl;
        } else {
            cout << "not a ruler" << endl;
        }
    }

    return 0;
}

 */