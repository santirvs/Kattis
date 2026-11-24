package Others.Easy.Puntuacion_2_0_a_2_9._2_4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DraggedOutDuel {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        sc.nextLine();
        String lineaYo = sc.nextLine();
        String lineaOtro = sc.nextLine();

        int contYo = 0;
        int contOtro = 0;

        for (int i=0; i<lineaYo.length(); i++) {

            char cYo = lineaYo.charAt(i);
            char cOtro = lineaOtro.charAt(i);

            if (cYo != cOtro) {
                if (ganoYo(cYo, cOtro)) {
                    contYo++;
                } else {
                    contOtro++;
                }
            }
        }

        if (contYo > contOtro) System.out.println("victory");
        else System.out.println("defeat");
    }

    public static boolean ganoYo(char yo, char otro) {
        if (yo=='R' && otro == 'S' ||
                yo == 'S' && otro == 'P' ||
                yo == 'P' && otro == 'R' )
            return true;
        else
            return false;
    }
}