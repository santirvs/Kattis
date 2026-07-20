package Others.Hard.Puntuacion_9_0_a_9_9._9_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class SheepPen {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());

        int[] seg = new int[n];
        for (int i = 0; i < n; i++) {
            seg[i] = Integer.parseInt(st.nextToken());
        }

        if (n < 3) {
            System.out.println("0");
            return;
        }

        Arrays.sort(seg);

        double maxAreaGlobal = 0.0;

        // Probar cada elemento desde el índice 2 hasta n-1 como el lado más largo (lMax)
        for (int i = 2; i < n; i++) {
            double lMax = seg[i];

            // Construimos la lista con el candidato a lMax y TODOS los elementos menores o iguales a él (de 0 a i)
            List<Double> ladosList = new ArrayList<Double>();
            for (int j = 0; j <= i; j++) {
                ladosList.add((double) seg[j]);
            }

            // Si el lado más largo es menor que la suma de todos los demás, es un polígono válido
            double area = calcularAreaSubconjunto(ladosList);
            if (area > maxAreaGlobal) {
                maxAreaGlobal = area;
            }
        }

        if (maxAreaGlobal <= 0.0) {
            System.out.println("0");
        } else {
            System.out.printf("%.3f%n", maxAreaGlobal);
        }
    }

    private static double calcularAreaSubconjunto(List<Double> ladosList) {
        int k = ladosList.size();
        if (k < 3) return 0.0;

        double[] lados = new double[k];
        double suma = 0;
        double lMax = 0;
        int idxMax = -1;

        for (int i = 0; i < k; i++) {
            lados[i] = ladosList.get(i);
            suma += lados[i];
            if (lados[i] > lMax) {
                lMax = lados[i];
                idxMax = i;
            }
        }

        // Condición necesaria: el lado mayor debe ser menor que la suma de los demás
        if (lMax >= suma - lMax) return 0.0;

        // Verificar si el centro del círculo circunscrito queda DENTRO o FUERA del polígono
        double sumaOtrosAngulosRmin = 0;
        for (int i = 0; i < k; i++) {
            if (i == idxMax) continue;
            double val = Math.min(1.0, lados[i] / lMax);
            sumaOtrosAngulosRmin += 2.0 * Math.asin(val);
        }

        boolean centroDentro = sumaOtrosAngulosRmin > Math.PI;
        double areaTotal = 0;

        if (centroDentro) {
            // CASO 1: Centro DENTRO del polígono
            double low = lMax / 2.0;
            double high = 1e7;

            for (int iter = 0; iter < 60; iter++) {
                double mid = low + (high - low) / 2.0;
                if (calcularAnguloTotal(lados, mid) > 2 * Math.PI) {
                    low = mid;
                } else {
                    high = mid;
                }
            }

            double R = low;
            for (int i = 0; i < k; i++) {
                double h = Math.sqrt(Math.max(0, R * R - (lados[i] / 2.0) * (lados[i] / 2.0)));
                areaTotal += 0.5 * lados[i] * h;
            }
        } else {
            // CASO 2: Centro FUERA del polígono
            double low = lMax / 2.0;
            double high = 1e7;

            for (int iter = 0; iter < 60; iter++) {
                double mid = low + (high - low) / 2.0;
                if (diferenciaAngulosCentroFuera(lados, idxMax, mid) > 0) {
                    low = mid;
                } else {
                    high = mid;
                }
            }

            double R = low;
            for (int i = 0; i < k; i++) {
                double h = Math.sqrt(Math.max(0, R * R - (lados[i] / 2.0) * (lados[i] / 2.0)));
                if (i == idxMax) {
                    areaTotal -= 0.5 * lados[i] * h; // Se resta el triángulo del lado mayor
                } else {
                    areaTotal += 0.5 * lados[i] * h;
                }
            }
        }

        return areaTotal;
    }

    private static double calcularAnguloTotal(double[] lados, double R) {
        double anguloTotal = 0;
        for (double s : lados) {
            double val = Math.min(1.0, s / (2.0 * R));
            anguloTotal += 2.0 * Math.asin(val);
        }
        return anguloTotal;
    }

    private static double diferenciaAngulosCentroFuera(double[] lados, int idxMax, double R) {
        double anguloMax = 2.0 * Math.asin(Math.min(1.0, lados[idxMax] / (2.0 * R)));
        double sumaOtros = 0;
        for (int i = 0; i < lados.length; i++) {
            if (i == idxMax) continue;
            sumaOtros += 2.0 * Math.asin(Math.min(1.0, lados[i] / (2.0 * R)));
        }
        return anguloMax - sumaOtros;
    }
}