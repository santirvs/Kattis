package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias.MisEstructuras.Pruebas;

import Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias.MisEstructuras.Grafo.GrafoAL;

public class PruebaGrafoAL {

    public static void main(String[] args) {
        GrafoAL grafo = new GrafoAL(6);

        grafo.agregarAdyacencia(0, 1, 10);
        grafo.agregarAdyacencia(0, 4, 100);
        grafo.agregarAdyacencia(1, 0, 10);
        grafo.agregarAdyacencia(1, 2, 7);
        grafo.agregarAdyacencia(1, 4, 8);
        grafo.agregarAdyacencia(2, 1, 7);


    }
}
