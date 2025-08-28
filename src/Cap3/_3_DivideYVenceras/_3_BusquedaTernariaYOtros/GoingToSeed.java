package Cap3._3_DivideYVenceras._3_BusquedaTernariaYOtros;

/*
Problema interactivo...  No lo había hecho nunca...
Original de: https://github.com/BrandonTang89/Competitive_Programming_4_Solutions/blob/main/Chapter_3_Problem_Solving_Paradigms/Divide_and_Conquer/kattis_goingtoseed.cpp

Observación 1:
    Obviamente el problema es una variante de búsqueda binaria... Dado esto, sabemos que el espacio de soluciones después
    de 16 iteraciones es como máximo 1e9/x^16 donde x es en cuántas regiones dividimos el área de búsqueda
    (suponiendo que podemos determinar en cuál región está el objetivo con una sola consulta). Resolviendo para x,
    nos damos cuenta de que x debe ser al menos 4. Esto es consistente con el hecho de que obtenemos 2 bits de
    información por consulta, es decir un máximo de 4 posibles respuestas...

    Entonces, ¿cómo diseñamos los rangos? Tras pensarlo, notamos que si hacemos el tamaño de cada rango la mitad del
    espacio de búsqueda y empezamos el primer rango en el inicio del área de búsqueda, mientras que el segundo rango
    empieza en el 25% del área de búsqueda, es decir {l1 --- l2 --- r1 --- r2 ---}, podemos usar al máximo los datos,
    donde {01, 11, 10, 00} corresponde a cada una de las 4 regiones del 25% representadas con ---.

Sin embargo, la parte más molesta de este problema son los detalles de implementación: como manejar +1, -1 al modificar
el área de búsqueda después de cada consulta, y tratar el final de la búsqueda cuando el espacio es pequeño (<= 4).
También es difícil de depurar debido a su naturaleza interactiva...

Tiempo: O(log(n))
Memoria: O(1)
*/

import java.io.*;
import java.util.*;

public class GoingToSeed {
    static int low, high, numArboles;

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        //Leer la cantidad de árboles
        numArboles = scan.nextInt();
        scan.nextLine();

        high = numArboles;
        low = 1;

        // Límites de los rangos (l1..r1  y  l2..r2)
        int l1, r1, l2, r2;
        int a, b;

        // Realizar la consulta mientras el espacio de búsqueda sea mayor que 3
        while (high - low + 1 > 3) { // consulta
            // System.err.println("low: " + low + " high: " + high);
            l1 = low;
            r1 = (int) (low + (high - low + 1) * 0.5 - 1);
            l2 = (int) (low + (high - low + 1) * 0.25);
            r2 = (int) (low + (high - low + 1) * 0.75 - 1);

            // Lanza la consulta
            out.println("Q " + l1 + " " + r1 + " " + l2 + " " + r2);
            out.flush();

            // Leer la respuesta
            StringTokenizer st = new StringTokenizer(scan.nextLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            // Actualizar los límites de búsqueda según la respuesta
            // El primero lo detecta y el segundo no
            if (a == 1 && b == 0) { // primer cuarto
                high = l2;  // Actualizar el límite superior
                if (l2 - l1 <= 1) {  // Se ha acotado suficientemente el rango --> Solución!
                    out.println("A " + l1);
                    out.flush();
                    return;
                }
            } else if (a == 1 && b == 1) {  // Lo detectan ambos
                low = l2 - 1;               // Actualizar los límites inferior y superior
                high = r1 + 1;
                if (l2 == r1) {             // Si el rango común era de 1 elemento, ya tenemos la solución
                    out.println("A " + r1);
                    out.flush();
                    return;
                }
            } else if (a == 0 && b == 1) {  // Sólo lo detecta el segundo
                low = r1;                   // Actualizar los límites inferior y superior. No debería ser r1-1???
                high = r2 + 1;
                if (r2 - r1 <= 1) {         // Se ha acotado suficientemente el rango --> Solución!
                    out.println("A " + r2);
                    out.flush();
                    return;
                }
            } else {                        // No lo detecta ninguno
                low = r2;                   // Actualizar los límites
                high = Math.min(high + 1, numArboles);
                if (high - r2 == 1) {       // Se ha acotado suficientemente el rango --> Solución!
                    out.println("A " + high);
                    out.flush();
                    return;
                }
            }
        }

        // Cuando quedan 3 o menos elementos, hacer consultas individuales
        // System.err.println("last 3: low: " + low + " high: " + high);
        out.println("Q " + low + " " + low + " " + (low + 1) + " " + (low + 1));
        out.flush();

        //Leer el resultado
        StringTokenizer st = new StringTokenizer(scan.nextLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        // Actualizar los límites de búsqueda según la respuesta
        if (a == 1 && b == 0) {
            high = low;
        } else if (a == 0 && b == 1) {
            high = low + 1;
        } else {
            high = high;
        }

        // Mostrar el resultado final
        out.println("A " + high);
        out.flush();
    }
}
