package Others.Easy.Puntuacion_2_0_a_2_9._2_4;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// Una simple división, pero con BigInteger

public class Lidaskipting2 {

     public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String numPart = scan.next();

        BigInteger numParticipantes = new BigInteger(numPart);
        //El número máximo de equipos es siempre la cantidad de participantes
        System.out.println(numParticipantes);

        //El número mínimo de equipos es la cantidad de participantes divida entre 3
         //Si el módulo no es cero, se le suma un nuevo equipo
        BigInteger[] numMaxEquipos = numParticipantes.divideAndRemainder(new BigInteger("3"));
        if (numMaxEquipos[1].equals(new BigInteger("0")))
            System.out.println(numMaxEquipos[0]);
        else
            System.out.println(numMaxEquipos[0].add(new BigInteger("1")));


    }
}