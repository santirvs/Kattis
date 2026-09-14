package Others.Easy.Puntuacion_2_0_a_2_9._2_3;


/*
    Leer las direcciones
    Girarlo para situarlo de forma que voy hacia el norte
    Tomar la decisión:
        //Ceder el paso si vamos a seguir recto (Norte) y el otro vehículo viene por la derecha (Este)
        //O bien si quiero girar a la izquierda (Oeste) y el otro vehículo viene desde el Norte o el Este



 */

import java.util.Scanner;

public class RightOfWay {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Leer los datos
        String dirYoInicio = sc.next();
        String dirYoFinal = sc.next();
        String dirOtro = sc.next();

        //Rotar hasta quedarnos mirando al Norte (venimos del Sur)
        while (!dirYoInicio.equals("South")) {
            dirYoInicio = rotate(dirYoInicio);
            dirYoFinal = rotate(dirYoFinal);
            dirOtro = rotate(dirOtro);
        }

        //Resolver:
        //Ceder el paso si vamos a seguir recto (Norte) y el otro vehículo viene por la derecha (Este)
        //O bien si quiero girar a la izquierda (Oeste) y el otro vehículo viene desde el Norte o el Este

        boolean ceder = ( (dirYoFinal.equals("North") && dirOtro.equals("East")) ||
                (dirYoFinal.equals("West") &&  (dirOtro.equals("North") || dirOtro.equals("East") ) ) );

        if (ceder) System.out.println("Yes");
        else System.out.println("No");


        }

    private static String rotate(String dir) {
        if (dir.equals("North")) return "West";
        if (dir.equals("West")) return "South";
        if (dir.equals("South")) return "East";
        else return "North";
    }
}

