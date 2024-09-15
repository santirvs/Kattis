package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._1_ColaDePrioridad;

// Poco que ver con un cola de prioridad, más que para ver como funciona un binary heap
// Además se puede ver una analogía con la numeración binaria
// N dígitos  --> N+1 bits todos activados a 1
// L --> ponemos a 0 el bit de la altura de la hoja
// R --> ponemos a 0 el bit de la derecha de la altura de la hora

// Caso #12: WA -->
//             -->

//Nuevo enfoque para la solución: buscamos el valor máximo
//Cada nivel, se multiplica por 2 y si es R, además se le suma 1
//Al final, el valor del nodo es el máximo menos el valor actual

// Caso #12: WA --> No veo la diferencia entre el código de https://github.com/mpfeifer1/Kattis/blob/master/numbertree.cpp
//              --> y el mío (mira que es bien sencillo... )
//              --> Cambio el tipo de dato de maxi de long -> AC

import java.util.Scanner;

public class NumbersOnATree_v2 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        //int numNiveles = Integer.parseInt(partes[0]);
        int numNiveles = scan.nextInt();

        //Procesamiento
        long maxi = (long)Math.pow (2, numNiveles + 1);

        char[] camino = scan.nextLine().trim().toCharArray();
        int pos = 1;
        for(int i = 0; i < camino.length; i++) {
            char c = camino[i];
            pos *= 2;
            if (c == 'R') pos++;
        }

        //Salida
        System.out.println((maxi-pos));

    }
}

/*
#include <iostream>
#include <string>
#include <cmath>

using namespace std;

int main() {
    int n;
    cin >> n;

    string path;
    cin >> path;

    int maxi = pow(2, n + 1);

    int pos = 1;
    for(auto c : path) {
        pos *= 2;
        if(c == 'R') {
            pos++;
        }
    }

    cout << maxi - pos << endl;
}
 */