package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 * Se trata de detectar valles y picos
 * Comprar en un valle
 * Vender en un pico
 * Acumular la diferencia
 *
 * Otra opción más simple es compra hoy para vender mañana si mañana tengo un precio superior al de hoy
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class StocksMania {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        int numHoras = sc.nextInt();

        //Leer los valores
        int[] valores = new int[numHoras+2];  //Crear una posición extra al inicio y al final
        for (int i=1; i<=numHoras; i++) {
            valores[i] = sc.nextInt();
        }

        //Informar las posiciones extras
        valores[0] = valores[1];
        valores[numHoras+1] = valores[numHoras];

        //Buscar picos y valles
        int ultimaCompra = valores[0];
        int ganancias = 0;
        for (int i=1; i<=numHoras; i++) {
            if (valores[i-1]<=valores[i] && valores[i]>=valores[i+1]) {
                //Es un pico --> Vender
                ganancias += valores[i] - ultimaCompra;
                ultimaCompra = valores[i];
            }
            if (valores[i-1]>=valores[i] && valores[i]<=valores[i+1]) {
                //Es un valle --> Comprar
                ultimaCompra = valores[i];
            }
        }

        // Mostrar el resultado
        System.out.println(ganancias);


        sc.close();
    }
}

