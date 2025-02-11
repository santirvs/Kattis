package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias._1_EstucturasDeDatosParaGrafos;

import java.util.Scanner;


public class WeakVertices {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        while (n != -1) {

            //Leer la matriz de adyacencias
            int[][] matriz = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matriz[i][j] = scan.nextInt();
                }
            }

            //Buscar los vértices débiles
            //Para cada vértice
            boolean primerVerticeDebil = false;
            for (int i = 0; i < n; i++) {
                //Suponemos inicialmente que es débil
                boolean esDebil = true;
                //Buscamos un vértice adyacente (j)
                for (int j = 0; j < n; j++) {
                    if (matriz[i][j] == 1) {  //Suponemos que nunca hay un vértice adyacente a sí mismo
                        //Buscamos otro vértice adyacente (k) a j
                        for (int k = 0; k < n; k++) {
                            //Si j y k son adyacentes entre ellos y k también lo es con i, forman un triángulo --> no és débil
                            if (matriz[j][k] == 1 && matriz[i][k] == 1) {
                                esDebil = false;
                                break;
                            }
                        }
                    }
                }
                if (esDebil) {
                    if (!primerVerticeDebil)
                        primerVerticeDebil = true;
                    else System.out.print(" ");

                    System.out.print(i);
                }
            }
            System.out.println();

            //Siguiente caso
            n = scan.nextInt();
        }
    }

}


