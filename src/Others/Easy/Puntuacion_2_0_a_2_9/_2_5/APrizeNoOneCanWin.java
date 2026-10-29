package Others.Easy.Puntuacion_2_0_a_2_9._2_5;
import java.util.Arrays;
import java.util.Scanner;

public class APrizeNoOneCanWin {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        int numItems = sc.nextInt();
        int precioASuperar = sc.nextInt();

        //Leer todos los precios
        int[] precios = new int[numItems];
        for (int i=0; i<numItems;i++) {
            precios[i]= sc.nextInt();
        }

        //Ordenar los precios
        Arrays.sort(precios);

        //Tomar los dos precios más altos
        int index = 1;  // Siempre habrá un item y, por ser el más barato, siempre se podrá etiquetar
        if (precios[0] <= precioASuperar) {
            index = 1;

            //Comprobar que los dos precios más altos no superan el precioASuperar
            while ( index < numItems &&  precios[index] + precios[index-1] <=  precioASuperar) {
                index++;
            }
        }

        //En index tenemos el contador de items que podemos etiquetar
        System.out.println(index);
    }
}