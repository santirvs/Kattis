package Others.Easy.Puntuacion_3_0_a_3_9._3_7;

// Leer los datos
// 1a línea: num_colores (N) y num_niveles (M)   1 <= N,M, <= 10^5
// 2a línea: número de patos de cada color ( 0 ... 10^18)
// 3a línea: M enteros, el color de cada nivel
// ¿Cuantos niveles pueden hacerse?
// Busqueda binaria en espacio de soluciones:
// El número de niveles estará entre 0 y M
// Si tengo suficientes patos para hacer M/2, probaré a hacer más niveles,
// en caso contrario, probaré a hacer menos niveles
import java.util.Scanner;


public class TheDuckamyds_WA {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int numColores = scan.nextInt();
        int numNiveles = scan.nextInt();

        long[] numPatos = new long[numColores+1]; // Descartamos la posición 0
        int[] colorNivel = new int[numNiveles+1];

        for (int i = 1; i <= numColores; i++) {
            numPatos[i] = scan.nextLong();
        }

        for (int i = 1; i <numNiveles+1; i++) {
            colorNivel[i] = scan.nextInt();
        }


        //Busqueda binaria en el espacio 0..numNiveles
        int lo = 0;
        int hi = numNiveles;
        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (esPosible(mid, colorNivel, numPatos)) lo = mid + 1;
            else hi = mid - 1;
        }
        if (esPosible(lo, colorNivel, numPatos)) hi = lo;
        if (!esPosible(lo, colorNivel, numPatos)) hi--;

        System.out.println(hi);


        scan.close();
    }


    public static boolean esPosible(int fin, int[] colorNivel, long[] numPatos) {
        boolean posible = true;
        long nivelDesdeArriba = 1;
        long[] numPatosUsados = new long[numPatos.length];

        for (int nivel=fin; nivel>0 && posible; nivel-- ) {
            long numPatosNivel = nivelDesdeArriba*nivelDesdeArriba;
            int color = colorNivel[nivel];
            if (numPatosUsados[color] + numPatosNivel > numPatos[color]) {
                //No se puede. Salir!
                posible = false;
            } else {
                //Sí se puede hacer el nivel, los apunto como usados
                numPatosUsados[color] += numPatosNivel;
            }
            nivelDesdeArriba++;
        }

        return posible;
    }

}