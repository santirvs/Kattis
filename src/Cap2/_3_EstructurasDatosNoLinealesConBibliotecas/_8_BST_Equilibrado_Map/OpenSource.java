package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._8_BST_Equilibrado_Map;

// Case #2: WA  --> Falta hacer un reset de los maps al finalizar el caso de prueba  --> AC!

import java.io.*;
import java.util.*;

public class OpenSource {

    public static class Proyecto {
        String nombre;
        int numAlumnos;

        public Proyecto(String nombre, int numAlumnos) {
            this.nombre = nombre;
            this.numAlumnos = numAlumnos;
        }

    }

    public static class ComparadorProyecto implements Comparator<Proyecto> {
        @Override
        public int compare(Proyecto a1, Proyecto a2) {
            int result = a2.numAlumnos  - a1.numAlumnos;
            if (result == 0)
                result = a1.nombre.compareTo(a2.nombre);
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        //mapa de proyectos --> Alumnos
        HashMap<String, Set<String>> proyectos = new HashMap<>();
        //mapa de alumnos --> Proyectos
        HashMap<String, Set<String>> alumnos = new HashMap<>();

        String entrada = in.readLine();
        String nombreProyecto = "";
        TreeSet<String> listaAlumnosProyecto = new TreeSet<String>();
        while (!entrada.equals("0")) {

            if (Character.isUpperCase(entrada.charAt(0))) {
                //Nombre del proyecto. Inicializar lista de alumnos
                listaAlumnosProyecto = new TreeSet<String>();
                proyectos.put(entrada, listaAlumnosProyecto);
                nombreProyecto = entrada;

            } else if (Character.isLowerCase(entrada.charAt(0))) {
                //Nombre del alumno
                if (alumnos.containsKey(entrada)) {
                    //Si el alumno ya está en el mapa de alumnos, añadir el proyecto al que se ha inscrito
                    alumnos.get(entrada).add(nombreProyecto);
                } else {
                    //Si el alumno no está en el mapa de alumnos, añadirlo
                    Set<String> proyectosAlumno = new TreeSet<String>();
                    proyectosAlumno.add(nombreProyecto);
                    alumnos.put(entrada, proyectosAlumno);
                }
                //Añadir el alumno a la lista de alumnos del proyecto
                listaAlumnosProyecto.add(entrada);

            } else if (Character.isDigit(entrada.charAt(0))) {
                //Final del caso de prueba. Imprimir los proyectos ordenados por cantidad de alumnos inscritos
                List<Proyecto> listaProyectos = new ArrayList<>();
                for (String nombre : proyectos.keySet()) {
                    Set<String> alumnosProyecto = proyectos.get(nombre);
                    int numAlumnos = 0;
                    //Contar únicamente los alumnos con un solo proyecto
                    for (String alumno : alumnosProyecto) {
                        Set<String> proyectosAlumno = alumnos.get(alumno);
                        if (proyectosAlumno.size() == 1)
                            numAlumnos++;
                    }
                    listaProyectos.add(new Proyecto(nombre, numAlumnos));
                }
                Collections.sort(listaProyectos, new ComparadorProyecto());
                for (Proyecto proyecto : listaProyectos) {
                    out.println(proyecto.nombre + " " + proyecto.numAlumnos);
                }
                //Reset del caso
                proyectos = new HashMap<>();
                alumnos = new HashMap<>();
            }

            entrada = in.readLine();

        }

        out.flush();
        out.close();
        in.close();
    }


}
