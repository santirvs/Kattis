package Cap3._2_BusquedaCompleta._8_SimulacionMatematicaFaciles;

// Problema sencillo de simulación por búsqueda completa.
// Calcular el número de grupos que se pueden formar
// Dividir el número de puentes entre el número de grupos.
// Si la división no es exacta necesitaremos un día más.

// v1 -> WA en Caso de prueba #3
// v2 -> Hay que darse cuenta de que no se debe buscar en el puente donde se encontraba el troll inicialmente.


import java.util.Scanner;

public class TrollHunt {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Leer los datos
        int numPuentes = scan.nextInt()-1;  // Descontar el puente donde se encuentra el troll inicialmente
        int numCaballeros = scan.nextInt();
        int cantidadPorGrupo = scan.nextInt();

        // Calcular el número de grupos
        int numGrupos = numCaballeros / cantidadPorGrupo; // Número de grupos completos

        // Calcular el número de días
        int numDias = numPuentes / numGrupos; // Número de días completos
        int sobrantePuentes = numPuentes % numDias; // Puentes sobrantes
        if (sobrantePuentes > 0) {
            numDias++; // Si hay más de un puente sobrante, se necesita un día más
        }

        // Imprimir el número de días
        System.out.println(numDias);

    }


}


