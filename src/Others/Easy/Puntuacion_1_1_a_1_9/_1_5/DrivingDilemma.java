package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer la velocidad entero (en MPH)
// Leer la distancia decimal (en pies)
// Leer el tiempo decimal (en segundos)
// Factor de conversion de MPH a PPS (pies por segundo)
//    1 milla = 1760 yardas
//    1 yarda = 3 pies   --> 1 milla = 5280 pies
//    1 hora = 60*60 segundos = 3600 segundos
//    MPH = 5280 / 3600 PPS
// Calcular la cantidad de pies que se habrán recorrido al cabo de t segundos
// Si se ha superado el semáforo -> MADE IT
// Sino --> FAILED TEST

import java.util.Locale;
import java.util.Scanner;

public class DrivingDilemma {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        // Leer la velocidad (MPH)
        float velocidad = sc.nextFloat();
        float distancia = sc.nextFloat();
        float tiempo = sc.nextFloat();

        //Convierte a PPS
        velocidad = velocidad * (5280.0f/3600.0f);

        //A qué distancia estará al cabo de t segundos
        float distanciaRecorrida = tiempo * velocidad;

        //Se habrá superado el semáforo?
        if (distanciaRecorrida > distancia)
            System.out.println("MADE IT");
        else
            System.out.printf("FAILED TEST");

        sc.close();
    }
}

