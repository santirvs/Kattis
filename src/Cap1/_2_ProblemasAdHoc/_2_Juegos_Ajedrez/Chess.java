package Cap1._2_ProblemasAdHoc._2_Juegos_Ajedrez;

import java.util.Locale;
import java.util.Scanner;

public class Chess {


    public static boolean enTablero(char fila, int columna) {
        return fila >= 'A' && fila <= 'H' && columna >= 1 && columna <= 8;
    }


     public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer número de casos
         int numCasos = scan.nextInt();

         while (numCasos > 0) {
             numCasos--;

             //Leer las coordenadas
             String filaIni = scan.next();
             int colIni = scan.nextInt();
             String filaFin = scan.next();
             int colFin = scan.nextInt();

            //Calcular la distancia
            int distFila = Math.abs(filaIni.charAt(0) - filaFin.charAt(0));
            int distCol = Math.abs(colIni - colFin);

            //Calcular la diagonal
             int diagonal1 = filaIni.charAt(0) - 'A' + colIni;
             int diagonal2 = filaFin.charAt(0) - 'A' + colFin;


             //Si las diagonales son de distinta paridad, no se puede llegar
             if (diagonal1 % 2 != diagonal2 % 2) {
                 System.out.println("Impossible");
             } else {
                    //0 movimientos, ya estamos en la casilla final
                    if (filaIni.equals(filaFin) && colIni == colFin) {
                        System.out.println("0 " + filaFin + " " + colFin);
                    } else if (distFila == distCol) {
                        //Estamos en la misma diagonal, sólo hay que moverse a la casilla final
                        System.out.println("1 " + filaIni + " " + colIni + " " + filaFin + " " + colFin);
                    } else {
                        //Hay que llegar a la misma diagonal para luego alcanzar la casilla final
                        int dist1 = Math.max(distFila, distCol);
                        int dist2 = Math.min(distFila, distCol);

                        //Puedo llegar a la diagonal o bien por la fila o bien por la columna, y hacia arriba o hacia abajo
                        char fila = 0;
                        int columna = 0;

                        boolean diagonalAlcanzada = false;
                        for (int i=0; i<4 && !diagonalAlcanzada; i++) {
                            fila = filaIni.charAt(0);
                            columna = colIni;
                            int filaDelta=0;
                            int colDelta=0;
                            switch (i) {
                                case 0: filaDelta=1; colDelta=1; break;
                                case 1: filaDelta=1; colDelta=-1; break;
                                case 2: filaDelta=-1; colDelta=1; break;
                                case 3: filaDelta=-1; colDelta=-1; break;
                            }

                            boolean dentro = true;
                            while (!diagonalAlcanzada && dentro) {
                                fila+=filaDelta;
                                columna+=colDelta;

                                dentro = enTablero(fila, columna);
                                if (dentro) {
                                    int distFilaInt = Math.abs(fila - filaFin.charAt(0));
                                    int distColInt = Math.abs(columna - colFin);
                                    if (distFilaInt == distColInt) {
                                        diagonalAlcanzada = true;
                                    }
                                }
                            }

                        }


                        System.out.println("2 " + filaIni + " " + colIni + " " + fila + " " + columna + " " + filaFin + " " + colFin);

                    }
             }
         }
    }
}



