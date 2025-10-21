package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer la secuencia de entrada
// Buscar todas las ocurrencias de ":) ;) :-) o ;-)

import java.util.Scanner;


public class SMIL {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la secuencia de entrada
        String entrada = sc.nextLine();

        // Buscar todas las ocurrencias de ":) ;) :-) o ;-)"
        String[] smilies = {":)", ";)", ":-)", ";-)"};
        for (String smilie : smilies) {
            int index = 0;
            while ((index = entrada.indexOf(smilie, index)) != -1) {
                System.out.println(index);
                index += smilie.length();
            }
        }
        sc.close();
    }
}

