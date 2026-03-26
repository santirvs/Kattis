package Others.Trivial.Puntuacion_1_1_a_1_5._1_2;

// Leer el número de campos de futbol
// Aplicar el factor de conversion 1 campo = 0.09144 km
// Mostrar el resultado con 5 decimales

import java.util.Scanner;

public class AmeriskurVinnustadur {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer los datos
        int numCampos = scan.nextInt();
        double kms = numCampos * 0.09144;
        System.out.printf("%.5f\n", kms);

    }
}