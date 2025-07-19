package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._8_BST_Equilibrado_Map;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeMap;

// Caso de prueba #2: WA --> Empezar a contar desde 0 y no desde la diferencia entre los primeros elementos de cada lista
// Caso de prueba #3: WA --> Corregir el < a <= hasta el último elemento de la lista de salidas
// Caso de prueba #5: TLE --> No se puede hacer un recorrido de 1000 millones de iteraciones!!!
//   - Si se calculan las diferencias entre las listas de entradas y salidas, se puede hacer un recorrido de 2000 * 2000 iteraciones
//     que, aunque lento, entra dentro de lo aceptable
//   - Miramos la distancia entre todos los elementos de la entrada y la salida
//   - Vamos contando en un mapa las coincidencias para cada distancia (incremento) incremento -> contador de coincidencias
//   - Finalmente, recorremos las claves del mapa y buscamos la de mayor coincidencia
//   - La clave con mayor coincidencia es la distancia que buscamos
//   --> AC!

public class CakeyMcCakeFace {

    public static void main(String[] args) throws IOException {
        //Scanner scan = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        //Lee el numero de personas
        int numEntradas = Integer.parseInt(in.readLine());
        int numSalidas = Integer.parseInt(in.readLine());

        //Crea una lista con las salidas y otra lista con las entradas
        ArrayList<Integer> listaEntradas = new ArrayList<>();
        ArrayList<Integer> listaSalidas = new ArrayList<>();

        //Lee las entradas y las guarda en una lista
        String[] partes = in.readLine().split(" ");
        for (int i = 0; i < numEntradas; i++) {
            listaEntradas.add(Integer.parseInt(partes[i]));
        }

        //Lee las salidas y las guarda en una lista
        partes = in.readLine().split(" ");
        for (int i = 0; i < numSalidas; i++) {
            listaSalidas.add(Integer.parseInt(partes[i]));
        }

        //Registra en un mapa la distancia entre los elementos de la lista de salidas y la lista de entradas
        TreeMap<Integer, Integer> contadorDistancias = new TreeMap<>();
        for (int salida : listaSalidas) {
            for (int entrada : listaEntradas) {
                int distancia = salida - entrada;
                if (distancia >= 0)
                    contadorDistancias.put(distancia, contadorDistancias.getOrDefault(distancia, 0) + 1);
            }
        }

        //Busca la distancia con mayor coincidencia
        int maximo = 0;
        int distancia = 0;
        for (int key : contadorDistancias.keySet()) {
            if (contadorDistancias.get(key) > maximo) {
                maximo = contadorDistancias.get(key);
                distancia = key;
            }
        }

        System.out.println(distancia);

        out.flush();
        out.close();
        in.close();
    }

}

