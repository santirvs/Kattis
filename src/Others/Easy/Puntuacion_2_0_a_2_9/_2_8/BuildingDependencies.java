package Others.Easy.Puntuacion_2_0_a_2_9._2_8;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.ArrayDeque;

public class BuildingDependencies {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        if (line == null || line.trim().isEmpty()) {
            return;
        }

        int n = Integer.parseInt(line.trim());

        // adj: almacena las dependencias directas de cada archivo (A depende de B, C...)
        Map<String, List<String>> adj = new HashMap<String, List<String>>();
        // revAdj: almacena quién depende de quién (si A depende de B, B afecta a A)
        Map<String, List<String>> revAdj = new HashMap<String, List<String>>();

        for (int i = 0; i < n; i++) {
            line = reader.readLine();
            if (line == null) break;

            String[] parts = line.split(":");
            String target = parts[0].trim();

            List<String> deps = new ArrayList<String>();
            if (parts.length > 1 && !parts[1].trim().isEmpty()) {
                String[] depFiles = parts[1].trim().split("\\s+");
                for (String dep : depFiles) {
                    deps.add(dep);

                    // Registrar en el grafo inverso (dep -> target)
                    List<String> revList = revAdj.get(dep);
                    if (revList == null) {
                        revList = new ArrayList<String>();
                        revAdj.put(dep, revList);
                    }
                    revList.add(target);
                }
            }
            adj.put(target, deps);
        }

        String changed = reader.readLine().trim();

        // ---------------------------------------------------------
        // Fase 1: Encontrar todos los archivos afectados usando BFS
        // ---------------------------------------------------------
        Set<String> affected = new HashSet<String>();
        Queue<String> queue = new ArrayDeque<String>();

        queue.add(changed);
        affected.add(changed);

        while (!queue.isEmpty()) {
            String u = queue.poll();
            List<String> dependents = revAdj.get(u);
            if (dependents != null) {
                for (String v : dependents) {
                    if (!affected.contains(v)) {
                        affected.add(v);
                        queue.add(v);
                    }
                }
            }
        }

        // ---------------------------------------------------------
        // Fase 2: Ordenamiento topológico de los archivos afectados
        // ---------------------------------------------------------
        Set<String> visited = new HashSet<String>();
        List<String> result = new ArrayList<String>();

        for (String file : affected) {
            if (!visited.contains(file)) {
                dfs(file, adj, affected, visited, result);
            }
        }

        // Imprimir el resultado en el orden correcto de compilación
        for (String file : result) {
            System.out.println(file);
        }
    }

    private static void dfs(String u, Map<String, List<String>> adj, Set<String> affected, Set<String> visited, List<String> result) {
        visited.add(u);
        List<String> deps = adj.get(u);
        if (deps != null) {
            for (String v : deps) {
                // Solo recorremos dependencias que también pertenezcan al conjunto de afectados
                if (affected.contains(v) && !visited.contains(v)) {
                    dfs(v, adj, affected, visited, result);
                }
            }
        }
        // Post-orden: agregamos el nodo cuando ya se procesaron todas sus dependencias necesarias
        result.add(u);
    }
}