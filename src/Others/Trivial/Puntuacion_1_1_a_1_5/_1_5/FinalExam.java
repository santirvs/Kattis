package Others.Trivial.Puntuacion_1_1_a_1_5._1_5;

// Contar el número de respuestas iguales consecutivas

import java.util.Scanner;


public class FinalExam {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numRespuestas = sc.nextInt();
        int numAciertos = 0;

        String respuestaAnterior = sc.next();
        for (int i=1; i<numRespuestas; i++) {
            String respuesta = sc.next();
            if (respuesta.equals(respuestaAnterior)) {
                numAciertos++;
            }
            respuestaAnterior = respuesta;
        }

        System.out.println(numAciertos);


        sc.close();
    }
}

