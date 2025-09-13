package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer los límites de las calificaciones
// Leer la calificación obtenida
// Asignar una calificación en base a los límites leídos
// Mostrar la calificación obtenida

import java.util.Scanner;

public class Grading {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer los límites de las calificaciones
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        // Leer la calificación obtenida
        int score = sc.nextInt();
        // Asignar una calificación en base a los límites leídos
        String grade;
        if (score >= a) {
            grade = "A";
        } else if (score >= b) {
            grade = "B";
        } else if (score >= c) {
            grade = "C";
        } else if (score >= d) {
            grade = "D";
        } else if (score >= e) {
            grade = "E";
        } else {
            grade = "F";
        }

        // Mostrar la calificación obtenida
        System.out.println(grade);
    }
}

