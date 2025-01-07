package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias.MisEstructuras.Grafo;


import java.util.ArrayList;

public class GrafoAL {

    //Adjacency List
    ArrayList<ArrayList<Adyacencia>> AL;
    public GrafoAL(int vertices) {
        // constructor
        AL = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            AL.add(new ArrayList<>());
        }
    }

    public void agregarAdyacencia(int origen, int destino, int peso) {
        AL.get(origen).add(new Adyacencia(destino, peso));
    }



}
