package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer la secuencia de puntos en un String
// Recorrer el String caracter a caracter hasta el final
//  - Si el caracter es 'T', incrementar el contador de Truls
//  - Si el caracter es 'H', incrementar el contador de Henry
//  - Si alguno supera los 11 puntos y la diferencia es mayor o igual a 2, resetear los contadores
// Al final, mostrar el resultado Truls - Henry

import java.util.Scanner;

public class TrulsTroubles {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la secuencia de puntos
        String secuencia = sc.nextLine();
        int puntosTruls = 0;
        int puntosHenry = 0;
        // Recorrer la secuencia
        for (int i = 0; i < secuencia.length(); i++) {
            char punto = secuencia.charAt(i);
            if (punto == 'T') {
                puntosTruls++;
            } else if (punto == 'H') {
                puntosHenry++;
            }

            // Comprobar si alguien ha ganado la ronda
            if ((puntosTruls >= 11 || puntosHenry >= 11) && Math.abs(puntosTruls - puntosHenry) >= 2) {
                puntosTruls = 0;
                puntosHenry = 0;
            }
        }

        // Mostrar el resultado
        System.out.println(puntosTruls + "-" + puntosHenry);


        sc.close();
    }
}

