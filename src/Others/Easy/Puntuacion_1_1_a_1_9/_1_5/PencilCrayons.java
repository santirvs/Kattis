package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer cantidad de botes y cantidad de lápices por bote
// Para cada bote, calcular el número de lápices de color repetidos
// Acumular las veces que se repiten los colores en los botes
//    -- Usar un HashMap <String, Integer> para contar las repeticiones de cada color
// Imprimir el total de lápices de color repetidos

import java.util.Locale;
import java.util.Scanner;


public class PencilCrayons {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        // Leer número de botes y lápices por bote
        int numBotes = sc.nextInt();
        int lapicesPorBote = sc.nextInt();
        int totalRepetidos = 0;

        //Para cada bote
        for (int i = 0; i < numBotes; i++) {
            // Usar un HashMap para contar colores
            java.util.HashMap<String, Integer> colorCount = new java.util.HashMap<>();
            // Leer colores de lápices en el bote
            for (int j = 0; j < lapicesPorBote; j++) {
                String color = sc.next();
                colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
            }
            // Contar lápices repetidos en el bote actual
            for (int count : colorCount.values()) {
                if (count > 1) {
                    totalRepetidos += (count - 1);
                }
            }
        }

        // Imprimir total de lápices repetidos
        System.out.println(totalRepetidos);

        sc.close();
    }
}

