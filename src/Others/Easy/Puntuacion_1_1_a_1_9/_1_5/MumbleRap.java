package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el string
// Leer caracter a caracter
// Si es numérico, multiplicar el resultado actual por 10 y sumar el valor numérico del caracter
//     Comprobar si el número es el mayor encontrado asta el momento
// Si es caracter, resetear el número actual a 0
// Al final, mostrar el mayor número encontrado

import java.util.Scanner;


public class MumbleRap {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Ignorar la longitud del string
        sc.nextLine();
        String linea = sc.nextLine();
        int maxNumero = 0;
        int numeroActual = 0;
        for (int i = 0; i < linea.length(); i++) {
            char c = linea.charAt(i);
            if (Character.isDigit(c)) {
                numeroActual = numeroActual * 10 + Character.getNumericValue(c);
                if (numeroActual > maxNumero) {
                    maxNumero = numeroActual;
                }
            } else {
                numeroActual = 0;
            }
        }
        System.out.println(maxNumero);

        sc.close();
    }
}

