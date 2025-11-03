package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer la fecha en formato MM/DD/YYYY
// Convertirla al formato DD. mes YYYY   (el mes debe estar en danés)

import java.util.Scanner;


public class DanishDateFormat {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Meses en danés en base 1
        String[] meses = { "","januar", "februar", "marts", "april","maj","juni","juli","august","september","oktober","november","december"};

        // Leer la cadena
        String fecha = sc.nextLine();

        // Hacer split con /
        String[] partesFecha = fecha.split("/");

        System.out.println(Integer.parseInt(partesFecha[1]) +". " + meses[Integer.parseInt(partesFecha[0])] + " " + partesFecha[2]);


        sc.close();
    }
}

