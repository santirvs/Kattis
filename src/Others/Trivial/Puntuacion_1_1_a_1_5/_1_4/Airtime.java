package Others.Trivial.Puntuacion_1_1_a_1_5._1_4;

// Contar el número de "vuelos"

import java.util.Scanner;

public class Airtime {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numPuntos = sc.nextInt();

        int puntoAnterior = sc.nextInt();
        int puntoActual = sc.nextInt();
        int numVuelos = 0;

        for (int punto=2; punto < numPuntos; punto++) {
            int puntoSiguiente = sc.nextInt();
            if (puntoActual-puntoAnterior > puntoSiguiente-puntoActual) {
                numVuelos++;
            }
            puntoAnterior = puntoActual;
            puntoActual = puntoSiguiente;
        }

        System.out.println(numVuelos);
    }
}

