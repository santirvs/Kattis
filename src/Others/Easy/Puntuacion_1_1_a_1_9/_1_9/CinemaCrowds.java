package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

/**
 * Leer los grupos según van llegando
 * Si hay suficientes plazas, restar de las disponibles
 * Si no hay suficientes plazas libres, añadir 1 a los grupos que se van
 * Finalmente, imprimir el contador de grupos rechazados
 */


import java.io.IOException;
import java.util.Scanner;

public class CinemaCrowds {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int capacidad = sc.nextInt();
        int numGrupos = sc.nextInt();
        int numGruposRechazados = 0;

        while (numGrupos-- > 0) {
            int grupo = sc.nextInt();
            if (capacidad >= grupo) capacidad-=grupo;
            else numGruposRechazados++;
        }

        System.out.println(numGruposRechazados);

        sc.close();
    }
}