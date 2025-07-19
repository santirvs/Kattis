package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._5_TablaDeHash_Facil;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// Codificar cada palabra del diccionario en un HashMap<String, List<String>>
// La codificación se hace con las teclas del teléfono
// En las consultas, se busca el código en el HashMap y se devuelve la cantidad de palabras


public class Marko {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int numPalabras = scan.nextInt();
        scan.nextLine();

        HashMap<String, ArrayList<String>> diccionario = new HashMap<String,ArrayList<String>>();

        //Leer las palabras del diccionario
        for (int i=0; i<numPalabras; i++) {
            String palabra = scan.nextLine();
            String codigo = "";
            for (int j=0; j<palabra.length(); j++) {
                switch (palabra.charAt(j)) {
                    case 'a': case 'b': case 'c':
                        codigo += "2";
                        break;
                    case 'd': case 'e': case 'f':
                        codigo += "3";
                        break;
                    case 'g': case 'h': case 'i':
                        codigo += "4";
                        break;
                    case 'j': case 'k': case 'l':
                        codigo += "5";
                        break;
                    case 'm': case 'n': case 'o':
                        codigo += "6";
                        break;
                    case 'p': case 'q': case 'r': case 's':
                        codigo += "7";
                        break;
                    case 't': case 'u': case 'v':
                        codigo += "8";
                        break;
                    case 'w': case 'x': case 'y': case 'z':
                        codigo += "9";
                        break;
                }
            }
            if (diccionario.containsKey(codigo)) {
                diccionario.get(codigo).add(palabra);
            } else {
                ArrayList<String> palabras = new ArrayList<>();
                palabras.add(palabra);
                diccionario.put(codigo, palabras);
            }
        }

        //Leer el código y devolver la cantidad de palabras
        String codigo = scan.nextLine();
        if (diccionario.containsKey(codigo)) {
            System.out.println(diccionario.get(codigo).size());
        } else {
            System.out.println(0);
        }
    }

}

