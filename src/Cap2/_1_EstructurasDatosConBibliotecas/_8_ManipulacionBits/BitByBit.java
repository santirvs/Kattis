package Cap2._1_EstructurasDatosConBibliotecas._8_ManipulacionBits;

import java.util.*;


public class BitByBit {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numInstrucciones = scan.nextInt();
        while (numInstrucciones > 0 ) {
            //Valor inicial
            char[] bits = new char[32];
            Arrays.fill(bits, '?');

            while (numInstrucciones > 0) {
                numInstrucciones--;

                String comando = scan.next();
                int pos1 = 31 - scan.nextInt();
                int pos2 = -1;
                if (comando.equals("AND") || comando.equals("OR"))
                    pos2 = 31 - scan.nextInt();

                switch (comando) {
                    case "SET":
                        //Se establece a 1 el bit
                        bits[pos1] = '1';
                        break;
                    case "CLEAR":
                        //Se establece a 0 el bit
                        bits[pos1] = '0';
                        break;
                    case "AND":
                        //Si alguno de los bits es 0, el resultado es 0
                        //Si alguno de los bits es ?, el resultado es ?
                        //En otro caso, el resultado es 1
                        if (bits[pos1] == '0' || bits[pos2] == '0')
                            bits[pos1] = '0';
                        else if (bits[pos1] == '?' || bits[pos2] == '?')
                            bits[pos1] = '?';
                        else
                            bits[pos1] = '1';
                        break;
                    case "OR":
                        //Si alguno de los bits es 1, el resultado es 1
                        //Si alguno de los bits es ?, el resultado es ?
                        //En otro caso, el resultado es 0
                        if (bits[pos1] == '1' || bits[pos2] == '1')
                            bits[pos1] = '1';
                        else if (bits[pos1] == '?' || bits[pos2] == '?')
                            bits[pos1] = '?';
                        else
                            bits[pos1] = '0';
                        break;
                }
            }
            //Mostar el resultado
            System.out.println(new String(bits));

            //Siguiente caso
            numInstrucciones = scan.nextInt();
        }


    }

}
