package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer la lista de tiempos que se puede dedicar cada día
// Recorrer la lista desde el final.
// Ese día sólo podrá permanecer el mín (dia, min)
// para poder satisfacer las restricciones el resto de días


import java.util.Scanner;

public class Bergur {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numDias = sc.nextInt();
        int[] tiempoDiario = new int[numDias];

        //Leer los dias
        for (int i=0; i<numDias; i++) {
            tiempoDiario[i] = sc.nextInt();
        }

        //Recorrido desde el final hasta el principio
        int minimo = Integer.MAX_VALUE;
        int totalTiempo = 0;
        for (int i=numDias-1; i>=0; i--) {
            minimo = Math.min(minimo, tiempoDiario[i]);
            totalTiempo += minimo;
        }

        //Mostrar el resultado
        System.out.println(totalTiempo);

        sc.close();
    }
}

