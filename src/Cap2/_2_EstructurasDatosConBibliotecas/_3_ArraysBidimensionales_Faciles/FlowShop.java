package Cap2._2_EstructurasDatosConBibliotecas._3_ArraysBidimensionales_Faciles;

import java.util.*;

public class FlowShop {

    public static class Operacion implements Comparable<Operacion> {
        int orden;
        int inicio;

        Operacion(int orden, int inicio) {
            this.orden = orden;
            this.inicio = inicio;
        }

        @Override
        public int compareTo(Operacion other) {
            if (inicio == other.inicio)
                return orden - other.orden;
            else
                return inicio - other.inicio;
        }

    }
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numCosechadoras = scan.nextInt();
        int numEtapas = scan.nextInt();

        //Define el tamaño de la matriz
        //Añadir un fila más para apuntar el momento en que queda libre una etapa
        int LIBRE = numCosechadoras;
        int[][] matriz = new int[numCosechadoras+1][numEtapas];

        //Leer los datos
        for (int f=0; f<numCosechadoras; f++) {
            for (int c=0; c<numEtapas; c++) {
                matriz[f][c] = scan.nextInt();
            }
        }

        //Procesar la primera etapa en orden de los pedidos
        for (int c=0; c<numCosechadoras; c++) {
            matriz[c][0] = matriz[c][0] + matriz[LIBRE][0];
            matriz[LIBRE][0] = matriz[c][0];
        }

        //Procesar el resto de etapas, buscando siempre el mínimo de cada etapa
        for (int e=1; e<numEtapas; e++) {
            ArrayList<Operacion> operaciones = new ArrayList<>();
            for (int c=0; c<numCosechadoras; c++) {
                Operacion o = new Operacion(c, matriz[c][e-1]);
                operaciones.add(o);
            }
            Collections.sort(operaciones);

            //Recorrer la lista de operaciones y determinar el momento
            //de finalización de cada etapa
            for (Operacion o : operaciones) {
                matriz[o.orden][e] = Math.max(o.inicio,matriz[LIBRE][e]) + matriz[o.orden][e];
                matriz[LIBRE][e] = matriz[o.orden][e];
            }
        }

        //Mostrar el resultado
        for (int c=0; c<numCosechadoras; c++) {
            if (c!=0) System.out.print(" ");
            System.out.print(matriz[c][numEtapas-1]);
        }
        System.out.println();


  }
}
