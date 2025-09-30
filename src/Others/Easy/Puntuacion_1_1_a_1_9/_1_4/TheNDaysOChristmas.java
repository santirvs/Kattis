package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el número de días durante los que se celebrará la Navidad
// El primer día se recibe 1 regalo
// El segundo día se vuelve a recibir el regalo del día anterior y 2 más
// El tercer días se vuelve a recibir los regalos del día anterior y 3 más
// ...
// Es decir, debemos mantener un contador de regalos del día y un acumulador de regalos en total
import java.util.Scanner;

public class TheNDaysOChristmas {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Leer el número de días
        int numDias = sc.nextInt();

        int regalosDia = 0;
        int totalRegalos = 0;

        for (int i = 1; i <= numDias; i++) {
            //En el día n se recibirán n regalos más
            regalosDia += i;
            //Acumularlos al total
            totalRegalos += regalosDia;
        }

        //Mostrar el resultado
        System.out.println(regalosDia);
        System.out.println(totalRegalos);

        sc.close();
    }
}

