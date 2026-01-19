package Others.Easy.Puntuacion_3_0_a_3_9._3_8;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Este es un problema clásico de colisión de esferas con movimiento rectilíneo uniforme,
 * que se resuelve reduciendolo al movimiento relativo y resolviendo una ecuación cuadrática.
 * 1. Modelo matemático
 * Para cada test:
 *    - Esfera A (nave):
 *      posición p₁, radio r₁, velocidad v₁
 *    - Esfera B (basura):
 *      posición p₂, radio r₂, velocidad v₂
 *
 * Movimiento relativo
 * Pasamos al sistema de referencia de la esfera A:
 *    Posición relativa inicial:
 *      p = p2-p1
 *    Velocidad relativa:
 *      v = v2-v1

 * Las esferas colisionan cuando la distancia entre centros es igual a la suma de radios:
 *      | p+v*t | = r1+r2
 * Elevando al cuadrado:
 *      | p+v*t | ^2  = (r1+r2)^2
 * Esto da una ecuación cuadrática:
 *      at^2 + bt + c = 0
 *  donde:
 *     a = v*v
 *     b = 2*(p*v)
 *     c = p*p - (r1+r2)^2
 *
 * 2. Casos a considerar
 *
 * a = 0
 * → no hay movimiento relativo
 * → nunca colisionan (el enunciado dice que no se tocan inicialmente)
 *
 * Discriminante < 0
 * → no hay solución real
 * → No collision
 *
 * Soluciones reales
 * Tomamos la menor raíz positiva:
 *
 *   t = (-b -SQRT(D) ) / 2a
 *   si t<0, usamos la otra raíz
 *
 * Si ambas son negativas → No collision
 *
 */
public class SpaceJunk {

    static class Sphere {
        double x, y, z, r;
        double vx, vy, vz;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        StringBuilder out = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            Sphere a = readSphere(br);
            Sphere b = readSphere(br);

            // Posición relativa
            double px = b.x - a.x;
            double py = b.y - a.y;
            double pz = b.z - a.z;

            // Velocidad relativa
            double vx = b.vx - a.vx;
            double vy = b.vy - a.vy;
            double vz = b.vz - a.vz;

            double R = a.r + b.r;

            double A = vx*vx + vy*vy + vz*vz;
            double B = 2 * (px*vx + py*vy + pz*vz);
            double C = px*px + py*py + pz*pz - R*R;

            if (A == 0) {
                out.append("No collision\n");
                continue;
            }

            double D = B*B - 4*A*C;
            if (D < 0) {
                out.append("No collision\n");
                continue;
            }

            double sqrtD = Math.sqrt(D);
            double t1 = (-B - sqrtD) / (2*A);
            double t2 = (-B + sqrtD) / (2*A);

            double t = Double.POSITIVE_INFINITY;
            if (t1 >= 0) t = t1;
            else if (t2 >= 0) t = t2;

            if (Double.isInfinite(t)) {
                out.append("No collision\n");
            } else {
                out.append(String.format("%.3f%n", t));
            }
        }

        System.out.print(out.toString());
    }

    static Sphere readSphere(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        Sphere s = new Sphere();
        s.x  = Double.parseDouble(st.nextToken());
        s.y  = Double.parseDouble(st.nextToken());
        s.z  = Double.parseDouble(st.nextToken());
        s.r  = Double.parseDouble(st.nextToken());
        s.vx = Double.parseDouble(st.nextToken());
        s.vy = Double.parseDouble(st.nextToken());
        s.vz = Double.parseDouble(st.nextToken());
        return s;
    }
}
