package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el número de bebidas y clientes
// Las bebidas deben guardarse en un Array
// Los clientes se van a guardar en un HashMap <Nombre, NúmeroVisita>
// A la primera visita se le asigna la bebida del índice 0
// A la segunda visita se le asigna la bebida del índice 1, ...

import java.util.Scanner;

public class DrinkMenu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el número de bebidas y clientes
        int numBebidas = sc.nextInt();
        int numClientes = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea

        // Guardar las bebidas en un array
        String[] bebidas = new String[numBebidas];
        for (int i = 0; i < numBebidas; i++) {
            bebidas[i] = sc.nextLine();
        }

        // Procesar los clientes
        java.util.HashMap<String, Integer> clientes = new java.util.HashMap<>();
        for (int i = 0; i < numClientes; i++) {
            String nombreCliente = sc.nextLine();
            int visita = clientes.getOrDefault(nombreCliente, 0);
            System.out.println(bebidas[visita % numBebidas]);
            clientes.put(nombreCliente, visita + 1);
        }



        sc.close();
    }
}

