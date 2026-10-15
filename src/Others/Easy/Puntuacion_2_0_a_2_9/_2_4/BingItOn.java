package Others.Easy.Puntuacion_2_0_a_2_9._2_4;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BingItOn {

    // Clase auxiliar que representa cada nodo dentro del Trie (Árbol de Prefijos)
    static class TrieNode {
        int count; // Almacena cuántas palabras anteriores han pasado por este nodo (es decir, comparten este prefijo)
        TrieNode[] children; // Apuntadores a los nodos hijos correspondientes a las 26 letras del alfabeto ('a'-'z')

        public TrieNode() {
            this.count = 0;
            this.children = new TrieNode[26];
        }
    }

    public static void main(String[] args) throws IOException {
        // Usamos BufferedReader para una lectura rápida de la entrada estándar
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) {
            return;
        }

        int n = Integer.parseInt(line.trim());
        TrieNode root = new TrieNode();

        // StringBuilder para acumular la salida y escribirla de una sola vez (mejora el rendimiento)
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String word = br.readLine().trim();

            // -------------------------------------------------------------------------
            // PASO 1: Consultar cuántas palabras ANTERIORES empiezan con esta palabra
            // -------------------------------------------------------------------------
            int matchingWords = 0;
            TrieNode current = root;
            boolean prefixExists = true;

            // Recorremos la palabra carácter por carácter en el Trie
            for (int j = 0; j < word.length(); j++) {
                int index = word.charAt(j) - 'a';

                // Si un carácter no existe en el árbol, significa que ninguna palabra
                // anterior tiene este prefijo completo.
                if (current.children[index] == null) {
                    prefixExists = false;
                    break;
                }
                current = current.children[index];
            }

            // Si logramos recorrer toda la palabra en el Trie, el contador del nodo final
            // nos indica exactamente cuántas palabras pasaron por ahí antes.
            if (prefixExists) {
                matchingWords = current.count;
            }

            // Añadimos el resultado de esta palabra a la respuesta acumulada
            sb.append(matchingWords).append("\n");

            // -------------------------------------------------------------------------
            // PASO 2: Insertar la palabra actual en el Trie y actualizar contadores
            // -------------------------------------------------------------------------
            current = root;
            for (int j = 0; j < word.length(); j++) {
                int index = word.charAt(j) - 'a';

                // Si el nodo hijo no existe, lo creamos
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }

                current = current.children[index];
                // Incrementamos el contador para que las siguientes palabras reconozcan
                // que esta palabra forma parte de su prefijo.
                current.count++;
            }
        }

        // Imprimimos el resultado final de golpe
        System.out.print(sb.toString());
    }
}