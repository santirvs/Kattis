package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el texto.
// Eliminar los caracteres repetidos consecutivos

import java.util.Scanner;

public class BiladLyklabord {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el texto
        String texto = sc.nextLine();
        StringBuilder resultado = new StringBuilder();

        // Eliminar los caracteres repetidos consecutivos
        char ultimoChar = '\0'; // Carácter inicial que no existe en el texto
        for (int i = 0; i < texto.length(); i++) {
            char currentChar = texto.charAt(i);
            if (currentChar != ultimoChar) {
                resultado.append(currentChar);
                ultimoChar = currentChar;
            }
        }

        // Mostrar el resultado
        System.out.println(resultado.toString());

        sc.close();
    }
}

