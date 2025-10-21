package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer toda la entrada
// Leer cada uno de los intervalos (separados por ;)
// Determinar cada intervalo (separado por -)
// Calcular la cantidad de problemas del intervalo
// Añadir a un total
// Mostrar el total

import java.util.Arrays;
import java.util.Scanner;


public class Heimavinna {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer toda la entrada
        String entrada = sc.nextLine();
        String[] intervalos = entrada.split(";");
        int totalProblemas = 0;
        for (String intervalo : intervalos) {
            String[] limites = intervalo.split("-");
            int inicio = Integer.parseInt(limites[0]);
            if (limites.length>1) {
                //Rango
                int fin = Integer.parseInt(limites[1]);
                totalProblemas += (fin - inicio + 1);
            }
            else {
                //Número único
                totalProblemas += 1;

            }
        }
        System.out.println(totalProblemas);


        sc.close();
    }
}

