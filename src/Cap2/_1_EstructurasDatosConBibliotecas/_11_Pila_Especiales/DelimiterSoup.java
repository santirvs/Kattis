package Cap2._1_EstructurasDatosConBibliotecas._11_Pila_Especiales;

import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

// Emparejamiento de delimitadores

public class DelimiterSoup {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        scan.nextLine(); //Puedo ignorar la longitud de la entrada
        char[] entrada = scan.nextLine().toCharArray();
        Stack<Character> pila = new Stack<>();
        boolean error = false;
        //Leer y recorrer la expresión
        for (int i=0; i<entrada.length && !error; i++) {
            //Consulto el carácter en la cima de la pila (en caso que esté vacía uso '#')
            char caracterPila = pila.isEmpty() ? '#' : pila.peek();
            char caracterActual = entrada[i];
            if (caracterActual == '(' || caracterActual == '[' || caracterActual == '{') {
                pila.push(caracterActual);
            }
            else if (caracterActual == ')' && caracterPila != '(') {
                System.out.println("" + caracterActual + " " + i);
                error = true;
            }
            else if (caracterActual == ']' && caracterPila != '[') {
                System.out.println("" + caracterActual + " " + i);
                error = true;
            }
            else if (caracterActual == '}' && caracterPila != '{') {
                System.out.println("" + caracterActual + " " + i);
                error = true;
            }
            //Si llega aquí es que ha ido correctamente
            if (!pila.isEmpty() && (caracterActual == ')' || caracterActual == ']' || caracterActual == '}')) {
                pila.pop();
            }
        }

        //Si ha ido bien, se imprime el mensaje de ok
        if (!error)
            System.out.println("ok so far");

    }

}
