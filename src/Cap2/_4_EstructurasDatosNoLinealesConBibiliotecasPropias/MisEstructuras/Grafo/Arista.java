package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias.MisEstructuras.Grafo;

public class Arista implements Comparable<Arista> {
    int _origen, _destino, _peso;

    public Arista(int origen, int destino, int peso) {
        _origen = origen;
        _destino = destino;
        _peso = peso;
    }

    public int compareTo(Arista o) {
        if (this._origen != o._origen)
            return this._origen- o._origen;
        else if (this._destino != o._destino)
            return this._destino - o._destino;
        else
            return this._peso - o._peso;
    }
}
