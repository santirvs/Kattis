package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el número de concursantes
// Para cada concursante:
//   Leer el nombre (ignorar)
//   Leer su ubicación
//   Mantener el contador de la ubicación mediante un Mapa  String -> Int
// Finalmente, mostrar las entradas del Mapa

import java.util.*;

public class Akureyri {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la cantidad de concursantes
        int numConcursantes = sc.nextInt();
        sc.nextLine();

        //Declarar el mapa String, Int
        Map<String, Integer> mapa = new HashMap<>();

        //Leer los concursantes
        for (int i=0; i<numConcursantes; i++) {
            sc.nextLine();  //Ignorar el nombre
            String localidad = sc.nextLine();

            //Añadir la localidad si no existe ya, si existe se incrementa en uno
            if (mapa.containsKey(localidad)) {
                mapa.put(localidad, mapa.get(localidad) + 1);
            }
            else {
                mapa.put(localidad, 1);
            }

        }

        //Mostrar las localidades
        for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


        sc.close();
    }
}

