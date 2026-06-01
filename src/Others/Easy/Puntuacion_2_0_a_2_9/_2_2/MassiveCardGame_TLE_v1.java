package Others.Easy.Puntuacion_2_0_a_2_9._2_2;

/**
 * v1 : Vector de frecuencias acumulado
 *  Leer la cantidad de cartas
 *  Si se crea un vector, como el tamaño es 10^9 MLE!!
 *  Debe usarse un mapa ordenado TreeMap y las funciones .ceilingKey y .floorKey
 *
 *  v2: TLE -> 100.000 elementos son muchos para un TreeMap.
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class MassiveCardGame_TLE_v1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<Integer, Integer> mapa = new TreeMap<>();

        //Leer los datos
        String line = br.readLine();
        int numValores = Integer.parseInt(line.trim());

        //Inicializar el mapa
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numValores; i++) {
            int valor = Integer.parseInt(st.nextToken());
            if (mapa.containsKey(valor)) {
                mapa.put(valor, mapa.get(valor) + 1);
            } else {
                mapa.put(valor, 1);
            }
        }

        //Añadir centinelas al mapa
        mapa.put(-1,0);
        mapa.put(Integer.MAX_VALUE, 0);

        //Acumular el mapa
        int acumulado = 0;
        for (int key : mapa.keySet()) {
            acumulado += mapa.get(key);
            mapa.put(key, acumulado);
        }

        //Resolver las consultas
        int numConsultas = Integer.parseInt(br.readLine().trim());

        for (int consulta = 0; consulta < numConsultas; consulta++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            int totalLeft = mapa.get(mapa.floorKey(left-1));
            int totalRight = mapa.get(mapa.floorKey(right));

            int contador = totalRight - totalLeft;

            System.out.println(contador);
        }
    }
}

