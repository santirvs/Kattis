package Cap2._1_EstructurasDatosConBibliotecas._10_Pila;

import java.util.*;

//Me creo una class Nombre para poder ordenar los nombres por longitud
//Luego leo los nombres, los ordeno y los imprimo
//Los nombres impares los imprimo directamente
//Los nombres pares los apilo y luego los imprimo

public class SymmetricOrder {
    static class Nombre implements Comparable<Nombre> {
        String nombre;

        public Nombre(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public int compareTo(Nombre o) {
            return this.nombre.length() - o.nombre.length();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numNombres = scan.nextInt();
        int contadorSet = 0;

        while (numNombres > 0) {
            contadorSet++;
            Stack<Nombre> pila = new Stack<>();

            //Leer la lista de nombres
            Nombre[] nombres = new Nombre[numNombres];
            for (int i = 0; i < numNombres; i++) {
                nombres[i] = new Nombre(scan.next());
            }
            //Ordenar los nombres
            Arrays.sort(nombres);

            //Imprimir los nombres impares y apilar los pares
            System.out.println("SET " + contadorSet);
            for (int i = 1; i <= numNombres; i++) {
                if (i % 2 == 0) pila.add(nombres[i - 1]);
                else System.out.println(nombres[i - 1].nombre);
            }

            //Desapilar los pares e imprimirlos
            while (!pila.isEmpty()) {
                System.out.println(pila.pop().nombre);
            }

            //Siguiente caso
            numNombres = scan.nextInt();
        }
    }
}
