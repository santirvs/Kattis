package Others.Medium.Puntuacion_3_0_a_3_9._3_2;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * PROBLEMA: Fence Bowling
 * * PLANTEAMIENTO MATEMÁTICO:
 * 1. Definición de Ángulos y Geometría:
 * - El problema mide los ángulos respecto a la "normal" (la perpendicular a los rieles/paredes).
 * - El tiro inicial comienza en el centro de la pista y va hacia una pared con un ángulo inicial 'beta'.
 * - La distancia horizontal que recorre la bola desde el centro hasta la pared es W / 2.
 * - Usando trigonometría, la distancia longitudinal (a lo largo del largo de la pista, L) que
 * recorre la bola en este primer tramo antes de chocar es: y_0 = (W / 2) * tan(beta).
 * * 2. Comportamiento de los Rebotes:
 * - Cuando la bola choca con un ángulo alpha respecto a la normal, rebota con un ángulo:
 * alpha_nuevo = arctan(2 * tan(alpha))
 * - Esto implica una relación directa sobre las tangentes: tan(alpha_nuevo) = 2 * tan(alpha).
 * - Tras el primer impacto en la pared, el ángulo respecto a la normal cambia de 'beta' a:
 * alpha_1 = arctan(2 * tan(beta))  =>  tan(alpha_1) = 2 * tan(beta)
 * - En los rebotes subsecuentes (de una pared a la otra), la bola cruza el ancho completo de la pista (W).
 * - Por lo tanto, el avance longitudinal en el tramo 'i' es: y_i = W * tan(alpha_i).
 * - Por inducción, tras 'i' rebotes, la tangente del ángulo actual es: tan(alpha_i) = (2^i) * tan(beta).
 * * 3. Ecuación del Trayecto Completo:
 * Para un total de 'k' rebotes exactos:
 * - Tramo Inicial (del centro a la 1ra pared): Avanza longitudinalmente y_0 = (W / 2) * tan(beta).
 * - Tramos Intermedios (entre rebotes, hay k - 1 tramos completos): Cada uno avanza W * tan(alpha_i).
 * - Tramo Final (del último rebote 'k' al centro de la pista): Avanza longitudinalmente (W / 2) * tan(alpha_k).
 * * Sumando todas las distancias longitudinales, estas deben igualar exactamente al largo total de la pista L:
 * L = (W / 2)*tan(beta) + [ Suma desde i=1 hasta k-1 de (W * tan(alpha_i)) ] + (W / 2)*tan(alpha_k)
 * * Sustituyendo tan(alpha_i) = 2^i * tan(beta):
 * L = tan(beta) * [ (W / 2) + W * (2^1 + 2^2 + ... + 2^(k-1)) + (W / 2) * 2^k ]
 * L = tan(beta) * (W / 2) * [ 1 + 2 * (2^1 + 2^2 + ... + 2^(k-1)) + 2^k ]
 * * Utilizando la identidad de la progresión geométrica (2^1 + 2^2 + ... + 2^(k-1) = 2^k - 2):
 * L = tan(beta) * (W / 2) * [ 1 + 2 * (2^k - 2) + 2^k ]
 * L = tan(beta) * (W / 2) * [ 1 + 2^(k+1) - 4 + 2^k ]
 * L = tan(beta) * (W / 2) * [ 3 * 2^k - 3 ]
 * L = tan(beta) * (3 * W / 2) * (2^k - 1)
 * * 4. Despeje de Beta:
 * tan(beta) = L / [ (3 * W / 2) * (2^k - 1) ]
 * tan(beta) = (2 * L) / [ 3 * W * (2^k - 1) ]
 * beta = arctan( (2 * L) / [ 3 * W * (2^k - 1) ] )
 * * Finalmente, convertimos 'beta' de radianes a grados para dar la respuesta requerida.
 */
public class FenceBowling {
    public static void main(String[] args) throws Exception {
        // Lectura rápida de datos mediante BufferedReader y StringTokenizer
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) {
            return;
        }

        StringTokenizer st = new StringTokenizer(line);
        int k = Integer.parseInt(st.nextToken());
        double w = Double.parseDouble(st.nextToken());
        double l = Double.parseDouble(st.nextToken());

        // 1. Calculamos la potencia (2^k).
        // Como k puede ser hasta 20, cabe perfectamente en un tipo double o long sin desbordamiento.
        double pow2k = Math.pow(2, k);

        // 2. Aplicamos la fórmula matemática despejada para obtener tan(beta)
        // tan(beta) = (2 * L) / (3 * W * (2^k - 1))
        double denominator = 3.0 * w * (pow2k - 1.0);
        double tanBeta = (2.0 * l) / denominator;

        // 3. Obtenemos el ángulo beta en radianes aplicando el arcotangente (atan)
        double betaRadians = Math.atan(tanBeta);

        // 4. Convertimos el resultado a grados sexagesimales
        double betaDegrees = Math.toDegrees(betaRadians);

        // 5. Imprimimos el ángulo final con alta precisión
        System.out.println(betaDegrees);
    }
}