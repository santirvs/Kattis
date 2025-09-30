package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el número de concursos
// Sumar los premios de cada concurso
// Mostrar si la suma es divisible entre 3


import java.util.Scanner;

public class DivvyingUp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la cantidad de concursos
        int numConcursos = sc.nextInt();

        //Sumar el importe de todos los concursos
        int sumaTotal = 0;
        for (int i=0; i<numConcursos; i++) {
            sumaTotal += sc.nextInt();
        }

        //Mostrar si el resultado es divisible entre 3
        if (sumaTotal%3==0) System.out.println("yes");
        else System.out.println("no");

        sc.close();
    }
}

