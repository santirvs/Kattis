package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._8_BST_Equilibrado_Map;

import java.io.*;
import java.util.TreeMap;

public class UnBearAbleZoo {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int numItems = Integer.parseInt(in.readLine());
        int numLista = 0;

        while (numItems > 0 ) {
            numLista++;

            //Mapa de animales --> contador
            TreeMap<String, Integer> mapa = new TreeMap<>();
            //Leer los animales
            while (numItems > 0) {
                String[] linea = in.readLine().split(" ");
                String animal = linea[linea.length-1].toLowerCase();
                if (!mapa.containsKey(animal)) {
                    mapa.put(animal, 1);
                } else {
                    mapa.put(animal, mapa.get(animal)+1);
                }

                numItems--;
            }

            //Mostrar el resultado
            out.println("List " + numLista + ":");
            for (String animal : mapa.keySet()) {
                out.println(animal + " | " + mapa.get(animal));
            }

            //Siguiente caso
            numItems = Integer.parseInt(in.readLine());
        }

        out.flush();
        out.close();
        in.close();
    }

}
