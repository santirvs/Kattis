package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el pesoMaximo, la tara y el número de items
// Restar la tara del pesoMaximo
// Restar el peso de cada uno de los items
// Mostrar el resultado final

import java.util.Scanner;

public class GCVWR {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el pesoMaximo, la tara y el número de ítems
        int pesoMaximo = sc.nextInt();
        int tara = sc.nextInt();
        int numItems = sc.nextInt();
        int pesoRemolque = pesoMaximo - tara;
        // Calcular el 90% del peso
        pesoRemolque = (int) (pesoRemolque * 0.9f);

        // Leer cada uno de los pesos y restarlo al pesoMaximo
        for (int i=0; i<numItems; i++) {
            int pesoItem = sc.nextInt();
            pesoRemolque -=pesoItem;
        }

        // Mostrar el resultado final
        System.out.println(pesoRemolque);


        sc.close();
    }
}

