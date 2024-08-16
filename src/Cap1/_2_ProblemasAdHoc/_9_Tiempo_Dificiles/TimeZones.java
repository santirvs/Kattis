package Cap1._2_ProblemasAdHoc._9_Tiempo_Dificiles;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class TimeZones {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Definir las zonas horarias
        ArrayList<String> zonasHorarias = new ArrayList<String>(Arrays.asList(
                "UTC","GMT","BST","IST","WET","WEST",
                "CET","CEST","EET","EEST","MSK","MSD",
                "AST","ADT","NST","NDT","EST","EDT",
                "CST","CDT","MST","MDT","PST","PDT",
                "HST","AKST","AKDT","AEST","AEDT","ACST",
                "ACDT","AWST" ) );
        int[] horas = {
                0,0,1,1,0,1,
                1,2,2,3,3,4,
                -4,-3,-3,-2,-5,-4,
                -6,-5,-7,-6,-8,-7,
                -10,-9,-8,10,11,9,
                10,8};
        int[] minutos = {
                0,0,0,0,0,0,
                0,0,0,0,0,0,
                0,0,-30,-30,0,0,
                0,0,0,0,0,0,
                0,0,0,0,0,30,
                30,0};

        //Lectura de los datos del caso
        int numCasos = scan.nextInt();
        scan.nextLine();

        while (numCasos > 0) {
            String tiempo = scan.next();
            String ampm = "";
            if (tiempo.equals("noon")) {
                tiempo = "12:00";
            } else if (tiempo.equals("midnight")) {
                tiempo = "00:00";
            } else {
                ampm = scan.next();
            }
            int hora = Integer.parseInt(tiempo.split(":")[0]);
            int minuto = Integer.parseInt(tiempo.split(":")[1]);
            if (ampm.equals("p.m.") && hora!=12) hora+=12;
            if (ampm.equals("a.m.") && hora==12) hora=0;

            String husoOrigen = scan.next();
            String husoDestino = scan.next();

            //Calcular la diferencia de horas
            int indiceOrigen = zonasHorarias.indexOf(husoOrigen);
            int indiceDestino = zonasHorarias.indexOf(husoDestino);

            //Pasar de indiceOrigen a UTC
            hora -= horas[indiceOrigen];
            minuto -= minutos[indiceOrigen];

            //Pasar de UTC a indiceDestino
            hora += horas[indiceDestino];
            minuto += minutos[indiceDestino];

            //Ajustar los minutos
            if (minuto < 0) {
                minuto += 60;
                hora--;
            }
            else if (minuto >= 60) {
                minuto -= 60;
                hora++;
            }

            //Ajustar la hora
            if (hora < 0) {
                hora += 24;
            } else if (hora >= 24) {
                hora -= 24;
            }

            //Mostrar el resultado
            if (hora == 12 && minuto==0)
                System.out.println("noon");
            else if (hora == 0 && minuto==0)
                System.out.println("midnight");
            else {
                if (hora > 12) {
                    hora -= 12;
                    System.out.printf("%d:%02d p.m.\n", hora, minuto);
                } else if (hora == 12) {
                    System.out.printf("%d:%02d p.m.\n", hora, minuto);
                }
                else {
                    if (hora == 0) hora = 12;
                    System.out.printf("%d:%02d a.m.\n",hora,minuto);
                }
            }


            numCasos--;
        }

    }
}


/*
Casos límite:
AST --> UTC - 4
midnight UTC AST  --> 8:00 p.m.
12:01 a.m. UTC AST --> 8:01 p.m.
*/

