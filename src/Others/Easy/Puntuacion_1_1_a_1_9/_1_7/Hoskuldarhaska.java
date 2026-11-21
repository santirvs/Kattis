package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 * Calcular todas las combinaciones de palabras
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Hoskuldarhaska {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();


        //Cargar todas las palabras con sus opciones
        int numPalabras = sc.nextInt();
        ArrayList< ArrayList <String>> palabras = new ArrayList();

        for (int i=0; i<numPalabras; i++) {
            ArrayList<String> opciones = new ArrayList<>();
            int numOpciones = sc.nextInt();
            for (int j=0; j<numOpciones; j++) {
                String opcion = sc.next();
                opciones.add(opcion);
            }
            //Ordenar cada lista de opciones para conseguir la salida ordenada
            Collections.sort(opciones);
            palabras.add(opciones);
        }

        //Crearnos un array de indices
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i=0; i<numPalabras; i++) {
            indices.add(0);
        }

        while (indices.get(0) < palabras.get(0).size()) {
            for (int i=0; i<numPalabras; i++) {
                if (i!=0) sb.append(" ");
                sb.append( palabras.get(i).get(indices.get(i)));
            }
            sb.append("\n");

            //Incrementar los índices
            int indice = indices.size()-1;
            boolean carry;
            do {
                carry = false;
                int ultimoValor = indices.get(indice);
                ultimoValor++;
                if (ultimoValor == palabras.get(indice).size() && indice > 0) {
                    indices.set(indice, 0);
                    indice--;
                    carry = true;
                } else {
                    indices.set(indice, ultimoValor);
                }
            } while (carry && indice >= 0);
        }

        System.out.print(sb.toString());

    }
}