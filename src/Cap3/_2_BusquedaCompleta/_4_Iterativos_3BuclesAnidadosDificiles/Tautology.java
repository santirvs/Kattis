package Cap3._2_BusquedaCompleta._4_Iterativos_3BuclesAnidadosDificiles;

// Fuerza bruta
// Probar todas las combinaciones de valores de verdad para las variables (2^5 = 32 posibles combinaciones)
// Se usa una pila para evaluar las operaciones lógicas

import java.util.*;

public class Tautology {

    static boolean isOperation(char c) {
        return c == 'N' || c == 'K' || c == 'A' || c == 'C' || c == 'E';
    }

    static String fix(String line) {
        // Reemplazar las operaciones lógicas por sus representaciones en notación polaca inversa
        // Se recorre la expresión en sentido inverso y se construye la notación polaca inversa
        Stack<String> S = new Stack<>();
        for (int i = line.length() - 1; i >= 0; --i) {
            String c = String.valueOf(line.charAt(i));
            if (isOperation(c.charAt(0))) {
                if (c.equals("N")) {
                    String top = S.pop();
                    S.push(top + c);
                } else {
                    String a = S.pop();
                    String b = S.pop();
                    S.push(a + b + c);
                }
            } else {
                S.push(c);
            }
        }
        return S.peek();
    }

    static void operate(Stack<Boolean> S, char c) {
        // Operar según el tipo de operación
        if (c == 'N') {
            //NOT:: sacar el top de la pila, negarlo y volver a apilar
            boolean f = S.pop();
            S.push(!f);
        } else if (c == 'K') {
            //AND:: sacar los dos últimos de la pila, hacer AND y volver a apilar
            boolean a = S.pop();
            boolean b = S.pop();
            S.push(a && b);
        } else if (c == 'A') {
            //OR:: sacar los dos últimos de la pila, hacer OR y volver a apilar
            boolean a = S.pop();
            boolean b = S.pop();
            S.push(a || b);
        } else if (c == 'C') {
            // IMPLIES:: sacar los dos últimos de la pila, hacer implicación y volver a apilar
            boolean x = S.pop();
            boolean w = S.pop();
            S.push(!w || x);
        } else if (c == 'E') {
            // EQUIVALENCE:: sacar los dos últimos de la pila, hacer equivalencia y volver a apilar
            boolean x = S.pop();
            boolean w = S.pop();
            S.push((!x) == (!w));
        }
    }

    static boolean eval(String line, int s) {
        // Convertir el entero s a booleanos
        // para asignar los valores a cada una de las 5 variables
        boolean[] B = new boolean[5];
        for (int i = 0; i < 5; ++i) {
            B[i] = (s & 1) == 1;
            s >>= 1;
        }

        Stack<Boolean> S = new Stack<>();
        //Evaluar la expresión
        for (char c : line.toCharArray()) {
            //Si es una operación, operar
            if (isOperation(c)) {
                operate(S, c);
            } else {
                //Si es una variable, recuperar su valor y apilarlo
                boolean val = switch (c) {
                    case 'p' -> B[0];
                    case 'q' -> B[1];
                    case 'r' -> B[2];
                    case 's' -> B[3];
                    default -> B[4]; // 't'
                };
                S.push(val);
            }
        }
        //Devolver el resultado de la expresión (top de la pila)
        return S.peek();
    }

    static boolean tautology(String line) {
        // Probar todas las combinaciones de valores de verdad (2^5 = 32 combinaciones)
        // Si para alguna combinación no se cumple, no es una tautología  (poda)
        for (int i = 0; i < 32; ++i) {
            if (!eval(line, i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String line = scan.nextLine();
            if (line.equals("0")) break;
            line = fix(line);
            System.out.println(tautology(line) ? "tautology" : "not");
        }
    }
}
