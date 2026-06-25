package Others.Medium.Puntuacion_3_0_a_3_9._3_2;

import java.util.Comparator;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.Scanner;

public class WeatherReport {

    // Clase para representar un grupo de nodos en el árbol de Huffman
    static class HuffmanNode {
        double prob;   // Probabilidad de cada secuencia en este grupo
        long count;    // Cuántas secuencias independientes tienen esta misma probabilidad

        public HuffmanNode(double prob, long count) {
            this.prob = prob;
            this.count = count;
        }
    }

    // Tabla de factoriales precalculada para el coeficiente multinomial (N <= 20)
    private static final long[] Fact = new long[21];
    static {
        Fact[0] = 1;
        for (int i = 1; i <= 20; i++) {
            Fact[i] = Fact[i - 1] * i;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);
        if (!sc.hasNextInt()) return;

        int N = sc.nextInt();
        double[] p = new double[4];
        for (int i = 0; i < 4; i++) {
            p[i] = sc.nextDouble();
        }

        // Cola de prioridad ordenada de MENOR a MAYOR probabilidad (Min-Heap)
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<HuffmanNode>(11, new Comparator<HuffmanNode>() {
            @Override
            public int compare(HuffmanNode n1, HuffmanNode n2) {
                return Double.compare(n1.prob, n2.prob);
            }
        });

        // --- FASE 1: Generar combinaciones mediante bucles anidados ---
        for (int c1 = 0; c1 <= N; c1++) {
            for (int c2 = 0; c2 <= N - c1; c2++) {
                for (int c3 = 0; c3 <= N - c1 - c2; c3++) {
                    int c4 = N - c1 - c2 - c3;

                    // Calcular la probabilidad de una única secuencia con esta distribución
                    double seqProb = Math.pow(p[0], c1) * Math.pow(p[1], c2)
                            * Math.pow(p[2], c3) * Math.pow(p[3], c4);

                    // Coeficiente multinomial: N! / (c1! * c2! * c3! * c4!)
                    long seqCount = Fact[N] / (Fact[c1] * Fact[c2] * Fact[c3] * Fact[c4]);

                    if (seqCount > 0 && seqProb > 0) {
                        pq.add(new HuffmanNode(seqProb, seqCount));
                    }
                }
            }
        }

        // --- FASE 2: Simulación del Algoritmo de Huffman a gran escala ---
        double totalExpectedBits = 0.0;

        // Continuamos hasta que solo quede un único nodo raíz de conteo 1
        while (true) {
            HuffmanNode curr = pq.poll();

            // Si el nodo extraído tiene count == 1 y la cola está vacía, terminamos
            if (curr.count == 1 && pq.isEmpty()) {
                break;
            }

            // Caso A: Tenemos más de un nodo con esta misma probabilidad exacta
            if (curr.count > 1) {
                long pairs = curr.count / 2;
                double parentProb = curr.prob * 2;

                // Cada pareja genera un bit por cada elemento combinado
                totalExpectedBits += (parentProb * pairs);

                // Añadimos los nuevos nodos padres a la cola
                pq.add(new HuffmanNode(parentProb, pairs));

                // Si era impar, nos sobra 1 nodo que debemos emparejar con el siguiente más cercano
                if (curr.count % 2 != 0) {
                    HuffmanNode next = pq.poll();
                    double combinedProb = curr.prob + next.prob;

                    totalExpectedBits += combinedProb;
                    pq.add(new HuffmanNode(combinedProb, 1));

                    // Si al 'next' le quedaban más elementos individuales, los devolvemos a la cola
                    if (next.count > 1) {
                        pq.add(new HuffmanNode(next.prob, next.count - 1));
                    }
                }
            }
            // Caso B: El nodo es único (count == 1), obligatoriamente lo unimos con el que le sigue
            else {
                HuffmanNode next = pq.poll();
                double combinedProb = curr.prob + next.prob;

                totalExpectedBits += combinedProb;
                pq.add(new HuffmanNode(combinedProb, 1));

                if (next.count > 1) {
                    pq.add(new HuffmanNode(next.prob, next.count - 1));
                }
            }
        }

        // Imprimir el costo total esperado con la precisión requerida
        System.out.printf(java.util.Locale.UK, "%.6f\n", totalExpectedBits);
        sc.close();
    }
}