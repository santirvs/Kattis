package Cap2._1_EstructurasDatosConBibliotecas._7_Ordenacion_Especiales;

import java.util.*;


public class Sort {

    public static class Elemento implements Comparable {
        int cantidad;
        int posicion;
        int valor;

        public Elemento (int valor, int cantidad, int posicion) {
            this.valor = valor;
            this.cantidad = cantidad;
            this.posicion = posicion;
        }

        public int compareTo(Object o) {
            Elemento e = (Elemento) o;
            if (this.cantidad == e.cantidad) {
                return this.posicion - e.posicion;
            } else {
                return e.cantidad - this.cantidad;
            }
        }

        public boolean equals(Object o) {
            Elemento e = (Elemento) o;
            return this.valor == e.valor;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numValores = scan.nextInt();
        int maxValor = scan.nextInt();

        ArrayList<Elemento> valores = new ArrayList<>();

        //Apuntamos las frecuencias de cada valor
        for (int i=0; i<numValores; i++) {
            int valor = scan.nextInt();
            int posicion = valores.indexOf(new Elemento(valor, 0,0));
            if (posicion >=0) {
                valor = valores.get(posicion).valor;
                valores.get(posicion).cantidad++;
            } else {
                valores.add(new Elemento(valor, 1, i));
            }
        }

        Collections.sort(valores);

        //Mostramos los valores ordenados, repitiendo tantas veces como indique su frecuencia
        boolean primero = true;
        for (Elemento e : valores) {
            int numRepeticiones = e.cantidad;
            for (int j=0; j<numRepeticiones; j++) {
                if (!primero) System.out.print(" ");
                else primero = false;
                System.out.print(e.valor);
            }
        }
        System.out.println("");
    }

}
