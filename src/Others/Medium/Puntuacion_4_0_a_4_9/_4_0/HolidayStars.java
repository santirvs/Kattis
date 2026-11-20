package Others.Medium.Puntuacion_4_0_a_4_9._4_0;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * Versión optimizada de "Holiday Stars" para Java 1.7 (evitando TLE en casos grandes):
 *
 * Optimizaciones clave frente a la versión ingenua:
 * 1. Se calculan cos(omega * t) y sin(omega * t) UNA sola vez por instante t (fuera del bucle de vértices).
 * 2. Se reutiliza fPrev[i] de un instante al siguiente en vez de evaluar ambos extremos en cada paso.
 * 3. Si vxVel > 0, ningún vértice puede alcanzar wallX antes de que (cx + vxVel * t + maxRadius) llegue a wallX,
 *    por lo que podemos iniciar la búsqueda cerca de ese instante (con un pequeño margen de seguridad).
 * 4. Se limita el número total de pasos de muestreo para garantizar tiempo de ejecución rápido incluso
 *    si la distancia o el tiempo de vuelo son grandes.
 */
public class HolidayStars {

    private static final int BISECTION_STEPS = 70;
    private static final int MAX_STEPS = 500000;
    private static final double EPS = 1e-12;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = readNextNonEmptyLine(br);
        if (firstLine == null) {
            return;
        }

        StringTokenizer st = new StringTokenizer(firstLine);
        int n = Integer.parseInt(st.nextToken());
        double omega = Double.parseDouble(st.nextToken());
        double v0 = Double.parseDouble(st.nextToken());
        int angleDeg = Integer.parseInt(st.nextToken());
        double wallX = Double.parseDouble(st.nextToken());

        double[] vxInit = new double[n];
        double[] vyInit = new double[n];

        for (int i = 0; i < n; i++) {
            String line = readNextNonEmptyLine(br);
            StringTokenizer vSt = new StringTokenizer(line);
            vxInit[i] = Double.parseDouble(vSt.nextToken());
            vyInit[i] = Double.parseDouble(vSt.nextToken());
        }

        // Cálculo del área con signo y centroide (cx, cy) del polígono
        double twiceArea = 0.0;
        double sumCx = 0.0;
        double sumCy = 0.0;

        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n;
            double cross = vxInit[i] * vyInit[next] - vxInit[next] * vyInit[i];
            twiceArea += cross;
            sumCx += (vxInit[i] + vxInit[next]) * cross;
            sumCy += (vyInit[i] + vyInit[next]) * cross;
        }

        double area = 0.5 * twiceArea;
        double cx = sumCx / (6.0 * area);
        double cy = sumCy / (6.0 * area);

        // Vectores relativos al centroide y radio máximo del polígono
        double[] relX = new double[n];
        double[] relY = new double[n];
        double maxRadius = 0.0;

        for (int i = 0; i < n; i++) {
            relX[i] = vxInit[i] - cx;
            relY[i] = vyInit[i] - cy;
            double r = Math.hypot(relX[i], relY[i]);
            if (r > maxRadius) {
                maxRadius = r;
            }
        }

        double angleRad = Math.toRadians(angleDeg);
        double vxVel = v0 * Math.cos(angleRad);

        // Tiempo de inicio seguro: si vxVel > 0, el borde más adelantado posible (cx + vxVel*t + maxRadius)
        // no puede llegar a wallX antes de este tiempo (dejamos un margen por si omega es grande).
        double tStart = 0.0;
        if (vxVel > 1e-9) {
            double earliestPossible = (wallX - cx - maxRadius) / vxVel;
            double safetyMargin = (omega > 1e-9) ? (2.0 * Math.PI / omega) + 0.05 : 0.05;
            if (earliestPossible - safetyMargin > 0.0) {
                tStart = earliestPossible - safetyMargin;
            }
        }

        // Horizonte superior de búsqueda
        double tEnd;
        if (vxVel > 1e-9) {
            tEnd = Math.max(tStart + 1.0, ((wallX - cx + maxRadius) / vxVel) + 5.0);
        } else {
            tEnd = 1000.0;
        }

        // Paso temporal adaptado a la velocidad angular, acotado para evitar demasiados pasos
        double dt = 1e-3;
        if (omega > 1e-9) {
            double period = (2.0 * Math.PI) / omega;
            dt = Math.min(dt, period / 120.0);
        }
        double minDtByCap = (tEnd - tStart) / MAX_STEPS;
        if (dt < minDtByCap) {
            dt = minDtByCap;
        }
        if (dt <= 0.0) {
            dt = 1e-4;
        }

        int steps = (int) Math.ceil((tEnd - tStart) / dt);
        if (steps < 1) {
            steps = 1;
        } else if (steps > MAX_STEPS) {
            steps = MAX_STEPS;
        }
        dt = (tEnd - tStart) / steps;

        // Evaluamos en t = tStart una sola vez para cada vértice
        double[] fPrev = new double[n];
        double cosInit = Math.cos(omega * tStart);
        double sinInit = Math.sin(omega * tStart);
        double baseXInit = cx + vxVel * tStart;

        int bestVertex = -1;
        double bestTime = Double.POSITIVE_INFINITY;

        for (int i = 0; i < n; i++) {
            double xVal = baseXInit + (relX[i] * cosInit + relY[i] * sinInit);
            double fVal = xVal - wallX;
            fPrev[i] = fVal;

            if (Math.abs(fVal) <= EPS && tStart >= 0.0 && tStart < bestTime) {
                bestTime = tStart;
                bestVertex = i + 1;
            }
        }

        // Si ya hay impacto en tStart, terminamos directamente
        if (bestVertex != -1) {
            System.out.printf(Locale.US, "%d %.6f%n", bestVertex, bestTime);
            return;
        }

        // Recorremos los intervalos [t0, t1] reutilizando fPrev[i]
        double t0 = tStart;
        for (int s = 0; s < steps; s++) {
            double t1 = tStart + (s + 1) * dt;

            // Calculamos cos y sin una sola vez para t1
            double angleRot = omega * t1;
            double cosR = Math.cos(angleRot);
            double sinR = Math.sin(angleRot);
            double baseX1 = cx + vxVel * t1;

            for (int i = 0; i < n; i++) {
                double x1 = baseX1 + (relX[i] * cosR + relY[i] * sinR);
                double f1 = x1 - wallX;
                double f0 = fPrev[i];

                if (Math.abs(f1) <= EPS && t1 >= 0.0) {
                    if (t1 < bestTime) {
                        bestTime = t1;
                        bestVertex = i + 1;
                    }
                } else if ((f0 < 0.0 && f1 >= 0.0) || (f0 > 0.0 && f1 <= 0.0)) {
                    double rootTime = bisectRoot(i, t0, t1, f0, cx, vxVel, wallX, omega, relX[i], relY[i]);
                    if (rootTime >= 0.0 && rootTime < bestTime) {
                        bestTime = rootTime;
                        bestVertex = i + 1;
                    }
                }

                fPrev[i] = f1;
            }

            if (bestVertex != -1) {
                break;
            }

            t0 = t1;
        }

        if (bestVertex == -1) {
            bestVertex = 1;
            bestTime = 0.0;
        }

        System.out.printf(Locale.US, "%d %.6f%n", bestVertex, bestTime);
    }

    /**
     * Refina mediante bisección el instante t en [lo, hi] donde f_i(t) cambia de signo.
     */
    private static double bisectRoot(
            int idx,
            double lo,
            double hi,
            double fLo,
            double cx,
            double vxVel,
            double wallX,
            double omega,
            double relX,
            double relY) {
        double left = lo;
        double right = hi;
        double fLeft = fLo;

        for (int iter = 0; iter < BISECTION_STEPS; iter++) {
            double mid = 0.5 * (left + right);
            double rot = omega * mid;
            double xMid = cx + vxVel * mid + (relX * Math.cos(rot) + relY * Math.sin(rot));
            double fMid = xMid - wallX;

            if ((fLeft <= 0.0 && fMid >= 0.0) || (fLeft >= 0.0 && fMid <= 0.0)) {
                right = mid;
            } else {
                left = mid;
                fLeft = fMid;
            }
        }
        return 0.5 * (left + right);
    }

    private static String readNextNonEmptyLine(BufferedReader br) throws IOException {
        String s;
        while ((s = br.readLine()) != null) {
            if (s.trim().length() > 0) {
                return s;
            }
        }
        return null;
    }
}