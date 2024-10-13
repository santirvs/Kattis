package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._4_TablaDeHash_Set;


import java.util.*;

// Ir guardando todas las conclusiones posibles en un HashSet
// Para cada linea, comprobar que todas las asunciones son conclusiones anteriores
// Si no existe, apuntar el error
// Si no hay error a la salida, es correcto


public class Proofs {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int numCasos = scan.nextInt();
        scan.nextLine();
        HashSet<String> conclusiones = new HashSet<String>();

        for (int i=0; i<numCasos; i++) {
            String[] linea = scan.nextLine().split("->");
            String[] asunciones = linea[0].split(" ");

            //Verificar que las asunciones existen en el conjunto de conclusiones
            for (String asuncion : asunciones) {
                if (!asuncion.equals("") && !conclusiones.contains(asuncion)) {
                    System.out.println(i+1);
                    return;
                }
            }

            //Añadir la conclusión a la lista de conclusiones
            conclusiones.add(linea[1].trim());

        }

        //Si no se ha encontrado ningún error, imprimir correcto
        System.out.println("correct");

    }

}

