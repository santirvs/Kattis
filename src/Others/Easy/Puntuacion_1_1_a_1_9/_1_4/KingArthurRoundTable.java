package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el diametro, el ancho que necesita cada caballero y el número de caballeros
// Mostrar "YES" si caben los caballeros y "NO" en caso contrario
// El perímetro de la mesa es PI*diametro y PI es 3.14159

import java.util.Locale;
import java.util.Scanner;

public class KingArthurRoundTable {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        //Leer los datos
        double diametro = sc.nextDouble();
        double ancho = sc.nextDouble();
        int numCaballeros = sc.nextInt();

        double perimetroNecesario = ancho * numCaballeros;
        double perimetroMesa = diametro * Math.PI;

        if (perimetroNecesario <= perimetroMesa) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


        sc.close();
    }
}

