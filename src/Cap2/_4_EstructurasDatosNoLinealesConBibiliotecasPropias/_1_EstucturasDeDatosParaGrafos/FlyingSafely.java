package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias._1_EstucturasDeDatosParaGrafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FlyingSafely {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int cases = scan.nextInt();

        int cities, pilots;

        for(int i = 0; i < cases; i++) {
            cities = scan.nextInt();
            pilots = scan.nextInt();

            int a,b;
            for(int j = 0; j < pilots; j++) {
                a = scan.nextInt();
                b= scan.nextInt();
            }

            System.out.println(cities-1);
        }

    }
}
