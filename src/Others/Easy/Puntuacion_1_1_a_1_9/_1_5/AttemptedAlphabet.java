package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer la frase y determinar qué letras del alfabeto le faltan
// Si no le falta ninguna, mostrar "Good job!"
// Leer la frase
// Crear un array de 26 posiciones booleanas para las letras del alfabeto
// Recorrer la frase y marcar las letras que aparecen
// Al final, comprobar qué letras no han aparecido y mostrarlas

import java.util.Scanner;


public class AttemptedAlphabet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String frase = sc.nextLine().toLowerCase();
        boolean[] letras = new boolean[26];
        for (char c : frase.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                letras[c - 'a'] = true;
            }
        }

        // Comprobar qué letras no han aparecido
        boolean faltan = false;
        for (int i = 0; i < 26; i++) {
            if (!letras[i]) {
                System.out.print((char) (i + 'a'));
                faltan = true;
            }
        }
        if (!faltan) {
            System.out.println("Good job!");
        } else
            System.out.println();

        sc.close();
    }
}

