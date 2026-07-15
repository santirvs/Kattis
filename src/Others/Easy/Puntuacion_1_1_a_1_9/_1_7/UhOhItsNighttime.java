package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 * Calcular el tamaño del cubo exterior
 * Restar las dimensiones del cubo necesario interior (ancho-2), (largo-2), (alto-1)
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class UhOhItsNighttime {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        //Leer los datos
        int numLados = sc.nextInt();

        int ancho = sc.nextInt();
        int largo = ancho;
        int alto = 3;
        if (numLados > 1) largo = sc.nextInt();
        if (numLados > 2) alto = sc.nextInt();

        //Asegurar las dimensiones mínimas (no es necesario, ya lo asegura el enunciado)
//        ancho = Math.max(ancho, 3);
//        alto = Math.max(alto, 3);
//        largo = Math.max(largo, 3);

        //Calculo del total de bloques
        int totalExterno = ancho * largo * alto;

        //Calculo de volumen interno
        int totalInterno = (ancho-2) * (largo-2) * (alto-1);

        //Calculo del resultado
        System.out.println(totalExterno - totalInterno);
    }
}

