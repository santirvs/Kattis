package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el número de casos
// Para cada pareja de secuencias
// Leer la secuencia1 y la secuencia2
// Recorrer ambas secuencias de la misma longitud
// Si los caracteres son iguales, imprimir .
// Si los caracteres son diferentes, imprimir *
// *** Cadenas de longitud 50 y máximo 500 casos, no es necesario optimizar
// Salto de linea para separar los casos


import java.util.Scanner;

public class DetailedDiferences {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el número de casos
        int numCasos = sc.nextInt();
        sc.nextLine(); //Salto de linea
        for (int caso = 1; caso <= numCasos; caso++) {

            String secuencia1 = sc.nextLine();
            String secuencia2 = sc.nextLine();

            //Imprimir las secuencias
            System.out.println(secuencia1);
            System.out.println(secuencia2);

            for (int i=0; i < secuencia1.length(); i++) {
                if (secuencia1.charAt(i) != secuencia2.charAt(i)) {
                    System.out.print("*");
                } else  {
                    System.out.print(".");
                }
            }

            System.out.println(); // Salto de línea de la comparativa


            System.out.println();  // Salto de línea al final de cada caso
        }


        sc.close();
    }
}

