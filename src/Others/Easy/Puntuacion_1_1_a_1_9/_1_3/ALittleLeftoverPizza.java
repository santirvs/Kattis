package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer la cantidad de pizzas
// Para cada pizza, leer el tamaño y los sobrantes
// Calcular cuantas cajas se necesitan sin mezclar tamaños de pizza y respetando la cantidad de trozos por cada tipo de caja

import java.util.Scanner;


public class ALittleLeftoverPizza {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int NUM_SLICES_SMALL = 6;
        int NUM_SLICES_MEDIUM = 8;
        int NUM_SLICES_LARGE = 12;

        //Leer la cantidad de pizzas
        int numTipos = sc.nextInt();

        int numSobrantesSmall = 0;
        int numSobrantesMedium = 0;
        int numSobrantesLarge = 0;

        for (int tipo=0; tipo < numTipos; tipo++) {
            String tamanyo = sc.next();
            int cantidad = sc.nextInt();
            if (tamanyo.equals("S")) numSobrantesSmall +=cantidad;
            else if (tamanyo.equals("M")) numSobrantesMedium +=cantidad;
            else numSobrantesLarge +=cantidad;
        }

        int numTotalCajas = 0;
        numTotalCajas+=numSobrantesSmall/NUM_SLICES_SMALL;
        numTotalCajas += (numSobrantesSmall%NUM_SLICES_SMALL) == 0 ? 0 :1 ;
        numTotalCajas+=numSobrantesMedium/NUM_SLICES_MEDIUM;
        numTotalCajas +=  (numSobrantesMedium%NUM_SLICES_MEDIUM) == 0 ? 0 :1 ;
        numTotalCajas+=numSobrantesLarge/NUM_SLICES_LARGE;
        numTotalCajas+= (numSobrantesLarge%NUM_SLICES_LARGE) == 0 ? 0 :1 ;

        System.out.println(numTotalCajas);


        sc.close();
    }
}

