package Cap2._1_EstructurasDatosConBibliotecas._2_ArraysUnidimensionalesDificiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class PhysicalMusic_WA {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer la entrada
        int numCasos = scan.nextInt();

        //Tratar loc casos
        while (numCasos > 0) {

            //Leer el tamaño del caso
            int n = scan.nextInt();

            //Definir el array de valores
            ArrayList<Integer> listaCDs = new ArrayList<>();
            //Leer los datos
            for (int i=1; i<=n; i++) {
                int dato = scan.nextInt();
                if (dato > i) {
                    listaCDs.add(dato);
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