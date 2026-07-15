package Others.Easy.Puntuacion_1_1_a_1_9._1_8;

/**
 * Haciendo uso de un HashMap<String, Concursante> guardemos la posición prevista de cada concursante
 * Luego la actualizamos con la posición final y el número de plazas que ha subido.
 * Finalmente, ordenamos la lista de concursantes (por subida y posición final) y mostramos el primero
 */
import java.util.*;

public class FigureSkating {

    static class Concursante implements Comparable<Concursante> {

        String nombre;
        int posicionEsperada;
        int posicionFinal;

        Concursante(String nombre, int posicionEsperada) {
            this.nombre = nombre;
            this.posicionEsperada = posicionEsperada;
            this.posicionFinal = -1;
        }

        @Override
        public int compareTo(Concursante o) {
            int result = Integer.compare(o.subida(),this.subida() );
            if (result == 0) result = Integer.compare(this.posicionFinal, o.posicionFinal);
            return result;
        }

        public int subida() {
            return this.posicionEsperada - this.posicionFinal;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numConcursantes = sc.nextInt();
        HashMap<String, Concursante> participantes = new HashMap<>();

        //Leer los concursantes y sus posiciones esperadas
        for (int i=1; i<=numConcursantes; i++) {
            String nombre = sc.next();
            participantes.put(nombre, new Concursante(nombre, i));
        }

        boolean sospecha = true;
        //Leer las posiciones finales y asignarlas
        for (int i=1; i<=numConcursantes; i++) {
            String nombre = sc.next();
            Concursante c = participantes.get(nombre);
            if (i!=c.posicionEsperada) sospecha = false;
            c.posicionFinal = i;
        }

        //Obtener la lista de participantes y ordenarla
        List<Concursante> miLista = new ArrayList<>(participantes.values());
        Concursante[] miArray = miLista.toArray(Concursante[]::new);
        Arrays.sort(miArray);

        //Mostrar el primero o la alerta de sospecha
        if (sospecha) System.out.println("suspicious");
        else System.out.println(miArray[0].nombre);
    }
}
