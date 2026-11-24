package Others.Easy.Puntuacion_2_0_a_2_9._2_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ServerCorridor {

    public static void main(String[] args) throws IOException {
        // Lectura rápida de entrada estándar
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String lineN = br.readLine();
        if (lineN == null || lineN.trim().isEmpty()) return;

        int N = Integer.parseInt(lineN.trim());
        String s = br.readLine().trim();

        // Convertimos la cadena a un arreglo de caracteres mutable para registrar
        // en tiempo real los servidores que vamos encendiendo ('1' -> '2').
        char[] corridor = s.toCharArray();

        /* =========================================================================
         * PLANTEAMIENTO Y ESTRATEGIA VORAZ (GREEDY):
         *
         * 1. Estados de cada sección:
         *    - '0': Vacío (aislante, no genera ni propaga calor).
         *    - '1': Servidor apagado (candidato).
         *    - '2': Servidor encendido (bloquea sus secciones adyacentes i-1 e i+1).
         *
         * 2. Regla de Elección Local Óptima:
         *    Recorremos el pasillo de izquierda a derecha (i = 0 hasta N - 1).
         *    Siempre que encontremos un servidor apagado ('1'), lo encendemos ('2')
         *    inmediatamente si sus dos vecinos directos (i-1 e i+1) no están encendidos.
         *
         * 3. Justificación de Optimalidad:
         *    Encender un servidor lo más a la izquierda posible solo compromete la
         *    siguiente posición (i + 1) hacia la derecha, dejando la máxima cantidad
         *    de espacio libre para futuras decisiones en [i + 2 ... N - 1].
         * =========================================================================
         */

        int additionalServers = 0;

        for (int i = 0; i < N; i++) {
            // Solo evaluamos secciones que tienen un servidor apagado
            if (corridor[i] == '1') {
                // Verificar si el vecino izquierdo está encendido
                boolean leftOn = (i > 0) && (corridor[i - 1] == '2');

                // Verificar si el vecino derecho está encendido
                boolean rightOn = (i + 1 < N) && (corridor[i + 1] == '2');

                // Si ningún vecino está encendido, es seguro encender el servidor actual
                if (!leftOn && !rightOn) {
                    corridor[i] = '2'; // Marcamos como encendido para que afecte a i + 1
                    additionalServers++;
                }
            }
        }

        // Imprimir el máximo número de servidores adicionales encendidos
        System.out.println(additionalServers);
    }
}