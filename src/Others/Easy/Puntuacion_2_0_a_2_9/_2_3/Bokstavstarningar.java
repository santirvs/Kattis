package Others.Easy.Puntuacion_2_0_a_2_9._2_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Bokstavstarningar {

    private static int N;
    private static int S;
    private static int W;
    private static String[] dados;

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            if (line == null) return;

            StringTokenizer st = new StringTokenizer(line);
            N = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            // Leer las caras de los N dados
            dados = new String[N];
            for (int i = 0; i < N; i++) {
                dados[i] = br.readLine().trim();
            }

            int palabrasValidas = 0;

            // Procesar cada una de las W palabras
            for (int i = 0; i < W; i++) {
                String palabra = br.readLine().trim();

                // Arreglo booleano para rastrear qué dados ya han sido asignados
                boolean[] dadosUsados = new boolean[N];

                // Si la palabra se puede formar, aumentamos el contador
                if (puedeFormarPalabra(palabra, 0, dadosUsados)) {
                    palabrasValidas++;
                }
            }

            // Imprimir el resultado final
            System.out.println(palabrasValidas);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Función recursiva de backtracking para emparejar letras con dados.
     * * @param palabra La palabra que estamos evaluando.
     * @param indiceLetra La posición actual de la letra en la palabra que queremos emparejar.
     * @param dadosUsados Arreglo para marcar qué dados ya están ocupados.
     * @return true si se logra asignar un dado único a cada letra, false en caso contrario.
     */
    private static boolean puedeFormarPalabra(String palabra, int indiceLetra, boolean[] dadosUsados) {
        // Caso base: Si ya logramos posicionar todas las letras con éxito
        if (indiceLetra == N) {
            return true;
        }

        char letraActual = palabra.charAt(indiceLetra);

        // Intentar asignar la letra actual a cualquiera de los dados disponibles
        for (int j = 0; j < N; j++) {
            // El dado 'j' no debe estar usado y debe contener la letra buscada
            if (!dadosUsados[j] && dadosiContieneLetra(dados[j], letraActual)) {

                // Marcar el dado como usado (Paso hacia adelante)
                dadosUsados[j] = true;

                // Intentar resolver de forma recursiva la siguiente letra
                if (puedeFormarPalabra(palabra, indiceLetra + 1, dadosUsados)) {
                    return true; // Si todo el camino fue exitoso, propagamos el true
                }

                // Desmarcar el dado (Backtracking) para probar otras combinaciones si falló
                dadosUsados[j] = false;
            }
        }

        // Si se probaron todos los dados para esta letra y ninguno sirvió
        return false;
    }

    /**
     * Método auxiliar para verificar si un dado contiene una letra específica.
     */
    private static boolean dadosiContieneLetra(String dado, char letra) {
        return dado.indexOf(letra) != -1;
    }
}