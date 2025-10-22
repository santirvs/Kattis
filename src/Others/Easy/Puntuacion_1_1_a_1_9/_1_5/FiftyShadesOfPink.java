package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer la cantidad de nombres a tratar
// Para cada nombre, leer el nombre completo y mirar si contiene "pink" (case insensitive) o "rose"
// Contar cuántos nombres cumplen la condición y mostrar el resultado
// Si no hay ninguno, mostrar "I must watch Star Wars with my daughter"

import java.util.Scanner;

public class FiftyShadesOfPink {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la secuencia de puntos
        int n = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea
        int contador = 0;
        // Recorrer los nombres
        for (int i = 0; i < n; i++) {
            String nombre = sc.nextLine().toLowerCase();
            if (nombre.contains("pink") || nombre.contains("rose")) {
                contador++;
            }
        }
        // Mostrar el resultado
        if (contador == 0)
            System.out.println("I must watch Star Wars with my daughter");
        else
            System.out.println(contador);

        sc.close();
    }
}

