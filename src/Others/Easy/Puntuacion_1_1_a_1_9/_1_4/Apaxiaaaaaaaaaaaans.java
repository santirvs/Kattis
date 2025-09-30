package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el nombre
// Eliminar los caracteres repetidos
// Guardarnos el primer caracter
// Procesar todos los caracteres hasta el final
// Si el caracter se repite, ignorarlo
// Si es diferente, escribirlo y actualizar el último

import java.util.Scanner;

public class Apaxiaaaaaaaaaaaans {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el nombre
        String nombre = sc.nextLine();

        // Obtener el primer caracter
        char ultimoCaracter = nombre.charAt(0);
        System.out.print(ultimoCaracter);
        //Procesar hasta el final
        for (int i=1; i<nombre.length(); i++) {
            char nuevoCaracter = nombre.charAt(i);
            if (nuevoCaracter!=ultimoCaracter) {
                System.out.print(nuevoCaracter);
                ultimoCaracter = nuevoCaracter;
            }
        }
        System.out.println();

        sc.close();
    }
}

