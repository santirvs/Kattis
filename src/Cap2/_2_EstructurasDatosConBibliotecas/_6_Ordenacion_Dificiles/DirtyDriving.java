package Cap2._2_EstructurasDatosConBibliotecas._6_Ordenacion_Dificiles;

import java.util.Locale;
import java.util.Scanner;
import java.util.Arrays;

public class DirtyDriving {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Datos del problema
        int numCoches = scan.nextInt();
        int p = scan.nextInt();

        //Leer la distancia a los coches
        int[] distancias = new int[numCoches];
        for (int i = 0; i < numCoches; i++) {
            distancias[i] = scan.nextInt();
        }

        //Ordenar los coches por distancia
        Arrays.sort(distancias);

        //Calcular la distancia mínima
        int min = 0;
        for (int i = 0; i < numCoches; i++) {
            min = Math.max(min, (i + 1) * p - (distancias[i]-distancias[0]));
        }

        //Mostrar el resultado
        System.out.println(min);
    }
}