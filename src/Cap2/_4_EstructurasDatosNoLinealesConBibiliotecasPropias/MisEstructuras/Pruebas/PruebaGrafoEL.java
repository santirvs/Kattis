package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias.MisEstructuras.Pruebas;

import Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias.MisEstructuras.Grafo.GrafoEL;

public class PruebaGrafoEL {
    public static void main(String[] args) {
        GrafoEL grafo = new GrafoEL(6);

        grafo.agregarArista(0, 1, 10);
        grafo.agregarArista(0, 4, 100);
        grafo.agregarArista(1, 0, 10);
        grafo.agregarArista(1, 2, 7);

        grafo.ordenarAristas();
    }
}
