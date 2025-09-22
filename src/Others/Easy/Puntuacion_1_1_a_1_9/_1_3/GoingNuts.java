package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer el número de entrada
// Convertirlo a binario
// Contar el número de 1s (cada 1 representa una ardilla)

import java.util.Scanner;

public class GoingNuts {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el número
        int num = sc.nextInt();
        String strNum = Integer.toBinaryString(num);

        //Contar los 1s de strNum
        int numUnos = 0;
        for (int i=0; i < strNum.length(); i++) {
            //Imprimir el valor
            if (strNum.charAt(i) == '1') {
                numUnos++;
            }
        }

        //Imprimir el resultado
        System.out.println(numUnos);

        sc.close();
    }
}

