package Cap1._2_ProblemasAdHoc._5_VidaReal_Faciles;


import java.util.Locale;
import java.util.Scanner;

public class CaloriesFromFat {

     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         int[] gramosToCalorias = {9, 4, 4, 4, 7};

         String linea = scan.nextLine();
         while (!linea.equals("-")) {
             //Lectura de datos
             double caloriasTotales = 0;
             double caloriasDeGrasaTotales = 0;
             while (!linea.equals("-")) {
                 int porcentaje = 0;
                 int calorias = 0;
                 int caloriasDeGrasa = 0;
                 int porcentajeGrasa = 0;
                 //Procesar cada alimento
                 String[] datos = linea.split(" ");
                 for (int i = 0; i < 5; i++) {
                     int caloriasAlimento = 0;
                     int porcentajeAlimento = 0;

                     //Convertir a calorias o porcentaje
                     char unidad = datos[i].charAt(datos[i].length() - 1);
                     if (unidad == 'C') {
                         caloriasAlimento = Integer.parseInt(datos[i].substring(0, datos[i].length() - 1));
                     } else if (unidad == 'g') {
                         caloriasAlimento = Integer.parseInt(datos[i].substring(0, datos[i].length() - 1)) * gramosToCalorias[i];
                     } else if (unidad == '%') {
                         porcentajeAlimento = Integer.parseInt(datos[i].substring(0, datos[i].length() - 1));
                     }
                     //Acumular valores totales de calorias y porcentajes
                     calorias += caloriasAlimento;
                     porcentaje += porcentajeAlimento;
                     //Acumular valores de grasa
                     if (i == 0) {
                         caloriasDeGrasa += calorias;
                         porcentajeGrasa = porcentaje;
                     }

                 }

                 //Unificar valores en calorias (los porcentajes se convierten a calorias) y acumular
                 int porcentajeRestante = 100 - porcentaje;
                 double caloriasLinea = 100* calorias / (double) porcentajeRestante;
                 caloriasTotales += caloriasLinea;

                 //Transformar porcentaje de Grasa a calorias  (uno de los dos valores es 0)
                 caloriasDeGrasaTotales += caloriasDeGrasa + (caloriasLinea * porcentajeGrasa / 100);

                 //Siguiente linea
                 linea = scan.nextLine();
             }

             //Calcular porcentaje de grasa
             double porcentajeGrasa = (caloriasDeGrasaTotales * 100) / caloriasTotales;

             //Mostrar el resultado
             System.out.printf("%.0f%%\n", porcentajeGrasa);

             //Siguiente linea
             linea = scan.nextLine();
         }


     }

}
