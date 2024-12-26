package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._8_BST_Equilibrado_Map;

import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

// TestCase #2: RTE --> Verificar que el tipo de coche existe en el mapa de coches, sino es inconsistente

public class AdministrativeDifficulties {

    static class Coche {
        String nombre;
        int precio;
        int costePickUp;
        int costeKm;

        public Coche(String nombre, int precio, int costePickUp, int costeKm) {
            this.nombre = nombre;
            this.precio = precio;
            this.costePickUp = costePickUp;
            this.costeKm = costeKm;
        }
    }

    static class Espia {
        String nombre;
        int dinero;
        Coche coche;
        boolean inconsistente;

        public Espia(String nombre, Coche coche) {
            this.nombre = nombre;
            this.dinero = 0;
            this.coche = coche;
            this.inconsistente = false;
        }
    }

    public static void main(String[] args) throws IOException {
        //Scanner scan = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int numCasos = Integer.parseInt(in.readLine());
        while (numCasos > 0) {
            String[] partes = in.readLine().split(" ");
            int numCoches = Integer.parseInt(partes[0]);
            int numEventos = Integer.parseInt(partes[1]);

            Map<String, Coche> coches = new HashMap<>();
            Map<String, Espia> espias = new HashMap<>();

            while (numCoches > 0) {
                String[] partesCoche = in.readLine().split(" ");
                String nombre = partesCoche[0];
                int precio = Integer.parseInt(partesCoche[1]);
                int costePickUp = Integer.parseInt(partesCoche[2]);
                int costeKm = Integer.parseInt(partesCoche[3]);

                coches.put(nombre, new Coche(nombre, precio, costePickUp, costeKm));

                numCoches--;
            }

            //Los eventos llegan en orden cronológico
            while (numEventos > 0) {
                String[] partesEvento = in.readLine().split(" ");
                String nombreEspia = partesEvento[1];
                String tipoEvento = partesEvento[2];

                if (tipoEvento.equals("p")) { //PickUp
                    String nombreCoche = partesEvento[3];
                    if (espias.containsKey(nombreEspia)) {
                        //Recupero el espía. Si es inconsistente, continuo
                        Espia espia = espias.get(nombreEspia);
                        //Si ya tiene coche, es inconsistente
                        if (espia.coche != null) {
                            espia.inconsistente = true;
                        }
                        if (!espia.inconsistente) {
                            //Si no tiene coche, se le asigna el coche y se apunta su coste de pickUp
                            if (coches.containsKey(nombreCoche)) {
                                Coche coche = coches.get(nombreCoche);
                                espia.coche = coche;
                                espia.dinero += coche.costePickUp;
                            } else {
                                espia.inconsistente = true;
                            }
                        }
                    } else {
                        //Nuevo espía, se da de alta con el coche y se apunta su coste de pickUp
                        Espia espia;
                        if (coches.containsKey(nombreCoche)) {
                            espia = new Espia(nombreEspia, coches.get(nombreCoche));
                            espia.dinero += espia.coche.costePickUp;
                        }
                        else {
                            espia = new Espia(nombreEspia, null);
                            espia.inconsistente = true;
                        }
                        espias.put(nombreEspia, espia);
                    }
                }
                else if (tipoEvento.equals("r")) { //Return
                    int numKms = Integer.parseInt(partesEvento[3]);
                    if (espias.containsKey(nombreEspia)) {
                        //Recupero el espía. Si es inconsistente, continuo
                        Espia espia = espias.get(nombreEspia);
                        //Si no tiene coche, es inconsistente
                        if (espia.coche == null) {
                            espia.inconsistente = true;
                        }
                        if (!espia.inconsistente) {
                            //Si tiene coche, se le apunta el coste de los kilómetros
                            //y se le quita el coche
                            espia.dinero += numKms * espia.coche.costeKm;
                            espia.coche = null;
                        }
                    } else {
                        //Nuevo espía, se da de alta sin coche e inconsistente
                        Espia espia = new Espia(nombreEspia, null);
                        espia.inconsistente = true;
                        espias.put(nombreEspia, espia);
                    }
                }
                else if (tipoEvento.equals("a")) { //Accident
                    int severidad = Integer.parseInt(partesEvento[3]);
                    if (espias.containsKey(nombreEspia)) {
                        //Recupero el espía.
                        Espia espia = espias.get(nombreEspia);
                        //Si no tiene coche, es inconsistente
                        if (espia.coche == null) {
                            espia.inconsistente = true;
                        }
                        if (!espia.inconsistente) {
                            //Si tiene coche, se le apunta el coste del accidente
                            espia.dinero += Math.ceil(severidad * espia.coche.precio / 100.0);
                        }
                    } else {
                        //Nuevo espía, se da de alta sin coche e inconsistente
                        Espia espia = new Espia(nombreEspia, null);
                        espia.inconsistente = true;
                        espias.put(nombreEspia, espia);
                    }
                }

                numEventos--;
            }

            //Ya se han procesado todos los eventos.
            //Mostrar los resultados
            TreeSet<Espia> espiasOrdenados = new TreeSet<>(new Comparator<Espia>() {
                @Override
                public int compare(Espia o1, Espia o2) {
                        return o1.nombre.compareTo(o2.nombre);
                }
            });

            for (Espia espia: espias.values()) {
                espiasOrdenados.add(espia);
            }

            for (Espia espia: espiasOrdenados) {
                if (espia.inconsistente || espia.coche != null) {
                    out.println(espia.nombre + " INCONSISTENT");
                } else {
                    out.println(espia.nombre + " " + espia.dinero);
                }
            }


            numCasos--;
        }

        out.flush();
        out.close();
        in.close();
    }
}