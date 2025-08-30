package Cap3._4_Voraz._1_Clasicos;

// Estrategia Voraz. Clásicos.

/*
 Parece ser un problema clásico de cobertura de intervalos, pero con varias aulas.
 El objetivo es maximizar el número de actividades que podemos acomodar en k aulas.
    Una estrategia voraz natural es:
    1. Ordenar las actividades por tiempo de finalización creciente.
    2. Para cada actividad en ese orden, asignarla a un aula que esté disponible
       (es decir, cuyo tiempo de disponibilidad sea menor o igual al tiempo de inicio de la actividad).
       Si hay varias aulas disponibles, asignarla a la que tenga el tiempo de disponibilidad más tardío.
       Si no hay aulas disponibles, descartamos la actividad.
    3. Contar cuántas actividades hemos asignado.

  Sin embargo, el número de aulas y actividades es demasiado grande (hasta 200.000), con lo que un algoritmo O(n*k) sería demasiado lento (4*10^10 operaciones).

    Para implementar la estrategia voraz eficientemente, podemos usar un multiset (árbol balanceado)
    para almacenar los tiempos de disponibilidad de las aulas.
    Inicialmente, todas las aulas están disponibles en el tiempo 0.
    Para cada actividad, buscamos en el multiset el mayor tiempo de disponibilidad
    que sea menor o igual al tiempo de inicio de la actividad (usando lower_bound).
    Si encontramos tal tiempo, significa que hay un aula disponible para la actividad.
    Actualizamos el multiset eliminando ese tiempo y añadiendo el tiempo de finalización
    de la actividad, que será el nuevo tiempo de disponibilidad del aula.
    Si no encontramos tal tiempo, descartamos la actividad.
    Al final, el número de actividades asignadas es el resultado.
    Este enfoque tiene complejidad O(n log k), que es eficiente para los límites dados.

    Atención al uso de claves negativas en el TreeMap para simular upper_bound.
    Esto es porque Java no tiene lower_bound, pero sí ceilingEntry (>= clave).
    Usando claves negativas, buscar el mayor valor <= x es equivalente a buscar
    el menor valor >= -x (ceilingEntry(-x)) y luego negarlo.
    Pero como ceilingEntry devuelve >= clave, le sumamos 1 a -x para que sea
    estrictamente mayor que -x.
*/

import java.io.*;
import java.util.*;

public class Classrooms {
    static class Actividad implements Comparable<Actividad> {
        int inicio, fin;
        Actividad(int s, int f) {
            this.inicio = s;
            this.fin = f;
        }
        @Override
        //Nos interesa un orden por tiempo de finalización creciente
        public int compareTo(Actividad o) {
            if (this.fin == o.fin) return this.inicio - o.inicio;
            return this.fin - o.fin;
        }
    }

    public static void main(String[] args) throws IOException {
        // Con 200.000 entradas, es necesario un scanner rápido
        FastScanner sc = new FastScanner();

        // Leer el número de actividades y aulas
        int numActividades = sc.nextInt();
        int numAulas = sc.nextInt();

        // Leer las actividades
        Actividad[] activities = new Actividad[numActividades];
        for (int i = 0; i < numActividades; i++) {
            int inicio = sc.nextInt();
            int fin = sc.nextInt();
            activities[i] = new Actividad(inicio, fin);
        }
        //Ordenar las actividades por tiempo de finalización creciente
        Arrays.sort(activities);

        // Usamos TreeMap como multiset con claves negativas (para simular upper_bound)
        // Inicialmente todas las aulas están disponibles en el tiempo 0
        // Simular un multiset con TreeMap, contando las ocurrencias de cada clave
        TreeMap<Integer, Integer> ms = new TreeMap<>();
        for (int i = 0; i < numAulas; i++) add(ms, 0);

        // Asignar las actividades a las aulas y contar las que se hayan podido asignar
        int numActividadesAsignadas = 0;
        for (Actividad a : activities) {
            int inicio = a.inicio;
            int fin = a.fin;

            // buscamos el mayor valor > -inicio   (ceilingEntry devuelve >= clave, por eso le sumamos 1)
            Map.Entry<Integer, Integer> it = ms.ceilingEntry(-inicio+1);
            if (it == null) continue; // no cabe esta actividad

            // Asignamos la actividad a esa aula
            // Actualizamos el multiset: eliminamos el tiempo de disponibilidad
            // del aula y añadimos el nuevo tiempo de disponibilidad (fin de la actividad)
            add(ms, -fin);
            remove(ms, it.getKey());
            numActividadesAsignadas++;
        }

        // Mostrar el resultado
        System.out.println(numActividadesAsignadas);
    }

    // Métodos auxiliares para simular multiset en TreeMap
    // Realmente no la añade, sino que le suma 1 al contador de ocurrencias
    // Únicamente la añade si no existía previamente y lo hace con contador =1
    static void add(TreeMap<Integer, Integer> map, int key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    //Elimina una ocurrencia de key del multiset
    //Realmente no la elimina, sino que le resta 1 al contador de ocurrencias
    //Solo la elimina si es la última (contador = 1)
    static void remove(TreeMap<Integer, Integer> map, int key) {
        int cnt = map.get(key);
        if (cnt == 1) map.remove(key);
        else map.put(key, cnt - 1);
    }

    // Scanner rápido
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = readByte()) != -1 && c <= ' ');
            if (c == -1) return null;
            do {
                sb.append((char)c);
            } while ((c = readByte()) != -1 && c > ' ');
            return sb.toString();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
