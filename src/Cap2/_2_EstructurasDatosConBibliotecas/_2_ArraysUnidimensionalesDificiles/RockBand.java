package Cap2._2_EstructurasDatosConBibliotecas._2_ArraysUnidimensionalesDificiles;

import java.util.*;

public class RockBand {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        int miembros = scan.nextInt();
        int canciones = scan.nextInt();

        int[][] cancionesPorMiembro = new int[miembros][canciones];

        //Leer las preferencias de cada miembro
        for (int i = 0; i < miembros; i++) {
            for (int j = 0; j < canciones; j++) {
                cancionesPorMiembro[i][j] = scan.nextInt();
            }
        }

        int resolved = 0;
        int[] concierto = new int[canciones + 1];

        for (int i = 0; i < canciones; i++) {
            // Add the next song to the set list
            for (int j = 0; j < miembros; j++) {
                concierto[cancionesPorMiembro[j][i]]++;
                if (concierto[cancionesPorMiembro[j][i]] == miembros) {
                    resolved++;
                }
            }
            if (resolved == i + 1) {
                break;
            }
        }

        int[] respuesta = new int[resolved];
        for (int i = 0; i < resolved; i++) {
            respuesta[i] = cancionesPorMiembro[0][i];
        }
        Arrays.sort(respuesta);

        System.out.println(respuesta.length);
        for (int i = 0; i < respuesta.length; i++) {
            if (i != 0) System.out.print(" ");
            System.out.print(respuesta[i]);
        }
        System.out.println();
    }

}



