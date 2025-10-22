package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el valor de la altura de la bandera
// Calcular el ancho de la cruz ( altura / 7 )
// Calcular el lado del cuadrado rojo cercano al mástil ( 6/7 de la altura )
// Calcular el ancho del rectángulo lejano al mástil ( lado * 6/4)
// Calcular la superficie total de los 4 cuadrantes rojos

import java.util.Scanner;


public class Dannebrog {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la altura de la bandera
        int altura = sc.nextInt();
        // Calcular las dimensiones
        double anchoCruz = altura / 7.0;
        double ladoCuadradoRojo = (6.0 / 7.0) * altura / 2;
        double anchoRectanguloLejano = (6.0 / 4.0) * ladoCuadradoRojo;
        // Calcular la superficie total de los cuadrantes rojos
        double superficieCuadrado = ladoCuadradoRojo * ladoCuadradoRojo;
        double superficieRectangulo = anchoRectanguloLejano * ladoCuadradoRojo;
        double superficieTotalRoja = 2 * superficieCuadrado + 2 * superficieRectangulo;
        // Mostrar el resultado
        System.out.printf("%.0f%n", superficieTotalRoja);


        sc.close();
    }
}

