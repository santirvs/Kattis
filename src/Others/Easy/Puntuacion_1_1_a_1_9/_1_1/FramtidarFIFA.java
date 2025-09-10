package Others.Easy.Puntuacion_1_1_a_1_9._1_1;

// Leer el número de mejoras total de mejoras, leer el número anual de mejoras
// Dividir y sumar a 2022

import java.util.Scanner;

public class FramtidarFIFA {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int numTotalMejoras = scan.nextInt();
        int numAnualMejoras = scan.nextInt();
        int anyos = numTotalMejoras / numAnualMejoras;
        System.out.println(2022 + anyos);

    }
}