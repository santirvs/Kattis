package Cap2._2_EstructurasDatosConBibliotecas._12_ListaColaDeque;

// Hacer una lista de días y que cada día sea una lista con las palabras de un texto y su número de apariciones
// Al empezar un día, se añaden las palabras del día anterior a la lista de palabras del día actual
// Si estamos más allá del día 7, se restarán (o eliminarán) las palabras del día 1

// Caso 2:WA -->

import java.io.*;
import java.util.*;

public class TrendingTopic_WA {

    static class FastIO {
        BufferedReader in;
        PrintWriter out;
        private boolean eof;

        FastIO() {
            eof = false;
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        }

        int nextInt() throws Exception {
            return Integer.parseInt(in.readLine());
        }

        String nextLine() throws Exception {
            return in.readLine();
        }

        String next()  {
            StringBuilder s = new StringBuilder();
            while (true) {
                int c = 0;
                try {
                    c = in.read();
                } catch (IOException e) {
                    eof = true;
                }
                if (Character.isWhitespace(c) || c == -1) {
                    break;
                }
                s.append((char) c);
            }
            return s.toString();
        }

        boolean hasNext() {
            return !eof;
        }


        void print(String s) {
            out.print(s);
            out.flush();
        }

        void print(int i) {
            this.print("" + i);
        }

        void println(String s) {
            out.println(s);
            out.flush();
        }

        void println(int i) {
            this.println("" + i);
        }
    }

    static class Entrada implements Comparable<Entrada> {
        String palabra;
        int numApariciones;

        @Override
        public int compareTo(Entrada o) {
            if (numApariciones == o.numApariciones) {
                return palabra.compareTo(o.palabra);
            } else {
                return o.numApariciones - numApariciones;
            }
        }
    };


    public static void main(String[] args) throws Exception {
        //FastIO io = new FastIO();
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        //Línea a línea, interpretando el comando o el texto

        int dia = 0;
        LinkedList<Map<String, Integer>> palabrasDias = new LinkedList<>();
        Map<String, Integer> palabrasDia= new HashMap<>() ;
        while (scan.hasNext()) {
            //Procesar la línea
            //Si es un comando, hacer lo que toque
            //Si es un texto, añadir las palabras a la lista de palabras del día actual

            String linea = scan.nextLine();
            if (linea.equals("<text>")) {
                linea = scan.nextLine();
                palabrasDia = new HashMap<>();
                if (palabrasDias.size() > 0) {
                    //Clonar la lista anterior
                    Map<String, Integer> palabrasDiaAnterior = palabrasDias.getLast();
                    for (Map.Entry<String, Integer> entrada : palabrasDiaAnterior.entrySet()) {
                        palabrasDia.put(entrada.getKey(), entrada.getValue());
                    }
                }
                while (!linea.equals("</text>")) {
                    //Añadir las palabras a la lista de palabras del día actual
                    for (String palabra : linea.split(" ")) {
                        //Añadir la palabra a la lista de palabras del día actual
                        if (palabra.length() >= 4) {
                            //Añadir la palabra a la lista de palabras del día actual
                            if (palabrasDia.containsKey(palabra)) {
                                palabrasDia.put(palabra, palabrasDia.get(palabra) + 1);
                            } else {
                                palabrasDia.put(palabra, 1);
                            }
                        }
                    }
                    linea = scan.nextLine();
                }
                dia++;
                if (dia > 6) {
                    //Restar o eliminar las palabras del día 1
                    for (Map.Entry<String, Integer> entrada : palabrasDias.get(0).entrySet()) {
                        //System.out.println("dia " + dia + " palabra " + entrada.getKey() + " " + entrada.getValue());
                        //Es posible que la palabra no esté en el día actual en el caso que hace más de 7 días que no se repite
                        if (palabrasDia.containsKey(entrada.getKey()) ) {
                            int numVeces = palabrasDia.get(entrada.getKey()).intValue() - entrada.getValue().intValue();
                            if (numVeces <= 0) {
                                //System.out.println("Eliminando " + entrada.getKey());
                                palabrasDia.remove(entrada.getKey());
                            } else {
                                palabrasDia.put(entrada.getKey(), numVeces);
                            }
                        }
                    }
                    //Eliminnar la lista de palabras de hace 7 días
                    palabrasDias.remove(0);
                }
                //Añadir las palabras del día actual a la lista de palabras del día anterior
                palabrasDias.addLast(palabrasDia);

            } else if (linea.startsWith("<top ")) {
                //Es un comando!!!
                //Obtener el número de palabras a mostrar
                String[] partes = linea.split(" ");
                int numPalabras = Integer.parseInt(partes[1]);

                //Obtener las palabras más repetidas
                ArrayList<Entrada> palabrasMasRepetidas = new ArrayList<>();
                for (Map.Entry<String, Integer> entrada : palabrasDia.entrySet()) {
                    Entrada e = new Entrada();
                    e.palabra = entrada.getKey();
                    e.numApariciones = entrada.getValue();
                    palabrasMasRepetidas.add(e);
                }

                //Ordenar las palabras por número de apariciones
                Collections.sort(palabrasMasRepetidas);
                //Mostrar las palabras
                System.out.println("<top " + numPalabras + ">");
                for (int i = 0; i < palabrasMasRepetidas.size() && (i < numPalabras || palabrasMasRepetidas.get(i).numApariciones == palabrasMasRepetidas.get(i-1).numApariciones); i++) {
                    System.out.println(palabrasMasRepetidas.get(i).palabra + " " + palabrasMasRepetidas.get(i).numApariciones);
                }
                System.out.println("</top>");
            }

        }

    }
}
