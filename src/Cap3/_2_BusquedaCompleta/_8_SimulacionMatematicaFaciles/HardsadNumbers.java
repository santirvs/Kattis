package Cap3._2_BusquedaCompleta._8_SimulacionMatematicaFaciles;

// A partir del número leído, probar incrementalmente hasta encontrar el siguiente numero que sea un número Hardsad
// Un número Hardsad es un número que es divisible por la suma de sus dígitos

import java.util.Scanner;

public class HardsadNumbers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Leer el número inicial
        int n = scan.nextInt();

        // Buscar el siguiente número Hardsad
        while (true) {
            if (esHardsad(n)) {
                System.out.println(n);
                break; // Salir del bucle si se encuentra un número Hardsad
            }
            n++; // Incrementar el número para probar el siguiente
        }

    }

    private static boolean esHardsad(int n) {
        int sumaDigitos = 0;
        int numero = n;

        // Calcular la suma de los dígitos del número
        while (numero > 0) {
            sumaDigitos += numero % 10; // Obtener el último dígito y sumarlo
            numero /= 10; // Eliminar el último dígito
        }

        // Comprobar si el número es divisible por la suma de sus dígitos
        return n % sumaDigitos == 0;
    }

}


