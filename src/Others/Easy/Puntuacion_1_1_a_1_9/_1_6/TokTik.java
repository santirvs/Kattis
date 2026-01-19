package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * v1 : Leer la cantidad de videos
 *      Para cada video:
 *          - leer el autor
 *          - leer las visualizaciones
 *          - Añadir el autor al diccionario HashMap<String, Int>
 *          - Sumar las visualizaciones al autor
 *          - Si las visualizaciones superan al máximo, actualizar el máximo (autor y cantidad)
 *
 *      Al finalizar, mostrar el autor con más visualizaciones
 */


import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;


public class TokTik {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        //leer autores
        int numAutores = sc.nextInt();
        HashMap<String, Integer> mapa = new HashMap<>();
        String maxAutor = "";
        int maxVisualizaciones = 0;

        while (numAutores-- > 0) {
            String autor = sc.next();
            int numVisualizaciones = sc.nextInt();
            int totalVisualizaciones;

            //Añadir o actualizar la clave
            if (mapa.containsKey(autor)) {
                totalVisualizaciones = mapa.get(autor) + numVisualizaciones;
                mapa.put(autor, totalVisualizaciones);
            } else {
                totalVisualizaciones = numVisualizaciones;
                mapa.put(autor, numVisualizaciones);
            }

            //Actualizar el máximo
            if (totalVisualizaciones > maxVisualizaciones) {
                maxAutor = autor;
                maxVisualizaciones = totalVisualizaciones;
            }

        }

        //Mostrar el resultado
        System.out.println(maxAutor);


        sc.close();
    }
}

