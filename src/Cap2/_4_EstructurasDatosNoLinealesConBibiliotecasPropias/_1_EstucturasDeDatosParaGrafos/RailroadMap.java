package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias._1_EstucturasDeDatosParaGrafos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RailroadMap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCasos = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (numCasos-- > 0) {
            br.readLine(); // Leer y descartar línea vacía
            String[] linea = br.readLine().split(" ");
            int estaciones = Integer.parseInt(linea[0]);
            int tramos = Integer.parseInt(linea[1]);

            //Construir el grafo de conexiones entre estaciones
            //Inicialmente, está vacío
            List<Map<Integer, List<Integer>>> grafoConexiones = new ArrayList<>();
            for (int i = 0; i <= estaciones; i++) {
                grafoConexiones.add(new HashMap<>());
            }

            //Cuenta el número de conexiones de cada estación
            //Base 1 (el índice 0 no se va a usar)
            int[] numConexiones = new int[estaciones + 1];

            for (int i = 0; i < tramos; i++) {
                String[] edge = br.readLine().split(" ");
                int estacionA = Integer.parseInt(edge[0]);
                int estacionB = Integer.parseInt(edge[1]);
                int longitud = Integer.parseInt(edge[2]);

                //Conecta A con B y B con A
                for (int j = 0; j < 2; j++) {
                    grafoConexiones.get(estacionA).putIfAbsent(estacionB, new ArrayList<>());
                    grafoConexiones.get(estacionA).get(estacionB).add(longitud);
                    numConexiones[estacionA]++;
                    //Intercambio de estaciones
                    int temp = estacionA;
                    estacionA = estacionB;
                    estacionB = temp;
                }
            }

            //Busca las estaciones con 2 conexiones, que luego habrá que eliminar
            Queue<Integer> estacionesAEliminar = new LinkedList<>();

            for (int i = 1; i <= estaciones; i++) {
                if (numConexiones[i] == 2) estacionesAEliminar.add(i);
            }

            //Mientras la lista de estaciones a eliminar no esté vacía
            while (!estacionesAEliminar.isEmpty()) {
                //Recupera la primera estación
                int i = estacionesAEliminar.poll();
                if (numConexiones[i] == 2) {
                    List<int[]> conexiones = new ArrayList<>();
                    //Recorre las conexiones de la estación y las añade a la lista de conexiones
                    for (Map.Entry<Integer, List<Integer>> entry : grafoConexiones.get(i).entrySet()) {
                        int j = entry.getKey();
                        for (int w : entry.getValue()) {
                            conexiones.add(new int[]{j, w});
                        }
                    }

                    //Recupera los datos de las 2 conexiones (estación y distancia)
                    int a = conexiones.get(0)[0];
                    int b = conexiones.get(0)[1];
                    int c = conexiones.get(1)[0];
                    int d = conexiones.get(1)[1];

                    //Decrementa el número de conexiones de las estaciones
                    numConexiones[a]--;
                    numConexiones[c]--;
                    //Elimina las conexiones de la estación i
                    grafoConexiones.get(i).clear();
                    //Elimina la conexión de las estaciones a y c
                    grafoConexiones.get(a).remove(i);
                    if (a != c) grafoConexiones.get(c).remove(i);

                    //Incrementa el número de conexiones de las estaciones a y c
                    numConexiones[a]++;
                    numConexiones[c]++;

                    //Fusiona las conexiones de las estaciones a y c
                    grafoConexiones.get(a).putIfAbsent(c, new ArrayList<>());
                    grafoConexiones.get(c).putIfAbsent(a, new ArrayList<>());
                    grafoConexiones.get(a).get(c).add(b + d);
                    grafoConexiones.get(c).get(a).add(b + d);

                    //Si la estación pasa a tener 2 conexiones, se añade a la lista a eliminar
                    if (numConexiones[a] == 2 && !estacionesAEliminar.contains(a)) estacionesAEliminar.add(a);
                    if (a != c && numConexiones[c] == 2 && !estacionesAEliminar.contains(c)) estacionesAEliminar.add(c);
                }
            }

            //Construye el conjunto de conexiones para la salida
            Set<String> E = new HashSet<>();
            for (int i = 1; i <= estaciones; i++) {
                for (Map.Entry<Integer, List<Integer>> entry : grafoConexiones.get(i).entrySet()) {
                    int j = entry.getKey();
                    for (int w : entry.getValue()) {
                        int min = Math.min(i, j);
                        int max = Math.max(i, j);
                        E.add(min + " " + max + " " + w);
                    }
                }
            }

            sb.append(E.size()).append("\n");
            for (String e : E) sb.append(e).append("\n");
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
