package Others.Trivial.Puntuacion_1_1_a_1_5._1_4;

// Leer direcciones hasta encontrar una q (quit)
// Cada direccion debe añadirse a un String (direccion) y a otro String (calle, numero)

import java.util.Scanner;

public class HomeAddresses {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StringBuilder listaDirecciones = new StringBuilder();
        StringBuilder listaParticulas = new StringBuilder();

        listaDirecciones.append("[");
        listaParticulas.append("[");

        //Leer las líneas hasta encontrar una q
        String linea = sc.nextLine();
        boolean primera = true;
        while (!linea.equals("q")) {

            //Separador excepto para el primer caso
            if (primera) primera = false;
            else {
                listaDirecciones.append(", ");
                listaParticulas.append(", ");
            }

            String[] partes = linea.split(" ");
            listaDirecciones.append("'" + partes[0] + " " + partes[1] + "'");
            listaParticulas.append("('" + partes[0] + "', '" + partes[1] + "')");

            //Siguiente línea
            linea = sc.nextLine();
        }

        listaDirecciones.append("]");
        listaParticulas.append("]");

        //Imprimir las listas
        System.out.println(listaDirecciones.toString());
        System.out.println(listaParticulas.toString());

        sc.close();
    }
}

