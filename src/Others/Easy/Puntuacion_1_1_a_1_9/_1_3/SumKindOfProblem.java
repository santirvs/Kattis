package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer el número de casos
// Para cada caso:
// Leer el número del dataset y el tamaño N del conjunto
// Calcular la suma de de los N positivos enteros
// Calcular la suma de los N positivos pares
// Calcular la suma de los N positivos impares
import java.util.Scanner;

public class SumKindOfProblem {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer el número de sumandos
        int numCasos  = scan.nextInt();

        //Tratar cada caso
        for (int cas=0; cas<numCasos; cas++) {
            int numDataset = scan.nextInt();
            int N = scan.nextInt();

            //Sumar los N positivos
            int sumaEnteros = 0;
            for (int i=1; i<=N; i++) {
                sumaEnteros += i;
            }

            //Sumar los N positivos impares
            int sumaImpares = 0;
            int num = 1;
            for (int i=1; i<=N; i++) {
                sumaImpares += num;
                num+=2;
            }

            //Sumar los N positivos impares
            int sumaPares = 0;
            num = 2;
            for (int i=1; i<=N; i++) {
                sumaPares += num;
                num+=2;
            }

            System.out.println(numDataset + " " + sumaEnteros + " " + sumaImpares + " " + sumaPares);
        }

    }
}