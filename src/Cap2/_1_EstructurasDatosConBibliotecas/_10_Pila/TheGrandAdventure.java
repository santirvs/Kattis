package Cap2._1_EstructurasDatosConBibliotecas._10_Pila;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

//Apilar los objetos segun se van encontrando
//Al encontrarme un villano, desapilo el último objeto apilado
//Si coincide con lo que me pide, ok
//Si no coincide, no se puede continuar
//Al final del recorrido, la mochila debe estar vacía

public class TheGrandAdventure {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numAventuras = scan.nextInt();
        scan.nextLine();

        //Para cada aventura
        for (int i=0; i<numAventuras; i++) {
            //Leer la aventura
            String aventura = scan.nextLine();
            //Crear la pila para la mochila
            Stack<Character> mochila = new Stack<>();
            //Recorrer la aventura
            boolean exito = true;
            int pos = 0;
            while (exito && pos < aventura.length()) {
                char c = aventura.charAt(pos);
                switch (c) {
                    case '*','|','$':
                        mochila.push(c);
                        break;
                    case 't': //trader
                        if (mochila.isEmpty() || mochila.peek() != '|') {
                            exito = false;
                        }
                        else {
                            mochila.pop();
                        }
                        break;
                    case 'j': //jeweler
                        if (mochila.isEmpty() || mochila.peek() != '*') {
                            exito = false;
                        }
                        else {
                            mochila.pop();
                        }
                        break;
                    case 'b': //banker
                        if (mochila.isEmpty() || mochila.peek() != '$') {
                            exito = false;
                        }
                        else {
                            mochila.pop();
                        }
                        break;
                }
                pos++;
            }

            //Mostrar el resultado
            if (exito && mochila.isEmpty()) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }

        }
    }
}
