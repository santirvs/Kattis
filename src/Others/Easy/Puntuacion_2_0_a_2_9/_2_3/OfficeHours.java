package Others.Easy.Puntuacion_2_0_a_2_9._2_3;


/**
 * Contar la frecuencia de disponibilidad de cada slot
 * Repasar los slots y determinar cual tiene la frecuencia más alta
 */


import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;

public class OfficeHours {

    public static void main(String[] args)  {
       Scanner sc = new Scanner(System.in);

        int numAlumnos = sc.nextInt();
        int[][] disponible = new int[7][24];
        int diaMax = 0;
        int horaMax = 0;

        for (int i=0; i<numAlumnos; i++) {
            sc.next();  // Ignorar el nombre del alumno
            int dia = diaSemanaInt(sc.next());
            int numHoras = sc.nextInt();
            for (int j=0; j<numHoras; j++) {
                int hora = sc.nextInt();
                disponible[dia][hora]++;
                if (disponible[dia][hora] > disponible[diaMax][horaMax]) {
                    diaMax = dia;
                    horaMax = hora;
                }
            }
        }

        System.out.printf("Your professor should host office hours %s @ %02d:00\n", diaSemanaString(diaMax), horaMax);
    }

    private static String diaSemanaString(int dia) {
        String result = switch (dia) {
            case 0 -> "Monday";
            case 1 -> "Tuesday";
            case 2 -> "Wednesday";
            case 3 -> "Thursday";
            case 4 -> "Friday";
            case 5 -> "Saturday";
            default -> "Sunday";
        };
        return result;
    }

    private static int diaSemanaInt(String dia) {
        int result = switch (dia) {
            case "Monday" -> 0;
            case "Tuesday" -> 1;
            case "Wednesday" -> 2;
            case "Thursday" -> 3;
            case "Friday" -> 4;
            case "Saturday" -> 5;
            case "Sunday" -> 6;
            default -> 0;
        };
        return result;
    }

}

