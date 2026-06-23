package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 * Ejercicio simple de tratamiento de cadenas.
 * Seguir las instrucciones del enunciado.
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class HonourThyApaxianParent {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        //Leer los datos
        String nombre = sc.next();
        String ancestro = sc.next();
        String nombreFinal = "";

        //Excepciones
        if (nombre.endsWith("e")) nombreFinal = nombre + "x" + ancestro;
        else if (acabaEnVocal(nombre)) nombreFinal = nombre.substring(0, nombre.length() - 1) + "ex" + ancestro;
        else if (nombre.endsWith("ex")) nombreFinal = nombre + ancestro;
            //Caso general
        else nombreFinal = nombre + "ex" + ancestro;

        //Muestra el resultado
        System.out.println(nombreFinal);

        sc.close();
    }

    private static boolean acabaEnVocal(String nombre) {
        return nombre.endsWith("a") ||
                nombre.endsWith("e") ||
                nombre.endsWith("i") ||
                nombre.endsWith("o") ||
                nombre.endsWith("u");
    }
}

