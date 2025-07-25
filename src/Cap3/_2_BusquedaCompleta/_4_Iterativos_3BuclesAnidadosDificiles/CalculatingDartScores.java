package Cap3._2_BusquedaCompleta._4_Iterativos_3BuclesAnidadosDificiles;

// Fuerza bruta
// Probar todas las combinaciones de puntuaciones (1..20) y lanzamientos posibles (0..3)
// Al encontrar una combinación, parar y mostrar el resultado
// Si no se encuentra, mostrar impossible
// O(20*20*20*4*4*4) = O(1.920.000) --> justito, pero aceptable en tiempo


import java.io.IOException;
import java.util.Scanner;

public class CalculatingDartScores {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

         //Leer la puntuación objetivo
        int puntuacionObjetivo = scan.nextInt();

        // Buscar la combinación de puntuaciones que sume la puntuación objetivo
        // Probar las combinaciones puntos

        for (int puntos1=1; puntos1 <= 20; puntos1++) {
            for (int puntos2=1; puntos2 <= 20; puntos2++) {
                for (int puntos3=1; puntos3 <= 20; puntos3++) {

                    //Probar las combinaciones de lanzamientos
                    for (int lanzamiento1 = 0; lanzamiento1 <= 3; lanzamiento1++) {
                        for (int lanzamiento2 = 0; lanzamiento2 <= 3; lanzamiento2++) {
                            for (int lanzamiento3 = 0; lanzamiento3 <= 3; lanzamiento3++) {
                                // Calcular la puntuación total
                                int puntuacionTotal = (puntos1 * lanzamiento1) + (puntos2 * lanzamiento2) + (puntos3 * lanzamiento3);

                                // Comprobar si la puntuación total es igual a la puntuación objetivo
                                if (puntuacionTotal == puntuacionObjetivo) {
                                    imprimir(puntos1, lanzamiento1);
                                    imprimir(puntos2, lanzamiento2);
                                    imprimir(puntos3, lanzamiento3);
                                    System.exit(0);
                                }
                            }
                        }
                    }


                }
            }
        }

        System.out.println("impossible");
     }

    private static void imprimir(int puntos, int lanzamientos) {
        switch (lanzamientos) {
            case 1:
                System.out.println("single " + puntos);
                break;
            case 2:
                System.out.println("double " + puntos);
                break;
            case 3:
                System.out.println("triple " + puntos);
                break;
            default:
                // No se imprime nada
        }
    }
}

