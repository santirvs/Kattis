package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 * Suma de dos números que contienen espacios entre sus cifras
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class CodeToSaveLives {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        //Leer el número de casos
        int numCasos = sc.nextInt();
        sc.nextLine();

        while (numCasos-- > 0) {
            long num1 = Integer.parseInt(sc.nextLine().replace(" ",""));
            long num2 = Integer.parseInt(sc.nextLine().replace(" ",""));

            long result = num1+num2;
            String resultadoString = "" + result;

            //Insertar espacios entre las cifras
            char[] resultadoEspaciado = new char[2*resultadoString.length()-1];
            for (int i=0; i<resultadoString.length();i++) {
                if (i!=0) {
                    resultadoEspaciado[2*i-1] = ' ';
                }
                resultadoEspaciado[2*i] = resultadoString.charAt(i);
            }

            //Mostrar el resultado espaciado
            System.out.println(resultadoEspaciado);

        }

    }
}

