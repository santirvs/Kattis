package Others.Easy.Puntuacion_2_0_a_2_9._2_0;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Invoker_Hard {

    static class Q {
        double a, b, c, d;

        Q(double a, double b, double c, double d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }

    static Q multiply(Q x, Q y) {
        double a = x.a * y.a - x.b * y.b - x.c * y.c - x.d * y.d;
        double b = x.a * y.b + x.b * y.a + x.c * y.d - x.d * y.c;
        double c = x.a * y.c - x.b * y.d + x.c * y.a + x.d * y.b;
        double d = x.a * y.d + x.b * y.c - x.c * y.b + x.d * y.a;
        return new Q(a, b, c, d);
    }

    static Q inverse(Q q) {
        double norm = q.a * q.a + q.b * q.b + q.c * q.c + q.d * q.d;
        return new Q(
                q.a / norm,
                -q.b / norm,
                -q.c / norm,
                -q.d / norm
        );
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Q me = new Q(
                Double.parseDouble(st.nextToken()),
                Double.parseDouble(st.nextToken()),
                Double.parseDouble(st.nextToken()),
                Double.parseDouble(st.nextToken())
        );

        st = new StringTokenizer(br.readLine());
        Q enemy = new Q(
                Double.parseDouble(st.nextToken()),
                Double.parseDouble(st.nextToken()),
                Double.parseDouble(st.nextToken()),
                Double.parseDouble(st.nextToken())
        );

        Q ans = multiply(me, inverse(enemy));

        System.out.printf("%.10f %.10f %.10f %.10f%n",
                ans.a, ans.b, ans.c, ans.d);
    }
}