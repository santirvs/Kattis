package Cap1._2_ProblemasAdHoc._6_VidaReal_Medios;


import java.util.Locale;
import java.util.Scanner;

public class WordCloud {

     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         //Leer los datos del caso
         int ancho = scan.nextInt();
         int numPalabras = scan.nextInt();

         int numCloud = 0;

        while (ancho!=0 || numPalabras!=0) {
            numCloud++;
            scan.nextLine();

            String[] palabras = new String[numPalabras];
            int[] ocurrencias = new int[numPalabras];
            int maxOcurrencias = 0;

            //Leer las palabras y ocurrencias
            for (int i = 0; i < numPalabras; i++) {
                String palabra = scan.next();
                int ocurrencia = scan.nextInt();
                palabras[i] = palabra;
                ocurrencias[i] = ocurrencia;
                maxOcurrencias = Math.max(maxOcurrencias, ocurrencia);
            }

            //Calcular el alto del cloud
            int anchoActual = 0;
            int altoCloud = 0;
            int maxAltoLinea = 0;
            for (int i = 0; i < numPalabras; i++) {
                int altoPalabra = 8 + (int)Math.ceil(40.0 * (ocurrencias[i] - 4) / (maxOcurrencias - 4));
                int anchoPalabra = (int)Math.ceil(9.0/16.0* altoPalabra * palabras[i].length());

                //Cabe la siguiente palabra? Cuanto espacio necesito?
                //Si ya había una palabra, necesito 10 puntos de separación
                int anchoNecesario = 0;
                if (anchoActual != 0) {
                    anchoNecesario = 10 + anchoPalabra;
                } else {
                    anchoNecesario = anchoPalabra;
                }

                //Si no cabe, se inicializa la siguiente linea con la palabra actual
                if (anchoActual + anchoNecesario > ancho) {
                    altoCloud += maxAltoLinea;
                    anchoActual = anchoPalabra;
                    maxAltoLinea = altoPalabra;
                } else {
                    //Sí que cabe, se incrementa el ancho y se actualiza el alto de la línea
                    anchoActual += anchoNecesario;
                    maxAltoLinea = (int)Math.max(maxAltoLinea, altoPalabra);
                }

            }

            //Añadir el alto de la última línea
            altoCloud += maxAltoLinea;

            //Mostrar el resultado
            System.out.println("CLOUD " + numCloud + ": " + altoCloud);

            //Siguiente caso
            ancho = scan.nextInt();
            numPalabras = scan.nextInt();
        }



     }

}
