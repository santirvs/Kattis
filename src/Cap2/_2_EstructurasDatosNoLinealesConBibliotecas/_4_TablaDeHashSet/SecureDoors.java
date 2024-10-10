package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._4_TablaDeHashSet;


import java.util.HashSet;
import java.util.Scanner;

// Ir guardando todas las personas que están dentro en un HashSet
// Antes de añadir o sacar a alguien, comprobar que no sea una anomalía
// Si es una anomalía, imprimir el caso y (ANOMALY)


public class SecureDoors {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int numCasos = scan.nextInt();
        scan.nextLine();
        HashSet<String> personasDentro = new HashSet<String>();

        for (int i=0; i<numCasos; i++) {
            String[] linea = scan.nextLine().split(" ");

            String accion = linea[0];
            String persona = linea[1];

            if (accion.equals("entry")) {
                if (personasDentro.contains(persona)) {
                    System.out.println(persona + " entered (ANOMALY)");
                }
                else {
                    personasDentro.add(persona);
                    System.out.println(persona + " entered");
                }
            }
            else {
                if (personasDentro.contains(persona)) {
                    personasDentro.remove(persona);
                    System.out.println(persona + " exited");
                }
                else {
                    System.out.println(persona + " exited (ANOMALY)");
                }
            }

        }

    }

}

