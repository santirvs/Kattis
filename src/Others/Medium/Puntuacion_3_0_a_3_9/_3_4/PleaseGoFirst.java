package Others.Medium.Puntuacion_3_0_a_3_9._3_4;

/*
    El tiempo óptimo de cada grupo esperando arriba seria: (N * (N-1)) / 2
    Leemos la cola y la guardamos en un Map <String, List<Int>>
    donde la key es el nombre del grupo y List<Int> son los instantes de llegada de cada individuo
    Finalmente recorremos el keySet del Map y calculamos la diferencia de tiempo de cada individuo con el último
    ya que todos tendran que esperar a ese último.
    Acumular los tiempos de espera y restar el tiempo óptimo
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PleaseGoFirst {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numCasos = scan.nextInt();
        while (numCasos-- > 0) {

            int tamanyoCola = scan.nextInt();
            String cola = scan.next();
            HashMap<Character, ArrayList<Integer>> mapa = new HashMap<>();

            //Leer toda la cola
            for (int i=0; i<tamanyoCola; i++) {
                char c = cola.charAt(i);
                if (mapa.containsKey(c)) {
                    mapa.get(c).add(i);
                } else {
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(i);
                    mapa.put(c, l);
                }
            }

            //Analizar las listas
            long totalTiempoAhorrado = 0;
            for (char c : mapa.keySet()) {
                ArrayList<Integer> lista = mapa.get(c);
                int tamanyoGrupo = lista.size();
                int totalTiempo = 0;
                for (int n : lista) {
                    //Cada miembro debe esperar al último en llegar (cada uno tarda 5 segundos)
                    totalTiempo += (lista.get(tamanyoGrupo-1) - n ) * 5;
                }
                //Calcular el tiempo óptimo del grupo
                int tiempoOptimo = ((tamanyoGrupo * (tamanyoGrupo-1)) / 2)*5;

                totalTiempoAhorrado += (totalTiempo - tiempoOptimo);
            }

            //Mostrar el resultado
            System.out.println(totalTiempoAhorrado);
        }

        scan.close();
    }
}