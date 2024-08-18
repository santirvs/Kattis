package Cap1._2_ProblemasAdHoc._9_Tiempo_Dificiles;

import java.util.Locale;
import java.util.Scanner;

public class Semafori {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de los datos del caso
        int numSemaforos = scan.nextInt();
        int longitud = scan.nextInt();
        int tiempoEspera = 0;

        for (int i = 0; i < numSemaforos; i++) {
            int distancia = scan.nextInt();
            int rojo = scan.nextInt();
            int verde = scan.nextInt();

            //Calcula en qué momento del ciclo del semaforo se llega
            int tiempoCiclo = (distancia+tiempoEspera) % (rojo + verde);
            //Si está en rojo, se suma el tiempo que falta para que se ponga en verde
            if (tiempoCiclo < rojo) {
                tiempoEspera += rojo-tiempoCiclo;
            }
            //Si está en verde, se pasa sin esperar

        }

        //Imprime el resultado:  la longitud de la ruta más el tiempo de espera en los semáforos
        System.out.println(longitud+tiempoEspera);

    }
}


