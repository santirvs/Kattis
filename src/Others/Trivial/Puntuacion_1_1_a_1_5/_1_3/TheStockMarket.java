package Others.Trivial.Puntuacion_1_1_a_1_5._1_3;

// Leer el array y comparar a una distancia de N posiciones
// Quedarnos con el mayor de las comparaciones

import java.util.Scanner;

public class TheStockMarket {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer los datos
        int numDias = scan.nextInt();
        int diasCociendo = scan.nextInt();

        int[] precios = new int[numDias];
        int maxBeneficio = Integer.MIN_VALUE;

        //Leer los valores y compararlos (si se puede)
        for (int i=0; i<numDias; i++) {
            precios[i] = scan.nextInt();
            if (i>=diasCociendo) {
                int beneficio = precios[i] - precios[i-diasCociendo];
                maxBeneficio = Math.max(maxBeneficio, beneficio);
            }
        }

        System.out.println(maxBeneficio);


    }
}