package Cap1._2_ProblemasAdHoc._11_Cifrado_Faciles;

import java.util.Locale;
import java.util.Scanner;

public class T9Spelling {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Mapa de las letras a los números
        char[][] mapa = {
            {' '},
            { },
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
        };

        //Lectura de los datos del caso
        int numCasos = scan.nextInt();
        scan.nextLine();

        for (int i=1; i<=numCasos; i++) {
            String texto = scan.nextLine();
            System.out.print("Case #" + i + ": ");

            int numAnterior = -1;
            //Recorre el texto y busca el número correspondiente a cada letra
            for (int j=0; j<texto.length(); j++) {
                char letra = texto.charAt(j);
                int num = 0;
                int repeticiones = 0;

                //Busca la letra en el mapa y obtiene el número correspondiente
                for (int k=0; k<mapa.length; k++) {
                    for (int l=0; l<mapa[k].length; l++) {
                        if (mapa[k][l] == letra) {
                            num = k;
                            repeticiones = l+1;
                            break;
                        }
                    }
                }
                //Si se repite la misma tecla, hay que esperar un tiempo (se simula con un espacio)
                if (num == numAnterior) {
                    System.out.print(" ");
                }
                //Imprime el número tantas veces como sea necesario
                for (int k=0; k<repeticiones; k++) {
                    System.out.print(num);
                }

                numAnterior = num;
            }
            //Salto de línia final
            System.out.println("");
        }


    }
}


