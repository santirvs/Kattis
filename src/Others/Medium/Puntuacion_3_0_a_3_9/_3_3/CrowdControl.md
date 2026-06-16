Este es un problema clásico de Teoría de Grafos combinado con una estrategia de optimización. Se divide en dos fases: primero, encontrar el camino que maximice el "cuello de botella" (la calle con menor capacidad del trayecto), y segundo, identificar qué calles que tocan ese camino deben ser bloqueadas.

Aquí tienes el planteamiento detallado para resolverlo paso a paso:
## 1. Fase 1: Encontrar el camino de máxima capacidad

Nos piden un camino desde la estación ($0$) hasta el destino ($N-1$) donde la capacidad total del camino esté determinada por su arista más débil. Queremos que esa "arista más débil" sea lo más grande posible. Este problema se conoce como el **Camino del Cuello de Botella Máximo**  *(Maximum Bottleneck Path)*.

Para resolverlo, podemos adaptar el **algoritmo de Dijkstra**, pero con una pequeña modificación en la forma en que "relajamos" las distancias:
- En el Dijkstra tradicional para caminos cortos, buscas *minimizar* la suma de los pesos: dist[v] = dist[u] + peso.
- En este problema, queremos **maximizar el mínimo**: si estamos en el nodo $u$ con una capacidad acumulada cap[u] y pasamos al nodo $v$ a través de una calle con capacidad peso, la capacidad para llegar a $v$ será el mínimo entre las dos: min(cap[u], peso). Queremos que este valor sea el mayor posible.

### El algoritmo de Dijkstra Modificado:

- 1. Crea un array cap de tamaño $N$ inicializado en $0$, excepto cap[0] = $\infty$ (el nodo inicial no tiene restricciones).
- 2. Usa una **Cola de Prioridad (Max-Heap)** que guarde pares (capacidad, nodo) para procesar siempre primero el nodo que tenga la mayor capacidad acumulada posible.
- 3. Para reconstruir el camino al final, mantén un array parent donde guardes de qué nodo viniste y qué **ID de calle** usaste para llegar allí.
- 4. Mientras la cola no esté vacía:
  - Saca el nodo $u$ con mayor capacidad.
  - Si ya llegaste al destino ($N-1$), puedes detener la búsqueda (aunque terminar el Dijkstra completo tampoco hace daño).
  - Para cada vecino $v$ de $u$ conectado por una calle de capacidad $W$:
    - Calcula la capacidad potencial para llegar a $v$: nueva_cap = min(cap[u], W).
    - Si nueva_cap > cap[v], actualizas cap[v] = nueva_cap, guardas el padre/calle en tu registro y metes $v$ a la cola de prioridad.
## 2. Fase 2: Identificar las calles a bloquear
Una vez que termina el Dijkstra, puedes reconstruir el camino exacto desde $0$ hasta $N-1$ yendo hacia atrás usando tu array de padres.

El enunciado dice: *"the organizers close down the streets which are incident to an intersection on the path, but not part of the path."*

Esto significa que debes bloquear cualquier calle que cumpla estas dos condiciones a la vez:
- Al menos uno de sus extremos (intersecciones) pertenece al camino óptimo que encontraste.
- La calle en sí **no** forma parte del camino óptimo.

### El proceso de marcado:
- Reconstruye el camino óptimo de atrás hacia adelante (desde $N-1$ hasta $0$).
- Guarda en un conjunto o array de booleanos (en_camino[nodo] = true) todos los nodos que forman parte de este camino.
- Guarda en otro conjunto o array de booleanos (calle_en_camino[id_calle] = true) los IDs de las calles que componen el camino óptimo.
- Recorre las $M$ calles originales del mapa una por una (desde la $0$ hasta la $M-1$):
  - Si la calle no está en calle_en_camino, pero el extremo $A$ o el extremo $B$ (o ambos) están marcados en en_camino, entonces esa calle debe ser bloqueada.
  - Guarda su ID de calle en una lista de resultados.

## Fase 3: Imprimir el resultado

- Si tu lista de calles a bloquear está vacía, la salida debe ser la palabra none.
- Si contiene elementos, dado que recorriste las calles en orden del $0$ al $M-1$, tu lista ya estará ordenada de menor a mayor de forma natural. Simplemente imprímelos separados por un espacio en una sola línea.


## Analicemos el Ejemplo 2 para verlo claro
Input:
````
4 4
0 1 10   (Calle 0)
1 2 50   (Calle 1)
0 3 30   (Calle 2)
1 3 20   (Calle 3)
````
Destino: Nodo $3$.

Fase 1 (Dijkstra):
- Camino A: $0 \rightarrow 1 \rightarrow 3$. Cuello de botella = $\min(10, 20) = 10$.
- Camino B: $0 \rightarrow 3$. Cuello de botella = $30$.
- El camino de máxima capacidad es ir directo de $0$ a $3$ (Capacidad 30).

Fase 2 (Marcado):
- Nodos en el camino: {0, 3}.
- Calles en el camino: {Calle 2}.

Evaluación de calles a bloquear:
- Calle 0 ($0 \rightarrow 1$): No está en el camino, pero toca al nodo $0$. ¡Se bloquea!
- Calle 1 ($1 \rightarrow 2$): No está en el camino y no toca ni a $0$ ni a $3$. No se bloquea (nadie del desfile pasará por ahí de todos modos)
- Calle 2 ($0 \rightarrow 3$): Está en el camino. No se bloquea.
- Calle 3 ($1 \rightarrow 3$): No está en el camino, pero toca al nodo $3$. ¡Se bloquea!

Resultado: Calles 0 y 3. Coincide exactamente con el Sample Output.