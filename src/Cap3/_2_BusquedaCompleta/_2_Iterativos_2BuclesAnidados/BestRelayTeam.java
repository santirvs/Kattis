package Cap3._2_BusquedaCompleta._2_Iterativos_2BuclesAnidados;

// No parece demasiado complejo.
// Iterar todas las combinaciones de corredores sumando sus tiempos
// En cada combinación, iterar todos los corredores para tomar su tiempo de arranque
// Quedarse con la combinación que tenga el menor tiempo total y apuntarse el primer corredor
// Esto son 500 * 499 * 498 * 497 = 61,5 M de combinaciones --> TLE?

// v1. TLE en Caso de Prueba 6, como ya me temía...
// v2. Cambio de enfoque para evitar TLE
//     La idea es iterar sobre cada corredor como candidato a salir primero
//     y luego quedarme con los 3 mejores corredores restantes
//     Esto reduce la complejidad a N (iteración) * logN (ordenación), que para 500 es más razonable
import java.util.*;

public class BestRelayTeam {

    static class Corredor {
        String nombre;
        double arranque;
        double sprint;

        Corredor(String nombre, double arranque, double sprint) {
            this.nombre = nombre;
            this.arranque = arranque;
            this.sprint = sprint;
        }
    }

    static class Resultado {
        List<String> equipo;
        double tiempoTotal;

        Resultado(List<String> equipo, double tiempoTotal) {
            this.equipo = equipo;
            this.tiempoTotal = tiempoTotal;
        }
    }

    static Resultado rest(List<Corredor> corredores, int skipIndex) {
        List<String> equipo = new ArrayList<>();

        // Añadir el corredor que se saldrá en primer lugar
        equipo.add(corredores.get(skipIndex).nombre);
        double total = corredores.get(skipIndex).arranque;

        // Hace una copia de la lista de corredores y elimina el que saldrá en primer lugar
        List<Corredor> restantes = new ArrayList<>(corredores);
        restantes.remove(skipIndex);

        // Ordena los corredores restantes por su tiempo de sprint
        restantes.sort(Comparator.comparingDouble(r -> r.sprint));

        // Añade los 3 mejores corredores restantes al equipo
        total += restantes.get(0).sprint;
        total += restantes.get(1).sprint;
        total += restantes.get(2).sprint;

        equipo.add(restantes.get(0).nombre);
        equipo.add(restantes.get(1).nombre);
        equipo.add(restantes.get(2).nombre);

        return new Resultado(equipo, total);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer el número de corredores
        int n = Integer.parseInt(sc.nextLine());
        List<Corredor> runners = new ArrayList<>();

        // Leer los corredores y sus tiempos
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String name = parts[0];
            double first = Double.parseDouble(parts[1]);
            double second = Double.parseDouble(parts[2]);
            runners.add(new Corredor(name, first, second));
        }

        // Inicializar el mejor tiempo y el mejor equipo
        double bestTime = Double.MAX_VALUE;
        List<String> bestTeam = new ArrayList<>();

        // Iterar sobre cada corredor (como candidato a salir primero) y buscarle el mejor equipo
        for (int i = 0; i < runners.size(); i++) {
            Resultado res = rest(runners, i);
            // Si el tiempo total es mejor que el mejor tiempo encontrado, actualizar
            if (res.tiempoTotal < bestTime) {
                bestTime = res.tiempoTotal;
                bestTeam = res.equipo;
            }
        }

        //Mostrar el mejor tiempo y el equipo
        System.out.printf("%.10f\n", bestTime);
        for (String name : bestTeam) {
            System.out.println(name);
        }
    }
}
