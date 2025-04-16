package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias._2_ConjuntosDisjuntosParaUnionBuscar_UFDS;

import java.util.*;

//Idea original de: https://github.com/BrandonTang89/Competitive_Programming_4_Solutions/blob/main/Chapter_2_Data_Structures/Data_Structures_With_Our_Own_Libraries/kattis_almostunionfind.cpp

// El problema principal reside en el movimiento de un elemento de un conjunto a otro
// El problema se puede resolver con un UnionFind, pero es necesario modificar la estructura
// de datos para que el movimiento de un elemento no implique la unión de los conjuntos
// Al eliminar un elemento, en lugar de eliminarlo, se crea un nuevo conjunto con el elemento y el anterior se marca
// como eliminado. De esta forma, el elemento se puede mover a otro conjunto sin necesidad de eliminarlo con un simple union


public class AlmostUnionFind {

    // Clase UnionFind modificada para permitir el movimiento de elementos entre conjuntos
    // Se ha añadido un array m que almacena el índice del elemento en el conjunto
    // y un contador que se incrementa cada vez que se añade un nuevo elemento
    // Se ha añadido un array setSum que almacena la suma de los elementos del conjunto
    // y un array vals que almacena el valor del elemento en el conjunto
    static class UnionFind {
        private List<Integer> p, rank, setSize;
        private List<Long> vals, setSum;
        public List<Integer> m;
        private int counter;

        public UnionFind(int N) {
            p = new ArrayList<>(Collections.nCopies(N, 0));
            rank = new ArrayList<>(Collections.nCopies(N, 0));
            setSize = new ArrayList<>(Collections.nCopies(N, 1));
            vals = new ArrayList<>(Collections.nCopies(N, 0L));
            setSum = new ArrayList<>(Collections.nCopies(N, 0L));
            m = new ArrayList<>(N);
            for (int i = 0; i < N; i++) {
                p.set(i, i);
                m.add(i);
                vals.set(i, (long) (i + 1));
                setSum.set(i, vals.get(i));
            }
            counter = N;
        }

        private int findSet(int i) {
            if (!p.get(i).equals(i)) {
                p.set(i, findSet(p.get(i)));
            }
            return p.get(i);
        }

        public boolean isSameSet(int i, int j) {
            return findSet(i) == findSet(j);
        }

        public int sizeOfSet(int i) {
            return setSize.get(findSet(i));
        }

        public long sumOfSet(int i) {
            return setSum.get(findSet(i));
        }

        public void unionSet(int i, int j) {
            if (isSameSet(i, j)) return;
            int x = findSet(i);
            int y = findSet(j);
            if (rank.get(x) > rank.get(y)) {
                int temp = x;
                x = y;
                y = temp;
            }
            p.set(x, y);
            if (rank.get(x).equals(rank.get(y))) {
                rank.set(y, rank.get(y) + 1);
            }
            setSize.set(y, setSize.get(y) + setSize.get(x));
            setSum.set(y, setSum.get(y) + setSum.get(x));
        }

        // Mueve un elemento de un conjunto a otro
        public void moveSet(int i, int j) {
            if (isSameSet(m.get(i), m.get(j))) return;

            // Add new element
            p.add(counter);
            rank.add(0);
            setSize.add(1);
            vals.add(vals.get(i));
            setSum.add(vals.get(i));

            // Remove from old set
            int oldSet = findSet(m.get(i));
            setSize.set(oldSet, setSize.get(oldSet) - 1);
            setSum.set(oldSet, setSum.get(oldSet) - vals.get(i));

            m.set(i, counter);
            counter++;

            unionSet(m.get(i), m.get(j));
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Mientras hayan datos, habrán juegos de pruebas
        while (sc.hasNext()) {
            //Leer el número de elementos y el número de operaciones
            int numElementos = sc.nextInt();
            int numOperaciones = sc.nextInt();

            //Crear el UFDS con el numero de elementos
            UnionFind UF = new UnionFind(numElementos);

            //Tratar las operaciones
            for (int oper = 0; oper < numOperaciones; oper++) {
                int codOperacion = sc.nextInt();
                if (codOperacion == 1) {
                    //Unir dos conjuntos
                    int p = sc.nextInt() - 1;
                    int q = sc.nextInt() - 1;
                    UF.unionSet(UF.m.get(p), UF.m.get(q));
                } else if (codOperacion == 2) {
                    //Mover un elemento de un conjunto a otro
                    int p = sc.nextInt() - 1;
                    int q = sc.nextInt() - 1;
                    UF.moveSet(p, q);
                } else if (codOperacion == 3) {
                    //Mostrar el número de elementos y la suma de los elementos del conjunto
                    int p = sc.nextInt() - 1;
                    int size = UF.sizeOfSet(UF.m.get(p));
                    long sum = UF.sumOfSet(UF.m.get(p));
                    System.out.printf("%d %d%n", size, sum);
                }
            }
        }
    }
}
