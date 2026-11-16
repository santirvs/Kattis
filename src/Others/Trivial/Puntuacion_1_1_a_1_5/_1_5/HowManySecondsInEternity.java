package Others.Trivial.Puntuacion_1_1_a_1_5._1_5;

// Leer el número de vueltas
// Multiplicar por 60 * 60 * 40
import java.util.Arrays;
import java.util.Scanner;


public class HowManySecondsInEternity {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long segundosIteracion = 60 * 60 * 40;

        //Leer número de iteraciones
        long iteraciones = sc.nextLong();

        //Mostrar el resultado
        System.out.println(iteraciones * segundosIteracion);

        sc.close();
    }
}

