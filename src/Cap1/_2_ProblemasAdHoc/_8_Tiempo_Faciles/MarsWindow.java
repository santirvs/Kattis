package Cap1._2_ProblemasAdHoc._8_Tiempo_Faciles;


import java.util.Locale;
import java.util.Scanner;

public class MarsWindow {

        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            scan.useLocale(Locale.ENGLISH);

            //Lectura de los datos del caso
            int year = scan.nextInt();
            int month = 4;
            final int VENTANA = 26;

            int mesesInferior = ((year - 2018) * 12 - month+1) % VENTANA;
            int mesesSuperior = ((year - 2018) * 12 + (12 - month)) % VENTANA;

            if (mesesInferior <= 0 && 0 <= mesesSuperior || mesesInferior > mesesSuperior) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

}
