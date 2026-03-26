package Others.Easy.Puntuacion_3_0_a_3_9._3_1;

// Usar un árbol de prefijos (Trie) para determininar si
// el número ya existe

import java.util.Scanner;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserta una palabra en el Trie.
     * Devuelve false si detecta conflicto de prefijo
     */
    public boolean insert(String word) {
        TrieNode current = root;

        for (char c : word.toCharArray()) {
            // Si ya existe una palabra que termina aquí, es prefijo
            if (current.isEndOfWord) {
                return false;
            }

            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
        }

        // Si el nodo tiene hijos, entonces word es prefijo de otra palabra
        if (!current.children.isEmpty()) {
            return false;
        }

        current.isEndOfWord = true;
        return true;
    }

    /**
     * Busca una palabra completa en el Trie.
     */
    public boolean search(String word) {
        TrieNode current = root;

        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }

        return current.isEndOfWord;
    }

    /**
     * Comprueba si existe alguna palabra con este prefijo.
     */
    public boolean startsWith(String prefix) {
        TrieNode current = root;

        for (char c : prefix.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }

        return true;
    }
}


public class PhoneList {
    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);

        int numCasos = scan.nextInt();

        while (numCasos-- > 0) {

            int numTelefonos = scan.nextInt();

            Trie t = new Trie();
            boolean consistente = true;

            while (numTelefonos-- > 0) {
                String telefono = scan.next();

                boolean conflicto = t.insert(telefono);
                consistente = consistente && conflicto;
            }

            if (consistente) System.out.println("YES");
            else System.out.println("NO");

        }
    }
}
