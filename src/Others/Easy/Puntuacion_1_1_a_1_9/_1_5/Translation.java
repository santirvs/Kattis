package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer la cantidad de palabras a traducir
// Leer las palabras a traducir
// Leer el número de palabras en el diccionario
// Leer las palabras del diccionario y sus traducciones en un HashMap<String, String>
// Finalmente, aplicar la traduccion a las palabras leídas inicialmente


import java.util.Locale;
import java.util.Scanner;

public class Translation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        // Leer las palabras a traducir
        int numPalabrasATraducir = sc.nextInt();
        String[] palabrasATraducir = new String[numPalabrasATraducir];
        for (int i = 0; i < numPalabrasATraducir; i++) {
            palabrasATraducir[i] = sc.next();
        }

        // Leer el diccionario
        int numPalabrasDiccionario = sc.nextInt();
        java.util.HashMap<String, String> diccionario = new java.util.HashMap<>();
        for (int i = 0; i < numPalabrasDiccionario; i++)
        {
            String palabra = sc.next();
            String traduccion = sc.next();
            diccionario.put(palabra, traduccion);
        }

        // Traducir las palabras
        boolean primera = true;
        for (String palabra : palabrasATraducir) {
            if (!primera) System.out.print(" ");
            else primera = false;
            System.out.print(diccionario.get(palabra));
        }
        System.out.println();

        sc.close();
    }
}

