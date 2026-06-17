package Others.Easy.Puntuacion_2_0_a_2_9._2_3;


/*
    Movernos adelante y atrás, sin salirnos del array y sin repetir visita.
 */
import java.util.*;

public class SliderPuzzle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numCasos = sc.nextInt();
        sc.nextLine();

        for(int caso=1; caso <=numCasos; caso++) {

            String[] nums = sc.nextLine().split(" ");

            boolean[] visitados = new boolean[nums.length];
            LinkedList<Integer> lista = new LinkedList<>();
            int pos = 0;
            lista.addLast(0);
            boolean encontrado = false;
            while (!lista.isEmpty()) {
                pos = lista.pollFirst();
                visitados[pos]=true;
                int valor = Integer.parseInt(nums[pos]);
                if (valor == 0)  {
                    encontrado = true;
                }

                if (pos-valor >= 0 && !visitados[pos-valor] ) {
                    lista.add(pos-valor);
                }
                if (pos+valor <nums.length && !visitados[pos+valor] ) {
                    lista.add(pos+valor);
                }

            }

            if (encontrado) System.out.println("Puzzle " + caso + " is solvable.");
            else System.out.println("Puzzle " + caso + " is not solvable.");
          }


        sc.close();
        }
    }
