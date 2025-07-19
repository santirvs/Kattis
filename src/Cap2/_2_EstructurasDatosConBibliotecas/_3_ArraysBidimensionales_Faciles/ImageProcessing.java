package Cap2._2_EstructurasDatosConBibliotecas._3_ArraysBidimensionales_Faciles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class ImageProcessing {
    public static int calcular(int[][]imagen, ArrayList<Integer>kernel, int fila, int columna, int altoKernel, int anchoKernel) {
        int resultado = 0;
        for (int f=0; f<altoKernel; f++) {
            for (int c=0; c<anchoKernel; c++) {
                resultado += imagen[fila+f][columna+c] * kernel.get(f*anchoKernel+c);
            }
        }
        return (resultado);
    }
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int altoImagen = scan.nextInt();
        int anchoImagen = scan.nextInt();
        int altoKernel = scan.nextInt();
        int anchoKernel = scan.nextInt();

        //Definir matrices
        int[][]imagen = new int[altoImagen][anchoImagen];
        ArrayList<Integer> kernel = new ArrayList<>();
        int[][]resultado = new int[altoImagen-altoKernel+1][anchoImagen-anchoKernel+1];

        //Lectura de imagen y kernel
        for (int f=0; f<altoImagen; f++) {
            for (int c=0; c<anchoImagen; c++) {
                imagen[f][c]=scan.nextInt();
            }
        }
        for (int i=0; i<altoKernel*anchoKernel; i++) {
            kernel.add(scan.nextInt());
        }

        //Invertir kernel
        Collections.reverse(kernel);

        //Procesar imagen
        for (int f=0; f<resultado.length; f++) {
            for (int c=0; c<resultado[0].length; c++) {
                resultado[f][c] = calcular(imagen, kernel, f,c, altoKernel, anchoKernel);
            }
        }

        //Mostrar resultado
        for (int f=0; f<resultado.length; f++) {
            for (int c=0; c<resultado[0].length; c++) {
                if (c!=0) System.out.print(" ");
                System.out.print(resultado[f][c]);
            }
            System.out.println();
        }

  }
}