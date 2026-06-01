Para resolver el problema "Good Coalition", debemos cambiar nuestra mentalidad: aunque hable de política y probabilidades, en el fondo es un problema clásico de optimización combinatoria.

Aquí tienes el planteamiento teórico y la estrategia algorítmica para resolverlo de forma eficiente.

## 1.Identificación del Problema
Este problema es una variante del Problema de la Mochila (Knapsack Problem), específicamente solucionable mediante Programación Dinámica (DP).
- Los "Objetos": Son los partidos políticos.
- El "Peso" (Capacidad): Son los escaños (seats). El objetivo es alcanzar un "peso" total de al menos 76 escaños (la mayoría estricta de 150).
- El "Valor" a maximizar: Es la probabilidad de estabilidad. A diferencia de la mochila tradicional donde los valores se suman, aquí las probabilidades se multiplican.

## 2.Modelado Matemático y de Estado
Queremos elegir un subconjunto de partidos de tal manera que:
- $\sum \text{escaños} \ge 76$
- $\prod \text{probabilidad} \rightarrow \text{sea máxima}$

### Definición del Estado de la Programación Dinámica:
Podemos definir un array unidimensional dp de tamaño $151$ (índices del 0 al 150), donde: dp[s] = La máxima probabilidad posible de formar una coalición que sume exactamente s escaños.
- Casos Base:
  - dp[0] = 1.0 (o 100.0 si prefieres trabajar con porcentajes directamente). Si no elegimos ningún partido, la probabilidad inicial "vacía" es del 100%.
  - Para todos los demás escaños (1 a 150), inicializamos dp[s] = 0.0, ya que inicialmente no conocemos ninguna combinación que sume esos escaños.
## 3. Estrategia de Transición (El Algoritmo)
Para cada partido disponible (con sus escaños $S_i$ y su probabilidad $P_i$ expresada en formato de $0.0$ a $1.0$):
<br>Debemos actualizar el array dp de atrás hacia adelante (desde $150$ hasta $S_i$) para evitar usar el mismo partido más de una vez (comportamiento típico de la mochila 0/1).
<br>Para cada número de escaños actual $s$:
$$\text{Nuevo } dp[s] = \max(dp[s], dp[s - S_i] \times P_i)$$
¿Qué significa esto en lenguaje claro?
<br>Que la máxima probabilidad de conseguir exactamente $s$ escaños teniendo en cuenta al partido actual es el máximo entre:
- No incluir al partido actual (mantener el valor que ya tenía dp[s]).
- Incluir al partido actual, lo que significa tomar la mejor probabilidad de haber conseguido $s - S_i$ escaños previamente y multiplicarla por la probabilidad de este partido ($P_i$).

## 4. Obtención del Resultado
Una vez que hayamos procesado todos los partidos políticos con el bucle de programación dinámica, las respuestas válidas estarán concentradas en las posiciones del arreglo que representen una mayoría estricta.
<br>Dado que el total de escaños es 150, la mayoría estricta se alcanza a partir de 76 escaños. Por lo tanto, la respuesta final al problema será el valor máximo encontrado en el rango de dp[76] hasta dp[150].

### Ejemplo de flujo con el Caso de Ejemplo:
Partidos: (35, 80%), (25, 70%), (60, 60%), (30, 90%)
<br>Al procesar las combinaciones, la DP descubrirá que si juntas el partido de 25 escaños y el de 60 escaños:Suman $25 + 60 = 85$ escaños (es $\ge 76$, es válido).Su probabilidad combinada es $0.70 \times 0.60 = 0.42$ ($42\%$).Sin embargo, si juntas el de 35, el de 25 y el de 30:Suman $35 + 25 + 30 = 90$ escaños (es $\ge 76$, es válido).Su probabilidad combinada es $0.80 \times 0.70 \times 0.90 = 0.504$ ($50.4\%$).Al final del día, la DP evaluará todas las combinaciones eficientemente en tiempo $O(N \times 150)$, y la combinación óptima para este caso dará el 54.0% que pide el output (que resulta de juntar el de 35 escaños y el de 60 escaños: $35+60 = 95$ escaños $\rightarrow 0.80 \times 0.60 = 0.48$... un momento, el ejemplo da 54.0% porque la combinación ideal exacta es el partido de 60 escaños y el de 30 escaños $\rightarrow 60+30 = 90$ escaños $\rightarrow 0.60 \times 0.90 = 0.54 \rightarrow \mathbf{54.0\%}$).

## 5.Complejidad
- Tiempo: $O(N \times 150)$ por caso de prueba. Como $N \le 150$, esto requiere a lo sumo unas $22,500$ operaciones por caso, lo cual corre en apenas unos pocos milisegundos (lejos de dar TLE).
- Espacio: $O(150)$ que es una cantidad de memoria fija e insignificante.