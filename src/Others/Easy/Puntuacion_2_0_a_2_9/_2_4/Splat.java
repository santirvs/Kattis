package Others.Easy.Puntuacion_2_0_a_2_9._2_4;

// Dado que el número de gotas y el número de puntos son relativamente pequeños (100, 100)
// se puede hacer un algoritmo de fuerza bruta que compruebe las gotas que han afectado a cada coordenada
// Si la coordenada queda afectada por la gota (distancia entre puntos menor o igual que el radio),
// entonces esa coordenada queda pintada por el color de la gota
// El radio se calcula segun el volumen. Nos dan la fórmula V = Pi * r^2 --> r^2 = V / Pi
// La distancia entre dos puntos es D = Sqrt((x1-x2)^2 - (y1-y2)^2)
// Nos podemos ahorrar raíces si trabajamos con los cuadrados de las distancias y del radio


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Splat {

    static class FR {
        BufferedReader br;
        StringTokenizer st;

        public FR() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null; // Manejo de EOF
                    st = new StringTokenizer(line);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        float nextFloat() {
            return Float.parseFloat(next());
        }

        String nextLine() {
            String str = "";
            try {
                if (st != null && st.hasMoreElements()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class Gota {
        double x;
        double y;
        double radio2;
        String color;

        Gota (double x, double y, double volumen, String color) {
            this.x =x;
            this.y = y;
            this.radio2 = volumen / Math.PI;
            this.color = color;
        }
    }


    public static void main(String[] args) throws IOException {

        FR sc = new FR();

        int numCasos = sc.nextInt();

        while (numCasos-- >0) {

            int numGotas = sc.nextInt();
            Gota[] gotas = new Gota[numGotas];
            for (int i=0; i<numGotas; i++) {
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                double vol = sc.nextDouble();
                String color = sc.next();
                gotas[i] = new Gota(x,y,vol,color);
            }

            int numPuntos = sc.nextInt();
            for (int i=0; i<numPuntos; i++) {
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                String color = "white";
                for (int j=0; j<numGotas; j++) {
                    double distancia2 = Math.pow(x-gotas[j].x,2.0) + Math.pow(y-gotas[j].y, 2.0);
                    if (gotas[j].radio2 >= distancia2) {
                        color = gotas[j].color;
                    }
                }
                System.out.println(color);
            }
        }

    }
}