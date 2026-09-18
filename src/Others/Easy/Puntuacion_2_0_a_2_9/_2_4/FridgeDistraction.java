package Others.Easy.Puntuacion_2_0_a_2_9._2_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FridgeDistraction {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        // Simulación del estado del refrigerador con una lista ligera
        List<Character> fridge = new ArrayList<Character>();
        for (int i = 0; i < N; i++) {
            fridge.add((char) ('a' + i));
        }

        List<Character> ans = new ArrayList<Character>();

        // Resolver de forma codiciosa reduciendo T
        while (T > 0) {
            // Si T cabe en el tamaño actual del refrigerador, tomamos directamente el elemento en el índice T
            if (T <= fridge.size()) {
                int pos = T - 1; // 0-indexed
                char picked = fridge.remove(pos);
                fridge.add(0, picked);
                ans.add(picked);
                T = 0; // Terminado
            } else {
                // Si T es mayor que N, sacamos el elemento más lejano posible que nos acerque a T
                // preferiblemente en el fondo (posición N)
                int targetPos = Math.min(T - 1, fridge.size() - 1);

                // Ajuste para evitar dejar un residuo inalcanzable de 0 en el último paso
                if (T - (targetPos + 1) == 0) {
                    // Ya es exacto
                } else if (T - (targetPos + 1) < 1) {
                    targetPos--;
                }

                char picked = fridge.remove(targetPos);
                fridge.add(0, picked);
                ans.add(picked);
                T -= (targetPos + 1);
            }
        }

        // Salida formateada
        System.out.println(ans.size());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.size(); i++) {
            sb.append(ans.get(i));
            if (i < ans.size() - 1) sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}