package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el número de casos
// Para cada caso:
// Leer el elemento en un String
// Leer el simbolo
// Comprobar que cada caracter del simbolo está en el String del elemento
// Si todos los caracteres están, imprimir "YES", si no, "NO"

import java.util.Scanner;

public class IntuitiveElements {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Ignorar la longitud del string
        int numCasos = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea después del entero

        // Procesar cada caso
        for (int i = 0; i < numCasos; i++) {
            // Leer el elemento y el símbolo
            String elemento = sc.nextLine();
            String simbolo = sc.nextLine();

            // Comprobar si todos los caracteres del símbolo están en el elemento
            boolean todosPresentes = true;
            for (int j = 0; j < simbolo.length() && todosPresentes; j++) {
                char c = simbolo.charAt(j);
                if (elemento.indexOf(c) == -1) {
                    todosPresentes = false;
                }
            }
            // Imprimir el resultado
            if (todosPresentes) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}

