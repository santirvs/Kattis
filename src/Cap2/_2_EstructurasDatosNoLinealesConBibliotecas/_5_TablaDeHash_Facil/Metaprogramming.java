package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._5_TablaDeHash_Facil;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// Leer la instruccion y parsearla
// Si es un define, añadir la palabra al diccionario con su valor
// Si es un eval, buscar las palabras en el diccionario y devolver su valor


public class Metaprogramming {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        HashMap<String, Integer> variables = new HashMap<String,Integer>();

        while (scan.hasNext()) {
            String[] instruccion = scan.nextLine().split(" ");
            if (instruccion[0].equals("define")) {
                variables.put(instruccion[2], Integer.parseInt(instruccion[1]));
            } else {
                //es un eval
                if (variables.containsKey(instruccion[1]) && variables.containsKey(instruccion[3])) {
                    int valor1 = variables.get(instruccion[1]);
                    int valor2 = variables.get(instruccion[3]);
                    if (instruccion[2].equals("<")) {
                        System.out.println(valor1 < valor2);
                    } else if (instruccion[2].equals(">")) {
                        System.out.println(valor1 > valor2);
                    } else {
                        System.out.println(valor1 == valor2);
                    }
                } else {
                    System.out.println("undefined");
                }
            }
        }
    }

}

