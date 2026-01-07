package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer la quadkey
// El zoom és la longitud de la quadkey
// Las coordenadas se buscarán en base a la quadkey
// El límite de las coordenadas es 2^longitud-1


import java.util.Scanner;


public class IdentifyingMapTiles {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer la quadkey
        String quadKey = sc.nextLine();
        int longitudKey = quadKey.length();

        //número máximo de las coordenadas
        long minX = 0;
        long maxX = (long) Math.pow(2.0,longitudKey) -1;
        long minY = 0;
        long maxY = maxX;

        for (int i=0; i<longitudKey; i++) {
            switch (quadKey.charAt(i)) {
                case '0':
                    maxX = minX + (maxX - minX) / 2 ;
                    maxY = minY + (maxY - minY) / 2;
                    break;
                case '1':
                    minX = minX + (maxX - minX) / 2 + 1;
                    maxY = minY + (maxY - minY) / 2;
                    break;
                case '2':
                    maxX = minX + (maxX - minX) / 2;
                    minY = minY + (maxY - minY) / 2 + 1;
                    break;
                case '3':
                    minX = minX + (maxX - minX) / 2 + 1;
                    minY = minY + (maxY - minY) / 2 + 1;
                    break;
            }
        }
        System.out.println(longitudKey + " " + minX + " " + minY);

    }
}

