package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Sumar el contenido de un vector de tamaño N
 */


import java.io.*;

public class Cookies {

    public static void main(String... args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter w = new PrintWriter(new BufferedOutputStream(System.out));

        int N = Integer.parseInt(r.readLine());
        String[] aStr = r.readLine().split(" ");


        int[] A = new int[N];
        for (int i = 0; i < N; ++i) {
            A[i] = Integer.parseInt(aStr[i]);
        }


        w.println(kakor.cookies(N, A));
        w.close();
    }


}
