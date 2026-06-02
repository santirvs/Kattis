package Others.Easy.Puntuacion_2_0_a_2_9._2_1;

// El problema se puede reducir a buscar uno de estos dos casos:
//   - dos letras iguales seguidas:  ej: aa
//   - la misma letra dos posiciones más adelante: ej: aXa
// Cualquier palíndromo contiene uno de esos dos casos
// Previamente, habrá que sanear la entrada eliminando lo que no sea caracter y convirtiendo a minúsculas

import java.util.Scanner;

public class AntiPalindrome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String entrada = sc.nextLine();

        //Pasar a minúsculas
        entrada = entrada.toLowerCase();
        StringBuilder sb = new StringBuilder();

        //Quedarnos sólo con los caracteres
        for (char c : entrada.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            }
        }

        entrada = sb.toString();

        //Buscar uno de los dos casos
        boolean esPalindromo = false;
        for (int i = 0; i < entrada.length() - 1 && !esPalindromo; i++) {
            if (entrada.charAt(i) == entrada.charAt(i + 1) ||
                    i < entrada.length() - 2 && entrada.charAt(i) == entrada.charAt(i + 2)) {
                esPalindromo = true;
            }
        }

        //Mostrar el resultado
        if (esPalindromo)
            System.out.println("Palindrome");
        else
            System.out.println("Anti-palindrome");

    }
}
