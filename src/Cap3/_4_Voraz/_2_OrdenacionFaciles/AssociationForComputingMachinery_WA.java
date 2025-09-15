package Cap3._4_Voraz._2_OrdenacionFaciles;

// Estrategia Voraz. Clásicos.

// Estrategia voraz.
// Leer los tiempos estimados, ordenarlos de menor a mayor y mirar si se pueden completar todos antes del límite.
// Imprimir la cantidad de problemas resueltos y el tiempo total de penalización

// v1. WA en Caso de prueba 5



import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AssociationForComputingMachinery_WA {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // Lectura del número de problemas
        int n = sc.nextInt();
        // Lectura del primer problema a resolver
        int primero = sc.nextInt();
        // Lectura de los tiempos estimados
        ArrayList<Integer> tiempos = new ArrayList<>();
        int penalizacion = 0;
        int tiempoInicial = 0;
        int tiempoTotal = 0;
        int resueltos = 0;
        for (int i = 0; i < n; i++) {
            if (i == primero) {
                penalizacion = sc.nextInt();
            } else {
                tiempos.add(sc.nextInt());
            }
        }

        // Ordenar los tiempos de menor a mayor
        Collections.sort(tiempos);

        // Ir resolviendo problemas mientras entren en el límite de tiempo ( 300 minutos )
        while (tiempoInicial <= 300 && tiempos.size() > 0) {

            if (tiempoInicial + penalizacion <= 300) {
                // Es posible resolver el problema
                tiempoTotal += tiempoInicial + penalizacion;  // Actualizar el tiempo total de penalización
                resueltos++;
            }

            // Actualizar el tiempo inicial para el siguiente problema
            tiempoInicial += penalizacion;
            // Siguiente problema a resolver
            penalizacion = tiempos.remove(0);
        }

        // Imprimir el resultado
        System.out.println(resueltos + " " + tiempoTotal);
    }

    // Scanner rápido
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = readByte()) != -1 && c <= ' ');
            if (c == -1) return null;
            do {
                sb.append((char)c);
            } while ((c = readByte()) != -1 && c > ' ');
            return sb.toString();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
