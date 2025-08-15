package Cap3._2_BusquedaCompleta._11_BacktrackingFaciles;

// Dado que el límite es relativmente pequeño (<200)
// generar todos los números posibles y buscar el más cercano

import java.util.*;

public class GoodMorning {

  static List<Integer> numerosPosibles = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        generarNumerosPosibles(200); // Generar números posibles hasta 200

        int numCasos = sc.nextInt(); // número de casos de prueba
        for (int i = 0; i < numCasos; i++) {
            int numero = sc.nextInt(); // número a analizar
            int resultado = encontrarNumeroCercano(numero);

            System.out.println(resultado); // Imprimir el número más cercano
        }
    }

    private static void generarNumerosPosibles(int limite) {
        for (int j = 0; j <= limite; j++) {
            if (esPosible(j)) {
                numerosPosibles.add(j);
            }
        }
        // Ordenar la lista para facilitar la búsqueda
        Collections.sort(numerosPosibles);
    }

    private static boolean esPosible(int j) {
        // Verificar si el número es posible según las reglas del problema
        // No podemos movernos hacia arriba ni hacia la izquierda
        // La disposición del tablero es:
        // 1 2 3
        // 4 5 6
        // 7 8 9
        //   0

        // Para facililar las cosas, miraremos desde atrás hacia adelante y sólo permitiremos subir o movernos a la izquierda
        int fila = 4;
        int columna = 3;
        while (j > 0) {
            int digito = j % 10; // Obtener el último dígito
            j /= 10; // Eliminar el último dígito

            // Verificar si el dígito es válido en la posición actual
            int filaDestino;
            int columnaDestino;
            switch (digito) {
                case 0:
                    filaDestino = 3;
                    columnaDestino = 1;
                    break;
                case 1:
                    filaDestino = 0;
                    columnaDestino = 0;
                    break;
                case 2:
                    filaDestino = 0;
                    columnaDestino = 1;
                    break;
                case 3:
                    filaDestino = 0;
                    columnaDestino = 2;
                    break;
                case 4:
                    filaDestino = 1;
                    columnaDestino = 0;
                    break;
                case 5:
                    filaDestino = 1;
                    columnaDestino = 1;
                    break;
                case 6:
                    filaDestino = 1;
                    columnaDestino = 2;
                    break;
                case 7:
                    filaDestino = 2;
                    columnaDestino = 0;
                    break;
                case 8:
                    filaDestino = 2;
                    columnaDestino = 1;
                    break;
                case 9:
                    filaDestino = 2;
                    columnaDestino = 2;
                    break;
                default:
                    return false; // Dígito no válido
            }

            if (filaDestino <= fila && columnaDestino <= columna) {
                // Si el dígito es válido, actualizar la posición
                fila = filaDestino;
                columna = columnaDestino;
            } else {
                // Si no es válido, retornar false
                return false;
            }

        }
        return true;
    }

    private static int encontrarNumeroCercano(int numero) {
        int masCercano = numerosPosibles.get(0);

        for (int posible : numerosPosibles) {
            if (Math.abs(posible-numero) < Math.abs(masCercano-numero)) {
                masCercano = posible;
            }
        }
        return masCercano;
    }

}
