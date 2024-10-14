package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._6_TablaDeHash_Dificil;

import java.util.*;

// Guardar un set de palabras para cada miembro de la conversación y otro para el conteo de palabras
// Al final, recorrer los sets y hacer la intersección de todos los sets
// Si el resultado es vacío, imprimir "ALL CLEAR"
// Si el resultado no es vacío, imprimir las palabras ordenadas alfabéticamente

public class ConversationalLog {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        HashMap<String, HashSet<String>> palabras = new HashMap<String, HashSet<String>>();
        HashMap<String, Integer> conteoPalabras = new HashMap<String, Integer>();
        int numConversaciones = scan.nextInt();
        scan.nextLine();

        //Añadir las palabras a los sets de cada miembro
        while (numConversaciones > 0) {
            String[] conversacion = scan.nextLine().split(" ");
            String miembro = conversacion[0];
            if (!palabras.containsKey(miembro)) {
                palabras.put(miembro, new HashSet<String>());
            }
            for (int i = 1; i < conversacion.length; i++) {
                palabras.get(miembro).add(conversacion[i]);

                //Añadir las palabras al conteo general de palabras
                if (conteoPalabras.containsKey(conversacion[i])) {
                    conteoPalabras.put(conversacion[i], conteoPalabras.get(conversacion[i]) + 1);
                } else {
                    conteoPalabras.put(conversacion[i], 1);
                }
            }

            numConversaciones--;
        }

        //Hacer la intersección de todos los sets
        HashSet<String> resultado = new HashSet<String>();
        boolean primero = true;
        for (HashSet<String> palabrasMiembro : palabras.values()) {
            if (primero) {
                resultado.addAll(palabrasMiembro);
                primero = false;
            } else {
                resultado.retainAll(palabrasMiembro);
            }
        }

        //Si el resultado es vacío, imprimir "ALL CLEAR"
        if (resultado.isEmpty()) {
            System.out.println("ALL CLEAR");
        } else {
            //Si el resultado no es vacío, imprimir las palabras ordenadas alfabéticamente
            List<AbstractMap.SimpleImmutableEntry<Integer, String>> resultadoOrdenado = new ArrayList<AbstractMap.SimpleImmutableEntry<Integer,String>>();
            for (String palabra : resultado) {
                resultadoOrdenado.add(new AbstractMap.SimpleImmutableEntry<Integer, String>(conteoPalabras.get(palabra), palabra));
            }
            Collections.sort(resultadoOrdenado, new Comparator<AbstractMap.SimpleImmutableEntry<Integer, String>>() {
                @Override
                public int compare(AbstractMap.SimpleImmutableEntry<Integer, String> o1, AbstractMap.SimpleImmutableEntry<Integer, String> o2) {
                    if (o1.getKey() == o2.getKey()) {
                        return o1.getValue().compareTo(o2.getValue());
                    } else {
                        return o2.getKey() - o1.getKey();
                    }
                }
            });
            for (AbstractMap.SimpleImmutableEntry<Integer,String> p : resultadoOrdenado) {
                System.out.println(p.getValue());
            }
        }
    }

}

