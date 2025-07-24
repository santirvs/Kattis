package Cap3._2_BusquedaCompleta._2_Iterativos_2BuclesAnidados;


import java.util.Scanner;

public class Liga_FaltaAlgunCaso {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numEquipos = scan.nextInt(); // Número de equipos
        scan.nextLine();

        while (numEquipos-- > 0) {
            String[] linea = scan.nextLine().split(" ");
            solve(linea);
        }

    }

    private static boolean resuelto(int numJugados, int numGanados, int numEmpatados, int numPerdidos, int puntos) {
        return numJugados != -1 && numGanados != -1 && numEmpatados != -1 && numPerdidos != -1 && puntos != -1 &&
                (numJugados == numGanados + numEmpatados + numPerdidos) &&
                (puntos == 3 * numGanados + numEmpatados);
    }

    public static void solve(String[] linea) {
        int numJugados = linea[0].equals("?") ? -1 : Integer.parseInt(linea[0]);
        int numGanados = linea[1].equals("?") ? -1 : Integer.parseInt(linea[1]);
        int numEmpatados = linea[2].equals("?") ? -1 : Integer.parseInt(linea[2]);
        int numPerdidos = linea[3].equals("?") ? -1 : Integer.parseInt(linea[3]);
        int puntos = linea[4].equals("?") ? -1 : Integer.parseInt(linea[4]);

        while (resuelto(numJugados, numGanados, numEmpatados, numPerdidos, puntos) == false) {

            //Determinar el número de partidos perdidos
            if (numPerdidos == -1 && numJugados != -1 && numGanados != -1 && numEmpatados != -1) {
                numPerdidos = numJugados - numGanados - numEmpatados;
            }
            //Determinar el número de partidos jugados
            if (numJugados == -1 && numGanados != -1 && numEmpatados != -1 && numPerdidos != -1) {
                numJugados = numGanados + numEmpatados + numPerdidos;
            }
            //Determinar el número de partidos ganados, a partir del número de partidos
            if (numGanados == -1 && numJugados != -1 && numEmpatados != -1 && numPerdidos != -1) {
                numGanados = numJugados - numEmpatados - numPerdidos;
            }
            //Determinar el número de partidos ganados, a partir del número de puntos
            if (numGanados == -1 && numEmpatados != -1 && puntos != -1) {
                numGanados = (puntos - numEmpatados) / 3; // Cada victoria da 3 puntos
            }
            //Determinar el número de partidos empatados, a partir del número de partidos
            if (numEmpatados == -1 && numJugados != -1 && numGanados != -1 && numPerdidos != -1) {
                numEmpatados = numJugados - numGanados - numPerdidos;
            }
            //Determinar el número de partidos empatados, a partir del número de puntos
            if (numEmpatados == -1 && numGanados != -1 && puntos != -1) {
                numEmpatados = puntos - (3 * numGanados); // Cada empate da 1 punto
            }
            //Determinar el número de partidos empatados si los puntos son 1 o 2
            if (numEmpatados == -1 && (puntos == 1 || puntos == 2)) {
                numEmpatados = puntos; // Cada empate da 1 punto
                numGanados = 0; // Si se determina el número de empates, los ganados se ponen a 0
            }
            //Determinar los puntos
            if (puntos == -1 && numGanados != -1 && numEmpatados != -1) {
                puntos = 3 * numGanados + numEmpatados;
            }
        }

        // Imprimir el resultado
        System.out.println(numJugados + " " + numGanados + " " + numEmpatados + " " + numPerdidos + " " + puntos);
    }

}

