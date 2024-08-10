package Cap1._2_ProblemasAdHoc._5_VidaReal_Faciles;


import java.util.Locale;
import java.util.Scanner;

public class JumbledCompass {

     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         //Lectura de datos
         int posInicial = scan.nextInt();
         int posFinal = scan.nextInt();

         //Calcular la diferencia
         int diferencia = posFinal - posInicial;
         //Si la diferencia excede los 180º, se suma o resta 360º para cambiar su sentido de giro
         if (diferencia <= -180) diferencia += 360; //-180º debe ser positivo
         if (diferencia > 180) diferencia -= 360;

         //Mostrar el resultado
         System.out.println(diferencia);

     }

}
