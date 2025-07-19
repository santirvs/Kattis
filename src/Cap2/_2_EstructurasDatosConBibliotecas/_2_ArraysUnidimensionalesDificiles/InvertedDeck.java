package Cap2._2_EstructurasDatosConBibliotecas._2_ArraysUnidimensionalesDificiles;

import java.util.Locale;
import java.util.Scanner;

public class InvertedDeck {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer la entrada
        int n = scan.nextInt();

        //Definir el array
        int[] cartas = new int[n];

        //Leer las cartas
        for (int i=0; i<n; i++) {
            cartas[i] = scan.nextInt();
        }

        //Comprobar las cartas
        int estado = 0;  //0: ascendiendo, 1: descendiendo, 2: ascendiendo de nuevo, 3: imposible
        int cartaAnterior = cartas[0];
        int limiteInferior = 0;
        int limiteSuperior = -1;
        for (int i = 1; i < n && estado!=3; i++) {
            int carta = cartas[i];
            switch (estado) {
                case 0: //ascendiendo
                    if (carta < cartaAnterior) {
                        estado = 1;
                    }
                    if (carta > cartaAnterior) {
                        limiteInferior = i;
                    }
                    break;
                case 1: //descendiendo
                    if (carta > cartaAnterior) {
                        estado = 2;
                        limiteSuperior = i - 1;
                    }
                    //Comprobar que no se haya descendido en exceso
                    if (limiteInferior > 0 && carta < cartas[limiteInferior-1]) {
                        estado = 3;
                    }
                    break;
                case 2: //ascendiendo de nuevo
                    if (carta < cartaAnterior) {
                        estado = 3;
                    }
                    break;
            }
            cartaAnterior=carta;
        }

        //Mostrar el resultado
        if (estado == 0) {
            System.out.println("1 1");
        } else if (estado == 1) {
            System.out.println(limiteInferior+1 + " " + n);
        } else if (estado == 2) {
            System.out.println((limiteInferior+1) + " " + (limiteSuperior+1));
        } else {
            System.out.println("impossible");
        }





    }
}