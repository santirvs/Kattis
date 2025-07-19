package Cap2._2_EstructurasDatosConBibliotecas._6_Ordenacion_Dificiles;

import java.util.*;

public class AClassyProblem {

    public static class Persona implements Comparable<Persona> {
        String nombre;
        String[] clase;

        public Persona(String nombre, String clase) {
            this.nombre = nombre;
            this.clase = clase.split("-");
        }

        @Override
        public int compareTo(Persona o) {
            int indexThis = this.clase.length - 1;
            int indexOther = o.clase.length - 1;
            //Si se pueden comparar
            for (; indexThis >= 0 && indexOther >=0; indexThis--, indexOther--) {
                if (!this.clase[indexThis].equals(o.clase[indexOther])) {
                    return o.clase[indexOther].compareTo( this.clase[indexThis]);
                }
            }

            //Uno de los dos ha llegado al final. Se considera que el que ha llegado al final es "middle"
            while (indexThis >= 0) {
                if (!this.clase[indexThis].equals("middle")) {
                    return "middle".compareTo(this.clase[indexThis]);
                }
                indexThis--;
            }
            while (indexOther >= 0) {
                if (!o.clase[indexOther].equals("middle")) {
                    return o.clase[indexOther].compareTo("middle");
                }
                indexOther--;
            }

            //Empate total en clases. Se compara por nombre
            return this.nombre.compareTo(o.nombre);
        }

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numCasos = scan.nextInt();

        while (numCasos > 0) {
            //Numero de personas
            int numPersonas = scan.nextInt();
            scan.nextLine();
            Persona[] listaPersonas = new Persona[numPersonas];

            for (int i=0; i<numPersonas; i++) {
                String[] persona = scan.nextLine().split(" ");
                String nombre = persona[0].substring(0, persona[0].length()-1);
                String clase = persona[1];
                Persona p = new Persona(nombre, clase);
                listaPersonas[i] = p;
            }

            //Ordenar las personas
            Arrays.sort(listaPersonas);

            //Mostrar el resultado
            for (Persona p : listaPersonas) {
                System.out.println(p.nombre);
            }
            numCasos--;
            System.out.println("==============================");

        }
    }


}