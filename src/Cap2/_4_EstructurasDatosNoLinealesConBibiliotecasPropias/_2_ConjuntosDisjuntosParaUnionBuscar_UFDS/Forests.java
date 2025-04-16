package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias._2_ConjuntosDisjuntosParaUnionBuscar_UFDS;

import java.util.*;

// v1.0 - No veo como usar UFDS en este caso

public class Forests {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextInt(); // Ignorar el segundo valor

        // Crear un mapa para almacenar la listas de árboles que escucha cada persona
        Map<Integer, List<Integer>> people = new HashMap<>();

        // Leer las demás líneas de entrada
        while (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            if (i == -1) break; // Terminar si se encuentra un 0  (salida manual)
            int j = scanner.nextInt();
            //people.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
            if (!people.containsKey(i)) {
                people.put(i, new ArrayList<>());
            }
            people.get(i).add(j);
        }

        //Comprobar los árboles que escucha cada persona
        Set<String> ans = new HashSet<>();
        for (int k = 1; k <= n; k++) {
            //Obtiene la lista de árboles que escucha la persona k y la ordena
            List<Integer> list = people.getOrDefault(k, new ArrayList<>());
            Collections.sort(list);
            //Construye una cadena con los árboles
            StringBuilder sb = new StringBuilder();
            for (int idx = 0; idx < list.size(); idx++) {
                sb.append(list.get(idx));
                if (idx < list.size() - 1) {
                    sb.append("-");
                }
            }
            //Añade la cadena al conjunto
            ans.add(sb.toString());
        }

        //Imprime el número de conjuntos diferentes
        System.out.println(ans.size());
    }
}
