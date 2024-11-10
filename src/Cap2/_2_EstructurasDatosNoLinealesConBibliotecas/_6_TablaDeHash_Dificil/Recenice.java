package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._6_TablaDeHash_Dificil;

import java.util.*;

// Leer las palabras
// Contar los caracteres de toda la frase
// Buscar, a partir de la longitud de la frase, la palabra que falta
// Usar una tabla de hash para guardar la descripción de los números

// Caso de prueba #11: WA --> ????
// Adapto de https://github.com/mpfeifer1/Kattis/blob/master/recenice.cpp

public class Recenice {

    public static String digit(int i) {
        switch (i) {
            case 0:
                return "";
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
        }
        return "";
    }

    public static String tens(int i) {
        switch(i) {
            case 0:
                return "";
            case 1:
                return "ten";
            case 2:
                return "twenty";
            case 3:
                return "thirty";
            case 4:
                return "forty";
            case 5:
                return "fifty";
            case 6:
                return "sixty";
            case 7:
                return "seventy";
            case 8:
                return "eighty";
            case 9:
                return "ninety";
        }
        return "";
    }

    public static String str(int i) {
        if(i >= 100) {
            return digit(i/100) + "hundred" + str(i%100);
        }

        if(i == 10) {
            return "ten";
        }
        if(i == 11) {
            return "eleven";
        }
        if(i == 12) {
            return "twelve";
        }
        if(i == 13) {
            return "thirteen";
        }
        if(i == 14) {
            return "fourteen";
        }
        if(i == 15) {
            return "fifteen";
        }
        if(i == 16) {
            return "sixteen";
        }
        if(i == 17) {
            return "seventeen";
        }
        if(i == 18) {
            return "eighteen";
        }
        if(i == 19) {
            return "nineteen";
        }

        String answer = "";
        if(i >= 10) {
            answer += tens(i / 10);
            i %= 10;
        }
        if(i >= 0) {
            answer += digit(i);
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        scan.nextLine();

        List sentence = new ArrayList();
        int index = 0;
        int characters = 0;
        for(int i = 0; i < n; i++) {
             String word = scan.nextLine();
             if(word.equals("$")) {
                    index = i;
             } else {
                    characters += word.length();
                }
             sentence.add(word);
        }

        for(int i = 1; i <= 1000; i++) {
            if(str(i).length() + characters == i) {
                sentence.set(index,str(i));
                break;
            }
        }

        for(Object i : sentence) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}

