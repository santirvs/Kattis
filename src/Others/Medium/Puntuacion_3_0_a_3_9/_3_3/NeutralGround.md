Este problema pertenece a una categoría clásica de la teoría de grafos y optimización. El objetivo de "separar completamente" las tropas del Rey A de las del Rey B al menor costo posible (mínimo número de soldados) es la definición exacta del problema del Corte Mínimo (Minimum Cut) en una red de flujo.

Por el famoso Teorema del Flujo Máximo / Corte Mínimo, sabemos que el costo del corte mínimo para separar dos conjuntos de nodos es exactamente igual al Flujo Máximo (Maximum Flow) que puede enviarse desde un conjunto hacia el otro.

Sin embargo, hay un detalle clave en este problema: el costo (capacidad) está en las casillas (los nodos), no en las conexiones (las aristas). Para resolver esto, debemos transformar nuestra matriz en una red de flujo dirigida utilizando una técnica llamada Duplicación de Nodos (Node Splitting).
## 1.El Planteamiento: Transformación del Grafo

Para convertir el mapa en una red de flujo donde las capacidades estén en los caminos entre nodos, dividiremos cada casilla transitable en dos nodos artificiales: un nodo de entrada y un nodo de salida
### A. Estructura de cada Casilla Numérica (Dígitos del '1' al '9')

Si una casilla $(x, y)$ tiene un número (por ejemplo, 5), la dividimos en:
- Nodo_Entrada(x, y)
- Nodo_Salida(x, y)

Creamos una arista dirigida desde el nodo de entrada hacia el de salida con una capacidad igual al dígito (en este caso, 5). Esto modela el hecho de que si el emperador quiere bloquear esta casilla, le cuesta 5 soldados.

### B. Conexiones entre Casillas Vecinas
Si dos casillas transitables son vecinas en el mapa (horizontal o verticalmente), significa que las tropas pueden moverse entre ellas. Creamos aristas dirigidas con capacidad infinita ($\infty$):
- Desde Nodo_Salida(Casilla_1) hacia Nodo_Entrada(Casilla_2)
- Desde Nodo_Salida(Casilla_2) hacia Nodo_Entrada(Casilla_1)

¿Por qué infinito? Porque el emperador no puede poner soldados en las "fronteras" entre casillas, solo puede ponerlos dentro de las casillas. Poner capacidad infinita asegura que el algoritmo de corte mínimo nunca intente cortar esa conexión.

### C. Manejo de Casillas Especiales ('A', 'B', '0')
- Casillas '0' (Infranqueables): Simplemente las ignoramos. No creamos nodos para ellas ni conexiones hacia ellas. Las tropas no pueden pasar por ahí.
- Casillas 'A' (Rey A): Son los puntos de origen del flujo. Conectamos un Super-Origen ($S$) virtual a los Nodo_Entrada de todas las casillas 'A' con capacidad $\infty$. Las casillas 'A' no necesitan dividirse, o si se dividen, su arista interna tiene capacidad $\infty$ (el emperador no puede patrullar territorio ya ocupado).
- Casillas 'B' (Rey B): Son los puntos de destino. Conectamos el Nodo_Salida de todas las casillas 'B' a un Super-Destino ($T$) virtual con capacidad $\infty$.

## 2.Pasos del Algoritmo
Una vez modelada la red de flujo, el problema se reduce a ejecutar un algoritmo estándar de flujo máximo:
### 1.- Construir el Grafo:
- Asigna un identificador único (un número entero) a cada nodo de entrada y de salida de la matriz para poder representarlos en una lista de adyacencia.
- Conecta el Super-Origen $S$ a todas las casillas 'A'.
- Conecta todas las casillas 'B' al Super-Destino $T$.
- Para cada dígito entre '1' y '9', crea la arista interna de entrada a salida con la capacidad del dígito.
- Une los vecinos con capacidad $\infty$ (Salida de uno a Entrada del otro).
### 2.- Calcular el Flujo Máximo:
- Aplica un algoritmo de Flujo Máximo desde $S$ hasta $T$.
- Dado que el grafo puede llegar a ser relativamente grande (una matriz de hasta $30 \times 30 = 900$ casillas, lo que equivale a unos 1800 nodos), algoritmos eficientes como Dinic o Edmonds-Karp funcionarán perfectamente dentro del límite de tiempo.
### 3.- Imprimir el Resultado:
El valor entero del flujo máximo obtenido será igual al mínimo número de soldados requeridos. Imprime ese valor.

## 3.Ejemplo Visual de Conexiones
Imagina un fragmento de mapa simple con dos casillas vecinas: una con 'A' y otra con un '3'.

Mapa: [ A ] [ 3 ]

La red de flujo se construiría de la siguiente manera:

$$S \xrightarrow{\infty} \text{Nodo\_A} \xrightarrow{\infty} \text{Nodo\_Entrada\_3} \xrightarrow{3} \text{Nodo\_Salida\_3} \xrightarrow{\infty} \dots$$

Si el flujo intenta ir desde $A$ hacia el resto del mapa, se verá obligado a pasar por el "cuello de botella" de capacidad 3. El algoritmo de corte mínimo elegirá pagar el costo de 3 para interrumpir el camino.