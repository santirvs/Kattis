package Cap3._2_BusquedaCompleta._1_CalculoPrevio;

// Dado que sólo hay 13 casos posibles, se calculan previamente y luego se responden a las consultas
// Para calcularlo previamente, se puede partir de la solución final para cada caso y calcularla hacia atrás

import java.util.*;

public class CardTrick {

    static Queue<Integer> q[] = new Queue[13+1];

    private static void calcularSoluciones() {

        // Para calcular una solución, basta con simular el proceso inverso
        for (int numCartas = 1; numCartas < q.length; numCartas++) {

            q[numCartas] = new LinkedList<>();
            q[numCartas].add(numCartas);

            for (int carta=numCartas-1; carta > 0; carta--) {
                // Añadir la carta actual al final
                q[numCartas].add(carta);

                // Mover la última carta al principio n veces (n la posición de la carta actual)
                for (int i = 0; i < carta; i++) {
                    int lastCard = q[numCartas].poll();
                    q[numCartas].add(lastCard);
                }

            }
        }
    }

    private static void imprimirSolucion(int caso) {
        List<Integer> solucion = new ArrayList<>(q[caso]);
        boolean first = true;
        for (int i = solucion.size()-1; i >=0; i--) {
           if (!first) System.out.print(" ");
           else first = false;
            System.out.print(solucion.get(i));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        calcularSoluciones();
        Scanner scan = new Scanner(System.in);

        int numCasos = scan.nextInt();

        for (int i = 0; i < numCasos; i++) {
            int caso = scan.nextInt();
            imprimirSolucion(caso);
        }

    }

}