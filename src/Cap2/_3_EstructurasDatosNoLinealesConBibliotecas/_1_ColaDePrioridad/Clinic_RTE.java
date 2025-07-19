package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._1_ColaDePrioridad;

// Usar una cola con prioridad que se debe ir recalculando en base a la fórmula
// Cada vez que se añade un elemento, se recalcula la cola con prioridad
// Avisan que será necesario utilizar un FasIO para la lectura de los datos

// WA en diferentes casos: 7, 9, 10, 11, 19, 21, 22, 23, 24, 25
// Había un error al comparar el nombre (lo comparaba consigo mismo)
// WA en diferentes casos: 21, 22, 23, 24
// Problema con longs en lugar de ints -> RTE en 33 y algunos más
//
// Adapto desde https://github.com/donaldong/kattis/blob/main/solutions/clinic/a.cpp
// weight =  -(severity - t*k)  ???   planteamiento inverso y no recalcular para el tiempo?
// Sigue dando RTE en 33  (la librería no parece la óptima)


import java.io.*;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Clinic_RTE {

    static long K;
    static long tiempo = 0;

    static class FastIO {
        BufferedReader in;
        PrintWriter out;

        FastIO() {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        }

        int nextInt() throws Exception {
            return Integer.parseInt(in.readLine());
        }

        String nextLine() throws Exception {
            return in.readLine();
        }

        String next() throws Exception {
            StringBuilder s = new StringBuilder();
            while (true) {
                int c = in.read();
                if (Character.isWhitespace(c) || c == -1) {
                    break;
                }
                s.append((char) c);
            }
            return s.toString();
        }

        void print(String s) {
            out.print(s);
            out.flush();
        }

        void println(String s) {
            out.println(s);
            out.flush();
        }
    }

    static class Paciente implements Comparable<Paciente> {
        String nombre;
        long llegada ;
        long severidad;

        Paciente(String nombre, long severidad, long llegada) {
            this.nombre = nombre;
            this.severidad = severidad;
            this.llegada = llegada;
        }

        long prioridad() {
            return  severidad + K * (tiempo-llegada);
        }

        @Override
        public int compareTo(Paciente o) {
            if (this.prioridad() == o.prioridad()) {
                return this.nombre.compareTo(o.nombre);
            }
            return (o.prioridad() > this.prioridad()) ? 1 : -1;
        }

        public boolean equals(Object o) {
            Paciente p = (Paciente) o;
            return this.nombre.equals(p.nombre);
        }
    }

    public static void main(String[] args) throws Exception {
        FastIO scan = new FastIO();

        PriorityQueue<Paciente> cola = new PriorityQueue<>();
        Set<String> abandonos = new HashSet<>();
        String[] linea = scan.nextLine().split(" ");
        long N = Long.parseLong(linea[0]);
        K = Long.parseLong(linea[1]);

        for (int i = 0; i < N; i++) {
            String[] datos = scan.nextLine().split(" ");
            int operacion = Integer.parseInt(datos[0]);

            if (operacion == 1) {
                //Llegada de un nuevo paciente
                tiempo = Long.parseLong(datos[1]);
                String nombre = datos[2];
                int severidad = Integer.parseInt(datos[3]);
                cola.add(new Paciente(nombre, severidad, tiempo));
            } else if (operacion == 2) {
                //Atender al paciente más prioritario
                tiempo = Integer.parseInt(datos[1]);
                //Buscamos en la lista el paciente más prioritario que no se haya marchado
                while (!cola.isEmpty() && abandonos.contains(cola.peek().nombre)) {
                    abandonos.remove(cola.poll().nombre);
                    cola.poll();
                }
                if (cola.isEmpty()) {
                    scan.println("doctor takes a break");
                } else {
                    Paciente p = cola.poll();
                    scan.println(p.nombre);
                }
            } else {
                //Añadir en lista de abandonos al paciente que se ha marchado
                String nombre = datos[1];
                abandonos.add(nombre);
            }
        }
    }
}


/**
 * @date        2022-03-28
 * @tags        data structure, implementation
 * @difficulty  1500
 */
/*
#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using Pair = pair<ll,string>;
int main() {
    ios_base::sync_with_stdio(false), cin.tie(NULL); // Fast IO
    int N;
    ll K;
    cin >> N >> K;
    unordered_set<string> S;
    priority_queue<Pair,vector<Pair>,greater<Pair>> pq;

    auto query = [&]() -> string {
        while (!pq.empty()) {
            auto [p, m] = pq.top(); pq.pop();
            if (!S.count(m)) continue;
            return m;
        }
        return "doctor takes a break";
    };

    while (N--) {
        int Q,T;
        cin >> Q >> T;
        switch (Q) {

            case 1: {
                string M;
                ll s;
                cin >> M >> s;
                S.insert(M);
                pq.emplace(-(s-T*K), move(M));
                break;
            }

            case 2: {
                cout << query() << endl;
                break;
            }

            case 3: {
                string M;
                cin >> M;
                S.erase(M);
                break;
            }
        }
    }
    return 0;
}

*/