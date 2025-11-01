package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el primer password
// Leer el segundo password
// Comparar caracter a caracter si son iguales
// Por cada caracter diferente multiplicar por 2
// Imprimir el resultado


import java.util.Scanner;


public class DoublePassword {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el primer password
        String password1 = sc.nextLine();
        // Leer el segundo password
        String password2 = sc.nextLine();

        int combinaciones = 1;

        // Comparar caracter a caracter
        for (int i = 0; i < password1.length(); i++) {
            if (password1.charAt(i) != password2.charAt(i)) {
                combinaciones *= 2;
            }
        }
        // Imprimir el resultado
        System.out.println(combinaciones);


        sc.close();
    }
}

