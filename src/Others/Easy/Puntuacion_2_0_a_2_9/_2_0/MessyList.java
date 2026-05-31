package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

/**
 * v1 : Ordenar la lista, compararla con la original posición a posición y
 *      contar los elementos que no coincidan
 *
 *  v2: TLE! Ojo que hay hasta 10^6 enteros  --> FastReader
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class MessyList {

    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in).useLocale(Locale.UK);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //Leer los datos
        //int tamany = sc.nextInt();
        String line = br.readLine();
        int tamany = Integer.parseInt(line.trim());

        int[] listaOriginal = new int[tamany];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<tamany; i++) {
            listaOriginal[i] = Integer.parseInt(st.nextToken());
        }

        int[] listaOrdenada = listaOriginal.clone();
        Arrays.sort(listaOrdenada);

        int diferencias = 0;
        for (int i=0; i<tamany; i++) {
            if (listaOriginal[i] != listaOrdenada[i]) diferencias++;
        }

        System.out.println(diferencias);

        //sc.close();
    }
}

