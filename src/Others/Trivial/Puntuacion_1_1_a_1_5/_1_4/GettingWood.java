package Others.Trivial.Puntuacion_1_1_a_1_5._1_4;

// Leer la secuencia
// Buscar "tree" dentro de la secuencia
// Mostrar el índice donde aparece "tree"
// Si no aparece mostrar "no trees here"

import java.util.Scanner;

public class GettingWood {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Leer la secuencia
        String secuencia = sc.nextLine();

        //Buscar "tree"
        int posicion = secuencia.indexOf("tree");

        if (posicion != -1) {
            System.out.println(posicion);
        }
        else {
            System.out.println("no trees here");
        }


        sc.close();
    }
}

