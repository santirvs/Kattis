package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer el viento
// Leer la cantidad de carreteras
// Para cada carretera, leer su nombre y su velocidad máxima de viento
// Para cada carretera, mostrar su nombre y si debe cerrarse (lokud) o no (opid)

import java.util.Scanner;

public class VedurLokadarHeidar {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer velocidad actual del viento
        int currentWind = sc.nextInt();

        // Leer cantidad de carreteras
        int n = sc.nextInt();
        sc.nextLine(); // limpiar el salto de línea

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            // Dividir en nombre de la carretera y velocidad máxima segura
            int lastSpace = line.lastIndexOf(' ');
            String roadName = line.substring(0, lastSpace);
            int safeWind = Integer.parseInt(line.substring(lastSpace + 1));

            if (currentWind > safeWind) {
                System.out.println(roadName + " lokud");
            } else {
                System.out.println(roadName + " opin");
            }
        }

        sc.close();
    }
}

