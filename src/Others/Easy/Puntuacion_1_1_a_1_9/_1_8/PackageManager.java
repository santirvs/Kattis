package Others.Easy.Puntuacion_1_1_a_1_9._1_8;

/**
 * Usar un HashMap<String, Int> para guardar la versión más reciente de cada embalaje
 * Para cada almacen, leer sus embalajes y apuntar la diferencia hasta la versión más reciente
 */


import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;


public class PackageManager {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        //Leer los datos
        int numEmbalajes = sc.nextInt();
        int numAlmacenes = sc.nextInt();

        //Leer la cantidad de embalajes de cada almacén
        int[] embalajesAlmacen = new int[numAlmacenes];
        for (int i=0; i<numAlmacenes; i++) {
            embalajesAlmacen[i] = sc.nextInt();
        }

        //Leer la última versión de cada embalaje
        HashMap<String, Integer> ultimaVersion = new HashMap<>();
        for (int i=0; i<numEmbalajes; i++) {
            String nombre = sc.next();
            int version = sc.nextInt();
            ultimaVersion.put(nombre, version);
        }

        //Procesar los datos de cada almacen
        for (int i=0; i<numAlmacenes; i++) {
            int total = 0;
            for (int j=0; j<embalajesAlmacen[i]; j++) {
                String nombre = sc.next();
                int version = sc.nextInt();

                total += ultimaVersion.get(nombre) - version;
            }

            System.out.println(total);
        }


        sc.close();
    }
}

