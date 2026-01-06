package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el precio de todos los libros
// Ordenar de mayor a menor
// Agrupar de 3 en 3, pero pagar sólo los 2 primeros
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Akcija {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Leer la cantidad de libros
        int numLibros = sc.nextInt();
        //Definir el array del tamaño adecuado
        int[] precios = new int[numLibros];

        //Leer el precio de cada uno de los libros
        for (int i=0; i<numLibros;i++) {
            precios[i] = sc.nextInt();
        }

        //Ordenar (de menor a mayor)
        Arrays.sort(precios);
        int suma = 0;
        //Recorrer desde atrás hacia adelante para hacer grupos de 3
        for (int pos=precios.length-1; pos >=0 ;) {
            for (int num=1; pos>=0 && num<=3; num++, pos--) {
                if (num != 3) {
                    suma+=precios[pos];
                }
            }
        }

        System.out.println(suma);

        sc.close();
    }
}

