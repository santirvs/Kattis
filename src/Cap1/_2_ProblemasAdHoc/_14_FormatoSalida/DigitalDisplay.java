package Cap1._2_ProblemasAdHoc._14_FormatoSalida;

import Cap1._2_ProblemasAdHoc._4_Juegos_Dificiles.Kattio;

public class DigitalDisplay {

    public static char[][] relojNuevo() {
        char[][] reloj = {
                "+---+  +---+     +---+  +---+".toCharArray(),
                "|   |  |   |     |   |  |   |".toCharArray(),
                "|   |  |   |  o  |   |  |   |".toCharArray(),
                "+---+  +---+     +---+  +---+".toCharArray(),
                "|   |  |   |  o  |   |  |   |".toCharArray(),
                "|   |  |   |     |   |  |   |".toCharArray(),
                "+---+  +---+     +---+  +---+".toCharArray()
        };
        return reloj;
    }

    public static void ajustarReloj(char[][] reloj, char c, int pos) {
        int offset = pos * 7 + (pos>=2? -4:0);

        if (c=='1') {
            for (int i = 0; i < 7; i++) {
                for (int fila = 0; fila < 4; fila++) {
                    reloj[i][offset + fila] = ' ';
                }
            }
        } else if (c=='2') {
            reloj[1][offset + 0] = ' ';
            reloj[2][offset + 0] = ' ';
            reloj[4][offset + 4] = ' ';
            reloj[5][offset + 4] = ' ';
        }
        else if (c=='3') {
            reloj[1][offset + 0] = ' ';
            reloj[2][offset + 0] = ' ';
            reloj[4][offset + 0] = ' ';
            reloj[5][offset + 0] = ' ';
        } else if (c=='4') {
            for (int i=1;i<4;i++) {
                reloj[0][offset + i] = ' ';
                reloj[6][offset + i] = ' ';
            }
            reloj[4][offset + 0] = ' ';
            reloj[5][offset + 0] = ' ';
            reloj[6][offset + 0] = ' ';
        } else if (c=='5') {
            reloj[1][offset + 4] = ' ';
            reloj[2][offset + 4] = ' ';
            reloj[4][offset + 0] = ' ';
            reloj[5][offset + 0] = ' ';
        } else if (c=='6') {
            reloj[1][offset + 4] = ' ';
            reloj[2][offset + 4] = ' ';
        } else if (c=='7') {
            reloj[1][offset + 0] = ' ';
            reloj[2][offset + 0] = ' ';
            for (int i=0; i<4; i++) {
                reloj[3][offset + i] = ' ';
            }
            reloj[4][offset + 0] = ' ';
            reloj[5][offset + 0] = ' ';
            for (int i=0; i<4; i++) {
                reloj[6][offset + i] = ' ';
            }
        } else if (c=='8') {
            //Nada
        } else if (c=='9') {
            reloj[4][offset + 0] = ' ';
            reloj[5][offset + 0] = ' ';
        } else if (c=='0') {
            for (int i=1; i<4; i++) {
                reloj[3][offset + i] = ' ';
            }
        }


    }

     public static void main(String[] args) {

        //Scanner scan = new Scanner(System.in);
        //scan.useLocale(Locale.ENGLISH);

         Kattio scan = new Kattio(System.in, System.out);

        //Leer la entrada
        //String hora = scan.nextLine();
         String hora = scan.getWord();
        while (!hora.equals("end")) {

            char[][] reloj = relojNuevo();
            for (int i = 0; i < 5; i++) {
               if (i!=2) {
                   ajustarReloj(reloj, hora.charAt(i), i);
               }
            }

            //Imprimir el reloj
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < reloj[i].length; j++) {
                    System.out.print(reloj[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();

            //hora = scan.nextLine();
            hora = scan.getWord();
        }
        System.out.println(hora);

    }
}


