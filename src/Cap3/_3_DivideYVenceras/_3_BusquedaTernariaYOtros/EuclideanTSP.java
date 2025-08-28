package Cap3._3_DivideYVenceras._3_BusquedaTernariaYOtros;

// Estrategia de D&C. Búsqueda ternaria y otros

/*
 * Búsqueda ternaria básica
 *
 * Aquí la dificultad radica en encontrar la función a minimizar.
 * La función es el tiempo total que tarda el algoritmo, que depende de una variable c.
 * La función es convexa, así que podemos usar búsqueda ternaria para encontrar el mínimo.
 * El valor c que minimiza el tiempo es el que buscamos.
 * La función tiempoEmpleado(c) calcula el tiempo total que tarda el algoritmo para un valor dado de c.
 * El tiempo total es la suma del tiempo de vuelo y el tiempo de cálculo.
 * El tiempo de vuelo es longitudTourOptimo * (1 + 1/c) / velocidadJet.
 * El tiempo de cálculo es numAeropuertos * (log2(numAeropuertos)^(c * sqrt(2))) / (1e9 * operacionesPorSegundo).
 * Hacemos 500 iteraciones de búsqueda ternaria para encontrar el valor óptimo de c.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EuclideanTSP {
    static int numAeropuertos;
    static double operacionesPorSegundo, longitudTourOptimo, velocidadJet;

    static double tiempoEmpleado(double c) {
        return longitudTourOptimo * (1.0 + 1.0 / c) / velocidadJet + numAeropuertos * (Math.pow(Math.log(numAeropuertos) / Math.log(2), c * Math.sqrt(2.0)) / (1e9 * operacionesPorSegundo));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //Lectura de datos
        numAeropuertos = Integer.parseInt(st.nextToken());
        operacionesPorSegundo = Double.parseDouble(st.nextToken());
        longitudTourOptimo = Double.parseDouble(st.nextToken());
        velocidadJet = Double.parseDouble(st.nextToken());

        double left = 1e-12, right = 1e11;
        for (int i = 0; i < 500; i++) {
            // System.out.println(left + " " + right);
            double midLeft = left + (right - left) / 3.0;
            double midRight = midLeft + (right - left) / 3.0;

            if (tiempoEmpleado(midLeft) > tiempoEmpleado(midRight)) {
                left = midLeft;
            } else {
                right = midRight;
            }
        }

        System.out.printf("%.12f %.12f%n", tiempoEmpleado(left), left);
    }
}
