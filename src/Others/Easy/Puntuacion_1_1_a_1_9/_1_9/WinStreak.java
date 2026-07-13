package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

/**
 * Leer el resultado y comparar la puntuación local y visitante
 * Si es mayor, se incrementa la racha
 * Sino, se resetea la racha
 * Actualizar la mayor racha
 */


import java.io.IOException;
import java.util.Scanner;

public class WinStreak {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numPartidos = sc.nextInt();
        int rachaVictorias = 0;
        int mayorRachaVictorias = 0;

        while (numPartidos-- > 0) {
            int local = sc.nextInt();
            int visitante = sc.nextInt();

            if (local > visitante) rachaVictorias++;
            else rachaVictorias = 0;

            mayorRachaVictorias = Math.max(mayorRachaVictorias, rachaVictorias);
        }

        System.out.println(mayorRachaVictorias);

    }
}