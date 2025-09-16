package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer el número de sumandos
// Leer cada uno de los números y transformarlo a X^Y sabiendo que X=num/10 y Y=num%10
// Acumular cada sumando
// Mostrar el resultado
import java.util.Scanner;

public class Pot {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer el número de sumandos
        int numSumandos = scan.nextInt();

        //Leer cada uno de los sumandos y acumular
        int acumulado = 0;
        for (int i=0; i<numSumandos; i++) {
            int sumando =  scan.nextInt();
            int base = sumando / 10;
            int exponente = sumando % 10;
            acumulado = acumulado + (int) Math.pow(base, exponente);
        }

        //Mostrar el resultado
        System.out.println(acumulado);

    }
}