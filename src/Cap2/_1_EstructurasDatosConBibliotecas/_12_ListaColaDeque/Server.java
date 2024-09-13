package Cap2._1_EstructurasDatosConBibliotecas._12_ListaColaDeque;

//Simple caso de una cola, que se podria implementar "al vuelo"
//sin necesidad de usar ningún tipo de dato especial
//Como los requerimientos no son muy exigentes, no hay necesidad de optimizar

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer los datos
        int numDatos = scan.nextInt();
        int capacidad = scan.nextInt();

        LinkedList<Integer> fila = new LinkedList<Integer>();

        //Leer los datos
        for (int i = 0; i < numDatos; i++) {
            fila.add(scan.nextInt());
        }

        //Procesar los datos
        int duracionTotal = 0;
        int numTareas = 0;
        while (!fila.isEmpty()) {
            int tarea = fila.pop();
            if (duracionTotal+tarea > capacidad) {
                break;
            }
            else {
                numTareas++;
                duracionTotal += tarea;
            }
        }

        //Mostrar el resultado
        System.out.println(numTareas);



    }
}

