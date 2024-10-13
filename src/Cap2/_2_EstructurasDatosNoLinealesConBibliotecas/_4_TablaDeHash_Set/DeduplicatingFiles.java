package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._4_TablaDeHash_Set;

import java.util.*;

// Apuntar en un array los hashes de cada cadena
// Caso 2: WA!  Adapto de https://github.com/mpfeifer1/Kattis/blob/master/deduplicatingfiles.cpp  --> AC
//    PENDIENTE DE ANALIZAR!!!


public class DeduplicatingFiles {


    //    public static int getcollisions(unordered_map<int, unordered_map<string, int>> vals) {
    public static int getcollisions(HashMap<Integer, HashMap<String, Integer>> vals) {
        int total = 0;

        // For each hash that landed here
        for(HashMap i : vals.values()) {
            // Get the count of each different string here
            List counts = new ArrayList();
            for(Object j : i.values()) {
                counts.add(j);
            }

            // Calculate the total collisions
            for(int j = 0; j < counts.size()-1; j++) {
                for(int k = j+1; k < counts.size(); k++) {
                    total += (int)counts.get(j) * (int)counts.get(k);
                }
            }
        }

        return total;
    }


   public static int calcularHash(String cadena) {
        int hash = cadena.charAt(0);
        for (int i=1; i<cadena.length(); i++) {
            hash = hash ^ cadena.charAt(i);
        }
        return hash;
    }

   public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);

       int n = scan.nextInt();

       while (n != 0) {
           scan.nextLine();
           HashSet<String> s = new HashSet<>();
           HashMap<Integer, HashMap<String, Integer>> vals = new HashMap<>();

           for (int i = 0; i < n; i++) {
               // Read in sentence, add to set
               String sentence = scan.nextLine();
               s.add(sentence);

               // Calculate hash, add it to list of hashes
               int hash = calcularHash(sentence);
               //vals[hash][sentence]++;
               if (vals.containsKey(hash)) {
                   if (vals.get(hash).containsKey(sentence)) {
                       vals.get(hash).put(sentence, vals.get(hash).get(sentence) + 1);
                   } else {
                       vals.get(hash).put(sentence, 1);
                   }
               } else {
                   HashMap<String, Integer> temp = new HashMap<>();
                   temp.put(sentence, 1);
                   vals.put(hash, temp);
               }
           }


           int c = getcollisions(vals);
           System.out.println(s.size() + " " + c);

           n = scan.nextInt();
       }

    }
}


