package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Controlar el emparejamiento con una pila
 * Abrir pareja --> Apilar
 * Cerrar pareja --> Desapilar
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;


public class BracketMatching {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        //Leer los datos
        int longitud = sc.nextInt();
        String s = sc.next();
        boolean esCorrecto = true;
        Stack<Character> pila = new Stack<>();
        for (int i=0; i<longitud && esCorrecto; i++) {
            char c = s.charAt(i);


            if (c=='(' || c=='[' || c=='{') {
                pila.push(c);
            } else {
                if (pila.isEmpty()) {
                    esCorrecto = false;
                    break;
                }
                char c2 = pila.pop();
                esCorrecto = false;
                if ((c == ')' && c2 == '(') || (c == '}' && c2 == '{') || (c == ']' && c2 == '[')) {
                    esCorrecto = true;
                }
            }
        }

        if (esCorrecto && pila.isEmpty()) System.out.println("Valid");
        else System.out.println("Invalid");

        sc.close();
    }
}

