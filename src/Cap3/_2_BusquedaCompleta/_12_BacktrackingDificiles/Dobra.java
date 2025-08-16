package Cap3._2_BusquedaCompleta._12_BacktrackingDificiles;

// Backtracking para encontrar total de palabras que se pueden formar
// sustituendo los "_" por letras del abecedario
// y que cumplan las restricciones:
//   - No más de 3 consonantes consecutivas
//   - No más de 3 vocales consecutivas
//   - Debe haber al menos una letra L


// v1. TLE en Caso #7.
// v2. Desactivar el DEBUG para evitar overhead. No es suficiente sigue el TLE en Caso #7
// v3. Evitar revisar si ya hay una L en la palabra al final del backtracking. Sigue sin ser suficiente
// v4. No es necesario probar todas las letras del abecedario, sino que hay que diferenciar 3 grupos
//      - Vocales (A, E, I, O, U)  --> Si es válido, multiplicar por 5 las combinaciones siguientes, tomar la A como referencia
//      - Consonantes que no son L --> Si es válido multiplicar por 20 las combinaciones siguientes, tomar la B como referencia
//      - L --> Si es válido, multiplicar por 1 las combinaciones siguientes
//  v5. AC en Caso#7, pero WA en Caso #8
//  v6. El número de palabras puede ser muy elevado. Usar long! --> AC

import java.util.Scanner;


public class Dobra {

    static long numPalabras = 0;
    static long peso = 1; // Peso para las combinaciones finales
    static char[] palabra;
    static Scanner scan = new Scanner(System.in);
    static boolean hayL = false; // Variable para saber si ya hay una L en la palabra

    public static void main(String[] args) {

        // Leer la palabra
        palabra = scan.nextLine().toCharArray();

        hayL = new String(palabra).contains("L"); // Comprobar si ya hay una L en la palabra

        // Llamar al backtracking para la posicion inicial
        backtracking(0);

        // Imprimir el número máximo de capturas
        System.out.println(numPalabras);

    }

    // Backtracking para contar el número de palabras válidas
    // desde la posición indicada.
    // Se asume que si llegamos a una posición, se cumplen las restricciones hasta la posición anterior.
    private static void backtracking(int posicion) {
        // Casos directos de finalización
        if (posicion == palabra.length) {
            // Si hemos llegado al final, comprobamos si hay al menos una L
            if (hayL) {
                // DEBUG: imprimir la palabra válida
                //imprimirPalabra(false);
                numPalabras+=peso;
                return;
            }
            //DEBUG: imprimir la palabra descartada
            //imprimirPalabra(true);
            return; // No hay L, no contamos esta palabra
        }

        // Si la posición actual ya tiene una letra, continuamos al siguiente carácter
        if (palabra[posicion] != '_') {
            backtracking(posicion + 1);
            return;
        }

        // Si la posición actual es un "_", probamos con todas las letras mayúsculas del abecedario
        // OPTIMIZACIÓN: Se toman 3 grupos (vocales (x5), L y consonantes(x21)) para evitar probar todas las letras del abecedario
        char[] letras = {'A','B','L'};
        int[] pesos = {5, 20, 1}; // Pesos para las combinaciones siguientes
        for (int i=0; i<3; i++) {
            // Asignamos la letra a la posición actual
            palabra[posicion] = letras[i];
            boolean habiaLAnterior = hayL; // Guardamos el estado de si ya había una L
            long pesoAnterior = peso; // Guardamos el peso anterior
            if (letras[i] == 'L') { hayL = true; }

            // Comprobamos las restricciones de consonantes y vocales consecutivas
            if (restriccionesCumplidas(posicion)) {
                // Si las restricciones se cumplen, continuamos al siguiente carácter
                peso *= pesos[i]; // Actualizamos el peso para las combinaciones siguientes
                backtracking(posicion + 1);
            }

            // Deshacemos el cambio para probar con la siguiente letra
            palabra[posicion] = '_';
            hayL = habiaLAnterior;
            peso = pesoAnterior; // Deshacemos el cambio del peso
        }

    }

    private static void imprimirPalabra(boolean descartada) {
        if (descartada) {
            System.out.println("Descartada la palabra: " + new String(palabra));
        } else {
            System.out.println("**** Palabra válida: " + new String(palabra) + " ****");
        }
    }

    // Comprobar que al colocar la letra en la posición actual se siguen cumpliendo las restricciones
    // de no haber 3 consonantes seguidas ni 3 vocales seguidas.
    // Asumir que hasta la posición anterior se cumplen las restricciones.
    // Devuelve true si se cumplen las restricciones, false en caso contrario.
    private static boolean restriccionesCumplidas(int posicion) {
        // Comprobar que no hay 3 consonantes seguidas
        int consonantesConsecutivas = 0;
        int vocalesConsecutivas = 0;
        for (int i = Math.min(palabra.length-1,posicion+2); i >= 0 && i > posicion - 3; i--) {
            char c = palabra[i];
            // Si encontramos un espacio vacío, no podemos comprobar las restricciones
            if (c == '_') {
                //Espacio vacío, no podemos comprobar las restricciones. Reiniciar contadores
                consonantesConsecutivas = 0;
                vocalesConsecutivas = 0;
                continue;
            }
            if (esVocal(c)) {
                vocalesConsecutivas++;
                consonantesConsecutivas = 0; // Reiniciar contador de consonantes
            } else {
                consonantesConsecutivas++;
                vocalesConsecutivas = 0; // Reiniciar contador de vocales
            }
            // Si hay 3 consonantes o 3 vocales consecutivas, no se cumplen
            if (consonantesConsecutivas > 2 || vocalesConsecutivas > 2) {
                //DEBUG: imprimir la palabra descartada
                //imprimirPalabra(true);
                return false;
            }
        }
        // Si hemos llegado hasta aquí, las restricciones se cumplen
        return true;
    }

    private static boolean esVocal(char c) {
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

}
