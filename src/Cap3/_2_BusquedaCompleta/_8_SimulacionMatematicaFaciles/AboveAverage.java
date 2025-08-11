package Cap3._2_BusquedaCompleta._8_SimulacionMatematicaFaciles;

// Leer los datos, calcular la media y contar los estudiantes por encima de la media

import java.util.Scanner;

public class AboveAverage {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Leer los datos
        int numCasos = scan.nextInt(); // Número de casos

        // Tratar cada caso
        for (int i = 0; i < numCasos; i++) {
            int numEstudiantes = scan.nextInt(); // Número de estudiantes
            int[] notas = new int[numEstudiantes]; // Array para las notas

            // Leer las notas de los estudiantes
            int sumaNotas = 0;
            for (int j = 0; j < numEstudiantes; j++) {
                notas[j] = scan.nextInt();
                sumaNotas += notas[j];
            }

            // Calcular la media
            double media = (double) sumaNotas / numEstudiantes;

            // Contar los estudiantes con nota por encima de la media
            int contador = 0;
            for (int nota : notas) {
                if (nota > media) {
                    contador++;
                }
            }

            // Calcular el porcentaje de estudiantes por encima de la media
            double porcentaje = (double) contador / numEstudiantes * 100.0;

            // Imprimir el resultado con tres decimales
            System.out.printf("%.3f%%\n", porcentaje);
        }

    }

}


