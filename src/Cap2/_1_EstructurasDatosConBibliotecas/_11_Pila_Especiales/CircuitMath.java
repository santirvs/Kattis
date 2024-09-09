package Cap2._1_EstructurasDatosConBibliotecas._11_Pila_Especiales;

import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

// Circuit Math
// Calculadora postfija de circuitos lógicos

public class CircuitMath {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numVariables = scan.nextInt();
        scan.nextLine();
        String[] variables = scan.nextLine().split(" ");
        Stack<Boolean> pila = new Stack<>();

        //Leer y recorrer la expresión
        String[] expresion = scan.nextLine().split(" ");
        for (int i=0; i<expresion.length; i++) {
            if (expresion[i].equals("*")) {
                boolean a = pila.pop();
                boolean b = pila.pop();
                pila.push(a && b);
            }
            else if (expresion[i].equals("+")) {
                boolean a = pila.pop();
                boolean b = pila.pop();
                pila.push(a || b);
            }
            else if (expresion[i].equals("-")) {
                boolean a = pila.pop();
                pila.push(!a);
            }
            else {
                pila.push(variables[expresion[i].charAt(0)-'A'].equals("T"));
            }
        }

        //Imprimir el resultado. Quedará en la cima de la pila
        System.out.println(pila.pop() ? "T" : "F");

    }

}
