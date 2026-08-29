package Others.Easy.Puntuacion_2_0_a_2_9._2_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class Talnalas {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        String line = reader.readLine();
        if (line == null || line.trim().isEmpty()) return;

        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String startState = reader.readLine().trim();
        String targetState = reader.readLine().trim();

        ArrayList<String> luckyList = new ArrayList<String>();
        Map<String, Integer> stringToIndex = new HashMap<String, Integer>();

        // IMPORTANTE: El estado inicial y final son válidos por definición.
        // Deben ser agregados al conjunto de nodos transitables.
        stringToIndex.put(startState, luckyList.size());
        luckyList.add(startState);

        if (!stringToIndex.containsKey(targetState)) {
            stringToIndex.put(targetState, luckyList.size());
            luckyList.add(targetState);
        }

        // Leer las m líneas de números de la suerte adicionales
        for (int i = 0; i < m; i++) {
            String lucky = reader.readLine().trim();
            if (!stringToIndex.containsKey(lucky)) {
                stringToIndex.put(lucky, luckyList.size());
                luckyList.add(lucky);
            }
        }

        int startIdx = stringToIndex.get(startState);
        int targetIdx = stringToIndex.get(targetState);
        int totalNodes = luckyList.size();

        // ------------------------------------------------------------------
        // EJECUCIÓN DEL BFS
        // ------------------------------------------------------------------
        int[] parent = new int[totalNodes];
        for (int i = 0; i < totalNodes; i++) {
            parent[i] = -1;
        }

        boolean[] visited = new boolean[totalNodes];
        Queue<Integer> queue = new ArrayDeque<Integer>();

        visited[startIdx] = true;
        queue.add(startIdx);

        boolean reached = false;

        while (!queue.isEmpty()) {
            int currentIdx = queue.poll();

            if (currentIdx == targetIdx) {
                reached = true;
                break;
            }

            char[] currentChars = luckyList.get(currentIdx).toCharArray();

            for (int i = 0; i < n; i++) {
                char originalChar = currentChars[i];
                int digit = originalChar - '0';

                int nextDigit = (digit + 1) % 10;
                int prevDigit = (digit + 9) % 10;

                int[] candidates = {nextDigit, prevDigit};

                for (int nextD : candidates) {
                    currentChars[i] = (char) (nextD + '0');
                    String neighborStr = new String(currentChars);

                    Integer neighborIdx = stringToIndex.get(neighborStr);
                    if (neighborIdx != null && !visited[neighborIdx]) {
                        visited[neighborIdx] = true;
                        parent[neighborIdx] = currentIdx;
                        queue.add(neighborIdx);
                    }
                }

                currentChars[i] = originalChar;
            }
        }

        // ------------------------------------------------------------------
        // RECONSTRUCCIÓN DE LA SALIDA
        // ------------------------------------------------------------------
        if (!reached) {
            writer.println("Neibb");
        } else {
            ArrayList<Integer> path = new ArrayList<Integer>();
            int curr = targetIdx;
            while (curr != -1) {
                path.add(curr);
                curr = parent[curr];
            }

            Collections.reverse(path);

            int k = path.size() - 1;
            writer.println(k);

            for (int idx : path) {
                writer.println(luckyList.get(idx));
            }
        }

        writer.flush();
    }
}