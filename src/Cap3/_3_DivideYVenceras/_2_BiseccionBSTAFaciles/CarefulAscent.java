package Cap3._3_DivideYVenceras._2_BiseccionBSTAFaciles;

// Estrategia de D&C. Bisección binaria
// La altura a alcanzar siempre debe ser Y y la Vy es constante = 1
// Aplicar un méthodo de bisección binaria para encontrar la Vx que,
// tras quedar afectada por los escudos, alcance la altura Y.
// Los rangos de Vx se establecen arbitrariamente:
// van desde 0 hasta 10^9, por lo que la bisección binaria es adecuada.
// 0 es el valor mínimo de Vx, ya que no puede ser negativo.
// 10^9 es el valor máximo y se calcula como 10^8 (altura máxima) y 0,1 que es el factor mínimo. (10^9 * 0,1 = 10^8)

// v1. WA en Caso #5
// v2. Tener en cuenta el caso de la velocidad negativa si la posX es negativa

import java.util.Scanner;

public class CarefulAscent {

    static int posX;
    static int posY;
    static int numEscudos;
    static int[][] limitesEscudos = new int[numEscudos][2];
    static double[] factorEscudos = new double[numEscudos];
    

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(java.util.Locale.US); // Asegurar que se usa el punto como separador decimal

        //Leer las coordenadas de destino
        posX = scan.nextInt();
        posY = scan.nextInt();

        boolean negativa = posX < 0; // Comprobar si la posición X es negativa
        posX = Math.abs(posX);

        // Leer el número de escudos
        numEscudos = scan.nextInt();

        // Leer los límites y factor de los escudos
        limitesEscudos = new int[numEscudos][2];
        factorEscudos = new double[numEscudos];
        for (int i = 0; i < numEscudos; i++) {
            limitesEscudos[i][0] = scan.nextInt();
            limitesEscudos[i][1] = scan.nextInt();
            factorEscudos[i] = scan.nextDouble();
        }

        // Calcular la velocidad Vx usando bisección binaria
        double vX = biseccionBinaria(0, 1e9);
        if (negativa) {
            vX *= -1; // Si la posición X era negativa, invertir la velocidad Vx
        }
        
        // Imprimir el resultado
        System.out.printf("%.10f\n", vX);
        
    }

    private static double biseccionBinaria(double left, double right) {
        double epsilon = 1e-9; // Precisión deseada
        while (right - left > epsilon) {
            double mid = (left + right) / 2.0;
            if (distanciaRecorrida(mid) >= posX) {
                right = mid; // Si la distancia recorrida es mayor o igual a posX, reducir el rango superior
            } else {
                left = mid; // Si la distancia recorrida es menor a posX, aumentar el rango inferior
            }
        }
        return (left + right) / 2.0; // Retornar el valor medio como resultado) {
    }

    private static double distanciaRecorrida(double velocidadX) {
        // La velocidad Vy es siempre constante y vale 1
        double x = 0.0;

        // Atravesar todos los escudos (según el enunciado, como máximo llegan a posY)
        int altura = 0;
        for (int escudo = 0; escudo < numEscudos; escudo++) {
            // Calcular el tiempo hasta llegar al escudo (a velocidad vertical constante de 1)
            double tiempoEscudo = (limitesEscudos[escudo][0] - altura);
            // Calcular la distancia horizontal recorrida hasta el escudo
            x += velocidadX * tiempoEscudo;

            // Calcular la distancia recorrida dentro del escudo
            x += velocidadX * factorEscudos[escudo] * (limitesEscudos[escudo][1] - limitesEscudos[escudo][0]);
            altura = limitesEscudos[escudo][1]; // Actualizar la altura alcanzada
        }

        // Llegar a la altura deseada
        if (altura < posY) {
            // Calcular la distancia horizontal recorrida hasta alcanzar la altura deseada
            x += velocidadX * (posY-altura);
        }

        return x; // Retornar la distancia horizontal alcanzada
    }
}
