package Cap2._2_EstructurasDatosConBibliotecas._4_ArraysBidimensionales_Dificiles;

import java.util.Locale;
import java.util.Scanner;

public class Tetris {


    public static int tetris1(int[] arr, int c)
    {
        int counter = 0;
        for (int i = 0; i < c - 3; i++)
        {
            if (arr[i+3] == arr[i+2])
            {
                if (arr[i+2] == arr[i+1])
                {
                    if (arr[i+1] == arr[i]) counter++;
                }
                else
                {
                    i += 1;
                }
            }
            else
            {
                i += 2;
            }
        }
        return counter + c;
    }

    public static int tetris2(int[] arr, int c)
    {
        int counter = 0;
        for (int i = 0; i < c - 1; i++)
        {
            if (arr[i] == arr[i+1]) counter++;
        }
        return counter;
    }

    public static int tetris3(int[] arr, int c)
    {
        int counter = 0;
        for (int i = 0; i < c - 2; i++)
        {
            if (arr[i] == arr[i + 1] && arr[i] == arr[i + 2] - 1) counter++;
            if (arr[i] == arr[i + 1] + 1) counter++;
        }
        if (arr[c - 2] == arr[c - 1] + 1) counter++;
        return counter;
    }

    public static int tetris4(int[] arr, int c)
    {
        int counter = 0;
        for (int i = 0; i < c - 2; i++)
        {
            if (arr[i] - 1 == arr[i + 1] && arr[i + 1] == arr[i + 2]) counter++;
            if (arr[i + 1] - 1 == arr[i]) counter++;
        }
        if (arr[c - 1] - 1 == arr[c - 2]) counter++;
        return counter;
    }

    public static int tetris5(int[] arr, int c)
    {
        int counter = 0;
        for (int i = 0; i < c - 2; i++)
        {
            if (arr[i] == arr[i + 1] && arr[i] == arr[i + 2]) counter++;
            if (arr[i] - 1 == arr[i + 1] && arr[i] == arr[i + 2]) counter++;
            if (arr[i] - 1 == arr[i + 1]) counter++;
            if (arr[i + 1] - 1 == arr[i]) counter++;
        }
        if (arr[c - 2] - 1 == arr[c - 1]) counter++;
        if (arr[c - 1] - 1 == arr[c - 2]) counter++;
        return counter;
    }

    public static int tetris6(int[] arr, int c)
    {
        int counter = 0;
        for (int i = 0; i < c - 2; i++)
        {
            if (arr[i] == arr[i + 1] && arr[i] == arr[i + 2]) counter++;
            if (arr[i] == arr[i + 1] - 1 && arr[i + 1] == arr[i + 2]) counter++;
            if (arr[i] - 2 == arr[i + 1]) counter++;
            if (arr[i] == arr[i + 1]) counter++;
        }
        if (arr[c - 2] - 2 == arr[c - 1]) counter++;
        if (arr[c - 2] == arr[c - 1]) counter++;
        return counter;
    }

    public static int tetris7(int[] arr, int c)
    {
        int counter = 0;
        for (int i = 0; i < c - 2; i++)
        {
            if (arr[i] == arr[i + 1] && arr[i] == arr[i + 2]) counter++;
            if (arr[i + 2] == arr[i + 1] - 1 && arr[i + 1] == arr[i]) counter++;
            if (arr[i + 1] - 2 == arr[i]) counter++;
            if (arr[i] == arr[i + 1]) counter++;
        }
        if (arr[c - 1] - 2 == arr[c - 2]) counter++;
        if (arr[c - 2] == arr[c - 1]) counter++;
        return counter;
    }

    public static int buscarSolucion(int[] tablero, int ancho, int pieza) {
        switch (pieza) {
            case 1:
                return tetris1(tablero, ancho);
            case 2:
                return tetris2(tablero, ancho);
            case 3:
                return tetris3(tablero, ancho);
            case 4:
                return tetris4(tablero, ancho);
            case 5:
                return tetris5(tablero, ancho);
            case 6:
                return tetris6(tablero, ancho);
            case 7:
                return tetris7(tablero, ancho);
            default:
                return 0;
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int ancho = scan.nextInt();
        int pieza = scan.nextInt();

        //Definir la matriz
        int[] matriz = new int[ancho];

        //Leer la matriz y detectar el mínimo
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ancho; i++) {
            matriz[i] = scan.nextInt();
            min = Math.min(min, matriz[i]);
        }

        //Reducir todos los valores en min para que la base sea 0
        for (int i = 0; i < ancho; i++) {
            matriz[i] -= min;
        }

        //Buscar la solución
        int solucion = buscarSolucion(matriz, ancho, pieza);

        //Imprimir la solución
        System.out.println(solucion);

    }
}

