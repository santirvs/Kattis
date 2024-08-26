package Cap1._2_ProblemasAdHoc._16_PerderTiempo_Dificiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Froggie {


     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         //Leer la entrada
         int lineas = scan.nextInt();
         int ancho = scan.nextInt();

         int[][] carretera = new int[lineas][ancho];
         int[] intervalos = new int[lineas];
         int[] velocidades = new int[lineas];

         for (int i = 0; i < lineas; i++) {
             carretera[i] = new int[ancho];
             int offset = scan.nextInt();
             int interval = scan.nextInt();
             int velocidad = scan.nextInt();

             if (i % 2 == 0) {
                 //En los carriles pares van de izquierda a derecha
                 for (int pos = offset; pos < ancho; pos += interval) {
                     carretera[i][pos] = 1;
                 }
             } else {
                 //En los carriles impares van de derecha a izquierda
                 for (int pos = ancho-offset-1; pos >= 0; pos -= interval) {
                     carretera[i][pos] = 1;
                 }
             }

             intervalos[i] = interval;
             velocidades[i] = velocidad;
         }

         //Posición inicial de froggie
         int posX = scan.nextInt();
         int posY = lineas;

         //Simular el movimiento de froggie
         char[] movimientos = scan.next().toCharArray();

         for (int i = 0; i < movimientos.length; i++) {

             //Mover froggie
             if (movimientos[i] == 'U') {
                 posY--;
                 if (posY < 0) {
                     System.out.println("safe");
                     return;
                 }
             } else if (movimientos[i] == 'D') {
                 posY++;
                 if (posY == lineas) posY--;
             } else if (movimientos[i] == 'L') {
                 posX--;
                 if (posX < 0) posX++;
             } else if (movimientos[i] == 'R') {
                 posX++;
                 if (posX == ancho) posX--;
             }


             //Comprobar si froggie ha sido alcanzado
             for (int linea = 0; linea < lineas; linea++) {
                 int[] carril = new int[ancho];
                 int direccion = linea % 2 == 0 ? 1 : -1;

                 for (int pos = 0; pos < ancho; pos++) {
                     if (carretera[linea][pos] == 1) {
                         int posFinal = pos + velocidades[linea] * direccion;
                         //Si la velocidad es 0 el coche no se mueve de la posición inicial
                         int posInicial = pos + (velocidades[linea] > 0 ? direccion : 0);
                         int posLeft = Math.min(posInicial, posFinal);
                         int posRight = Math.max(posInicial, posFinal);
                         int posFroggie = posX;
                         //Si la posición de froggie está en el intervalo de la carretera
                         //y estamos en el mismo carril
                         if (posFroggie >= posLeft && posFroggie <= posRight && posY == linea) {
                             System.out.println("squish");
                             return;
                         }

                         //Mover el coche sobre el carril para la siguiente iteración
                         if (posFinal >= 0 && posFinal < ancho) {
                             carril[posFinal] = 1;
                         }

                     }

                 }

                 //Aparecen nuevos coches por la izquierda?
                 if (direccion == 1) {
                     for (int pos = 0; pos < ancho; pos++) {
                         if (carretera[linea][pos] == 1) {
                             if (pos + velocidades[linea] >= intervalos[linea]) {
                                 //Primer coche en la parte izquierda
                                 int posFinal = pos + velocidades[linea] - intervalos[linea];
                                 if (posX <= posFinal && posY == linea) {
                                     System.out.println("squish");
                                     return;
                                 }

                                 //Algun coche más por la parte izquierda?
                                 while (posFinal >= 0) {
                                     if (posFinal < ancho) {
                                         carril[posFinal] = 1;
                                     }
                                     posFinal -= intervalos[linea];
                                 }
                             }
                             break;  //Ya se ha encontrado el de más a la izquierda
                         }
                     }
                 }

                 if (direccion == -1) {
                     for (int pos = ancho-1; pos >=0; pos--) {
                         if (carretera[linea][pos] == 1) {
                             if (pos - velocidades[linea] <= ancho - intervalos[linea]) {
                                 //Primer coche en la parte derecha
                                 int posFinal = pos - velocidades[linea] + intervalos[linea];
                                 if (posX >= posFinal && posY == linea) {
                                     System.out.println("squish");
                                     return;
                                 }

                                 //Algun coche más por la parte derecha?
                                 while (posFinal < ancho) {
                                     if (posFinal >= 0) {
                                         carril[posFinal] = 1;
                                     }
                                     posFinal += intervalos[linea];
                                 }
                             }
                             break;  //Ya se ha encontrado el de más a la derecha
                         }
                     }
                 }

                 //Asignar el nuevo estado del carril
                 carretera[linea] = carril;
             }

         }

         //Se han hecho todos los movimientos y no se ha conseguido salir --> Squish
         System.out.println("squish");

     }
}


