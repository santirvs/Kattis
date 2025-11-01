package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Problema de matemáticas aplicado a la programación
// Leer la altura de una pared
// Leer el ángulo que debe formar la escalera con el suelo
// Calcular la longitud mínima de la escalera necesaria para alcanzar la pared
// La fórmula es: longitud = altura / sen(ángulo)
// Redondear el resultado al alza y mostrarlo como un número entero


import java.util.Locale;
import java.util.Scanner;

public class Ladder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        // Leer la altura de una pared
        double altura = sc.nextDouble();
        // Leer el ángulo que debe formar la escalera con el suelo
        double angulo = sc.nextDouble();
        // Calcular la longitud mínima de la escalera necesaria para alcanzar la pared
        double longitud = altura / Math.sin(Math.toRadians(angulo));
        // Redondear el resultado al alza y mostrarlo como un número entero
        int resultado = (int) Math.ceil(longitud);
        System.out.println(resultado);

        sc.close();
    }
}

