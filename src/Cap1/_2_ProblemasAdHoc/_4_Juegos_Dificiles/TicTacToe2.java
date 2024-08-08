package Cap1._2_ProblemasAdHoc._4_Juegos_Dificiles;


import java.util.Locale;
import java.util.Scanner;

public class TicTacToe2 {

    public static int ganador(char[][] tablero, char simbolo) {
        int numGanador = 0;
        //Comprueba las filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == simbolo && tablero[i][1] == simbolo && tablero[i][2] == simbolo) {
                numGanador++;
            }
        }
        //Comprueba las columnas
        for (int i = 0; i < 3; i++) {
            if (tablero[0][i] == simbolo && tablero[1][i] == simbolo && tablero[2][i] == simbolo) {
                numGanador++;
            }
        }
        //Comprueba las diagonales
        if (tablero[0][0] == simbolo && tablero[1][1] == simbolo && tablero[2][2] == simbolo) {
            numGanador++;
        }
        if (tablero[0][2] == simbolo && tablero[1][1] == simbolo && tablero[2][0] == simbolo) {
            numGanador++;
        }
        return numGanador;
    }
     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         int numCasos = scan.nextInt();

         while (numCasos > 0) {
             scan.nextLine();
             int numX = 0;
             int numO = 0;
             char tablero[][] = new char[3][3];
             for (int i = 0; i < 3; i++) {
                 String linea = scan.nextLine();
                 for (int j = 0; j < 3; j++) {
                     tablero[i][j] = linea.charAt(j);
                     if (tablero[i][j] == 'X') {
                         numX++;
                     } else if (tablero[i][j] == 'O') {
                         numO++;
                     }
                 }
             }


             //numX y numO deben ser iguales o numO debe ser uno menos que numX
             if (numX - numO > 1 || numO > numX) {
                 System.out.println("no");
             } else {
                 int numGanX = ganador(tablero, 'X');
                 int numGanO = ganador(tablero, 'O');

                 //Las X sí que podrían formar más de una combinación ganadora
                 //Las Os nunca podrían formarla
                 //Tampoco puede ser que ganen los dos
                 if (numGanO > 1 || (numGanX == 1 && numGanO == 1))
                     System.out.println("no");
                 //Si ganan las O, deben tener el mismo número de O que de X
                 else if (numGanO == 1 && numGanX == 0 && numX != numO) {
                     System.out.println("no");
                 }
                 // Si ganan las X, deben tener un X más que O
                 else if (numGanX == 1 && numGanO == 0 && numX != numO + 1) {
                     System.out.println("no");
                 }
                 //Si no se da ninguna de las condiciones anteriores, es correcto
                 else
                     System.out.println("yes");
             }

             numCasos--;
         }


     }

}
