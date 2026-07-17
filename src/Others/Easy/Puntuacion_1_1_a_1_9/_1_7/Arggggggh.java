package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 * A partir de las coordenadas iniciales, sumar o restar dependiendo de la dirección
 * Para las diagonales, aplicar la fórmula trigonométrica:
 *   ca = h * cos(45º)
 *   cc = h * sin(45º)
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class Arggggggh {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        //Leer los datos
        int numInstrucciones = sc.nextInt();
        double posX = sc.nextInt();
        double posY = sc.nextInt();
        double rad45 = Math.toRadians(45);
        double sin45 = Math.sin(rad45);
        double cos45 = Math.cos(rad45);

        //La primera instruccion son las coordenadas iniciales
        //Procesar las instruccions
        for (int i=1; i<numInstrucciones; i++) {
            String direccion = sc.next();
            double distancia = sc.nextDouble();

            switch (direccion) {
                case "N" : posY += distancia; break;
                case "S" : posY -= distancia; break;
                case "E" : posX += distancia; break;
                case "W" : posX -= distancia; break;
                case "NE": posY += distancia * sin45;
                           posX += distancia * cos45;
                           break;
                case "NW": posY += distancia * sin45;
                            posX -= distancia * cos45;
                            break;
                case "SE": posY -= distancia * sin45;
                            posX += distancia * cos45;
                            break;
                case "SW": posY -= distancia * sin45;
                    posX -= distancia * cos45;
                    break;
            }
        }

        //Mostrar el resultado con 8 decimales
        System.out.printf("%.8f %.8f", posX, posY);



    }
}

