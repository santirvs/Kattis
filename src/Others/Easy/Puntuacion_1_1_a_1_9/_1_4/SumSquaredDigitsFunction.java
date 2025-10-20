package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el número de casos
// Para cada caso,
//   - leer el número del caso
//   - leer la base
//   - leer el número
//   mientras el número no sea 0
//   - extraer el último dígito segun la base (mod base)
//   - sumar el cuadrado del dígito y acumular
//   - eliminar el último dígito según la base ( / base)


import java.util.Scanner;

public class SumSquaredDigitsFunction {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Leer datos iniciales
        int numCasos =  sc.nextInt();
        while (numCasos-- >0) {
            int numCaso = sc.nextInt();
            int base = sc.nextInt();
            int numero =  sc.nextInt();

            int totalSSD = 0;
            while (numero>0) {
                int digit = numero %  base;
                totalSSD += digit*digit;
                numero /= base;
            }

            System.out.println(numCaso + " " + totalSSD);
        }

        sc.close();
    }
}

