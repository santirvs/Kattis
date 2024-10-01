package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._3_TablasDireccionamientoDirecto_Otros;

import java.util.Scanner;

//*** Copiado de https://github.com/RussellDash332/kattis/blob/main/src/Floppy%20Music/floppy.py
//*** Y traducido a Java con ChatGPT  --> AC a la primera!

// Análisis:
// Para cada frecuencia y cada nota se debe determinar si es posible que se escuche en algún momento.
// Partimos de una lista de posiciones habilitadas (1) y deshabilitadas (0).
// Inicialmente todas las posiciones están habilitadas ya que el cabezal puede encontrarse en cualquier posición.
// Para cada posición habilitada, y sobre un nuevo array con todas las posiciones inicialmente desabilitadas
// se habilitan las posiciones anteriores y posteriores a la posición actual alcanzables con la nota actual.
// Para la siguiente nota, partimos de la nueva lista de posiciones habilitadas y se repite el proceso.
// Al finalizar cada nota, si alguna posición está habilitada, entonces es posible escuchar la frecuencia.
// Si no hay ninguna posición habilitada, entonces no es posible escuchar la frecuencia.

// Como los tiempos de las notas son estrictamente crecientes no es necesario ordenar las notas ni verificar
// ni solapamientos ni intersecciones entre los intervalos de tiempo de las notas.
// Tampoco es necesario verificar si entre una nota y otra hay menos de 1ms de diferencia.

public class FloppyMusic {
    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);

        int numCasos = Integer.parseInt(scan.nextLine());
        boolean posible = true;

        for (int caso = 0; caso < numCasos && posible; caso++) {
            int tamanyo = scan.nextInt();
            int periodos = scan.nextInt();

            int[] posiciones = new int[tamanyo + 1];
            for (int i = 0; i <= tamanyo; i++) {
                posiciones[i] = 1; // inicializando el array 'posiciones' con 1's
            }

            for (int n = 0; n < periodos; n++) {
                int[] d = new int[tamanyo + 1]; // nuevo array 'd' inicializado con 0's

                //Leer inicio y fin del período en que debe sonar la frecuencia
                int inicio = scan.nextInt();
                int fin = scan.nextInt();
                int duracion = fin - inicio;

                //Marcar las posiciones desde donde se puede escuchar la frecuencia
                for (int pos = 0; pos <= tamanyo; pos++) {
                    //Si posiciones[pos] está habilitada (1), entonces se puede escuchar la frecuencia
                    if (posiciones[pos] == 1) {
                        //Habilito las posiciones anteriores
                        if (pos >= duracion) {
                            d[pos - duracion] = 1;
                        }
                        //Habilito las posiciones posteriores
                        if (pos <= tamanyo - duracion) {
                            d[pos + duracion] = 1;
                        }
                    }
                }
                //Las posiciones habilitadas pasan a la siguiente vuelta
                posiciones = d;
            }

            //Buscar si hay alguna posición habilitada --> es posible
            posible = false;
            for (int i = 0; i <= tamanyo && !posible; i++) {
                if (posiciones[i] == 1) {
                    posible = true;
                }
            }

        }

        if (posible) System.out.println("possible");
        else System.out.println("impossible");

        scan.close();
    }
}
