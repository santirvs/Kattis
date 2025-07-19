package Cap2._2_EstructurasDatosConBibliotecas._7_Ordenacion_Especiales;

import Utils.Kattio;

/*
 Al hacer los casos de prueba, se puede observar que el mínimo de A y el máximo de B son los que suman el valor más pequeño
 pero no pasa el caso #3 --> WA  un caso donde no se cumple es
 2
 80 10
 15 50
 Debe dar 90 y 90, pero este planteamiento da 90 y 65!

 Deben buscarse los valores de A y B que sumen el valor más pequeño y eso se consigue sumando los valores más bajos de A con los más altos de B.

 Adaptando el código de C++

 Caso #4: TLE --> Paso a usar Kattio --> AC

 */


public class Mali {

/*
    public static void main_WA3(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numCasos = scan.nextInt();
        int minA = Integer.MAX_VALUE;
        int maxB = Integer.MIN_VALUE;

        while (numCasos > 0) {
            //Lectura de los datos del caso
            int a = scan.nextInt();
            int b = scan.nextInt();
            minA = Math.min(minA, a);
            maxB = Math.max(maxB, b);
            numCasos--;
            //Mostrar el resultado
            System.out.println(minA+maxB);
        }

    }
}
*/


    static int n;
    static int[] f_a = new int[101];
    static int[] f_b = new int[101]; // f_a[i] is the number of is in a

    public static int compute_max_sum(int num) {
        int[] freq_a = new int[101];
        int[] freq_b = new int[101];
        //Copiar las tablas de frecuencias
        for (int i = 1; i <= 100; i++) {
            freq_a[i] = f_a[i];
            freq_b[i] = f_b[i];
        }

        //Inicializar los valores de los índices y contadores
        int index_a = 1, index_b = 100;
        int counter = 0;
        int max_sum = 0;

        //Recorrer las tablas de frecuencias
        while (counter < num) {
            //Busco el valor de b más alto y el de a más bajo
            while (freq_b[index_b] == 0) {
                index_b--;
            }
            while (freq_a[index_a] == 0) {
                index_a++;
            }
            //Optimización: determinar el número de elementos que resultan en parejas iguales
            int match_num = Math.min(freq_a[index_a], freq_b[index_b]);

            //Actualizo la tabla de frecuencias y los contadores
            freq_b[index_b] -= match_num;
            freq_a[index_a] -= match_num;

            //Me quedo con el máximo de la suma de los índices de la tabla de frecuencias (que son los valores de a y b)
            max_sum = Math.max(max_sum, index_b + index_a);
            counter += match_num;
        }

        return max_sum;
    }

    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        scan.useLocale(Locale.ENGLISH);
        Kattio scan = new Kattio(System.in, System.out);

        n = scan.getInt();
        for (int r = 1; r <= n; r++) {
            int a_c = scan.getInt();
            int b_c = scan.getInt();
            f_a[a_c]++;
            f_b[b_c]++;

            System.out.println(compute_max_sum(r));
        }
    }

}
