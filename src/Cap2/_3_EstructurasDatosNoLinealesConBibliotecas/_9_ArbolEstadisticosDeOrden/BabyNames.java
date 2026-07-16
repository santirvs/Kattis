package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._9_ArbolEstadisticosDeOrden;

// Usa estadísticos de orden y sólo se ha implementado en C++
// pero en Visual Studio C++ no se permite el uso de bits/stdc++.h
// Pruebo a hacerlo en Java con TreeSet y con subSet(desde, hasta),
// que devuelve un subconjunto de elementos que están en el rango [desde, hasta)
// y luego hago size() para saber cuántos elementos hay en ese rango.
// Esta solución supera los 6 primeros casos de prueba, pero luego da TLE.
// Esperar a conocer los árboles de Fenwick ya que los PBDS no están implementados en Java.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BabyNames {

    static class Trie {
        static class Node {
            int count = 0;     // Palabras activas en este subárbol
            int endCount = 0;  // Palabras activas que terminan exactamente aquí
            Node[] children = new Node[26];
        }

        Node root = new Node();

        void insert(String s) {
            Node curr = root;
            curr.count++;
            for (int i = 0; i < s.length(); i++) {
                int idx = s.charAt(i) - 'A';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new Node();
                }
                curr = curr.children[idx];
                curr.count++;
            }
            curr.endCount++;
        }

        void remove(String s) {
            // Primero verificamos si la palabra realmente existe en este género
            if (!contains(s)) return;

            Node curr = root;
            curr.count--;
            for (int i = 0; i < s.length(); i++) {
                int idx = s.charAt(i) - 'A';
                curr = curr.children[idx];
                curr.count--;
            }
            curr.endCount--;
        }

        boolean contains(String s) {
            Node curr = root;
            for (int i = 0; i < s.length(); i++) {
                int idx = s.charAt(i) - 'A';
                if (curr.children[idx] == null) return false;
                curr = curr.children[idx];
            }
            return curr.endCount > 0;
        }

        // Cuenta cuántas palabras en el Trie tienen un prefijo estrictamente menor que 's'
        int countLessThan(String s) {
            Node curr = root;
            int total = 0;
            for (int i = 0; i < s.length(); i++) {
                // Si hay palabras que terminan exactamente en el prefijo de 's' actual,
                // son menores que 's' y deben ser sumadas
                if (i > 0 && curr.endCount > 0) {
                    total += curr.endCount;
                }

                int limitChar = s.charAt(i) - 'A';
                // Sumamos todos los caminos (subárboles) que se desvían a la izquierda de 's'
                for (int idx = 0; idx < limitChar; idx++) {
                    if (curr.children[idx] != null) {
                        total += curr.children[idx].count;
                    }
                }

                if (curr.children[limitChar] == null) {
                    return total;
                }
                curr = curr.children[limitChar];
            }
            return total;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Trie masculino = new Trie();
        Trie femenino = new Trie();

        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line == null) break;
            st = new StringTokenizer(line);
            if (!st.hasMoreTokens()) continue;

            int command = Integer.parseInt(st.nextToken());
            if (command == 0) break;

            if (command == 1) {
                String name = st.nextToken();
                int gender = Integer.parseInt(st.nextToken());
                if (gender == 1) {
                    masculino.insert(name);
                } else {
                    femenino.insert(name);
                }
            } else if (command == 2) {
                String name = st.nextToken();
                // Eliminamos de donde exista
                masculino.remove(name);
                femenino.remove(name);
            } else if (command == 3) {
                String start = st.nextToken();
                String end = st.nextToken();
                int gender = Integer.parseInt(st.nextToken());

                int ans = 0;
                if (gender == 1 || gender == 0) {
                    ans += masculino.countLessThan(end) - masculino.countLessThan(start);
                }
                if (gender == 2 || gender == 0) {
                    ans += femenino.countLessThan(end) - femenino.countLessThan(start);
                }
                sb.append(ans).append("\n");
            }
        }
        System.out.print(sb);
    }
}