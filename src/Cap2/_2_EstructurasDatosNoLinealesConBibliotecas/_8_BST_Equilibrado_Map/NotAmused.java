package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._8_BST_Equilibrado_Map;

import java.io.*;
import java.util.*;

public class NotAmused {

    static class Visitante {
        String nombre;
        int entrada;
        float coste;

        public Visitante(String nombre, int entrada) {
            this.nombre = nombre;
            this.entrada = entrada;
            this.coste = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        TreeMap<String, Visitante> visitantes = new TreeMap<>();
        int numDia = 0;

        while (scan.hasNext()) {
            String[] partes = scan.nextLine().split(" ");
            if (partes[0].equals("OPEN")) {
                //Reset del mapa de visitantes e incrementar el dia
                visitantes = new TreeMap<>();
                numDia++;
            } else if (partes[0].equals("ENTER")) {
                String nombre = partes[1];
                int hora = Integer.parseInt(partes[2]);
                //Añadir el visitante o actualizar la hora de entrada
                if (visitantes.containsKey(nombre)) {
                    visitantes.get(nombre).entrada = hora;
                } else {
                    visitantes.put(nombre, new Visitante(nombre, hora));
                }
            } else if (partes[0].equals("EXIT")) {
                //Calcular el coste del visitante y sumarlo al coste total
                String nombre = partes[1];
                int hora = Integer.parseInt(partes[2]);
                Visitante visitante = visitantes.get(nombre);
                visitante.coste += (hora - visitante.entrada) * 0.1f;
            } else if (partes[0].equals("CLOSE")) {
                System.out.println("Day " + numDia);
                for (Map.Entry<String, Visitante> entry : visitantes.entrySet()) {
                    Visitante visitante = entry.getValue();
                    System.out.printf("%s $%.2f\n",visitante.nombre,visitante.coste);
                }

                System.out.println();
            }


        }
    }

}
