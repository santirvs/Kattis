package Cap1._1_ParaEmpezar._A_Medios;

import java.util.Locale;
import java.util.Scanner;

public class ShatteredCake {

     public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Ancho conocido del pastel
        int ancho = scan.nextInt();

        //Número de trozos
        int numTrozos = scan.nextInt();

        //Leer los trozos y calcular el área
        int area = 0;
        for(int i=0; i<numTrozos; i++){
            int anchoTrozo = scan.nextInt();
            int largoTrozo = scan.nextInt();
            area += anchoTrozo*largoTrozo;
        }

        //El área del pastel y el área de los trozos deberían coincidir
         //Por lo tanto, el largo del pastel será el área de los trozos dividido por el ancho
        int largo = area/ancho;

        System.out.println(largo);

    }
}



