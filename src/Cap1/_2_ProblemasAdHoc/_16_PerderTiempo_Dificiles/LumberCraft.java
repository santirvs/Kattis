package Cap1._2_ProblemasAdHoc._16_PerderTiempo_Dificiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class LumberCraft {

    public static class Arbol implements Comparable<Arbol> {
        int x;
        int y;
        Lenyador lenyador;

        public Arbol(int x, int y, Lenyador lenyador) {
            this.x = x;
            this.y = y;
            this.lenyador = lenyador;
        }

        public double distancia() {
            return Math.sqrt(Math.pow(this.x - lenyador.x, 2) + Math.pow(this.y - lenyador.y, 2));
        }

        public boolean equals(Object o) {
            if (o instanceof Arbol) {
                Arbol a = (Arbol) o;
                return this.x == a.x && this.y == a.y;
            }
            return false;
        }

        @Override
        public int compareTo(Arbol o) {
            //Primer criterio: distancia
            if (distancia() == o.distancia()) {
                //Segundo criterio: más al este (x es mayor)
                if (o.x > this.x) {
                    return 1;
                } else if (o.x < this.x) {
                    return -1;
                } else {
                    //Tercer criterio: más al sur (y es mayor)
                    if (o.y > this.y) {
                        return 1;
                    } else if (o.y < this.y) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            } else if (distancia() < o.distancia()) {
                return -1;
            } else {
                return 1;
            }
        }
    }
    public static class Lenyador implements Comparable<Lenyador> {
        int x;
        int y;
        double arbolesCortados;
        char[][] tablero;
        String nombre;
        ArrayList<Arbol> arbolesCandidatos = new ArrayList<>();

        public Lenyador(String nombre, int x, int y, char[][] tablero) {
            this.nombre = nombre;
            this.x = x;
            this.y = y;
            this.arbolesCortados = 0;
            this.tablero = tablero;
        }

        public void buscarArboles() {
            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero[i].length; j++) {
                    if (tablero[i][j] == '!') {
                        arbolesCandidatos.add(new Arbol(j, i, this));
                    }
                }
            }
            Collections.sort(arbolesCandidatos);
        }

        public Arbol siguienteArbol() {
            if (arbolesCandidatos.size() == 0) {
                return null;
            }
            return arbolesCandidatos.get(0);
        }

        public void eliminarArbol(Arbol arbol) {
            arbolesCandidatos.remove(arbol);
        }

        @Override
        public int compareTo(Lenyador o) {
            return nombre.compareTo(o.nombre);
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer la entrada
        int turnos = scan.nextInt();
        int alto = scan.nextInt();
        int ancho = scan.nextInt();

        while (turnos != 0 ||alto != 0 || ancho != 0) {
            scan.nextLine();
            ArrayList<Lenyador> lenyadores = new ArrayList<>();

            //Definir y cargar el tablero inicial
            char[][] tablero = new char[alto][ancho];
            for (int i = 0; i < alto; i++) {
                tablero[i] = scan.nextLine().toCharArray();

                //Localizar a los leñadores
                for (int j = 0; j < tablero[i].length; j++) {
                    if (tablero[i][j] != '.' && tablero[i][j] != '!') {
                        Lenyador lenyador = new Lenyador("" + tablero[i][j], j, i, tablero);
                        lenyadores.add(lenyador);
                    }
                }
            }


            //Para cada leñador, construir la lista de arboles candidatos
            for (Lenyador lenyador : lenyadores) {
                lenyador.buscarArboles();
            }

            //Simular los turnos
            ArrayList<Arbol> arbolesSeleccionados = new ArrayList<>();
            for (int i = 0; i < turnos; i++) {
                for (Lenyador lenyador : lenyadores) {
                    Arbol arbol = lenyador.siguienteArbol();
                    if (arbol != null)
                        arbolesSeleccionados.add(arbol);
                }


                //Revisar los arboles seleccionados buscando duplicados
                while (arbolesSeleccionados.size() > 0) {
                    ArrayList<Arbol> repetidos = new ArrayList<>();
                    repetidos.add(arbolesSeleccionados.get(0));
                    for (int j = 1; j < arbolesSeleccionados.size(); j++) {
                        if (arbolesSeleccionados.get(0).equals(arbolesSeleccionados.get(j))) {
                            repetidos.add(arbolesSeleccionados.get(j));
                        }
                    }
                    if (repetidos.size() == 1) {
                        //No hay repetidos
                        Lenyador l = arbolesSeleccionados.get(0).lenyador;
                        l.arbolesCortados++;
                    } else {
                        //Hay repetidos
                        for (Arbol arbol : repetidos) {
                            Lenyador l = arbol.lenyador;
                            l.arbolesCortados += 1.0 / repetidos.size();
                        }
                    }
                    //Eliminar cada arbol de cada leñador
                    for (Arbol arbol : repetidos) {
                        for (Lenyador lenyador : lenyadores) {
                            lenyador.eliminarArbol(arbol);
                        }
                        //Eliminar el arbol de la lista de arboles seleccionados
                        arbolesSeleccionados.remove(arbol);
                        tablero[arbol.y][arbol.x] = '.';
                    }

                }
            }

            //Imprimir el tablero
            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero[i].length; j++) {
                    System.out.print(tablero[i][j]);
                }
                System.out.println();
            }


            //Imprimir los resultados
            Collections.sort(lenyadores);
            for (Lenyador lenyador : lenyadores) {
                System.out.println(lenyador.nombre + " " + lenyador.arbolesCortados);
            }


            //Siguiente caso
            turnos = scan.nextInt();
            alto = scan.nextInt();
            ancho = scan.nextInt();
        }

     }
}


