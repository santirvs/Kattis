package Cap2._2_EstructurasDatosConBibliotecas._2_ArraysUnidimensionalesDificiles;

import java.util.*;

public class RockBand_TLE {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer la entrada
        int miembros = scan.nextInt();
        int canciones = scan.nextInt();

        //Definir el array de canciones
        int[][] cancionesPorMiembro = new int[miembros][canciones];

        //Leer las canciones
        for (int i=0; i<miembros; i++) {
            for (int j=0; j<canciones; j++) {
                cancionesPorMiembro[i][j] = scan.nextInt();
            }
        }

        //Buscar el conjunto mínimo de canciones que todos los miembros pueden tocar
        //Tomamos como referencia el primer miembro y verificar si las canciones que toca
        //pueden ser tambien tocadas por los demás miembros
        //A cada iteración añadimos una canción más y comprobamos si todos los miembros pueden tocarla
        boolean todosPuedenTocar = false;
        Set<Integer> concierto = new TreeSet<>();
        for (int j=0; j<canciones && !todosPuedenTocar ; j++) {
            concierto.add(cancionesPorMiembro[0][j]);
            todosPuedenTocar = true;
            for (int i=1; i<miembros && todosPuedenTocar; i++) {
                for (int k=0; k<concierto.size(); k++) {
                    if (!concierto.contains(cancionesPorMiembro[i][k])) {
                        todosPuedenTocar = false;
                    }
                }
            }
        }

        //Imprimir el resultado
        System.out.println(concierto.size());
        for (int i=0; i<concierto.size(); i++) {
            if (i!=0) System.out.print(" ");
            System.out.print(concierto.toArray()[i]);
        }
        System.out.println();


     }
}
