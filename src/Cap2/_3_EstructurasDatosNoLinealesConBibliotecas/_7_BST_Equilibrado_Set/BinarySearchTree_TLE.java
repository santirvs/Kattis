package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._7_BST_Equilibrado_Set;

import java.io.*;

// Crear una estructura BST que, además de guardar los números, acumule la cantidad de niveles que se han recorrido
// Caso de prueba #5: TLE - Cambio a fast input/output. Sigue el TLE

public class BinarySearchTree_TLE {

    public static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public int insert(int value) {
            int niveles = 0;
            if (value < this.value) {
                if (this.left == null) {
                    this.left = new BST(value);
                } else {
                    niveles += this.left.insert(value);
                }
            } else {
                if (this.right == null) {
                    this.right = new BST(value);
                } else {
                    niveles+= this.right.insert(value);
                }
            }
            return niveles+1;
        }

    }

    public static void main(String[] args) throws IOException {

        //Scanner scan = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int numValores = Integer.parseInt(in.readLine())-1;


        BST arbol = new BST(Integer.parseInt(in.readLine()));
        int totalNiveles = 0;
        out.println(totalNiveles);

        while (numValores > 0) {
            totalNiveles += arbol.insert(Integer.parseInt(in.readLine()));
            out.println(totalNiveles);

            numValores--;
        }

        out.flush();
        out.close();

    }

}
