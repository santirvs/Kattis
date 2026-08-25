package Others.Easy.Puntuacion_2_0_a_2_9._2_6;

/*
    c = monedas del oponente
    m = monedas mías

    si m>c --> apostar c+1 para ganar la vaca
    si m=c --> apostar c para empatar y no perder una vaca ni ganarla
    mi m<c --> apostar 0, ya que se va a perder la vaca, centranos en el objetivo secundario y no perder dinero
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Koehandel {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();
        int m = sc.nextInt();

        if (m>c) System.out.println(c+1);
        else if (m==c) System.out.println(m);
        else System.out.println(0);
    }

}