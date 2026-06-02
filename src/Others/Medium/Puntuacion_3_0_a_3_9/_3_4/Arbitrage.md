Este problema, conocido clásicamente como Arbitrage, nos pide detectar si existe un ciclo de conversiones que nos permita empezar con una cantidad de dinero en una divisa y terminar con una cantidad estrictamente mayor en esa misma divisa.

Este escenario se puede modelar perfectamente utilizando teoría de grafos. A diferencia de los problemas anteriores donde buscabas sumas mínimas o el camino más corto en pasos, aquí estamos buscando un multiplicador acumulado mayor que 1.0 a lo largo de un ciclo.

Aquí tienes el planteamiento estructurado paso a paso para resolverlo de manera óptima.
## 1. Modelado del Problema como un Grafo
Podemos transformar el mercado de divisas en un grafo dirigido y pesado:
* Vértices (Nodos): Cada una de las $N$ monedas (como CZK, EUR, USD) será un nodo. Puedes mapear cada código de 3 letras a un índice entero de $0$ a $N-1$ usando un HashMap<String, Integer>.
* Aristas (Conexiones): Si existe una tasa de cambio que dice que por $A$ unidades de la moneda $1$ obtienes $B$ unidades de la moneda $2$, creamos una arista dirigida desde el nodo $1$ hacia el nodo $2$.
* Peso de la arista: El factor de multiplicación al cambiar de la moneda 1 a la 2 es la fracción $\frac{B}{A}$.

### El reto de la multiplicación
Si seguimos un camino de intercambios, el dinero final se calcula multiplicando los pesos de las aristas:
$$\text{Cantidad Final} = \text{Cantidad Inicial} \times \left( \frac{B_1}{A_1} \times \frac{B_2}{A_2} \times \dots \times \frac{B_k}{A_k} \right)$$

Queremos detectar si existe algún ciclo donde este producto sea estrictamente mayor que 1:
$$\prod \frac{B_i}{A_i} > 1$$

## 2. El Truco Matemático: Transformar Multiplicación en Suma
La mayoría de los algoritmos de grafos (como Bellman-Ford o Floyd-Warshall) están diseñados para buscar caminos óptimos sumando pesos, no multiplicándolos. Para adaptar nuestro problema, aplicamos una propiedad fundamental de los logaritmos:

$$\log(x \cdot y) = \log(x) + \log(y)$$

Si aplicamos el logaritmo natural ($\ln$) a nuestra condición de arbitraje:

$$\log\left(\prod \frac{B_i}{A_i}\right) > \log(1)$$
$$\sum \log\left(\frac{B_i}{A_i}\right) > 0$$

Para que encaje con los algoritmos tradicionales de detección de ciclos negativos (que buscan sumas menores a 0), multiplicamos toda la inecuación por $-1$ (lo que invierte el sentido del signo):

$$\sum -\log\left(\frac{B_i}{A_i}\right) < 0$$

### La equivalencia exacta:
* Si definimos el peso de cada arista en nuestro grafo como: $W = -\log\left(\frac{B}{A}\right)$
* El problema de encontrar un "ciclo multiplicativo mayor que 1" se reduce a encontrar un ciclo de suma negativo ($< 0$) en el grafo.

## 3. Estrategia de Resolución
Dado que el número de monedas es pequeño ($N \le 20$ en variantes estándar de este problema, usualmente no supera los 100-200 nodos), el algoritmo ideal es Floyd-Warshall o Bellman-Ford.
<br>Utilizar Floyd-Warshall es sumamente elegante porque calcula los caminos más cortos entre todos los pares de nodos en un código de apenas 4 líneas.

### Pasos del Algoritmo (usando Floyd-Warshall):
- Inicialización:
  - Crea una matriz de adyacencia double[][] dist de tamaño $N \times N$
  - Inicializa todas las celdas con un valor infinito positivo (Double.POSITIVE_INFINITY), excepto la diagonal principal (dist[i][i] = 0).
- Llenar el Grafo:
  - Por cada tasa de cambio entre la moneda $u$ y la moneda $v$ con ratio $A:B$, calcula el peso: peso = -Math.log((double)B / A).
  - Si hay múltiples tasas para el mismo par de monedas, guarda únicamente la menor: dist[u][v] = Math.min(dist[u][v], peso).
- Ejecutar Floyd-Warshall:
  - Corre los tres bucles anidados característicos del algoritmo para actualizar las distancias mínimas:

```` Java
for (int k = 0; k < N; k++) {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (dist[i][k] < Double.POSITIVE_INFINITY && dist[k][j] < Double.POSITIVE_INFINITY) {
                dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
            }
        }
    }
}
````
### Detección de Arbitraje:
- Una vez terminado el algoritmo, revisa la diagonal principal de la matriz (dist[i][i]).
- Si para cualquier moneda $i$ el valor de dist[i][i] se volvió menor que cero (dist[i][i] < 0), significa que la distancia para ir de esa moneda a sí misma a través de otros nodos se redujo gracias a un ciclo negativo.
- Si encuentras al menos un dist[i][i] < 0, imprimes "Arbitrage". 
- Si revisas todas las monedas y ninguna es menor que cero, imprimes "Ok".
## 4. Análisis de Complejidad
- Complejidad Temporal: $O(N^3)$ debido a los tres bucles anidados de Floyd-Warshall. Como $N$ suele ser muy pequeño en este problema, el algoritmo se ejecutará instantáneamente.
- Complejidad Espacial: $O(N^2)$ para almacenar la matriz de adyacencia, lo cual requiere una cantidad insignificante de memoria RAM.