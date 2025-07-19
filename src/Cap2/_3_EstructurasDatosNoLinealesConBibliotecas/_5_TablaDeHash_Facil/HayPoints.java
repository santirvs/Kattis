package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._5_TablaDeHash_Facil;


import java.util.HashMap;
import java.util.Scanner;

// Leer el diccionario en una HashMap<String, Int>
// Leer los textos y buscar las palabras que están en el diccionario
// sumando sus importes

public class HayPoints {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int numCasos = scan.nextInt();
        int numDescripciones = scan.nextInt();
        scan.nextLine();

        HashMap<String, Integer> diccionario = new HashMap<>();

        //Leer el diccionario
        for (int i=0; i<numCasos; i++) {
            String[] linea = scan.nextLine().split(" ");
            diccionario.put(linea[0], Integer.parseInt(linea[1]));
        }

        //Leer las descripciones y sumar los importes
        for (int i=0; i<numDescripciones; i++) {
            String descripcion = scan.nextLine();
            int importe = 0;
            while (!descripcion.equals(".")) {
                for (String palabra : descripcion.split(" ")) {
                    if (diccionario.containsKey(palabra)) {
                        importe += diccionario.get(palabra);
                    }
                }
                descripcion = scan.nextLine();
            }
            System.out.println(importe);
        }

    }

}

