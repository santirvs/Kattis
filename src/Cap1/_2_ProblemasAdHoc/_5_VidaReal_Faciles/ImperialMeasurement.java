package Cap1._2_ProblemasAdHoc._5_VidaReal_Faciles;


import java.util.Locale;
import java.util.Scanner;

public class ImperialMeasurement {

     public static void main(String[] args) {

         //Tablas de conversion
         double[] conversion = {1, 1000, 12, 3, 22, 10, 8, 3};
         String[] unidades = {"thou","inch","foot","yard","chain","furlong","mile","league"};
         String[] abreviadas = {"th","in","ft","yd","ch","fur","mi","lea"};

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         //Lectura de datos
         String[] linea = scan.nextLine().split(" ");

         //Procesar la línea
         double medida = Double.parseDouble(linea[0]);

         //Unidad origen
         String unidad = linea[1];
         int posOrigen = -1;
         for (int i = 0; posOrigen==-1 && i < unidades.length; i++) {
             if (unidades[i].equals(unidad)) {
                 posOrigen = i;
             }
         }
         for (int i = 0; posOrigen==-1 && i < abreviadas.length; i++) {
             if (abreviadas[i].equals(unidad)) {
                 posOrigen = i;
             }
         }

         //Unidad destino
         String destino = linea[3];
         int posDestino = -1;
         for (int i = 0; posDestino==-1 && i < unidades.length; i++) {
             if (unidades[i].equals(destino)) {
                 posDestino = i;
             }
         }
         for (int i = 0; posDestino==-1 && i < abreviadas.length; i++) {
             if (abreviadas[i].equals(destino)) {
                 posDestino = i;
             }
         }

         if (posOrigen < posDestino) {
             for (int pos= posOrigen; pos < posDestino; pos++) {
                 medida /= conversion[pos+1];
             }
         } else {
             for (int pos = posOrigen; pos > posDestino; pos--) {
                 medida *= conversion[pos];
             }
         }

         //Mostrar el resultado
         System.out.printf("%.10f\n", medida);

     }

}
