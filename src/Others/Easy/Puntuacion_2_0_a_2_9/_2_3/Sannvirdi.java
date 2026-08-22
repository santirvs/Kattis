package Others.Easy.Puntuacion_2_0_a_2_9._2_3;


/*
    Guardar las apuestas en un HashMap<Int,String) y después buscar la floorKey(apuesta)

 */

import java.util.Scanner;
import java.util.TreeMap;

public class Sannvirdi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Leer los participantes y sus apuestas
        int numParticipantes = sc.nextInt();
        TreeMap<Integer, String> participantes = new TreeMap<>();
        participantes.put(-1,"fantasma");  //Límite inferior

        for (int i = 0; i < numParticipantes; i++) {
            String nombre = sc.next();
            int valor = sc.nextInt();

            participantes.put(valor, nombre);
        }

        //Leer los diferentes precios
        int numPrecios = sc.nextInt();
        for (int i = 0; i < numPrecios; i++) {
            int valor = sc.nextInt();

            int ganador = participantes.floorKey(valor);
            if (ganador == -1) {
                System.out.println(":(");
            } else {
                System.out.println(participantes.get(ganador));
            }
        }


    }
}


