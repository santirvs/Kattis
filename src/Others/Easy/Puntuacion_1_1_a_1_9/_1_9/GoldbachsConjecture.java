package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

/**
 * Construir una lista de números primos menores de 32000
 * Para cada número:
 *  - Leer el número a buscar
 *  - Tomar el primer y último primo de la lista
 *  - Es mayor al número que se busca? -> Reducir por la derecha
 *  - Es menor al número que se busca? -> Incrementar por la izquierda
 *  - Es igual al número que se busca? -> Añadir a la lista
 *  - Seguir hasta que los índices se crucen
 *  - Mostrar la lsita
 */


import java.io.IOException;
import java.util.*;

public class GoldbachsConjecture {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        List<Integer> primos = obtenerPrimosMenoresQue(32000);

        int numCasos = sc.nextInt();

        while (numCasos-- >0) {
            int numero = sc.nextInt();
            int idxIzquierda = 0;
            int idxDerecha = primos.size()-1;
            ArrayList<Integer> listaSuma = new ArrayList<Integer>();

            while (idxIzquierda <= idxDerecha) {
                int suma = primos.get(idxIzquierda) + primos.get(idxDerecha);
                if (suma == numero ) {
                    listaSuma.add (primos.get(idxIzquierda));
                    listaSuma.add (primos.get(idxDerecha));
                    idxDerecha--;
                    idxIzquierda++;
                }
                else if (suma > numero) {
                    idxDerecha--;
                } else {
                    idxIzquierda++;
                }
            }

            //Mostrar el resultado
            System.out.println(numero + " has " + listaSuma.size()/2 + " representation(s)");
            for (int i=0; i<listaSuma.size(); i+=2){
                System.out.println(listaSuma.get(i) + "+" + listaSuma.get(i+1));
            }
            System.out.println();
        }


        sc.close();
    }


    public static List<Integer> obtenerPrimosMenoresQue(int n) {
        List<Integer> primos = new ArrayList<>();
        if (n <= 2) {
            return primos; // No hay números primos menores que 2
        }

        // Crear un arreglo booleano para marcar los números primos
        boolean[] esPrimo = new boolean[n];
        Arrays.fill(esPrimo, true);
        esPrimo[0] = false;
        esPrimo[1] = false;

        // Criba de Eratóstenes
        for (int i = 2; i * i < n; i++) {
            if (esPrimo[i]) {
                for (int j = i * i; j < n; j += i) {
                    esPrimo[j] = false;
                }
            }
        }

        // Recopilar los números primos encontrados
        for (int i = 2; i < n; i++) {
            if (esPrimo[i]) {
                primos.add(i);
            }
        }

        return primos;
    }
}