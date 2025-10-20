package Others.Easy.Puntuacion_1_1_a_1_9._1_4.Adaptaciones;

// Leer el número de registros.
// Para cada registro
//   Leer el tipo de visitante (EST, VIS o PRO)
//   Leer la dirección (IN / OUT)
//   Leer la cantidad
//   Actualizar el contador del tipo
// Por cada profesor se pueden restar 5 estudiantes
// Por cada profesor se puede restar 1 visitante
// Si la cantidad de visitantes o estudiantes es superior a 0 --> alarma
// Sino, ok

import java.util.Scanner;

public class RobosEnLaCantina {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Leer el número de registros
        int numRegistros = sc.nextInt();

        //Leer los registros y actualizar contadores
        // En este caso sería suficiente un contador general
        long numProfesores = 0;
        long numVisitantes = 0;
        long numEstudiantes = 0;

        for (int i=0; i<numRegistros; i++) {
            String tipo = sc.next();
            String direccion = sc.next();
            int cantidad = sc.nextInt();

            // Si la direccion es de salida, se considera una cantidad negativa
            if (direccion.equals("OUT")) cantidad *= -1;

            switch (tipo) {
                case "EST" : numEstudiantes+=cantidad; break;
                case "VIS" : numVisitantes+=cantidad; break;
                case "PRO" : numProfesores+=cantidad; break;
            }
        }

        //Mostrar el resultado final
        /*
        System.out.println("EST:" + numEstudiantes);
        System.out.println("VIS:" + numVisitantes);
        System.out.println("PRO:" + numProfesores);
        */

        //Ajustar el número de estudiantes y visitantes, según el número de profesores
        numEstudiantes -= numProfesores*5;
        numVisitantes -= numProfesores;

        if (numEstudiantes <=0 && numVisitantes <= 0)
            System.out.println("OK");
        else {
            long totalEscondidos = Math.max(0L,numEstudiantes) + Math.max(0L,numVisitantes);
            System.out.println("ALARMA " + totalEscondidos);
        }

        sc.close();
    }
}

