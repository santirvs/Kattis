package Others.Medium.Puntuacion_2_0_a_2_9._2_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

public class CurvyLittleBottles {

    public static void main(String[] args) throws IOException {
        // Fast I/O para manejar múltiples casos de prueba eficientemente
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int caseNum = 1;

        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) continue;

            // 1. Leer el grado del polinomio
            int n = Integer.parseInt(line.trim());

            // 2. Leer los coeficientes del polinomio P(x)
            double[] a = new double[n + 1];
            line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            for (int i = 0; i <= n; i++) {
                a[i] = Double.parseDouble(st.nextToken());
            }

            // 3. Leer x0, x1 e incVol
            line = br.readLine();
            st = new StringTokenizer(line);
            double x0 = Double.parseDouble(st.nextToken());
            double x1 = Double.parseDouble(st.nextToken());
            double incVol = Double.parseDouble(st.nextToken());

            // --- PLANTEAMIENTO MATEMÁTICO: ELEVAR AL CUADRADO ---
            // Si P(x) tiene grado n, Q(x) = [P(x)]^2 tendrá un grado máximo de 2n.
            double[] b = new double[2 * n + 1];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    b[i + j] += a[i] * a[j];
                }
            }

            // --- PLANTEAMIENTO MATEMÁTICO: INTEGRACIÓN ANALÍTICA ---
            // La integral de x^k es (x^(k+1)) / (k+1). Multiplicamos todo por PI.
            // Guardamos los coeficientes de la antiderivada. El término k ahora acompaña a x^(k+1).
            double[] integralCoefs = new double[2 * n + 2];
            for (int k = 0; k <= 2 * n; k++) {
                integralCoefs[k + 1] = (b[k] / (k + 1)) * Math.PI;
            }

            // El volumen total de la botella es la integral evaluada en x1 menos evaluada en x0
            double volTotal = evaluarIntegral(integralCoefs, x1) - evaluarIntegral(integralCoefs, x0);

            // Imprimir encabezado del caso
            System.out.printf(Locale.UK, "Case %d: %.2f\n", caseNum++, volTotal);

            // --- PLANTEAMIENTO ALGORÍTMICO: BÚSQUEDA BINARIA ---
            // Si el volumen total ni siquiera llega al incremento mínimo requerido, es insuficiente.
            if (volTotal < incVol) {
                System.out.println("insufficient volume");
            } else {
                List<Double> marcas = new ArrayList<Double>();
                double volObjetivo = incVol;

                // El problema restringe a un máximo de 8 marcas consecutivas
                while (volObjetivo <= volTotal && marcas.size() < 8) {
                    double low = x0;
                    double high = x1;

                    // 60 iteraciones de búsqueda binaria garantizan una precisión de ~10^-18,
                    // lo cual es sumamente superior al margen de error exigido.
                    for (int iter = 0; iter < 60; iter++) {
                        double mid = (low + high) / 2.0;
                        double volActual = evaluarIntegral(integralCoefs, mid) - evaluarIntegral(integralCoefs, x0);

                        if (volActual < volObjetivo) {
                            low = mid; // Falta líquido, subimos el límite inferior
                        } else {
                            high = mid; // Nos pasamos, bajamos el límite superior
                        }
                    }

                    // La altura requerida es la distancia desde el fondo (mid - x0)
                    marcas.add(low - x0);
                    volObjetivo += incVol; // Siguiente marca (2 * incVol, 3 * incVol, etc.)
                }

                // Imprimir las marcas separadas exactamente por un espacio
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < marcas.size(); i++) {
                    if (i > 0) sb.append(" ");
                    sb.append(String.format(Locale.UK, "%.2f", marcas.get(i)));
                }
                System.out.println(sb.toString());
            }
        }
    }

    /**
     * Evalúa el polinomio de la integral usando el método de Horner para mayor precisión
     * y velocidad, evitando el uso repetitivo de Math.pow().
     */
    private static double evaluarIntegral(double[] coefs, double x) {
        double resultado = 0.0;
        // El arreglo de coeficientes tiene tamaño 2n + 2.
        // Evaluamos de atrás hacia adelante: coefs[m]*x^m + coefs[m-1]*x^(m-1)...
        for (int i = coefs.length - 1; i >= 0; i--) {
            resultado = resultado * x + coefs[i];
        }
        return resultado;
    }
}