package Others.Hard.Puntuacion_9_0_a_9_9._9_4;

import java.io.InputStream;

public class AreaOfEffect {

    static class FastReader {
        private InputStream in = System.in;
        private byte[] buffer = new byte[1 << 16];
        private int head = 0, tail = 0;

        private int read() throws Exception {
            if (head >= tail) {
                head = 0;
                tail = in.read(buffer, 0, buffer.length);
                if (tail <= 0) return -1;
            }
            return buffer[head++];
        }

        public int nextInt() throws Exception {
            int c = read();
            while (c != -1 && c <= 32) c = read();
            if (c == -1) return -1;
            boolean neg = false;
            if (c == '-') { neg = true; c = read(); }
            int res = 0;
            while (c > 32) {
                res = res * 10 + (c - '0');
                c = read();
            }
            return neg ? -res : res;
        }
    }

    static class Pueblo {
        double x, y, r;
        Pueblo(double x, double y, double r) { this.x = x; this.y = y; this.r = r; }
    }

    static class Esbirro {
        double x, y;
        Esbirro(double x, double y) { this.x = x; this.y = y; }
    }

    private static final double EPS = 1e-7;

    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int N;

        while ((N = sc.nextInt()) != -1) {
            int M = sc.nextInt();
            double Rmax = sc.nextInt();

            Pueblo[] pueblos = new Pueblo[N];
            for (int i = 0; i < N; i++) {
                pueblos[i] = new Pueblo(sc.nextInt(), sc.nextInt(), sc.nextInt());
            }

            Esbirro[] esbirros = new Esbirro[M];
            for (int i = 0; i < M; i++) {
                esbirros[i] = new Esbirro(sc.nextInt(), sc.nextInt());
            }

            int maxGlobal = 1;

            // CASO 8 FIX: Iteramos sobre TODOS los esbirros para no saltarnos ninguna
            // agrupación local densa aislada.
            for (int i = 0; i < M; i++) {
                double cx = esbirros[i].x;
                double cy = esbirros[i].y;

                int actual = contarEsbirros(cx, cy, esbirros, pueblos, Rmax, M, N);
                if (actual > maxGlobal) maxGlobal = actual;

                // Si el máximo teórico restante no puede superar el global, podríamos podar,
                // pero el Hill Climbing es lo suficientemente rápido si converge pronto.
                double paso = Rmax;
                while (paso > 1e-3) {
                    double mejorX = cx, mejorY = cy;
                    int mejorCuenta = actual;

                    // Exploramos el vecindario inmediato
                    for (int dx = -1; dx <= 1; dx++) {
                        for (int dy = -1; dy <= 1; dy++) {
                            if (dx == 0 && dy == 0) continue;
                            double nx = cx + dx * paso;
                            double ny = cy + dy * paso;

                            int cuenta = contarEsbirros(nx, ny, esbirros, pueblos, Rmax, M, N);
                            if (cuenta > mejorCuenta) {
                                mejorCuenta = cuenta;
                                mejorX = nx;
                                mejorY = ny;
                            }
                        }
                    }

                    if (mejorCuenta > actual) {
                        actual = mejorCuenta;
                        cx = mejorX;
                        cy = mejorY;
                        if (actual > maxGlobal) maxGlobal = actual;
                    } else {
                        paso *= 0.5;
                    }
                }
            }

            System.out.println(maxGlobal);
        }
    }

    private static int contarEsbirros(double cx, double cy, Esbirro[] esbirros, Pueblo[] pueblos,
                                      double Rmax, int M, int N) {
        double rEfectivo = Rmax;

        // Validación ultra rápida con los pueblos
        for (int j = 0; j < N; j++) {
            double dx = cx - pueblos[j].x;
            double dy = cy - pueblos[j].y;
            double distSq = dx * dx + dy * dy;
            double rPueblo = pueblos[j].r;

            if (distSq < rPueblo * rPueblo - EPS) {
                return 0; // Invade el pueblo ilegalmente
            }

            double dist = Math.sqrt(distSq);
            double rPermitido = dist - rPueblo;
            if (rPermitido < rEfectivo) {
                rEfectivo = rPermitido;
            }
        }

        if (rEfectivo < 0) return 0;

        int cuenta = 0;
        double rEfectivo2 = (rEfectivo + EPS) * (rEfectivo + EPS);

        // Contar los esbirros dentro del radio dinámico calculado
        for (int i = 0; i < M; i++) {
            double dx = esbirros[i].x - cx;
            double dy = esbirros[i].y - cy;
            if (dx * dx + dy * dy <= rEfectivo2) {
                cuenta++;
            }
        }
        return cuenta;
    }
}