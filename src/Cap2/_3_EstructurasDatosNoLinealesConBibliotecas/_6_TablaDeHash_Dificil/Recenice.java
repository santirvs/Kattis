package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._6_TablaDeHash_Dificil;

import java.util.HashMap;
import java.util.Scanner;

// Leer las palabras
// Contar los caracteres de toda la frase
// Buscar, a partir de la longitud de la frase, la palabra que falta
// Usar una tabla de hash para guardar la descripción de los números

// Caso de prueba #11: WA --> Se empieza a contar desde 1, no desde longitudFrase -> OK
//                            No se me ocurre un caso en el que el número a añadir sea inferior a longitudFrase...

public class Recenice {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        HashMap<Integer, String> numeros = new HashMap<Integer, String>();
        numeros.put(0, "");
        numeros.put(1, "one");
        numeros.put(2, "two");
        numeros.put(3, "three");
        numeros.put(4, "four");
        numeros.put(5, "five");
        numeros.put(6, "six");
        numeros.put(7, "seven");
        numeros.put(8, "eight");
        numeros.put(9, "nine");
        numeros.put(10, "ten");
        numeros.put(11, "eleven");
        numeros.put(12, "twelve");
        numeros.put(13, "thirteen");
        numeros.put(14, "fourteen");
        numeros.put(15, "fifteen");
        numeros.put(16, "sixteen");
        numeros.put(17, "seventeen");
        numeros.put(18, "eighteen");
        numeros.put(19, "nineteen");
        numeros.put(20, "twenty");
        numeros.put(30, "thirty");
        numeros.put(40, "forty");
        numeros.put(50, "fifty");
        numeros.put(60, "sixty");
        numeros.put(70, "seventy");
        numeros.put(80, "eighty");
        numeros.put(90, "ninety");

        //Leer las palabras
        int numPalabras = scan.nextInt();
        scan.nextLine();
        String[] palabras = new String[numPalabras];
        int longitudFrase = 0;
        for (int i = 0; i < numPalabras; i++) {
            palabras[i] = scan.nextLine();
            if (! palabras[i].equals("$")) {
                longitudFrase += palabras[i].length();
            }
        }

        //Buscar la palabra que falta a partir de la longitud de la frase
        boolean encontrado = false;
        int num = 1;
        String palabraFaltante = "";
        while (! encontrado) {
            String palabra = descripcionNumero(num, numeros);
            if (palabra.length() + longitudFrase == num) {
                encontrado = true;
                palabraFaltante = palabra;
            }
            else {
                num++;
            }
        }

        //Mostrar la frase completa
        for (int i = 0; i < numPalabras; i++) {
            if (palabras[i].equals("$")) {
                System.out.print(palabraFaltante);
            } else {
                System.out.print(palabras[i]);
            }
            if (i < numPalabras - 1) System.out.print(" ");
        }
        System.out.println();

    }

    private static String descripcionNumero(int num, HashMap<Integer, String> numeros) {
        String resultado = "";

        if (num >= 100) {
            resultado += numeros.get(num / 100) + "hundred" + descripcionNumero(num % 100, numeros);
        }
        else if (num >= 20) {
            resultado += numeros.get((num / 10) * 10) + numeros.get(num % 10);
        }
        else {
            resultado += numeros.get(num);
        }

        return resultado;
    }

}

