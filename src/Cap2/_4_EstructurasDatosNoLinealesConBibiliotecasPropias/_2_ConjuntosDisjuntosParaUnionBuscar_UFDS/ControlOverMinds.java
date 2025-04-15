package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias._2_ConjuntosDisjuntosParaUnionBuscar_UFDS;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

// Planteamiento del problema a partir de:
// https://github.com/BrandonTang89/Competitive_Programming_4_Solutions/blob/main/Chapter_2_Data_Structures/Data_Structures_With_Our_Own_Libraries/kattis_control.cpp

// v1 : RTE en caso #3 --> simplifico la entrada de datos usando scan
// v2 : Supera el caso #3, pero WA en caso #20
// v3 : Revisada la codificación, no encuentro el posible error. Cambiar la implementación de UnionFind !!!
// v4 : Sigue dando error en el caso #20. Codifico a partir del código de Brandon -> AC
// v5 : Buscando diferencias. Copio implementación de UnionFind, vuelve el WA
// v6 : Buscando diferencias. Copio implementación del main. AC!  Paso a buscar las diferencias en el main
// v7 : Recupero mi implementación de UnionFind. AC!
// v8 : Diferencias en el main...  Reviso la iteración final del unionSet -> WA
// v9 : Diferencias en el main... Reviso la carga de datos y revisión de los calderos usados --> AC
// v10: El motivo era que estaba usando parents y treeSize (heurísticos) en lugar de usar findSet y sizeOfSet


class ControlOverMinds {

    static class UnionFind{

        int[] parents, rank, treeSize;
        int numSets;

        UnionFind(int N){
            parents = new int[N]; for (int i=0;i<N;i++) { parents[i]=i; }
            rank = new int[N];
            treeSize = new int[N]; for (int i=0; i<N;i++){ treeSize[i]= 1; }
            numSets=N;
        }

        int findSet(int i){return (parents[i]==i) ? i : (parents[i] = findSet(parents[i]));}
        boolean isSameSet(int i, int j){return findSet(i) == findSet(j);}
        int numDisjointSets(){return numSets;}
        int sizeOfSet(int i){return treeSize[findSet(i)];}

        void unionSet(int i,int j){
            if (isSameSet(i,j))return;
            int x = findSet(i), y=findSet(j);
            if (rank[x] > rank[y]) { int aux=x; x=y; y=aux; }
            parents[x] = y;
            if (rank[x] == rank[y])++rank[y];
            treeSize[y] += treeSize[x];
            --numSets;
        }
    };

    public static void main(String[] args) throws IOException {
        //Crear el UFDS - máximo 500000 ingredientes
        UnionFind uf = new UnionFind(500001);

        Scanner scan = new Scanner(System.in);

        //Leer los datos
        int numRecetas = scan.nextInt();
        int numPreparaciones = 0;

        while (numRecetas > 0) {
            numRecetas--;

            //Lista de calderos usados para la poción
            Set<Integer> calderosPocion = new HashSet<>();

            //Leer la cantidad de ingredientes
            int numIngredientes = scan.nextInt();

            //Total ingredientes usados
            int totalIngredientes = 0;

//            //Leer los ingredientes
            for (int i = 1; i <= numIngredientes; i++) {
                int ingrediente = scan.nextInt();

                //Si no tengo aún el ingrediente, añado el caldero que lo contiene a la lista
                if (!calderosPocion.contains(uf.findSet(ingrediente))) {
                    calderosPocion.add(uf.findSet(ingrediente));
                    totalIngredientes+=uf.sizeOfSet(uf.findSet(ingrediente));
                }
            }

            //Al acabar de repasar los ingredientes, si el total de ingredientes es igual al número de ingredientes de la receta
            //eso significa que se puede hacer la poción
            //Habra que juntar todos los calderos usados en el primer caldero
            if (totalIngredientes == numIngredientes) {
                numPreparaciones++;
                //Unir todos los ingredientes
                Iterator<Integer> iter = calderosPocion.iterator();
                int calderoBase = iter.next();
                while (iter.hasNext()) {
                    uf.unionSet(calderoBase, iter.next());
                }
            }
        }

        //Imprimir el resultado
        System.out.println(numPreparaciones);
        scan.close();
    }
}