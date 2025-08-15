package Cap3._2_BusquedaCompleta._10_Josefo;

// No se trata de un problema de Josefo puro (determinar el último superviviente),
// sino de ir repartiendo los nombres de personas en dos grupos separados.

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EenyMeeny {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        // Leer la frase
        String[] frase = scan.nextLine().trim().split(" ");
        int numPersonas = scan.nextInt();
        scan.nextLine();

        // Leer los nombres de las personas
        List<String> nombres = new ArrayList<>();
        for (int i = 0; i < numPersonas; i++) {
            nombres.add(scan.nextLine().trim());
        }

        // Inicializar los grupos
        List<String> grupo1 = new ArrayList<>();
        List<String> grupo2 = new ArrayList<>();

        // Repartir los nombres en dos grupos según la frase
        boolean turnoGrupo1 = true; // Empezamos con el grupo 1
        int indice = 0;
        while (nombres.size() > 0) {
            // Calcular el índice basado en la longitud de la frase
            indice = (indice + frase.length - 1) % nombres.size(); // Seleccionamos el índice basado en la longitud de la frase
            if (turnoGrupo1) {
                grupo1.add(nombres.get(indice));
            } else {
                grupo2.add(nombres.get(indice));
            }
            nombres.remove(indice); // Eliminar el nombre seleccionado
            turnoGrupo1 = !turnoGrupo1; // Cambiar de grupo
        }

        // Imprimir los grupos
        System.out.println(grupo1.size());
        for (String nombre : grupo1) {
            System.out.println(nombre);
        }
        System.out.println(grupo2.size());
        for (String nombre : grupo2) {
            System.out.println(nombre);
        }


    }

}
