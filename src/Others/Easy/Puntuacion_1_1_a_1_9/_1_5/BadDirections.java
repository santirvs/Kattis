package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el numero de casos
// Para cada caso, leer el incremento y el número
// Sumar el número a cada cifra sin acarreo

import java.util.Scanner;

public class BadDirections {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Leer el número de casos
        int numCasos = sc.nextInt();

        //Tratar los casos
        while (numCasos-- >0) {
            int incremento = sc.nextInt();
            String numero = sc.nextLine().trim();
            StringBuilder sb = new StringBuilder();

            //incrementar cada dígito
            for (int i=0; i<numero.length();i++) {
                int valor = numero.charAt(i)-'0';
                valor += incremento;
                valor = valor%10;
                sb.append(valor);
            }

            //Mostrar el resultado
            System.out.println(sb.toString());
        }

        sc.close();
    }
}

