package Cap2._1_EstructurasDatosConBibliotecas._1_ArraysUnidimensionales_Medios;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Baloni_WA {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer la entrada
        int numBallons = scan.nextInt();
        scan.nextLine();

        //Leer la altura de los globos
        ArrayList<Integer> ballons = new ArrayList<>();
        String[] entrada = scan.nextLine().split(" ");
        for (int i = 0; i < numBallons; i++) {
            ballons.add(Integer.parseInt(entrada[i]));
        }

        //No se pueden ordenar los globos ni se puede fabricar una secuencia
        //de globos con altura decreciente.
        //La idea es disparar siempre al primer globo (no quedará otro remedio) y que sea lo de Dios quiera...
        //El globo de más a la izquierda sólo se puede explotar si se le dispara correctamente.
        int numDisparos = 0;
        while (ballons.size() > 0) {
            numDisparos++;
            int altura = ballons.get(0);
            ArrayList<Integer> explotados = new ArrayList<>();
            for (Integer b: ballons) {
                if (b == altura) {
                    explotados.add(b);
                    altura--;
                }
            }
            //Eliminar los globos explotados
            for (Integer b: explotados) {
                ballons.remove(b);
            }
        }

        //Mostrar el resultado
        System.out.println(numDisparos);

    }
}
