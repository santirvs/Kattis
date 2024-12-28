package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._8_BST_Equilibrado_Map;


import java.io.*;
import java.util.*;

public class ProblemClassification {

    public static class Categoria {
        String nombre;
        HashSet<String> palabrasClave;
        int coincidencias;

        public Categoria(String nombre) {
            this.nombre = nombre;
            this.palabrasClave = new HashSet<>();
            coincidencias = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int numCategorias = Integer.parseInt(in.readLine());

        //Crea una lista de categorias y un mapa que contiene las palabras clave de cada categoria
        ArrayList<Categoria> categorias = new ArrayList<>();

        //Lee las categorias y las palabras clave
        for (int i = 0; i < numCategorias; i++) {

            // Crea la categoría y la añade a la lista
            String[] partes = in.readLine().split(" ");
            Categoria categoria = new Categoria(partes[0]);
            categorias.add(categoria);

            //Lee las palabras clave y las añade a la categoria
            int numPalabras = Integer.parseInt(partes[1]);
            for (int j = 0; j < numPalabras; j++) {
                String palabra = partes[j + 2];
                categoria.palabrasClave.add(palabra);
            }
        }

        //Lee la descripción del problema
        try {
            while (true) {
                String descripcion = in.readLine();
                if (descripcion.equals("-1")) break; //Salida manual interactiva
                String[] palabras = descripcion.split(" ");
                for (Categoria categoria : categorias) {
                    for (String palabra : palabras) {
                        if (categoria.palabrasClave.contains(palabra)) {
                            categoria.coincidencias++;
                        }
                    }
                }
            }
        } catch (Exception e) {
            //Se acabó el fichero
        }

        //Ordena las categorias por coincidencias y, en caso de empate, por nombre
        Collections.sort(categorias, new Comparator<Categoria>() {
            @Override
            public int compare(Categoria c1, Categoria c2) {
                int result = c2.coincidencias - c1.coincidencias;
                if (result == 0)
                    result = c1.nombre.compareTo(c2.nombre);
                return result;
            }
        });

        //Imprime las categorias
        int maximo = categorias.get(0).coincidencias;
        for (Categoria categoria : categorias) {
            if (categoria.coincidencias == maximo) {
                out.println(categoria.nombre);
            }
            else break;
        }



        out.flush();
        out.close();
        in.close();
    }


}
