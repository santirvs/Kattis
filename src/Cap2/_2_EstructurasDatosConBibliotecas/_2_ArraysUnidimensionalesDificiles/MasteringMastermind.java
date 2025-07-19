package Cap2._2_EstructurasDatosConBibliotecas._2_ArraysUnidimensionalesDificiles;

import java.util.Locale;
import java.util.Scanner;

public class MasteringMastermind {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

       //Leer la entrada
        int longitud = scan.nextInt();

        char[] codigo  = scan.next().toCharArray();
        char[] intento = scan.next().toCharArray();

        //Contar las coincidencias exactas
        int coincidenciasExactas = 0;
        for (int i = 0; i < longitud; i++) {
            if (codigo[i] == intento[i]) {
                coincidenciasExactas++;
                //Marcar las coincidencias para no contarlas dos veces
                codigo[i] = '.';
                intento[i] = ' ';
            }
        }


        //Contar las coincidencias parciales
        int coincidenciasParciales = 0;
        for (int i = 0; i < longitud; i++) {
            if (codigo[i] != '.') {
                for (int j = 0; j < longitud; j++) {
                    if (codigo[i] == intento[j]) {
                        coincidenciasParciales++;
                        //Marcar las coincidencias para no contarlas dos veces
                        intento[j] = ' ';
                        break;
                    }
                }
            }
        }


        //Imprimir el resultado
        System.out.println(coincidenciasExactas + " " + coincidenciasParciales);
  }
}
