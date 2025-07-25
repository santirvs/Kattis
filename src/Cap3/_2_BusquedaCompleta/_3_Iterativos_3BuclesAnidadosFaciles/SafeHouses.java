package Cap3._2_BusquedaCompleta._3_Iterativos_3BuclesAnidadosFaciles;

// Fuerza bruta
// Leer el mapa e ir apuntando las casas y los espías con sus coordenadas
// Para cada espía calcular la distancia a cada casa y quedarnos con la más cercana
// De entre todas las distancias, quedarnos con la mayor

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SafeHouses {

     public static void main(String[] args) throws IOException {
         Scanner scan = new Scanner(System.in);

         // Leer el tamaño del mapa
        int numFilas = scan.nextInt();
        scan.nextLine();

         // Guardar las coordenadas de las casas y los espías
         List<int[]> casas = new ArrayList<>();
         List<int[]> espias = new ArrayList<>();

         for (int fila=0; fila < numFilas ; fila++) {
             char[] linea = scan.nextLine().toCharArray();
             for (int columna = 1; columna <= linea.length; columna++) {
                 if (linea[columna-1] == 'H') {
                     casas.add(new int[]{fila, columna});
                 } else if (linea[columna-1] == 'S') {
                     espias.add(new int[]{fila, columna});
                 }
             }

         }
         // Calcular la distancia de cada espía a cada casa y seleccionar la más cercana
         // Entre todas las distancias, quedarnos con la mayor de las mínimas
         int maxDistancia = Integer.MIN_VALUE;
         for (int[] espia : espias) {
             int distanciaMinimaEspia = Integer.MAX_VALUE;
             for (int[] casa : casas) {
                 int distancia = Math.abs(espia[0] - casa[0]) + Math.abs(espia[1] - casa[1]);
                 if (distancia < distanciaMinimaEspia) {
                     distanciaMinimaEspia = distancia;
                 }
             }
             // Actualizar la distancia máxima entre las mínimas de cada espía
             if (distanciaMinimaEspia > maxDistancia) {
                 maxDistancia = distanciaMinimaEspia;
             }
         }

         // Imprimir la distancia máxima
         System.out.println(maxDistancia);
     }
}

