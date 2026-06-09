package Others.Easy.Puntuacion_2_0_a_2_9._2_7;

/*
    Recorrer las dos cadenas y comparar los caracteres.
    En el momento en que difieran, avanzar la de salida y apuntar el caracter repetido en un Set.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Keyboardd {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        Set<Character> resultado = new HashSet<>();

        String entrada = sc.nextLine();
        String salida = sc.nextLine();

        int j=0;
        for (int i=0; i<entrada.length(); i++) {
            if (entrada.charAt(i) != salida.charAt(j)) {
                //el caracter j de salida debe estar repetido
                resultado.add(salida.charAt(j));
                i--;
            }
            j++;
        }
        if (j < salida.length()) {
            //Se repite el último caracter
            resultado.add(salida.charAt(j));
        }


        // Salida del resultado
        for (Character c : resultado) {
            System.out.print(c);
        }
        System.out.println();
    }
}