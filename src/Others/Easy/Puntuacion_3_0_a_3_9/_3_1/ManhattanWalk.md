Este problema es fantástico y bastante profundo. No se trata de una simple suma de caminos, sino de un problema de Programación Dinámica con Valor Esperado (Expected Value DP), donde debes tomar decisiones óptimas bajo incertidumbre (Proceso de Decisión de Markov).

Vamos a desglosar la lógica matemática detrás del problema para entender cómo calcular ese valor esperado y luego implementarlo en Java.

## Análisis del Problema y Deducción Matemática

Estás en una celda $(i, j)$ de una cuadrícula de tamaño $R \times C$. Tu objetivo es llegar a $(R-1, C-1)$ minimizando el tiempo de espera.

Al llegar a una celda, te encuentras con dos variables aleatorias:
- La dirección de la flecha: Puede ser Abajo ($\downarrow$) o Derecha ($\rightarrow$) con probabilidad de $50\%$ cada una ($0.5$).
- El temporizador ($t$): Está distribuido uniformemente entre $0$ y $W$. Es decir, la probabilidad de que falten $t$ segundos es uniforme.

Llamemos $E(i, j)$ al tiempo esperado mínimo de espera desde la celda $(i, j)$ hasta el final.

### Casos Base: Los Bordes de la Cuadrícula

- En la meta $(R-1, C-1)$: Ya llegaste, el costo es $0$.$$E(R-1, C-1) = 0$$
- En la última fila $(R-1, j)$: Ya no puedes ir hacia abajo. Obligatoriamente tienes que ir a la derecha. Si la flecha apunta a la derecha, avanzas gratis. Si apunta hacia abajo, tienes que esperar a que el temporizador llegue a $0$. Como el tiempo $t$ es uniforme entre $0$ y $W$, el tiempo esperado de espera si te toca la flecha incorrecta es el valor medio: $W/2$.
<br>Por lo tanto, la mitad de las veces esperas $0$ y la otra mitad esperas un promedio de $W/2$:$$E(R-1, j) = E(R-1, j+1) + 0.5 \cdot 0 + 0.5 \cdot \frac{W}{2} = E(R-1, j+1) + \frac{W}{4}$$
- En la última columna $(i, C-1)$: Es un caso simétrico al anterior, solo puedes ir hacia abajo.$$E(i, C-1) = E(i+1, C-1) + \frac{W}{4}$$

### El Caso General: Celdas Intermedias
Cuando estás en una celda $(i, j)$ donde puedes ir tanto Abajo como a la Derecha, el temporizador te muestra un tiempo restante $t$ (donde $0 \le t \le W$). Aquí es donde tomas una decisión óptima.

Supongamos que la flecha apunta en la dirección de la celda con el peor camino (mayor valor esperado). ¿Te conviene esperar a que cambie la flecha hacia el camino más barato, o te conviene irte ya mismo por el camino caro para no perder tiempo?

Definamos:
- $A = E(i+1, j)$ (Costo esperado si vas Abajo)
- $B = E(i, j+1)$ (Costo esperado si vas a la Derecha)

Para facilitar la explicación, asumamos sin pérdida de generalidad que $A \le B$ (ir hacia abajo es más barato o igual que ir a la derecha).

- Si la flecha apunta hacia Abajo (el camino barato):Te vas inmediatamente. No esperas nada. El costo es $A$.
- Si la flecha apunta hacia la Derecha (el camino caro):
<br>Tienes el temporizador enfrente marcando un tiempo $t$. Tienes dos opciones:
  - Opción 1 (Moverte ya): Te vas por la derecha. El costo total es $B$.
  - Opción 2 (Esperar): Esperas $t$ segundos a que la flecha cambie hacia abajo. El costo total será $t + A$.

Como eres un jugador óptimo, elegirás el mínimo de ambos: $\min(B, t + A)$.
El punto de quiebre ocurre cuando $t + A = B$, es decir, cuando $t = B - A$.
- Si $t < B - A$, te conviene esperar porque el temporizador terminará rápido.
- Si $t > B - A$, el temporizador va a tardar demasiado, mejor te vas por el camino caro de una vez.

Dado que $t$ está acotado por el tiempo máximo $W$, tenemos dos subcasos para calcular la integral de la decisión óptima cuando la flecha apunta al lado "malo":
- Subcaso 1: Si $B - A \ge W$
<br>Incluso si el temporizador está en su punto máximo ($W$), siempre es menor o igual que $B-A$. Por lo tanto, siempre te conviene esperar. El tiempo promedio de espera será la media de la distribución uniforme: $\frac{W}{2}$.
<br>El costo esperado en este escenario si la flecha apunta al lado malo es: $\frac{W}{2} + A$.
- Subcaso 2: Si $B - A < W$
<br>Aquí depende de $t$. Si $t$ es pequeño (entre $0$ y $B-A$), esperas $t$ y luego pagas $A$. Si $t$ es grande (entre $B-A$ y $W$), no esperas y pagas $B$.
<br>Al calcular el valor esperado (mediante cálculo integral continuo de la distribución uniforme de $0$ a $W$), el costo promedio cuando la flecha apunta al lado malo resulta ser:$$\text{Costo Malo} = B - \frac{(B - A)^2}{2W}$$

## Ecuación Final de DP
Como hay $50\%$ de probabilidad de que la flecha apunte al lado bueno ($A$) y $50\%$ al lado malo:$$E(i, j) = 0.5 \cdot A + 0.5 \cdot (\text{Costo Malo})$$