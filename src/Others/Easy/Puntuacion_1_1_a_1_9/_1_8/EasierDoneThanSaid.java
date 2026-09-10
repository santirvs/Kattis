package Others.Easy.Puntuacion_1_1_a_1_9._1_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class EasierDoneThanSaid {

    // Regla 1: Debe contener al menos una vocal (a, e, i, o, u)
    private static final Pattern HAS_VOWEL = Pattern.compile(".*[aeiou].*");

    // Regla 2: NO puede contener 3 vocales consecutivas O 3 consonantes consecutivas
    // [aeiou]{3} captura 3 vocales seguidas.
    // [^aeiou]{3} captura 3 consonantes seguidas.
    private static final Pattern THREE_CONSECUTIVE = Pattern.compile(".*([aeiou]{3}|[^aeiou]{3}).*");

    // Regla 3: NO puede contener dos letras iguales consecutivas, a excepción de "ee" u "oo"
    // ([a-z])\\1 detecta cualquier par de letras dobles iguales.
    // (?!ee|oo) asegura mediante una inspección negativa (negative lookahead) que el par no sea ni "ee" ni "oo".
    private static final Pattern INVALID_DOUBLE_LETTER = Pattern.compile(".*(?!ee|oo)([a-z])\\1.*");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pwd;

        // Lectura continua hasta encontrar la palabra reservada "end"
        while ((pwd = br.readLine()) != null) {
            pwd = pwd.trim();
            if (pwd.equals("end")) {
                break;
            }

            if (isAcceptable(pwd)) {
                System.out.println("<" + pwd + "> is acceptable.");
            } else {
                System.out.println("<" + pwd + "> is not acceptable.");
            }
        }
    }

    /**
     * Evalúa si una contraseña cumple las 3 condiciones utilizando expresiones regulares.
     */
    private static boolean isAcceptable(String pwd) {
        // 1. Debe tener al menos una vocal
        if (!HAS_VOWEL.matcher(pwd).matches()) {
            return false;
        }

        // 2. No debe tener 3 vocales o 3 consonantes seguidas
        if (THREE_CONSECUTIVE.matcher(pwd).matches()) {
            return false;
        }

        // 3. No debe tener letras dobles prohibidas (diferentes a "ee" u "oo")
        if (INVALID_DOUBLE_LETTER.matcher(pwd).matches()) {
            return false;
        }

        return true;
    }
}