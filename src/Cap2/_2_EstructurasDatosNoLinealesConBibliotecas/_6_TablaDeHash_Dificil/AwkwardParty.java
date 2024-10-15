package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._6_TablaDeHash_Dificil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// Guardar los idiomas de cada invitado en un HashMap <Integer, List<Integer>> con el idioma y la posición que ocupa
// Al final, recorrer el HashMap y, para cada invitado, recorrer su lista y quedarnos con la mínima distancia entre dos elementos consecutivos
// La distancia mínima inicial es el número de invitados

public class AwkwardParty {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        HashMap<Integer, ArrayList<Integer>> idiomas = new HashMap<Integer, ArrayList<Integer>>();

        int numInvitados = scan.nextInt();
        //Leer cada una de los invitados
        int posicion = 0;
        while (posicion < numInvitados) {
            int idioma = scan.nextInt();
            if (!idiomas.containsKey(idioma)) {
                idiomas.put(idioma, new ArrayList<Integer>());
            }
            idiomas.get(idioma).add(posicion);
            posicion++;
        }

        //Recorrer el HashMap y, para cada invitado, recorrer su lista y quedarnos con la mínima distancia entre dos elementos consecutivos
        int distanciaMinima = numInvitados;
        for (ArrayList<Integer> posiciones : idiomas.values()) {
            for (int i = 1; i < posiciones.size(); i++) {
                distanciaMinima = Math.min(distanciaMinima, posiciones.get(i) - posiciones.get(i - 1));
            }
        }

        //Mostrar la distancia mínima
        System.out.println(distanciaMinima);

    }

}

