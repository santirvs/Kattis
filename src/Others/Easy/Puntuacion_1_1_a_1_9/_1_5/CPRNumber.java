package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el código c1c2c3c4c5c6-c7c8c9c10
// Calcular la fórmula
// 4xc1 + 3xc2 + 2xc3 + 7xc4 + 6xc5 + 5xc6 + 4xc7 + 3xc8 + 2xc9 + 1xc10
// Si el resultado es divisible entre 11 --> imprimir 1, sino 0
import java.util.Locale;
import java.util.Scanner;


public class CPRNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        // Leer el código
        String codigo = sc.nextLine();

        int factor = 4;
        int suma = 0;
        for (int i=0; i<11; i++) {
            if (i!=6) {
                int valor = codigo.charAt(i) - '0';
                suma += valor * factor;
                if (i==2) {
                    factor = 7;
                } else {
                    factor--;
                }


            }
        }

        if (suma%11 == 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }


        sc.close();
    }
}

