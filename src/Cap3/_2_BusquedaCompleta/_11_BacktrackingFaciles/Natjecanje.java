package Cap3._2_BusquedaCompleta._11_BacktrackingFaciles;

// Cada equipo tiene 4 opciones:
//  1.- No hacer nada
//  2.- Usar el kayak de reserva (si lo tiene dañado)
//  3.- Pasar el kayak a su vecino de la izquierda (si ellos lo tienen dañado y nosotros no)
//  4.- Pasar el kayak a su vecino de la derecha (si ellos lo tienen dañado y nosotros no)

// Mapear el estado de cada equipo con 3 valores:
//  0: tiene kayak normal o prestado (puede competir)
// -1: tiene kayak dañado (no puede competir)
//  1: tiene kayak de reserva (puede competir y tiene bote extra)


import java.util.*;

public class Natjecanje {

    static int numEquipos, numDanyados, numReservas;
    static List<Integer> vEquipos = new ArrayList<>();

    // Función recursiva de backtracking
    static int backtrack(int equiposProcesados) {
        // Caso base: hemos procesado todos los equipos
        if (equiposProcesados == numEquipos) {
            int respuesta = 0;
            for (int val : vEquipos) {
                if (val == -1) respuesta++; // equipo que no puede competir
            }
            return respuesta;
        }

        // Cada elemento de vEquipos puede ser:
        // -1: equipo dañado (no puede competir)
        //  0: equipo con kayak normal o prestado (puede competir)
        //  1: equipo con kayak de reserva (puede competir y tiene bote extra)

        // Si no tiene bote extra, continuar
        if (vEquipos.get(equiposProcesados) != 1) return backtrack(equiposProcesados + 1);

        int ans = Integer.MAX_VALUE;

        if (equiposProcesados == 0) {
            // Si está al inicio, solo puede pasar a su vecino derecho, si es que lo necesita (-1)
            if (vEquipos.get(1) == -1) {
                vEquipos.set(1, 0);
                vEquipos.set(0, 0);
                ans = backtrack(equiposProcesados + 1);
                // Restaurar el estado anterior
                vEquipos.set(1, -1);
                vEquipos.set(0, 1);
            } else {
                ans = backtrack(equiposProcesados + 1);
            }
            return ans;
        }
        else if (equiposProcesados == numEquipos - 1) {
            // Si está al final, solo puede pasar a su vecino izquierdo, si lo necesita (-1)
            if (vEquipos.get(equiposProcesados - 1) == -1) {
                vEquipos.set(equiposProcesados - 1, 0);
                vEquipos.set(equiposProcesados, 0);
                ans = backtrack(equiposProcesados + 1);
                // Restaurar el estado anterior
                vEquipos.set(equiposProcesados - 1, -1);
                vEquipos.set(equiposProcesados, 1);
            } else {
                ans = backtrack(equiposProcesados + 1);
            }
            return ans;
        }
        else {
            // Caso general: puede pasar a antes o después
            ans = backtrack(equiposProcesados + 1); // no pasa nada

            // Pasar a la izquierda
            if (vEquipos.get(equiposProcesados - 1) == -1) {
                vEquipos.set(equiposProcesados - 1, 0);
                vEquipos.set(equiposProcesados, 0);
                ans = Math.min(ans, backtrack(equiposProcesados + 1));
                vEquipos.set(equiposProcesados - 1, -1);
                vEquipos.set(equiposProcesados, 1);
            }

            // Pasar a la derecha
            if (vEquipos.get(equiposProcesados + 1) == -1) {
                vEquipos.set(equiposProcesados + 1, 0);
                vEquipos.set(equiposProcesados, 0);
                ans = Math.min(ans, backtrack(equiposProcesados + 1));
                vEquipos.set(equiposProcesados + 1, -1);
                vEquipos.set(equiposProcesados, 1);
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer los datos del problema
        numEquipos = sc.nextInt();
        numDanyados = sc.nextInt();
        numReservas = sc.nextInt();

        // Inicializar vector de equipos
        for (int i = 0; i < numEquipos; i++) {
            // Cada equipo comienza con su propio kayak
            vEquipos.add(0);
        }

        // Leer equipos dañados
        for (int i = 0; i < numDanyados; i++) {
            int x = sc.nextInt();
            // Restamos 1 si el kayak está dañado
            vEquipos.set(x - 1, vEquipos.get(x - 1) - 1);
        }

        // Equipos con bote extra
        for (int i = 0; i < numReservas; i++) {
            int x = sc.nextInt();
            // Sumamos 1 si el equipo tiene un kayak de reserva
            vEquipos.set(x - 1, vEquipos.get(x - 1) + 1);
        }

        // Ejecutar backtracking
        System.out.println(backtrack(0));
        sc.close();
    }
}
