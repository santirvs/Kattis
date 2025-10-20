package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el importe inicial y el número de reintegros
// Para cada reintegro, mirar si es igual o inferior al importe restante
// Si lo es --> imprimir 1 y actualizar importe restante
// Si no lo es --> imprimir 0

import java.util.Scanner;

public class ATMMaintenance {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Leer datos iniciales
        int numCasos =  sc.nextInt();
        int importeRestante = sc.nextInt();

        while (numCasos-- > 0) {
            int importeSolicitado =  sc.nextInt();
            if (importeRestante >= importeSolicitado) {
                importeRestante -= importeSolicitado;
                System.out.print(1);
            }
            else {
                System.out.print(0);
            }
        }

        //Final de la línea
        System.out.println();

        sc.close();
    }
}

