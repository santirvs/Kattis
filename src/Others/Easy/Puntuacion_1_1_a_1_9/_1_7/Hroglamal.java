package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

import java.io.IOException;
import java.util.*;


public class Hroglamal {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        //Leer los entradas del diccionario
        int numPalabras = sc.nextInt();
        HashMap<String, String> dicc = new HashMap<>();

        while (numPalabras-- > 0) {
            String palabra = sc.next();
            String traduccion = sc.next();

            dicc.put(palabra, traduccion);
        }

        //Leer las palabras a traducir
        numPalabras = sc.nextInt();
        while (numPalabras-- > 0) {
            String palabra = sc.next();

            //Hay que traducirla?
            if (!contieneCaracterNoTraducible(palabra)) {
                if (dicc.containsKey(palabra)) {
                    palabra = dicc.get(palabra);
                }
                else {
                    palabra = "?" + palabra + "?";
                }
            }

            System.out.println(palabra);
        }

    }

    private static boolean contieneCaracterNoTraducible(String palabra) {

        boolean encontrado = false;
        for (int i=0; i<palabra.length() && !encontrado; i++) {
            if (!Character.isLetter(palabra.charAt(i))) {
                encontrado = true;
            }
        }
        return encontrado;
    }
}

