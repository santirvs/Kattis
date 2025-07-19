package Cap2._2_EstructurasDatosConBibliotecas._9_BigInteger;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;



public class GeneralizedRecursiveFunctions {

    public static BigInteger funcion(int[][] ab, int x, int y, int c, int d, BigInteger[][] resultados) {
        BigInteger result = BigInteger.ZERO;

        if (x<=0 || y<=0 ) {
            //Caso directo
            result = BigInteger.valueOf(d);
        }
        else {
            //Caso recursivo, donde nos guardamos los resultados ya calculados para evitar solapamiento
            result = BigInteger.valueOf(c);
            if (resultados[x][y] == null) {
                for (int i = 0; i < ab[0].length; i++) {
                    BigInteger temp = funcion(ab, x - ab[0][i], y - ab[1][i], c, d, resultados);
                    result = result.add(temp);
                }
                resultados[x][y] = result;
            }
            else result = resultados[x][y];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numCasos = scan.nextInt();
        scan.nextLine();
        int caso = 0;
        while (caso < numCasos) {
            caso++;
            if (caso != 1) System.out.println();

            //Leemos los datos
            String[] linea = scan.nextLine().split(" ");
            int[][] ab = new int[2][(linea.length - 2) / 2];
            int c = Integer.parseInt(linea[linea.length - 2]);
            int d = Integer.parseInt(linea[linea.length - 1]);
            for (int i = 0; i < ab[0].length; i++) {
                ab[0][i] = Integer.parseInt(linea[i * 2]);
                ab[1][i] = Integer.parseInt(linea[i * 2 + 1]);
            }

            linea = scan.nextLine().split(" ");
            int[][] xy = new int[2][linea.length / 2];
            for (int i = 0; i < xy[0].length; i++) {
                xy[0][i] = Integer.parseInt(linea[i * 2]);
                xy[1][i] = Integer.parseInt(linea[i * 2 + 1]);
            }

            //Calcular el resultado

            for (int i = 0; i < xy[0].length; i++) {
                BigInteger[][] resultados = new BigInteger[xy[0][i]+1][xy[1][i]+1];
                for (int k = 0; k < resultados.length; k++) {
                    resultados[k] = new BigInteger[xy[1][i]+1];
                    Arrays.fill(resultados[k],null);
                }
                BigInteger result = funcion(ab, xy[0][i], xy[1][i], c, d, resultados);
                System.out.println(result);
            }

        }
    }

}
