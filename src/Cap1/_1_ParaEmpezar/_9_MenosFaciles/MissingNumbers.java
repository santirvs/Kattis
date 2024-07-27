package Cap1._1_ParaEmpezar._9_MenosFaciles;

import java.util.Locale;
import java.util.Scanner;

public class MissingNumbers {

   public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Lectura de los datos del caso
        int numbers = scan.nextInt();
        boolean blnOk = true;
        int anteriorNum = 1;

        //Leer el número de la secuencia
        for (int i=1; i<=numbers; i++){
            int n = scan.nextInt();
            //Imprimir los números que falten
            int j= anteriorNum;
            while (n != j){
                System.out.println(j);
                j++;
                blnOk = false;
            }
            anteriorNum = n+1;
        }

        //Si no faltan números, felicitar
        if (blnOk){
            System.out.println("good job");
        }
    }
}
