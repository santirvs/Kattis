package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._5_TablaDeHash_Facil;


import java.util.*;

// Usar un HashMap para guardar las palabras traducción -> inglés
// En las consultas, buscar la traducción en el HashMap y devolver su palabra en inglés

public class Babelfish {


    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        HashMap<String, String> diccionario = new HashMap<String, String>();
        String[] linea = scan.nextLine().split(" ");

        //Añadir las palabras al diccionario
        while (!linea[0].equals("")) {
            diccionario.put(linea[1], linea[0]);
            linea = scan.nextLine().split(" ");
        }

        while (scan.hasNext()) {
            String palabra = scan.nextLine();
            if (diccionario.get(palabra)!=null) {
                System.out.println(diccionario.get(palabra));
            } else {
                System.out.println("eh");
            }
        }

    }

}
