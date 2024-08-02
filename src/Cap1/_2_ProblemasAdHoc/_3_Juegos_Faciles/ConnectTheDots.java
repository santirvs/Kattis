package Cap1._2_ProblemasAdHoc._3_Juegos_Faciles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class ConnectTheDots {

    public static class Punto implements Comparable<Punto> {
        @Override
        public int compareTo(Punto o) {
            return this.c - o.c;
        }

        int x;
        int y;
        char c;

        public Punto(int x, int y, char c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         boolean primero = true;

         //Leer las imágenes
         while (scan.hasNext()) {
             //Imprimir línia extra entre casos
             if (primero) {
                 primero = false;
             } else {
                 System.out.println();
             }

             String linea;
             ArrayList<Punto> puntos = new ArrayList<Punto>();
             ArrayList<String> tablero = new ArrayList<String>();
             int fila = 0;

             while (scan.hasNext() && !(linea = scan.nextLine()).isEmpty()){
                 tablero.add(linea);
                 //Extraer las posiciones de la linea
                 for (char c : linea.toCharArray()) {
                     if (c != '.') {
                         puntos.add(new Punto(linea.indexOf(c), fila, c));
                     }
                 }
                 fila++;
             }

             //Ordenar los puntos
             Collections.sort(puntos);

             //Construir el tablero
             char[][] tableroFinal = new char[tablero.size()][tablero.get(0).length()];
             for (int i = 0; i < tablero.size(); i++) {
                tableroFinal[i] = tablero.get(i).toCharArray();
             }
             //Recorrer los puntos
             Punto puntoAnterior = null;
             for (Punto p : puntos) {
                if (puntoAnterior != null) {
                    //Trazar una línea desde puntoAnterior a p
                    if (p.x == puntoAnterior.x) {
                        //Vertical
                        for (int i = Math.min(p.y, puntoAnterior.y); i <= Math.max(p.y, puntoAnterior.y); i++) {
                            char caracter ;
                            if (tableroFinal[i][p.x] == '-'  ) {
                                caracter = '+';
                            } else if (tableroFinal[i][p.x] == '|' || tableroFinal[i][p.x] == '.') {
                                caracter = '|';
                            } else if (tableroFinal[i][p.x] == '+') {
                                caracter = '+';
                            } else {
                                //Respetar el caracter existente
                                caracter = tableroFinal[i][p.x];
                            }
                            tableroFinal[i][p.x] = caracter;
                        }
                    } else if (p.y == puntoAnterior.y) {
                        //Horizontal
                        for (int i = Math.min(p.x, puntoAnterior.x); i <= Math.max(p.x, puntoAnterior.x); i++) {
                            char caracter;
                            if (tableroFinal[p.y][i] == '-' || tableroFinal[p.y][i] == '.') {
                                caracter = '-';
                            } else if (tableroFinal[p.y][i] == '|') {
                                caracter = '+';
                            } else if (tableroFinal[p.y][i] == '+') {
                                caracter = '+';
                            } else {
                                //Respetar el caracter existente
                                caracter = tableroFinal[p.y][i];
                            }
                            tableroFinal[p.y][i] = caracter;
                        }
                    }

                }

                puntoAnterior = p;
             }

             //Imprimir tablero final
             for (int i = 0; i < tableroFinal.length; i++) {
                 System.out.println(tableroFinal[i]);
             }

         }
     }


}

/*
#include <iostream>
#include <string>
#include <vector>

using namespace std;

void process(vector<string>& v) {
    vector<pair<int, int>> locations(62);

    int size = 0;
    for(int i = 0; i < v.size(); i++) {
        for(int j = 0; j < v[i].size(); j++) {
            if(isdigit(v[i][j])) {
                size++;
                locations[v[i][j]-'0'] = {i,j};
            }
            if(isalpha(v[i][j])) {
                size++;
                if(islower(v[i][j])) {
                    locations[v[i][j]-'a'+10] = {i,j};
                }
                else {
                    locations[v[i][j]-'A'+36] = {i,j};
                }
            }
        }
    }

    for(int i = 1; i < size; i++) {
        pair<int, int> p1 = locations[i-1];
        pair<int, int> p2 = locations[i];

        // HORIZONTAL
        if(p1.first == p2.first) {
            int j = p1.first;

            // BACKWARD
            if(p1.second > p2.second) {
                for(int i = p1.second-1; i > p2.second; i--) {
                    if(v[j][i] == '|') {
                        v[j][i] = '+';
                    }
                    if(v[j][i] == '.') {
                        v[j][i] = '-';
                    }
                }
            }

            // FOREWARD
            else {
                for(int i = p1.second+1; i < p2.second; i++) {
                    if(v[j][i] == '|') {
                        v[j][i] = '+';
                    }
                    if(v[j][i] == '.') {
                        v[j][i] = '-';
                    }
                }
            }
        }

        // VERTICAL
        else {
            int j = p1.second;
            // UP
            if(p1.first > p2.first) {
                for(int i = p1.first-1; i > p2.first; i--) {
                    if(v[i][j] == '-') {
                        v[i][j] = '+';
                    }
                    if(v[i][j] == '.') {
                        v[i][j] = '|';
                    }
                }
            }

            // DOWN
            else {
                for(int i = p1.first+1; i < p2.first; i++) {
                    if(v[i][j] == '-') {
                        v[i][j] = '+';
                    }
                    if(v[i][j] == '.') {
                        v[i][j] = '|';
                    }
                }
            }
        }
    }

    // Print array
    for(auto s : v) {
        cout << s << endl;
    }

}

int main() {
    vector<string> v;
    string s;
    while(getline(cin, s)) {
        if(s == "") {
            process(v);
            v.clear();
            cout << endl;
        }
        else {
            v.push_back(s);
        }
    }
    process(v);
}
 */


