package Cap3._2_BusquedaCompleta._10_Josefo;

// Problema de Josefo, usar el caso genérico de recurrencia
// pero al ser un conjunto muy grande (hasta 10^7) dará RTE para el caso recursivo
// Usar una solución iterativa para evitar el RTE

import java.util.Scanner;

public class Toys {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numJuguetes = sc.nextInt(); // número de juguetes
        int salto = sc.nextInt(); // número de saltos a realizar

        int pos = JosefoIterativo (numJuguetes, salto);

        // Imprimir la posición del último juguete vivo (0-index)
        System.out.println(pos-1);
    }

    private static int Josefo(int numJuguetes, int salto) {
        if (numJuguetes == 1) {
            return 0; // base case: si solo queda un juguete, su posición es 0 (ajustada a 0-index)
        } else {
            // Recursión: calcular la posición del juguete vivo en el caso reducido
            return (Josefo(numJuguetes - 1, salto) + salto) % numJuguetes;
        }
    }

    /**
     * Calcula el superviviente usando la fórmula matemática.
     * @param n Número de personas
     * @param k Salto (cada k-ésima persona es eliminada)
     * @return Índice 1-based del superviviente
     */
    public static int JosefoIterativo(int n, int k) {
        int resultado = 0; // J(1, k) = 0
        for (int i = 2; i <= n; i++) {
            resultado = (resultado + k) % i;
        }
        return resultado + 1; // +1 para convertir a 1-based
    }
}
