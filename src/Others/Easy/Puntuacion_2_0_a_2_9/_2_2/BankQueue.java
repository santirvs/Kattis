package Others.Easy.Puntuacion_2_0_a_2_9._2_2;

/**
 * No es pot fer servir una cua amb prioritat (temps límit, import) perquè aquest cas fallaria
 *    temps límit 1 seg,  cua  { (100,0), (1000,1), (1000,1) }
 *
 * Com que tenim poc temps (com a màxim 47 seg) podem fer un Array de clients a despatxar que indica en quin moment
 * es despatxa a aquell client. Els intentarem despatxar el més tard possible.
 *
 * Ordenem els clients per import. Agafem el de més import i el despatxem en l'instant màxim que pot esperar.
 * Agafem el següent client i mirem de despatxar-lo en l'instant màxim. Si està ocupat, el despatxem en l'anterior.
 * I així, fins que tinguem tots els clients que poguem despatxar.
 *
 *
 *
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.PriorityQueue;

public class BankQueue {


    static class FR_Int {
        private InputStream in = System.in;
        private byte[] buffer = new byte[1 << 16];
        private int head = 0;
        private int tail = 0;

        private int read() throws IOException {
            if (head >= tail) {
                head = 0;
                tail = in.read(buffer, 0, buffer.length);
                if (tail <= 0) return -1;
                // Fin de archivo
            }
            return buffer[head++];
        }

        public int nextInt() throws IOException {
            int c = read();
            // Ignorar espacios en blanco o saltos de línea (ASCII <= 32)
            while (c != -1 && c <= 32) {
                c = read();
            }
            if (c == -1) return -1; // EOF
            boolean negativo = false;
            if (c == '-') {
                negativo = true;
                c = read();
            }

            int res = 0;
            // Construir el número mientras el carácter sea visible (> 32)
            while (c > 32) {
                res = res * 10 + (c - '0');
                c = read();
            }

            if (negativo) return -res;
            else return res;
        }
    }

    static class Client implements Comparable<Client> {

        int importe;
        int tiempo;

        Client(int importe, int tiempo) {
            this.importe = importe;
            this.tiempo = tiempo;
        }
        @Override
        public int compareTo(Client o) {
            return o.importe - this.importe;
        }
    }

    public static void main(String[] args) throws IOException {

        FR_Int sc = new FR_Int();

        int numClientes = sc.nextInt();
        int tiempoMaximo = sc.nextInt();

        Client[] despachados = new Client[tiempoMaximo];


        PriorityQueue<Client> cola = new PriorityQueue<>();
        for (int i=0; i<numClientes; i++) {
            int importe = sc.nextInt();
            int tiempo = sc.nextInt();
            cola.add(new Client(importe, tiempo));
        }

        //Assignar els clients segons el màxim
        //Si algun client no pot ser assignat, el saltem
        int numClientsAssignats = 0;

        while (numClientsAssignats < tiempoMaximo && !cola.isEmpty()) {
            Client c = cola.poll();
            boolean assignat = false;
            for (int i=c.tiempo; i>=0 && !assignat; i-- ) {
                if (despachados[i] == null) {
                    assignat = true;
                    despachados[i] = c;
                    numClientsAssignats++;
                }
            }
        }

        //Sumem l'import dels clients assignats
        int totalImporte = 0;
        for (int i=0; i< despachados.length; i++) {
            if (despachados[i] != null) totalImporte += despachados[i].importe;
        }

        System.out.println(totalImporte);
    }
}
