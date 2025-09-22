package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer el precio del m2 de semilla (en un double)
// Leer el número de casos (en un Int)
// Para cada caso
//   leer largo y ancho (doubles)
//   multiplicar largo*ancho*precio m2
//   acumular el resultado
// Mostrar el resultado

import java.util.Locale;
import java.util.Scanner;

public class GrassSeedInc {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.UK);

        // Leer el precio del m2 de semillas
        double precio = sc.nextDouble();

        //Leer el número de casos
        int num = sc.nextInt();

        //Contar los 1s de strNum
        double totalPrecio = 0;
        for (int i=0; i < num; i++) {
            //Leer ancho y largo
            double ancho = sc.nextDouble();
            double largo = sc.nextDouble();
            totalPrecio += ancho*largo*precio;
        }

        //Imprimir el resultado
        System.out.println(totalPrecio);

        sc.close();
    }
}

