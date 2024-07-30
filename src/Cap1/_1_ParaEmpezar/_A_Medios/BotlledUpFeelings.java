package Cap1._1_ParaEmpezar._A_Medios;

import java.util.Locale;
import java.util.Scanner;
public class BotlledUpFeelings {

   public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Lectura de los datos del caso
       int volumen = scan.nextInt();
       int v1 = scan.nextInt();
       int v2 = scan.nextInt();

       int botellas1 = volumen/v1;
       int botellas2 = 0;
       volumen= volumen % v1;

       while (volumen % v2 != 0 && botellas1 > 0) {
           botellas1--;
           volumen += v1;
       }

       if (volumen % v2 == 0) {
           botellas2 = volumen/v2;
           System.out.println(botellas1 + " " + botellas2);
       }
       else {
           System.out.println("Impossible");
       }

   }

}

