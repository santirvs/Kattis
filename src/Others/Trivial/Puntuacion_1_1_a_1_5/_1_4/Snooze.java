package Others.Trivial.Puntuacion_1_1_a_1_5._1_4;

// Pasar la hora a minutos
// Multiplicar el tiempo de snooze por los ciclos
// Restarlo a la hora
// Volver a pasarlo a hh:mm

import java.util.Scanner;

public class Snooze {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la hora
        String hora = sc.nextLine();

        // Obtener el primer caracter
        int duracion = sc.nextInt();
        int ciclos = sc.nextInt();
        int totalSnooze = duracion*ciclos;

        int minutos = horaToMinutos(hora);

        minutos = ( minutos + (60*24) - totalSnooze ) % (60*24);

        System.out.println(minutosToHora(minutos));
    }

    private static String minutosToHora(int minutos) {
        int numHoras = minutos / 60;
        int numMinutos = minutos % 60;

        return String.format("%02d:%02d", numHoras, numMinutos);
    }

    private static int horaToMinutos(String hora) {
        int resultado = 0;

        resultado = Integer.parseInt(hora.substring(0, 2)) * 60 + Integer.parseInt(hora.substring(3));

        return resultado;
    }
}

