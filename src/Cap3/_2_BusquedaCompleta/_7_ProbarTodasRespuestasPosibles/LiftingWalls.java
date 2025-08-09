package Cap3._2_BusquedaCompleta._7_ProbarTodasRespuestasPosibles;

// En este problema sólo pueden haber como máximo 4 grúas (respuestas 1, 2, 3 o 4) o bien ser imposible.
// Cada grúa podrá acceder a su lado más cercano y, quizás, a alguno de los lados adyacentes.
// Por tanto, se trata de probar todas las combinaciones posibles de 4 grúas y comprobar a cuantos lados pueden acceder.
// Habrán 30^4 combinaciones posibles, lo que es un número bajo (810.000) y se puede probar en un tiempo razonable.

// v1. TestCase #4 --> WA
// v2. No encuentro el error, cambio el enfoque:
//   Para cada grúa, busco qué muros alcanza
//   y luego pruebo combinaciones de hasta 4 grúas. En el momento que una combinación alcanza todos los muros, paro.



import java.io.*;
import java.util.*;

public class LiftingWalls {

    static final double EPSILON = 1e-12;
    static List<double[]> centros = new ArrayList<>();
    static List<List<Integer>> gruas;

    static double dist(double[] a, double[] b) {
        return Math.sqrt((a[0] - b[0]) * (a[0] - b[0]) +
                (a[1] - b[1]) * (a[1] - b[1]));
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int largo = scan.nextInt();
        int ancho = scan.nextInt();
        int numGruas = scan.nextInt();
        int radio = scan.nextInt();

        // Definir los centros de los muros
        centros.add(new double[]{-largo / 2.0, 0});
        centros.add(new double[]{largo / 2.0, 0});
        centros.add(new double[]{0, -ancho / 2.0});
        centros.add(new double[]{0, ancho / 2.0});

        // Lista de las grúas
        gruas = new ArrayList<>();
        for (int i = 0; i < numGruas; i++) gruas.add(new ArrayList<>());

        // Leer las posiciones de las grúas y comprobar qué muros alcanzan
        for (int i = 0; i < numGruas; i++) {
            double x = scan.nextDouble();
            double y = scan.nextDouble();

            for (int j = 0; j < 4; j++) {
                if (dist(new double[]{x, y}, centros.get(j)) - radio <= EPSILON) {
                    gruas.get(i).add(j);
                }
            }
            // Usando solo 1 grúa
            if (gruas.get(i).size() == 4) {
                System.out.println(1);
                return;
            }
        }

        int bm;

        // Usando 2 grúas
        for (int i = 0; i < numGruas; i++) {
            for (int j = i + 1; j < numGruas; j++) {
                bm = 0;
                // Para cada uno de los muros alcanzados por cada una de las grúas, activamos el bit correspondiente al muro
                for (int a : gruas.get(i)) bm |= 1 << a;
                for (int a : gruas.get(j)) bm |= 1 << a;
                if (bm == 15) {
                    // Si los 4 muros están alcanzados, imprimimos el resultado
                    // y salimos del programa
                    System.out.println(2);
                    return;
                }
            }
        }

        // Usando 3 grúas
        for (int i = 0; i < numGruas; i++) {
            for (int j = i + 1; j < numGruas; j++) {
                for (int k = j + 1; k < numGruas; k++) {
                    bm = 0;
                    // Para cada uno de los muros alcanzados por cada una de las grúas, activamos el bit correspondiente al muro
                    for (int a : gruas.get(i)) bm |= 1 << a;
                    for (int a : gruas.get(j)) bm |= 1 << a;
                    for (int a : gruas.get(k)) bm |= 1 << a;
                    if (bm == 15) {
                        // Si los 4 muros están alcanzados, imprimimos el resultado
                        // y salimos del programa
                        System.out.println(3);
                        return;
                    }
                }
            }
        }

        // Usando 4 grúas
        for (int i = 0; i < numGruas; i++) {
            for (int j = i + 1; j < numGruas; j++) {
                for (int k = j + 1; k < numGruas; k++) {
                    for (int l = k + 1; l < numGruas; l++) {
                        bm = 0;
                        // Para cada uno de los muros alcanzados por cada una de las grúas, activamos el bit correspondiente al muro
                        for (int a : gruas.get(i)) bm |= 1 << a;
                        for (int a : gruas.get(j)) bm |= 1 << a;
                        for (int a : gruas.get(k)) bm |= 1 << a;
                        for (int a : gruas.get(l)) bm |= 1 << a;
                        if (bm == 15) {
                            // Si los 4 muros están alcanzados, imprimimos el resultado
                            // y salimos del programa
                            System.out.println(4);
                            return;
                        }
                    }
                }
            }
        }

        // Si no se han alcanzado los 4 muros con ninguna combinación de grúas, imprimimos "Impossible"
        // y salimos del programa
        System.out.println("Impossible");
    }
}


