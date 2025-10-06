package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer un valor decimal x y mostrar
//   Si x==1  --> -1 2
//   Si x>-999 -> x-1 1
//   Sino -> x+1 -1

import java.util.Scanner;

public class AritmethicAdaptation {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        //Leer los datos
        int num = scan.nextInt();

        if (num==1)
            System.out.println("-1 2");
        else if (num > -999)
            System.out.println((num-1) + " 1");
        else
            System.out.println((num+1) + " -1");

    }
}