package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Un palindromo tiene una frecuencia par para cada letra y, como máximo una impar
 * Eso es lo que tenemos que buscar: dejar todas las frecuencias pares, salvo una como máximo
 */


import java.util.Scanner;

public class Peragrams {

    public static void main(String[] args) {
        // Inicializamos Scanner para leer la entrada estándar
        Scanner sc = new Scanner(System.in);

        //Leer la palabra
        String palabra = sc.nextLine();

        //Contar la frecuencia de aparición de cada carácter
        int[] frecuencia = new int[26];
        for (int i=0; i<palabra.length(); i++) {
            frecuencia[(int)(palabra.charAt(i) - 'a')]++;
        }

        //Revisar la frecuencia de cada caracter
        boolean imparYaUsado = false;
        int numEliminaciones = 0;
        for (int i=0; i<26; i++) {
            if (frecuencia[i] %2 == 0) {
                //Es par! Perfecto, no hacer nada
            } else {
                //Es impar. Solo se acepta 1
                if (imparYaUsado) {
                    numEliminaciones++;  //Quitamos una letra para dejar la frecuencia par
                } else {
                    imparYaUsado = true;  // Gastamos el comodín del impar
                }
            }
        }

        //Mostrar el resultado
        System.out.println(numEliminaciones);
    }
}