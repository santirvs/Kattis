package Cap3._2_BusquedaCompleta._12_BacktrackingDificiles;

// Problema de la cesta de frutas con hasta 40 tipos de frutas diferentes
// Restricciones: Peso >= 200, Máximo una fruta de cada tipo. Cada pieza pesa un mínimo de 50
// Cualquier combinación de 4 o más frutas será válida  4 x 50+ >= 200
// Se pueden comprobar qué combinaciones de hasta 3 frutas no son válidas y descartarlas.
// Se espera que con hasta 40 frutas haya muchas más combinaciones válidas que no válidas
// Pero nos piden la suma de las cestas válidas...  ¿cómo sumarlas?
// El peso total de todas las combinaciones de frutas es pesoTotal * 2^(N-1)
// El problema se reduce a restar del peso total el peso de las combinaciones no válidas
// Y las cestas no válidas se pueden calcular fácilmente con backtracking


import java.util.Scanner;


public class FruitBaskets {

    static long pesoCestasNoValidas = 0; // Peso de las combinaciones no válidas
    static int numFrutas; // Número de tipos de frutas
    static int[] pesoFrutas;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // Leer el número de piezas de fruta
        numFrutas = scan.nextInt();
        long pesoTotal = 0;
        // Leer el peso de cada tipo de fruta
        pesoFrutas = new int[numFrutas];
        for (int i = 0; i < numFrutas; i++) {
            pesoFrutas[i] = scan.nextInt();
            pesoTotal += pesoFrutas[i];     // Acumula el peso de las frutas
        }

        // Calcula el peso total de todas las combinaciones de cestas de frutas (válidas y no válidas)
        pesoTotal = pesoTotal * (1L << (numFrutas - 1)); // 2^(N-1) es el número de combinaciones posibles

        backtracking(0, 0);

        //Mostrar el peso total de las cestas válidas
        System.out.println(pesoTotal - pesoCestasNoValidas);
    }

    private static void backtracking(int posicion, int pesoCesta) {

        // Caso directo de finalización. Hemos llegado al final de la lista de frutas
        if (posicion == numFrutas) {
            // Se ha llegado al final. Se acumula el peso de la cesta
            pesoCestasNoValidas += pesoCesta;
            return;
        }

        // Caso recursivo. Se prueba a incluir la fruta actual en la cesta
        // Se incluye la fruta actual en la cesta
        if (pesoCesta + pesoFrutas[posicion] < 200) {
            //Si con la fruta actual la cesta sigue siendo válida, se acumula el peso
            backtracking(posicion + 1, pesoCesta + pesoFrutas[posicion]);
        }

        // Caso recursivo. Se ignora la fruta actual
        backtracking(posicion + 1, pesoCesta);
    }



}
