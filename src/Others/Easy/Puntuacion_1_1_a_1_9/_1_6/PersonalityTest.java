package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Contar la frecuencia de respuestas de cada tipo y responder con la de frecuencia más alta
 */

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class PersonalityTest {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numCasos = sc.nextInt();

        while (numCasos-- >0) {
            int[] frecuencia = new int[5];

            //Conteo de frecuencias
            for (int i=0; i<20; i++) {
                int respuesta = sc.nextInt();
                frecuencia[respuesta]++;
            }

            //Determinar la mayor
            int mayor = 0;
            int posMayor = 0;
            for (int i=1; i<=4; i++) {
                if (frecuencia[i] > mayor) {
                    mayor = frecuencia[i];
                    posMayor = i;
                }
            }

            //Imprimir el resultado
            String resultado = "";
            switch(posMayor) {
                case 1 : resultado = "leader"; break;
                case 2 : resultado = "intellectual"; break;
                case 3 : resultado = "social"; break;
                case 4 : resultado = "practical"; break;
            }
            System.out.println(resultado);
        }


        sc.close();
    }
}

