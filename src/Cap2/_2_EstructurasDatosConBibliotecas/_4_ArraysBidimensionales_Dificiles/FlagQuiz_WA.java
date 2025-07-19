package Cap2._2_EstructurasDatosConBibliotecas._4_ArraysBidimensionales_Dificiles;

import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;

public class FlagQuiz_WA {

    public static class Palabra implements Comparable<Palabra> {
        String palabra;
        int numVeces;

        public Palabra(String palabra) {
            this.palabra = palabra;
            this.numVeces = 1;
        }

        public void incrementar() {
            this.numVeces++;
        }

        @Override
        public int compareTo(Palabra o) {
            return o.numVeces - this.numVeces;
        }

        public boolean equals(Object o) {
            return this.palabra.equals(((Palabra)o).palabra);
        }
    }
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        scan.nextLine();  //Ignorar la pregunta
        int numFilas = scan.nextInt();
        scan.nextLine();
        String propuesta1 = scan.nextLine();

        String[][] propuestas = new String[numFilas][propuesta1.split(", ").length];
        propuestas[0] = propuesta1.split(", ");
        for (int f = 1; f < numFilas; f++) {
            propuestas[f] = scan.nextLine().split(", ");
        }

        //Crear una lista de respuestas
        ArrayList<String> respuestas = new ArrayList<>();
        respuestas.add("");

        //Analizar las propuestas
        for (int c = 0; c < propuestas[0].length; c++) {
            Palabra p = new Palabra(propuestas[0][c]);
            ArrayList<Palabra> palabras = new ArrayList<>();
            palabras.add(p);
            for (int f = 1; f < numFilas; f++) {
                p = new Palabra(propuestas[f][c]);
                if (palabras.contains(p)) {
                    p = palabras.get(palabras.indexOf(p));
                    p.incrementar();
                } else palabras.add(p);
            }
            //Ordenas las palabras por número de veces
            Collections.sort(palabras);
            //Eliminar les paraules que no son les més repetides
            int max = palabras.get(0).numVeces;
            for (int i = palabras.size() - 1; i >= 0; i--) {
                if (palabras.get(i).numVeces < max) {
                    palabras.remove(i);
                }
            }

            int tamanyo = respuestas.size();
            if (palabras.size() > 1) {
                //Si hay empate, multiplicar las opciones
                for (int i = 0; i < tamanyo; i++) {
                    for (int j = 0; j < palabras.size()-1; j++) {
                        respuestas.add(respuestas.get(i));
                    }
                }
            }

            for (int i = 0; i < palabras.size(); i++) {
                p = palabras.get(i);
                for (int j = 0; j < tamanyo; j++) {
                    if (respuestas.get(j+i*tamanyo).equals("")) {
                        respuestas.set(j+i*tamanyo, p.palabra);
                    } else {
                        respuestas.set(j+i*tamanyo, respuestas.get(j+i*tamanyo) + ", " + p.palabra);
                    }
                }
            }


        }

        //Imprimir resultado
        for (int i = 0; i < respuestas.size(); i++) {
            System.out.println(respuestas.get(i));
        }

    }


}

/*
'''
Kattis - flagquiz
Relatively straightforward, for each alternative i, we compare against all other alternatives to
find the max_num_changes for i. We keep track of the smallest max num changes and keep a list
of the indices and print the list at the end.

Note the use of the various python specific things to make life easier (especially zip, split and join)

Time: O(n^2 * num_parts), Space: O(n*num_parts)
'''
n = input()
n = int(input())
A = []
for _ in range(n):
    A.append(list(input().split(',')))

ans = []
smallest_max_num_changes = 200
for i in range(n):
    max_num_changes = 0
    for j in range(n):
        # Compare A[i] with A[j]
        num_changes = 0
        for (a, b) in zip(A[i], A[j]):
            if (a != b):
                num_changes += 1
        max_num_changes = max(num_changes, max_num_changes)

    if (max_num_changes == smallest_max_num_changes):
        ans.append(i)
    elif (max_num_changes < smallest_max_num_changes):
        smallest_max_num_changes = max_num_changes
        ans = [i]

for i in ans:
    print(','.join(A[i]))
 */