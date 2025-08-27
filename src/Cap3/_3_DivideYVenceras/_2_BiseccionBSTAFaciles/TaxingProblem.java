package Cap3._3_DivideYVenceras._2_BiseccionBSTAFaciles;

// Estrategia de D&C. Bisección binaria

// Cada amigo es un caso de pruebas independiente
// Hay que hacer una BSTA para encontrar una cantidad X que sumada a los ingresos del amigo y aplicados los impuestos
// le deje el beneficio deseado.
// El límite inferior es 0 y el límite superior es una cantidad suficientemente grande. En el peor de los casos será el doble del impuesto
// Hay que tener en cuenta que los impuestos se aplican por tramos, por lo que hay que calcularlos correctamente
// y que cada amigo se paga sus propios impuestos antes de sumar la donación

// v1. WA en Caso #3
// v2. Amplío el límite superior a 1e12. Supero el caso #3, pero WA en el #6
// v3. Hacer cambio de planteamiento

/** Calcular el beneficio después de impuestos como:
 * money_after_tax(initial + nominal_given) - money_after_tax(initial).
 * Buscar con BSTA el nominal_given que hace que el beneficio después de impuestos sea el deseado.
 */

import java.util.*;
import java.io.*;

public class TaxingProblem {

    static int numTramos;
    static double ultimoTramo;
    static List<double[]> rangoImpuestos = new ArrayList<>(); // (tamaño, tasa)

    // Calcula el dinero después de impuestos dado un monto inicial
    static double calcularImpuestos(double importeInicial) {
        double despuesImpuestos = 0;
        for (double[] impuesto : rangoImpuestos) {
            double tamanyo = impuesto[0];
            double porcentaje = impuesto[1];
            if (importeInicial >= tamanyo) {
                despuesImpuestos += tamanyo * (1.0 - porcentaje);
                importeInicial -= tamanyo;
            } else {
                despuesImpuestos += importeInicial * (1.0 - porcentaje);
                importeInicial = 0;
                break;
            }
        }
        if (importeInicial > 0) {
            despuesImpuestos += importeInicial * (1.0 - ultimoTramo);
        }
        return despuesImpuestos;
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);

        //Lectura del número de tramos y datos de los tramos impositivos
        numTramos = scan.nextInt();
        for (int i = 0; i < numTramos; i++) {
            double tamanyo = scan.nextDouble();
            double tipo = scan.nextDouble();
            rangoImpuestos.add(new double[]{tamanyo, tipo / 100.0});
        }
        // Lectura del porcentaje impositivo para ingresos superiores al último tramo
        ultimoTramo = scan.nextDouble() / 100.0;

        // Lectura del número de amigos y procesamiento de cada caso
        int numAmigos = scan.nextInt();
        for (int i = 0; i < numAmigos; i++) {
            double ingresos = scan.nextDouble();
            double donacionNeta = scan.nextDouble();
            double impuestosAmigo = calcularImpuestos(ingresos);

            double low = 0, high = 1e12, mid = 0; // upper bound grande
            for (int j = 0; j < 1000; j++) {  // 1000 iteraciones para precisión
                mid = (low + high) / 2;
                double realGive = calcularImpuestos(ingresos + mid) - impuestosAmigo;
                if (realGive < donacionNeta) {
                    low = mid;
                } else {
                    high = mid;
                }
            }
            System.out.printf("%.10f%n", mid);
        }
    }

}
