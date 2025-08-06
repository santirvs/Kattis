package Cap3._2_BusquedaCompleta._6_Iterativos_Combinacion;

import java.util.Scanner;

// Probar las diferentes combinaciones de los hasta 2^17 símbolos  (2^17 = 131072, asumible))
// calcular el resultado de la expresión y añadirla a un Set para evitar duplicados.

public class DoublePlusGood {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\+");
        int tamanyo = input.length - 1;

        // Set para almacenar los resultados únicos
        var resultados = new java.util.TreeSet<Long>();

        // Probar todas las combinaciones de los símbolos
        for (int i = 0; i < (1 << tamanyo); i++) {
            StringBuilder expresion = new StringBuilder(input[0]); // Empezar con el primer símbolo
            long resultado = 0;
            for (int j = 0; j <= tamanyo; j++) {

                if ((i & (1 << j)) != 0) {
                    // Si el bit j está activo --> CONCATENAR el siguiente símbolo
                    expresion.append(input[j+1]);
                }
                else {
                    // Si el bit j no está activo --> SUMAR
                    // sumar la expresión actual al resultado y reiniciar la nueva expresión
                    resultado += Long.parseLong(expresion.toString());
                    if (j < tamanyo) {
                        // Si no es el último símbolo, añadir el siguiente símbolo
                        expresion = new StringBuilder(input[j+1]);
                    }
                    else {
                        // Si es el último símbolo, no añadir nada más
                        expresion = new StringBuilder("0");
                    }
                }
            }
            // Añadir el último resultado de la expresión
            resultado += Long.parseLong(expresion.toString());
            // Añadir el resultado al set
            resultados.add(resultado);
            // DEBUG
            //System.out.println("Combinación: " + i + ":: Resultado: " + resultado);
        }


        // Mostrar la cantidad de resultados únicos
        System.out.println(resultados.size());

    }

}
