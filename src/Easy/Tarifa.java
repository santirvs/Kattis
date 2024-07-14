package Easy;

import java.util.Scanner;

public class Tarifa {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int megasContratadas = scan.nextInt();
        int meses = scan.nextInt();
        int megasConsumidas = 0;

        for (int i=0; i<meses; i++) {
            int gasto = scan.nextInt();
            megasConsumidas += gasto;
        }

        System.out.println(megasContratadas*(meses+1)-megasConsumidas);

    }
}