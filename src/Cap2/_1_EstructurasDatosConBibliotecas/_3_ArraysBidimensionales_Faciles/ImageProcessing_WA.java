package Cap2._1_EstructurasDatosConBibliotecas._3_ArraysBidimensionales_Faciles;

import java.util.Locale;
import java.util.Scanner;

public class ImageProcessing_WA {
    public static int calcular(int[][]imagen, int[][]kernel, int fila, int columna) {
        int resultado = 0;
        for (int f=0; f<kernel.length; f++) {
            for (int c=0; c<kernel[0].length; c++) {
                resultado += imagen[fila+f][columna+c] * kernel[f][c];
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
        int[][]kernel = new int[altoKernel][anchoKernel];
        int[][]resultado = new int[altoImagen-anchoKernel+1][anchoImagen-altoKernel+1];

        //Lectura de imagen y kernel
        for (int f=0; f<altoImagen; f++) {
            for (int c=0; c<anchoImagen; c++) {
                imagen[f][c]=scan.nextInt();
            }
        }
        for (int f=0; f<altoKernel; f++) {
            for (int c=0; c<anchoKernel; c++) {
                kernel[f][c]=scan.nextInt();
            }
        }

        //Invertir kernel
        int[][]kernelInv = new int[altoKernel][anchoKernel];
        for (int f=0; f<altoKernel; f++) {
            for (int c=0; c<anchoKernel; c++) {
                kernelInv[altoKernel-f-1][anchoKernel-c-1]=kernel[f][c];
            }
        }

        //Procesar imagen
        for (int f=0; f<resultado.length; f++) {
            for (int c=0; c<resultado[0].length; c++) {
                resultado[f][c] = calcular(imagen, kernelInv, f,c);
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


/*
import java.io.*;
import java.util.*;

public class imageprocessing {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(in.readLine());

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] image = new int[h][w];
        for(int i = 0; i < h; i++) {
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < w; j++) {
                image[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ArrayList<Integer> formula = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < m; j++) formula.add(Integer.parseInt(st.nextToken()));
        }
        Collections.reverse(formula);
        int[][] convoluted = new int[h - n + 1][w - m + 1];
        for(int i = 0; i <= h - n; i++) {
            for(int j = 0; j <= w - m; j++) {
                convoluted[i][j] += formula(formula, image, i, j, n, m);
            }
        }
        for(int i = 0; i < h - n + 1; i++) {
            for(int j = 0; j < w - m + 1; j++) {
                out.print(convoluted[i][j] + " ");
            }
            out.println();
        }
        out.close();
    }

    private static int formula(ArrayList<Integer> formula, int[][] grid, int r, int c, int n, int m) {
        int count = 0;
        int result = 0;
        for(int i = r; i < r + n; i++) {
            for(int j = c; j < c + m; j++) {
                result += formula.get(count) * grid[i][j];
                count++;
            }
        }
        return result;
    }
}
 */