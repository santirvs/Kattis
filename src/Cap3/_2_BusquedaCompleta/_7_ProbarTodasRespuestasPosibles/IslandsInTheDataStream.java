package Cap3._2_BusquedaCompleta._7_ProbarTodasRespuestasPosibles;

// Problema para plantearlo con máscara de bits
// Sólo hay 10 bits variables que pueden formar islas, y únicamente una pequeña porción (55/1023)
// de los 2^10 subconjuntos son contiguos y pueden ser una isla
// Precomputar todos los subconjuntos válidos y luego comprobar cada uno de ellos
// para cada caso de prueba, comprobando que los elementos intermedios son mayores que los
// elementos adyacentes a los extremos del subconjunto


import java.util.*;
import java.io.*;

public class IslandsInTheDataStream {
    static List<Integer> bitmaskValidos = new ArrayList<>();
    static int[] arr = new int[12];

    static void rellenarBitmaskValidos() {
        for (int bm = 1; bm < (1 << 10); bm++) {
            int bitMenosSignificativo = Integer.numberOfTrailingZeros(bm);
            int bitMasSignificativo = (int) (Math.log(bm) / Math.log(2));
            int totalSet = Integer.bitCount(bm);

            // Comprobar que los bits están contiguos (hay tantos activos como la diferencia entre los bits más y menos significativos + 1)
            if (totalSet == (bitMasSignificativo - bitMenosSignificativo + 1)) {
                bitmaskValidos.add(bm);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //Precalcular la lista de bitmasks válidos
        rellenarBitmaskValidos();

        Scanner scan = new Scanner(System.in);

        //Leer el número de caso y los 12 elementos del array
        int numCasos = scan.nextInt();
        for (int cNum = 1; cNum <= numCasos; cNum++) {
            int setNumber = scan.nextInt();
            for (int i = 0; i < 12; i++) {
                arr[i] = scan.nextInt();
            }

            // Contar el número de islas
            int islands = 0;
            // Probar cada bitmask válido
            // Comprobar que los elementos intermedios son mayores que los elementos adyacentes
            for (int bm : bitmaskValidos) {
                // Obtener el bit más alto y más bajo
                int leastSig = Integer.numberOfTrailingZeros(bm);
                int mostSig = (int) (Math.log(bm) / Math.log(2));

                // Comprobar que los extremos del bitmask son válidos
                // Cada uno de los extremos debe ser menor que los elementos de la isla
                // Si no lo son, no es una isla válida
                boolean valid = true;
                int elementBefore = arr[mostSig + 2];
                int elementAfter = arr[leastSig];
                int maxImmediate = Math.max(elementBefore, elementAfter);

                for (int i = leastSig + 1; i < mostSig + 2; i++) {
                    if (arr[i] <= maxImmediate) {
                        valid = false;
                        break;
                    }
                }
                if (valid) islands++;
            }
            System.out.println(setNumber + " " + islands);
        }
    }
}
