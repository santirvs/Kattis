package Others.Easy.Puntuacion_2_0_a_2_9._2_0;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EvilJudges {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Leer la cadena S
        String s = readNextToken(br);
        if (s == null) {
            return;
        }

        // Leer el numero maximo de intercambios K.
        // Se usa long porque K puede ser grande (ej. 10^9 o mas en problemas de este tipo).
        String kToken = readNextToken(br);
        if (kToken == null) {
            return;
        }
        long k = Long.parseLong(kToken);

        /*
         * PLANTEAMIENTO:
         * 1. Solo interesan las parejas (i, j) con i < j donde s[i] == 'A' y s[j] es 'C' o 'K'.
         *    Las parejas formadas por 'C' y 'K' no son subsecuencias "AC" ni "AK", por lo que
         *    intercambiar 'C' y 'K' no cambia el costo.
         *
         * 2. Recorremos la cadena de derecha a izquierda llevando la cuenta de cuantos caracteres
         *    'C' y 'K' hemos visto hasta el momento (a la derecha de la posicion actual).
         *    Cada vez que encontramos una 'A', forma exactamente 'countCK' subsecuencias prohibidas
         *    ("AC" o "AK") con los caracteres 'C' y 'K' que estan a su derecha.
         */
        long initialCost = 0L; // Numero inicial de subsecuencias "AC" y "AK"
        long countCK = 0L;     // Cantidad de caracteres 'C' o 'K' vistos a la derecha

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == 'C' || ch == 'K') {
                countCK++;
            } else if (ch == 'A') {
                initialCost += countCK;
            }
        }

        /*
         * 3. Efecto de los intercambios adyacentes:
         *    - Si intercambiamos 'A' seguida de 'C' o 'K' ("AC" -> "CA" o "AK" -> "KA"),
         *      la 'A' avanza una posicion a la derecha y deja de formar subsecuencia con ese
         *      caracter, reduciendo el total en exactamente 1.
         *    - Hacer lo contrario (mover 'A' a la izquierda sobre 'C' o 'K') aumentaria el total en 1,
         *      lo cual nunca conviene para minimizar.
         *
         * 4. Por tanto, cada intercambio util reduce el costo en 1. Con hasta K intercambios,
         *    podemos reducir el costo como maximo en K unidades, sin bajar nunca de 0.
         */
        long minSubsequences = initialCost - k;
        if (minSubsequences < 0L) {
            minSubsequences = 0L;
        }

        System.out.println(minSubsequences);
    }

    // Lee el siguiente token ignorando lineas vacias o espacios extra
    private static String readNextToken(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            if (st.hasMoreTokens()) {
                return st.nextToken();
            }
        }
        return null;
    }
}