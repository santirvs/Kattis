package Cap3._3_DivideYVenceras._2_BiseccionBSTAFaciles;

// Estrategia de D&C. Bisección binaria

// Nos piden únicamente el peso máximo que se debe cargar en dos filas de pesas
// de forma que se emparejen correctamente los pesos. Eso significa que podemos mover
// libremente los pesos menores a ese peso máximo.
// Se toman todos los pesos, se eliminan duplicados y se ordenan.
// Luego se realiza una bisección binaria sobre los pesos únicos y ordenados.
// Para cada peso, se verifica si cada una de las filas quedaría ordenada.
// Los pesos inferiores o iguales al peso máximo se ignoran, verificando únicamente que los pesos mayores
// queden emparejados correctamente.

import java.util.*;

public class FreeWeights {
    static int numPares;
    static int[] fila1, fila2;
    static List<Integer> pesosOrdenados = new ArrayList<>();

    // Méthodo para verificar si se puede cargar un peso w
    // en ambas filas de forma que se emparejen correctamente
    // Los pesos se emparejan si son iguales y se ignoran los que son menores
    // o iguales al peso w.
    // Si se encuentra un peso que no se puede emparejar, se devuelve false.
    // Si todos los pesos se emparejan correctamente, se devuelve true.
    static boolean check(int w) {
        return checkFila(w, fila1) && checkFila(w, fila2);
    }

    static boolean checkFila(int w, int[] fila) {
        int previous = -1;

        // Recorrer la fila y verificar los pesos
        // Ignorar los pesos menores o iguales al peso w
        for (int i = 0; i < numPares; i++) {
            if (fila[i] <= w) continue; // ignorar si el peso es menor o igual al límite
            if (previous != -1) {
                if (fila[i] == previous) {
                    previous = -1; // se empareja correctamente
                } else {
                    return false; // falla
                }
            } else {
                previous = fila[i];
            }
        }
        return (previous == -1);  // si queda un peso sin emparejar, falla
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Leer el número de pares de pesos
        numPares = scan.nextInt();
        fila1 = new int[numPares];
        fila2 = new int[numPares];

        // Leer los pesos de la primera fila
        // Usar un TreeSet para mantener los pesos únicos y ordenados
        TreeSet<Integer> s = new TreeSet<>();
        for (int i = 0; i < numPares; i++) {
            fila1[i] = scan.nextInt();
            s.add(fila1[i]);
        }
        // Leer los pesos de la segunda fila
        // Agregar los pesos de la segunda fila al mismo TreeSet
        for (int i = 0; i < numPares; i++) {
            fila2[i] = scan.nextInt();
            s.add(fila2[i]);
        }

        s.add(0); // también considerar peso 0
        pesosOrdenados.addAll(s);

        // Búsqueda binaria sobre pesosOrdenados
        int menor = 0, mayor = pesosOrdenados.size() - 1;
        while (menor + 1 < mayor) {
            int medio = (menor + mayor) / 2;
            int pesoMedio = pesosOrdenados.get(medio);
            if (check(pesoMedio)) {
                mayor = medio; // podemos cargar este peso, probamos con menor
            } else {
                menor = medio + 1; // necesitamos más peso
            }
        }

        if (check(pesosOrdenados.get(menor))) {
            System.out.println(pesosOrdenados.get(menor));
        } else {
            System.out.println(pesosOrdenados.get(mayor));
        }
    }
}
