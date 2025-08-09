package Cap3._2_BusquedaCompleta._7_ProbarTodasRespuestasPosibles;

// En este problema sólo pueden haber como máximo 4 grúas (respuestas 1, 2, 3 o 4) o bien ser imposible.
// Cada grúa podrá acceder a su lado más cercano y, quizás, a alguno de los lados adyacentes.
// Por tanto, se trata de probar todas las combinaciones posibles de 4 grúas y comprobar a cuantos lados pueden acceder.
// Habrán 30^4 combinaciones posibles, lo que es un número bajo (810.000) y se puede probar en un tiempo razonable.

// v1. TestCase #4 --> WA  (es posible que una dimensión al dividir por 2 no sea entera, y se redondee hacia abajo)


import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class LiftingWalls_WA {

    public static class Alcanzados {
        boolean[] alcanzado = new boolean[4]; // Lado izquierdo, derecho, superior e inferior

        public Alcanzados(boolean[] alcanzado) {
            this.alcanzado = alcanzado;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        // Leer las dimensiones de la casa
        int ancho = scan.nextInt();
        int alto = scan.nextInt();

        //Leer el número de grúas
        int numGruas = scan.nextInt();
        //Leer el radio de acción de las grúas
        int radioGruas = scan.nextInt();

        // Leer las posiciones de las grúas
        int[][] posicionesGruas = new int[numGruas][2];
        for (int i = 0; i < numGruas; i++) {
            int posX = scan.nextInt();
            int posY = scan.nextInt();
            posicionesGruas[i][0] = posX;
            posicionesGruas[i][1] = posY;
        }

        int minGruas = Integer.MAX_VALUE;
        Stack<Alcanzados> alcanzadosStack = new Stack<>();
        for (int i = 0; i < numGruas; i++) {
            boolean[] ladosAlcanzados = new boolean[4];
            int numGruasUsadas = 1;
            ladosAlcanzados = comprobarLadosAlcanzados(posicionesGruas[i], radioGruas, ancho, alto, ladosAlcanzados);
            alcanzadosStack.push(new Alcanzados(ladosAlcanzados));
            if (faltanLados(ladosAlcanzados)) {
                // Probar combinaciones de grúas adicionales
                for (int j = i+1; j < numGruas; j++) {
                    ladosAlcanzados = alcanzadosStack.peek().alcanzado.clone(); // Clonar el estado actual
                    numGruasUsadas=2;
                    ladosAlcanzados = comprobarLadosAlcanzados(posicionesGruas[j], radioGruas, ancho, alto, ladosAlcanzados);
                    alcanzadosStack.push(new Alcanzados(ladosAlcanzados));
                    if (faltanLados(ladosAlcanzados)) {
                        for (int k = j+1; k < numGruas; k++) {
                            ladosAlcanzados = alcanzadosStack.peek().alcanzado.clone(); // Clonar el estado actual
                            numGruasUsadas=3;
                            ladosAlcanzados = comprobarLadosAlcanzados(posicionesGruas[k], radioGruas, ancho, alto, ladosAlcanzados);
                            alcanzadosStack.push(new Alcanzados(ladosAlcanzados));
                            if (faltanLados(ladosAlcanzados)) {
                                for (int l = k + 1; l < numGruas; l++) {
                                    ladosAlcanzados = alcanzadosStack.peek().alcanzado.clone(); // Clonar el estado actual
                                    numGruasUsadas=4;
                                    ladosAlcanzados = comprobarLadosAlcanzados(posicionesGruas[l], radioGruas, ancho, alto, ladosAlcanzados);
                                    alcanzadosStack.push(new Alcanzados(ladosAlcanzados));
                                    if (!faltanLados(ladosAlcanzados)) {
                                        // Si se han alcanzado todos los lados, actualizar el mínimo de grúas usadas
                                        minGruas = Math.min(minGruas, numGruasUsadas);
                                    }
                                    alcanzadosStack.pop(); // Deshacer la última grúa añadida
                                }
                            }
                            if (!faltanLados(ladosAlcanzados)) {
                                // Si se han alcanzado todos los lados, actualizar el mínimo de grúas usadas
                                minGruas = Math.min(minGruas, numGruasUsadas);
                            }
                            alcanzadosStack.pop(); // Deshacer la última grúa añadida
                        }
                    }
                    if (!faltanLados(ladosAlcanzados)) {
                        // Si se han alcanzado todos los lados, actualizar el mínimo de grúas usadas
                        minGruas = Math.min(minGruas, numGruasUsadas);
                    }
                    alcanzadosStack.pop(); // Deshacer la última grúa añadida
                }
            }
            if (!faltanLados(ladosAlcanzados)) {
                minGruas = Math.min(minGruas, numGruasUsadas);
            }
            alcanzadosStack.pop(); // Deshacer la primera grúa añadida
        }

        // Mostrar el resultado
        if (minGruas == Integer.MAX_VALUE) {
            System.out.println("Impossible");
        } else {
            System.out.println(minGruas);
        }

    }

    private static boolean[] comprobarLadosAlcanzados(int[] posicionesGrua, int radioGruas, int ancho, int alto, boolean[] ladosAlcanzados) {
        int posX = posicionesGrua[0];
        int posY = posicionesGrua[1];

        int radioGruas2 = radioGruas * radioGruas; // Cuadrado del radio para evitar calcular la raíz cuadrada
        int posY2 = posY * posY; // Cuadrado de la posición Y para evitar calcular la raíz cuadrada
        int posX2 = posX * posX; // Cuadrado de la posición X para evitar calcular la raíz cuadrada

        // Comprobar si la grúa alcanza el centro del lado izquierdo
        if (!ladosAlcanzados[0] && (posX-(-ancho/2))*(posX-(-ancho/2)) + posY2 <= radioGruas2) {
            ladosAlcanzados[0] = true; // Lado izquierdo alcanzado
        }
        // Comprobar si la grúa alcanza el centro del lado derecho
        if (!ladosAlcanzados[1] && (posX-(ancho/2))*(posX-(ancho/2)) + posY2 <= radioGruas2) {
            ladosAlcanzados[1] = true; // Lado derecho alcanzado
        }
        // Comprobar si la grúa alcanza el centro del lado superior
        if (!ladosAlcanzados[2] && posX2 + (posY-(alto/2))*(posY-(alto/2)) <= radioGruas2) {
            ladosAlcanzados[2] = true; // Lado superior alcanzado
        }
        // Comprobar si la grúa alcanza el centro del lado inferior
        if (!ladosAlcanzados[3] && posX2 + (posY-(-alto/2))*(posY-(-alto/2)) <= radioGruas2) {
            ladosAlcanzados[3] = true; // Lado inferior alcanzado
        }

        return ladosAlcanzados;
    }

    private static boolean faltanLados(boolean[] ladosAlcanzados) {
        for (boolean lado : ladosAlcanzados) {
            if (!lado) {
                return true; // Si falta algún lado, se devuelve true
            }
        }
        return false; // Si todos los lados están alcanzados, se devuelve false
    }
}
