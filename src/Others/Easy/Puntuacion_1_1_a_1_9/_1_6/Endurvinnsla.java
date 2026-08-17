package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Leer los items y calcular el porcentaje de no plástico
 * Si supera el límite, no es reciclable
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class Endurvinnsla {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        sc.nextLine();  //Ignorar el nombre de la ciudad

        double limite = sc.nextDouble();
        double numItems = sc.nextDouble();
        sc.nextLine();
        int numNoPlasticos = 0;

        for (int i=0; i<numItems; i++) {
            String item = sc.nextLine();

            if (item.equals("ekki plast")) numNoPlasticos++;
        }

        //Calcular el porcentaje de no plásticos
        double porcentaje = numNoPlasticos / numItems;

        //Mostrar el resultado
        if (porcentaje > limite) System.out.println("Neibb");
        else System.out.println("Jebb");


        sc.close();
    }
}

