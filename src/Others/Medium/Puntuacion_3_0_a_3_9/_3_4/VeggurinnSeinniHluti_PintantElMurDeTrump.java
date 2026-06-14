package Others.Medium.Puntuacion_3_0_a_3_9._3_4;

/*
    Leer todos los tramos, ordenarlos por inicio
    Procesarlos en orden. Si el siguiente tramo no tiene continuidad con el anterior, acumular el anterior
    y comenzar uno nuevo.
    No olvidarse del último!!!
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class VeggurinnSeinniHluti_PintantElMurDeTrump {
    static class FR_Int {
        private InputStream in = System.in;
        private byte[ ] buffer = new byte[1 << 16];
        private int head = 0;
        private int tail = 0;

        private int read() throws IOException {
            if (head >= tail) {
                head = 0;
                tail = in.read(buffer, 0, buffer.length);
                if (tail <= 0) return -1;   // Fin de archivo
            }
            return buffer[head++];    }

        public long nextLong() throws IOException {
            int c = read();
            // Ignorar espacios en blanco o saltos de línea (ASCII <= 32)
            while (c != -1 && c <= 32) {    c = read();       }

            if (c == -1) return -1; // EOF
            boolean negativo = false;
            if (c == '-') {  negativo = true;  c = read();     }
            long res = 0;
            // Construir el número mientras el carácter sea visible (> 32)
            while (c > 32) {
                res = res * 10 + (c - '0');
                c = read();
            }
            return res;
        }     }

    public static class Tramo implements Comparable<Tramo> {
        long inicio;
        long fin;

        Tramo(long inicio, long fin) {
            this.inicio = inicio;
            this.fin = fin;
        }

        @Override
        public int compareTo(Tramo o) {
            // Primero comparamos por el punto de inicio
            int compInicio = Long.compare(this.inicio, o.inicio);
            if (compInicio != 0) {
                return compInicio;
            }
            // Si tienen el mismo inicio, desempatamos por el punto de fin
            return Long.compare(this.fin, o.fin);
        }
    }

    public static void main(String[] args) throws IOException {
        //Scanner scan = new Scanner(System.in);
        FR_Int scan = new FR_Int();

        long muros = scan.nextLong();
        long viajes = scan.nextLong();

        //Leer los tramos
        ArrayList<Tramo> tramos = new ArrayList<>();
        for (int i=0; i<viajes; i++) {
            long inicio = scan.nextLong();
            long fin = scan.nextLong();

            tramos.add( new Tramo(inicio, fin));
        }

        //Ordenar los tramos
        Collections.sort(tramos);

        //Procesar los tramos
        long inicioTramo = -1;
        long finalTramo = -1;
        long totalTramos = 0;
        for (Tramo t : tramos) {
            if (finalTramo >= t.inicio) {
                //El nuevo tramo se solapa o continúa con el anterior
                finalTramo = Math.max(finalTramo, t.fin);
            }
            else {
                //El nuevo tramo está desconectado del anterior
                if (inicioTramo!=-1)
                    totalTramos += finalTramo-inicioTramo+1;
                inicioTramo = t.inicio;
                finalTramo = t.fin;
            }
        }

        //Añadir el último tramo
        if (inicioTramo!=-1)
            totalTramos += finalTramo - inicioTramo +1;

        //Imprimir el total de tramos
        System.out.println(totalTramos);

        if (totalTramos * 2 > muros) System.out.println("The Mexicans took our jobs! Sad!");
        else System.out.println("The Mexicans are Lazy! Sad!");

        //scan.close();
    }
}