package Others.Trivial.Puntuacion_1_1_a_1_5._1_5;

import java.util.Scanner;

public class Jabuke {
    // Clase auxiliar para representar puntos usando enteros (evita imprecisión)
    static class Punto {
        int x, y;
        Punto(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // Devuelve el DOBLE del área de un triángulo formado por tres puntos (siempre entero)
    public static int calcularDobleArea(Punto p1, Punto p2, Punto p3) {
        return Math.abs(p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y));
    }

    // Función que verifica si el punto P está dentro o en el borde de ABC
    public static boolean puntoEnTriangulo(Punto A, Punto B, Punto C, Punto P) {
        int areaABC = calcularDobleArea(A, B, C);

        int areaABP = calcularDobleArea(A, B, P);
        int areaBCP = calcularDobleArea(B, C, P);
        int areaCAP = calcularDobleArea(C, A, P);

        // Si la suma de las sub-áreas es exactamente igual al área total, el punto está dentro
        return (areaABP + areaBCP + areaCAP) == areaABC;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer las coordenadas del triángulo
        Punto a = new Punto(sc.nextInt(), sc.nextInt());
        Punto b = new Punto(sc.nextInt(), sc.nextInt());
        Punto c = new Punto(sc.nextInt(), sc.nextInt());

        // El área real se calcula dividiendo el doble del área entre 2.0
        double areaReal = calcularDobleArea(a, b, c) / 2.0;

        int numCasos = sc.nextInt();
        int numArbolesDentro = 0;

        // Leer cada uno de los árboles
        while (numCasos-- > 0) {
            Punto arbol = new Punto(sc.nextInt(), sc.nextInt());
            if (puntoEnTriangulo(a, b, c, arbol)) {
                numArbolesDentro++;
            }
        }

        // Mostrar el resultado con un solo decimal
        System.out.printf("%.1f\n", areaReal);
        System.out.println(numArbolesDentro);

        sc.close();
    }
}