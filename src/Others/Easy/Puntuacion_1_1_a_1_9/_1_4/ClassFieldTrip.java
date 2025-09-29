package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer la lista de la clase de ann
// Leer la lista de la clase de ben
// Recorrer las dos listas y avanzar la que sea inferior alfabéticamente
// Acabar de recorrer ambas listas

import java.util.Scanner;

public class ClassFieldTrip {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer las listas
        String listaAnn = sc.nextLine();
        String listaBen = sc.nextLine();

        int indiceAnn = 0;
        int indiceBen = 0;

        while (indiceAnn < listaAnn.length() && indiceBen < listaBen.length()) {
            if (listaAnn.charAt(indiceAnn) <= listaBen.charAt(indiceBen)) {
                System.out.print(listaAnn.charAt(indiceAnn));
                indiceAnn++;
            } else {
                System.out.print(listaBen.charAt(indiceBen));
                indiceBen++;
            }
        }

        //Alguna acabará antes que la otra, finalizarlas
        for (; indiceAnn < listaAnn.length(); indiceAnn++) {
            System.out.print(listaAnn.charAt(indiceAnn));
        }
        for (; indiceBen < listaBen.length(); indiceBen++) {
            System.out.print(listaBen.charAt(indiceBen));
        }

        System.out.println();

        sc.close();
    }
}

