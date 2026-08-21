package Others.Trivial.Puntuacion_1_1_a_1_5._1_5;

// Leer la semilla
// Iterar hasta encontrar el valor
// Mostrar el número de veces que se ha iterado

import java.util.Scanner;


public class EncryptedCounting {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Lectura de los valores
        String semilla = sc.next();
        String objetivo = sc.next();
        int iteraciones = 0;

        //Iterar las encriptaciones
        while (!semilla.equals(objetivo)) {
            iteraciones++;
            semilla = encriptar(semilla);
        }

        //Mostrar resultado
        System.out.println(iteraciones);

        sc.close();
    }

    static String encriptar(String semilla) {
        StringBuilder resultado = new StringBuilder();

        int pos =0;
        while (pos < semilla.length()) {

            int contador = 0;
            while (((pos+contador) < semilla.length())  && (semilla.charAt(pos) == semilla.charAt(pos+contador)) ) {
                contador++;
            }

            resultado.append(contador);
            resultado.append(semilla.charAt(pos));

            pos+=contador;
        }

        return resultado.toString();
    }
}

