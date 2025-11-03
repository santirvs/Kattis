package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el número de casos, el record actual y el record anterior
// Para cada caso
//    Leer el valor del salto
//    Comprobar si el salto es superior a la suma del record actual y el record anterior
//    Si es así, actualizar los records y sumar 1 al contador
//  Finalmente, imprimir el contador

import java.util.Scanner;


public class OffWorldRecords {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el número de casos, el record actual y el record anterior
        int numCasos = sc.nextInt();
        int recordActual = sc.nextInt();
        int recordAnterior = sc.nextInt();
        int contador = 0;
        // Para cada caso
        while (numCasos-- > 0) {
            //    Leer el valor del salto
            int salto = sc.nextInt();
            //    Comprobar si el salto es superior a la suma del record actual y el record anterior
            if (salto > recordActual+recordAnterior) {
                //    Si es así, actualizar los records y sumar 1 al contador
                contador++;
                recordAnterior = recordActual;
                recordActual = salto;
            }

        }
        //  Finalmente, imprimir el contador
        System.out.println(contador);

        sc.close();
    }
}

