package Cap3._3_DivideYVenceras._2_BiseccionBSTAFaciles;

// Estrategia de D&C. Bisección binaria

// No sabemos el tiempo que se pasa cada grupo de monos, pero sí el total.
// También sabemos que el número de cocos que se recogen por el primer grupo es el mismo que el que se parten por el segundo grupo.
// Por tanto, podemos hacer una búsqueda binaria sobre tiempo que se tarda en recogerlos (límite inferior 0, límite superior tiempo total).
// Para cada tiempo medio, se calcula el número de cocos que se recogen y se parten.
// Si el número de cocos recogidos es mayor que el número de cocos partidos, se intenta con un tiempo menor; si no, se intenta con un tiempo mayor.

// v1. WA en Caso #4
// v2. El número de cocos que pueden recoger o partir todos los monos puede ser muy grande, usar long en lugar de int
//     Sigue el WA en Caso #4.  El planteamiento no garantiza que cada grupo de monos no tengan ningún tiempo ocioso antes del final

import java.util.Scanner;

public class Svada_WA {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Lectura del tiempo total
        int tiempoTotal = scan.nextInt();
        //Lectura del número de monos y su velocidad recogiendo cocos
        int numMonosRecogiendo = scan.nextInt();
        int[][] monosRecogiendo = new int[numMonosRecogiendo][2];
        for (int i = 0; i < numMonosRecogiendo; i++) {
            monosRecogiendo[i][0] = scan.nextInt();
            monosRecogiendo[i][1] = scan.nextInt();
        }

        //Lectura del número de monos y su velocidad partiendo cocos
        int numMonosPartiendo = scan.nextInt();
        int[][] monosPartiendo = new int[numMonosPartiendo][2];
        for (int i = 0; i < numMonosPartiendo; i++) {
            monosPartiendo[i][0] = scan.nextInt();
            monosPartiendo[i][1] = scan.nextInt();
        }


        //Búsqueda binaria del tiempo que se tarda en recoger los cocos
        int low = 0, high = tiempoTotal;
        while (high>low) {
            int mid = (low + high) / 2;
            //Calcular el número de cocos recogidos y partidos en ese tiempo
            long cocosRecogidos = 0;
            for (int i = 0; i < numMonosRecogiendo; i++) {
                // El tiempo que ha estado recogiendo cocos es mid - tiempo que tarda en prepararse
                // dividido entre el tiempo que tarda en recoger cada coco
                // Hacemos divisiones enteras, ya que un coco o se coge entero o no se coge
                cocosRecogidos += (long)(mid-monosRecogiendo[i][0]) / monosRecogiendo[i][1];
            }
            //El mismo cálculo para los cocos partidos. Ahora el tiempo que se ha estado partiendo cocos es tiempoTotal - mid
            long cocosPartidos = 0;
            for (int i = 0; i < numMonosPartiendo; i++) {
                cocosPartidos += (long)(tiempoTotal-mid-monosPartiendo[i][0]) /monosPartiendo[i][1];
            }
            if (cocosRecogidos > cocosPartidos) {
                // Se recogen más cocos de los que se parten --> intentar con un tiempo menor
                high = mid;
            } else if (cocosRecogidos < cocosPartidos) {
                // Se parten más cocos de los que se recogen --> intentar con un tiempo mayor
                low = mid + 1;
            }
            else {
                // Se recogen los mismos cocos que se parten --> solución encontrada
                low = mid;
                break;
            }

        }

        //Salida del resultado
        System.out.println(low);


    }

}

