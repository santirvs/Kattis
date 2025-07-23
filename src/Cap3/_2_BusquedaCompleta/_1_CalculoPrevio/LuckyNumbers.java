package Cap3._2_BusquedaCompleta._1_CalculoPrevio;

import java.math.BigInteger;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

// El número de casos está limitado a 1000. Pueden precalcularse y dar una solución rápida.
// Hay que observar que si un número de N cifras es un Lucky Number, entonces el número de cifras de N-1 también lo es.
// Por lo que podemos construir los números incrementalmente.
// El problema es que podemos tener números de hasta 1000 cifras, por lo que un Integer nos soporta 10 cifras como máximo.
// Y un long nos soporta 19 cifras como máximo. Necesitaremos un BigInteger para soportar números de hasta 1000 cifras.

// Tras generar todos los casos posibles, vemos que a partir de 26 cifras no hay más Lucky Numbers.



public class LuckyNumbers {



    // Ejecutar el código con los valores predefinidos de m[i]
    public static void main(String[] args) {
       //generateLuckyNumbers();
       solve();
    }

    public static void generateLuckyNumbers() {
        Queue<BigInteger> cola = new PriorityQueue<>();
        int cantidad[] = new int[1001]; // Array para almacenar la cantidad de Lucky Numbers de cada longitud

        //Inicializamos la cola con los números base
        cantidad[0] = 1;
        cantidad[1] = 9;
        for (int i = 1; i <= 9; i++) {
            cola.add(new BigInteger(String.valueOf(i)));
        }

        // Generar los Lucky Numbers desde 2 cifras hasta 1000 cifras
        for (int i = 2; i <= 1000; i++) {
            // Miramos el tamaño de la cola al inicio de cada iteración
            int size = cola.size();
            BigInteger bi = new BigInteger(i+"");
            for (int j = 0; j < size; j++) {
                BigInteger num = cola.poll();
                // Añadir un dígito al final del número
                for (int k = 0; k <= 9; k++) {
                    BigInteger nuevoNum = new BigInteger(num.toString() + k);
                    if (nuevoNum.divideAndRemainder(bi)[1].equals(BigInteger.ZERO)) {
                        // Si el nuevo número es divisible por i, lo añadimos a la cola
                        cola.add(nuevoNum);
                    }
                }
            }
            // Guardamos la cantidad de Lucky Numbers de longitud i
            cantidad[i] = cola.size();
        }

        // Imprimir los resultados
        for (int i = 0; i <= 1000; i++) {
            System.out.printf("Cantidad de Lucky Numbers de %d cifras: %d\n", i, cantidad[i]);
        }
        System.out.println("***");
        for (int i = 0; i <= 30; i++) {
            System.out.printf(",%d", cantidad[i]);
        }

    }

    public static void solve() {
        Scanner scanner = new Scanner(System.in);
        int soluciones[] = {1,9,45,150,375,750,1200,1713,2227,2492,2492,2225,2041,1575,1132,770,571,335,180,90,44,18,12,6,3,1,0,0,0,0,0}; // Array para almacenar las soluciones de 0 a 26 cifras
        int n = scanner.nextInt();

        if (n >= 26) {
            System.out.println("0");
        } else {
            System.out.println(soluciones[n]);
        }
    }
}
