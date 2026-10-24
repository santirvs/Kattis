package Others.Easy.Puntuacion_2_0_a_2_9._2_1;

// Usar dos diccionarios donde cada entrada debe ser única y no vacía

import java.util.HashMap;
import java.util.Scanner;

public class GandalfSpell {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        char[] palabra = scan.nextLine().toCharArray();
        String[] frase = scan.nextLine().split(" ");

        HashMap<Character, String> dicc_C2S = new HashMap<>();
        HashMap<String, Character> dicc_S2C = new HashMap<>();

        //Verificar que tienen la misma longitud
        if (palabra.length != frase.length) {
            System.out.println("False");
        } else {
            boolean correcto = true;
            for (int i=0; i<palabra.length && correcto; i++) {
                if (dicc_C2S.containsKey(palabra[i]) && !dicc_C2S.get(palabra[i]).equals(frase[i])) {
                    //El diccionario C2S ya contiene la palabra pero no es la misma
                    correcto = false;
                }
                if (dicc_S2C.containsKey(frase[i]) && dicc_S2C.get(frase[i]) != palabra[i]) {
                    //El diccionario S2C ya contiene la palabra pero no es la misma
                    correcto = false;
                }
                if (correcto) {
                    //Si sigue correcto, se añaden las entradas a los diccionarios
                    dicc_C2S.put(palabra[i], frase[i]);
                    dicc_S2C.put(frase[i], palabra[i]);
                }
            }

            if (correcto) System.out.println("True");
            else System.out.println("False");
        }

    }
}
