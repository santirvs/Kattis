package Cap1._2_ProblemasAdHoc._16_PerderTiempo_Dificiles;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class FunctionalFun {


     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         //Leer la entrada
         while (scan.hasNext()) {
             //Leer elementos del codominio
             String[] dominio = scan.nextLine().split(" ");
             //Leer elementos del dominio
             String[] codominio = scan.nextLine().split(" ");

             //Definir los mapas de los elementos
             Map<String, Integer> mapDominio = new java.util.HashMap<>();
             Map<String, Integer> mapCodominio = new java.util.HashMap<>();

             //Llenar los mapas
             for (int i = 1; i < dominio.length; i++) {
                 mapDominio.put(dominio[i], 0);
             }
             for (int i = 1; i < codominio.length; i++) {
                 mapCodominio.put(codominio[i], 0);
             }

             //Leer la cantidad de relaciones
             int n = scan.nextInt();
             scan.nextLine();

             //Leer las relaciones
             for (int i = 0; i < n; i++) {
                 String[] relacion = scan.nextLine().split(" ");
                 mapDominio.put(relacion[0], mapDominio.get(relacion[0]) + 1);
                 mapCodominio.put(relacion[2], mapCodominio.get(relacion[2]) + 1);
             }

             //Verificar si es una función
             //No hay ningun elemento en el dominio con más de una imagen
             boolean esFuncion = true;

             for (String key : mapDominio.keySet()) {
                 if (mapDominio.get(key) > 1) {
                     esFuncion = false;
                     break;
                 }
             }
             //Verificar si es injectiva
             //Cualquier elemento del codominio tiene a lo sumo una imagen
             boolean esInjectiva = true;
             for (String key : mapCodominio.keySet()) {
                 if (mapCodominio.get(key) > 1) {
                     esInjectiva = false;
                     break;
                 }
             }

             //Verificar si es subjetiva
             //Todos los elementos del codominio tienen al menos una imagen
             boolean esSubjetiva = true;
             for (String key : mapCodominio.keySet()) {
                 if (mapCodominio.get(key) == 0) {
                     esSubjetiva = false;
                     break;
                 }
             }

             //Imprimir el resultado
             if (esFuncion && esInjectiva && esSubjetiva) {
                 System.out.println("bijective");
             } else if (esFuncion && esInjectiva) {
                 System.out.println("injective");
             } else if (esFuncion && esSubjetiva) {
                 System.out.println("surjective");
             } else if (esFuncion) {
                 System.out.println("neither injective nor surjective");
             } else {
                 System.out.println("not a function");
             }
         }
     }
}


