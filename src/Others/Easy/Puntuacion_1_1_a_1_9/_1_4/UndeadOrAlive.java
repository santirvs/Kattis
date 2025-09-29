package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el mensaje
// Comprobar si existe :)  (smiley)
// Comprobar si existe :(  (frowny)
// Si existen ambos imprimir double agent
// Si sólo existe smiley --> alive
// Si sólo existe frowny --> undead
// Si no existe ninguno --> machine


import java.util.Scanner;

public class UndeadOrAlive {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el mensaje
        String mensaje = sc.nextLine();

        // Comprobar si existe smiley o frowny
        boolean smiley = mensaje.contains(":)");
        boolean frowney = mensaje.contains(":(");

        // Mostrar el resultado
        if (smiley && frowney) System.out.println("double agent");
        else if (smiley && !frowney) System.out.println("alive");
        else if (!smiley && frowney) System.out.println("undead");
        else System.out.println("machine");

        sc.close();
    }
}

