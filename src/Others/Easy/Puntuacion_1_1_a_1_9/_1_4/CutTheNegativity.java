package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el tamaño de la matriz
// Para cada fila, leer cada columna
// Si el valor de la celda es negativo, ignorar
// Si es positivo, guardar en una lista de String el número de fila, el número de columna y el valor de la celda
// Finalmente, imprimir la cantidad de valores de la lista y cada uno de los valores

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CutTheNegativity {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el tamaño de la matriz
        int tamanyo = sc.nextInt();
        List<String> resultados = new ArrayList<>();

        for (int fila=1; fila <= tamanyo; fila++) {
            for (int columna=1; columna <= tamanyo; columna++) {
                int valor = sc.nextInt();
                if (valor >= 0) {
                    resultados.add(fila + " " + columna + " " + valor);
                }
            }
        }

        //Mostrar los resultados
        System.out.println(resultados.size());
        for (String r:resultados) {
            System.out.println(r);
        }
        sc.close();
    }
}

