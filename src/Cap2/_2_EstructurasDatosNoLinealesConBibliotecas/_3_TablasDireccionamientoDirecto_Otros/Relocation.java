package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._3_TablasDireccionamientoDirecto_Otros;

import java.io.*;

// Usar una TAD para guardar las posiciones de las compañías
// Si una compañía se mueve, basta con actualizar la posición de la TAD
// La distancia entre dos compañías es la diferencia entre sus posiciones

// Caso 2: TLE -> Usar Fast I/O -> AC


public class Relocation {

    static class FastIO {
        BufferedReader in;
        PrintWriter out;

        FastIO() {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        }

        int nextInt() throws Exception {
            return Integer.parseInt(in.readLine());
        }

        String nextLine() throws Exception {
            return in.readLine();
        }

        String next() throws Exception {
            StringBuilder s = new StringBuilder();
            while (true) {
                int c = in.read();
                if (Character.isWhitespace(c) || c == -1) {
                    break;
                }
                s.append((char) c);
            }
            return s.toString();
        }

        void print(String s) {
            out.print(s);
            out.flush();
        }

        void print(int i) {
            this.print("" + i);
        }

        void println(String s) {
            out.println(s);
            out.flush();
        }

        void println(int i) {
            this.println("" + i);
        }
    }


    public static void main(String[] args) throws Exception  {
        FastIO scan = new FastIO();

        //Leer el número de compañías y consultas
        String[] partes = scan.nextLine().split(" ");
        int numCompanias = Integer.parseInt(partes[0]);
        int numConsultas = Integer.parseInt(partes[1]);

        //Leer la posición inicial de cada compañía
        int[] posiciones = new int[numCompanias+1];
        partes = scan.nextLine().split(" ");
        for (int i = 1; i <= numCompanias; i++) {
            posiciones[i] = Integer.parseInt(partes[i-1]);
        }

        //Leer las consultas
        for (int i = 0; i < numConsultas; i++) {
            partes = scan.nextLine().split(" ");
            int tipoConsulta = Integer.parseInt(partes[0]);
            int compania1 = Integer.parseInt(partes[1]);
            int compania2 = Integer.parseInt(partes[2]);

            if (tipoConsulta == 1) {
                //La compañía cambia de posición
                posiciones[compania1] = compania2;
            } else {
                //Consulta la posición entre dos compañías
                System.out.println(Math.abs(posiciones[compania1] - posiciones[compania2]));
            }
        }

    }
}
