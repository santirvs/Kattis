package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer la cantidad de medidas
// Para cada medida, leerla y compararla con 48
// Si es menor que 48, marcar como False
// Al final, imprimir el resultado
// Si alguna medida es menor que 48, imprimir "False", si no "True"

import java.util.Scanner;


public class TallEnough {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la cantidad de medidas
        int n = sc.nextInt();
        boolean esSuficientementeAlto = true;
        // Procesar las medidas
        for (int i = 0; i < n; i++) {
            int medida = sc.nextInt();
            if (medida < 48) {
                esSuficientementeAlto = false;
            }
        }

        // Imprimir el resultado
        if (esSuficientementeAlto) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        sc.close();
    }
}

