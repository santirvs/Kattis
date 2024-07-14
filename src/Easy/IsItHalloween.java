package Easy;

import java.util.Locale;
import java.util.Scanner;

public class IsItHalloween {
    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);
        Scanner scan = new Scanner(System.in);

        String fecha = scan.nextLine();

        if (fecha.equals("OCT 31") || fecha.equals("DEC 25")) {
            System.out.println("yup");
        } else {
            System.out.println("nope");
        }
    }
}