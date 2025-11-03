package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el número de personajes, número de atributos y número de preguntas
// Leer los de los N personajes
// Leer cada una de las preguntas (atributo y respuesta)
// Ir eliminando los personajes que no cumplan con el atributo y la respuesta

// Finalmente imprimir: unique y el número de personaje
// o bien "ambiguous" con la cantidad de personajes posibles

import java.util.Arrays;
import java.util.Scanner;


public class GuessWho {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el número de personajes, número de atributos y número de preguntas
        int numPersonajes = sc.nextInt();
        int numAtributos = sc.nextInt();
        int numRespuestas = sc.nextInt();
        sc.nextLine();
        // Leer los de los N personajes
        String[] personajes = new String[numPersonajes];
        for (int i=0; i<numPersonajes; i++) {
            personajes[i] = sc.nextLine();
        }
        //Define el array de personajes posibles (inicialmente, todos)
        boolean[] posibles = new boolean[numPersonajes];
        Arrays.fill(posibles, true);

        // Leer cada una de las preguntas (atributo y respuesta)
        for (int i=0; i< numRespuestas; i++) {
            int atributo = sc.nextInt();
            char valor = sc.next().charAt(0);
            // Ir eliminando los personajes que no cumplan con el atributo y la respuesta
            for (int personaje=0; personaje < numPersonajes; personaje++) {
                if (posibles[personaje] && personajes[personaje].charAt(atributo-1) != valor) {
                    posibles[personaje]=false;
                }
            }
        }

        // Buscar los personajes candidatos
        int candidatos=0;
        int candidatoElegido = 0;
        for (int personaje=0; personaje < numPersonajes; personaje++){
            if (posibles[personaje]) {
                candidatos++;
                candidatoElegido = personaje + 1;
            }
        }

        // Finalmente imprimir: unique y el número de personaje
        // o bien "ambiguous" con la cantidad de personajes posibles
        if (candidatos == 1) {
            System.out.println("unique");
            System.out.println(candidatoElegido);
        } else {
            System.out.println("ambiguous");
            System.out.println(candidatos);
        }

        sc.close();
    }
}

