package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 * Seguir las instrucciones e implementar los ifs
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class ColourAnalysis {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        //Leer los datos
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();

        if (r > g && r > b) System.out.println("raudur");
        else if (g > r && g > b) System.out.println("graenn");
        else if (b > r && b > g) System.out.println("blar");
        else if (r == g && r > b) System.out.println("gulur");
        else if (r == b && r > g) System.out.println("fjolubleikur");
        else if (g == b && g > r) System.out.println("blagraenn");
        else if (r == 0 && g == 0 && b == 0) System.out.println("svartur");
        else if (r == 255 && g == 255 && b == 255) System.out.println("hvitur");
        else if (r == g && r == b &  r!=0 & r!=255) System.out.println("grar");
        else System.out.println("othekkt");

        sc.close();
    }
}

