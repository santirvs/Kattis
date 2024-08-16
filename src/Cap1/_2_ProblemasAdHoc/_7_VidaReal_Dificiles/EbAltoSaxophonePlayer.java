package Cap1._2_ProblemasAdHoc._7_VidaReal_Dificiles;


import java.util.Locale;
import java.util.Scanner;

public class EbAltoSaxophonePlayer {


        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            scan.useLocale(Locale.ENGLISH);

            //Definir las notas
            int[] notas = new int[15];
            notas[0]  = 0b0000000000;
            notas[1]  = 0b1110000000; //A
            notas[2]  = 0b1100000000; //B
            notas[3]  = 0b0010000000; //C
            notas[4]  = 0b1111001110; //D
            notas[5]  = 0b1111001100; //E
            notas[6]  = 0b1111001000; //F
            notas[7]  = 0b1111000000; //G
            notas[8]  = 0b0110000000; //a
            notas[9]  = 0b0100000000; //b
            notas[10] = 0b0111001111; //c
            notas[11] = 0b0111001110; //d
            notas[12] = 0b0111001100; //e
            notas[13] = 0b0111001000; //f
            notas[14] = 0b0111000000; //g

            //Leer el número de casos
            int numCasos = scan.nextInt();
            scan.nextLine();
            while (numCasos > 0) {
                int[] dedos = new int[10];
                int notaAnterior = notas[0];

                //Leer la línea
                String cancion = scan.nextLine();

                for (int i = 0; i < cancion.length(); i++) {
                    char nota = cancion.charAt(i);
                    int codigoNota;
                    if (Character.isLowerCase(nota)) {
                        codigoNota = notas[nota - 'a' + 8];
                    }
                    else {
                        codigoNota = notas[nota - 'A' + 1];
                    }

                    //Calcular la diferencia entre la nota anterior y la actual
                    //Hacemos XOR para ver qué dedos se han de mover
                    //Y se hace un AND para ver qué dedos se han de pulsar
                    int diferenciaNotas = (notaAnterior ^ codigoNota) & codigoNota;

                    //Mirar si cada dedo se ha de pulsar
                    for (int j = 10; j > 0; j--) {
                        if ((diferenciaNotas & (1 << (j-1))) != 0) {
                            dedos[10-j]++;
                        }
                    }

                    notaAnterior = codigoNota;
                }

                //Imprimir el resultado
                for (int i = 0; i < 10; i++) {
                    System.out.print(dedos[i]);
                    if (i != 9) {
                        System.out.print(" ");
                    }
                }
                System.out.println();

                numCasos--;
            }



     }

}
