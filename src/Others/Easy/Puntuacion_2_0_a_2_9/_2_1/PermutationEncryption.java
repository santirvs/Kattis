package Others.Easy.Puntuacion_2_0_a_2_9._2_1;

// Aplicar el cifrado a cada bloque, rellenando con espacios al final

import java.util.Scanner;

public class PermutationEncryption {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tamanyoBloque = sc.nextInt();

        while (tamanyoBloque > 0) {
            //Leer la clave
            int[] clave = new int[tamanyoBloque];
            for (int i=0; i<tamanyoBloque;i++) {
                clave[i] = sc.nextInt();
            }
            sc.nextLine();
            String mensaje = sc.nextLine();

            StringBuilder sb = new StringBuilder();
            //Leer los bloques
            int posBloque =0;
            while (posBloque < mensaje.length() ) {
                StringBuilder bloque = new StringBuilder();
                if (posBloque+tamanyoBloque >= mensaje.length()) {
                    bloque.append(mensaje.substring(posBloque));
                    //Añade espacios
                    while (bloque.length() < tamanyoBloque) {
                        bloque.append(" ");
                    }
                } else {
                    bloque.append(mensaje.substring(posBloque, posBloque + tamanyoBloque));
                }


                char[] bloqueEncriptado = new char[tamanyoBloque];
                for (int i=0; i<tamanyoBloque;i++){
                    bloqueEncriptado[i] = bloque.charAt(clave[i]-1);
                }

                sb.append(bloqueEncriptado);
                posBloque += tamanyoBloque;
            }

            System.out.println("'" + sb.toString() + "'");


            //Siguiente caso
            tamanyoBloque = sc.nextInt();
        }
    }
}
