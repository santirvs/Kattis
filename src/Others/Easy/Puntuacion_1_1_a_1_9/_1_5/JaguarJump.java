package Others.Easy.Puntuacion_1_1_a_1_9._1_5;


/*
    Determinar la posición del Jaguar (J) y del campamento (#)
    durante la lectura de la matriz.
    Calcular la distancia y mirar si es inferior o no a la máxima distancia que
    puede saltar el jaguar
 */

import java.util.Locale;
import java.util.Scanner;

public class JaguarJump {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numColumnas = sc.nextInt();
        int numFilas = sc.nextInt();
        int maxSalto = sc.nextInt();

        sc.nextLine();
        int posX_Jaguar=0;
        int posY_Jaguar=0;
        int posX_Campamento = 0;
        int posY_Campamento = 0;

        //Leer la matriz
        for (int f=0; f<numFilas; f++) {
            String linea = sc.nextLine();
            for (int c=0; c<numColumnas; c++) {
                if (linea.charAt(c) == 'J') {
                    //Jaguar detectado
                    posX_Jaguar = c;
                    posY_Jaguar = f;
                }
                if (linea.charAt(c) == '@') {
                    //Campamento detectado
                    posX_Campamento = c;
                    posY_Campamento = f;
                }
            }
        }

        //Calcular la distancia entre el jaguar y el campamento
        int distX = Math.abs(posX_Campamento-posX_Jaguar);
        int distY = Math.abs(posY_Campamento-posY_Jaguar);
        long distancia = distX*distX + distY*distY;   //Evitamos sqrt para evitar errores

        if (distancia > maxSalto * maxSalto) {
            System.out.println("no jumpscares here");
        } else {
            System.out.println("the guide is right");
        }


    }
}
