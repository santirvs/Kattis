package Cap2._2_EstructurasDatosConBibliotecas._2_ArraysUnidimensionalesDificiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class PhysicalMusic_TLE {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer la entrada
        int numCasos = scan.nextInt();

        //Tratar los casos
        while (numCasos > 0) {

            //Leer el tamaño del caso
            int n = scan.nextInt();

            //Definir el array de valores
            int[] listaValores = new int[n];
            ArrayList<Integer> listaCDs = new ArrayList<>();

            //Leer los datos
            for (int i=0; i<n; i++) {
                int dato = scan.nextInt();
                listaValores[i] = dato;
            }

            //for every index i, find out if there exist an index j (i < j) where a[i] > a[j] if it exist, then add a[i] to the answer
            for (int i=0; i<n; i++) {
                for (int j=i+1; j<n; j++) {
                    if (listaValores[i] > listaValores[j]) {
                        listaCDs.add(listaValores[i]);
                        break;
                    }
                }
            }

            //Ordenar el resultado
            Collections.sort(listaCDs);

            //Imprimir el resultado
            System.out.println(listaCDs.size());
            for (int i=0; i<listaCDs.size(); i++) {
                System.out.println(listaCDs.get(i));
            }

            numCasos--;
        }



    }
}