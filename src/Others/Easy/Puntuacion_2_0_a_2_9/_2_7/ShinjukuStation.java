package Others.Easy.Puntuacion_2_0_a_2_9._2_7;

/*
    Pasar los tiempos a segundos en dos arrays (uno de llegadas y otro de salidas)
    Calcular el tiempo mínimo >= necesario entre una llegada y una salida
    Como la cantidad de tiempos es reducidos (50) no es necesario ordenación previa

 */

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ShinjukuStation {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numLlegadas = sc.nextInt();
        int numSalidas = sc.nextInt();

        int[] llegadas = new int[numLlegadas];
        int[] salidas = new int[numSalidas];

        for (int i=0; i<numLlegadas; i++) {
            String hora = sc.next();
            llegadas[i] = segundoHora(hora);
        }

        for (int i=0; i<numSalidas; i++) {
            String hora = sc.next();
            salidas[i] = segundoHora(hora);
        }

        int transbordo = sc.nextInt();
        int minTransbordo = Integer.MAX_VALUE;

        for (int llega=0; llega < numLlegadas; llega++) {
            for (int sal=0; sal < numSalidas; sal++) {
                //Actualiza el tiempo mínimo
                if (salidas[sal] >= llegadas[llega] + transbordo) {
                    minTransbordo = Math.min(minTransbordo, salidas[sal] - llegadas[llega]) ;
                }
            }
        }

        if (minTransbordo == Integer.MAX_VALUE)
            System.out.println("-1");
        else
            System.out.println(minTransbordo);

    }

    private static int segundoHora(String hora) {
        String[] partes = hora.split(":");
        int resultado = Integer.parseInt(partes[0])*3600 +Integer.parseInt(partes[1])*60+Integer.parseInt(partes[2]);
        return resultado;
    }
}