package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._4_TablaDeHash_Set;


import java.util.*;

// Hacer dos listas para cada traducción
// Una lista de traducciones posibles
// Una lista de traducciones imposibles
// Al aparecer una nueva traducción, se le añaden todos los ingredientes de la pizza a los ingredientes posibles
//    y se añaden todos los ingredientes aparecidos antes de esta pizza a los ingredientes imposibles
// Si la traducción ya existía, se revisan sus ingredientes posibles entre los ingredientes de la pizza y se añaden a imposibles los que no aparezcan
// Si alguna traducción no aparece en la lista de traducciones de la pizza, todos los ingredientes se añaden a la lista de imposibles


public class PizzaHawaii {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int numCasos = scan.nextInt();

        for (int i=0; i<numCasos; i++) {
            HashMap<String, HashSet<String>> posiblesIngredientes = new HashMap<String, HashSet<String>>();
            HashMap<String, HashSet<String>> imposiblesIngredientes = new HashMap<String, HashSet<String>>();
            HashSet<String> ingredientesExistentes = new HashSet<String>();
            HashSet<String> traduccionesExistentes = new HashSet<String>();

            int numPizzas = scan.nextInt();

            for (int j = 0; j< numPizzas; j++) {
                //Leer traduccionesPizza e ingredientesPizza de la pizza
                List<String> traduccionesPizza = new ArrayList<String>();
                List<String> ingredientesPizza = new ArrayList<String>();

                scan.nextLine();   //Ignorar el salto de línea anterior
                scan.nextLine();   //Nombre de la pizza. La ignoramos

                //Leer traduccionesPizza
                int numTraducciones = scan.nextInt();
                for (int k = 0; k < numTraducciones; k++) {
                    traduccionesPizza.add(scan.next());
                }
                //Leer ingredientesPizza
                int numIngredientes = scan.nextInt();
                for (int k = 0; k < numIngredientes; k++) {
                    ingredientesPizza.add(scan.next());
                }

                //Comprobar si las traducciones existentes aparecen en la nueva pizza
                //Si no aparece, se le añaden todos los ingredientes de la pizza a la lista de imposibles
                for (String traduccion : traduccionesExistentes) {
                    if (!traduccionesPizza.contains(traduccion)) {
                        HashSet<String> ingredientesImposibles = imposiblesIngredientes.get(traduccion);
                        ingredientesImposibles.addAll(ingredientesPizza);
                    }
                }

                //Recorrer las traduccionesPizza
                for (String traduccion : traduccionesPizza) {
                    //Ya contiene la traducción: revisar los ingredientesPizza y añadir a los imposibles los que no estén
                    if (posiblesIngredientes.containsKey(traduccion)) {
                        HashSet<String> ingredientesImposibles = imposiblesIngredientes.get(traduccion);
                        HashSet<String> ingredientesPosibles = posiblesIngredientes.get(traduccion);
                        for (String ingrediente : ingredientesPosibles) {
                            if (!ingredientesPizza.contains(ingrediente)) {
                                ingredientesImposibles.add(ingrediente);
                            }
                        }
                    } else {
                        //No contiene la traducción: añadirla con todos los ingredientes de la Pizza
                        //Añadir a los imposibles todos los ingredientes existentes hasta el momento
                        HashSet<String> ingredientesPosibles = new HashSet<String>();
                        ingredientesPosibles.addAll(ingredientesPizza);
                        posiblesIngredientes.put(traduccion, ingredientesPosibles);
                        HashSet<String> ingredientesImposibles = new HashSet<String>();
                        ingredientesImposibles.addAll(ingredientesExistentes);
                        imposiblesIngredientes.put(traduccion, ingredientesImposibles);
                    }
                }

                //Añadir los ingredientesPizza a la lista de ingredientesPizza existentes
                ingredientesExistentes.addAll(ingredientesPizza);
                traduccionesExistentes.addAll(traduccionesPizza);

            }
            List<String> traducciones = new ArrayList<String>(posiblesIngredientes.keySet());
            Collections.sort(traducciones);

            //Imprimir traducciones con sus ingredientes
            for (String traduccion : traducciones) {
                //Recuperar las traducciones y ordenarlas
                HashSet<String> ingredientesPosibles = posiblesIngredientes.get(traduccion);
                HashSet<String> ingredientesImposibles = imposiblesIngredientes.get(traduccion);

                //Eliminar los ingredientes imposibles de los posibles
                ingredientesPosibles.removeAll(ingredientesImposibles);

                Iterator iter = ingredientesPosibles.iterator();
                List<String> ingredientes = new ArrayList<String>();
                while (iter.hasNext()) {
                    ingredientes.add((String)iter.next());
                }
                Collections.sort(ingredientes);

                //Imprimir cada ingrediente con sus posibles traducciones
                for (String ingrediente : ingredientes) {
                    System.out.println("(" + traduccion + ", " + ingrediente + ")");
                }
            }

            System.out.println("");
        }

    }

}

