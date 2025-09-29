package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el número de segundos
// Imprimir las horas (dividir entre 3600), los minutos (dividir el resto entre 60) y los segundos (el resto)

import java.util.Scanner;

public class ASecondOpinion {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el número de segundos
        int numSegundos =  sc.nextInt();

        // Calcular las horas
        int numHoras = numSegundos / 3600;
        numSegundos = numSegundos % 3600;

        //Calcular los minutos
        int numMinutos = numSegundos / 60;
        numSegundos = numSegundos % 60;

        //MOstrar el resultado
        System.out.println(numHoras + " : " + numMinutos + " : " + numSegundos);
        sc.close();
    }
}

