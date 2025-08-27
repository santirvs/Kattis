package Cap3._3_DivideYVenceras._2_BiseccionBSTAFaciles;

// Estrategia de D&C. Bisección binaria

// Buscar la cantidad mínima de días necesarios para recuperar el coste inicial de la inversión y obtener un mínimo beneficio.
// Se puede aplicar una búsqueda binaria sobre el número de días, desde 1 hasta un valor suficientemente grande (por ejemplo, 10^9).
// Para cada número de días, se calcula el beneficio total y se compara con el coste inicial más el beneficio mínimo requerido.
// Si el beneficio es suficiente, se intenta con un número menor de días; si no, se intenta con un número mayor de días.

// El problema es que el número de opciones es de hasta 10^5 y eso puede llevar a TLE

// v1. Dado que el tiempo límite es de 7seg. pruebo el planteamiento inicial
//     --> WA en caso #19
// v2. Ajustar el límite superior de días a 2*(10^9)  (suponer un coste inicial máximo de 10^9 y un beneficio por día mínimo de 1)
//     --> AC

import java.util.Scanner;

public class FinancialPlanning {

    static int numOpciones;
    static long beneficioMinimo;
    static int[] beneficioPorDia;
    static int[] costeInicial;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer el número de opciones y el beneficio mínimo requerido
        numOpciones = sc.nextInt();
        beneficioMinimo = sc.nextInt();

        // Leer las opciones de inversión
        beneficioPorDia = new int[numOpciones];
        costeInicial = new int[numOpciones];
        for (int i = 0; i < numOpciones; i++) {
            beneficioPorDia[i] = sc.nextInt();
            costeInicial[i] = sc.nextInt();
        }
        // Fin de la entrada
        sc.close();

        // Biseccion binaria para encontrar el número mínimo de días
        int left = 1; // Mínimo número de días
        int right = 2_000_000_000; // Máximo número de días (10^9)  (suponer un coste inicial máximo de 10^9 y un beneficio por día mínimo de 1)
        int result = -1; // Resultado final
        while (left <= right) {
            int mid = left + (right - left) / 2; // Punto medio del número de días a probar

            // Calcular si se alcanza el beneficio mínimo con 'mid' días
            boolean suficiente = false;
            long beneficioTotal = 0; // Beneficio total acumulado
            for (int i = 0; i < numOpciones && !suficiente; i++) {
                long beneficioDiaOpcion = (long) beneficioPorDia[i] * mid - costeInicial[i]; // Beneficio total de la opción i en 'mid' días
                // Solo considerar las inversiones que generen beneficios en el número de días indicado
                if (beneficioDiaOpcion > 0) {
                    beneficioTotal += beneficioDiaOpcion; // Sumar al beneficio total de las inversiones
                    if (beneficioTotal >= beneficioMinimo) {
                        suficiente = true; // Se alcanza el beneficio mínimo
                    }
                }
            }

            // Verificar si el beneficio total es suficiente
            if (suficiente) {
                result = mid; // Actualizar el resultado
                right = mid - 1; // Intentar con un número menor de días
            } else {
                left = mid + 1; // Intentar con un número mayor de días
            }
        }

        // Imprimir el resultado
        System.out.println(result);
    }


}
