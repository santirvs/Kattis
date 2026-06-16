package Others.Easy.Puntuacion_2_0_a_2_9._2_7;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * PROBLEMA: Smart Phone
 * * PLANTEAMIENTO EN COMENTARIOS:
 * 1. El problema nos pide encontrar el mínimo número de pulsaciones ('keypresses')
 * para transformar la cadena actual (Current) en la cadena objetivo (Target).
 * 2. Disponemos de 4 caminos posibles para llegar al objetivo:
 * - Camino 0: Modificar la palabra actual directamente usando solo borrar (backspace)
 * y escribir letras.
 * - Camino 1, 2 y 3: Presionar una de las 3 sugerencias (gasta 1 pulsación) y luego
 * modificarla con borrar y escribir letras hasta llegar a Target.
 * 3. Para calcular el costo de transformar de forma manual una palabra 'X' en una 'Y':
 * - Encontramos el Prefijo Común Más Largo (LCP) entre ambas.
 * - Las letras que no coinciden en 'X' después del LCP deben ser borradas.
 * Costo borrado = longitud(X) - longitud(LCP).
 * - Las letras restantes para formar 'Y' deben ser escritas de forma manual.
 * Costo escritura = longitud(Y) - longitud(LCP).
 * - Costo Total (X -> Y) = longitud(X) + longitud(Y) - 2 * longitud(LCP).
 * 4. Al final, el programa evalúa los 4 caminos y se queda con el valor mínimo.
 */
public class SmartPhone {
    public static void main(String[] args) throws Exception {
        // Usamos BufferedReader para una lectura rápida, compatible con Java 1.7
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) {
            return;
        }

        // Leemos la cantidad de casos de prueba
        int t = Integer.parseInt(line.trim());

        for (int i = 0; i < t; i++) {
            String target = br.readLine().trim();
            String current = br.readLine().trim();
            String s1 = br.readLine().trim();
            String s2 = br.readLine().trim();
            String s3 = br.readLine().trim();

            // CAMINO 0: Ir directo desde lo que ya está escrito sin usar sugerencias
            long costDirect = getEditCost(current, target);

            // CAMINO 1: Seleccionar Sugerencia 1 (1 pulsación) + editar hacia el Target
            long costS1 = 1 + getEditCost(s1, target);

            // CAMINO 2: Seleccionar Sugerencia 2 (1 pulsación) + editar hacia el Target
            long costS2 = 1 + getEditCost(s2, target);

            // CAMINO 3: Seleccionar Sugerencia 3 (1 pulsación) + editar hacia el Target
            long costS3 = 1 + getEditCost(s3, target);

            // Encontramos el mínimo absoluto entre todas las estrategias disponibles
            long minKeypresses = Math.min(costDirect, Math.min(costS1, Math.min(costS2, costS3)));

            // Imprimimos el resultado del caso de prueba actual
            System.out.println(minKeypresses);
        }
    }

    /**
     * Calcula el costo de transformar manualmente la palabra 'origin' en la palabra 'dest'.
     * Aplica la fórmula: longitud(origin) + longitud(dest) - 2 * longitud(LCP)
     */
    private static long getEditCost(String origin, String dest) {
        int lcpLength = getLCP(origin, dest);
        return origin.length() + dest.length() - (2 * lcpLength);
    }

    /**
     * Encuentra la longitud del Prefijo Común Más Largo (LCP) entre dos cadenas.
     * Recorre ambas cadenas carácter por carácter desde el inicio hasta encontrar una diferencia.
     */
    private static int getLCP(String s1, String s2) {
        int minLength = Math.min(s1.length(), s2.length());
        int lcp = 0;

        while (lcp < minLength && s1.charAt(lcp) == s2.charAt(lcp)) {
            lcp++;
        }

        return lcp;
    }
}
