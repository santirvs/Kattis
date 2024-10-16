package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._6_TablaDeHash_Dificil;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

// Crear una lista de palabras de 4 letras, otra de 3 letras y otra de 2 letras
// Crear una tabla de hash con las palabras y su traducción
// Leer las frases y traducirlas
// Para traducir, recorrer la frase y buscar las palabras de 4 letras, 3 letras y 2 letras en la tabla de hash
// Si se encuentra la palabra, añadir la traducción a la frase final
// Si no se encuentra la palabra, añadir el caracter tal cual a la frase final y seguir con el siguiente caracter

public class AnIForAnEye {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Crear las listas de palabras
        List<String> palabras4 = new ArrayList<String>()  { {add("four");} };
        List<String> palabras3 = new ArrayList<String>()  { {add("and");add("one");add("won");add("too");add("two");add("for");add("bea");add("bee");add("sea");add("see");add("eye");add("owe");add("are");add("you");add("why");} };
        List<String> palabras2 = new ArrayList<String>()  { {add("at");add("to");add("be");add("oh");} };

        HashMap<String, Character> traduccion = new HashMap<String, Character>() {
                {   put("at", '@');
                    put("and", '&');
                    put("one", '1');put("won", '1');
                    put("to", '2');put("too", '2');put("two", '2');
                    put("for", '4');put("four", '4');
                    put("bea", 'b');put("be", 'b'); put("bee", 'b');
                    put("sea", 'c');put("see", 'c');
                    put("eye", 'i');
                    put("oh", 'o');put("owe", 'o');
                    put("are", 'r');
                    put("you", 'u');
                    put("why", 'y');}};

        //Tratar los casos
        int numCasos = scan.nextInt();
        scan.nextLine();
        while (numCasos > 0) {
            numCasos--;

            StringBuilder frase = new StringBuilder();
            //Leer la frase
            String palabra = scan.nextLine();
            for (int i = 0; i < palabra.length(); i++) {
                //Buscar la palabra en las listas, si existe y añadir la traducción a la frase
                //Empezamos por las palabras más largas
                boolean esMayuscula = Character.isUpperCase(palabra.charAt(i));
                char c = palabra.charAt(i);
                if (i + 3 < palabra.length() && palabras4.contains(palabra.substring(i, i + 4).toLowerCase())) {
                    c = traduccion.get(palabra.substring(i, i + 4).toLowerCase());
                    i += 3;
                } else if (i + 2 < palabra.length() && palabras3.contains(palabra.substring(i, i + 3).toLowerCase())) {
                    c = traduccion.get(palabra.substring(i, i + 3).toLowerCase());
                    i += 2;
                } else if (i + 1 < palabra.length() && palabras2.contains(palabra.substring(i, i + 2).toLowerCase())) {
                    c = traduccion.get(palabra.substring(i, i + 2).toLowerCase());
                    i += 1;
                }
                frase.append(esMayuscula ? Character.toUpperCase(c) : c);
            }

            //Imprimir la frase
            System.out.println(frase.toString());

        }
    }

}

