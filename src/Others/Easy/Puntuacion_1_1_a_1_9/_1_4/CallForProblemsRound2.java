package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el número de problemas posibles y el número de problemas a escoger
// Leer las dificultades del número de problemas y guardarlos en un Set para tener las dificultades unicas
// El resultado será el mínimo entre el número de problemas a escoger y el tamaño del Set

import java.util.*;

public class CallForProblemsRound2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Leer los datos
        int numProblemasPosibles = sc.nextInt();
        int numProblemasEscoger =  sc.nextInt();

        //Definir el Set
        Set<Integer> dificultadesDiferentes = new HashSet<Integer>();

        //Leer las dificultades
        for (int i=1; i<=numProblemasPosibles; i++) {
            dificultadesDiferentes.add(sc.nextInt());
        }

        //Mostrar el resultado
        System.out.println(Math.min(numProblemasEscoger,dificultadesDiferentes.size()));

        sc.close();
    }
}

