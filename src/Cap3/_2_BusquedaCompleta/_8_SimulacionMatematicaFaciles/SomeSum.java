package Cap3._2_BusquedaCompleta._8_SimulacionMatematicaFaciles;

// Búsqueda completa
// Se eligen N números consecutivos entre 1 y 100. ¿La suma de esos números es par o impar?
// Si elige 1, puede ser tanto par como impar.
// Si elige 2, la suma es impar (ya que será la suma de un par y un impar o bien de un impar y un par)
// Si elige 3, habrán dos pares y un impar (que suman un impar) o bien dos impares y un par (que suman un par).
// Si elige 4, la suma es par (ya que será la suma de dos pares y dos impares).
// Si elige 5, es como si elige 1 y 4 más (que ya hemos visto que es par)
// Si elige 6, es como si elige 2 y 4 más (que ya hemos visto que es impar)

// Por lo tanto, la elección de N números consecutivos se puede reducir a 4 casos

// 1. N % 4 == 0 -> Par
// 2. N % 4 == 1 -> Par / Impar
// 3. N % 4 == 2 -> Impar
// 4. N % 4 == 3 -> Par / Impar

import java.util.Scanner;

public class SomeSum {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Leer el número de corredores
        int numero = scan.nextInt();

        switch(numero%4){
            case 0:
                System.out.println("Even");
                break;
            case 1:
                System.out.println("Either");
                break;
            case 2:
                System.out.println("Odd");
                break;
            case 3:
                System.out.println("Either");
                break;
        }

    }

}


