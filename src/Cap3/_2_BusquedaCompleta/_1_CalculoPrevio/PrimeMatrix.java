package Cap3._2_BusquedaCompleta._1_CalculoPrevio;
import java.util.*;

// El enunciado nos pide construir una matriz de números enteros de tamaño tamanyMatriu x tamanyMatriu
// donde no se repite ningún número por cada fila y la suma de cada fila es un número primo.
// Además, ningún número de la matriz puede ser mayor que numeroLimit.
// Para las columnas, se aplican las mismas restricciones que para las filas.

// Solución constructiva:
// Asumir que nuestra fila inicial es la secuencia de números del 1 al tamanyMatriu.
// Buscar el primer número primo que sea mayor o igual a la suma de esta fila inicial.
// Si la suma inicial es igual al primo encontrado, simplemente llenamos la lista.
// Si no, eliminamos el número que hace que la suma sea igual al primo encontrado.
// Finalmente, verificamos si el último número de la lista es mayor que numeroLimit.
// Las filas restantes se construyen rotando circularmente la lista inicial de números.

// De esta forma se busca el conjunto de números más pequeño posible que cumpla con las restricciones dadas.
// Si el más pequeño conjunto no cumple con las restricciones, se imprime "impossible".


public class PrimeMatrix {
    static int _tamany_criba = 0;
    static boolean[] bs;
    static ArrayList<Integer> primos = new ArrayList<>();

    public static void cribaErastotenes(int upperbound) {
        _tamany_criba = upperbound + 1;
        bs = new boolean[Math.max(_tamany_criba, 10_000_010)];
        Arrays.fill(bs, true);
        bs[0] = bs[1] = false;

        for (int i = 2; i < _tamany_criba; i++) {
            if (bs[i]) {
                for (int j = i * i; j < _tamany_criba; j += i) {
                    bs[j] = false;
                }
                primos.add(i);
            }
        }
    }

    public static void main(String[] args) {
        cribaErastotenes(1277);  // El mínim primer més gran que sum(1..50)

        Scanner scanner = new Scanner(System.in);
        int tamanyMatriu = scanner.nextInt();
        int numeroLimit = scanner.nextInt();

        //Calcular la suma inicial de la primera fila sum (1..tamanyMatriu)
        int initSum = (tamanyMatriu * (tamanyMatriu + 1)) / 2;

        // Buscar el primer número primo que sea mayor o igual a initSum
        int targetPrime = -1;
        for (int p : primos) {
            if (p >= initSum) {
                targetPrime = p;
                break;
            }
        }

        //Construye la primera fila de la matriz
        List<Integer> nums = new ArrayList<>();
        // Si la suma inicial no es igual al primo encontrado, ajustamos la lista
        // eliminando aquel número que hace que la suma sea igual al primo encontrado
        if (targetPrime != initSum) {
            int diff = targetPrime - initSum;
            int x = tamanyMatriu + 1 - diff;

            for (int i = 1; i <= tamanyMatriu + 1; i++) {
                if (i != x) {
                    nums.add(i);
                }
            }
        } else {
            // Si la suma inicial es igual al primer primo encontrado, simplemente llenamos la lista
            for (int i = 1; i <= tamanyMatriu; i++) {
                nums.add(i);
            }
        }

        // Verificar si el último número de la lista es mayor que el límite, si lo es -> imposible
        if (nums.get(nums.size() - 1) > numeroLimit) {
            System.out.println("impossible");
        } else {
            // Imprimir la primera fila
            // y el resto de filas con rotación circular
            for (int i = 0; i < tamanyMatriu; i++) {
                for (int j = 0; j < nums.size(); j++) {
                    System.out.print(nums.get(j));
                    if (j < nums.size() - 1) System.out.print(" ");
                }
                System.out.println();
                // Rota la llista (circular shift)
                int first = nums.remove(0);
                nums.add(first);
            }
        }
    }
}
