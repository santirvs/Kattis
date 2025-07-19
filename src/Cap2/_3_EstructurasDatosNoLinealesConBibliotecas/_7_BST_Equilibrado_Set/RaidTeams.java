package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._7_BST_Equilibrado_Set;

import java.io.*;
import java.util.*;

// TestCase #2 a #6 --> WA  --> Probar quien se elige en caso de empate! Correcto, se elige el menor
// Al presentar los nombres, se presentan ordenados alfabéticamente  --> AC hasta el #21 -> TLE
// TestCase #21: TLE --> Cambio a Fast Input/Output --> AC!!

public class RaidTeams {

    static class Aventurer {
        String nombre;
        int skill1;
        int skill2;
        int skill3;

        public Aventurer(String nombre, int skill1, int skill2, int skill3) {
            this.nombre = nombre;
            this.skill1 = skill1;
            this.skill2 = skill2;
            this.skill3 = skill3;
        }

    }

    public static class ComparadorS1 implements Comparator<Aventurer> {
        @Override
        public int compare(Aventurer a1, Aventurer a2) {
            int result = a2.skill1 - a1.skill1;
            if (result == 0)
                result = a1.nombre.compareTo(a2.nombre);
            return result;
        }
    }
    public static class ComparadorS2 implements Comparator<Aventurer> {
        @Override
        public int compare(Aventurer a1, Aventurer a2) {
            int result = a2.skill2 - a1.skill2;
            if (result == 0)
                result = a1.nombre.compareTo(a2.nombre);
            return result;
        }
    }
    public static class ComparadorS3 implements Comparator<Aventurer> {
        @Override
        public int compare(Aventurer a1, Aventurer a2) {
            int result = a2.skill3 - a1.skill3;
            if (result == 0)
                result = a1.nombre.compareTo(a2.nombre);
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        //Scanner scan = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));


        int numMiembros = Integer.parseInt(in.readLine());
        TreeSet<Aventurer> mapaAventurersS1 = new TreeSet<>(new ComparadorS1());
        TreeSet<Aventurer> mapaAventurersS2 = new TreeSet<>(new ComparadorS2());
        TreeSet<Aventurer> mapaAventurersS3 = new TreeSet<>(new ComparadorS3());

        while (numMiembros > 0 ) {
            String[] partes = in.readLine().split(" ");
            String nombre = partes[0];
            int skill1 = Integer.parseInt(partes[1]);
            int skill2 = Integer.parseInt(partes[2]);
            int skill3 = Integer.parseInt(partes[3]);

            Aventurer aventurer = new Aventurer(nombre, skill1, skill2, skill3);
            mapaAventurersS1.add(aventurer);
            mapaAventurersS2.add(aventurer);
            mapaAventurersS3.add(aventurer);

            numMiembros--;
        }

        while (mapaAventurersS1.size() >= 3) {
            List<String> miembrosEquipo = new ArrayList<>();
            Aventurer a1 = mapaAventurersS1.pollFirst();
            mapaAventurersS2.remove(a1);
            mapaAventurersS3.remove(a1);
            Aventurer a2 = mapaAventurersS2.pollFirst();
            mapaAventurersS1.remove(a2);
            mapaAventurersS3.remove(a2);
            Aventurer a3 = mapaAventurersS3.pollFirst();
            mapaAventurersS1.remove(a3);
            mapaAventurersS2.remove(a3);
            miembrosEquipo.add(a1.nombre);
            miembrosEquipo.add(a2.nombre);
            miembrosEquipo.add(a3.nombre);
            Collections.sort(miembrosEquipo);
            out.println(miembrosEquipo.get(0) + " " + miembrosEquipo.get(1) + " " + miembrosEquipo.get(2));
        }

        out.flush();
        out.close();
        in.close();


    }
}