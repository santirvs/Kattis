package Cap3._2_BusquedaCompleta._9_SimulacionMatematicaDificiles;

// Buscar por fuerza bruta
// El límite lo marca el último planeta.
// A partir de ahí, debemos eliminar toda la población que exceda del planeta siguiente y tomar la población restante como nueva referencia.
// Si alguna población pasa a ser negativa, se considerará imposible y se imprimirá "1"

// v1. WA en Caso#11


import java.util.Scanner;

public class ThanosTheHero_WA {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int numPlanetas = scan.nextInt();
        //Leer los planetas
        int[] poblacion = new int[numPlanetas];
        for (int i = 0; i < numPlanetas; i++) {
            poblacion[i] = scan.nextInt();
        }

        // Revisar los planetas de atrás hacia adelante
        int poblacionEliminada = 0;
        for (int i = numPlanetas - 1; i > 0; i--) {
            // Si la población del planeta actual es menor o igual que la del anterior, eliminar la diferencia
            if (poblacion[i] <= poblacion[i-1]) {
                poblacionEliminada += poblacion[i-1] - poblacion[i] +1;
                poblacion[i-1] = poblacion[i]-1; // Ajustar la población del planeta actual
            }
            // Si la población del planeta actual es negativa, es imposible
            if (poblacion[i] < 0) {
                System.out.println("1"); // Imposible,aquí se acaba el programa
                return;
            }
        }

        // Si hemos llegado hasta aquí, es posible eliminar la población
        System.out.println(poblacionEliminada);
        scan.close();


    }
}
