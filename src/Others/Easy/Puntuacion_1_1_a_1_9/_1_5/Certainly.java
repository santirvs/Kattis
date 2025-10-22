package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer una frase y contar cuantas veces aparece la palabra "certainly"
// Mostrar el conteo al final


import java.util.Scanner;


public class Certainly {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer la frase
        String frase = sc.nextLine();
        // Contar las apariciones de "certainly"
        String palabraBuscada = "certainly";
        int contador = 0;
        int indice = 0;
        while ((indice = frase.indexOf(palabraBuscada, indice)) != -1) {
            contador++;
            indice += palabraBuscada.length();
        }
        // Mostrar el resultado
        System.out.println(contador);


        sc.close();
    }
}

