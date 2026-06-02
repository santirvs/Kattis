package Others.Medium.Puntuacion_3_0_a_3_9._3_2;

import java.util.Scanner;

public class CrashingRobots {

    // NUEVO ORDEN HORARIO: 0=N, 1=E, 2=S, 3=W
    public static int avanzarX(int valor) {
        switch (valor / 1000) {
            case 0: return 0;   // N -> No se mueve en X
            case 1: return 1;   // E -> Avanza a la derecha (+1)
            case 2: return 0;   // S -> No se mueve en X
            case 3: return -1;  // W -> Avanza a la izquierda (-1)
            default: return 0;
        }
    }

    public static int avanzarY(int valor) {
        switch (valor / 1000) {
            case 0: return 1;   // N -> En el problema, el eje Y crece hacia arriba (+1)
            case 1: return 0;   // E -> No se mueve en Y
            case 2: return -1;  // S -> El eje Y decrece hacia abajo (-1)
            case 3: return 0;   // W -> No se mueve en Y
            default: return 0;
        }
    }

    public static int valorDir(String dir) {
        if (dir.equals("N")) return 0;
        if (dir.equals("E")) return 1000;
        if (dir.equals("S")) return 2000;
        if (dir.equals("W")) return 3000;
        return 0;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        if (!scan.hasNextInt()) return;
        int numCasos = scan.nextInt();

        for (int caso = 0; caso < numCasos; caso++) {

            int ancho = scan.nextInt();
            int alto = scan.nextInt();

            // Matriz que representa el plano cartesiano.
            // Usamos alto + 1 y ancho + 1 para usar las coordenadas 1-indexadas directamente del problema
            int[][] almacen = new int[alto + 1][ancho + 1];

            int numRobots = scan.nextInt();
            int numInstrucciones = scan.nextInt();
            int[][] posRobots = new int[numRobots + 1][2];

            // Posicionar los robots
            for (int robot = 1; robot <= numRobots; robot++) {
                int columna = scan.nextInt(); // Coordenada X (1 a ancho)
                int fila = scan.nextInt();    // Coordenada Y (1 a alto)
                String dir = scan.next().trim();

                almacen[fila][columna] = valorDir(dir) + robot;
                posRobots[robot][0] = fila;
                posRobots[robot][1] = columna;
            }

            boolean crashed = false;
            String msg = "OK";

            for (int i = 0; i < numInstrucciones; i++) {
                int robot = scan.nextInt();
                String accion = scan.next().trim();
                int repeticiones = scan.nextInt();

                if (!crashed) {
                    int fila = posRobots[robot][0];
                    int columna = posRobots[robot][1];
                    int valorRobot = almacen[fila][columna];

                    int dirActual = valorRobot / 1000;
                    int idRobot = valorRobot % 1000;

                    if (accion.equals("R")) {
                        // Sentido horario: N(0) -> E(1) -> S(2) -> W(3)
                        dirActual = (dirActual + repeticiones) % 4;
                        almacen[fila][columna] = (dirActual * 1000) + idRobot;
                    }
                    else if (accion.equals("L")) {
                        // Sentido antihorario: restamos y aseguramos que sea positivo
                        dirActual = (dirActual - (repeticiones % 4) + 4) % 4;
                        almacen[fila][columna] = (dirActual * 1000) + idRobot;
                    }
                    else if (accion.equals("F")) {
                        int dx = avanzarX(valorRobot);
                        int dy = avanzarY(valorRobot);

                        // Variables para seguir el rastro exacto del movimiento paso a paso
                        int fActual = fila;
                        int cActual = columna;

                        for (int paso = 1; paso <= repeticiones && !crashed; paso++) {
                            fActual += dy;
                            cActual += dx;

                            // Verificar límites del almacén (coordenadas entre 1 y alto/ancho)
                            if (fActual < 1 || fActual > alto || cActual < 1 || cActual > ancho) {
                                crashed = true;
                                msg = "Robot " + robot + " crashes into the wall";
                            }
                            // Verificar si la casilla está ocupada por OTRO robot
                            else if (almacen[fActual][cActual] != 0) {
                                int otroRobot = almacen[fActual][cActual] % 1000;
                                crashed = true;
                                msg = "Robot " + robot + " crashes into robot " + otroRobot;
                            }
                        }

                        if (!crashed) {
                            // Movemos el robot a su posición final tras los 'N' avances
                            almacen[fActual][cActual] = almacen[fila][columna];
                            almacen[fila][columna] = 0; // Vaciamos la casilla antigua
                            posRobots[robot][0] = fActual;
                            posRobots[robot][1] = cActual;
                        }
                    }
                }
            }
            System.out.println(msg);
        }
        scan.close();
    }
}