package Others.Easy.Puntuacion_2_0_a_2_9._2_2;

/**
 * Crear un Set de cartas de bajo nivel
 * para cada mazo de 6 cartas verificar si contiene alguna de las cartas de bajo nivel
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class LowSkillDecks {

    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);

       int numLR = sc.nextInt();
       sc.nextLine();
       HashSet<String> lowRange = new HashSet<String>();

       //Leer las cartas de bajo nivel
       for (int i=0; i<numLR;i++) {
           String nom = sc.nextLine();
           lowRange.add(nom);
       }

       int numMazos = sc.nextInt();
       sc.nextLine();
       for (int i=0; i<numMazos; i++) {
           boolean esBajoNivel = false;
           for (int j=0; j<6;j++) {
               String nom = sc.nextLine();
               if (lowRange.contains(nom))
                   esBajoNivel = true;
           }

           if (esBajoNivel) System.out.println("Hæfileikalaust Drasl");
           else System.out.println("Fínn Stokkur");
       }


    }
}