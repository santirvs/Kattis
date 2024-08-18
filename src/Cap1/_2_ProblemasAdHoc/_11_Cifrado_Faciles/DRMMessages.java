package Cap1._2_ProblemasAdHoc._11_Cifrado_Faciles;

import java.util.Locale;
import java.util.Scanner;

public class DRMMessages {


    public static int calcularRotacion(String texto) {
        int rotacion = 0;
        for (int i=0; i<texto.length(); i++) {
            rotacion += texto.charAt(i) - 'A';
        }
        return rotacion;
    }

    public static String rotar(String texto, int rotacion) {
        String rotada = "";
        for (int i=0; i<texto.length(); i++) {
            char letra = texto.charAt(i);
            int nuevaPos = (letra - 'A' + rotacion) % 26;
            rotada += (char) ('A' + nuevaPos);
        }
        return rotada;
    }

    public static String merge(String texto1, String texto2) {
        String resultado = "";
        for (int i=0; i<texto1.length(); i++) {
            char letra1 = texto1.charAt(i);
            char letra2 = texto2.charAt(i);
            int nuevaPos = (letra1 - 'A' + letra2 - 'A') % 26;
            resultado += (char) ('A' + nuevaPos);
        }
        return resultado;
    }
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de los datos del caso
        String texto = scan.nextLine();

        //Paso1: Dividir el texto en dos partes
        String primeraMitad = texto.substring(0, texto.length()/2);
        String segundaMitad = texto.substring(texto.length()/2);

        //Paso2:
        // 1. Calcular el valor de la rotacion de cada parte
        int rotacion1 = calcularRotacion(primeraMitad);
        int rotacion2 = calcularRotacion(segundaMitad);

        // 2. Rotar cada parte
        String rotada1 = rotar(primeraMitad, rotacion1);
        String rotada2 = rotar(segundaMitad, rotacion2);

        //Paso3: Merge de las dos partes rotadas
        String resultado = merge(rotada1, rotada2);

        //Mostrar el resultado
        System.out.println(resultado);

    }
}


