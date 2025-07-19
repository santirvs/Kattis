package Cap2._2_EstructurasDatosConBibliotecas._2_ArraysUnidimensionalesDificiles;

import java.util.Locale;
import java.util.Scanner;

public class TheUpsAndDownsOfInvesting {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numDatos = scan.nextInt();
        int longPico = scan.nextInt();
        int longValle = scan.nextInt();

        //Expando el array para evitar comprobaciones
        int[] oscila = new int[numDatos+longPico+longValle];

        //Leo los valores y apunto la longitud de la secuencia incremental (positivo)
        //o decremental (negativo)
        int numeroAnterior = scan.nextInt();
        oscila[0] = 0;
        for (int i=1; i<numDatos; i++) {
            int numero = scan.nextInt();
            if (numero > numeroAnterior)
                oscila[i] = Math.max(2, oscila[i-1]+1);
            if (numero < numeroAnterior)
                oscila[i] = Math.min(-2, oscila[i-1]-1);
            numeroAnterior = numero;
        }

        for (int i=numDatos;  i<numDatos+longPico+longValle; i++)
            oscila[i] = oscila[i-1];

        //Recorrer el array de oscilaciones buscando
        // a) oscila[i] >= longPico o -longValle  y
        // b.1) oscila[i+longPico] = -longPico     o bien
        // b.2) oscila[i+longValle] = longValle

        int numPicos = 0;
        int numValles = 0;
        for (int i=0; i<numDatos; i++) {
            if (oscila[i] >= longPico && oscila[i+longPico-1] == -longPico)
                numPicos++;
            if (oscila[i] <= -longValle && oscila[i+longValle-1] == longValle)
                numValles++;
        }


        //Mostrar el resultado
        System.out.println(numPicos + " " + numValles);
    }
}
