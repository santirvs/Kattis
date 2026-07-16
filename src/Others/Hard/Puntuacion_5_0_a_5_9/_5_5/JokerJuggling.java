package Others.Hard.Puntuacion_5_0_a_5_9._5_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class JokerJuggling {
    public static void main(String[] args) {
        // Usamos BufferedReader para una lectura rápida y eficiente de la entrada
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String pattern = reader.readLine();
            String word = reader.readLine();

            if (pattern == null || word == null) {
                System.out.println("no");
                return;
            }

            // Paso 1: Contar la cantidad de asteriscos y de letras en el patrón
            int numAsterisks = 0;
            int numLetters = 0;

            for (int i = 0; i < pattern.length(); i++) {
                if (pattern.charAt(i) == '*') {
                    numAsterisks++;
                } else {
                    numLetters++;
                }
            }

            // Paso 2: Caso base - Si no hay asteriscos, deben ser exactamente iguales
            if (numAsterisks == 0) {
                if (pattern.equals(word)) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
                return;
            }

            // Paso 3: Validar viabilidad matemática de la longitud de la cadena S
            // El espacio restante en 'word' tras descontar las letras del patrón
            int remainingLength = word.length() - numLetters;

            // a) No puede haber una longitud de caracteres negativa restante.
            // b) El espacio restante debe poder dividirse de manera exacta y equitativa entre los asteriscos.
            if (remainingLength < 0 || remainingLength % numAsterisks != 0) {
                System.out.println("no");
                return;
            }

            // L es la longitud exacta que debe tener la cadena candidata S
            int lenS = remainingLength / numAsterisks;

            // Paso 4: Identificar la cadena candidata S
            // Para ello, buscamos la posición del primer asterisco en el patrón.
            // Los caracteres antes del primer '*' deben coincidir exactamente uno a uno con 'word'.
            int firstAsteriskIndexInPattern = pattern.indexOf('*');

            // Si el índice del primer asterisco es mayor que los caracteres disponibles en 'word',
            // significa que el prefijo del patrón es más largo que la palabra entera.
            if (firstAsteriskIndexInPattern > word.length()) {
                System.out.println("no");
                return;
            }

            // Extraemos la subcadena candidata S de la palabra.
            // Empezamos en la posición donde debería estar el primer '*' en correspondencia con 'word'
            // y tomamos 'lenS' caracteres.
            String candidateS = word.substring(firstAsteriskIndexInPattern, firstAsteriskIndexInPattern + lenS);

            // Paso 5: Verificación final
            // Construimos la palabra resultante reemplazando cada '*' por nuestra cadena candidata S.
            StringBuilder reconstructed = new StringBuilder();
            for (int i = 0; i < pattern.length(); i++) {
                char c = pattern.charAt(i);
                if (c == '*') {
                    reconstructed.append(candidateS);
                } else {
                    reconstructed.append(c);
                }
            }

            // Comparamos si la cadena reconstruida es idéntica a la palabra objetivo
            if (reconstructed.toString().equals(word)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

        } catch (IOException e) {
            System.out.println("no");
        }
    }
}