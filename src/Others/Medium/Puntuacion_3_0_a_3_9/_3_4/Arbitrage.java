package Others.Medium.Puntuacion_3_0_a_3_9._3_4;

//Ver Arbitrage.md

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Arbitrage {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // El programa corre de forma continua hasta leer un 0
        while (scan.hasNextInt()) {
            int n = scan.nextInt();
            if (n == 0) {
                break;
            }

            // Mapa para asignar a cada código de moneda de 3 letras un ID numérico (0 a N-1)
            Map<String, Integer> monedaId = new HashMap<String, Integer>();
            for (int i = 0; i < n; i++) {
                String codigo = scan.next().trim();
                monedaId.put(codigo, i);
            }

            int m = scan.nextInt();

            // Matriz de adyacencia para distancias mínimas
            double[][] dist = new double[n][n];

            // Inicializar la matriz con infinito positivo
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        dist[i][j] = 0.0; // La distancia de un nodo a sí mismo empieza en 0
                    } else {
                        dist[i][j] = Double.POSITIVE_INFINITY;
                    }
                }
            }

            // Leer las tasas de cambio y llenar la matriz
            for (int i = 0; i < m; i++) {
                String desde = scan.next().trim();
                String hasta = scan.next().trim();
                String ratioStr = scan.next().trim();

                // Separar los dos enteros del formato "A:B"
                String[] partes = ratioStr.split(":");
                int a = Integer.parseInt(partes[0]);
                int b = Integer.parseInt(partes[1]);

                int u = monedaId.get(desde);
                int v = monedaId.get(hasta);

                // Aplicamos el logaritmo negativo: W = -ln(B / A)
                double peso = -Math.log((double) b / a);

                // Si hay múltiples tasas para el mismo par de monedas, nos quedamos con la menor (más óptima)
                if (peso < dist[u][v]) {
                    dist[u][v] = peso;
                }
            }

            // Algoritmo de Floyd-Warshall para encontrar los caminos mínimos entre todos los pares
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (dist[i][k] < Double.POSITIVE_INFINITY && dist[k][j] < Double.POSITIVE_INFINITY) {
                            if (dist[i][k] + dist[k][j] < dist[i][j]) {
                                dist[i][j] = dist[i][k] + dist[k][j];
                            }
                        }
                    }
                }
            }

            // Verificar si existe arbitraje (un ciclo negativo)
            boolean existeArbitraje = false;
            for (int i = 0; i < n; i++) {
                // Si la distancia de una moneda a sí misma es menor que 0, encontramos un ciclo de ganancia
                if (dist[i][i] < -1e-9) { // Usamos una pequeña tolerancia para evitar errores de precisión de punto flotante
                    existeArbitraje = true;
                    break;
                }
            }

            // Imprimir el resultado correspondiente
            if (existeArbitraje) {
                System.out.println("Arbitrage");
            } else {
                System.out.println("Ok");
            }
        }
        scan.close();
    }
}