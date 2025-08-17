package Cap3._2_BusquedaCompleta._12_BacktrackingDificiles;

// Resolver mediante backtracking
// Ir multiplicando el resultado por cada uno de los factores primos
// Si el número se encuentra dentro del rango especificado, se cuenta como primo peculiar
// Abortar en el momento que el número supera el rango especificado
// Añadir a un set para evitar duplicados
// Trabajar con long para evitar overflow en el caso de números grandes aunque no se necesiten para el rango máximo
// pero sí que pueden aparecer en el caso extremo 2^31 => 10^9 * 10^5 --> 10^14 => 2^47
// Hay una lista de 10 números primos, no parece que pueda haber TLE  (t=3seg)

// v1. TLE en Caso #2  -- pues sí hay TLE...  buscar optimización
// v2. Durante el backtracking, si el nuevo resultado supera el rango, podar la búsqueda.
//     Los siguientes resultados también superarán el rango, ya que son se multiplicarán por un número mayor
//     Sigue el TLE en el Caso #2
// v3. Traduzco a C++ y vuelvo a obtener TLE. Buscar otro enfoque!

import java.util.*;

public class PeculiarPrimes_TLE {

    static long[] primos;
    static long rangoInferior;
    static long rangoSuperior;
    static Set<Integer> primosPeculiares = new HashSet<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Leer los números primos
        int numPrimos = scan.nextInt();

        while (numPrimos > 0) {

            // Leer los números primos
            primos = new long[numPrimos];
            for (int i = 0; i < numPrimos; i++) {
                primos[i] = scan.nextLong();
            }
            // Leer el rango inferior y superior
            rangoInferior = scan.nextLong();
            rangoSuperior = scan.nextLong();

            // Inicializar la lista de primos peculiares
            primosPeculiares = new HashSet<>();

            // Iniciar el backtracking
            backtracking(1);

            // Mostrar el resultado
            // Si no hay primos peculiares, mostrar none
            if (primosPeculiares.isEmpty()) {
                System.out.println("none");
            }
            else {
                //Ordenar el resultado, por ser un HashSet ya está sin duplicados pero no está ordenado, convertir a lista
                List<Integer> primosPeculiaresList = new ArrayList<>(primosPeculiares);
                Collections.sort(primosPeculiaresList);
                boolean primero = true;
                for (Integer primo : primosPeculiaresList) {
                    if (primero) primero = false;
                    else System.out.print(",");
                    System.out.print(primo);
                }
                System.out.println();
            }

            // Siguiente caso
            numPrimos = scan.nextInt();
        }


    }

    private static boolean backtracking(long multiplo) {
        // Caso directo: Si el multiplo está fuera del rango, abortar
        if (multiplo > rangoSuperior) return false;

        // Si el multiplo está dentro del rango, añadirlo a la lista de primos peculiares
        if (multiplo >= rangoInferior) {
            primosPeculiares.add((int) multiplo);
        }

        // Recorrer la lista de números primos y hacer backtracking con su producto
        for (long primo : primos) {
            long nuevoResultado = multiplo * primo;
            // Si el nuevo resultado supera el rango, podar la búsqueda.
            // Los siguientes resultados también lo harán ya que son mayore
            if (!backtracking(nuevoResultado)) break;
        }

        return true;
    }
}
