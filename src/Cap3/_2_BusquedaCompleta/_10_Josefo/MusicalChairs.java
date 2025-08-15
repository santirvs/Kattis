package Cap3._2_BusquedaCompleta._10_Josefo;

// Problema de Josefo, pero con una variante: el salto es variable

// v1.  WA en Caso #4
// v2.  Cambio de planteamiento. Fuerza bruta para simular el juego

import java.util.Scanner;

public class MusicalChairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numProfesores = sc.nextInt(); // número de jugadores
        int[] saltoProfesor = new int[numProfesores]; // pasos para cada jugador
        boolean[] eliminados = new boolean[numProfesores]; // marca si un jugador ha sido eliminado

        // Leer los valores de salto y ajustarlos para cero-index
        for (int i = 0; i < numProfesores; i++) {
            saltoProfesor[i] = sc.nextInt() - 1;
        }

        int numEliminados = 0; // contador de eliminados
        int pos = 0;     // posición actual

        while (numEliminados < numProfesores - 1) { // seguimos hasta que quede un jugador
            int salto = saltoProfesor[pos] % (numProfesores - numEliminados); // evitar movimientos innecesarios

            // Simular salto, sin contar jugadores eliminados y ciclando
            while (salto > 0) {
                pos++;
                if (pos == numProfesores) pos = 0;
                if (!eliminados[pos]) salto--;
            }

            eliminados[pos] = true; // eliminar al jugador actual
            numEliminados++;

            // movernos al siguiente jugador vivo
            while (eliminados[pos]) {
                pos++;
                if (pos == numProfesores) pos = 0;
            }
        }

        // imprimir la posición del último jugador vivo (ajustada a 1-index)
        System.out.println(pos + 1);
    }
}
