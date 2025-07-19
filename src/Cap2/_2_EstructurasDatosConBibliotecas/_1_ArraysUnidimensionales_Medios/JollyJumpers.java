package Cap2._2_EstructurasDatosConBibliotecas._1_ArraysUnidimensionales_Medios;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class JollyJumpers {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

       //Mientras hayan datos
        while (scan.hasNext()) {
            //Leer la entrada
            String[] linea = scan.nextLine().split(" ");
            int numElementos = Integer.parseInt(linea[0]);

            //Crear un array de booleanos para registrar las diferencias
            //La posición 0 no se usa
            //La posición i se usa para registrar si la diferencia i está presente
            //Las posiciones que se usan van de la 1 a la numElementos-1
            boolean diferencia[] = new boolean[numElementos];
            Arrays.fill(diferencia, false);
            diferencia[0] = true;

            //Registrar la presencia de las diferencias
            int numAnterior = Integer.parseInt(linea[1]);
            for (int i = 2; i < linea.length; i++) {
                int numActual = Integer.parseInt(linea[i]);
                int diff = Math.abs(numAnterior - numActual);
                numAnterior = Integer.parseInt(linea[i]);
                if (diff < numElementos) {
                    diferencia[diff] = true;
                }
            }

            //Comprobar si todas las diferencias están presentes
            boolean jolly = true;
            for (int i = 1; i < numElementos; i++) {
                if (!diferencia[i]) {
                    jolly = false;
                    break;
                }
            }

            //Mostrar el resultado
            if (jolly) {
                System.out.println("Jolly");
            } else {
                System.out.println("Not jolly");
            }
        }


    }
}
