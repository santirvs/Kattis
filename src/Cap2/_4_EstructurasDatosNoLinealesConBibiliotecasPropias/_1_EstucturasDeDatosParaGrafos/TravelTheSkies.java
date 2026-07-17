package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias._1_EstucturasDeDatosParaGrafos;

// Travel the Skies
// Caso 12 - RTE --> Buscar alguna estructura no inicializada


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TravelTheSkies {

    public static class Vuelo {
        int origen;
        int destino;
        int capacidad;

        Vuelo(int o, int dest, int cap) {
            this.origen = o;
            this.destino = dest;
            this.capacidad = cap;
        }
    }

    public static class PasajerosDia {
        int aeropuerto;
        int cantidad;

        PasajerosDia(int a, int c) {
            this.aeropuerto = a;
            this.cantidad = c;
        }
    }

    public static void main(String[] args) {
        FastScanner scan = new FastScanner();

        int cantidadAeropuertos = scan.nextInt();
        int ventanaDias = scan.nextInt();
        int vuelosEnVentana = scan.nextInt();

        // Personas acumuladas esperando en cada aeropuerto
        int[] personas = new int[cantidadAeropuertos];

        // Usamos arrays de ArrayList indexados por día [0 ... ventanaDias-1]
        // Esto evita usar HashMaps y previene de forma segura los NullPointerException
        ArrayList<Vuelo>[] vuelosPorDia = new ArrayList[ventanaDias];
        ArrayList<PasajerosDia>[] pasajerosPorDia = new ArrayList[ventanaDias];

        for (int i = 0; i < ventanaDias; i++) {
            vuelosPorDia[i] = new ArrayList<>();
            pasajerosPorDia[i] = new ArrayList<>();
        }

        // Leer todos los vuelos
        for (int i = 0; i < vuelosEnVentana; i++) {
            int origen = scan.nextInt() - 1;
            int destino = scan.nextInt() - 1;
            int dia = scan.nextInt() - 1;
            int capacidad = scan.nextInt();

            vuelosPorDia[dia].add(new Vuelo(origen, destino, capacidad));
        }

        // Leer las llegadas de pasajeros procedentes de sus casas
        int totalConsultasPasajeros = cantidadAeropuertos * ventanaDias;
        for (int i = 0; i < totalConsultasPasajeros; i++) {
            int aeropuerto = scan.nextInt() - 1;
            int dia = scan.nextInt() - 1;
            int cantidad = scan.nextInt();

            pasajerosPorDia[dia].add(new PasajerosDia(aeropuerto, cantidad));
        }

        // Simulación cronológica día a día
        boolean optimo = true;
        for (int i = 0; i < ventanaDias; i++) {

            // 1. Llegan los nuevos pasajeros de sus casas al aeropuerto en el día i
            for (PasajerosDia p : pasajerosPorDia[i]) {
                personas[p.aeropuerto] += p.cantidad;
            }

            // 2. Comprobar si hay suficientes personas en el origen para llenar cada vuelo programado hoy
            for (Vuelo v : vuelosPorDia[i]) {
                personas[v.origen] -= v.capacidad;
                if (personas[v.origen] < 0) {
                    optimo = false;
                    break;
                }
            }

            if (!optimo) break;

            // 3. Los pasajeros que volaron con éxito llegan a sus destinos correspondientes
            // Nota: No pueden volver a volar hoy (la regla dice que solo un vuelo al día)
            // pero ya estarán listos en el aeropuerto de destino para el día de mañana (i + 1)
            for (Vuelo v : vuelosPorDia[i]) {
                personas[v.destino] += v.capacidad;
            }
        }

        if (optimo) {
            System.out.println("optimal");
        } else {
            System.out.println("suboptimal");
        }
    }

    // Lector rápido para evitar TLE en Java con inputs grandes
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}