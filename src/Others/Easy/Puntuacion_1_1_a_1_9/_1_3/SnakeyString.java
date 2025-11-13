package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer la cantidad de filas y columnas
// Leer cada fila
// Si encuentro un caracter que no es ., copiarlo en un array
// Al final, imprimir el array con la solución

import java.util.Scanner;

public class SnakeyString {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        //Leer los datos
        int numFilas = scan.nextInt();
        int longitud = scan.nextInt();
        scan.nextLine();
        char[] solucion = new char[longitud];

        for (int fila=0; fila<numFilas; fila++) {
            String linea = scan.nextLine();

            for (int pos=0; pos<longitud; pos++) {
                if (linea.charAt(pos) != '.') {
                    solucion[pos] = linea.charAt(pos);
                }
            }
        }

        // Imprimir la solución
        System.out.println(solucion);
    }
}