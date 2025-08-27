package Cap3._3_DivideYVenceras._2_BiseccionBSTAFaciles;

// Estrategia de D&C. Bisección binaria

// Buscar la cantidad máxima de moléculas de salida que se pueden conseguir con n moléculas de entrada

// Se puede aplicar una búsqueda binaria sobre el número de moléculas de salida, desde 0 hasta un número máximo.
// Para cada número de moléculas de salida, se cuenta cuántas moléculas de entrada se necesitan.
// Si el número de moléculas de entrada es menor o igual que el número de moléculas de entrada disponibles, se intenta con
// un número mayor de moléculas de salida; si no, se intenta con un número menor de moléculas de salida.


import java.util.*;
import java.io.*;

public class HToO {

    // Méthodo para parsear una fórmula molecular
    private static Map<String, Integer> getElements(String mol) {
        mol += "A"; // Dummy terminator
        String cur = "";

        // Mapa para contar los elementos y sus cantidades
        Map<String, Integer> elements = new HashMap<>();

        // Recorrer cada carácter de la molécula
        for (char c : mol.toCharArray()) {
            // Si es una letra, es el inicio de un nuevo elemento
            if (Character.isAlphabetic(c)) {
                if (cur.isEmpty()) {
                    //Nuevo elemento
                    cur = String.valueOf(c);
                    continue;
                }
                // El anterior elemento ha terminado, procesarlo con su cantidad
                String el = String.valueOf(cur.charAt(0)); // El símbolo del elemento
                // La cantidad del elemento (si no hay número, es 1)
                int amt = (cur.length() > 1) ? Integer.parseInt(cur.substring(1)) : 1;

                elements.put(el, elements.getOrDefault(el, 0) + amt);

                // Empezar a construir el nuevo elemento
                cur = String.valueOf(c);
            } else {
                // No es una letra, tratar el carácter como parte de la cantidad
                cur += c;
            }
        }
        return elements;
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        // Leer la molécula y el número de moléculas disponibles
        String mol = scan.next();
        int n = scan.nextInt();

        // Parsear la molécula de entrada
        Map<String, Integer> elements = getElements(mol);
        // Multiplicar todos los elementos por n
        for (String el : elements.keySet()) {
            elements.put(el, elements.get(el) * n);
        }

        // Leer la molécula objetivo y parsearla
        String target = scan.next();
        Map<String, Integer> targetElements = getElements(target);

        long ans = (long) 1e10;  // Valor inicial muy grande

        // Calcular el número máximo de moléculas objetivo que se pueden formar
        // que será el mínimo entre cada uno de los átomos necesarios
        for (Map.Entry<String, Integer> entry : targetElements.entrySet()) {
            String el = entry.getKey();
            int amt = entry.getValue();

            if (!elements.containsKey(el)) {
                System.out.println(0);
                return;
            }
            ans = Math.min(ans, elements.get(el) / amt);
        }

        System.out.println(ans);
    }
}
