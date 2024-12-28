package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._8_BST_Equilibrado_Map;

import java.io.*;
import java.util.TreeMap;



public class Srednji {

    public static void main(String[] args) throws IOException {
        //Scanner scan = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        //Lee la cantidad de número y el valor que hará de mediana una vez ordenados
        String[] partes = in.readLine().split(" ");
        int cantidadNumeros = Integer.parseInt(partes[0]);
        int mediana = Integer.parseInt(partes[1]);

        //Lee los números y los guarda en un array
        //Además, guarda la posición que ocupa el valor de la mediana
        int[] numeros = new int[cantidadNumeros];
        int posicion = 0;
        partes = in.readLine().split(" ");
        for (int i = 0; i < cantidadNumeros; i++) {
            numeros[i] = Integer.parseInt(partes[i]);
            if (numeros[i] == mediana) {
                posicion = i;
            }
        }

        //Crea un mapa que guardará la cantidad de números que hay a la derecha de la mediana
        //y la cantidad de números que hay a la izquierda de la mediana
        TreeMap<Integer, Integer> mapaDistancias = new TreeMap<>();
        mapaDistancias.put(0, 1);
        int suma = 0;
        for (int i = posicion + 1; i < cantidadNumeros; i++) {
            if (numeros[i] > mediana) suma++;
            else suma--;
            mapaDistancias.put(suma, mapaDistancias.getOrDefault(suma, 0) + 1);
        }

        //
        long resultado = mapaDistancias.get(0);
        suma = 0;
        for (int i = posicion - 1; i >= 0; i--) {
            if (numeros[i] > mediana) suma++;
            else suma--;
            resultado += mapaDistancias.getOrDefault(-suma, 0);
        }

        out.println(resultado);

        out.flush();
        out.close();
        in.close();
    }

}

