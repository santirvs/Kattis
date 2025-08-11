package Cap3._2_BusquedaCompleta._8_SimulacionMatematicaFaciles;

// Búsqueda completa
// La solución se encuentra entre L y D y son menores de 10_000
// Hacer dos bucles: uno buscará a partir de L hacia arriba y el otro desde D hacia abajo.



import java.util.Scanner;

public class Zamka {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Leer los datos
        int L = scan.nextInt();
        int D = scan.nextInt();
        int X = scan.nextInt();

        // Buscar el primer número que cumple la condición
        int minimo = -1;
        int maximo = -1;
        boolean encontrado = false;
        for (int i = L; i <= D && !encontrado; i++) {
            if (sumaDigitos(i) == X) {
                minimo = i;
                encontrado = true;
            }
        }
        // Buscar el último número que cumple la condición
        encontrado = false;
        for (int i = D; i >= L && !encontrado; i--)
        {
            if (sumaDigitos(i) == X) {
                maximo = i;
                encontrado = true;
            }
        }

        // Imprimir los resultados
        System.out.println(minimo);
        System.out.println(maximo);
        scan.close();
    }

    private static int sumaDigitos(int i) {
        int suma = 0;
        while (i > 0) {
            suma += i % 10; // Sumar el último dígito
            i /= 10; // Eliminar el último dígito
        }
        return suma;
    }
}


