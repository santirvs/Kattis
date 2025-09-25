package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer la palabra
// Recorrer desde el final hasta encontrar el primer punto
// Mostrar desde el punto hasta el final

import java.util.Scanner;

public class FileExtension {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la palabra
        String palabra = sc.nextLine();

        //Recorrer desde el final hasta encontrar el primer punto
        String extension = "";
        for (int i=palabra.length()-1; i>=0; i--) {
            if (palabra.charAt(i) == '.') {
                extension = palabra.substring(i);
                break;
            }
        }

        //Mostrar el resultado
        System.out.println(extension);

        sc.close();
    }
}

