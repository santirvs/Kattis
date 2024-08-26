package Cap2._1_EstructurasDatosConBibliotecas._1_ArraysUnidimensionales_Medios;

import java.util.Locale;
import java.util.Scanner;

public class Baloni {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Crear un histograma de frecuencias
        //La idea es contabilizar a qué altura llegan las flechas al final
        //por lo que si hay un globo a una altura x, la flecha llegará a la altura x-1
        //y si ya había una flecha a esa altura, no será necesaria una nueva flecha
        int[] frecuencias = new int[1000001];

        //Leer la entrada
        int numBallons = scan.nextInt();
        scan.nextLine();

        //Leer la altura de los globos
        String[] entrada = scan.nextLine().split(" ");
        for (int i = 0; i < numBallons; i++) {
            int altura = Integer.parseInt(entrada[i]);
            //La flecha que haga explotar este globo bajará un nivel
            frecuencias[altura-1]++;
            //Pero si ya había una flecha este nivel, la flecha no es necesaria
            if (frecuencias[altura] != 0) {
                frecuencias[altura]--;
            }
        }

        //Contar el número de flechas necesarias
        int numDisparos = 0;
        for (int i=0; i<frecuencias.length; i++) {
            if (frecuencias[i] != 0) {
                numDisparos += frecuencias[i];
            }
        }


        //Mostrar el resultado
        System.out.println(numDisparos);

    }
}
