package Cap2._1_EstructurasDatosConBibliotecas._2_ArraysUnidimensionalesDificiles;

import java.util.Locale;
import java.util.Scanner;

public class DivideBy100 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

       //Leer la entrada
        String n = scan.nextLine();
        String m = scan.nextLine();
        String result = "";

        //Longitud de las cadenas
        int nLength = n.length();
        int mLength = m.length()-1;


        //Si la longitud de n es mayor que la de m, entonces se puede dividir corriendo la coma m posiciones a la izquierda
        if (nLength > mLength) {
            result = n.substring(0, nLength-mLength) + "." + n.substring(nLength-mLength);
        }
        //Si la longitud de n es menor que la de m, entonces se deben agregar ceros a la izquierda
        else {
            result = "0." + "0".repeat(mLength - nLength) + n;
        }

        //Eliminar los ceros a la derecha y el posible punto decimal
        int i = result.length() - 1;
        while (result.charAt(i) == '0') {
            i--;
        }
        if (result.charAt(i) == '.') i--;
        result = result.substring(0, i + 1);



        //Imprimir el resultado
        System.out.println(result);
  }
}
