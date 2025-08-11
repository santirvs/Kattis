package Cap3._2_BusquedaCompleta._8_SimulacionMatematicaFaciles;

// Búsqueda completa
// Hay que tener en cuenta que las botellas que se beben también las puede reciclar,
// así que hay que ir acumulando mientras el número de botellas vacías sea mayor que las que se necesitan para comprar una nueva.

import java.util.Scanner;

public class SodaSlurper {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Leer el número de corredores
        int vaciasInicio = scan.nextInt();
        int vaciasEncontradas = scan.nextInt();
        int botellasNecesarias = scan.nextInt();

        System.out.println(calcularBotellasTotales(vaciasInicio, vaciasEncontradas, botellasNecesarias));
    }

    private static int calcularBotellasTotales(int vaciasInicio, int vaciasEncontradas, int botellasNecesarias) {
        int totalBotellas = vaciasInicio + vaciasEncontradas;
        if (totalBotellas < botellasNecesarias) {
            return 0;
        }
        return (totalBotellas / botellasNecesarias) +
               calcularBotellasTotales(totalBotellas / botellasNecesarias , totalBotellas % botellasNecesarias, botellasNecesarias);
    }

}


