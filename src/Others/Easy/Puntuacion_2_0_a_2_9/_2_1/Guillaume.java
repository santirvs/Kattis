package Others.Easy.Puntuacion_2_0_a_2_9._2_1;

// Recorrer de atrás hacia adelante y quedarnos con la ratio máxima de victorias
// tamaño máximo 3*10^5, suficiente para recorrido lineal en 1 seg

import java.util.Scanner;

public class Guillaume {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numPartidas = sc.nextInt();
        String resultados = sc.next();

        double ratioMax = -1;  //Obliga a inicializar con el primer resultado.
        int ganadasMax = 0;
        int derrotasMax = 0;

        int ganadas = 0;
        int derrotas = 0;
        double validas = 0;

        //Salta los empates más recientes
        int pos = numPartidas-1;
        while (pos>=0 && resultados.charAt(pos) == 'E') {
            pos--;
        }

        for (int i = pos; i >= 0; i--) {
            if (resultados.charAt(i) == 'G') {
                ganadas++;
                validas++;
            } else if (resultados.charAt(i) == 'A') {
                derrotas++;
                validas++;
            }

            if (ganadas / validas > ratioMax) {
                ratioMax = ganadas / validas;
                ganadasMax = ganadas;
                derrotasMax = derrotas;
            }
        }

        //Resultado final
        System.out.println(ganadasMax + "-" + derrotasMax);


    }
}
