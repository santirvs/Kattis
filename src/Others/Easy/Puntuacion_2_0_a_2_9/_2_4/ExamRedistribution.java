package Others.Easy.Puntuacion_2_0_a_2_9._2_4;

/*
 * Ordenar las aulas de mayor a menor cantidad de exámenes
 * De esta forma nos aseguramos que siempre vamos a tener suficientes exámenes para
 * distribuir en la siguiente aula y que no le vamos a dar a nadie su propio examen.
 * Sólo debemos controlar que al volver a la primera sala se hayan repartido todos los de la primera sala,
 * en caso contrario alguien podría corregir su propio examen.
 */


import java.util.Arrays;
import java.util.Scanner;

public class ExamRedistribution {

    public static class Aula implements Comparable<Aula> {
        int numAula;
        int numAlumnos;

        Aula(int numAula, int numAlumnos) {
            this.numAula = numAula;
            this.numAlumnos = numAlumnos;
        }
        @Override
        public int compareTo(Aula o) {
            return Integer.compare(o.numAlumnos, this.numAlumnos);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numAulas = sc.nextInt();
        Aula[] aulas = new Aula[numAulas];

        int totalAlumnos = 0;
        for (int i=1; i<=numAulas; i++ ) {
            int numAlumnos = sc.nextInt();
            aulas[i-1] = new Aula(i, numAlumnos);
            totalAlumnos += numAlumnos;
        }

        //Ordenar de mayor a menor capacidad
        Arrays.sort(aulas);

        //Comprobar si en primer aula hay más de la mitad de los alumnos totales
        if (aulas[0].numAlumnos > totalAlumnos/2)
            System.out.println("impossible");
        else {
            boolean primero = true;
            for (int i=0; i<numAulas; i++) {
                if (primero) primero=false;
                else System.out.print(" ");
                System.out.print(aulas[i].numAula);
            }
        }



        sc.close();
    }
}