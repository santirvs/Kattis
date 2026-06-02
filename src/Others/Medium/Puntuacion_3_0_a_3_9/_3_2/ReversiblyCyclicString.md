# 1.Conceptos
## A. ¿Qué es una Subcadena Cíclica?
El problema dice que una cadena $A$ es una subcadena cíclica de $S$ si $A$ aparece en alguna rotación de $S$.
- El truco clásico: Cualquier rotación de una cadena $S$ es siempre una subcadena de $S + S$ (la cadena duplicada).
- Ejemplo: Si $S = \text{"fatcat"}$, entonces $S + S = \text{"fatcatfatcat"}$.
- Si buscas "atf", verás que está dentro de "fatcatfatcat". Por lo tanto, comprobar si algo es una "subcadena cíclica" es tan simple como verificar si es una subcadena normal de $S + S$.

## B. ¿Qué es "Internally Reversibly Cyclic"?
El problema te pide que para cada subcadena propia $A$ de $S$, su reverso ($A^R$) debe ser una subcadena cíclica de $S$ (es decir, $A^R$ debe estar dentro de $S + S$).
Nota clave: Una subcadena "propia" es cualquier subcadena que no sea la cadena completa $S$. Es decir, subcadenas de longitud desde $1$ hasta $|S|-1$.
# 2.El Análisis de Fuerza Bruta (Y por qué no es viable directamente)
Si intentáramos probar el texto de forma literal:
- Duplicamos la cadena: $T = S + S$.
- Generamos todas las subcadenas posibles de $S$ (hay $O(|S|^2)$ subcadenas).
- Invertimos cada subcadena.
- Buscamos si la subcadena invertida existe dentro de $T$.

Dado que la longitud de $S$ puede ser de hasta $10^5$, el número de subcadenas sería de aproximadamente $\frac{(10^5)^2}{2} = 5 \times 10^9$. Generar e invertir todas nos daría un error de Tiempo Límite Excedido (TLE) catastrófico. Necesitamos una propiedad matemática que reduzca esto.

# 3. La Reducción Eficiente: El Poder de los Caracteres Pequeños
Pensemos en qué pasa con las subcadenas más pequeñas posibles. Si la propiedad se debe cumplir para todas las subcadenas, debe cumplirse obligatoriamente para las subcadenas de longitud 2 y longitud 3.
## Caso 1: Subcadenas de longitud 2
Si tomamos cualquier par de caracteres adyacentes en $S$, por ejemplo $xy$, su reverso es $yx$. Para que la cadena sea válida, $yx$ debe aparecer en alguna parte de las rotaciones de $S$ (en $S+S$).Esto significa que si en tu cadena aparece la transición de la letra $x$ a la letra $y$, en alguna otra parte (o de forma cíclica) debe existir la transición de $y$ a $x$.
## Caso 2: El colapso geométrico de las condiciones
Si extiendes esta lógica a subcadenas de longitud 3 ($xyz$ al revertirse es $zyx$), la restricción se vuelve tan absurdamente estricta que muy pocas cadenas en el universo pueden cumplirla.
<br>De hecho, en teoría de palabras y combinatoria de cadenas, una cadena solo puede cumplir que todos sus reversos cíclicos existan cíclicamente si la cadena pertenece a uno de estos tres grupos ultra-restringidos:
- Todas las letras son iguales: (Ejemplo: aaaaa). Cualquier subcadena invertida sigue siendo igual a sí misma.
- Es un palíndromo puro o casi puro y es periódica: Cadenas formadas por la repetición monótona de máximo 2 caracteres ordenados de una forma muy específica (como el Sample 1: ccca, cuyas subcadenas son c, cc, ccc, ccca (no cuenta por ser completa), cca, ca. Sus reversos son c, cc, ccc, acc, ac. Si duplicas ccca -> cccaccca, verás que todas esas invertidas existen ahí dentro).
- El alfabeto efectivo de la cadena es ridículamente pequeño: Si una cadena tiene 3 o más caracteres completamente distintos es prácticamente imposible que cumpla la condición a menos que sea una estructura extremadamente simétrica y pequeña.

## La Estrategia de los K-meros (Testing de subcadenas cortas)
Existe un teorema que nos dice que no necesitamos probar todas las longitudes hasta $10^5$. Si una cadena falla la condición, casi siempre fallará en subcadenas muy cortas (longitud 2 o longitud 3).
Una propiedad matemática de este problema nos dice que si la condición se cumple para todas las subcadenas de longitud 2 y de longitud 3, se cumplirá para absolutamente todas las demás longitudes.


# Wrong Answer?
Cuando las cadenas tienen patrones repetitivos (como un palíndromo puro), la lógica de las frecuencias se rompe.
<br>Para no adivinar más con teoremas restrictivos y asegurar el 100% de los casos de prueba (AC), volvamos a la raíz del problema de forma ultra-eficiente. Dado que $N \le 10^5$, no podemos hacer un algoritmo de $O(N^2)$, pero sí podemos optimizar la fuerza bruta usando algoritmos de búsqueda de subcadenas modernos como KMP o String.indexOf(), combinados con una observación clave.


# Enfoque aún más simple

Para que una cadena sea válida, el reverso de toda subcadena propia debe estar en S + S.
- ¿Cuál es la subcadena propia más grande y difícil de cumplir? La de longitud $N-1$.
- Si la subcadena propia más larga (de tamaño $N-1$) se puede revertir y encontrar en S + S, casi automáticamente todas sus subcadenas hijas más pequeñas también lo harán.

En lugar de verificar todas las subcadenas, solo necesitamos verificar las dos subcadenas propias máximas:
- La subcadena que va desde el índice 0 hasta N-2 (quitando el último carácter).
- La subcadena que va desde el índice 1 hasta N-1 (quitando el primer carácter).

Si invertimos estas dos subcadenas largas y ambas existen dentro de la rotación cíclica (S + S), la cadena es Internally Reversibly Cyclic.

¿Por qué esto es rápido?
En Java, buscar una cadena larga dentro de otra (s.indexOf()) utiliza optimizaciones a nivel de lenguaje que toman tiempo lineal o casi lineal en la práctica. Invertir solo dos cadenas de tamaño $N$ toma $O(N)$. Así evitamos los bucles anidados y los sets gigantes.


