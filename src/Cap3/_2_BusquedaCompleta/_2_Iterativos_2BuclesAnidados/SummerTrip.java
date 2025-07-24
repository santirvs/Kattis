package Cap3._2_BusquedaCompleta._2_Iterativos_2BuclesAnidados;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1o.- No tengo nada claro que es lo que se pide. No lo entiendo! Para el primer caso de prueba
//      me aparecen muchos más de 10 itinerarios posibles. ---> Algo del enunciado no lo entendí bien.
// 2o.- Adapto el código de https://github.com/JonSteinn/Kattis-Solutions/blob/master/src/Summer%20Trip/C/main.c
//      a Java
// 3o.- Sigo sin entender el enunciado ni qué hace el programa
//      Parece ser que aprovecha que hay 26 letras para mapearlas sobre un entero de 32 bits
//      y así poder contar los bits a 1 de cada letra.
//      No entiendo el funcionamiento de count...  :-(

public class SummerTrip {

    // Funció per comptar els bits a 1 (popcount) d’un enter
    // Algorisme de Brian Kernighan per comptar bits a 1
    public static int ones(int i) {
        i = i - ((i >> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >> 2) & 0x33333333);
        return (((i + (i >> 4)) & 0x0F0F0F0F) * 0x01010101) >>> 24;
    }


    public static int count(String word) {
        int counter = 0;
        int[] sinceLast = new int[26];
        for (int i = 0; i < 26; i++) {
            sinceLast[i] = 1 << (word.charAt(0) - 'a');
        }
        sinceLast[word.charAt(0) - 'a'] = 0;

        for (int i = 1; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            counter += ones(sinceLast[idx]);
            for (int j = 0; j < 26; j++) {
                sinceLast[j] |= 1 << idx;
            }
            sinceLast[idx] = 0;
        }
        return counter;
    }

    public static void main(String[] args) throws IOException {
        // Llegir línia d’entrada
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        // Resoldre el cas
        int result =count(line);
        // Imprimir el resultat
        System.out.println(result);
    }
}
