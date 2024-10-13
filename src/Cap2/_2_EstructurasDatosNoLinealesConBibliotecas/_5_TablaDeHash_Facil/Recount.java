package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._5_TablaDeHash_Facil;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

// Leer los votos y apuntarlos en un HashMap
// Al final, recorrer el HashMap y ver si hay un ganador o si hay empate


public class Recount {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String voto = scan.nextLine();

        HashMap<String, Integer> recuento = new HashMap<String, Integer>();

        while (!voto.equals("***")) {

            if (recuento.containsKey(voto)) {
                //Incrementar los votos del candidato
                recuento.put(voto, recuento.get(voto) + 1);
            } else {
                //Añadir el candidato al recuento con su primer voto
                recuento.put(voto, 1);
            }
            //Siguiente voto
            voto = scan.nextLine();
        }

        //Recorrer el HashMap para ver si hay un ganador o si hay empate
        int maxVotos = 0;
        String ganador = "";
        boolean empate = false;
        for (String candidato : recuento.keySet()) {
            if (recuento.get(candidato) > maxVotos) {
                maxVotos = recuento.get(candidato);
                ganador = candidato;
                empate = false;
            } else if (recuento.get(candidato) == maxVotos) {
                empate = true;
            }
        }

        if (empate) {
            System.out.println("Runoff!");
        } else {
            System.out.println(ganador);
        }
    }

}

