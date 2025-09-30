package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer las dimensiones (ancho y alto) del ordenador y de la pegatina
// Determinar si cabrá la pegatina (sin rotar) en el ordenador dejando 1cm de margen

// Cabrá siempre que la dimensión del ordenador sea mayor o igual a la dimension de la pegatina + 2 (1cm por cada lado)

import java.util.Scanner;

public class LaptopSticker {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Leer el tamaño del ordenador y la pegatina
        int anchoOrdenador = sc.nextInt();
        int altoOrdenador = sc.nextInt();
        int anchoPegatina = sc.nextInt();
        int altoPegatina = sc.nextInt();

        //Comprobar
        if (anchoOrdenador >= (anchoPegatina + 2)  && altoOrdenador >= (altoPegatina + 2)){
            System.out.println(1);
        } else
            System.out.println(0);

        sc.close();
    }
}

