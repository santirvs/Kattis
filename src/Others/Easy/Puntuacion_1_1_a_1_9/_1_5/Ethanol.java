package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el número de atomos de carbono
// Dibujar la molécula
// 1 línea con 1 espacio, seguido de espacio H (tantas veces como átomos de carbono)
// 1 línea con 1 espacio, seguido de espacio | (tantas veces como átomos de carbono)
// 1 lína con H, seguido de -C (tantas veces como átomos de carbono), seguido de -OH
// 1 línea con 1 espacio, seguido de espacio | (tantas veces como átomos de carbono)
// 1 línea con 1 espacio, seguido de espacio H (tantas veces como átomos de carbono)


import java.util.Scanner;


public class Ethanol {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la cantidad de átomos de carbono
        int numC = sc.nextInt();
        // Dibujar la molécula
        // 1 línea con 1 espacio, seguido de espacio H (tantas veces como átomos de carbono)
        System.out.print(" ");
        for (int i=0; i<numC; i++) {
            System.out.print(" H");
        }
        System.out.println("");
        // 1 línea con 1 espacio, seguido de espacio | (tantas veces como átomos de carbono)
        System.out.print(" ");
        for (int i=0; i<numC; i++) {
            System.out.print(" |");
        }
        System.out.println("");
        // 1 lína con H, seguido de -C (tantas veces como átomos de carbono), seguido de -OH
        System.out.print("H");
        for (int i=0; i<numC; i++) {
            System.out.print("-C");
        }
        System.out.println("-OH");
        // 1 línea con 1 espacio, seguido de espacio | (tantas veces como átomos de carbono)
        System.out.print(" ");
        for (int i=0; i<numC; i++) {
            System.out.print(" |");
        }
        System.out.println("");
        // 1 línea con 1 espacio, seguido de espacio H (tantas veces como átomos de carbono)
        System.out.print(" ");
        for (int i=0; i<numC; i++) {
            System.out.print(" H");
        }
        System.out.println("");


        sc.close();
    }
}

