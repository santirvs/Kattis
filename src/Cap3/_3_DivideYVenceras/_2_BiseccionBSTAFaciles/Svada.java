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
// v3. Hacer un primer BSTA para calcular el número de cocos y un segundo BSTA para calcular el tiempo mínimo que se tarda en procesarlos (recogerlos o partirlos)
//     El planteamiento garantiza que cada grupo de monos no tengan ningún tiempo ocioso antes del final
//     Si los tiempos coinciden, el resultado es correcto
//     --> AC


import java.io.*;
import java.util.*;

public class Svada {
    static long tiempoTotal;
    static List<long[]> monosRecogiendo, monosPartiendo;

    // Calcula cuántos cocos pueden procesarse en 'tiempo'
    static long cocosProcesados(List<long[]> listaMonos, long tiempo) {
        long ans = 0;
        for (long[] monkey : listaMonos) {
            long init = monkey[0];
            long cont = monkey[1];
            if (tiempo >= init) {
                ans++;
                ans += (tiempo - init) / cont;
            }
        }
        return ans;
    }

    // Calcula el tiempo mínimo para procesar 'numCocos'
    static long tiempoEmpleado(List<long[]> listaMonos, long numCocos) {
        long l = 0, r = (long) 1e9; // 10^9 tiempoTotal
        while (l + 1 < r) {
            long mid = (l + r) / 2;
            if (cocosProcesados(listaMonos, mid) >= numCocos) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (cocosProcesados(listaMonos, l) >= numCocos) {
            return l;
        } else {
            return r;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        //Lectura del tiempo total
        tiempoTotal = scan.nextInt();
        //Lectura del número de monos del primer grupo y su velocidad recogiendo cocos
        int numMonosRecogiendo = scan.nextInt();
        monosRecogiendo = new ArrayList<>();
        for (int i = 0; i < numMonosRecogiendo; i++) {
            long init = scan.nextLong();
            long cont = scan.nextLong();
            monosRecogiendo.add(new long[]{init, cont});
        }
        monosRecogiendo.sort(Comparator.comparingLong(x -> x[0]));

        //Lectura del número de monos del segundo grupo y su velocidad partiendo cocos
        int numMonosPartiendo = scan.nextInt();
        monosPartiendo = new ArrayList<>();
        for (int i = 0; i < numMonosPartiendo; i++) {
            long init = scan.nextLong();
            long cont = scan.nextLong();
            monosPartiendo.add(new long[]{init, cont});
        }
        monosPartiendo.sort(Comparator.comparingLong(x -> x[0]));

        // Búsqueda binaria del número de cocos que se recogen y se parten
        // El límite inferior es 0, el límite superior es el máximo número de cocos que pueden recoger o partir todos los monos en el tiempo total
        long l = 0, r = (long) 1e11; // 10^9 tiempoTotal * 10^2 numeroMonos / 1 tiempo por coco = 10^11 cocos
        while (l < r) {
            long mid = (l + r) / 2;
            if (tiempoEmpleado(monosRecogiendo, mid) + tiempoEmpleado(monosPartiendo, mid) < tiempoTotal) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        // Mostrar el resultado
        System.out.println(tiempoEmpleado(monosRecogiendo, l));
    }
}
