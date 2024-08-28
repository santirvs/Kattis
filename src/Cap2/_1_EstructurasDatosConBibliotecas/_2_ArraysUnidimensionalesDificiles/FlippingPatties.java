package Cap2._1_EstructurasDatosConBibliotecas._2_ArraysUnidimensionalesDificiles;

import java.util.Locale;
import java.util.Scanner;

public class FlippingPatties {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer la entrada
        int n = scan.nextInt();

        //Definir el array
        int[] horario = new int[50_000];  //43_200 + 600*2 + margen

        //Leer los valores
        for (int i = 0; i < n; i++) {
            int tAsado = scan.nextInt();
            int tServicio = scan.nextInt();
            horario[tServicio]++;
            horario[tServicio-tAsado]++;
            horario[tServicio-2*tAsado]++;
        }

        //Determinar el màximo
        int maximo = 0;
        for (int i = 0; i < horario.length; i++) {
            if (horario[i] > maximo) {
                maximo = horario[i];
            }
        }

        //Imprimir el resultado
        System.out.println(maximo/2 + (maximo%2 == 0? 0 : 1));
    }
}