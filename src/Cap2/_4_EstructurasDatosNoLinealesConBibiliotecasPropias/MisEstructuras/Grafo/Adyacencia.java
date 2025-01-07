package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias.MisEstructuras.Grafo;

public class Adyacencia implements Comparable<Adyacencia> {
    int _destino, _peso;

    public Adyacencia(int destino, int peso) {
        _destino = destino;
        _peso = peso;
    }

    public int compareTo(Adyacencia o) {
        if (this._destino != o._destino)
            return this._destino - o._destino;
        else
            return this._peso - o._peso;
    }
}
