package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

/**
 * Asegurar que cada mayúscula (función) empieza en un múltiplo de 4
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class NOP {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String programa = sc.nextLine();

        int pc = 0;
        int index = 0;

        while (index < programa.length()) {
            //Leer una instruccion
            index++;
            pc++;
            //Leer los parámetros
            while (index < programa.length() && programa.charAt(index) >= 'a' && programa.charAt(index) <= 'z') {
                index++;
                pc++;
            }
            if (index < programa.length() && pc % 4 != 0) {
                pc += 4 - pc % 4;
            }
        }

        System.out.println(pc - index);


        sc.close();
    }
}

