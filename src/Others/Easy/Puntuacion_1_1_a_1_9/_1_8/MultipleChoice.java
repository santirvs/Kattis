package Others.Easy.Puntuacion_1_1_a_1_9._1_8;

/**
 * Usar una list donde guardar los estudiantes y su número de respuestas correctas.
 * Ordenar la lista según el criterio que nos indiquen.
 *
 */


import java.util.*;


public class MultipleChoice {

    static class Alumne {
        int Id;
        int puntos;

        Alumne(int id, int puntos) {
            this.Id = id;
            this.puntos = puntos;
        }
    }

    public static class ComparaPorID_Asc implements Comparator<Alumne> {
        @Override
        public int compare(Alumne a1, Alumne a2) {
            return a1.Id - a2.Id;
        }
    }

    public static class ComparaPorID_Desc implements Comparator<Alumne> {
        @Override
        public int compare(Alumne a1, Alumne a2) {
            return a2.Id - a1.Id;
        }
    }

    public static class ComparaPorPuntos_Asc implements Comparator<Alumne> {
        @Override
        public int compare(Alumne a1, Alumne a2) {
            int result = a1.puntos - a2.puntos;
            if (result == 0 ) {
                result = a1.Id - a2.Id;
            }
            return result;
        }
    }

    public static class ComparaPorPuntos_Desc implements Comparator<Alumne> {
        @Override
        public int compare(Alumne a1, Alumne a2) {
            int result = a2.puntos - a1.puntos;
            if (result == 0 ) {
                result = a1.Id - a2.Id;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Leer los datos
        int numRespuestas = sc.nextInt();
        char[] respuestasCorrectas = new char[numRespuestas];

        //Leer la plantilla de respuesta
        for (int i=0; i<numRespuestas;i++) {
            respuestasCorrectas[i]=sc.next().charAt(0);
        }

        //Leer la cantidad de alumnos
        int numAlumnos = sc.nextInt();
        Alumne[] clase = new Alumne[numAlumnos];

        for (int i=0; i<numAlumnos; i++) {
            //Lee el identificador
            int Id = sc.nextInt();
            //Lee las respuestas
            int aciertos = 0;
            for (int j=0; j<numRespuestas; j++) {
                char respuesta = sc.next().charAt(0);
                if (respuesta == respuestasCorrectas[j]) {
                    aciertos++;
                }
            }

            //Añadir el alumno con su ID y su cantidad de aciertos
            clase[i] = new Alumne(Id, aciertos);
        }

        //Leer el orden
        String orden = sc.next();

        if (orden.equals("GRADE_ASC")) {
            Arrays.sort(clase, new ComparaPorPuntos_Asc());
        } else if (orden.equals("GRADE_DESC")) {
            Arrays.sort(clase, new ComparaPorPuntos_Desc());
        } else if (orden.equals("STUDENT_ID_ASC")) {
            Arrays.sort(clase, new ComparaPorID_Asc());
        } else if (orden.equals("STUDENT_ID_DESC")) {
            Arrays.sort(clase, new ComparaPorID_Desc());
        }

        //Mostrar la lista una vez ordenada
        for (Alumne a : clase) {
            System.out.println(a.Id + " " + a.puntos);
        }

    }
}

