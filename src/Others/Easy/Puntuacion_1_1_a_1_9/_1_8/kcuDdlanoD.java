package Others.Easy.Puntuacion_1_1_a_1_9._1_8;


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class kcuDdlanoD {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);


        String num1 = sc.next();
        String num2 = sc.next();

        //Dar la vuelta al String
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        //Cambiar 2 por 5 y 5 por 2
        num1 = num1.replace("5","x").replace("2","5").replace("x","2");
        num2 = num2.replace("5","x").replace("2","5").replace("x","2");

        int i1 = Integer.parseInt(num1);
        int i2 = Integer.parseInt(num2);

        if (i1 > i2) System.out.println("1");
        else System.out.println("2");




    }


}

