package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer la ciudad
// Mostrar su localidad más cercana

import java.util.Scanner;


public class HvertSkalMaeta {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la ciudad
        String ciudad = sc.nextLine();

        switch (ciudad) {
            case "Reykjavik","Kopavogur","Hafnarfjordur","Reykjanesbaer","Gardabaer","Mosfellsbaer","Arborg","Akranes","Seltjarnarnes" :
                System.out.println("Reykjavik");
                break;
            case "Akureyri","Fjardabyggd","Mulathing":
                System.out.println("Akureyri");
                break;
        }

        sc.close();
    }
}

