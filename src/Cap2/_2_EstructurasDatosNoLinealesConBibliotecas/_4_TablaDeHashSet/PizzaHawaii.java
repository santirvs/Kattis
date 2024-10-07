package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._4_TablaDeHashSet;


import java.util.*;

// HAcer una lista para cada ingrediente
// Si el ingrediente no existe, se añade a la lista con todas sus posibles traducciones
// Si el ingrediente ya existe, se revisan los ingredientes existentes con sus posibles nuevas traducciones. Solo se mantienen las que existen en ambas
// Al final, se imprime la lista de ingredientes con sus posibles traducciones


public class PizzaHawaii {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int numCasos = scan.nextInt();



        for (int i=0; i<numCasos; i++) {
            HashMap<String, HashSet<String>> ingredientesPosiblesTraducciones = new HashMap<String, HashSet<String>>();
            HashSet<String> invitados = new HashSet<String>();

            int numPizzas = scan.nextInt();


            for (int j = 0; j< numPizzas; j++) {
                List<String> traducciones = new ArrayList<String>();
                List<String> ingredientes = new ArrayList<String>();

                scan.nextLine();   //Ignorar el salto de línea anterior
                scan.nextLine();   //Nombre de la pizza. La ignoramos

                //Leer traducciones
                int numTraducciones = scan.nextInt();
                for (int k = 0; k < numTraducciones; k++) {
                    traducciones.add(scan.next());
                }
                //Leer ingredientes
                int numIngredientes = scan.nextInt();
                for (int k = 0; k < numIngredientes; k++) {
                    ingredientes.add(scan.next());
                }

                //Recorrer los ingredientes
                for (String ingrediente : ingredientes) {
                    //Ya contiene el ingrediente: revisar las traducciones y mantener solo las que existen en ambas
                    if (ingredientesPosiblesTraducciones.containsKey(ingrediente)) {
                        HashSet<String> traduccionesPosibles = ingredientesPosiblesTraducciones.get(ingrediente);
                        HashSet<String> traduccionesPosiblesNuevas = new HashSet<String>();
                        for (String traduccion : traducciones) {
                            if (traduccionesPosibles.contains(traduccion)) {
                                traduccionesPosiblesNuevas.add(traduccion);
                            }
                        }
                        ingredientesPosiblesTraducciones.put(ingrediente, traduccionesPosiblesNuevas);
                    } else {
                        //No contiene el ingrediente: añadirlo con todas sus traducciones
                        HashSet<String> traduccionesPosibles = new HashSet<String>();
                        for (String traduccion : traducciones) {
                            traduccionesPosibles.add(traduccion);
                        }
                        ingredientesPosiblesTraducciones.put(ingrediente, traduccionesPosibles);
                    }
                }

            }
            List<String> ingredientes = new ArrayList<String>(ingredientesPosiblesTraducciones.keySet());
            Collections.sort(ingredientes);

            //Imprimir ingredientes con sus traducciones
            for (String ingrediente : ingredientes) {
                //Recuperar las traducciones y ordenarlas
                HashSet<String> traduccionesPosibles = ingredientesPosiblesTraducciones.get(ingrediente);
                Iterator iter = traduccionesPosibles.iterator();
                List<String> traducciones = new ArrayList<String>();
                while (iter.hasNext()) {
                    traducciones.add((String)iter.next());
                }
                Collections.sort(traducciones);

                //Imprimir cada ingrediente con sus posibles traducciones
                for (String traduccion : traducciones) {
                    System.out.println("(" + ingrediente + ", " + traduccion + ")");
                }
            }

            System.out.println("");


            //*** LA SALIDA ES TRADUCCION, INGREDIENTE. Hay que cambiarlo!!!

            //*** SALEN MÁS DE LA CUENTA!!!!




        }


    }

}

