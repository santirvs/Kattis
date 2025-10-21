package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Podemos ignorar el número de palabras del número inicial
// Leer la segunda línia y hacer un split por espacios
// Para cada palabra, si empieza por Mayúscula, añadirla al resultado
// Al final, mostrar el resultado

import java.util.Scanner;


public class Skammstofun {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Ignorar la primera línea
        sc.nextLine();
        // Leer la segunda línea
        String linea = sc.nextLine();
        String[] palabras = linea.split(" ");
        StringBuilder resultado = new StringBuilder();
        // Procesar las palabras
        for (String palabra : palabras) {
            if (Character.isUpperCase(palabra.charAt(0))) {
                resultado.append(palabra.charAt(0));
            }
        }
        // Mostrar el resultado
        System.out.println(resultado.toString().trim());

        sc.close();
    }
}

