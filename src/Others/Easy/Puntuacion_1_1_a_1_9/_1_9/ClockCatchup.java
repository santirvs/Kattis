package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

/**
 * Leer las horas
 * Calcular la distancia en segundos para cada una de las dos horas
 * Simular el paso segundo a segundo y calcular si cada una de las agujas está en las 12
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class ClockCatchup {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);


        String line1 = sc.next();
        String line2 = sc.next();

        String[] horaInicio = line1.split(":");
        String[] horaFin = line2.split(":");

        int h1 = Integer.parseInt(horaInicio[0]);
        int m1 = Integer.parseInt(horaInicio[1]);
        int s1 = Integer.parseInt(horaInicio[2]);

        int h2 = Integer.parseInt(horaFin[0]);
        int m2 = Integer.parseInt(horaFin[1]);
        int s2 = Integer.parseInt(horaFin[2]);

        // Convertir ambos tiempos a segundos absolutos desde la medianoche
        int tiempoInicio = h1 * 3600 + m1 * 60 + s1;
        int tiempoFin = h2 * 3600 + m2 * 60 + s2;

        int nvHoras = 0;
        int nvMinutos = 0;
        int nvSegundos = 0;

        // Simulamos el paso del tiempo segundo a segundo
        int tiempoActual = tiempoInicio;
        while (tiempoActual < tiempoFin) {
            tiempoActual++; // Avanzamos 1 segundo

            // Calculamos las posiciones de las agujas en este nuevo segundo
            int hActual = (tiempoActual / 3600) % 12; // Formato 12 horas para el reloj analógico
            int mActual = (tiempoActual / 60) % 60;
            int sActual = tiempoActual % 60;

            // Si la aguja acaba de caer exactamente en el "12" (0), sumamos
            if (sActual == 0) {
                nvSegundos++;
                // La aguja de los minutos solo llega al 12 cuando los segundos también son 0
                if (mActual == 0) {
                    nvMinutos++;
                    // La aguja de las horas solo llega a las 12 (0) cuando min y seg son 0
                    if (hActual == 0) {
                        nvHoras++;
                    }
                }
            }
        }

        System.out.println(nvHoras + " " + nvMinutos + " " + nvSegundos);


        sc.close();
    }
}