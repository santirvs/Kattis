package Others.Easy.Puntuacion_1_1_a_1_9._1_8;

/**
 * Usar un HashMap<Int, Int> para identificar la posición de preferencia de una canción
 *
 * Comparar mi mapa con el de la otra persona:
 * Para cada canción (de 1 a N)
 *   Para cada cancion (de i+1 a N)
 *     Comparar si coincide la preferencia
 *     Si no coincide incrementar el contador de inversiones
 */


import java.util.*;


public class SongPreferences {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Leer los datos
        int numCanciones = sc.nextInt();

        //Leer mi lista
        Map<Integer,Integer> myList = new HashMap<>();
        for (int i=1; i<=numCanciones; i++) {
            int cancion = sc.nextInt();
            myList.put(cancion, i);
        }

        //Leer el número de personas
        int numPersonas = sc.nextInt();
        while (numPersonas-- > 0) {
            //Leer su lista
            Map<Integer,Integer> hisList = new HashMap<>();
            for (int i=1; i<=numCanciones; i++) {
                int cancion = sc.nextInt();
                hisList.put(cancion, i);
            }

            //Comparar las listas
            int contador = 0;
            for (int i=1; i<=numCanciones; i++) {
                for (int j=i+1; j<=numCanciones; j++) {
                    //Comparar las posiciones de las canciones i, j en ambas listas
                    int posMy_i = myList.get(i);
                    int posMy_j = myList.get(j);
                    int preferida_My = posMy_i < posMy_j ? i : j;

                    int posHis_i = hisList.get(i);
                    int posHis_j = hisList.get(j);
                    int preferida_His = posHis_i < posHis_j ? i : j;

                    if (preferida_His != preferida_My) {
                        contador++;
                    }


                }
            }

            System.out.println(contador);

        }


    }
}

