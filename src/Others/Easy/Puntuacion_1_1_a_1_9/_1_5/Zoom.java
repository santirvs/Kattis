package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el número de datos
// Leer el zoom
// Leer cada dato, si la posición es múltiplo de zoom, añadirlo al resultado
// Imprimir el resultado


import java.util.Locale;
import java.util.Scanner;


public class Zoom {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        // Leer el número de datos
        int n = sc.nextInt();
        // Leer el zoom
        int zoom = sc.nextInt();

        StringBuilder resultado = new StringBuilder();
        // Leer cada dato
        for (int i = 1; i <= n; i++) {
            int dato = sc.nextInt();
            // Si la posición es múltiplo de zoom, añadirlo al resultado
            if (i % zoom == 0) {
                resultado.append(dato + " ");
            }
        }

        // Imprimir el resultado
        System.out.println(resultado.toString().trim());

        sc.close();
    }
}

