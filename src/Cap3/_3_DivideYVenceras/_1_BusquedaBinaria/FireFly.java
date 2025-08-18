package Cap3._3_DivideYVenceras._1_BusquedaBinaria;

// Resolver mediante divide and conquer
// Debemos tratar por separado las estalacticas y las estalagmitas
// Dada una altura de H, las estalacticas van desde 0 hasta la altura
// y las estalagmitas desde la H-altura hasta H
// Como N puede ser de hasta 200.000, no podemos hacer una búsqueda lineal
// Anotar en cada altura la cantidad de estalacticas y estalagmitas que llegan hasta ella y posteriormente acumularlas
// Sumar estas cantidades para cada altura y quedarnos con la menor cantidad contando las veces que se repite la misma altura
// No veo la búsqueda binaria por ningún lado...

import java.util.Scanner;

public class FireFly {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // Leer el número de estalacticas y estalagmitas
        int numObstaculos = scan.nextInt();

        // Leer la altura de la cueva
        int alturaCueva = scan.nextInt();

        // Inicializar los arrays para las estalacticas y estalagmitas
        int[] estalacticas = new int[alturaCueva + 1];
        int[] estalagmitas = new int[alturaCueva + 1];

        // Leer las alturas de las estalacticas y estalagmitas
        for (int i = 0; i < numObstaculos; i+=2) {
            int alturaEstalactita = scan.nextInt();
            int alturaEstalagmita = scan.nextInt();
            estalacticas[alturaEstalactita]++;
            estalagmitas[alturaCueva - alturaEstalagmita+1]++;
        }

        // Acumular las estalacticas y estalagmitas
        for (int i = 1; i <= alturaCueva; i++) {
            estalacticas[alturaCueva-i] += estalacticas[alturaCueva-i + 1];
            estalagmitas[i] += estalagmitas[i - 1];
        }

        // Buscar la altura con la menor cantidad de obstáculos
        int minObstaculos = Integer.MAX_VALUE;
        int numVariantes = 0;
        for (int i = 1; i <= alturaCueva; i++) {
            int totalObstaculos = estalacticas[i] + estalagmitas[i];
            if (totalObstaculos < minObstaculos) {
                minObstaculos = totalObstaculos;
                numVariantes = 1; // Resetear el contador de variantes
            } else if (totalObstaculos == minObstaculos) {
                numVariantes++; // Incrementar el contador de variantes
            }
        }
        // Imprimir el resultado
        System.out.println(minObstaculos + " " + numVariantes);
        scan.close();
    }

}
