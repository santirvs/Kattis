package Cap3._2_BusquedaCompleta._7_ProbarTodasRespuestasPosibles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// No veo como calcular todas las respuestas posibles...
// Se puede calcular la respuesta directamente sin necesidad de probar todas las respuestas posibles.

public class SavingForRetirement {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Leer los datos de entrada
        int edadBob = scan.nextInt();
        int edadJubilacionBob = scan.nextInt();
        int ahorroBob = scan.nextInt();
        int edadAlice = scan.nextInt();
        int ahorroAlice = scan.nextInt();

        // Calcular la edad de jubilación de Alice
        int totalAhorroBob = (edadJubilacionBob - edadBob) * ahorroBob;
        int anyosHastaJubilacionAlice = totalAhorroBob / ahorroAlice + 1;

        int edadJubilacionAlice = edadAlice + anyosHastaJubilacionAlice;

        // Imprimir la edad de jubilación de Alice
        System.out.println(edadJubilacionAlice);
    }
}


