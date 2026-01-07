package Others.Easy.Puntuacion_3_0_a_3_9._3_8;

// Paridad de grafos
// Si alguno de los dos lados es par -> NxM
// Si los dos lados son impares --> NxM +1
// Falla casos 16 y 46 :: Contemplar el caso especial de ancho o alto = 1
//  Falta el caso 1x1 : No hace falta moverse!
// Falla casos 17 y 47 ??? que antes daban bien?
//  La fórmula del caso de 1 fila o columna estaba incorrecta es  2 * (Filas-1) o 2 * (Columnas -1)
//  antes tenía 2*columnas -1
import java.util.Arrays;
import java.util.Scanner;


public class Roomba1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Leer las dimensiones de la sala
        int alto = sc.nextInt();
        int ancho = sc.nextInt();
        int total = 0;

        if (alto==1 && ancho==1) {
            //No es necesario moverse
            total = 0;
        }else  if (alto==1 || ancho==1) {
            //Caso especial: Debe ir y volver por la misma fila o columna
            total = 2 * (alto * ancho - 1);
        } else if (alto%2==0 || ancho%2==0) {
            total = alto * ancho;
        } else {
            total = alto * ancho + 1;
        }

        System.out.println(total);
        sc.close();
    }
}

