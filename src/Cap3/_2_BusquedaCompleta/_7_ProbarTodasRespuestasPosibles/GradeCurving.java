package Cap3._2_BusquedaCompleta._7_ProbarTodasRespuestasPosibles;
import java.util.*;
import java.io.*;

// En este problema se empieza probando con 0 iteraciones y se van incrementando
//  hasta que se cumpla la condición de parada o x alcance 100
//  La clave del asunto está en detectar cuándo será infinito el número de veces que se aplica la fórmula
//  sin que se llegue a 100 o se salga del rango.
//  Pero como el resultado se debe redondear al alza, y nunca puede superar 100
//  podemos suponer un número infinito de iteraciones si x se acerca lo suficiente a 100 (error <= 1e-5).
//  Hay que tener en cuenta que la función x = 10 * sqrt(x) es creciente y converge en 100 sin llegar a alcanzarlo.
//

public class GradeCurving {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        // x: valor inicial
        double x = scan.nextDouble();
        // low y high: límites enteros de interés
        int low = scan.nextInt();
        int high = scan.nextInt();

        // k: número de iteraciones (empezamos en -1 porque lo incrementamos al inicio del bucle)
        // mini: primer k que cumple la condición
        // maxi: último k que cumple la condición
        int k = -1, mini = -1, maxi = -1;

        // Bucle infinito que se romperá con una condición interna
        while (true) {
            // Si hemos hecho al menos una iteración y x es prácticamente 100 (error <= 1e-5), paramos
            if (k > 0 && Math.abs(x - 100) < 1e-5) {
                break;
            }

            // Avanzamos el contador de iteraciones
            k++;

            // Comprobamos si el valor actual de x (redondeado hacia arriba) está entre low y high
            // o si x ha llegado a ser al menos 100
            if ((Math.ceil(x) >= low && Math.ceil(x) <= high) || x >= 100) {
                // Si es la primera vez que ocurre, guardamos el valor en mini
                if (mini < 0) {
                    mini = k;
                }
                // Siempre actualizamos maxi con la última iteración que cumple
                maxi = k;
            }

            // Actualizamos x aplicando la transformación: x = 10 * sqrt(x)
            x = 10 * Math.sqrt(x);
        }

        // Al final, imprimimos el resultado según los casos
        if (mini < 0 && maxi < 0) {
            // Nunca se cumplió la condición
            System.out.println("impossible");
        } else if (maxi == k) {
            // El valor se sigue cumpliendo hasta el final → "inf" significa infinito
            System.out.println(mini + " inf");
        } else {
            // Caso general: mostramos el rango [mini, maxi]
            System.out.println(mini + " " + maxi);
        }
    }
}
