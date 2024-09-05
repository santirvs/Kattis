package Cap2._1_EstructurasDatosConBibliotecas._7_Ordenacion_Especiales;

import java.util.Locale;
import java.util.Scanner;

/*
Adaptado de https://github.com/mpfeifer1/Kattis/blob/master/gamenight.cpp

************************   RTE en el caso #29 !!!

Falta la explicación del problema

Hay dos permutaciones posibles: ABC y ACB. El resto son equivalentes a una de estas dos por ser cíclicas
Cuenta el número de A, B y C en la cadena
Crea una cadena cíclica duplicando la original
Crea una tabla de prefijos para cada letra
Calcula el número de movimientos para cada permutación posible
Muestra el resultado

 */

public class GameNight_RTE {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

            int n = scan.nextInt();
            char[] s = scan.next().toCharArray();

            int A = 0, B = 0, C = 0;
            for(char c : s) {
                A += (c == 'A'?1:0);
                B += (c == 'B'?1:0);
                C += (c == 'C'?1:0);
            }
            //Conseguir un string cíclico
            s = (new String(s)+new String(s)).toCharArray();
            int[][] prefix = new int[3][n*2];

            for(int let = 0; let < 3; ++let) {
                prefix[let][0] = ((s[0]=='A'+let)?1:0);
            }
            for(int let = 0; let < 3; ++let) {
                for(int i = 1; i < n+n; ++i) {
                    prefix[let][i] = (s[i] == 'A'+let?1:0) + prefix[let][i-1];
                }
            }
            int res = n;
            for(int startA = 0; startA+n <= n+n; ++startA) {
                int startB = startA+A;
                int startC = startB+B;
                int moveA = prefix[0][startA+A-1];
                if(startA-1 >= 0) {
                    moveA -= prefix[0][startA-1];
                }
                moveA = A-moveA;

                int moveB = prefix[1][startB+B-1];
                if(startB-1 >= 0) {
                    moveB -= prefix[1][startB-1];
                }
                moveB = B-moveB;


                int moveC = prefix[2][startC+C-1];
                if(startC-1 >= 0) {
                    moveC -= prefix[2][startC-1];
                }
                moveC = C-moveC;
                res = Math.min(res, moveA+moveB+moveC);
            }

            for(int startA = 0; startA+n <= n+n; ++startA) {
                int startC = startA+A;
                int startB = startC+C;
                int moveA = prefix[0][startA+A-1];
                if(startA-1 >= 0) {
                    moveA -= prefix[0][startA-1];
                }
                moveA = A-moveA;

                int moveB = prefix[1][startB+B-1];
                if(startB-1 >= 0) {
                    moveB -= prefix[1][startB-1];
                }
                moveB = B-moveB;


                int moveC = prefix[2][startC+C-1];
                if(startC-1 >= 0) {
                    moveC -= prefix[2][startC-1];
                }
                moveC = C-moveC;
                res = Math.min(res, moveA+moveB+moveC);
            }

            //Mostrar resultado
        System.out.println(res);
        }


 }

