package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el número de días
// Leer el estado (sober / drunk) de cada uno de los días
// Determinar cuantos días ha habido resaca (días que se ha estado sobrio despues de haber bebido)

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HairOfTheDog {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el número de días a tratar
        int numDias = sc.nextInt();
        boolean bebido = false;
        int numDiasResaca = 0;

        for (int i=0; i<numDias; i++){
            String estado = sc.next();
            if (estado.equals("sober")) {
                if (bebido) numDiasResaca++;
                bebido = false;
            }
            else  bebido = true;
        }

        //Mostrar el resultado
        System.out.println(numDiasResaca);


        sc.close();
    }
}

