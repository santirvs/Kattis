package Cap2._2_EstructurasDatosConBibliotecas._2_ArraysUnidimensionalesDificiles;

import java.util.Locale;
import java.util.Scanner;

public class Pivot {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer la entrada
        int longitud = scan.nextInt();
        scan.nextLine();

        //Definir los arrays
        int[] array = new int[longitud];
        int[] maximos = new int[longitud];
        int[] minimos = new int[longitud];

        //Leer los valores y determinar los màximos desde la izquierda
        int maximo = Integer.MIN_VALUE;
        for (int i = 0; i < longitud; i++) {
            array[i] = scan.nextInt();
            if (array[i] > maximo) {
                maximo = array[i];
            }
            maximos[i] = maximo;
        }

        //Determinar los mìnimos desde la derecha
        int minimo = Integer.MAX_VALUE;
        for (int i = longitud - 1; i >= 0; i--) {
            if (array[i] < minimo) {
                minimo = array[i];
            }
            minimos[i] = minimo;
        }

        //Determinar los pivotes
        //Un elemento es pivote si se cumple que es mayor o igual que todos los elementos a su izquierda (maximos[i]
        //y menor o igual que todos los elementos a su derecha (minimos[i])
        int pivotes = 0;
        for (int i = 0; i < longitud; i++) {
            if (array[i] >= maximos[i] && array[i] <= minimos[i]) {
                pivotes++;
            }
        }

        //Imprimir el resultado
        System.out.println(pivotes);

     }
}
