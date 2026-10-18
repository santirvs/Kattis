package Others.Medium.Puntuacion_2_0_a_2_9._2_9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class LastChristmas {

    // Clase auxiliar para representar a un artista y sus estadísticas
    static class Artist implements Comparable<Artist> {
        String name;
        int totalAppearances;
        int[] positions; // positions[0] = puesto 1, positions[1] = puesto 2, ..., positions[9] = puesto 10

        public Artist(String name) {
            this.name = name;
            this.totalAppearances = 0;
            this.positions = new int[10];
        }

        // Definimos el criterio de ordenamiento según las reglas del problema
        @Override
        public int compareTo(Artist other) {
            // 1. Comparar por apariciones totales (orden descendente: mayor cantidad primero)
            if (this.totalAppearances != other.totalAppearances) {
                return Integer.compare(other.totalAppearances, this.totalAppearances);
            }

            // 2. Si empatan en total, comparar posición por posición (del puesto 1 al 10) de forma descendente
            for (int i = 0; i < 10; i++) {
                if (this.positions[i] != other.positions[i]) {
                    return Integer.compare(other.positions[i], this.positions[i]);
                }
            }

            // 3. Si son exactamente iguales en todo, ordenamos alfabéticamente por nombre (para estabilidad)
            return this.name.compareTo(other.name);
        }
    }

    public static void main(String[] args) throws IOException {
        // Usamos BufferedReader y StringTokenizer para una lectura rápida y eficiente de la entrada
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        if (line == null || line.trim().isEmpty()) {
            return;
        }

        int n = Integer.parseInt(line.trim());

        // Mapa para buscar y acumular las estadísticas de cada artista por su nombre
        Map<String, Artist> artistMap = new HashMap<String, Artist>();

        // Leer las n líneas de listas top-10
        for (int i = 0; i < n; i++) {
            line = br.readLine();
            if (line == null) break;

            StringTokenizer st = new StringTokenizer(line);
            for (int pos = 0; pos < 10; pos++) {
                if (!st.hasMoreTokens()) break;
                String artistName = st.nextToken();

                // Obtenemos el artista del mapa o lo creamos si es la primera vez que aparece
                Artist artist = artistMap.get(artistName);
                if (artist == null) {
                    artist = new Artist(artistName);
                    artistMap.put(artistName, artist);
                }

                // Incrementamos las estadísticas generales y la posición específica (0 a 9)
                artist.totalAppearances++;
                artist.positions[pos]++;
            }
        }

        // Convertimos los valores del mapa a una lista para poder ordenarlos
        List<Artist> artists = new ArrayList<Artist>(artistMap.values());

        if (artists.isEmpty()) {
            System.out.println("tie");
            return;
        }

        // Ordenamos la lista aplicando la lógica implementada en el método compareTo
        Collections.sort(artists);

        // Verificamos si hay un empate real entre el primer y el segundo lugar
        if (artists.size() > 1) {
            Artist first = artists.get(0);
            Artist second = artists.get(1);

            // Comparamos si el primero y el segundo tienen exactamente las mismas estadísticas
            if (first.totalAppearances == second.totalAppearances) {
                boolean exactTie = true;
                for (int i = 0; i < 10; i++) {
                    if (first.positions[i] != second.positions[i]) {
                        exactTie = false;
                        break;
                    }
                }

                // Si tienen exactamente las mismas apariciones y distribución de puestos, hay empate
                if (exactTie) {
                    System.out.println("tie");
                    return;
                }
            }
        }

        // Si hay un único ganador claro, imprimimos su nombre
        System.out.println(artists.get(0).name);
    }
}
