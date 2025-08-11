package Cap3._2_BusquedaCompleta._7_ProbarTodasRespuestasPosibles;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// Parece un simple problema de ir probando todas las combinaciones posibles en un rango



public class HeirsDilemma {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer los límites del rango
        int min = sc.nextInt();
        int max = sc.nextInt();

        int numResultados = 0;
        for (int i = min; i <= max; i++) {
            if (cifrasDiferentes(i) && noTieneCeros(i) && esDivisiblePorCadaDigito(i)) {
                numResultados++;
            }
        }

        // Mostrar el número de resultados encontrados
        System.out.println(numResultados);
    }

    private static boolean esDivisiblePorCadaDigito(int i) {
        String numero = String.valueOf(i);
        for (char c : numero.toCharArray()) {
            int digito = Character.getNumericValue(c);
            if (digito == 0 || i % digito != 0) {
                return false; // Si el dígito es 0 o no divide al número, no es válido
            }
        }
        return true; // Todos los dígitos dividen al número
    }

    private static boolean noTieneCeros(int i) {
        String numero = String.valueOf(i);
        return !numero.contains("0"); // Comprobar si el número contiene el dígito '0'
    }

    private static boolean cifrasDiferentes(int i) {
        Set<Character> cifras = new TreeSet<>();
        String numero = String.valueOf(i);
        for (char c : numero.toCharArray()) {
            if (cifras.contains(c)) {
                return false; // Si ya contiene la cifra, no son diferentes
            }
            cifras.add(c);
        }
        return true; // Todas las cifras son diferentes
    }
}
