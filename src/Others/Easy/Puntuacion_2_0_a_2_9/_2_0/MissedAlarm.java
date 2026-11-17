package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class MissedAlarm {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String horaAlarma = sc.next();
        String horaMirada = sc.next();

        int minutosAlarma = minutos(horaAlarma);
        int minutosMirada = minutos(horaMirada);
        if (minutosMirada >= minutosAlarma) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


    }

    private static int minutos(String horaAlarma) {
        String[] partes = horaAlarma.split(":");
        int resultado = 0;

        resultado = Integer.parseInt(partes[0]) * 60 + Integer.parseInt(partes[1]);

        return resultado;

    }
}