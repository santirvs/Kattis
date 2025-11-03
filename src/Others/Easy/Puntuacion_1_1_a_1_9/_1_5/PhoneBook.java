package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer la cantidad de casos
// Leer cada caso
// Determinar si empieza por +39 y tiene entre 9 y 10 caracteres más
// Contar los que si cumplen las condiciones
// Imprimir el contador

import java.util.Scanner;


public class PhoneBook {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la cantidad de casos
        int numCasos = sc.nextInt();
        sc.nextLine();
        int contador = 0;
        // Leer cada caso
        for (int i=0; i<numCasos; i++) {
            // Determinar si empieza por +39 y tiene entre 9 y 10 caracteres más
            String telefono = sc.nextLine();

            if (telefono.startsWith("+39") && (telefono.length()==(9+3) || telefono.length()==(10+3))) {
                contador++;
            }
            // Contar los que si cumplen las condiciones
        }
        // Imprimir el contador
        System.out.println(contador);
        sc.close();
    }
}

