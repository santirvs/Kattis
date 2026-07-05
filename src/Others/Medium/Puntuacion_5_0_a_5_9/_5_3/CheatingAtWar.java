package Others.Medium.Puntuacion_5_0_a_5_9._5_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

    public class CheatingAtWar {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            if (line == null) return;

            int numCasos = Integer.parseInt(line.trim());

            while (numCasos-- > 0) {
                String oponenteStr = br.readLine();
                String miasStr = br.readLine();

                if (oponenteStr == null || miasStr == null) break;

                oponenteStr = oponenteStr.trim();
                miasStr = miasStr.trim();

                int[] oponenteCartas = new int[26];
                int[] miasCartas = new int[26];

                for (int i = 0; i < 26; i++) {
                    oponenteCartas[i] = obtenerValorNumerico(oponenteStr.charAt(i));
                    miasCartas[i] = obtenerValorNumerico(miasStr.charAt(i));
                }

                // Ordenamos ambos mazos de menor a mayor
                Arrays.sort(oponenteCartas);
                Arrays.sort(miasCartas);

                int numCartasGanadas = 0;

                // Punteros de los extremos
                int miMin = 0, miMax = 25;
                int opMin = 0, opMax = 25;

                // Procesamos hasta que se agoten las 26 cartas
                while (miMin <= miMax) {
                    if (miasCartas[miMin] > oponenteCartas[opMin]) {
                        // 1. Nuestra peor gana a su peor -> Aseguramos victoria barata
                        numCartasGanadas += 2;
                        miMin++;
                        opMin++;
                    } else if (miasCartas[miMax] > oponenteCartas[opMax]) {
                        // 2. Nuestra mejor gana a su mejor -> Aseguramos victoria alta
                        numCartasGanadas += 2;
                        miMax--;
                        opMax--;
                    } else {
                        // 3. No podemos ganar en los extremos de forma limpia.
                        // Evaluamos si nuestra peor carta empata con su mejor carta.
                        if (miasCartas[miMin] == oponenteCartas[opMax]) {
                            numCartasGanadas += 1;
                        }
                        // Sacrificamos/usamos nuestra peor carta contra su mejor carta
                        miMin++;
                        opMax--;
                    }
                }

                System.out.println(numCartasGanadas);
            }
        }

        private static int obtenerValorNumerico(char c) {
            if (c >= '2' && c <= '9') {
                return c - '0';
            }
            switch (c) {
                case 'T': return 10;
                case 'J': return 11;
                case 'Q': return 12;
                case 'K': return 13;
                case 'A': return 14;
                default: return 0;
            }
        }
    }