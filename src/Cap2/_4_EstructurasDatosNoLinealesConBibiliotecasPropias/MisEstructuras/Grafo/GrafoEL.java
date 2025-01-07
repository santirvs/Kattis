package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias.MisEstructuras.Grafo;


import java.util.ArrayList;

public class GrafoEL {

    //Edge List
    ArrayList<Arista> EL;

    // constructor
    public GrafoEL(int vertices) {
        EL = new ArrayList<>(vertices);
    }

    public void agregarArista(int origen, int destino, int peso) {
        EL.add(new Arista(origen,destino, peso));
    }

    public void ordenarAristas() {
        EL.sort(Arista::compareTo);
    }


}
