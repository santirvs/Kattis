package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

/**
 * Leer el número, y calcular si es happy o no
 * Para evitar un bucle infinito, guardarnos los números ya calculados en un Set
 */


import java.util.Scanner;

public class HappyHappyPrimePrime {

    static boolean[] esPrimo = new boolean[10001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numCasos = sc.nextInt();
        calcularPrimos(10000);

        while (numCasos-- > 0) {
            int numCaso = sc.nextInt();
            int numero = sc.nextInt();

            if (numero == 1 || !esPrimo[numero]) System.out.println(numCaso + " " + numero + " NO");
            else {
                String esHappy = comprobarHappy(numero);
                System.out.println(numCaso + " " + numero + " " + esHappy);
            }
        }


        sc.close();
    }

    // Criba de Eratóstenes clásica hasta 10000
    private static void calcularPrimos(int maximo) {
        for (int i = 2; i <= maximo; i++) {
            esPrimo[i] = true;
        }

        for (int i = 2; i * i <= maximo; i++) {
            if (esPrimo[i]) {
                for (int j = i * i; j <= maximo; j += i) {
                    esPrimo[j] = false;
                }
            }
        }
    }


    private static String comprobarHappy(int numero) {
        int nuevoNumero = calcularNumero(numero);
        if (nuevoNumero == 1) return "YES";
        else if (nuevoNumero == 4) return "NO";
        else return comprobarHappy(nuevoNumero);
    }

    private static int calcularNumero(int numero) {
        int resultado = 0;

        while (numero != 0) {
            int modulo = numero % 10;
            resultado += modulo * modulo;
            numero = numero / 10;
        }

        return resultado;
    }
}