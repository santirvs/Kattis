package Cap2._2_EstructurasDatosConBibliotecas._1_ArraysUnidimensionales_Medios;

import java.util.Locale;
import java.util.Scanner;

public class EraseSecurely {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

       //Leer la entrada
        int numVeces = scan.nextInt();
        scan.nextLine();
        String original = scan.nextLine();
        String finalString = scan.nextLine();

        boolean isOk = true;
        if (numVeces%2==0) {
            //Si el número de veces es par, entonces se compara el string original con el final
            isOk = original.equals(finalString);
        }
        else {
            //Si el número de veces es impar, entonces se invierte el string original
            for (int i=0; i<original.length() && isOk; i++) {
                if (original.charAt(i) == finalString.charAt(i)) {
                    isOk = false;
                }
            }
        }

        if (isOk) {
            System.out.println("Deletion succeeded");
        }
        else {
            System.out.println("Deletion failed");
        }
    }
}
