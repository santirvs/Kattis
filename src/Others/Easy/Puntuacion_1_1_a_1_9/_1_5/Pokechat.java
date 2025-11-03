package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el String y guardarlo como array de char
// Leer el String de posiciones
// Tratar el String de 3 en 3 caracteres
//     Convertir a número
//     Obtener el carácter del String correspondiente al número
// Finalmente, mostrar el string resultante

import java.util.Scanner;


public class Pokechat {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Leer la cadena
        String cadena = sc.nextLine();
        //Leer el mensaje
        String mensaje = sc.nextLine();

        StringBuilder resultado = new StringBuilder();

        //Tratar el mensaje
        for (int i=0; i<mensaje.length(); i+=3) {
            //Convertir 3 caracteres a número
            String numero = "" + mensaje.charAt(i) + mensaje.charAt(i+1) + mensaje.charAt(i+2);
            int index = Integer.parseInt(numero);

            //Obtener el caracter de la cadena original y añadirlo al resultado
            resultado.append(cadena.charAt(index-1));
            }

        // Mostrar resultado
        System.out.println(resultado.toString());

        sc.close();
    }
}

