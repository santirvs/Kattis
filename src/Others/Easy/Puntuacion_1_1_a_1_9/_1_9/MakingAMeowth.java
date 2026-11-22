package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

/**
 * Leer los datos
 *  N -> cada cuantas páginas leerá Meowth
 *  P -> cantidad de páginas a leer
 *  X -> tiempo que tardo en leer yo
 *  Y -> tiempo que tarda en leer Meowth
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MakingAMeowth {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = null;

        String line = br.readLine();
        while (line != null) {
            st = new StringTokenizer(line);
            if (st.hasMoreTokens()) {
                long n = Long.parseLong(st.nextToken());
                long m = Long.parseLong(st.nextToken());
                long x = Long.parseLong(st.nextToken());
                long y = Long.parseLong(st.nextToken());

                long myTime = m * x;   // tiempo que paso leyendo yo
                long meowthPages = (n > 1) ? (m / (n - 1)) : m;  //Páginas que leerá Meowth
                long meowthTime = meowthPages * y;  // tiempo que pasa leyendo Meowth

                out.println(myTime + meowthTime);
            }
            line = br.readLine();
        }

        out.flush();
    }
}