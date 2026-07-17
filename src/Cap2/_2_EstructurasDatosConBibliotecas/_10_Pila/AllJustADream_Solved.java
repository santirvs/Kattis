package Cap2._2_EstructurasDatosConBibliotecas._10_Pila;


// Adapto el código de https://github.com/BrandonTang89/Competitive_Programming_4_Solutions/blob/main/Chapter_2_Data_Structures/Linear_DS_with_Built-in_Libraries/kattis_dream.cpp
// ya que tengo un TLE y el planteamiento es parecido. Una vez más sospecho que el límite de tiempo para Java es insuficiente
// Efectivmente, el código de BrandonTang89 también da TLE una vez se adapta a Java.

// Eliminar tipos de datos complejos y usar estructuras básicas

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AllJustADream_Solved {

    // Clase Trie ultra-rápida y eficiente en memoria para mapear String -> ID
    static class EventTrie {
        static class Node {
            int id = -1;
            Node[] children = null;
        }

        Node root = new Node();
        int nextId = 0;

        // Inserta o busca el ID de una palabra. Soporta compensar el inicio por si viene con '!'
        int getOrCreateId(String s, int offset) {
            Node curr = root;
            int len = s.length();
            for (int i = offset; i < len; i++) {
                int c = s.charAt(i) - 'a';
                if (c < 0 || c > 25) { // Para el carácter '_' que es común en este problema
                    c = 26;
                }
                if (curr.children == null) {
                    curr.children = new Node[27];
                }
                if (curr.children[c] == null) {
                    curr.children[c] = new Node();
                }
                curr = curr.children[c];
            }
            if (curr.id == -1) {
                curr.id = nextId++;
            }
            return curr.id;
        }

        // Solo busca el ID. Retorna -1 si no existe (el evento nunca se ha visto)
        int getIdIfExists(String s, int offset) {
            Node curr = root;
            int len = s.length();
            for (int i = offset; i < len; i++) {
                int c = s.charAt(i) - 'a';
                if (c < 0 || c > 25) {
                    c = 26;
                }
                if (curr.children == null || curr.children[c] == null) {
                    return -1;
                }
                curr = curr.children[c];
            }
            return curr.id;
        }
    }

    public static void main(String[] args) {
        FastScanner scan = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = scan.nextInt();

        // Arrays primitivos en lugar de ArrayLists para máxima velocidad
        int[] stack = new int[n + 5];
        int stackSize = 0;

        // Almacenamos en qué posición del stack se encuentra cada ID de evento
        int[] pos = new int[n + 5];
        for (int i = 0; i < pos.length; i++) {
            pos[i] = -1;
        }

        EventTrie trie = new EventTrie();

        for (int e = 0; e < n; e++) {
            String type = scan.next();
            char c = type.charAt(0);

            if (c == 'E') {
                String eventStr = scan.next();
                int eventId = trie.getOrCreateId(eventStr, 0);

                stack[stackSize] = eventId;
                pos[eventId] = stackSize;
                stackSize++;

            } else if (c == 'D') {
                int x = scan.nextInt();
                for (int i = 0; i < x; i++) {
                    stackSize--;
                    int removedEventId = stack[stackSize];
                    pos[removedEventId] = -1; // Ya no está en el stack real
                }

            } else { // 'S'
                int x = scan.nextInt();
                boolean plotError = false;
                int stackLte = stackSize;
                int stackGte = -1;

                for (int i = 0; i < x; i++) {
                    String eventStr = scan.next();
                    if (plotError) continue;

                    boolean negate = eventStr.charAt(0) == '!';
                    int offset = negate ? 1 : 0;

                    // Buscamos el ID del evento (sin crear nuevas sub-cadenas)
                    int eventId = trie.getIdIfExists(eventStr, offset);

                    if (!negate) { // El evento DEBE haber ocurrido
                        if (eventId == -1 || pos[eventId] == -1) {
                            plotError = true;
                        } else {
                            // No podemos recortar más allá de donde ocurrió este evento requerido
                            stackGte = Math.max(stackGte, pos[eventId]);
                        }
                    } else { // El evento NO debe haber ocurrido
                        if (eventId != -1 && pos[eventId] != -1) {
                            // Para que no exista, tendríamos que descartarlo (su posición es la cota superior)
                            stackLte = Math.min(stackLte, pos[eventId]);
                        }
                    }
                }

                if (plotError || stackLte <= stackGte) {
                    out.println("Plot Error");
                } else if (stackLte == stackSize) {
                    out.println("Yes");
                } else {
                    out.println((stackSize - stackLte) + " Just A Dream");
                }
            }
        }
        out.flush(); // Imprimir todo de golpe
    }

    // Lector rápido personalizado (Fast I/O) para Java
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
