package Cap3._2_BusquedaCompleta._3_Iterativos_3BuclesAnidadosFaciles;

// Fuerza bruta
// Tomar 3 cartas y ver si forman un set
// Un set es un conjunto de 3 cartas en las que cada atributo es igual en todas las cartas o es diferente en todas las cartas
// Hay cuatro atributos a verificar
// Si se recorren en orden, ya se imprimiran en el orden esperado
// Podemos guardar los resultados en una lista de Strings

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Set {

     public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        //Resultados
        List<String> resultados = new ArrayList<>();

        List<String> cartas = new ArrayList<>();
        //Leer las cartas
        for (int i = 0; i < 12; i++) {
            String carta = scan.next();
            cartas.add(carta);
        }

        //Buscar sets
        for (int i = 0; i < cartas.size()-2; i++) {
            for (int j = i + 1; j < cartas.size()-1; j++) {
                for (int k = j + 1; k < cartas.size(); k++) {
                    String carta1 = cartas.get(i);
                    String carta2 = cartas.get(j);
                    String carta3 = cartas.get(k);

                    if (esSet(carta1, carta2, carta3)) {
                        resultados.add((i+1) + " " + (j+1) + " " + (k+1));
                    }
                }
            }
        }

        //Imprimir resultados
        if (resultados.isEmpty()) {
            System.out.println("no sets");
        } else {
            for (String resultado : resultados) {
                System.out.println(resultado);
            }
        }
    }

    private static boolean esSet(String carta1, String carta2, String carta3) {
        // Comprobar cada atributo de las cartas
        for (int i = 0; i < 4; i++) {
            char atributo1 = carta1.charAt(i);
            char atributo2 = carta2.charAt(i);
            char atributo3 = carta3.charAt(i);

            // Si los atributos son todos iguales o todos diferentes, continuamos
            if (!(atributo1 == atributo2 && atributo2 == atributo3) &&
                !(atributo1 != atributo2 && atributo1 != atributo3 && atributo2 != atributo3)) {
                return false; // No es un set
            }
        }
        return true; // Es un set
    }
}

