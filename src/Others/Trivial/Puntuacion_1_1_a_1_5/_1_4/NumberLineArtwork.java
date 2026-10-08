package Others.Trivial.Puntuacion_1_1_a_1_5._1_4;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class NumberLineArtwork {

    // Definición del nodo para la Lista Doblemente Enlazada.
    // Cada nodo representa una marca en la línea numérica con su color y enlaces al vecino izquierdo y derecho.
    static class Node {
        String color;
        Node prev;
        Node next;

        public Node(String color) {
            this.color = color;
            this.prev = null;
            this.next = null;
        }
    }

    public static void main(String[] args) throws IOException {
        // Usamos BufferedReader y StringTokenizer para optimizar la lectura de datos de entrada masivos.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // 1. Lectura de N (número de brazos) y Q (número de acciones)
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;
        st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        // 2. Lectura de los colores iniciales de las marcas
        line = br.readLine();
        st = new StringTokenizer(line);

        Node head = null; // Apuntador al extremo izquierdo de la línea
        Node tail = null; // Apuntador al extremo derecho de la línea

        // Arreglo para mantener la referencia directa al nodo donde descansa cada brazo
        Node[] armNode = new Node[N];

        for (int i = 0; i < N; i++) {
            String color = st.nextToken();
            Node newNode = new Node(color);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }

            // Inicialmente, el i-ésimo brazo descansa sobre la i-ésima marca
            armNode[i] = newNode;
        }

        // 3. Procesamiento de las Q acciones
        for (int q = 0; q < Q; q++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            int armId = Integer.parseInt(st.nextToken());
            String action = st.nextToken();

            if (action.equals("L")) {
                // Movimiento a la izquierda: el brazo pasa al nodo anterior
                armNode[armId] = armNode[armId].prev;
            } else if (action.equals("R")) {
                // Movimiento a la derecha: el brazo pasa al nodo siguiente
                armNode[armId] = armNode[armId].next;
            } else {
                // Creación de una nueva marca:
                // Se inserta un nuevo nodo inmediatamente a la izquierda del nodo actual del brazo.
                Node curr = armNode[armId];
                Node newNode = new Node(action);
                Node prevNode = curr.prev;

                // Reenlazar los punteros de la lista doblemente enlazada
                newNode.next = curr;
                newNode.prev = prevNode;
                curr.prev = newNode;

                if (prevNode != null) {
                    prevNode.next = newNode;
                } else {
                    // Si el nodo anterior es nulo, significa que la nueva marca es el nuevo extremo izquierdo
                    head = newNode;
                }

                // El brazo pasa a descansar sobre la nueva marca recién creada
                armNode[armId] = newNode;
            }
        }

        // 4. Generación del resultado final recorriendo la lista desde la cabeza (izquierda a derecha)
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.color);
            if (current.next != null) {
                sb.append(" ");
            }
            current = current.next;
        }

        // Imprimir la secuencia final de colores
        System.out.println(sb.toString());
    }
}