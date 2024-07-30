package Cap1._2_ProblemasAdHoc._1_Juegos_Naipes;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class MemoryMatch {

    public static final String UP = "UP";
     public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Datos del caso
        int cartas = scan.nextInt();
        int numMovs = scan.nextInt();

        //Leer los movimientos y apuntarlos sobre la baraja
        HashSet<String> imagenes = new HashSet<String>();
        String[] baraja = new String[cartas];
        for (int i=0; i<baraja.length;i++)
            baraja[i] = "DOWN";

        int parejasHechas= 0;

        for (int i=0; i<numMovs; i++) {
            int carta1 = scan.nextInt();
            int carta2 = scan.nextInt();
            String imagen1 = scan.next();
            String imagen2 = scan.next();

            //Si las cartas son iguales, se eliminan
            if (imagen1.equals(imagen2)) {
                baraja[carta1-1] = UP;
                baraja[carta2-1] = UP;
                if (imagenes.contains(imagen1)) {
                    imagenes.remove(imagen1);
                }
                parejasHechas++;
            } else {
                //Si no, se apuntan
                baraja[carta1-1] = imagen1;
                baraja[carta2-1] = imagen2;
                imagenes.add(imagen1);
                imagenes.add(imagen2);
            }

        }

        //Ya se han leído todos los movimientos.
        //Vamos a ver qué se puede hacer

        int nuevasParejas = 0;
        int cartasPendientes = 0;

        //En primer lugar, emparejar todas las cartas descubiertas y eliminarlas
        for (int i=0; i<baraja.length; i++) {
            //Si la imagen es conocida (está en la lista de imágenes), busco su pareja
            if (imagenes.contains(baraja[i])) {
                for (int j=i+1; j<baraja.length; j++) {
                    //Si la encuentro, elimino ambas cartas y cuento una nueva pareja
                    if (baraja[j].equals(baraja[i])) {
                        imagenes.remove(baraja[i]);
                        baraja[i] = UP;
                        baraja[j] = UP;
                        nuevasParejas++;
                        break;
                    }
                }
            }
            //Cuento las cartas que quedan por descubrir
            if (baraja[i].equals("DOWN"))
                cartasPendientes++;
        }

        //Ya se han emparejado las cartas conocidas. Ahora, a ver qué se puede hacer con las cartas restantes
        //Si quedan tantas cartas como imagenes conocidas, se pueden emparejar todas
        if (cartasPendientes == imagenes.size()) {
            nuevasParejas += imagenes.size();
            cartasPendientes -=imagenes.size();
        }

        //Si quedan sólo dos cartas, seguro que forman pareja
         if (cartasPendientes == 2) {
             nuevasParejas++;
             cartasPendientes = 0;
         }


        //Mostrar el resultado
        System.out.println(nuevasParejas);


    }
}



