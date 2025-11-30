package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer las coordenadas del triángulo
// Calcular el área
// Leer la cantidad de puntos
// Determinar si el punto está dentro del triángulo o no

import java.util.Scanner;



public class Jabuke_WA {
    // Clase auxiliar para representar puntos
    static class Punto {
        double x, y;
        Punto(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    // Función para verificar si P está dentro del triángulo ABC
    public static boolean puntoEnTriangulo(Punto A, Punto B, Punto C, Punto P) {
        // Denominador compartido
        double denom = (B.y - C.y) * (A.x - C.x) + (C.x - B.x) * (A.y - C.y);

        // Evitar división por cero (triángulo degenerado)
        if (denom == 0) return false;

        // Coordenadas baricéntricas
        double lambda1 = ((B.y - C.y) * (P.x - C.x) + (C.x - B.x) * (P.y - C.y)) / denom;
        double lambda2 = ((C.y - A.y) * (P.x - C.x) + (A.x - C.x) * (P.y - C.y)) / denom;
        double lambda3 = 1.0 - lambda1 - lambda2;

        // El punto está dentro si todos están entre 0 y 1
        return lambda1 >= 0 && lambda2 >= 0 && lambda3 >= 0 &&
                lambda1 <= 1 && lambda2 <= 1 && lambda3 <= 1;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Leer las coordenadas del triángulo
        Punto a = new Punto(sc.nextInt(), sc.nextInt());
        Punto b = new Punto(sc.nextInt(), sc.nextInt());
        Punto c = new Punto(sc.nextInt(), sc.nextInt());

        //Calcular el área del triángulo
        double area = Math.abs(a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) / 2.0;

        int numCasos = sc.nextInt();

        //leer cada uno de los casos
        int numArbolesDentro = 0;
        while (numCasos-- > 0) {
            Punto arbol = new Punto(sc.nextInt(), sc.nextInt());
            if (puntoEnTriangulo(a, b, c, arbol))
                numArbolesDentro++;
        }

        //Mostrar el resultado
        System.out.printf("%.1f\n",area);
        System.out.println(numArbolesDentro);

        //Cierra el scanner
        sc.close();
    }
}

