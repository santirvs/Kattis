package Cap1._2_ProblemasAdHoc._6_VidaReal_Medios;


import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ScalingRecipes {

    public static void tratarCaso(Scanner scan, int caso) {
        //Leer los datos del caso
        int numIngredientes = scan.nextInt();
        int numPorciones = scan.nextInt();
        int numPorcionesDeseadas = scan.nextInt();

        //Leer los ingredientes
        ArrayList<String> ingredientes = new ArrayList<String>();
        ArrayList<Double> cantidades = new ArrayList<Double>();
        ArrayList<Double> porcentajes = new ArrayList<Double>();
        int ingredientePrincipal = 0;
        for (int i = 0; i < numIngredientes; i++) {
            ingredientes.add(scan.next());
            cantidades.add(scan.nextDouble());
            double porcentaje = scan.nextDouble();
            porcentajes.add(porcentaje);
            if (porcentaje == 100) {
                ingredientePrincipal = i;
            }

        }

        //Ajustar el ingrediente principal al número de porciones deseadas
        double cantidadPrincipal = cantidades.get(ingredientePrincipal) * numPorcionesDeseadas / numPorciones;
        cantidades.set(ingredientePrincipal, cantidadPrincipal);

        //Ajustar el resto de ingredientes, segun su porcentaje respecto a la cantidad del ingrediente principal
        for (int i = 0; i < numIngredientes; i++) {
            double cantidad = cantidades.get(ingredientePrincipal) * porcentajes.get(i)/100;
            cantidades.set(i, cantidad);
        }


        //Mostrar resultados
        System.out.println("Recipe # " + caso);
        for (int i = 0; i < numIngredientes; i++) {
            System.out.printf("%s %.1f\n",ingredientes.get(i),cantidades.get(i));
        }
        System.out.println("----------------------------------------");
    }


     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         //Leer los datos del caso
         int numCasos = scan.nextInt();

         for (int i=0; i<numCasos;i++) {
             tratarCaso(scan, i+1);
         }

     }

}
