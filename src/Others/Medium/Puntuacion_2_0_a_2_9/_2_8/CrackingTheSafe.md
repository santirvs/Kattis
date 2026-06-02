# Explicación: Cracking The Safe

Este problema pertenece a una categoría clásica de acertijos matemáticos y de lógica (muy similar al famoso juego Lights Out). Para resolverlo de forma eficiente, el secreto está en cambiar la perspectiva: en lugar de intentar adivinar qué botones presionar a ciegas, modelamos el tablero utilizando aritmética modular y una búsqueda de estados.

---

## 1. El Análisis Matemático

El tablero consta de una cuadrícula de 3x3, lo que nos da un total de 9 botones.

* Denotaremos los botones/celdas con índices del 0 al 8:
```
  0  1  2
  3  4  5
  6  7  8
```

* Cada variable representa cuántas veces presionamos ese botón específico.
* Dado que los números en el display van del 0 al 3 y al pasar de 3 vuelven a empezar en 0, cualquier pulsación extra por encima de 3 es redundante (presionar un botón 4 veces te regresa al mismo estado).
* Por lo tanto, operamos en Módulo 4. Cada botón se puede presionar 0, 1, 2 o 3 veces.

### El efecto de presionar un botón
Cuando presionas un botón k, sumas +1 a su propio valor, a todos los botones de su misma fila y a todos los de su misma columna.

## 2. Modelado del Espacio de Estados

Para saber si el safe se puede abrir y en cuántos pasos, debemos analizar qué tan grande es el universo de posibilidades.

* Tenemos 9 celdas.
* Cada celda puede tener uno de 4 valores posibles (0, 1, 2, 3).
* El número total de configuraciones (estados) posibles que puede tener el tablero es: 4^9 = 262,144.

Como 262,144 es un número increíblemente pequeño para la memoria de una computadora actual, la forma más segura y óptima de resolver el problema es mediante un algoritmo de Búsqueda en Anchura (BFS).

---

## 3. Estrategia de Resolución (BFS)

El algoritmo BFS es ideal aquí porque procesa los estados por "capas" (primero todos los tableros a 1 click de distancia, luego a 2 clicks, etc.). Esto garantiza de forma natural que el primer camino que encuentre hacia la solución será el mínimo número de pulsaciones.

### Pasos del Algoritmo:
1. Representación: Convertimos el tablero de 3x3 en un único número entero para manipularlo fácilmente. Por ejemplo, si el tablero es:
```
   3 1 2
   0 1 1  --> El entero resultante es: 312011323
   3 2 3
```
2. Estructura de Visitados: Creamos un arreglo de distancias de tamaño 262,144. Para optimizar el espacio, mapeamos el número entero (que está en base 10) a su equivalente en Base 4 (mediante una función stateToId), obteniendo un índice único entre 0 y 262,143.

3. Inicialización: Añadimos el estado inicial a una cola (Queue) y marcamos su distancia como 0.

4. Bucle Principal:
    * Sacamos un estado de la cola.
    * Si el estado actual es igual a 0 (es decir, 000000000), ¡hemos ganado! Imprimimos la distancia acumulada.
    * Si no, simulamos presionar cada uno de los 9 botones de manera independiente.
    * Para cada nuevo estado generado, si no ha sido visitado antes, calculamos su distancia (distancia_actual + 1) y lo metemos a la cola.

5. Caso Imposible: Si la cola se vacía y nunca pudimos transformar el tablero en todo ceros, significa que la configuración inicial es un estado huérfano inalcanzable. El programa devuelve -1.

---

## 4. Complejidad

* Complejidad Temporal: O(V + E) donde V es el número de estados (4^9) y E son las transiciones (9 * 4^9). En el peor de los casos, realiza poco más de 2 millones de operaciones, lo cual se ejecuta en menos de 0.05 segundos en Java.
* Complejidad Espacial: O(4^9) para almacenar el arreglo de estados visitados, ocupando apenas unos cuantos Kilobytes de memoria RAM.