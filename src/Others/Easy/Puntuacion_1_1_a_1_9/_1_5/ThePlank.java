package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Sencillo problema de programación dinámica
// Leer un entero n que representa la longitud de una tabla
// Calcular el número de maneras de construir la tabla usando piezas de longitud 1, 2 o 3
// Usar un arreglo para guardar el número de maneras para cada longitud
    // El número de maneras para una longitud i es la suma de las maneras para i-1 + i-2 + i-3
    // La razón es que una tabla de longitud L se puede construir añadiendo una pieza de longitud 1 a una tabla de longitud L-1,
    // o una pieza de longitud 2 a una tabla de longitud L-2, o una pieza de longitud 3 a una tabla de longitud L-3
// Mostrar el número de maneras para la longitud n


import java.util.Scanner;


public class ThePlank {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int longitud = sc.nextInt();
        sc.close();

        // Arreglo para guardar el número de maneras (mínimo longitud 4 para evitar errores de índice)
        long[] maneras = new long[Math.max(4, longitud + 1)];

        // Casos base
        maneras[0] = 1;  // Una manera de construir longitud 0 (no usar piezas)
        maneras[1] = 1;  // (1)
        maneras[2] = 2;  // (1+1, 2)

        // Llenar el arreglo usando programación dinámica
        for (int i = 3; i <= longitud; i++) {
            maneras[i] = maneras[i - 1] + maneras[i - 2] + maneras[i - 3];
        }

        // Mostrar el resultado
        System.out.println(maneras[longitud]);
    }
}

