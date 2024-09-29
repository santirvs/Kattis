package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._3_TablasDireccionamientoDirecto_Otros;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;



//***   PENDIENTE DE ANALIZAR   ***//
//*** Copiado de https://github.com/RussellDash332/kattis/blob/main/src/Floppy%20Music/floppy.py
//*** Y trducido a Java con ChatGPT  --> AC a la primera!


public class FloppyMusic {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCases; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int[] c = new int[T + 1];
            for (int i = 0; i <= T; i++) {
                c[i] = 1; // inicializando el array 'c' con 1's
            }

            for (int n = 0; n < N; n++) {
                int[] d = new int[T + 1]; // nuevo array 'd' inicializado con 0's
                st = new StringTokenizer(br.readLine());
                int t1 = Integer.parseInt(st.nextToken());
                int t2 = Integer.parseInt(st.nextToken());
                int v = t2 - t1;

                for (int i = 0; i <= T; i++) {
                    if (c[i] == 1) {
                        if (i >= v) {
                            d[i - v] = 1;
                        }
                        if (i <= T - v) {
                            d[i + v] = 1;
                        }
                    }
                }
                c = d;
            }

            boolean possible = false;
            for (int i = 0; i <= T; i++) {
                if (c[i] == 1) {
                    possible = true;
                    break;
                }
            }

            if (!possible) {
                System.out.println("impossible");
                return; // finaliza el programa si es imposible
            }
        }
        System.out.println("possible");
    }
}
