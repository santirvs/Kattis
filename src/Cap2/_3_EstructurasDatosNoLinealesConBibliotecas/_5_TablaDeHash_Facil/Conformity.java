package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._5_TablaDeHash_Facil;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

// Leer los cursos de cada estudiante, ordenarlos y convertirlos en un String para añadirlos en un HashMap
// Al final, recorrer el HashMap y ver si hay un ganador o si hay empate


public class Conformity {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int numEstudiantes = scan.nextInt();

        HashMap<String, Integer> recuento = new HashMap<String, Integer>();

        for (int i=0; i<numEstudiantes; i++) {

            List<Integer> cursos = new ArrayList<>();
            for (int j=0; j<5; j++) {
                int curso = scan.nextInt();
                cursos.add(curso);
            }
            cursos.sort(null);
            String cursosStr = cursos.toString();
            if (recuento.containsKey(cursosStr)) {
                //Incrementar los votos del candidato
                recuento.put(cursosStr, recuento.get(cursosStr) + 1);
            } else {
                //Añadir el candidato al recuento con su primer voto
                recuento.put(cursosStr, 1);
            }
        }

        //Recorrer el HashMap para ver cuantos estudiantes tienen el mismo horario
        int maxVotos = 0;
        int numEstudiantesConMaxVotos = 0;
        for (String candidato : recuento.keySet()) {
            if (recuento.get(candidato) > maxVotos) {
                maxVotos = recuento.get(candidato);
                numEstudiantesConMaxVotos = maxVotos;
            }
            else if (recuento.get(candidato) == maxVotos) {
                numEstudiantesConMaxVotos += maxVotos;
            }
        }

        System.out.println(numEstudiantesConMaxVotos);
    }

}

