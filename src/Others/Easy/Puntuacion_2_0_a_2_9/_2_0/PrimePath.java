package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

//Ver PrimePath.md

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrimePath {

    // Tamaño máximo para el array de la criba (números de 4 dígitos: 1000 a 9999)
    private static final int MAX = 10000;
    private static boolean[] esPrimo = new boolean[MAX];

    public static void main(String[] args) {
        // Fase 1: Precomputar los números primos usando la Criba de Eratóstenes
        generarCriba();

        Scanner scan = new Scanner(System.in);
        if (!scan.hasNextInt()) return;

        int numCasos = scan.nextInt();

        // Procesar cada caso de prueba
        for (int i = 0; i < numCasos; i++) {
            int origen = scan.nextInt();
            int destino = scan.nextInt();

            int resultado = resolverBFS(origen, destino);

            if (resultado == -1) {
                System.out.println("Impossible");
            } else {
                System.out.println(resultado);
            }
        }
    }

    // Fase 1: Criba de Eratóstenes
    private static void generarCriba() {
        // Inicializamos asumiendo que todos son primos
        for (int i = 2; i < MAX; i++) {
            esPrimo[i] = true;
        }

        // Algoritmo de la criba
        for (int p = 2; p * p < MAX; p++) {
            if (esPrimo[p]) {
                for (int i = p * p; i < MAX; i += p) {
                    esPrimo[i] = false;
                }
            }
        }
    }

    // Fase 2 y 3: Búsqueda en Anchura (BFS) y generación de vecinos
    private static int resolverBFS(int origen, int destino) {
        if (origen == destino) {
            return 0;
        }

        // Arreglo de distancias. -1 significa "no visitado"
        int[] distancia = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            distancia[i] = -1;
        }

        Queue<Integer> cola = new LinkedList<Integer>();

        // Inicializar el BFS con el nodo origen
        cola.add(origen);
        distancia[origen] = 0;

        while (!cola.isEmpty()) {
            int actual = cola.poll();

            if (actual == destino) {
                return distancia[actual];
            }

            // Convertimos el número actual en un arreglo de 4 dígitos para manipularlo
            int[] digitos = numeroADigitos(actual);

            // Intentar cambiar cada una de las 4 posiciones del número
            for (int i = 0; i < 4; i++) {
                int digitoOriginal = digitos[i];

                // Probar dígitos del 0 al 9 para la posición actual
                for (int nuevoDigito = 0; nuevoDigito <= 9; nuevoDigito++) {
                    // Evitar ceros a la izquierda en la posición de los millares (índice 0)
                    if (i == 0 && nuevoDigito == 0) {
                        continue;
                    }

                    // Si es el mismo dígito que ya tenemos, saltamos
                    if (nuevoDigito == digitoOriginal) {
                        continue;
                    }

                    // Cambiamos el dígito temporalmente
                    digitos[i] = nuevoDigito;
                    int vecino = digitosANumero(digitos);

                    // Verificar si el vecino es primo y no ha sido visitado
                    if (esPrimo[vecino] && distancia[vecino] == -1) {
                        distancia[vecino] = distancia[actual] + 1;
                        cola.add(vecino);
                    }
                }

                // Restauramos el dígito original antes de pasar a la siguiente posición
                digitos[i] = digitoOriginal;
            }
        }

        // Si la cola se vacía sin encontrar el destino, es imposible
        return -1;
    }

    // Función auxiliar: Convierte un entero de 4 dígitos a un arreglo de enteros
    private static int[] numeroADigitos(int num) {
        int[] digitos = new int[4];
        for (int i = 3; i >= 0; i--) {
            digitos[i] = num % 10;
            num /= 10;
        }
        return digitos;
    }

    // Función auxiliar: Convierte un arreglo de 4 dígitos de regreso a un número entero
    private static int digitosANumero(int[] digitos) {
        int num = 0;
        for (int i = 0; i < 4; i++) {
            num = num * 10 + digitos[i];
        }
        return num;
    }
}