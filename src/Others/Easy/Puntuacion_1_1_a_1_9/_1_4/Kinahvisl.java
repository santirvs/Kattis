package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer la palabra inicial y la final
// Revisar letra a letra y contar las que cambian
// Añadir 1 para el primer niño
// Mostrar el resultado

import java.util.Scanner;

public class Kinahvisl {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer las palabras
        String palabraInicial = sc.nextLine();
        String palabraFinal = sc.nextLine();

        //Recorrer ambas palabras (de la misma longitud) y contar las diferencias
        int numNinyos = 1;
        for (int i=0; i<palabraInicial.length(); i++) {
            if (palabraInicial.charAt(i)!=palabraFinal.charAt(i)) {
                numNinyos++;
            }
        }

        //Mostrar el resultado
        System.out.println(numNinyos);

        sc.close();
    }
}

