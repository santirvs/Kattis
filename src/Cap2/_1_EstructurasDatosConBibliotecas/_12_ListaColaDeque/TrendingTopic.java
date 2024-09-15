package Cap2._1_EstructurasDatosConBibliotecas._12_ListaColaDeque;

// Hacer una lista de días y que cada día sea una lista con las palabras de un texto y su número de apariciones
// Al empezar un día, se añaden las palabras del día anterior a la lista de palabras del día actual
// Si estamos más allá del día 7, se restarán (o eliminarán) las palabras del día 1

// Caso 1:RTE --> El hasNext() no está correctamente implementado. Uso Scanner
// Caso 2:WA -->  Adapto el código de https://github.com/mpfeifer1/Kattis/blob/master/trendingtopic.cpp a Java
//                no lo consigo ya que hace uso de iteradores sobre un map y no sé cómo hacerlo en Java
//                Rehago la implementación de runquery
//           --> AC

// La estrategia seguida es algo diferente:
// Se crea una lista de palabras que llegan cada día y se actualiza el conteo de palabras
// Se crea una lista de consultas que se van a realizar cada día
// Se recorren los días acumulando el conteo de palabras
// Si se ha pasado de 7 días, se resta el acumulado de las palabras del día n-7. Si el conteo es 0, se elimina la palabra
// Al final de cada día se lanzan las consultas propuestas ese día
// La consulta consiste en hacer una lista de las palabras con su conteo y ordenarlas por frecuencia y luego por orden alfabético

import java.io.*;
import java.util.*;

public class TrendingTopic {

    static class Entrada implements Comparable<Entrada> {
        String palabra;
        int apariciones;

        Entrada(String palabra, int apariciones) {
            this.palabra = palabra;
            this.apariciones = apariciones;
        }

        //Ordena por apariciones (descendente) y por palabra (ascendente)
        @Override
        public int compareTo(Entrada o) {
            if(o.apariciones == this.apariciones) {
                return this.palabra.compareTo(o.palabra);
            }
            return o.apariciones - this.apariciones;
        }
    }


    static void runquery(HashMap<String,Integer> cnt, int top) {

        //EN cnt llega la lista de palabras vigente del dia
        //Necesitamos ordenarlas por frecuencia y luego por orden alfabetico
        //Para ello, creamos una lista de objetos Entrada y la ordenamos

        ArrayList<Entrada> lista = new ArrayList<>();
        for(Map.Entry<String,Integer> i : cnt.entrySet()) {
            lista.add(new Entrada(i.getKey(),i.getValue()));
        }
        Collections.sort(lista);

        //Se imprimen las top primeras palabras
        //Si hay empate, se siguen imprimiendo hasta que se rompa el empate
        for(int i = 0; i < lista.size() && (i<top || lista.get(i).apariciones == lista.get(i-1).apariciones); i++) {
            System.out.println(lista.get(i).palabra + " " + lista.get(i).apariciones);
        }

    }

    public static void main(String[] args) throws Exception {
        //FastIO io = new FastIO();
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        String token;
        LinkedList<LinkedList<String>> dias = new LinkedList<>();
        HashMap<Integer,ArrayList<Integer>> consultas = new HashMap<>();

        //En el día 0 no hay palabras ni consultas
        int hoy = 0;
        dias.addLast(new LinkedList<>());
        consultas.put(hoy, new ArrayList<>());

        while(scan.hasNext()) {
            token = scan.next();

            // Para poder simular el final de fichero en debug
            if (token.equals("#END#")) {
                break;
            }

            if(token.equals("<text>")) {
                //Nuevo día. Nueva lista de palabras vacía y consultas vacía
                hoy++;
                dias.addLast(new LinkedList<>());
                consultas.put(hoy, new ArrayList<>());
                continue;
            }
            if(token.equals("</text>")) {
                //Final del día
                continue;
            }
            if(token.equals("<top")) {
                //Nueva consulta en el día actual
                int n = scan.nextInt();
                scan.next();    // Ignorar el "/>"
                ArrayList<Integer> list = consultas.get(hoy);
                list.add(n);
                continue;
            }
            if(token.length() < 4) {
                //Palabra corta. No se añade
                continue;
            }
            //Palabra larga. Se añade al día actual
            dias.get(hoy).addLast(token);
        }
        //Incrementa el número de días para flexibilizar el código
        dias.addLast(new LinkedList<>());
        hoy++;

        //Mapa de palabras con el contador de apariciones
        HashMap<String,Integer> cnt = new HashMap<>();

        //Recorrer los días
        for(int i = 0; i < hoy; i++) {
            //Incrementa el contador de palabras acumulado
            for(String j : dias.get(i)) {
                cnt.put(j, cnt.getOrDefault(j, 0) + 1);
            }
            //A partir del 7o dia, hay que restar las palabras de la semana anterior
            if(i >= 7) {
                for(String j : dias.get(i-7)) {
                    cnt.put(j, cnt.getOrDefault(j, 0) - 1);
                    if(cnt.get(j) == 0) {
                        cnt.remove(j);
                    }
                }
            }
            //Ejecutar las consultas del día
            for(int j : consultas.get(i)) {
                System.out.println("<top " + j + ">");
                runquery(cnt,j);
                System.out.println("</top>");
            }
        }


    }
}

