package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._6_TablaDeHash_Dificil;

import java.util.*;

// Leer las variables de un HashSet<Long, Int>
// La clave es el nombre de la variable y el valor es el número de instrucción en que se estableció su valor
// El valor se establece al hacer un write y será el max(valor de las variables leídas) + 1
// Si la variable no existe, su valor será 0
// El resultado es el valor más alto entre todos los writes

// Caso de prueba #11: WA - Adapto de https://github.com/mpfeifer1/Kattis/blob/master/parallelanalysis.cpp
//                     No veo diferencias significativas respecto a mi implementación, salvo <Int,Int> en lugar de <Long,Int>
//                     Y compruebo que no es eso
//                     La diferencia es que en mi implementación es que también tengo en cuenta el valor de la variable
//                     que voy a escribir (para asegurar que una instrucción más tardía no sobreescriba una más temprana)
//                     En la implementación de mpfeifer1 no se tiene en cuenta el valor de la variable que se va a escribir
//                     y se sobreescriben valores más tempranos.  ---> AC!!


public class ParallelAnalysis {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int numCasos = scan.nextInt();
        int numCas = 0;

        while (numCas < numCasos) {

            int numInstrucciones = scan.nextInt();
            HashMap<Long, Integer> variables = new HashMap<>();
            int max = 0;

            for (int i = 0; i < numInstrucciones; i++) {
                int numVariables = scan.nextInt();
                int maxVar = 0;
                for (int j = 0; j < numVariables-1; j++) {
                    long var = scan.nextLong();
                    if (variables.containsKey(var)) {
                        maxVar = Math.max(maxVar, variables.get(var));
                    } else {
                        maxVar = Math.max(maxVar, 0);
                    }
                }
                long var = scan.nextLong();
                /*
                if (variables.containsKey(var)) {
                    maxVar = Math.max(maxVar, variables.get(var));
                } else {
                    maxVar = Math.max(maxVar, 0);
                }
                */
                variables.put(var, maxVar+1);
                max = Math.max(max, maxVar+1);
            }
            numCas++;
            System.out.println(numCas + " " + max);

        }
    }

}

/*  AC!!!
public class ParallelAnalysis {
    static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
        int cases = scan.nextInt();
        for (int i = 1; i <= cases; i++) {
            System.out.print(i + " ");
            solve();
        }
    }

    public static void solve() {


        int numCasos = scan.nextInt();
        int best = 0;

        HashMap<Long, Integer> variables = new HashMap<>();
        for(int i = 0; i < numCasos; i++) {
            int t = scan.nextInt();
            int besthere = 0;
            long v;
            for(int j = 0; j < t-1; j++) {
                v = scan.nextLong();
                int valor = variables.containsKey(v) ? variables.get(v) : 0;
                besthere = Math.max(besthere, valor);
            }
            v = scan.nextLong();
            besthere++;
            variables.put(v, besthere);
            best = Math.max(best, besthere);
        }

        System.out.println(best);


    }

}
*/