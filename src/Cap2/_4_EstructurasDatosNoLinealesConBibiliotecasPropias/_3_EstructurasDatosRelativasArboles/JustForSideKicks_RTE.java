package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias._3_EstructurasDatosRelativasArboles;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

//v1. RTE en Caso #2
//v2. El RTE estaba causado por el Reader!!!

public class JustForSideKicks_RTE {

    static class FenwickTree {
        //Array del acumulador de frecuencias
        private long[] sums;
        //Tamaño
        private int size;

        //Devuelve el 1 menos significativo del número pasado por parámetro
        // Less Significant One
        public int LSOne(int i) {
            return i & -i;
        }

        //Constructor segun el tamaño estimado
        public FenwickTree(int size) {
            this.size = size;
            this.sums = new long[size + 1];
        }

        //Actualización de los nodos del árbol
        public void update(int i, int value) {
            while (i <= size) {
                sums[i] += value;
                i += i & -i;
            }
        }

        //Suma los nodos del árbol
        public long sum(int i) {
            long s = 0;
            while (i > 0) {
                s += sums[i];
                i -= i & -i;
            }
            return s;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

       //Lectura de la primera línea
        int numGemas = scan.nextInt();
        int numConsultas = scan.nextInt();

        //Segunda línea
        //Lectura de los valores iniciales de las gemas
        int[] valorTipos = new int[6];  //6 tipos, base 0
        for (int i=0; i<6; i++) {
            int valorGema = scan.nextInt();
            valorTipos[i] = valorGema;
        }

        //Tercera línia
        //Preparacion de los árboles Fenwick (uno por cada tipo)
        FenwickTree[] fw = new FenwickTree[6];
        for (int i=0; i<6; i++) {
            fw[i] = new FenwickTree(numGemas);
        }

        //Lectura de los tipos de gemas de cada posicion
        scan.nextLine();
        String gemas = scan.nextLine();
        for (int i=0; i<numGemas;i++) {
            String tipo = gemas.substring(i, i + 1);
            int tipoInt = Integer.parseInt(tipo);
            tipoInt--;
            fw[tipoInt].update(i+1,1);
        }

        //Últimas líneas
        //Consultas
        for (int i=0; i<numConsultas;i++) {
            int tipo = scan.nextInt();
            switch (tipo) {
                case 1:
                    //La gema en la posición K pasa a ser del tipo P
                    int posK = scan.nextInt();
                    int tipoP = scan.nextInt();
                    for (int j=0; j<6; j++) {
                        //Incrementar en 1 el árbol del tipo j en la posK
                        if (tipoP-1 == j) {
                            fw[j].update(posK,1);
                        }
                        else {
                            //Buscar qué árbol tiene la gema en la posicion K
                            //y restarle 1
                            if (fw[j].sum(posK) > fw[j].sum(posK-1)) {
                                fw[j].update(posK,-1);
                            }
                        }
                    }
                    break;

                case 2:
                    // La gema de tipo G pasa a valer V
                    int tipoG = scan.nextInt();
                    int valorV = scan.nextInt();
                    valorTipos[tipoG-1] = valorV;
                    break;

                case 3:
                    //Suma del valor de las gemas entre las posiciones L y R
                    long sumaTotal = 0;
                    int posL = scan.nextInt();
                    int posR = scan.nextInt();
                    for (int j=0; j<6; j++) {
                        long totalGemasTipo = fw[j].sum(posR) - fw[j].sum(posL-1);
                        sumaTotal += totalGemasTipo * valorTipos[j];
                    }
                    System.out.println(sumaTotal);
                    break;
            }

        }

    }
}


/*

8 5
10 30 25 420 39 69
55513642
3 2 6

39 39 39 10 25 69 420 30
    X  X  X  X  X
    Suma = 39+39+10+25+69 = 182

1 1 6  -> cambiar tipo de gema de la P1 al tipo 6

69 39 39 10 25 69 420 30

2 6 3286  --> cambio de valor de la gema de tipo 6 al nuevo valor de 3286

3286 39 39 10 25 3286 420 30

3 2 6

3286 39 39 10 25 3286 420 30
     X  X  X  X  X
     Suma = 39+39+10+25+3286 = 3399

3 1 8

3286 39 39 10 25 3286 420 30
X    X  X  X  X  X    X   X
     Suma = 3286+39+39+10+25+3286+420+30 = 7135

 */