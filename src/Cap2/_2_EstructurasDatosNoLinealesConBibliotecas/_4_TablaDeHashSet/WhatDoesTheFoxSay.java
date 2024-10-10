package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._4_TablaDeHashSet;


import java.util.HashSet;
import java.util.Scanner;

// Leer todos los sonidos grabados
// Leer todos los sonidos que hacen los animales y añadirlos a un HashSet



public class WhatDoesTheFoxSay {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int numCasos = scan.nextInt();
        scan.nextLine();

        for (int i=0; i<numCasos; i++) {
            HashSet<String> sonidosConocidos = new HashSet<String>();

            //Leer los sonidos grabados
            String[] grabacion = scan.nextLine().split(" ");

            //Leer los sonidos conocidos
            String[] accion = scan.nextLine().split(" ");
            while (!accion[0].equals("what")) {
                sonidosConocidos.add(accion[2].trim());
                accion = scan.nextLine().split(" ");
            }

            //Imprimir los sonidos que no se conocen
            boolean primero = true;
            for (String sonido : grabacion) {
                if (!sonidosConocidos.contains(sonido)) {
                    if (primero) primero = false; else System.out.print(" ");
                    System.out.print(sonido);
                }
            }
            System.out.println();
        }
    }

}

