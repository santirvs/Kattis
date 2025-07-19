package Cap2._2_EstructurasDatosConBibliotecas._5_Ordenacion_Faciles;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class HeightOrdering {

    public static int posicionar(int[] lista, int valor) {
        int i = 0;
        int movs=0;
        while (lista[i] != -1 && lista[i] < valor) {
            i++;
        }
        if (lista[i] == -1) {
            lista[i] = valor;
        } else {
            for (int j = 19; j > i; j--) {
                if (lista[j] != -1) movs++;
                lista[j] = lista[j - 1];
            }
            movs++;
            lista[i] = valor;
        }
        return movs;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numCasos = scan.nextInt();

        while (numCasos > 0) {
            numCasos--;

            //Lectura de datos
            int caso = scan.nextInt();

            //Definir la lista
            int[] lista = new int[20];
            Arrays.fill(lista,-1);

            //Lectura de la lista
            int movs=0;
            for (int i = 0; i < 20; i++) {
                int valor = scan.nextInt();
                movs += posicionar(lista, valor);
            }

            //Mostrar el resultado
            System.out.println(caso + " " + movs);
        }

    }
}