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


import java.util.Locale;
import java.util.Scanner;

public class TaxingProblem_WA {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer el número de tramos impositivos
        //Creamos un nuevo tramo al final con altura infinita para simplificar el código
        int numTramos = scan.nextInt();
        double[][] tramos = new double[numTramos+1][2];
        for (int i = 0; i < numTramos; i++) {
            tramos[i][0] = scan.nextDouble(); // altura
            tramos[i][1] = scan.nextDouble(); // porcentaje
        }
        tramos[numTramos][0] = Double.MAX_VALUE; // altura infinita
        tramos[numTramos][1] = scan.nextDouble();

        //Leer el número de amigos
        int numAmigos = scan.nextInt();
        //Leer los ingresos y el beneficio deseado de cada amigo
        double[][] amigos = new double[numAmigos][2];
        for (int i = 0; i < numAmigos; i++) {
            amigos[i][0] = scan.nextDouble(); // ingresos
            amigos[i][1] = scan.nextDouble(); // beneficio deseado
        }

        //Para cada amigo, hacer una BSTA para encontrar la cantidad X que necesita
        for (int i = 0; i < numAmigos; i++) {
            double ingresos = amigos[i][0];
            //Calcula los impuestos que debería pagar el amigo sin hacerle ninguna donación
            double impuestosSinDonacion = calcularImpuestos(tramos, ingresos);
            double beneficioDeseado = amigos[i][1];

            double left = 0;
            double right = 1e11; // límite superior suficientemente grande (en el peor de los casos es un 100% de impuestos)
                                    // v2.1 Amplío el límite superior a 1e9. Supero el caso #3, pero WA en el #7
                                    // v2.2. Amplío el límite superior a 1e24. TLE en el caso #7
                                    // v2.3 Amplío el límite superior a 1e12. TLE en el caso #7
                                    // v2.4 Amplío el límite superior a 1e10. WA en el caso #7
                                    // v2.5 Amplío el límite superior a 1e11. WA en el caso #7

            while (right - left > 1e-7) { // precisión de 10^-6
                double mid = (left + right) / 2;

                //Calcular los impuestos a pagar si se dona 'mid'
                double impuestosConDonacion = calcularImpuestos(tramos, ingresos + mid);
                //Calcular el beneficio neto después de impuestos y donación
                double beneficioNeto = mid - impuestosConDonacion + impuestosSinDonacion;

                if (beneficioNeto >= beneficioDeseado) {
                    right = mid; // intentar con una donación menor
                } else {
                    left = mid; // intentar con una donación mayor
                }

            }

            //Imprimir la cantidad mínima que debe donar al amigo
            System.out.printf("%.6f\n",right);
        }

    }

    private static double calcularImpuestos(double[][] tramos, double ingresos) {
        double impuestos = 0;
        double ingresosRestantes = ingresos;

        for (int j = 0; j < tramos.length && ingresosRestantes > 0; j++) {
            double tramoActual = tramos[j][0];
            double porcentaje = tramos[j][1];

            double ingresosEnTramo = Math.min(ingresosRestantes, tramoActual);
            impuestos += ingresosEnTramo * (porcentaje / 100.0);
            ingresosRestantes -= ingresosEnTramo;
        }

        return impuestos;
    }
}
