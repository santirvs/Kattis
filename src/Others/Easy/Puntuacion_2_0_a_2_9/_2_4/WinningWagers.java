package Others.Easy.Puntuacion_2_0_a_2_9._2_4;

/*
 Calcular las combinaciones de los eventos, multiplicandolos entre ellos
 MONEDA: 1/2
 DADO: 1/6
 CARTAS: 1/52
 Las combinaciones de no acertar serán el total de combinaciones menos 1 (la que acierta)
 Calcular el precio W multiplicando por el precio L
 */


import java.util.Scanner;

public class WinningWagers {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int numEventos = sc.nextInt();

        long opciones = 1;
        for (int i=0; i<numEventos;i++) {
            String evento = sc.next();
            if (evento.equals("COIN")) opciones *=2;
            else if (evento.equals("DIE")) opciones *=6;
            else if (evento.equals("CARDS")) opciones *=52;
        }

        //Restamos la única opción ganadora y nos quedamos con las perdedoras
        opciones--;

        //Y multiplicamos por el precio a pagar cuando se pierde
        int loose = sc.nextInt();

        System.out.println(opciones * loose);

    }

}