package Cap1._2_ProblemasAdHoc._4_Juegos_Dificiles;


import java.util.Locale;
import java.util.Scanner;


/**
 * Atención a las coordenadas: la posición 0,0 es la esquina inferior izquierda
 */
public class BattleShip_WA {

     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         int numCasos = scan.nextInt();

         while (numCasos > 0) {
             //Lee los datos
            int ancho = scan.nextInt();
            int alto = scan.nextInt();
            int numDisparos = scan.nextInt();
            scan.nextLine();

            //Declara los tableros
            char[][] tablero1 = new char[alto][ancho];
            char[][] tablero2 = new char[alto][ancho];
            int numBarcos1=0;
            int numBarcos2=0;

            //Lee el tablero1
            for (int i=0; i<alto; i++) {
                String fila = scan.nextLine();
                for (int j = 0; j < ancho; j++) {
                    tablero1[i][j] = fila.charAt(j);
                    if (tablero1[i][j] == '#') {
                        numBarcos1++;
                    }
                }
            }

            //Lee el tablero2
            for (int i=0; i<alto; i++) {
                String fila = scan.nextLine();
                for (int j = 0; j < ancho; j++) {
                    tablero2[i][j] = fila.charAt(j);
                    if (tablero2[i][j] == '#') {
                        numBarcos2++;
                    }
                }
            }

            //Leer los disparos
            boolean turnoJugador1 = true;
            boolean fin = false;

            for (; numDisparos>0 && !fin ; numDisparos--) {
                int x = scan.nextInt();
                //Leer la fila y adaptarla al origen de coordenadas
                int y = (alto-1) - scan.nextInt();

                if (turnoJugador1 && tablero2[y][x] == '#') {
                    numBarcos2--;
                    tablero1[y][x] = '.';
                    if (numBarcos2 == 0) turnoJugador1 = false;
                } else if (turnoJugador1) {
                    turnoJugador1 = false;
                } else if (!turnoJugador1 && tablero1[y][x] == '#') {
                    numBarcos1--;
                    tablero1[y][x] = '.';
                    if (numBarcos1 == 0) fin = true;
                } else if (!turnoJugador1) {
                    turnoJugador1 = true;
                }

                if (turnoJugador1 && numBarcos2 == 0 || numBarcos1 == 0) {
                    fin = true;
                }
            }

            //Imprimir el resultado
            if (numBarcos1 == 0 && numBarcos2 > 0) {
                System.out.println("player two wins");
            } else if (numBarcos2 == 0 && numBarcos1 > 0) {
                System.out.println("player one wins");
            } else {
                System.out.println("draw");
            }

            //Leer los disparos que puedan sobrar
            while (numDisparos>0) {
                scan.nextInt();
                scan.nextInt();
                numDisparos--;
            }

            numCasos--;
         }

     }

}


/**

 #include <iostream>
 #include <cstdio>
 #include <string>
 #include <sstream>
 #include <vector>
 #include <list>
 #include <set>
 #include <map>
 #include <queue>
 #include <stack>
 #include <bitset>
 #include <numeric>
 #include <iterator>
 #include <algorithm>
 #include <cmath>
 #include <chrono>
 #include <cassert>

 using namespace std;
 using ll = long long;
 using ii = pair<int,int>;
 using vi = vector<int>;
 using vb = vector<bool>;
 using vvi = vector<vi>;
 using vii = vector<ii>;
 using vvii = vector<vii>;

 const int INF = 2000000000;
 const ll LLINF = 9000000000000000000;

 int main() {

 int t;
 scanf("%d", &t);
 while (t--) {
 int w, h, n;
 scanf("%d %d %d", &w, &h, &n);

 char board[2][30][30];
 int ships[2];
 ships[0] = ships[1] = 0;
 for (int s = 0; s < 2; ++s) {
 for (int y = h - 1; y >= 0; --y) {
 for (int x = 0; x < w; ++x) {
 char ch;
 scanf(" %c", &ch);
 board[s][x][y] = ch;
 if (ch == '#') ships[s]++;
 }
 }
 }

 bool end = false;
 int turn = 0;
 while (n--) {
 int x, y;
 scanf("%d %d", &x, &y);
 if (end) continue;
 if (board[1 - turn][x][y] == '#') {
 board[1-turn][x][y] = ' ';
 ships[1-turn]--;
 if (ships[1-turn]==0) {
 turn = 1 - turn;
 if (turn == 0) end = true;
 }
 } else {
 turn = 1 - turn;
 if (turn == 0 && ships[0]*ships[1] == 0)
 end = true;
 }
 }

 if (ships[0] == 0 && ships[1] > 0)
 printf("player two wins\n");
 else if (ships[0] > 0  && ships[1] == 0)
 printf("player one wins\n");
 else	printf("draw\n");

 }

 return 0;
 }


 */