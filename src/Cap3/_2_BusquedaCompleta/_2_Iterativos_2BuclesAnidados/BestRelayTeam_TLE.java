package Cap3._2_BusquedaCompleta._2_Iterativos_2BuclesAnidados;

// No parece demasiado complejo.
// Iterar todas las combinaciones de corredores sumando sus tiempos
// En cada combinación, iterar todos los corredores para tomar su tiempo de arranque
// Quedarse con la combinación que tenga el menor tiempo total y apuntarse el primer corredor
// Esto son 500 * 499 * 498 * 497 = 61,5 M de combinaciones --> TLE?

// v1. TLE en Caso de Prueba 6, como ya me temía...


import java.util.Locale;
import java.util.Scanner;

public class BestRelayTeam_TLE {

    static class Corredor {
        String nombre;
        float tiempoArranque;
        float tiempoSprint;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.UK);
        int numCorredores = scan.nextInt(); // Número de corredores

        //Lista de corredores
        Corredor[] corredores = new Corredor[numCorredores];

        //Equipo seleccionado
        Corredor[] equipoSeleccionado = new Corredor[4];
        float mejorTiempo = Float.MAX_VALUE; // Inicializar con el mayor valor posible

        //Cargar los corredores
        while (numCorredores-- > 0) {
            corredores[numCorredores] = new Corredor();
            corredores[numCorredores].nombre = scan.next(); // Nombre del corredor
            corredores[numCorredores].tiempoArranque = scan.nextFloat(); // Tiempo de arranque
            corredores[numCorredores].tiempoSprint = scan.nextFloat(); // Tiempo de sprint
        }

        // Iterar todas las combinaciones de corredores
        for (int i = 0; i < corredores.length-3; i++) {
            for (int j = i+1; j < corredores.length-2; j++) {
                for (int k = j+1; k < corredores.length-1; k++) {
                    for (int l = k+1; l < corredores.length; l++) {
                        // Calcular el tiempo total de la combinación
                        float tiempoTotal = corredores[i].tiempoSprint +
                                corredores[j].tiempoSprint +
                                corredores[k].tiempoSprint +
                                corredores[l].tiempoSprint;

                        // Iterar los tiempos de arranque
                        float tiempoAjustado = 0;
                        for (int m = 0; m < 4; m++) {
                            switch (m) {
                                case 0:
                                    tiempoAjustado = tiempoTotal - corredores[i].tiempoSprint + corredores[i].tiempoArranque;
                                    break;
                                case 1:
                                    tiempoAjustado = tiempoTotal - corredores[j].tiempoSprint + corredores[j].tiempoArranque;
                                    break;
                                case 2:
                                    tiempoAjustado = tiempoTotal - corredores[k].tiempoSprint + corredores[k].tiempoArranque;
                                    break;
                                case 3:
                                    tiempoAjustado = tiempoTotal - corredores[l].tiempoSprint + corredores[l].tiempoArranque;
                                    break;
                            }

                            // Comprobar si es el mejor tiempo
                            if (tiempoAjustado < mejorTiempo) {
                                mejorTiempo = tiempoAjustado;
                                // Guardar el equipo seleccionado
                                equipoSeleccionado[0] = corredores[i];
                                equipoSeleccionado[1] = corredores[j];
                                equipoSeleccionado[2] = corredores[k];
                                equipoSeleccionado[3] = corredores[l];
                                // Ajustar el primer corredor
                                Corredor aux = equipoSeleccionado[m];
                                equipoSeleccionado[m] = equipoSeleccionado[0];
                                equipoSeleccionado[0] = aux; // El primer corredor es el que arranca
                            }
                        }
                    }
                }
            }
        }

        // Imprimir el equipo seleccionado
        System.out.println(mejorTiempo);
        for (int i = 0; i < equipoSeleccionado.length; i++) {
            System.out.println(equipoSeleccionado[i].nombre);
        }

    }

}
