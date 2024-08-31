package Cap2._1_EstructurasDatosConBibliotecas._5_Ordenacion_Faciles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class StackingCups {

    public static class Taza implements Comparable<Taza> {
        String color;
        double radio;

        public Taza(String color, double radio) {
            this.color = color;
            this.radio = radio;
        }

        @Override
        public int compareTo(Taza o) {
            return Double.compare(this.radio, o.radio);
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numTazas = scan.nextInt();
        scan.nextLine();

        ArrayList<Taza> listaTazas = new ArrayList<>();

        for (int i=0; i<numTazas;i++) {
            String[] taza = scan.nextLine().split(" ");
            double radio = 0;
            String color = "";

            if (taza[0].matches("[0-9]+")) {
                radio = Integer.parseInt(taza[0])/2.0;
                color = taza[1];
            } else {
                color = taza[0];
                radio = Integer.parseInt(taza[1]);
            }

            Taza t = new Taza(color, radio);
            listaTazas.add(t);
        }

        //Ordenar las tazas
        Collections.sort(listaTazas);

        //Mostrar el resultado
        for (Taza t : listaTazas) {
            System.out.println(t.color);
        }


    }
}