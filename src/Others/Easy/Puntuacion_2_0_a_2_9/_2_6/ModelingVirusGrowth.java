package Others.Easy.Puntuacion_2_0_a_2_9._2_6;

/*
    El primer minuto el primer nodo entra en instalación, 0 nodos en propagación
    El segundo minuto el primer nodo entra en propagación y empieza la instalación en un segundo nodo
    El tercer minuto el segundo nodo entra en propagación y empieza la instalación en un tercer nodo.
    A su vez, el primer nodo, infecta un cuarto nodo.
    El cuarto minuto, tenemos 4 nodos en propagación que empiezan la instalación en 4 nuevos nodos.
    El quinto minuto, tenemos 8 nodos en propagación que empiezan la instalación en 8 nuevos nodos.
    El sexto minuto, tenemos 16 nodos en propagación, que empiezan la instalación en 16 nuevos nodos.

    El ritmo de propagación es 2^(n-2), pero hay que tener en cuenta que no podemos infectar un nodo
    que ya se encuentra infectado y que el número de nodos es limitado!
 */

import java.util.Locale;
import java.util.Scanner;

public class ModelingVirusGrowth {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        // n puede ser hasta 10^18, por lo que usamos nextLong()
        long n = sc.nextLong();

        // Caso base especial: si solo hay 1 nodo, toma exactamente 1 minuto
        if (n == 1) {
            System.out.println(1);
            sc.close();
            return;
        }

        // Estado inicial en el minuto 0
        long instalacion = 1; // El nodo inicial empieza instalándose
        long replicacion = 0; // No hay nodos replicando todavía
        int minutos = 0;

        // El bucle corre hasta que los nodos en REPLICACIÓN cubran o superen 'n'
        while (replicacion < n) {
            minutos++;

            // 1. Calcular cuántos virus nuevos se pueden crear este minuto
            long nodosTotalesActuales = replicacion + instalacion;
            long nodosLibres = n - nodosTotalesActuales;
            long nuevosInfectados = Math.min(replicacion, nodosLibres);

            // 2. Los que se estaban instalando pasan a replicación
            replicacion += instalacion;

            // 3. Los nuevos infectados entran en fase de instalación
            instalacion = nuevosInfectados;
        }

        System.out.println(minutos);
        sc.close();
    }
}