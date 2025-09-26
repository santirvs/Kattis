package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer las dimensiones de la matriz
// Leer cada una de las filas
// Buscar los '*' en cada fila
// Guardar las dimensiones en una lista
// Imprimir el tamaño de la lista y las dimensiones

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hakkari {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la matriz
        int filas = sc.nextInt();
        int columnas = sc.nextInt();
        sc.nextLine();
        List<String> lista  = new ArrayList<String>();

        for (int i=1; i<= filas; i++) {
            String fila  = sc.next();
            for (int j=0; j< columnas; j++) {
                if (fila.charAt(j) == '*') {
                    lista.add(i + " " + (j+1));
                }
            }
        }

        // Mostrar el resultado
        System.out.println(lista.size());
        for (int i=0; i<lista.size(); i++) {
            System.out.println(lista.get(i));
        }


        sc.close();
    }
}

