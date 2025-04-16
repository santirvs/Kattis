package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias._2_ConjuntosDisjuntosParaUnionBuscar_UFDS;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Chatter {

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
        Scanner scan = new Scanner(System.in);

        //Leer los datos de cada día, mientras hayan datos
        while (scan.hasNext()) {

            int numConectados = scan.nextInt();
            //Leer los valores de la fórmula para el random
            int r = scan.nextInt();
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();

            //Crear el UFDS - de personas conectadas  0..numConectados-1
            UnionFind uf = new UnionFind(numConectados);

            //Intentar conectar los diferentes pares de personas
            for (int i = 0; i < numConectados; i++) {
                int x=-1;
                int y=-1;
                while (x==y) {
                    //Generar los números aleatorios
                    r = ((a * r + b) % c);
                    x = r % numConectados;
                    r = ((a * r + b) % c);
                    y = r % numConectados;
                }
                //Al salir del bucle, x!=y, conectar los dos grupos
                uf.unionSet(x, y);
            }

            //Al acabar el día, contar los grupos
            int numGrupos = uf.numDisjointSets();

            HashSet<Integer> disjointSets = new HashSet<>();
            List<Integer> tamanyosGrupos = new ArrayList<>();
            for (int i=0; i< numConectados; i++) {
                int root = uf.findSet(i);
                if (!disjointSets.contains(root)) {
                    disjointSets.add(root);
                    tamanyosGrupos.add(uf.sizeOfSet(root));
                }
            }

            //Ordenar la lista de tamaños de mayor a menor
            Collections.sort(tamanyosGrupos, Collections.reverseOrder());

            //Mostrar el número de grupos y los tamaños
            System.out.print(numGrupos);
            int tamanyo = tamanyosGrupos.get(0);
            int contador = 1;
            for (int i = 1; i < tamanyosGrupos.size(); i++) {
                int nuevoTamanyo = tamanyosGrupos.get(i);
                if (nuevoTamanyo == tamanyo) contador++;
                else if (contador > 1) {
                    System.out.print(" " + tamanyo + "x" + contador);
                    contador = 1;
                    tamanyo = nuevoTamanyo;
                }
                else {
                    System.out.print(" " + tamanyo);
                    tamanyo = nuevoTamanyo;
                }
            }
            //Gestión del último grupo
            if (contador > 1) {
                System.out.println(" " + tamanyo + "x" + contador);
            } else {
                System.out.println(" " + tamanyo);
            }
        }
    }
}
