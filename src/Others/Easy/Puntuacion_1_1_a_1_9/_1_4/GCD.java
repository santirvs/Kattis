package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el número y calcular el Maximo Comun Divisor
// Aplicar el algoritmo de Euclides
// Se divide el mayor entre el menor
// Si el resto de la division es cero -> el MCD es el menor
// Sino calcular el MCD(menor, resto)

import java.util.Scanner;

public class GCD {

    public static int GCD(int a, int b){
        if (a%b==0) return b;
        else return GCD(b,a%b);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Leer los dos números
        int mayor = sc.nextInt();
        int menor = sc.nextInt();

        //Asegurarse que el mayor es realmente el mayor, sino intercambiarlos
        if (mayor < menor) {
            int aux = mayor;
            mayor = menor;
            menor = aux;
        }

        System.out.println(GCD(mayor, menor));


        sc.close();
    }
}

