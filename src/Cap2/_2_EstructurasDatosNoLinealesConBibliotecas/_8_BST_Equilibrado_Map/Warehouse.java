package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._8_BST_Equilibrado_Map;


import java.io.*;
import java.util.*;

public class Warehouse {

    public static class Producto {
        String nombre;
        int cantidad;

        public Producto(String nombre, int cantidad) {
            this.nombre = nombre;
            this.cantidad = cantidad;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int numCasos = Integer.parseInt(in.readLine());

        while (numCasos > 0 ) {

            //Lee el numero de productos
            int numProductos = Integer.parseInt(in.readLine());
            HashMap<String, Integer> mapaProductos = new HashMap<>();
            while (numProductos > 0 ) {

                //Leer la línea (producto cantidad)
                String[] partes = in.readLine().split(" ");
                String producto = partes[0];
                int cantidad = Integer.parseInt(partes[1]);

                //Si el producto no está en el mapa, lo añade
                if (!mapaProductos.containsKey(producto)) {
                    mapaProductos.put(producto, cantidad);
                } else {
                    //Si el producto ya está en el mapa, suma la cantidad
                    mapaProductos.put(producto, mapaProductos.get(producto) + cantidad);
                }

                numProductos--;
            }

            //Ordena los productos según la cantidad (descendente) y el nombre (ascendente)
            ArrayList<Producto> listaProductos = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : mapaProductos.entrySet()) {
                listaProductos.add(new Producto(entry.getKey(), entry.getValue()));
            }

            //Ordena la lista de productos
            Collections.sort(listaProductos, new Comparator<Producto>() {
                @Override
                public int compare(Producto p1, Producto p2) {
                    int result = p2.cantidad - p1.cantidad;
                    if (result == 0)
                        result = p1.nombre.compareTo(p2.nombre);
                    return result;
                }
            });

            //Muestra los productos
            out.println(listaProductos.size());
            for (Producto producto : listaProductos) {
                out.println(producto.nombre + " " + producto.cantidad);
            }

            numCasos--;
        }



        out.flush();
        out.close();
        in.close();
    }


}
