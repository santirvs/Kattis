package Cap2._1_EstructurasDatosConBibliotecas._7_Ordenacion_Especiales;

import java.util.Locale;
import java.util.Scanner;


public class Excursion {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        char[] linea = scan.nextLine().toCharArray();
        //tabla de frecuencias
        int[] frecuencias = new int[3];

        //Procesar la línea.
        for (int i=0; i<linea.length; i++) {
            frecuencias[linea[i]-'0']++;
        }

        //Calcular el número de swaps para colocar los ceros al principio
        long swaps = 0;
        for (int i=0; i<linea.length; i++) {
            if (linea[i] == '0')
                frecuencias[0]--;
            else {
                //Habrá tantos swaps como ceros haya tras esta posición
                swaps += frecuencias[0];
                if (linea[i] == '1') {
                    frecuencias[1]--;
                } else if (linea[i] == '2') {
                    //Habrá tantos swaps como unos haya tras esta posición
                    swaps += frecuencias[1];
                }
            }
        }

        //Imprimir el resultado
        System.out.println(swaps);
    }
}

