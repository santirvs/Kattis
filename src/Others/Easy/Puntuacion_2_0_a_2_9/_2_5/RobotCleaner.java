package Others.Easy.Puntuacion_2_0_a_2_9._2_5;


/*
  Controlar en cada movimiento si se ha pasado por las diagonales
  El control de las diagonales se puede controlar con un simple array de booleanos
  Y un contador de celdas pendientes
  Cuando el contador llegue a cero, el robot se detiene
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class RobotCleaner {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        //Leer los datos

        //Tamaño de la habitación
        int tamX = sc.nextInt();
        int tamY = sc.nextInt();

        //Posición inicial del robot
        int posX = sc.nextInt();
        int posY = sc.nextInt();

        //Cantidad de movimientos
        int movs = sc.nextInt();

        //Variables necesarias
        boolean[] diagonal = new boolean[Math.min(tamX, tamY) + 1];
        int suciedadPendiente = Math.min(tamX, tamY);

        //Control de la primera casilla
        if (posY == posX) {
            suciedadPendiente--;
            diagonal[posX] = true;
        }

        //Movimientos
        while (movs-- > 0 && suciedadPendiente > 0) {
            int numCeldas = sc.nextInt();
            String direccion = sc.next();

            switch (direccion) {
                case "up":
                    if (posY <= posX && (posY + numCeldas) >= posX && !diagonal[posX]) {
                        suciedadPendiente--;
                        diagonal[posX] = true;
                    }
                    posY += numCeldas;
                    break;
                case "down":
                    if (posY >= posX && (posY - numCeldas) <= posX && !diagonal[posX]) {
                        suciedadPendiente--;
                        diagonal[posX] = true;
                    }
                    posY -= numCeldas;
                    break;
                case "left":
                    if (posX >= posY && (posX - numCeldas) <= posY && !diagonal[posY]) {
                        suciedadPendiente--;
                        diagonal[posY] = true;
                    }
                    posX -= numCeldas;
                    break;
                case "right":
                    if (posX <= posY && (posX + numCeldas) >= posY && !diagonal[posY]) {
                        suciedadPendiente--;
                        diagonal[posY] = true;
                    }
                    posX += numCeldas;
                    break;
            }

            System.out.println(posX + " " + posY);

        }

    }
}
