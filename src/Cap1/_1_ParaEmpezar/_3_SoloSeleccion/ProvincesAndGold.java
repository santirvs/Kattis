package Cap1._1_ParaEmpezar._3_SoloSeleccion;

import java.util.Locale;
import java.util.Scanner;

public class ProvincesAndGold {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        int sum = scan.nextInt() * 3 + scan.nextInt() * 2 + scan.nextInt();

        //Victory Cards
        if (sum >= 8) System.out.println("Province or ");
        else if (sum >= 5) System.out.println("Duchy or ");
        else if (sum >= 2) System.out.println("Estate or ");

        //Treasure Cards
        if (sum >= 6) System.out.println("Gold");
        else if (sum >= 3) System.out.println("Silver");
        else System.out.println("Copper");
    }
}