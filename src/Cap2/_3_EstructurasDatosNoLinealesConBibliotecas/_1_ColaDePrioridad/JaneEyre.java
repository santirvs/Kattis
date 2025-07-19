package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._1_ColaDePrioridad;

// Usar una priotity queue para ir tomando los libros que nos vayan regalando (orden por tiempo)
// Usar otra prority queue para ir cogiendo el libro a leer (orden por titulo)
// Caso 19 -> RTE : No he comprobado que la cola de regalos esté vacía
// Caso 19 -> WA : Tiempo debe ser long. Si en el instante 1.000.000.000 me regalan
//               : 100.000 libros de 100.000 páginas = 10^10 --> LONG!!!
//         -> AC! 1,51s
import java.util.*;

public class JaneEyre {
    public static class Libro {
        String titulo;
        int numPaginas;
        int instanteLlegada;

        Libro(String titulo, int numPaginas, int instanteLlegada) {
            this.titulo = titulo;
            this.numPaginas = numPaginas;
            this.instanteLlegada = instanteLlegada;
        }
    }

    public static class LibroInstantComparator implements Comparator<Libro> {
        public int compare(Libro a, Libro b) {
            return a.instanteLlegada - b.instanteLlegada;
        }
    }

    public static class LibroTítleComparator implements Comparator<Libro> {
        public int compare(Libro a, Libro b) {
            return a.titulo.compareTo(b.titulo);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        int numLibros = scan.nextInt();
        int numRegalos = scan.nextInt();
        int numPaginasJaneEyre = scan.nextInt();
        scan.nextLine();

        PriorityQueue<Libro> libros = new PriorityQueue<>(new LibroTítleComparator());
        PriorityQueue<Libro> regalos = new PriorityQueue<>(new LibroInstantComparator());

        //El libro JaneEyre ya lo tiene
        Libro libroJaneEyre = new Libro("Jane Eyre", numPaginasJaneEyre,0);
        libros.add(libroJaneEyre);
        //Añadimos el resto de libros que tiene
        for (int i=0; i<numLibros; i++) {
            String[] partes = scan.nextLine().split("\"");
            String titulo = partes[1];
            int numPaginas = Integer.parseInt(partes[2].trim());
            Libro l = new Libro(titulo, numPaginas, 0);
            libros.add(l);
        }

        //Añadimos los regalos
        for (int i=0; i<numRegalos; i++) {
            String[] partes = scan.nextLine().split("\"");
            int instante = Integer.parseInt(partes[0].trim());
            String titulo = partes[1];
            int numPaginas = Integer.parseInt(partes[2].trim());
            Libro l = new Libro(titulo, numPaginas, instante);
            regalos.add(l);
        }

        long tiempo = 0;
        Libro lectura = null;
        while (lectura != libroJaneEyre) {
            while (!regalos.isEmpty() && regalos.peek().instanteLlegada <= tiempo) {
                libros.add(regalos.poll());
            }
            lectura = libros.poll();
            tiempo += lectura.numPaginas;
        }

        System.out.println(tiempo);

    }
}