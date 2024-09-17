package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._1_ColaDePrioridad;

// Usar una cola con prioridad para recorrer el patrón de malabarismo
// Cada mano tiene una cola de instantes de tiempo en los que se lanza la pelota
// En cada instante de tiempo, sólo se puede lanzar una pelota con la misma mano. Si cae una segunda pelota
// en el mismo instante de tiempo y en la misma mano, ese patrón no es válido
// El patrón debe repetirse en un ciclo de duración mcm(suma lanzamientos_pares, suma lanzamientos_impares)

// Caso #2 --> WA --> Adapto la solución de https://github.com/BrandonTang89/Competitive_Programming_4_Solutions/blob/main/Chapter_2_Data_Structures/Non-Linear_DS_with_Built-in_Libraries/kattis_jugglingpatterns.cpp
//                --> Interesante, porque reduce el problema a la mínima expresión
//                --> Se olvida del tratamiento de las dos manos, y se centra en el patrón de lanzamientos, con una única cola con prioridad
//                --> Si se lanza más de una pelota en un instante, el patrón no es válido
//                --> Si no toca lanzar una pelota en un instante, no puede haber una pelota para lanzar
//                --> Se recorre el patrón 100 veces, y si no se ha demostrado lo contrario, el patrón es válido
//                --> Simplemente genial. AC!!!

import java.util.PriorityQueue;
import java.util.Scanner;

public class JugglingPatterns {

     public static void main(String[] args) throws Exception {
         Scanner scan = new Scanner(System.in);


         while (scan.hasNext()) {
             //Cola de prioridad para almacenar los instantes de tiempo en los que se lanza la pelota
             PriorityQueue<Integer> pq = new PriorityQueue<>();
             //Lectura del patron de malabarismo
             String patron = scan.nextLine();

             //Suma los digitos del patron
             int tamanyoPatron = patron.length();
             int total = 0;
             for (int i = 0; i < tamanyoPatron; i++) {
                 total += patron.charAt(i) - '0';
             }
             //Si la división no es exacta, el patrón no es válido
             if (total % tamanyoPatron != 0) {
                 System.out.println(patron + ": invalid # of balls");
                 continue;
             }

             //Calcula el número de bolas
             int num_balls = total / tamanyoPatron;
             //Mientras no se demuestre lo contrario, el patrón es válido
             boolean valido = true;

             //Recorre el patrón 100 veces  (no se sabe como probar que con 100 es suficiente, pero parece razonable)
             for (int indice = 0; indice < 100 * tamanyoPatron; indice++) {
                 int counter = 0;
                 if (patron.charAt(indice % tamanyoPatron) != '0') {
                     //Si no es un cero, se lanzan tantas bolas como caigan en ese instante
                     while (pq.size() > 0 && pq.peek() == indice) {
                         pq.poll();
                         counter++;
                     }
                     //Pero si se ha lanzado más de una, el patrón no es válido
                     if (counter > 1) {
                         valido = false;
                         break;
                     }
                     //Se añade el instante de tiempo en el que se lanzará la pelota
                     pq.add(indice + patron.charAt(indice % tamanyoPatron) - '0');
                 } else {
                     //Si no toca lanzar, no puede ser que haya una pelota para lanzar en ese instante
                     if (pq.size() > 0 && pq.peek() == indice) {
                         valido = false;
                         break;
                     }
                 }
             }

             if (valido) {
                    System.out.println(patron + ": valid with " + num_balls + " balls");
             } else {
                    System.out.println(patron + ": invalid pattern");
             }
         }


    }
}



// From: https://github.com/BrandonTang89/Competitive_Programming_4_Solutions/blob/main/Chapter_2_Data_Structures/Non-Linear_DS_with_Built-in_Libraries/kattis_jugglingpatterns.cpp
/*Kattis - jugglingpatterns
 * Very confusing problem statement. We need to prune useless information like the stuff about
 * hands. Essentially we should go beat by beat and check if 2 balls are falling at the same time or
 * not. We should also check that if we don't throw a ball, we don't catch a ball at the beat since
 * "If a ball is caught on a beat, it should be thrown on the same beat."
 *
 * Note that an issue is regarding how many cycles to run the checks for. I just guessed that 100*n
 * should be enough... I have no proof for it tho.
 *
 * Time: O(100 n log 9), Space: O(9)
 */
/*
#pragma GCC optimize("Ofast")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,avx2,fma")
#pragma GCC optimize("unroll-loops")
#include <bits/stdc++.h>
using namespace std;

priority_queue<int, vector<int>, greater<int>> pq;
string p;
int main() {
    while (cin >> p) {
        while (!pq.empty()) pq.pop();
        int n = p.size();
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += p[i] - '0';
        }
        if (total % n != 0) {
            cout << p << ": invalid # of balls" << endl;
            continue;
        }

        int num_balls = total / n;
        bool valid = true;

        for (int i = 0; i < 100 * n; i++) {
            int counter = 0;
            if (p[i % n] != '0') {
                while (pq.size() > 0 && pq.top() == i) {
                    pq.pop();
                    counter++;
                }
                if (counter > 1) {
                    valid = false;
                    break;
                }
                pq.push(i + p[i % n] - '0');
            } else {
                if (pq.size() > 0 && pq.top() == i) { // check if we catch a ball on the beat
                    valid = false;
                    break;
                }
            }
        }

        if (valid) {
            cout << p << ": valid with " << num_balls << " balls" << endl;
        } else {
            cout << p << ": invalid pattern" << endl;
        }
    }

    return 0;
}
*/