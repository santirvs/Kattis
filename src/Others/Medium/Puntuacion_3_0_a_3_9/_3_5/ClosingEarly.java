package Others.Medium.Puntuacion_3_0_a_3_9._3_5;

//Buscar un momento en que tengamos 0 trozos de pizza para cerrar la tienda
//Si no tenemos suficientes, hacemos una nueva pizza (o tantas como necesitemos para servir al nuevo cliente)

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClosingEarly {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int sobrantes = scan.nextInt();
        int porcionesPizza = scan.nextInt();
        int numClientes = scan.nextInt();

        int numClientesAtendidos = 0;

        while (sobrantes!=0 && numClientes-- >0) {
            int peticion = scan.nextInt();

            //Tengo suficientes porciones --> servirlas
            if (sobrantes < peticion) {
                //No tengo suficientes -> hornear pizzas
                int faltantes = peticion - sobrantes;
                int pizzas = (faltantes + porcionesPizza - 1) / porcionesPizza;  //redondea hacia arriba
                sobrantes += pizzas * porcionesPizza;
            }

            //Servir el pedido
            sobrantes -= peticion;
            numClientesAtendidos++;

        }

        //Imprimir el resultado
        if (sobrantes != 0) System.out.println(-1);
        else System.out.println(numClientesAtendidos);

        scan.close();
    }
}