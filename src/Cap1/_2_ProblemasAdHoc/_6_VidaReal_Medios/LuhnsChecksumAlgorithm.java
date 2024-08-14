package Cap1._2_ProblemasAdHoc._6_VidaReal_Medios;


import java.util.Locale;
import java.util.Scanner;

public class LuhnsChecksumAlgorithm {

     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         //Leer los datos del caso
            int casos = scan.nextInt();
            scan.nextLine();

            for (int i = 0; i < casos; i++) {
                String numTarjeta = scan.nextLine();
                int suma = 0;



                for (int j = 0; j < numTarjeta.length() ; j++) {
                    int pos = numTarjeta.length() - j - 1;
                    int digito = numTarjeta.charAt(pos) - '0';

                    if (j % 2 == 0) {
                        suma += digito;
                    } else {
                        suma += digito * 2 % 10 + digito * 2 / 10;
                    }
                }

                if (suma % 10 == 0) {
                    System.out.println("PASS");
                } else {
                    System.out.println("FAIL");
                }
            }

     }

}
