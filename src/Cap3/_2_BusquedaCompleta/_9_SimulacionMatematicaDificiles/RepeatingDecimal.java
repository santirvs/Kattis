package Cap3._2_BusquedaCompleta._9_SimulacionMatematicaDificiles;

// Buscar por fuerza bruta
// Calcular uno por uno los decimales de la división a/b
// Se puede hacer como a*10/b y quedarnos con el residuo para calcular el siguiente decimal.

import java.util.Scanner;

public class RepeatingDecimal {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            // Leer los números a y b
            int a = scan.nextInt();
            int b = scan.nextInt();
            // Leer la cantidad de decimales
            int numDecimales = scan.nextInt();

            // Imprimir la parte entera de la división
            System.out.print("0.");  // b > a, por lo tanto, siempre será menor de 1
            for (int i = 0; i < numDecimales; i++) {
                // Calcular el decimal actual
                a *= 10;
                int decimal = a / b;
                System.out.print(decimal);
                // Actualizar a para el siguiente decimal
                a = a%b;
            }
            // Imprimir un salto de línea al final
            System.out.println();
        }
    }

}


