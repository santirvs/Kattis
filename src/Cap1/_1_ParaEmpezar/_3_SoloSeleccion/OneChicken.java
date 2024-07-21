package Cap1._1_ParaEmpezar._3_SoloSeleccion;

import java.util.Locale;
import java.util.Scanner;

public class OneChicken {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        int numPersonas = scan.nextInt();
        int numPiezas = scan.nextInt();

        if (numPiezas > numPersonas) {
            int sobrantes = numPiezas - numPersonas;
            if (sobrantes == 1) {
                System.out.println("Dr. Chaz will have 1 piece of chicken left over!");
            } else {
                System.out.println("Dr. Chaz will have " + sobrantes + " pieces of chicken left over!");
            }
        } else {
            int faltantes = numPersonas - numPiezas;
            if (faltantes == 1) {
                System.out.println("Dr. Chaz needs 1 more piece of chicken!");
            } else {
                System.out.println("Dr. Chaz needs " + faltantes + " more pieces of chicken!");
            }
        }
    }
}