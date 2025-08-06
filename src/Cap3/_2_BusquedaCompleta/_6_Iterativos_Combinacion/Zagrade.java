package Cap3._2_BusquedaCompleta._6_Iterativos_Combinacion;

import java.util.*;

// Procesar la expresión de entrada e identificar los pares de paréntesis (usar una pila para esto)
// Una vez identificados los pares de paréntesis, contarlos
// Recorrer todas las combinaciones de paréntesis y eliminar esos caracteres de la expresión original
// Ir almacenando en un HashSet todas las combinaciones de la expresión resultante
// Imprimir los resultados de forma ordenana

public class Zagrade {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Leer la expresión de entrada
        String expresion = sc.nextLine();

        //Recorrer la expresión para encontrar los pares de paréntesis
        Stack<Integer> pila = new Stack<>();
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < expresion.length(); i++) {
            if (expresion.charAt(i) == '(') {
                pila.push(i); // Guardamos el índice del paréntesis de apertura
            } else if (expresion.charAt(i) == ')') {
                //Cierre de paréntesis encontrado
                //Sacar de la pila el último indice de apertura y añadir ambos índices a la lista
                int inicio = pila.pop();
                indices.add(inicio);
                indices.add(i);
            }
        }

        // Ahora tenemos los índices de apertura y cierre de todos los pares de paréntesis
        int numParesParentesis = indices.size() /2;
        TreeSet<String> resultados = new TreeSet<>();

        // Generar todas las combinaciones y eliminar los paréntesis
        // Empezar por 1 para evitar la combinación vacía (expresión original)
        for (int i=1; i < (1 << numParesParentesis); i++) {
            StringBuilder resultado = new StringBuilder(expresion);
            for (int j = 0; j < numParesParentesis; j++) {
                if ((i & (1 << j)) != 0) { // Si el bit j está activo, eliminamos el par de paréntesis
                    int inicio = indices.get(2*j);
                    int fin = indices.get(2*j+1);
                    resultado.replace(inicio, inicio+1, "X");
                    resultado.replace(fin, fin + 1, "X");
                }
            }
            // Reemplazamos las X por espacios para mostrar la expresión sin paréntesis
            resultados.add(resultado.toString().replace("X", ""));
        }

        // Mostrar los resultados ordenados
        for (String resultado : resultados) {
            System.out.println(resultado);
        }

    }
}
