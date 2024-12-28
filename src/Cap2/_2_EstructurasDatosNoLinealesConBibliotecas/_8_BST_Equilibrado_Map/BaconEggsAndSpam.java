package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._8_BST_Equilibrado_Map;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;


public class BaconEggsAndSpam {

    public static void main(String[] args) throws IOException {
        //Scanner scan = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        //Lee el numero de personas
        int numPersonas = Integer.parseInt(in.readLine());
        while (numPersonas > 0) {
            //Crea un mapa que guardará los platos y las personas que los han pedido
            TreeMap<String, ArrayList<String>> mapaPlatos = new TreeMap<>();
            while (numPersonas > 0) {
                //Lee los platos que ha pedido la persona
                String[] platos = in.readLine().split(" ");
                String persona = platos[0];
                for (int i=1; i<platos.length; i++) {
                    //Si el plato no está en el mapa, lo añade
                    if (!mapaPlatos.containsKey(platos[i])) {
                        ArrayList<String> personas = new ArrayList<>();
                        mapaPlatos.put(platos[i], personas);
                    }
                    //Añade la persona al plato
                    mapaPlatos.get(platos[i]).add(persona);
                }
                numPersonas--;
            }

            //Imprime los platos y las personas que los han pedido
            for (String plato : mapaPlatos.keySet()) {
                ArrayList<String> personas = mapaPlatos.get(plato);
                Collections.sort(personas);
                out.println(plato + " " + String.join(" ", personas));
            }
            out.println();

            numPersonas = Integer.parseInt(in.readLine());
        }

        out.flush();
        out.close();
        in.close();
    }

}

