package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._9_ArbolEstadisticosDeOrden;

// Usa estadísticos de orden y sólo se ha implementado en C++
// pero en Visual Studio C++ no se permite el uso de bits/stdc++.h
// Pruebo a hacerlo en Java con TreeSet y con subSet(desde, hasta),
// que devuelve un subconjunto de elementos que están en el rango [desde, hasta)
// y luego hago size() para saber cuántos elementos hay en ese rango.
// Esta solución supera los 6 primeros casos de prueba, pero luego da TLE.
// Esperar a conocer los árboles de Fenwick ya que los PBDS no están implementados en Java.



import Utils.Kattio;

import java.util.TreeSet;

public class BabyNames_TLE {

    public static int buscarCantidadNombres(String nomDesde, String nomHasta, TreeSet<String> nombres) {
        return nombres.subSet(nomDesde, nomHasta).size();
    }

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        TreeSet<String> nombresNen = new TreeSet<>();
        TreeSet<String> nombresNena = new TreeSet<>();

        int n = io.getInt();
        while (n != 0) {
            if (n==1) {
                String nombre = io.getWord();
                int genero = io.getInt();

                if (genero == 1) {
                    nombresNen.add(nombre);
                } else {
                    nombresNena.add(nombre);
                }
            } else if (n==2) {
                String nombre = io.getWord();
                nombresNen.remove(nombre);
                nombresNena.remove(nombre);
            }
             else if (n==3) {
                String nomDesde = io.getWord();
                String nomHasta = io.getWord();
                int genero = io.getInt();
                int cantNombres = 0;

                if (genero == 1 || genero == 0) {
                    cantNombres += buscarCantidadNombres(nomDesde, nomHasta, nombresNen);
                }
                if (genero == 2 || genero == 0) {
                    cantNombres += buscarCantidadNombres(nomDesde, nomHasta,nombresNena);
                }
                io.println(cantNombres);
            }
             //Siguiente comando
            n = io.getInt();
        }

        io.close();
    }
}


