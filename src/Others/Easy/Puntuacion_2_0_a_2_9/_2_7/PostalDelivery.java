package Others.Easy.Puntuacion_2_0_a_2_9._2_7;

/**
 * Algoritmo voraz.
 * Dividir en dos los repartos: los que van a la derecha y los que van a la izquierda
 * Para cada uno de ellos, ir lo más lejos posible con la capacidad máxima. Descargar allí y, de vuelta, usar
 * la carga excedente para repartir en el resto de puntos.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PostalDelivery {
    static class Entrega {
        long x;
        long cartas;

        Entrega(long x, long cartas) {
            this.x = x;
            this.cartas = cartas;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        List<Entrega> pos = new ArrayList<Entrega>();
        List<Entrega> neg = new ArrayList<Entrega>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long cartas = Long.parseLong(st.nextToken());

            if (x > 0) {
                pos.add(new Entrega(x, cartas));
            } else {
                neg.add(new Entrega(-x, cartas)); // Guardamos valor absoluto
            }
        }

        // Ordenar de mayor a menor distancia
        Comparator<Entrega> comp = new Comparator<Entrega>() {
            @Override
            public int compare(Entrega a, Entrega b) {
                return Long.compare(b.x, a.x);
            }
        };

        Collections.sort(pos, comp);
        Collections.sort(neg, comp);

        long distanciaTotal = calcularDistancia(pos, k) + calcularDistancia(neg, k);
        System.out.println(distanciaTotal);
    }

    private static long calcularDistancia(List<Entrega> lista, long k) {
        long distancia = 0;
        int i = 0;
        int size = lista.size();

        while (i < size) {
            long xMax = lista.get(i).x;
            long cartasNecesarias = lista.get(i).cartas;

            // Viajes completos con capacidad K a esta casa
            long viajesCompletos = cartasNecesarias / k;
            distancia += viajesCompletos * 2 * xMax;
            long sobrantesEnCasa = cartasNecesarias % k;

            if (sobrantesEnCasa > 0) {
                // Hacemos 1 viaje adicional para cubrir las cartas restantes
                distancia += 2 * xMax;
                long capacidadDisponible = k - sobrantesEnCasa;
                i++;

                // Usamos la capacidad sobrante del viaje en las siguientes casas
                while (i < size && capacidadDisponible > 0) {
                    if (lista.get(i).cartas <= capacidadDisponible) {
                        capacidadDisponible -= lista.get(i).cartas;
                        i++;
                    } else {
                        lista.get(i).cartas -= capacidadDisponible;
                        capacidadDisponible = 0;
                    }
                }
            } else {
                i++;
            }
        }

        return distancia;
    }
}