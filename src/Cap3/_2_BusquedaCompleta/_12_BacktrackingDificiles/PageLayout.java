package Cap3._2_BusquedaCompleta._12_BacktrackingDificiles;

// Resolver mediante backtracking
// Ir probando todos las historias posibles, si la historia no se sobrepone con ninguna de las existentes, se añade
// La cuestión es como verificar si se superpone o no con alguna de las anteriores
// Si se hace una matriz de booleanos, se puede comprobar si dos historias se superponen entre ellas,
// pero en el backtracking, no sabemos cuáles de las historias anteriores se han añadido ya
// Si se hace con una matriz de booleanos de 1000x1000 se va marcando el espacio ocupado por cada historia, pero en cada llamada
// de backtracking se tendría que copiar la matriz de booleanos, lo cual es muy costoso
// Otra opción es marcar el espacio en la matriz de booleanos y desmarcarlo al volver atrás, es constante en memoria aunque lento

// v1. TLE en Caso #2, es necesario optimizar el backtracking
// v2. En lugar de usar una matriz de booleanos para marcar el espacio usado, se usará un array de estados
//      donde cada historia puede estar en 3 estados: 0 (no asignada), -1 (excluida) o 1 (incluida)
//      Antes de añadir una nueva historia, se comprueba si se superpone con alguna de las historias ya asignadas
//      La comprobación de superposición se hace mediante la función hayInterseccion2 que comprueba que un anuncio
//      se encuentra más allá de los límites del otro anuncio. Esto evita el overhead de reescribir la matriz de booleanos
//      --> AC para todos los casos

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PageLayout {

    static class Historia {
        int ancho;
        int alto;
        int x;
        int y;

        public Historia(int ancho, int alto, int x, int y) {
            this.ancho = ancho;
            this.alto = alto;
            this.x = x;
            this.y = y;
        }
    }

    static int estados[] = new int[20];  // Como máximo hay 20 historias, se usa un array de estados
    static int numHistorias; // Número de historias que se pueden añadir a la página
    static int maxSuperficie; // Máximo número de historias que se pueden añadir a la página
    static List<Historia> historias; // Lista de historias que se pueden añadir a la página

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        // Leer el número de historias
        int numHistorias = scan.nextInt();
        while (numHistorias > 0) {
            // Inicializar las variables globales para cada caso
            Arrays.fill(estados, 0); // Inicializar todos los estados a 0 (no asignada)
            historias = new ArrayList<Historia>();
            maxSuperficie = 0;

            // Leer las historias que se pueden añadir a la página
            for (int i = 0; i < numHistorias; i++) {
                // Leer el número de historias que se pueden añadir a la página
                int ancho = scan.nextInt();
                int alto = scan.nextInt();
                int x = scan.nextInt();
                int y = scan.nextInt();

                historias.add( new Historia(ancho, alto, x, y) );
            }

            backtracking(0,0);

            // Mostrar el resultado
            System.out.println(maxSuperficie);

            // Siguiente caso
            numHistorias = scan.nextInt();
        }

    }

    private static void backtracking(int numHistoria, int superficie) {

        //Caso directo de finalización
        if (numHistoria == historias.size()) {
            // Hemos llegado al final de la lista de historias
            maxSuperficie = Math.max(maxSuperficie, superficie);
            return;
        }
        // Caso recursivo. Probar a añadir la historia actual
        Historia historiaActual = historias.get(numHistoria);
        // Comprobar si la historia actual se puede añadir a la página
        if (puedeAñadirHistoria(historiaActual)) {
            // Si se puede añadir, se marca el espacio ocupado por la historia
            estados[numHistoria] = 1;
            // Se llama al backtracking para la siguiente historia
            backtracking(numHistoria + 1, superficie + (historiaActual.ancho * historiaActual.alto));
            // Desmarcar el espacio ocupado por la historia al volver atrás
            estados[numHistoria] = 0;
        }
        // Caso recursivo. Probar a no añadir la historia actual
        estados[numHistoria] = -1; // Marcar la historia como excluida
        backtracking(numHistoria + 1, superficie);
    }

    private static void marcarHistoria(int historiaActual, int valor) {
        estados[historiaActual] = valor;
    }

    private static boolean puedeAñadirHistoria(Historia historiaActual) {
        // Comprobar si la historia actual se puede añadir a la página
        for (int i = 0; i < estados.length; i++) {
            if (estados[i] == 1) { // Si la historia ya está asignada
                Historia historiaAsignada = historias.get(i);
                // Comprobar si hay intersección entre la historia actual y la asignada
                if (hayInterseccion(historiaActual, historiaAsignada)) {
                    return false; // La historia no se puede añadir, hay superposición
                }
            }
        }

        return true; // La historia se puede añadir a la página
    }

    private static boolean hayInterseccion(Historia h1, Historia h2) {
        return hayInterseccion2(h1.ancho, h1.alto, h1.x, h1.y,
                                h2.ancho, h2.alto, h2.x, h2.y);
    }

    static boolean hayInterseccion2(int w1, int h1, int x1, int y1,
                                   int w2, int h2, int x2, int y2) {
        if (x1 > x2) {
            // intercambiar para asegurar que ad1 está a la izquierda de ad2
            int tmp;
            tmp = x1; x1 = x2; x2 = tmp;
            tmp = y1; y1 = y2; y2 = tmp;
            tmp = w1; w1 = w2; w2 = tmp;
            tmp = h1; h1 = h2; h2 = tmp;
        }

        // Si ad2 está más allá del límite de ad1, no hay intersección
        if (x1 + w1 - 1 < x2) return false; // ad1 acaba abans que comenci ad2
        if (y1 + h1 - 1 < y2) return false; // ad1 està per sota d’ad2
        if (y2 + h2 - 1 < y1) return false; // ad2 està per sota d’ad1

        return true;
    }

}
