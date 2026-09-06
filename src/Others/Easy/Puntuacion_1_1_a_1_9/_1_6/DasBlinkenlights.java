package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Calcular el mcm de los dos números y comprobar si es menor o igual que p
 */


import java.io.IOException;
import java.util.Scanner;


public class DasBlinkenlights {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int p = sc.nextInt();

        int mcm = calcularMCM(a, b);

        if (mcm <= p) System.out.println("yes");
        else System.out.println("no");

        sc.close();
    }

    public static int calcularMCM(int a, int b) {
        if (a == 0 || b == 0) {
            return 0; // El MCM de 0 con cualquier número es 0 por convención
        }
        // Dividimos primero por el MCD para evitar desbordamientos (overflow)
        // si los números multiplicados son muy grandes.
        return Math.abs((a / calcularMCD(a, b)) * b);
    }

    public static int calcularMCD(int a, int b) {
        // Trabajamos con valores absolutos para soportar números negativos
        a = Math.abs(a);   b = Math.abs(b);

        while (b != 0) {
            int temporal = b;
            b = a % b;
            a = temporal;
        }
        return a;
    }


}

