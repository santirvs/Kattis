package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer las notas de los dos examenes intermedios (valen 25% cada uno)
// Leer la nota final (vale el 50%)
// Calcular la nota definitiva como la suma ponderada de las tres notas
// Clasificar la nota definitiva en A, B, C, D o F según el rango A [90-100], B [80-89], C [70-79], D [60-69], F [0-59]

import java.util.Scanner;

public class FairGrading {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer las notas
        int exam1 = sc.nextInt() * 25;
        int exam2 = sc.nextInt() * 25;
        int finalExam = sc.nextInt() * 50;

        // Calcular la nota definitiva
        int finalGrade = (exam1 + exam2 + finalExam) / 100;
        char grade;
        // Clasificar la nota definitiva
        if (finalGrade >= 90) {
            grade = 'A';
        } else if (finalGrade >= 80) {
            grade = 'B';
        } else if (finalGrade >= 70) {
            grade = 'C';
        } else if (finalGrade >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Mostrar el resultado
        System.out.println(grade);

        sc.close();
    }
}

