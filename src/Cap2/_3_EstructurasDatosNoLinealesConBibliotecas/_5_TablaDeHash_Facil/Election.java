package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._5_TablaDeHash_Facil;


import java.util.*;

// Leer los candidatos y sus partidos
// Podemos entender que el partido de un candidato independiente es "independiente"
// Cargar los candidatos en un HashMap
// Leer los votos y contabilizarlos solo si el candidato existe en el HashMap
// Al final, recorrer el HashMap y ver si hay un ganador o si hay empate

public class Election {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        HashMap<String, String> candidatos = new HashMap<>();
        HashMap<String, Integer> recuento = new HashMap<>();

        int numCandidatos = scan.nextInt();
        scan.nextLine();
        //Leer los candidatos y sus partidos
        for (int i=0; i<numCandidatos; i++) {
            String candidato = scan.nextLine();
            String partido = scan.nextLine();
            candidatos.put(candidato, partido);
            recuento.put(candidato, 0);
        }

        //Leer los votos y contabilizarlos
        int numVotos = scan.nextInt();
        scan.nextLine();
        for (int i=0; i<numVotos; i++) {
            String voto = scan.nextLine();
            if (candidatos.containsKey(voto)) {
                recuento.put(voto, recuento.get(voto) + 1);
            }
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

        //Imprimir el resultado
        if (empate) {
            System.out.println("tie");
        } else {
            System.out.println(candidatos.get(ganador));
        }


    }

}

