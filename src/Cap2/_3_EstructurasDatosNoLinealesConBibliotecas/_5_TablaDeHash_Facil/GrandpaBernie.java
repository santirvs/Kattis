package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._5_TablaDeHash_Facil;


import java.io.*;
import java.util.*;

// Leer los viajes a cada país y apuntarlos en una lista.
// Ordenar las listas
// Responder a las preguntas accediendo a la lista de cada país y a la posición indicada

// Caso #3: TLE  -- uso fast io  -> TLE
//-- ordeno las listas, sólo si se necesita -> TLE
// copio de https://github.com/shakeelsamsu/kattis/blob/master/src/grandpabernie.java -> AC
// Falta analizar el código y compararlo con el de la solución de kattis
//   --> Usar fast output --> TLE
//   --> Usar StringTokenizer en lugar de .split(" ") --> TLE
//  --> Usar un HashSet para los países visitados --> TLE
//  --> Dejo de usar FastIO y uso BufferedReader y PrintWriter  --> AC

public class GrandpaBernie {


    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int numViajes = Integer.parseInt(in.readLine());

        HashMap<String, List<Integer>> viajes = new HashMap<String, List<Integer>>();

        for (int i=0; i<numViajes; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            String pais = st.nextToken();
            int anyo = Integer.parseInt(st.nextToken());

            if (viajes.get(pais)!=null) {
                //Añadir a la lista de viajes del país
                viajes.get(pais).add(anyo);
            } else {
                //Añadir el pais a la lista con su primer año
                List<Integer> lista = new ArrayList<>();
                lista.add(anyo);
                viajes.put(pais, lista);
            }
        }

        //Responder a las preguntas
        int numPreguntas = Integer.parseInt(in.readLine());
        HashSet<String> visitados = new HashSet<>();
        for (int i=0; i<numPreguntas; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            String pais = st.nextToken();
            int posicion = Integer.parseInt(st.nextToken());

            if (!visitados.contains(pais)) {
                visitados.add(pais);
                //Ordenar la lista de viajes del país
                Collections.sort(viajes.get(pais));
            }
            //System.out.println(viajes.get(pais).get(posicion-1));
            out.println(viajes.get(pais).get(posicion-1));
        }

        out.close();

    }

}
