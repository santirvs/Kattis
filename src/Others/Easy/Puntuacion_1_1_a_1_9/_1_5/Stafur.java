package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer un caracter y mostrar determinar si es una vocal, consonante o desconocido (Y)
// Debe mostrarse "Jebb" para vocales, "Neibb" para consonantes y "Kannski" para desconocidos


import java.util.Scanner;


public class Stafur {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char caracter = sc.next().toLowerCase().charAt(0);
        sc.close();
        if ("aeiou".indexOf(caracter) != -1) {
            System.out.println("Jebb");
        } else if (caracter == 'y') {
            System.out.println("Kannski");
        } else {
            System.out.println("Neibb");
        }
    }
}

