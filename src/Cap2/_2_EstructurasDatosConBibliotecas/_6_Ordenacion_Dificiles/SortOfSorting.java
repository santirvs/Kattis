package Cap2._2_EstructurasDatosConBibliotecas._6_Ordenacion_Dificiles;

import java.util.*;

public class SortOfSorting {

    public static class Alumno implements Comparable<Alumno> {
        String nombre;

        public Alumno(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public int compareTo(Alumno o) {
            if (this.nombre.charAt(0) == o.nombre.charAt(0)) {
                return this.nombre.charAt(1) - o.nombre.charAt(1);
            } else {
                return this.nombre.charAt(0) - o.nombre.charAt(0);
            }
        }

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numAlumnos = scan.nextInt();
        boolean primero = true;
        while (numAlumnos>0) {
            scan.nextLine();
            Alumno[] listaAlumnos = new Alumno[numAlumnos];
            for (int i = 0; i < numAlumnos; i++) {
                String nombre = scan.next();
                Alumno a = new Alumno(nombre);
                listaAlumnos[i]=a;
            }
            //Ordenar los alumnos
            Collections.sort(Arrays.asList(listaAlumnos));
            //Mostrar el resultado
            for (Alumno a : listaAlumnos) {
                System.out.println(a.nombre);
            }
            if (primero) primero = false;
            else System.out.println();

            //Siguiente caso
            numAlumnos = scan.nextInt();
        }
    }


}