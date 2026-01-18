package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Apilar todos los operadores
// Llamar recursivamente a la función que lee
// Operador
// Parte izquierda
// Parte derecha
// E imprime (izquierda operador derecha)

import java.util.Scanner;
import java.util.Stack;

public class ReversePolishToInfixNotation_Easy {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<String> pila = new Stack<String>();

        //Apilar todos los tokens
        while (sc.hasNext()) {
            pila.push(sc.next());
        }

        String expresion = analizarExpresion(pila);

        System.out.println(expresion);

        sc.close();
    }

    private static String analizarExpresion(Stack<String> pila) {
        String valor = pila.pop();
        if (valor.equals("+") || valor.equals("-") || valor.equals("*") || valor.equals("/")) {
            String derecha = analizarExpresion(pila);
            String izquierda = analizarExpresion(pila);
            return "(" + izquierda + valor + derecha + ")";
        }
        else return valor;
    }


}

