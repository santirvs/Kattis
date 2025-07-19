package Cap2._2_EstructurasDatosConBibliotecas._12_ListaColaDeque;

// Se requieren dos listas, una para cada orilla del rio

// Caso #2: WA --> La salida debe mostrarse en el mismo orden que se indican los coches en la llegada.
//             --> Como llegan en orillas diferentes es posible que no se carguen en el mismo orden
//             --> Sigue dando WA
//             --> Adopto solución de https://github.com/donaldong/kattis/blob/main/solutions/ferryloading3/ferryloading3.cpp

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class FerryLoadingIII {

    public static final int ORILLA_IZQUIERDA = 0;
    public static final int ORILLA_DERECHA = 1;


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

        void print(int i) {
            this.print("" + i);
        }

        void println(String s) {
            out.println(s);
            out.flush();
        }

        void println(int i) {
            this.println("" + i);
        }

        void println() {
            this.println("");
        }
    }

    public static class Coche implements Comparable<Coche> {
        int llegada;
        int cruzado;
        int id;

        Coche(int llegada, int id) {
            this.llegada = llegada;
            this.id = id;
        }

        @Override
        public int compareTo(Coche o) {
            return this.id - o.id;
        }
    }

    public static class Tuple implements Comparable<Tuple> {
        int a, b;

        Tuple(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Tuple o) {
            return this.a - o.a;
        }
    }

    public static void main(String[] args) throws Exception {
        FastIO io = new FastIO();

        //Lectura de datos
        int numCasos, capacidadFerry, tiempoViaje, numCoches;
        numCasos = io.nextInt();

        while (numCasos>0) {
            numCasos--;
            //Lectura de datos
            String linea = io.nextLine();
            String[] partes = linea.split(" ");
            capacidadFerry = Integer.parseInt(partes[0]);
            tiempoViaje = Integer.parseInt(partes[1]);
            numCoches = Integer.parseInt(partes[2]);

            //Definir variables para tratar el caso
            int tiempo = 0, instanteLlegada, orilla = ORILLA_IZQUIERDA;
            String orillaCoche;
            LinkedList<Integer>[] Q = new LinkedList[2];
            for (int i=0; i<2; i++) Q[i] = new LinkedList<>();
            LinkedList<Integer>[] ID = new LinkedList[2];
            for (int i=0; i<2; i++) ID[i] = new LinkedList<>();

            //Lectura de los coches. Se guardan en las listas de cada orilla, tanto el instante de llegada como el ID
            for (int i = 0; i < numCoches; ++i) {
                linea = io.nextLine();
                partes = linea.split(" ");
                instanteLlegada = Integer.parseInt(partes[0]);
                orillaCoche = partes[1];
                int orillaLlegada = orillaCoche.charAt(0) == 'r' ? ORILLA_DERECHA : ORILLA_IZQUIERDA;
                Q[orillaLlegada].addLast(instanteLlegada);
                ID[orillaLlegada].addLast(i);
            }

            //Los resultados los guardaré en un array de Tupla <ID, instanteCruzado>
            ArrayList <Tuple> res = new ArrayList<>();

            while (!Q[ORILLA_DERECHA].isEmpty() || !Q[ORILLA_IZQUIERDA].isEmpty()) {
                int cantidadCochesCargados = 0;
                while (!Q[orilla].isEmpty() && Q[orilla].peek() <= tiempo && cantidadCochesCargados < capacidadFerry) {
                    Tuple tupla = new Tuple(ID[orilla].peek(), tiempo + tiempoViaje);
                    res.add(tupla);
                    Q[orilla].pop();
                    ID[orilla].pop();
                    ++cantidadCochesCargados;
                }
                int otraOrilla = orilla== ORILLA_DERECHA ? ORILLA_IZQUIERDA : ORILLA_DERECHA;
                if (cantidadCochesCargados!=0) {
                    orilla = otraOrilla;
                    tiempo += tiempoViaje;
                }
                else if (!Q[otraOrilla].isEmpty() && Q[otraOrilla].peek() <= tiempo) { orilla = otraOrilla; tiempo += tiempoViaje;}
                else if (!Q[otraOrilla].isEmpty() && !Q[orilla].isEmpty() && Q[otraOrilla].peek() < Q[orilla].peek()) { tiempo = Q[otraOrilla].peek() + tiempoViaje; orilla = otraOrilla; }
                else if (!Q[orilla].isEmpty()) tiempo = Q[orilla].peek();
                else { tiempo = Q[otraOrilla].peek() + tiempoViaje; orilla = otraOrilla; }
            }

            //Mostrar el resultado ordenado por ID
            Collections.sort(res);
            for (Tuple c : res) {
                io.println(c.b);
            }
            if (numCasos>0) io.println();
        }

    }
}

/*

#include <bits/stdc++.h>
using namespace std;

int main() {
  ios::sync_with_stdio(0), cin.tie(0);
  int T, n, t, m;
  cin >> T;
  while (T--) {
    cin >> n >> t >> m;
    int cur = 0, a, s = 0;
    string S;
    queue<int> Q[2], ID[2];
    for (int i = 0; i < m; ++i) {
      cin >> a >> S;
      int j = S[0] == 'r';
      Q[j].push(a), ID[j].push(i);
    }
    vector<tuple<int, int>> res;
    res.reserve(m);
    while (!Q[0].empty() || !Q[1].empty()) {
      int k = 0;
      while (!Q[s].empty() && Q[s].front() <= cur && k < n) {
        res.emplace_back(ID[s].front(), cur + t);
        Q[s].pop(), ID[s].pop(), ++k;
      }
      if (k) s = !s, cur += t;
      else if (!Q[!s].empty() && Q[!s].front() <= cur) s = !s, cur += t;
      else if (!Q[!s].empty() && !Q[s].empty() && Q[!s].front() < Q[s].front()) cur = Q[!s].front() + t, s = !s;
      else if (!Q[s].empty()) cur = Q[s].front();
      else cur = Q[!s].front() + t, s = !s;
    }
    sort(res.begin(), res.end());
    for (auto &r : res) printf("%d\n", get<1>(r));
    printf("\n");
  }
  return 0;
}
 */