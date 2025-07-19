package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._8_BST_Equilibrado_Map;

import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

// TestCase #12: TLE --> Se cambia el Set por un TreeSet --> AC hasta el 17 -> TLE
//  Ha sido necesario cambiar el instante de eliminación de un gato de la cola, antes de cambiar la prioridad
//  de un gato, para que el comparador lo encuentre en la cola.
// TestCase#17 --> Adaptando desde C++ https://github.com/versenyi98/kattis-solutions/blob/main/solutions/doctorkattis/main.cpp

public class DoctorKattis_2 {

    static class Pair {
        int primero;
        int segundo;

        public Pair(int primero, int segundo) {
            this.primero = primero;
            this.segundo = segundo;
        }
    }

    static class Gato {
        String nombre;
        int nivel;
        int llegada;

        public Gato(String nombre, int nivel, int llegada) {
            this.nombre = nombre;
            this.nivel = nivel;
            this.llegada = llegada;
        }

    }

    public static class ComparadorGato implements Comparator<Gato> {
        @Override
        public int compare(Gato a1, Gato a2) {
            int result = a2.nivel  - a1.nivel;
            if (result == 0)
                result = a1.llegada - a2.llegada;
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        //Scanner scan = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int numEventos = Integer.parseInt(in.readLine());

        TreeSet<Gato> colaGatos = new TreeSet<>(new ComparadorGato());
        Map<String,Pair> mapaGatos = new HashMap<>();


        int llegada = 0;
        for (int i = 0; i < numEventos; i++) {
            String[] evento = in.readLine().split(" ");
            switch (evento[0]) {
                case "0": {  //arrival
                        Gato d = new Gato(evento[1], Integer.parseInt(evento[2]), llegada);
                        colaGatos.add(d);
                        mapaGatos.put(evento[1], new Pair(llegada, Integer.parseInt(evento[2])));
                        llegada++;
                    }
                    break;
                case "1": { // Update infection level
                        String name = evento[1];
                        int infection = Integer.parseInt(evento[2]);
                        Gato d = new Gato(name, mapaGatos.get(name).segundo, mapaGatos.get(name).primero);
                        //Sacar al gato de la cola.
                        //Hay que sacarlo antes de actualizar el nivel para que el comparador lo encuentre
                        colaGatos.remove(d);
                        d.nivel += Integer.parseInt(evento[2]);
                        //Volver a meter el gato una vez incrementado el nivel
                        colaGatos.add(d);
                        mapaGatos.get(name).segundo = d.nivel;
                    }
                    break;
                case "2": { // Treated
                        Pair p = mapaGatos.remove(evento[1]);
                        colaGatos.remove(new Gato(evento[1], p.segundo, p.primero));
                    }
                    break;


                case "3": {// Query
                        if (colaGatos.isEmpty())
                            out.println("The clinic is empty");
                        else {
                            Gato primerGato = colaGatos.first();
                            out.println(primerGato.nombre);
                        }
                    }
                    break;
            }

        }

        out.flush();
        out.close();
        in.close();


    }
}



/*

//From https://github.com/versenyi98/kattis-solutions/blob/main/solutions/doctorkattis/main.cpp

#include <bits/stdc++.h>

using namespace std;

int total_cats = 0;

struct cat {

	int arrived;
	int infection;
	string name;

	bool operator< (const cat& d) const {
		if (infection != d.infection) return infection > d.infection;
		return arrived < d.arrived;
	}
};

int main() {

	std::ios_base::sync_with_stdio(false);

	int n;
	cin >> n;

	set<cat> cats;
	map<string, pair<int, int>> old_value;

	while (n--) {
		int operation;
		cin >> operation;

		if (operation == 0) {
			cat d;
			string name;
			int infection;
			cin >> name >> infection;

			d.arrived = total_cats++;
			d.infection = infection;
			d.name = name;

			cats.insert(d);
			old_value[name] = {total_cats - 1, infection};

		} else if (operation == 1) {
			string name;
			int infection;
			cin >> name >> infection;

			cat d;
			d.name = name;
			d.infection = old_value[name].second;
			d.arrived = old_value[name].first;

			auto it = cats.find(d);
			auto old = *it;
			cats.erase(it);
			old.infection += infection;
			cats.insert(old);

			old_value[name].second = old.infection;
		} else if (operation == 2) {
			string name;
			cin >> name;

			cat d;
			d.name = name;
			d.arrived = old_value[name].first;
			d.infection = old_value[name].second;

			cats.erase(cats.find(d));
		} else {
			if (cats.empty()) {
				cout << "The clinic is empty" << endl;
			} else {
				cout << (*cats.begin()).name << endl;
			}
		}
	}

	return 0;
}

 */