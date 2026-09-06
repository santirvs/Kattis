package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

/**
 * Leer los nombres y su clasificacion
 *
 * Para cada frase, leer el nombre y el adjetivo
 * Verificar que coincida el adjetivo con alguna de las formas aceptadas
 *
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class LessVsFewer {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        //Leer la cantidad de datos
        int numNombres = sc.nextInt();
        int numFrases = sc.nextInt();

        //Definir el mapa para clasificar los nombres
        HashMap<String, List<String>> nombres = new HashMap<>();
        List<String> contables = List.of("number of", "most", "fewest", "more", "fewer","many", "few" );
        List<String> incontables = List.of("amount of", "most", "least", "more", "less", "much", "little" ) ;

        //Clasificar los nombres
        for (int i=0; i<numNombres; i++) {
            String nombre = sc.next();
            String tipo = sc.next();

            if (tipo.equals("c")) {
                nombres.put(nombre, contables);
            } else {
                nombres.put(nombre, incontables);
            }
        }

        sc.nextLine();
        //Leer las frases y determinar si son o no correctas
        for (int i=0; i<numFrases; i++) {
            String frase = sc.nextLine();
            //Extraer el nombre (última palabra)
            String nombre = frase.substring(frase.lastIndexOf(' ')+1);
            String forma = frase.substring(0, frase.lastIndexOf( ' '));

            List<String> validos = nombres.get(nombre);
            if (validos.contains(forma)) {
                System.out.println("Correct!");
            } else {
                System.out.println("Not on my watch!");
            }

        }


    }
}

