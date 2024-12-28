package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._8_BST_Equilibrado_Map;

// Case #2: TLE --> Cambiar a fast input/output -> AC
// Case #5: TLE --> Pasar de TreeMap a HashMap y hacer un sort al final --> AC


import java.io.*;
import java.util.*;

public class HardwoodSpecies {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        //Mientras haya entradas, leer el tipo de árbol y apuntarlo en un mapa  arbol --> cantidad
        //Contar también la cantidad de árboles
        HashMap<String, Integer> arboles = new HashMap<>();
        int cantidadArboles = 0;
        try {
        while (true) {
            String arbol = in.readLine();
            if (arbol.equals("-1")) break;  //Test local
            cantidadArboles++;
            if (arboles.containsKey(arbol)) {
                arboles.put(arbol, arboles.get(arbol) + 1);
            } else {
                arboles.put(arbol, 1);
            }
        }
        } catch (Exception e) {
            //Final del archivo
        }

        //Ordenar el mapa por el nombre del árbol
        List<String> listaArboles = new ArrayList<>(arboles.keySet());
        Collections.sort(listaArboles);

        //Imprimir el tipo de árbol y el porcentaje que representa sobre el total
        for (String arbol : listaArboles) {
            System.out.println(arbol + " " + String.format("%.4f", (arboles.get(arbol).intValue() * 100.0) / cantidadArboles));
        }
    }

}
