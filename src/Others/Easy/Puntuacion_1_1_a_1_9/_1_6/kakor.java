package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

public class kakor {


    public static long cookies(int n, int[] a) {
        long resultado=0;
        for (int i=0; i<n; i++) {
            resultado += a[i];
        }

        return resultado;

    }

    }