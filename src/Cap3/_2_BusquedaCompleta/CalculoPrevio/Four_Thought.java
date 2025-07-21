package Cap3._2_BusquedaCompleta.CalculoPrevio;

import java.util.Map;
import java.util.Scanner;

// Calcular todas las combinaciones posibles de operaciones con 4 cuatros
// Mapear los resultados
// Buscar si existe solución para un número dado

public class Four_Thought {

    //Ejecutar en modo generación o ejecución
    public static void main(String[] args) {
        //main_generate(args);
        main_execute(args);
    }


    private static int realizarOperacion(int num1, int num2, char operador) {
        switch (operador) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Operador invalido");
        }
    }

    public static int resultado(int[] result, char[] operadores) {
        // Realizar las operaciones, teniendo en cuenta la precedencia de los operadores

        // Buscar multiplicaciones o divisiones
        while (operadores.length > 0) {
            boolean trobat = false; // Para controlar si se ha encontrado una multiplicación o división
            for (int i = 0; i < operadores.length && !trobat; i++) {
                if (operadores[i] == '*' || operadores[i] == '/') {
                    result[i] = realizarOperacion(result[i], result[i + 1], operadores[i]);
                    // Eliminar el siguiente elemento ya que se ha realizado la operación
                    for (int j = i + 1; j < result.length - 1; j++) {
                        result[j] = result[j + 1];
                    }
                    // Eliminar el operador correspondiente
                    for (int j = i; j < operadores.length - 1; j++) {
                        operadores[j] = operadores[j + 1];
                    }
                    operadores = java.util.Arrays.copyOf(operadores, operadores.length - 1);
                    result = java.util.Arrays.copyOf(result, result.length - 1);
                    trobat = true; // Volver a empezar el bucle para evitar errores de índice
                }
            }
            //No hay multiplicaciones ni divisiones, así que se pueden realizar las sumas y restas
            if (!trobat) {
                result[0] = realizarOperacion(result[0], result[1], operadores[0]);
                // Eliminar el siguiente elemento ya que se ha realizado la operación
                for (int j = 1; j < result.length - 1; j++) {
                    result[j] = result[j + 1];
                }
                // Eliminar el operador correspondiente
                for (int j = 0; j < operadores.length - 1; j++) {
                    operadores[j] = operadores[j + 1];
                }
                operadores = java.util.Arrays.copyOf(operadores, operadores.length - 1);
                result = java.util.Arrays.copyOf(result, result.length - 1);
            }

        }
        //Devuelve el resultado final
        return result[0];
    }

// Generar las operaciones y resultados posibles con 4 cuatros
    public static void main_generate(String[] args) {

        char[] operators = {'+','-','*','/'};


        // test
/*
        int test = resultado(new int[]{4, 4, 4, 4}, new char[]{'/', '/', '/'});
        System.out.printf("4 / 4 / 4 / 4 = %d\n", test);
        System.exit(0);
*/

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    try {
                        int res = resultado(new int[]{4, 4, 4, 4}, new char[]{operators[i], operators[j], operators[k]});
                        // Imprimir todas las combinaciones de operaciones con 4 cuatros
                        //System.out.printf("4 %c 4 %c 4 %c 4 = %d\n", operators[i], operators[j], operators[k], res);

                        System.out.printf("resultados.putIfAbsent(%d, \"4 %c 4 %c 4 %c 4 = %d\");\n", res, operators[i], operators[j], operators[k], res);
                    }
                    catch (Exception e) {
                        // Ignorar las combinaciones que no son válidas como una división por cero
                    }
                }
            }
        }
    }


    public static void main_execute(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCasos = scanner.nextInt();
        Map<Integer, String> resultados = new java.util.HashMap<>();
        rellenarResultados(resultados);

        while (numCasos-- > 0) {
            int num = scanner.nextInt();
            if (resultados.containsKey(num)) {
                System.out.println(resultados.get(num));
            }
            else {
                System.out.println("no solution");
            }

        }
    }

    private static void rellenarResultados(Map<Integer, String> resultados) {
        resultados.putIfAbsent(16, "4 + 4 + 4 + 4 = 16");
        resultados.putIfAbsent(8, "4 + 4 + 4 - 4 = 8");
        resultados.putIfAbsent(24, "4 + 4 + 4 * 4 = 24");
        resultados.putIfAbsent(9, "4 + 4 + 4 / 4 = 9");
        resultados.putIfAbsent(8, "4 + 4 - 4 + 4 = 8");
        resultados.putIfAbsent(0, "4 + 4 - 4 - 4 = 0");
        resultados.putIfAbsent(-8, "4 + 4 - 4 * 4 = -8");
        resultados.putIfAbsent(7, "4 + 4 - 4 / 4 = 7");
        resultados.putIfAbsent(24, "4 + 4 * 4 + 4 = 24");
        resultados.putIfAbsent(16, "4 + 4 * 4 - 4 = 16");
        resultados.putIfAbsent(68, "4 + 4 * 4 * 4 = 68");
        resultados.putIfAbsent(8, "4 + 4 * 4 / 4 = 8");
        resultados.putIfAbsent(9, "4 + 4 / 4 + 4 = 9");
        resultados.putIfAbsent(1, "4 + 4 / 4 - 4 = 1");
        resultados.putIfAbsent(8, "4 + 4 / 4 * 4 = 8");
        resultados.putIfAbsent(4, "4 + 4 / 4 / 4 = 4");
        resultados.putIfAbsent(8, "4 - 4 + 4 + 4 = 8");
        resultados.putIfAbsent(0, "4 - 4 + 4 - 4 = 0");
        resultados.putIfAbsent(16, "4 - 4 + 4 * 4 = 16");
        resultados.putIfAbsent(1, "4 - 4 + 4 / 4 = 1");
        resultados.putIfAbsent(0, "4 - 4 - 4 + 4 = 0");
        resultados.putIfAbsent(-8, "4 - 4 - 4 - 4 = -8");
        resultados.putIfAbsent(-16, "4 - 4 - 4 * 4 = -16");
        resultados.putIfAbsent(-1, "4 - 4 - 4 / 4 = -1");
        resultados.putIfAbsent(-8, "4 - 4 * 4 + 4 = -8");
        resultados.putIfAbsent(-16, "4 - 4 * 4 - 4 = -16");
        resultados.putIfAbsent(-60, "4 - 4 * 4 * 4 = -60");
        resultados.putIfAbsent(0, "4 - 4 * 4 / 4 = 0");
        resultados.putIfAbsent(7, "4 - 4 / 4 + 4 = 7");
        resultados.putIfAbsent(-1, "4 - 4 / 4 - 4 = -1");
        resultados.putIfAbsent(0, "4 - 4 / 4 * 4 = 0");
        resultados.putIfAbsent(4, "4 - 4 / 4 / 4 = 4");
        resultados.putIfAbsent(24, "4 * 4 + 4 + 4 = 24");
        resultados.putIfAbsent(16, "4 * 4 + 4 - 4 = 16");
        resultados.putIfAbsent(32, "4 * 4 + 4 * 4 = 32");
        resultados.putIfAbsent(17, "4 * 4 + 4 / 4 = 17");
        resultados.putIfAbsent(16, "4 * 4 - 4 + 4 = 16");
        resultados.putIfAbsent(8, "4 * 4 - 4 - 4 = 8");
        resultados.putIfAbsent(0, "4 * 4 - 4 * 4 = 0");
        resultados.putIfAbsent(15, "4 * 4 - 4 / 4 = 15");
        resultados.putIfAbsent(68, "4 * 4 * 4 + 4 = 68");
        resultados.putIfAbsent(60, "4 * 4 * 4 - 4 = 60");
        resultados.putIfAbsent(256, "4 * 4 * 4 * 4 = 256");
        resultados.putIfAbsent(16, "4 * 4 * 4 / 4 = 16");
        resultados.putIfAbsent(8, "4 * 4 / 4 + 4 = 8");
        resultados.putIfAbsent(0, "4 * 4 / 4 - 4 = 0");
        resultados.putIfAbsent(16, "4 * 4 / 4 * 4 = 16");
        resultados.putIfAbsent(1, "4 * 4 / 4 / 4 = 1");
        resultados.putIfAbsent(9, "4 / 4 + 4 + 4 = 9");
        resultados.putIfAbsent(1, "4 / 4 + 4 - 4 = 1");
        resultados.putIfAbsent(17, "4 / 4 + 4 * 4 = 17");
        resultados.putIfAbsent(2, "4 / 4 + 4 / 4 = 2");
        resultados.putIfAbsent(1, "4 / 4 - 4 + 4 = 1");
        resultados.putIfAbsent(-7, "4 / 4 - 4 - 4 = -7");
        resultados.putIfAbsent(-15, "4 / 4 - 4 * 4 = -15");
        resultados.putIfAbsent(0, "4 / 4 - 4 / 4 = 0");
        resultados.putIfAbsent(8, "4 / 4 * 4 + 4 = 8");
        resultados.putIfAbsent(0, "4 / 4 * 4 - 4 = 0");
        resultados.putIfAbsent(16, "4 / 4 * 4 * 4 = 16");
        resultados.putIfAbsent(1, "4 / 4 * 4 / 4 = 1");
        resultados.putIfAbsent(4, "4 / 4 / 4 + 4 = 4");
        resultados.putIfAbsent(-4, "4 / 4 / 4 - 4 = -4");
        resultados.putIfAbsent(0, "4 / 4 / 4 * 4 = 0");
        resultados.putIfAbsent(0, "4 / 4 / 4 / 4 = 0");
    }
}




/*
4 + 4 + 4 + 4 = 16
4 + 4 + 4 - 4 = 8
4 + 4 + 4 * 4 = 24
4 + 4 + 4 / 4 = 9
4 + 4 - 4 + 4 = 8
4 + 4 - 4 - 4 = 0
4 + 4 - 4 * 4 = -8
4 + 4 - 4 / 4 = 7
4 + 4 * 4 + 4 = 24
4 + 4 * 4 - 4 = 16
4 + 4 * 4 * 4 = 68
4 + 4 * 4 / 4 = 8
4 + 4 / 4 + 4 = 9
4 + 4 / 4 - 4 = 1
4 + 4 / 4 * 4 = 8
4 + 4 / 4 / 4 = 4
4 - 4 + 4 + 4 = 8
4 - 4 + 4 - 4 = 0
4 - 4 + 4 * 4 = 16
4 - 4 + 4 / 4 = 1
4 - 4 - 4 + 4 = 0
4 - 4 - 4 - 4 = -8
4 - 4 - 4 * 4 = -16
4 - 4 - 4 / 4 = -1
4 - 4 * 4 + 4 = -8
4 - 4 * 4 - 4 = -16
4 - 4 * 4 * 4 = -60
4 - 4 * 4 / 4 = 0
4 - 4 / 4 + 4 = 7
4 - 4 / 4 - 4 = -1
4 - 4 / 4 * 4 = 0
4 - 4 / 4 / 4 = 4
4 * 4 + 4 + 4 = 24
4 * 4 + 4 - 4 = 16
4 * 4 + 4 * 4 = 32
4 * 4 + 4 / 4 = 17
4 * 4 - 4 + 4 = 16
4 * 4 - 4 - 4 = 8
4 * 4 - 4 * 4 = 0
4 * 4 - 4 / 4 = 15
4 * 4 * 4 + 4 = 68
4 * 4 * 4 - 4 = 60
4 * 4 * 4 * 4 = 256
4 * 4 * 4 / 4 = 16
4 * 4 / 4 + 4 = 8
4 * 4 / 4 - 4 = 0
4 * 4 / 4 * 4 = 16
4 * 4 / 4 / 4 = 1
4 / 4 + 4 + 4 = 9
4 / 4 + 4 - 4 = 1
4 / 4 + 4 * 4 = 17
4 / 4 + 4 / 4 = 2
4 / 4 - 4 + 4 = 1
4 / 4 - 4 - 4 = -7
4 / 4 - 4 * 4 = -15
4 / 4 - 4 / 4 = 0
4 / 4 * 4 + 4 = 8
4 / 4 * 4 - 4 = 0
4 / 4 * 4 * 4 = 16
4 / 4 * 4 / 4 = 1
4 / 4 / 4 + 4 = 4
4 / 4 / 4 - 4 = -4
4 / 4 / 4 * 4 = 0
4 / 4 / 4 / 4 = 0
 */
