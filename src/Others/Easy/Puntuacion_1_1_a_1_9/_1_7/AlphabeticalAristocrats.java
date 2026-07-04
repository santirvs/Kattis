package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 * Usar un TreeMap<String,String> donde la clave es el substring a partir de la primera mayúscula
 * y el valor es el apellido completo
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class AlphabeticalAristocrats {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        //Leer los datos
        int numDatos = sc.nextInt();
        sc.nextLine();
        TreeMap<String, String> mapa = new TreeMap<>();

        while (numDatos-- > 0) {
            String apellido = sc.nextLine();
            String apellidoDesdeMayuscula = desdeMayuscula(apellido);
            mapa.put(apellidoDesdeMayuscula, apellido);
        }

        for (Map.Entry e: mapa.entrySet()) {
            System.out.println(e.getValue());
        }

        sc.close();
    }

    private static String desdeMayuscula(String apellido) {
        int index =0;
        boolean trobat = false;
        while (!trobat) {
            trobat = Character.isUpperCase(apellido.charAt(index));
            if (!trobat) index++;
        }
        return apellido.substring(index);
    }
}

