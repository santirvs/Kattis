package Cap1._2_ProblemasAdHoc._13_ProcesamientoEntrada;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;


public class GenealogicalResearch {

    public static Persona buscarOCrearPersona(ArrayList<Persona> personas, String nombre) {
        Persona persona = new Persona(nombre);
        int pos = personas.indexOf(persona);
        if (pos == -1) {
            personas.add(persona);
            return persona;
        } else {
            return personas.get(pos);
        }
    }

    public static Persona buscarOCrearPersona(ArrayList<Persona> personas, Persona p) {
        int pos = personas.indexOf(p);
        if (pos == -1) {
            personas.add(p);
            return p;
        } else {
            return personas.get(pos);
        }
    }

    public static void nacimiento(String comando, ArrayList<Persona> personas) {
        String[] datos = comando.split(" : ");
        datos[0] = datos[0].substring(6); //Eliminar BIRTH del primer dato (nombre)

        //Mirar de recuperar la persona si ya existe
        Persona persona = buscarOCrearPersona(personas, datos[0]);
        persona.fechaNacimiento = datos[1];
        persona.padre = buscarOCrearPersona(personas, datos[2]);
        persona.madre = buscarOCrearPersona(personas, datos[3]);

        //Añade como hijo a los padres
        buscarOCrearPersona(persona.padre.hijos, persona);
        buscarOCrearPersona(persona.madre.hijos, persona);
    }

    public static void defuncion(String comando, ArrayList<Persona> personas) {
        String[] datos = comando.split(" : ");
        datos[0] = datos[0].substring(6); //Eliminar DEATH del primer dato (nombre)
        Persona persona = buscarOCrearPersona(personas, datos[0]);
        persona.fechaDefuncion = datos[1];
    }

    public static void imprimirAncestros(String comando, ArrayList<Persona> personas) {
        Persona persona = buscarOCrearPersona(personas, comando.substring(10));
        persona.ancestros(0);
    }

    public static void imprimirDescendientes(String comando, ArrayList<Persona> personas) {
        Persona persona = buscarOCrearPersona(personas, comando.substring(12));
        persona.descendientes(0);
    }


    public static class Persona implements Comparable<Persona> {
        String nombre;
        String fechaNacimiento;
        String fechaDefuncion;
        Persona padre;
        Persona madre;

        Persona(String nombre) {
            this.nombre = nombre;
        }

        ArrayList<Persona> hijos = new ArrayList<Persona>();

        @Override
        public int compareTo(Persona o) {
            return this.nombre.compareTo(o.nombre);
        }

        public boolean equals(Object o) {
            return this.nombre.equals(((Persona)o).nombre);
        }

        public void imprimirDatos() {
            System.out.print(nombre);
            if (fechaNacimiento != null) {
                System.out.print(" " + fechaNacimiento + " -");
            }
            if (fechaDefuncion != null) {
                System.out.print(" " + fechaDefuncion);
            }
        }

        private void imprimirAncestros(int nivel) {
            for (int i = 0; i < nivel; i++) {
                System.out.print("  ");
            }
            imprimirDatos();
            System.out.println("");
            //Siguientes ancestros
            ancestros(nivel);
        }

        private void imprimirHijos(int nivel) {
            for (int i = 0; i < nivel; i++) {
                System.out.print("  ");
            }
            imprimirDatos();
            System.out.println("");
            //Siguientes ancestros
            descendientes(nivel);
        }


        public void ancestros(int nivel) {
            if (nivel == 0)
                System.out.println("ANCESTORS of " + nombre);

            ArrayList<Persona> ancestros = new ArrayList<Persona>();
            if (padre != null) ancestros.add(padre);
            if (madre != null) ancestros.add(madre);
            Collections.sort(ancestros);
            for (Persona ancestro : ancestros) {
                ancestro.imprimirAncestros(nivel+1);
            }
        }

        public void descendientes(int nivel) {
            if (nivel == 0)
                System.out.println("DESCENDANTS of " + nombre);

            Collections.sort(hijos);
            for (Persona hijo : hijos) {
                hijo.imprimirHijos(nivel+1);
            }
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        ArrayList<Persona> personas = new ArrayList<Persona>();

        //Mientras no se lea el QUIT
        String comando = scan.nextLine();
        boolean primeraVez = true;
        while (!comando.equals("QUIT")) {
            if (comando.startsWith("BIRTH")) {
                nacimiento(comando, personas);
            } else if (comando.startsWith("DEATH")) {
                defuncion(comando, personas);
            } else if (comando.startsWith("ANCESTORS")) {
                if (!primeraVez) System.out.println();
                primeraVez = false;
                imprimirAncestros(comando, personas);
            } else if (comando.startsWith("DESCENDANTS")) {
                if (!primeraVez) System.out.println();
                primeraVez = false;
                imprimirDescendientes(comando, personas);
            }

            comando = scan.nextLine();
        }

    }
}


