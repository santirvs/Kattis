package Others.Medium.Puntuacion_3_0_a_3_9._3_2;


import java.util.Scanner;

public class MoonlitTimeMachine {

    public static String fases = "NCCCCQQQQGGGGGFGGGGGQQQCCCCC";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numObservaciones = sc.nextInt();
        String[] observaciones = new String[numObservaciones];
        for (int i=0; i<numObservaciones; i++) {
            observaciones[i] = sc.next();
        }

        //Probar con el número de días
        boolean encontrado = false;
        int numDias = 0;
        while (!encontrado) {
            numDias++;
            encontrado = true;
            for (int i=0; i<numObservaciones && encontrado; i++ ) {
                char observado = observaciones[i].charAt(0);
                char fase = fases.charAt( ((i+1)*numDias) % 28) ;
                if (observado != fase ) {
                    encontrado = false;
                }
            }
        }

        System.out.println(numDias);


    }
}