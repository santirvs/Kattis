package Cap1._1_ParaEmpezar._6_Funcion;

import java.util.Locale;
import java.util.Scanner;

public class TreasureHunt {

   public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer las dimensiones del tablero
        int filas = scan.nextInt();
        int columnas = scan.nextInt();

        //Definir y cargar el tablero
        char[][] tablero = new char[filas][columnas];

        for (int i = 0; i < filas; i++) {
            String linea = scan.next();
            tablero[i]= linea.toCharArray();
        }

        //Empezar a recorrer el tablero
        boolean encontrado = false;
        boolean perdido = false;
        boolean fuera = false;

        int fila = 0;
        int columna = 0;
        int numPasos = 0;

        while (!encontrado && !perdido && !fuera) {
            char celda = tablero[fila][columna];
            tablero[fila][columna] = 'V'; // Marcar la celda como visitada
            numPasos++;

            switch (celda) {
                case 'T': encontrado = true; numPasos--; break;
                case 'N': fila--; break;
                case 'S': fila++; break;
                case 'E': columna++; break;
                case 'W': columna--; break;
                case 'V': perdido = true; break;
            }

            //Control de los límites del tablero
            if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
                fuera = true;
            }
        }

        //Mostrar el resultado
        if (fuera)
            System.out.println("Out");
        else if (perdido)
            System.out.println("Lost");
        else
            System.out.println(numPasos);

    }
}
