package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el número de items que se han cogido
// Leer cada uno de los ítems y comprobar si es phone, keys o wallet
// Si lo son, marcar el booleano correspondiente
// Al final, mostrar ordenadamente los que falten
// Si no falta ninguna, imprimir "ready"

import java.util.Scanner;

public class KeysPhoneWallet {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el número de items
        int numItems =  sc.nextInt();

        // Definir los booleanos para los items a controlar
        boolean keys = false;
        boolean phone = false;
        boolean wallet = false;

        // Leer los items
        for (int i = 0; i < numItems; i++) {
            String item = sc.next();
            if (item.equals("keys")) keys = true;
            if (item.equals("phone")) phone = true;
            if (item.equals("wallet")) wallet = true;
        }

        //Mostrar el resultado
        if (keys && phone && wallet) {
            System.out.println("ready");
        }
        else {
            if (!keys) System.out.println("keys");
            if (!phone) System.out.println("phone");
            if (!wallet) System.out.println("wallet");
        }

        sc.close();
    }
}

