Este problema es fascinante porque, aunque parece pedir simulaciones geométricas complejas debido a las dimensiones del Overworld y el Nether, en realidad se puede modelar de forma impecable como un problema de el camino más corto en un grafo ponderado.
<br>Aquí tienes el planteamiento estratégico para estructurar tu solución antes de programarla.
## 1.Entendiendo las Reglas y la "Física" del Juego
Analicemos las mecánicas clave del problema:
- Inicio y Fin: Empezamos en la posición 0 del Overworld (OW) y queremos llegar a la posición T del Overworld.
- Costo de Movimiento (OW): Caminar en el Overworld cuesta tiempo equivalente a la distancia directa: $\text{Tiempo} = |x_1 - x_2|$.
- Costo de Movimiento (Nether): Caminar en el Nether (NE) también cuesta tiempo igual a la distancia, pero las coordenadas están comprimidas por un factor de $8$. Si te mueves entre la coordenada de Nether $n_1$ y $n_2$, el tiempo que toma es $|n_1 - n_2|$.
- Portales: Un portal $i$ conecta la coordenada $n_i$ del Nether con la coordenada $8 \times n_i$ del Overworld. Cruzarlo e ingresar al otro mundo requiere repararlo, lo cual consume $C_i$ segundos.

## 2.Modelado como un Grafo
La forma más eficiente de abordar esto es abstraer el mapa en un grafo de nodos y aristas con pesos (tiempos).
### Los Nodos (Estados)
Definiremos los puntos clave donde Harry puede decidir cambiar de dirección o de mundo:
- Nodo Inicial (Origen): Posición 0 en el Overworld.
- Nodo Final (Destino): Posición T en el Overworld (The Stronghold).
- Nodos de Portales: Cada portal $i$ representa realmente dos puntos de parada en nuestra red:
  - El lado del portal en el Overworld ($OW_i$ en la coordenada $8 \times n_i$).
  - El lado del portal en el Nether ($NE_i$ en la coordenada $n_i$).
Esto nos da un total de $2N + 2$ nodos en nuestro grafo.
### Las Aristas (Conexiones válidas)
Las conexiones y sus respectivos "pesos" (tiempo en segundos) se definen de la siguiente manera:
- Conexión Directa Inicial-Final (Overworld):
  - Del Origen al Destino caminando por el Overworld.
  - Peso: $|0 - T| = T$.
- Conexiones en el Overworld (Caminar):
  - Del Origen a cualquier entrada de portal $OW_i$: Peso = $|0 - 8 \times n_i| = 8 \times n_i$.
  - De cualquier salida de portal $OW_i$ al Destino: Peso = $|8 \times n_i - T|$.
  - ¡Importante! También se puede caminar en el Overworld de un portal a otro. Entre $OW_i$ y $OW_j$: Peso = $|8 \times n_i - 8 \times n_j|$.
- Conexiones en el Nether (Caminar):
  - Se puede caminar en el Nether entre cualquier par de portales $NE_i$ y $NE_j$: Peso = $|n_i - n_j|$.
- Cruzar un Portal (Cambiar de Mundo):
  - Entre el lado Overworld y el lado Nether del mismo portal ($OW_i \leftrightarrow NE_i$).
  - Peso: $C_i$ (el tiempo de reparación).
  
## 3. Estrategia Algorítmica: Algoritmo de Dijkstra
Dado que todas las aristas tienen pesos no negativos (el tiempo nunca es negativo), el problema se reduce a encontrar el camino más corto desde el nodo Origen hasta el nodo Destino utilizando el Algoritmo de Dijkstra.
### Pasos del Algoritmo:
 - Construir el Grafo: Recibir los $N$ portales y calcular las distancias en tiempo entre todos los nodos combinables de Overworld entre sí, y todos los de Nether entre sí.
 - Inicializar Dijkstra: Usar una cola de prioridad (Priority Queue) para procesar los nodos con la menor distancia acumulada primero.
 - Ejecutar la búsqueda: Relajar las aristas expandiendo los caminos a través de los portales y las caminatas inter-portales hasta extraer de la cola el nodo Destino.

### Optimización de Aristas (Para evitar $O(N^2)$)
Si $N$ es grande (hasta $10^5$ en el peor escenario teórico de problemas competitivos avanzados), conectar todos los portales con todos en el Overworld y Nether generaría $O(N^2)$ aristas, lo que daría TLE.
<br>Para optimizarlo, nota que caminar por una línea recta siempre es óptimo si visitas los puntos en orden. Si ordenas los portales de menor a mayor según su coordenada $n_i$, solo necesitas crear aristas entre portales adyacentes en la lista ordenada tanto para el Overworld como para el Nether. Caminar del portal 1 al portal 3 de forma directa toma el mismo tiempo que pasar por el portal 2 intermedio si están sobre la misma línea. Esto reduce las aristas a un comportamiento lineal de $O(N)$.