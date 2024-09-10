package Cap2._1_EstructurasDatosConBibliotecas._12_ListaColaDeque;

// Parece ser que con una lista puede ser suficiente

// Casos #14 y #15: TLE --> Paso a usar FastIO, sigue el TLE
//            --> Cambio List por LinkedList
// Miro otras soluciones en otros lenguajes y veo que tienen un planteamiento similar.
// De nuevo las librerías de java parece que no son lo suficientemente rápidas


import java.io.*;
import java.util.ArrayList;

public class Sim {

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

    public static void main(String[] args) throws Exception {
        FastIO scan = new FastIO();

        int numCasos = scan.nextInt();
        for (int i=0; i<numCasos; i++) {
            char[] operaciones = scan.nextLine().toCharArray();

            ArrayList<Character> lista = new ArrayList<>();
            int pos = 0;
            for (char c : operaciones) {
                if (c == '<') {
                    //Backspace
                    if (pos > 0) {
                        lista.remove(pos-1);
                        pos--;
                    }
                }
                else if (c == ']') {
                    //Final
                    pos=lista.size();
                }
                else if (c == '[') {
                    //Inicio
                    pos = 0;
                }
                else {
                    //Insertar
                    lista.add(pos, c);
                    pos++;
                }
            }

            //Mostrar el resultado
            for (char c : lista) {
                System.out.print(c);
            }
            System.out.println();

        }

    }
}


/*

/* Kattis - Sim
This seems like an introductory question to lists, not that lists are often used in ICPC style contests anyway
Just follow the instructions and use some common sense.
    Also beware of invalid pointers for when u backspace at the front of the list.
    Also remember to clear list between testcases

Time: O(length of string * T), Mem: O(length of string)
*/
/*

//  https://github.com/BrandonTang89/Competitive_Programming_4_Solutions/blob/main/Chapter_2_Data_Structures/Linear_DS_with_Built-in_Libraries/kattis_sim.cpp


#include <bits/stdc++.h>
using namespace std;

int T;
list<char> l;
string line;
int main(){
    cin >> T;
    cin.ignore ( std::numeric_limits<std::streamsize>::max(), '\n' ); // clear the \n from the input buffer before using getline
    for (int tc=0;tc<T;tc++){
        getline(cin,line);

        list<char>::iterator it = l.begin();
        for (int p=0;p<line.length();p++){
            //cout << p << endl;
            if (line[p] == ']'){
                it = l.end();
            }
            else if (line[p] == '['){
                it = l.begin();
            }
            else if (line[p] == '<'){
                list<char>::iterator temp = it;
                temp--;
                if (temp == --l.begin())continue;
                l.erase(temp);
            }
            else{
                l.insert(it, line[p]);
            }
            //for(auto i: l){cout << i;}cout << endl;
        }
        for(auto i: l){cout << i;}cout << endl;
        l.clear();

    }

    return 0;
}

 */