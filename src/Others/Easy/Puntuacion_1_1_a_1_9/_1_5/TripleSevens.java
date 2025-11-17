package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer la cantidad de digitos de cada rueda
// Leer cada una de las tres ruedas
// Comprobar si la rueda contiene el 7
// Si las tres ruedas lo contienen, imprimir 777 sino 0
// Se puede hacer con Strings en lugar de int


import java.util.Locale;
import java.util.Scanner;

public class TripleSevens {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        //Ignorar el número de digitos
        sc.nextLine();
        // Leer las tres ruedas
        String rueda1= sc.nextLine();
        String rueda2 = sc.nextLine();
        String rueda3 = sc.nextLine();

        // Comprobar que las 3 ruedas tengan el 7
        if (rueda1.contains("7") && rueda2.contains("7") && rueda3.contains("7")) {
            System.out.println("777");
        } else {
            System.out.println("0");
        }

        //Cerrar el scanner
        sc.close();
    }
}

