package Others.Easy.Puntuacion_1_1_a_1_9._1_5.Adaptaciones;

// Sencillo problema de programación dinámica
// Leer un entero n que representa la longitud de la pieza deseada
// Calcular el número de maneras de construir una pieza usando piezas de longitud 1, 2, 3, 4, 6, 8 y 10
// Usar un array para guardar el número de maneras para cada longitud
    // El número de maneras para una longitud i es la suma de las maneras para i-1 + i-2 + i-3 + i-4 + i-6 + i-8 + i-10
    // La razón es que una pieza de longitud L se puede construir añadiendo una pieza de longitud 1 a una construcción de longitud L-1,
    // o una pieza de longitud 2 a una construcción de longitud L-2, o ...
// Mostrar el número de maneras para la longitud n


import java.util.Scanner;


public class LegoBrick {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCasos = sc.nextInt();
        //Leer las longitudes, guardarlas en un array y quedarnos con el valor máximo
        int maxLongitud = Integer.MIN_VALUE;
        int[] longitudes = new int[numCasos];
        for (int i = 0; i < numCasos; i++) {
            longitudes[i] = sc.nextInt();
            maxLongitud = Math.max(maxLongitud, longitudes[i]);
        }
        //Cerrar el scanner, ya no hay que leer nada más
        sc.close();

        int[] piezas =  { 1, 2, 3, 4, 6, 8, 10 };

        // Array para guardar el número de maneras (mínimo longitud 4 para evitar errores de índice)
        long[] maneras = new long[Math.max(4, maxLongitud + 1)];

        // Casos base
        maneras[0] = 1;  // Una manera de construir longitud 0 (no usar piezas)
        maneras[1] = 1;  // (1)
        maneras[2] = 2;  // (1+1, 2)

        // Llenar el array usando programación dinámica
        // Calcular las maneras de conseguir una longitud determinada
        for (int i = 3; i <= maxLongitud; i++) {
            // Si la longitud buscada es superior o igual al tamaño de cada pieza
            // podemos construirla a partir de la combinación de una longitud
            // x posiciones más corta
            for (int j=0; j<piezas.length; j++) {
                if (piezas[j]<=i) {
                    maneras[i] += maneras[i - piezas[j]];
                }
            }
        }

        //Ya hemos calculado todas las maneras posibles,
        //Es el momento de mostrar el resultado
        for (int i=0; i<longitudes.length; i++) {
            System.out.println(maneras[longitudes[i]]);
        }
    }
}

