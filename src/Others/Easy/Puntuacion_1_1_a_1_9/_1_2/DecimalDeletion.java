package Others.Easy.Puntuacion_1_1_a_1_9._1_2;

// Leer el float, redondear a entero y mostrar el resultado sin decimales

import java.util.Locale;
import java.util.Scanner;

public class DecimalDeletion {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);  // Asegura que el punto decimal sea reconocido correctamente

        //Leer el número de personas
        float num = scan.nextFloat();
        System.out.printf("%.0f\n", num);  //La impresión sin decimales ya hace el redondeo

    }
}