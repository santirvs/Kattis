package Cap3._2_BusquedaCompleta._3_Iterativos_3BuclesAnidadosFaciles;

// Fuerza bruta
// Probar hasta que la cantidad de patas estimada sea superior a la cantidad de patas máxima
// Guardar en una lista en formato String las combinaciones que cumplen la condición

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MathHomework {

     public static void main(String[] args) throws IOException {
         Scanner scan = new Scanner(System.in);

         // Leer la cantidad de patas de cada tipo
         int patasB = scan.nextInt();
         int patasC = scan.nextInt();
         int patasD = scan.nextInt();

         // Leer la cantidad máxima de patas
         int maxPatas = scan.nextInt();

         // Lista para guardar las combinaciones
         List<String> combinaciones = new ArrayList<>();

         // Probar todas las combinaciones de patas
         for (int b = 0; b <= maxPatas / patasB; b++) {
             for (int c = 0; c <= maxPatas / patasC; c++) {
                 for (int d = 0; d <= maxPatas / patasD; d++) {
                     int totalPatas = b * patasB + c * patasC + d * patasD;
                     if (totalPatas > maxPatas) {
                         break; // Si superamos el máximo, no necesitamos seguir buscando
                     }
                     if (totalPatas == maxPatas) {
                         combinaciones.add(b + " " + c + " " + d);
                     }
                 }
             }
         }

         // Imprimir las combinaciones encontradas
         if (combinaciones.isEmpty()) {
             System.out.println("impossible");
         } else {
             for (String combinacion : combinaciones) {
                 System.out.println(combinacion);
             }
         }

     }
}

