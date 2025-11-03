package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer la fecha en formato AA/BB/YYYY
// Comprobar si AA es mayor de 12
// Comprobar si BB es mayor de 12
// Si AA y BB son menores --> imprimir "either"
// Si AA es mayor de 12 --> imprimir "EU"
// Si BB es mayor de 12 --> imprimir "US"

import java.util.Scanner;


public class InternationalDates {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //Leer la fecha
        String[] fecha = sc.nextLine().split("/");

        //Comprobar las partes
        boolean esDiaAA = Integer.parseInt(fecha[0]) > 12;
        boolean esDiaBB = Integer.parseInt(fecha[1]) > 12;

        if (!esDiaAA && !esDiaBB)
            System.out.println("either");
        else if (esDiaAA)
            System.out.println("EU");
        else
            System.out.println("US");

        sc.close();
    }
}

