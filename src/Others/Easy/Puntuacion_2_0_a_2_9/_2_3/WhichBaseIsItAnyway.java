package Others.Easy.Puntuacion_2_0_a_2_9._2_3;


/*
    Leer un número e interpretarlo como octal, decimal y hexadecimal
 */
import java.util.*;

public class WhichBaseIsItAnyway {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numCasos = sc.nextInt();

        while (numCasos-- >0) {
            //Imprimir el data set number
            System.out.print(sc.nextInt());

            //Leer el número
            String num = sc.next();

            //Probar con las bases octal, decimal y hexadecimal
            int[] bases = {8, 10, 16};
            for (int i = 0; i < bases.length; i++) {
                System.out.print(" ");
                try {
                    System.out.print(Integer.parseInt(num, bases[i]));
                } catch (Exception e) {
                    System.out.print(0);
                }
            }
            System.out.println();

        }
    }
}