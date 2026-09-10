package Others.Easy.Puntuacion_1_1_a_1_9._1_8;
import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int anyo = sc.nextInt();
        boolean esBisiesto = false;

        // Es bisiesto si es múltiplo de 4
        if (anyo % 4 == 0) {
            esBisiesto = true;

            //Excepto si es múltiplo de 100
            if (anyo % 100 == 0) {
                esBisiesto = false;
            }
            //Pero recuperamos los múltiplos de 400
            if (anyo % 400 == 0) {
                esBisiesto = true;
            }
        }

        if (esBisiesto)
            System.out.println("True");
        else
            System.out.println("False");

    }
}