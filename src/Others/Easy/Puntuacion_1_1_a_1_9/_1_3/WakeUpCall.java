package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer la cantidad de datos de las secuencias 1 y 2
// Leer e ir sumando los datos de la secuencia 1
// Leer e ir sumando los datos de la secuencia 2
// Comparar las sumas
// Mostrar el resultado


//v1. TLE en caso 19 --> Acelerar la lectura con FastScanner
//v2 --> AC

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WakeUpCall {
    public static void main(String[] args) throws IOException {

        //Scanner scan = new Scanner(System.in);
        FastScanner scan =  new FastScanner();

        //Leer el tamaño de las secuencias
        int cantidad1 = scan.nextInt();
        int cantidad2 = scan.nextInt();
        
        //Leer y acumular la secuencia 1
        int suma1 = 0;
        for (int i = 0; i < cantidad1; i++) {
            suma1 += scan.nextInt();
        }
        
        //Leer y acumular la secuencia 2
        int suma2 = 0;
        for (int i = 0; i < cantidad2; i++) {
            suma2 += scan.nextInt();
        }

        //Comparar y mostrar el resultado
        if (suma1 > suma2) {
            System.out.println("Button 1");
        }
        else if (suma1 < suma2) {
            System.out.println("Button 2");
        }
        else {
            System.out.println("Oh no");
        }


    }



    // Lector rápido
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}