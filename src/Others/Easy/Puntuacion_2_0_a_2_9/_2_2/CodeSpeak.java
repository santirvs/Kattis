package Others.Easy.Puntuacion_2_0_a_2_9._2_2;



import java.io.IOException;
import java.util.Scanner;

public class CodeSpeak {

    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);

       sc.nextLine();   //Ignorar el número de palabras

        String linea = sc.nextLine();

        boolean ultimaEsVocal = false;
        for (int i=0; i<linea.length(); i++) {
            char c = linea.charAt(i);
            if (esVocal(c)) {
                if (!ultimaEsVocal) {
                    System.out.print("ib");
                }
                ultimaEsVocal = true;
            } else {
                ultimaEsVocal = false;
            }
            System.out.print(c);
        }
        System.out.println();

    }

    public static boolean esVocal(char c) {
        char cm = Character.toLowerCase(c);
        return (cm == 'a' || cm == 'e' || cm == 'i' || cm == 'o' || cm == 'u');
    }
}