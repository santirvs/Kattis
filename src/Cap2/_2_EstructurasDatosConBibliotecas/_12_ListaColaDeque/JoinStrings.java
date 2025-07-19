package Cap2._2_EstructurasDatosConBibliotecas._12_ListaColaDeque;

import Utils.Kattio;

// Es necesario construir una lista de cadenas de texto a partir de una lista de cadenas de texto
// Las operaciones deben realizarse en O(1)

// Uso una LinkedList para almacenar las cadenas de texto

// Caso #3: RTE -> Miro en https://github.com/alif898/Kattis-Solutions/blob/main/JoinStrings.java
//              --> veo que lo implementa igual, pero con una linkedList "handmade", que supongo que ocupa menos memoria
/*
public class JoinStrings {

    public static void main(String[] args) {
        //Scanner scan = new Scanner(System.in);
        //scan.useLocale(Locale.ENGLISH);
        Kattio scan = new Kattio(System.in);

        //Lectura de datos
        LinkedList<String> lista = new LinkedList<>();
        int numCadenas = scan.getInt();

        //Array de cadenas
        LinkedList[] cadenas = new LinkedList[numCadenas+1];

        //Carga las cadenas en el array
        for (int i=1; i<=numCadenas; i++) {
            cadenas[i] = new LinkedList<String>();
            cadenas[i].add(scan.getWord());
        }

        int ultimo = 0;
        //Realiza las operaciones de unión
        for (int i=0; i<numCadenas-1; i++) {
            int a = scan.getInt();
            int b = scan.getInt();
            cadenas[a].addAll(cadenas[b]);
            cadenas[b].clear();
            cadenas[b] = null;
            ultimo = a;
        }

        //Imprime la lista
        for (int i=0; i<cadenas[ultimo].size(); i++) {
            System.out.print(cadenas[ultimo].get(i));
        }
        System.out.println();

    }

}
*/

/**
 * @author Alif Naufal Farrashady A0218302U
 */

public class JoinStrings {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        int n = io.getInt();
        TailedLinkedList[] listArray = new TailedLinkedList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            TailedLinkedList nextList = new TailedLinkedList();
            nextList.addNode(new HelperNode(io.getWord()));
            listArray[i] = nextList;
        }
        int resultIndex = 1;
        for (int j = 1; j < n; j++) {
            int a = io.getInt();
            int b = io.getInt();
            listArray[a].addList(listArray[b]);
            resultIndex = a;
        }
        listArray[resultIndex].print(io);
        io.close();
    }
}

class HelperNode {
    String string;
    HelperNode next;

    HelperNode(String string) {
        this.string = string;
        this.next = null;
    }

    void addNext(HelperNode next) {
        if (this.next == null) {
            this.next = next;
        } else {
            this.next.addNext(next);
        }
    }
}

class TailedLinkedList {
    HelperNode head;
    HelperNode tail;
    int size;

    TailedLinkedList() {
        size = 0;
    }

    void addNode(HelperNode node) {
        node.addNext(this.head);
        this.head = node;
        this.tail = head;
        size ++;
    }

    void addList(TailedLinkedList other) {
        tail.next = other.head;
        other.head = null;
        tail = other.tail;
        size += other.size;
    }

    void print(Kattio io) {
        HelperNode current = head;
        io.write(current.string);
        for (int i = 1; i < size; i++) {
            current = current.next;
            io.write(current.string);
        }
    }
}
