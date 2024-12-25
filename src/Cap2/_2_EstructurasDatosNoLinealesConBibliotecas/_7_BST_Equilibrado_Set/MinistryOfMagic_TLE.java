package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._7_BST_Equilibrado_Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Leer los candidatos y sus preferencias
// Cada partido se guarda en un HashMao
// Las preferencias de cada partido se guardan en una lista
// Se realiza una votación por cada candidato, votando el primer partido de su lista de preferencias
// El partido menos votado se elimina (se elimina de la lista de preferencias de todos los candidatos)

// Caso de prueba #3: RTE - Ojo que pueden haber más candidatos que candidatos!!!
// Caso de prueba #4: TLE - Cambio a fast input/output. Sigue con TLE
//       C -> numCandidatos :  hasta 10.000
//       P -> numPartidos : hasta 100
//       V -> votos : hasta 10^6
//       Total de votos: hasta 10^6 * 100 = 10^8
//   Como agilizar el proceso???
//     - El candidato a votar es el primero de la lista (acceso directo)
//     - Se votarán un máximo de 100 candidatos, no de 10.000  (OPTIMIZACIÓN!!!)
//     - Se puede eliminar el candidato menos votado accediendo a un HashMap en lugar de una lista (OPTIMIZACIÓN!!!)

class Partido {
    int nomPartido;
    int votos;
    List<Integer> candidatos;
    boolean eliminado;

    public Partido(int nomPartido, int votos) {
        this.nomPartido = nomPartido;
        this.votos = votos;
        this.candidatos = new ArrayList<>();
    }
}

public class MinistryOfMagic_TLE {


    public static void main(String[] args) throws IOException {

        //Scanner scan = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String linea[] = in.readLine().split(" ");
        //Leer numCandidatos y numPartidos
        int numCandidatos = Integer.parseInt(linea[0]);
        int maxCandidatos = numCandidatos;
        int numPartidos = Integer.parseInt(linea[1]);

        //Mapa donde me guardo los partidos
        HashMap<Integer, Partido> partidos = new HashMap<>();

        //Candidatos eliminados
        HashSet<Integer> candidatosEliminados = new HashSet<>();

        for (int i = 1; i <= numPartidos; i++) {
            String lineaPartido[] = in.readLine().split(" ");
            int numVotosPartido = Integer.parseInt(lineaPartido[0]);
            Partido partido = new Partido(i, numVotosPartido);

            //Leer las preferencias de cada partido
            for (int j = 0; j < numCandidatos; j++) {
                int candidato = Integer.parseInt(lineaPartido[j+1]);
                partido.candidatos.add(candidato);
            }
            //Añado el partido al HashMap
            partidos.put(i, partido);
        }

        //Empiezan las votaciones
        while (numCandidatos > 0) {
            //Reiniciar los votos
            int[] votos = new int[maxCandidatos+1];
            int numVotos = 0;
            int maxVotos = 0;
            int candidatoGanador = -1;

            //Ronda de votaciones
            for (int i = 1; i <= numPartidos; i++) {
                //De cada partido cojo el candidato preferido
                Partido partido = partidos.get(i);
                Integer preferido = partido.candidatos.get(0);
                //Añado los votos del partido al candidato preferido
                votos[preferido]+=partido.votos;
                //Actualizar el número de votos
                numVotos += partido.votos;
                //Actualizar el máximo de votos
                if (votos[preferido] > maxVotos) {
                    maxVotos = votos[preferido];
                    candidatoGanador = preferido;
                }
                else if (votos[preferido] == maxVotos) {
                    candidatoGanador = -1;
                }
            }

            //Hay ganador por mayoría absoluta?
            if (candidatoGanador != -1 && maxVotos > numVotos/2) {
                System.out.println(candidatoGanador);
                break;
            }

            //No hay ganador, eliminar el candidato menos votado
            int minVotos = Integer.MAX_VALUE;
            int candidatoMenosVotado = -1;
            for (int i = 1; i <= maxCandidatos; i++) {
                if (votos[i] < minVotos && !candidatosEliminados.contains(i)) {
                    minVotos = votos[i];
                    candidatoMenosVotado = i;
                }
            }
            candidatosEliminados.add(candidatoMenosVotado);

            System.err.println("Partido más votado: " + candidatoGanador);
            System.err.println("Total votos: " + numVotos + " Votos partido ganador: " + maxVotos);
            System.err.println("Eliminado: " + candidatoMenosVotado + " con " + minVotos + " votos");

            //Eliminar el candidato menos votado de la lista de preferencias de los demás candidatos
            for (int i = 1; i <= numPartidos; i++) {
                partidos.get(i).candidatos.remove((Object)candidatoMenosVotado);
            }
            numCandidatos--;
        }

    }


}
