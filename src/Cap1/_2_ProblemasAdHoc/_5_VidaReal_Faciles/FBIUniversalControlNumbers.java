package Cap1._2_ProblemasAdHoc._5_VidaReal_Faciles;


import java.util.Locale;
import java.util.Scanner;

public class FBIUniversalControlNumbers {

     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         //Tablas de conversiones
         String base27 = "0123456789ACDEFHJKLMNPRTVWX";
         String prohibidos = "BGIOQSUYZ";
         String cambiados = "8C1005VV2";
         int[] pesos = {2, 4, 5, 7, 8, 10, 11, 13};

         //Lectura de datos
         int casos = scan.nextInt();
         scan.nextLine();
         for (int i = 0; i < casos; i++) {

             //Leer la línea
             String[] linea = scan.nextLine().split(" ");

             char[] codigo = linea[1].toCharArray();

             //Cambiar los posibiles caracteres prohibidos
             boolean valido = true;
             for (int j = 0; j < codigo.length; j++) {
                 int posicion = prohibidos.indexOf(codigo[j]);
                 if (posicion != -1) {
                     codigo[j] = cambiados.charAt(posicion);
                 }
             }

             //Comprobar que todos los caracteres sean válidos
             for (int j = 0; j < linea[1].length(); j++) {
                 if (base27.indexOf(linea[1].charAt(j)) == -1) {
                     valido = false;
                 }
             }

             //Comprobar si tiene un número de control válido
             int suma = 0;
             for (int k = 0; k < codigo.length-1; k++) {
                 suma += base27.indexOf(codigo[k]) * pesos[k];
             }
             suma %= 27;
             if (base27.charAt(suma) != codigo[8]) {
                 valido = false;
             }

             //Mostrar el resultado
             if (valido) {
                 //Calcular el valor decimal
                 long valor = 0;
                    for (int k = 0; k < codigo.length-1; k++) {
                        valor = valor * 27 + base27.indexOf(codigo[k]);
                    }
                 System.out.println(linea[0] + " " + valor);
             }
             else {
                 System.out.println(linea[0] + " Invalid");
             }

         }

     }

}
