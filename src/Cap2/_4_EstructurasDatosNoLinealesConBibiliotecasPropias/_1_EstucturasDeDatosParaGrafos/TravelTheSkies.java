package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias._1_EstucturasDeDatosParaGrafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// Travel the Skies
// Caso 12 - RTE --> Buscar alguna estructura no inicializada


public class TravelTheSkies {

    public static class Vuelo {
        int origen;
        int destino;
        int capacidad;
    };

    public static class Pair {
        int first;
        int second;

        Pair(int f, int s) {
            first = f;
            second = s;
        }
    };

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int cantidadAeropuertos = scan.nextInt();
        int ventanaDias = scan.nextInt();
        int vuelosEnVentana = scan.nextInt();

        // Número de personas en cada aeropuerto
        ArrayList<Integer> personas = new ArrayList<Integer>(cantidadAeropuertos);
        for(int i = 0; i < cantidadAeropuertos; i++) {
            personas.add(0);
        }

        // Map día -> vuelos
        HashMap<Integer, ArrayList<Vuelo>> vuelos = new HashMap<Integer, ArrayList<Vuelo>>();

        // Map día -> personas que llegan
        HashMap<Integer, ArrayList<Pair>> nuevosPasajeros = new HashMap<Integer, ArrayList<Pair>>();

        // Leer todos los vuelos
        for(int i = 0; i < vuelosEnVentana; i++) {
            Vuelo vuelo = new Vuelo();
            vuelo.origen = scan.nextInt()-1;
            vuelo.destino = scan.nextInt()-1;
            int dia = scan.nextInt()-1;
            vuelo.capacidad = scan.nextInt();
            //Si no existe la lista de vuelos para el día, la crea
            if (!vuelos.containsKey(dia)) {
                vuelos.put(dia, new ArrayList<Vuelo>());
            }
            //Añade el vuelo a la lista de vuelos del día
            vuelos.get(dia).add(vuelo);
        }

        // Leer las llegadas de pasajeros a cada aeropuerto
        for(int i = 0; i < cantidadAeropuertos * ventanaDias; i++) {
            int destino, origen, capacidad;
            origen = scan.nextInt()-1;
            destino = scan.nextInt()-1;
            capacidad = scan.nextInt();
            if (!nuevosPasajeros.containsKey(destino)) {
                nuevosPasajeros.put(destino, new ArrayList<Pair>());
            }
            nuevosPasajeros.get(destino).add(new Pair(origen, capacidad));
        }

        // Simular cada día y ver si funciona
        boolean optimo = true;
        for(int i = 0; i < ventanaDias; i++) {
            // Añadir las nuevas llegadas
            for(Pair j : nuevosPasajeros.get(i)) {
                personas.set(j.first, personas.get(j.first)+j.second);
            }

            // Eliminar las personas que salen en algún vuelo
            for(Vuelo j : vuelos.get(i)) {
                personas.set(j.origen, personas.get(j.origen)-j.capacidad);
                if(personas.get(j.origen) < 0) {
                    optimo = false;
                    break;
                }
            }

            // Si no es óptimo, salir
            if(!optimo) break;

            // Añade las personas que llegan a cada destino
            for(Vuelo j : vuelos.get(i)) {
                personas.set(j.destino, personas.get(j.destino)+j.capacidad);
            }
        }

        // Imprimir si es óptimo o no
        if(optimo) {
            System.out.println("optimal");
        }
        else System.out.println("suboptimal");
    }
}



/*
#include <bits/stdc++.h>

using namespace std;

struct flight {
    int n1;
    int n2;
    int cap;
};

int main() {
    int k, n, m;
    cin >> k >> n >> m;

    // Number of people currently in this airport
    vector<int> people(k, 0);
    // Map of day to flights happening
    map<int, vector<flight>> flights;
    // Map of day to people arriving
    map<int,vector<pair<int,int>>> additional;

    // Read in all of the flights
    for(int i = 0; i < m; i++) {
        int d;
        flight f;
        cin >> f.n1 >> f.n2 >> d >> f.cap;
        f.n1--; f.n2--; d--;
        flights[d].push_back(f);
    }

    // Read in all of the peoples' arrivals
    for(int i = 0; i < k*n; i++) {
        int d, n1, cap;
        cin >> n1 >> d >> cap;
        n1--; d--;
        additional[d].push_back({n1,cap});
    }

    // Simulate each day
    bool works = true;
    for(int i = 0; i < n; i++) {
        // Add new arrivals
        for(auto j : additional[i]) {
            people[j.first] += j.second;
        }

        // Remove any people flying out
        for(auto j : flights[i]) {
            people[j.n1] -= j.cap;
            if(people[j.n1] < 0) {
                works = false;
                break;
            }
        }

        // If it doesn't work, quit early
        if(!works) break;

        // Add people flying in
        for(auto j : flights[i]) {
            people[j.n2] += j.cap;
        }
    }

    // Print answer
    if(works) cout << "optimal" << endl;
    else cout << "suboptimal" << endl;
}
 */