package Others.Easy.Puntuacion_2_0_a_2_9._2_6;

import java.util.*;

public class PremierLeagueTable {

    private static class Equipo implements Comparable<Equipo> {
        String nombre = "";
        int pj = 0;
        int pg = 0;
        int pe = 0;
        int pp = 0;
        long gf = 0;
        long gc = 0;
        int pts = 0;

        Equipo(String nombre) {
            this.nombre = nombre;
        }

        public void juegaPartido(int golesFavor, int golesContra) {
            gf += golesFavor;
            gc += golesContra;
            pj += 1;
            if (golesFavor > golesContra) {
                pts+=3;
                pg++;
            } else if (golesFavor == golesContra) {
                pts++;
                pe++;
            } else {
                pp++;
            }
        }

        public long difGoles() {
            return this.gf-this.gc;
        }

        @Override
        public int compareTo(Equipo o) {
            int result = Integer.compare(o.pts, this.pts);
            //Desempate por diferencia de goles
            if (result == 0) {
                result = Long.compare(o.difGoles(), this.difGoles());
            }
            //Desempate por nombre de Equipo
            if (result == 0) {
                result = this.nombre.compareTo(o.nombre);
            }
            return result;
        }
    }


    public static void main(String[] args) {
        //Hasta 10.000 partidos, no será necesario FastReader
        Scanner sc = new Scanner(System.in);

        //Leer la cantidad de partidos
        int numPartidos = sc.nextInt();
        sc.nextLine();
        HashMap<String, Equipo> mapa = new HashMap<>();

        //Procesar cada partido
        while (numPartidos-- > 0) {
            String[] partido = sc.nextLine().split(" ");
            String equipoLocal = partido[0];
            String equipoVisitante = partido[2];
            String[] resultado = partido[1].split("-");
            int golesLocal = Integer.parseInt(resultado[0]);
            int golesVisitante = Integer.parseInt(resultado[1]);

            Equipo el;
            if (mapa.containsKey(equipoLocal)) {
                el = mapa.get(equipoLocal);
            } else {
                el = new Equipo(equipoLocal);
            }
            el.juegaPartido(golesLocal, golesVisitante);
            mapa.put(equipoLocal,el);

            Equipo ev;
            if (mapa.containsKey(equipoVisitante)) {
                ev = mapa.get(equipoVisitante);
            } else {
                ev = new Equipo(equipoVisitante);
            }
            ev.juegaPartido(golesVisitante, golesLocal);
            mapa.put(equipoVisitante,ev);
        }

        //Ordenar la clasificacion
        List<Equipo> clasificacion = new ArrayList<>(mapa.values());

        Collections.sort(clasificacion);

        //Imprimir la clasificacion
        for (Equipo e: clasificacion) {
            System.out.println(e.nombre + " " + e.pj + " " + e.pg + " " + e.pe + " " + e.pp + " " + e.gf + " " + e.gc + " " + e.difGoles() + " " + e.pts);
        }

        sc.close();
    }
}
