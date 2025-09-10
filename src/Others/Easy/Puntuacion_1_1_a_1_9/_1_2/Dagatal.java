package Others.Easy.Puntuacion_1_1_a_1_9._1_2;

// Leer el mes e indicar el número de días que tiene

import java.util.Scanner;

public class Dagatal {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer los datos
        int mes = scan.nextInt();

        //Determinar el número de días del mes
        int dias;
        switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12:
                dias = 31;
                break;
            case 4, 6, 9, 11:
                dias = 30;
                break;
            default:  // Febrero
                dias = 28;
                break;
        }
        //Imprimir el resultado
        System.out.println(dias);
    }
}