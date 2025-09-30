package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el mensaje escrito en un teclado ABCDEF
// Traducir a lo que quería realmente escribir en un teclado QWERTY
// Definir dos mapas de teclas y buscar la posición de cada caracter en ABC y traducirlo por el caracter de la posicion en QWERTY

import java.util.Scanner;

public class Qwerty {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Definir los mapas
        String mapaABC    = " abcdefghijklmnopqrstuvwxyz";
        String mapaQWERTY = " qwertyuiopasdfghjklzxcvbnm";

        //Leer la longitud y la cadena
        sc.nextLine(); // Ignorar la longitud
        String mensaje = sc.nextLine();

        for (int i=0; i < mensaje.length(); i++) {
            char c = mensaje.charAt(i);
            int pos = mapaABC.indexOf(c);
            System.out.print(mapaQWERTY.charAt(pos));
        }
        System.out.println();
    }
}

