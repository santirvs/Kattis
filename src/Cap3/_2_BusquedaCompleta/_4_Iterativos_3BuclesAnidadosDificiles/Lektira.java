package Cap3._2_BusquedaCompleta._4_Iterativos_3BuclesAnidadosDificiles;

// Fuerza bruta
// Probar todas las combinaciones de puntos de corte


import java.io.IOException;
import java.util.Scanner;

public class Lektira {

    private static String reverse(String originalStr) {
        StringBuilder reversedStr = new StringBuilder(originalStr);
        return reversedStr.reverse().toString();
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        //Leer la palabra
        String palabra = scan.nextLine();

        // Buscar la combinación de puntos de corte que produzca la palabra
        // Y quedarnos con la lexicograficamente más baja
        String palabraMenor = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        for (int i = 0; i < palabra.length()-2; i++) {
            String subpalabra1 = reverse(palabra.substring(0, i + 1));
            for (int j = i + 1; j < palabra.length()-1; j++) {
                String subpalabra2 = reverse(palabra.substring(i + 1, j + 1));
                String subpalabra3 = reverse(palabra.substring(j + 1));

                // Comprobar si la concatenación de las subpalabras es igual a la palabra original
                String concatenacion = subpalabra1 + subpalabra2 + subpalabra3;
                if (concatenacion.compareTo(palabraMenor) < 0) {
                    palabraMenor = concatenacion;
                }
            }
        }

        // Imprimir la palabra lexicográficamente menor
        System.out.println(palabraMenor);

    }

}

