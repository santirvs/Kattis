package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._7_BST_Equilibrado_Set;

import java.io.IOException;
import java.util.*;

public class RaceDay {

    static class Runner {
        String nombre;
        String apellido;
        String xip;
        int tiempoF = 0;
        int tiempoS1 = 0;
        int tiempoS2 = 0;
        int posS1 = 0;
        int posS2 = 0;
        int posF = 0;

        public Runner(String nombre, String apellido, String xip) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.xip = xip;
        }

        public String toMMSS(int tiempo) {
            int mins = tiempo / 60;
            int secs = tiempo % 60;
            return String.format("%02d:%02d", mins, secs);
        }

        public String toString() {
            String result = String.format("%-20s%10s%10s%10s%10s%10s%10s%10s",apellido + ", " + nombre,xip,toMMSS(tiempoS1),posS1,toMMSS(tiempoS2),posS2,toMMSS(tiempoF),posF);
            //return "%-20s%10s%10s%10s%10s%10s%10s%10s".format(apellido + ", " + nombre,xip,tiempoS1,posS1,tiempoS2,posS2,tiempoF,posF);
            return result;
        }
    }

    public static class ComparadorS1 implements Comparator<Runner> {
        @Override
        public int compare(Runner r1, Runner r2) {
            return  r1.tiempoS1 - r2.tiempoS1;
        }
    }
    public static class ComparadorS2 implements Comparator<Runner> {
        @Override
        public int compare(Runner r1, Runner r2) {
            return  r1.tiempoS2 - r2.tiempoS2;
        }
    }
    public static class ComparadorF implements Comparator<Runner> {
        @Override
        public int compare(Runner r1, Runner r2) {
            return  r1.tiempoF - r2.tiempoF;
        }
    }
    public static class ComparadorNombre implements Comparator<Runner> {
        @Override
        public int compare(Runner r1, Runner r2) {
            int result = r1.apellido.compareTo(r2.apellido);
            if (result == 0) {
                result = r1.nombre.compareTo(r2.nombre);
            }
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int numRunners = scan.nextInt();

        while (numRunners > 0 ) {
            TreeMap<String, Runner> mapaRunners = new TreeMap<>();
            ArrayList<Runner> listaCorredores = new ArrayList<>();

            int numTiempos = 3 * numRunners;

            //Leer los nombres de los corredores
            while (numRunners > 0) {
                String nombre = scan.next();
                String apellido = scan.next();
                String xip = scan.next();
                Runner runner = new Runner(nombre, apellido, xip);
                listaCorredores.add(runner);
                mapaRunners.put(xip, runner);

                numRunners--;
            }

            //Leer los tiempos de los corredores
            while (numTiempos > 0) {
                String xip = scan.next();
                String split = scan.next();
                String tiempo = scan.next();
                String[] tiempoPartes = tiempo.split(":");
                int tiempoSecs = Integer.parseInt(tiempoPartes[0]) * 60 + Integer.parseInt(tiempoPartes[1]);
                Runner runner = mapaRunners.get(xip);
                switch (split) {
                    case "F":
                        runner.tiempoF = tiempoSecs;
                        break;
                    case "S1":
                        runner.tiempoS1 = tiempoSecs;
                        break;
                    case "S2":
                        runner.tiempoS2 = tiempoSecs;
                        break;
                }

                numTiempos--;
            }

            //Ordenar los corredores
            listaCorredores.sort(new ComparadorS1());
            //Asignar posiciones
            int pos = 1;
            int posAnt = 1;
            int tiempoAnt = 0;
            for (Runner runner: listaCorredores) {
                if (runner.tiempoS1 != tiempoAnt) {
                    runner.posS1 = pos;
                    posAnt = pos;
                    tiempoAnt = runner.tiempoS1;
                }
                else {
                    runner.posS1 = posAnt;
                }
                pos++;
            }

            //Ordenar los corredores
            listaCorredores.sort(new ComparadorS2());
            //Asignar posiciones
            pos = 1;
            posAnt = 1;
            tiempoAnt = 0;
            for (Runner runner: listaCorredores) {
                if (runner.tiempoS2 != tiempoAnt) {
                    runner.posS2 = pos;
                    posAnt = pos;
                    tiempoAnt = runner.tiempoS2;
                }
                else {
                    runner.posS2 = posAnt;
                }
                pos++;
            }

            //Ordenar los corredores
            listaCorredores.sort(new ComparadorF());
            //Asignar posiciones
            pos = 1;
            posAnt = 1;
            tiempoAnt = 0;
            for (Runner runner: listaCorredores) {
                if (runner.tiempoF != tiempoAnt) {
                    runner.posF = pos;
                    posAnt = pos;
                    tiempoAnt = runner.tiempoF;
                }
                else {
                    runner.posF = posAnt;
                }
                pos++;
            }

            listaCorredores.sort(new ComparadorNombre());

            //Mostrar los resultados
            System.out.printf("%-20s%10s%10s%10s%10s%10s%10s%10s\n", "NAME", "BIB", "SPLIT1","RANK", "SPLIT2","RANK", "FINISH","RANK");
            for (Runner runner: listaCorredores) {
                System.out.println(runner.toString());
            }
            System.out.println();

            //Siguiente carrera
            numRunners = scan.nextInt();
        }
    }
}