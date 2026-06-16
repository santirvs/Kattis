package Others.Easy.Puntuacion_2_0_a_2_9._2_3;


/*
    Crear un Mapa Int, List<Int> donde apuntamos las piezas que tira la pieza
    Añadir en una cola las piezas que se tiran y las que tira cada una de esas piezas siempre que no las hayamos tirado ya
    Añadir en un Set las piezas que se van tirando
 */

import java.io.IOException;
import java.util.*;

public class Dominoes2 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numCasos = sc.nextInt();

        while (numCasos-- > 0) {

            int tamanyoDomino = sc.nextInt();  //Podria usarlo con un boolean[tamanyoDomino] que indique las piezas caídas de forma recursiva
            int numParejas = sc.nextInt();
            int numEmpujadas = sc.nextInt();

            //Leer las parejas
            HashMap<Integer, List<Integer>> mapa = new HashMap<>();
            for (int i=0; i<numParejas; i++) {
                int piezaInicial = sc.nextInt();
                int piezaFinal = sc.nextInt();

                if (mapa.containsKey(piezaInicial))
                    mapa.get(piezaInicial).add(piezaFinal);
                else {
                    List<Integer> l = new ArrayList<>();
                    l.add(piezaFinal);
                    mapa.put(piezaInicial, l);
                }
            }

            //Tiramos las piezas
            Deque<Integer> cola = new LinkedList<>();
            HashSet<Integer> set = new HashSet<>();
            for (int i=0; i<numEmpujadas; i++) {
                int pieza=sc.nextInt();
                cola.add(pieza);
            }

            //Vaciar la cola
            while (!cola.isEmpty()) {
                int num = cola.pollFirst();
                if (!set.contains(num)) {
                    set.add(num);
                    List<Integer> l = mapa.get(num);
                    if (l!=null) {
                        cola.addAll(l);
                    }
                }
            }

            //Imprimir el resultado
            System.out.println(set.size());

        }


    }
}

