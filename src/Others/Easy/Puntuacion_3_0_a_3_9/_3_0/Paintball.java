package Others.Easy.Puntuacion_3_0_a_3_9._3_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
Estrategia de Solución: Emparejamiento Máximo Bipartito (Maximum Bipartite Matching)
Este problema se modela perfectamente como un Grafo Bipartito.
Imagina que duplicamos a los jugadores en dos grupos:
    Grupo A (Tiradores): Los N jugadores en su rol de disparar.
    Grupo B (Objetivos): Los N jugadores en su rol de recibir el impacto.

Existe una arista dirigida desde el Tirador i hacia el Objetivo j si el jugador i conoce (puede ver)
al jugador j.

Queremos asignar a cada Tirador exactamente un Objetivo diferente, de modo que cada Objetivo
sea alcanzado exactamente una vez (lo que resulta en una asignación perfecta 1 a 1).
Esto es la definición exacta de un Emparejamiento Perfecto (Perfect Matching).

Si el tamaño del emparejamiento máximo es igual a N, encontramos la solución.
De lo contrario, es Impossible.

Podemos resolver esto eficientemente usando el Algoritmo de Augmenting Paths (Caminos de Aumento),
típicamente implementado con una DFS (Búsqueda en Profundidad) similar al algoritmo
de Hopcroft-Karp simplificado o Ford-Fulkerson.
 */


public class Paintball {
    static ArrayList<Integer>[] grafo;
    static int[] match; // Guarda quién dispara a quién (match[objetivo] = tirador)
    static boolean[] visitado;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numJugadores = Integer.parseInt(st.nextToken()); // Número de jugadores
        int numLineas = Integer.parseInt(st.nextToken()); // Número de conexiones

        // Inicializar el grafo de adyacencia (1-indexado para comodidad)
        grafo = new ArrayList[numJugadores + 1];
        for (int i = 1; i <= numJugadores; i++) {
            grafo[i] = new ArrayList<>();
        }

        // Leer las relaciones (son bidireccionales: si A ve a B, B ve a A)
        for (int i = 0; i < numLineas; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            grafo[u].add(v);
            grafo[v].add(u);
        }

        match = new int[numJugadores + 1];
        Arrays.fill(match, -1);
        int infoMatches = 0;

        // Intentar encontrar un rival para cada tirador 'i'
        for (int i = 1; i <= numJugadores; i++) {
            visitado = new boolean[numJugadores + 1];
            if (dfs(i)) {
                infoMatches++;
            }
        }

        // Si el total de emparejamientos es igual a N, todos están a salvo/impactados
        if (infoMatches == numJugadores) {
            // Reconstruir la respuesta: queremos saber a quién le dispara cada Tirador.
            // Actualmente 'match[objetivo] = tirador', invertimos la relación para imprimir.
            int[] resultado = new int[numJugadores + 1];
            for (int objetivo = 1; objetivo <= numJugadores; objetivo++) {
                int tirador = match[objetivo];
                resultado[tirador] = objetivo;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= numJugadores; i++) {
                sb.append(resultado[i]).append("\n");
            }
            System.out.print(sb);
        } else {
            System.out.println("Impossible");
        }
    }

    // DFS para encontrar caminos de aumento en el grafo bipartito
    static boolean dfs(int tirador) {
        for (int objetivo : grafo[tirador]) {
            if (!visitado[objetivo]) {
                visitado[objetivo] = true;

                // Si el objetivo no tiene tirador asignado, o si el tirador previo
                // de ese objetivo puede encontrar otro objetivo alternativo...
                if (match[objetivo] < 0 || dfs(match[objetivo])) {
                    match[objetivo] = tirador; // Asignamos el match
                    return true;
                }
            }
        }
        return false;
    }
}

/*
Para entender cómo funciona el algoritmo de Emparejamiento Máximo Bipartito (Maximum Bipartite Matching)
mediante Caminos de Aumento, lo mejor es visualizar el problema dividiendo conceptualmente a
los mismos N jugadores en dos grupos o bandos totalmente separados.

Imaginalo de esta manera: a la izquierda tenemos la lista de Tiradores y a la derecha la lista de Objetivos.
Queremos trazar una línea (un disparo) desde cada tirador de la izquierda hacia un objetivo de la derecha,
con dos reglas estrictas:Un tirador solo puede dispararle a alguien que conoce.Ningún objetivo de la derecha
puede recibir más de un disparo (queremos que todos sean impactados exactamente una vez).

El Concepto del Camino de Aumento (Augmenting Path)
El algoritmo funciona de manera "codiciosa pero con derecho a rectificar" (esto es la magia del DFS).
Va recorriendo los tiradores uno a uno e intenta asignarles un objetivo.Aquí está el truco de cómo
decide a quién disparar:

Escenario A: El objetivo está libre
Si el Tirador 1 conoce al Objetivo A, y nadie le está disparando al Objetivo A, se genera
el emparejamiento inmediatamente.Resultado: Tirador 1 ➔ Objetivo A.

Escenario B: El objetivo ya está ocupado (Negociación)
¿Qué pasa si el Tirador 2 entra en escena, su única opción es el Objetivo A, pero el Tirador 1 ya le estaba
disparando a A? Aquí entra la recursión del DFS:El Tirador 2 le pregunta al Objetivo A: "¿Puedo dispararte?"
El Objetivo A responde: "Ya me está disparando el Tirador 1. Pero déjame preguntarle a él si puede cambiar de objetivo".
El algoritmo salta temporalmente al Tirador 1 y busca si tiene otra opción en su lista de conocidos (por ejemplo,
el Objetivo B) que esté libre o que pueda desencadenar otra cadena de cambios.
Si el Tirador 1 encuentra con éxito al Objetivo B y se cambia con él, entonces el Objetivo A queda libre.
Finalmente, el Tirador 2 se queda con el Objetivo A.
Esta cadena de favores o de "empujones" es lo que en teoría de grafos llamamos un Camino de Aumento.
Si la cadena llega a un final feliz (un objetivo libre), to do el camino se actualiza y el número total de
impactos aumenta en 1.

¿Por qué usamos el array visitado en cada turno?
Si te fijas en el código, antes de procesar a cada tirador hacemos un visitado = new boolean[n + 1].
Este array evita que entremos en bucles infinitos durante la fase de negociación.
Si el Tirador 2 quiere el Objetivo A, y para soltarlo el Tirador 1 necesita el Objetivo B, y para soltarlo el
Tirador de B necesita volver al Objetivo A... el array de visitado frena esa contradicción bloqueando los objetivos
que ya se están evaluando en esa misma cadena de llamadas.

El resultado final
Al terminar el bucle principal, si logramos que el contador de éxitos (infoMatches) sea exactamente igual a N,
significa que la cadena de negociaciones fue perfecta: encontramos una configuración donde cada una de las N personas
tiene un objetivo único y nadie se quedó sin recibir un disparo.
 */