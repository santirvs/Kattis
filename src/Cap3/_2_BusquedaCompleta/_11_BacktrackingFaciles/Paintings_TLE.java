package Cap3._2_BusquedaCompleta._11_BacktrackingFaciles;

// Probar todas las combinaciones de colores de pinturas
// y saltar aquellas que no sean válidos

// v1. TLE en Caso #7
// v2. Optimización en backtracking para evitar overhead --> TLE en Caso #8

import java.util.*;

public class Paintings_TLE {
    static int respuestas;
    static String solPreferida;
    static Map<String, Integer> mascaraColores;
    static List<String> colores;
    static Map<String, Set<String>> paresHorribles;
    static List<String> solucion;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numCasos = scan.nextInt();

        for (int caso = 0; caso < numCasos; caso++) {
            int n = scan.nextInt();
            scan.nextLine(); // Consumir el salto de línea
            colores = Arrays.asList(scan.nextLine().split(" "));

            // Inicializar colourMask
            mascaraColores = new HashMap<>();
            for (String c : colores) {
                mascaraColores.put(c, 1);
            }

            // Leer los pares de colores horribles
            int num_horribles = scan.nextInt();
            scan.nextLine();
            paresHorribles = new HashMap<>();

            for (int i = 0; i < num_horribles; i++) {
                String[] ab = scan.nextLine().split(" ");
                String a = ab[0], b = ab[1];

                paresHorribles.computeIfAbsent(a, k -> new HashSet<>()).add(b);
                paresHorribles.computeIfAbsent(b, k -> new HashSet<>()).add(a);
            }

            // Preparar para la búsqueda, la respuesta y la primera solución (la preferida)
            respuestas = 0;
            solPreferida = "";
            solucion = new ArrayList<>();

            // Iniciar el backtracking
            // Comenzamos con una cadena vacía para el color previo
            backtrack("");

            System.out.println(respuestas);
            System.out.println(solPreferida);
        }

        scan.close();
    }

    static void backtrack(String colorPrevio) {

        int sum = 0;
        for (int val : mascaraColores.values()) {
            sum += val;
        }
        if (sum == 0) {
            // Caso base: todos los colores usados

            // Ya se han usado todos los colores, de forma que tenemos una solución
            // colourMask -> 1 disponible, 0 usado
            // Solución encontrada, incrementar el contador de soluciones
            respuestas++;
            if (respuestas == 1) {
                // Guardar la primera solución encontrada como la preferida
                solPreferida = String.join(" ", solucion);
            }
            return;
        }

        for (String color : colores) {
            // El color ya está usado
            if (mascaraColores.get(color) == 0) continue;
            // El color combina mal con el color previo, saltarlo
            if (paresHorribles.containsKey(colorPrevio) && paresHorribles.get(colorPrevio).contains(color)) continue;

            // Uso el color, lo marco como usado en la máscara y lo añado a la solución
            mascaraColores.put(color, 0);
            solucion.add(color);

            // Llamada recursiva para seguir con el siguiente color
            backtrack(color);

            // Deshacer el paso: quitar el color de la solución y marcarlo como disponible
            // (backtracking)
            solucion.remove(solucion.size() - 1);
            mascaraColores.put(color, 1);
        }
    }
}
