package Others.Easy.Puntuacion_2_0_a_2_9._2_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FairShare {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int numAmigos = Integer.parseInt(line.trim()); // Número de amigos

        int[] efectivo = new int[numAmigos];
        int[] parte = new int[numAmigos];

        //Leer los datos
        //Aprovecho para sumar el importe total de la factura y del efectivo
        int importeTotalFactura = 0;
        int sumaTotalEfectivo = 0;
        for (int i=0; i<numAmigos; i++) {
            line = br.readLine();
            String[] partes = line.split(" ");
            efectivo[i] = Integer.parseInt(partes[0]);
            parte[i] = Integer.parseInt(partes[1]);

            importeTotalFactura += parte[i];
            sumaTotalEfectivo +=efectivo[i];
        }

        //Buscar alguno que pueda pagar sin que pague más de lo que le corresponda
        boolean encontrado = false;
        int numAmigo = -1;
        for (int i=0; i<numAmigos && !encontrado; i++) {
            int totalEfectivo = sumaTotalEfectivo - efectivo[i];
            int pagoReal = importeTotalFactura - totalEfectivo;

            if (pagoReal <= parte[i]) {
                encontrado = true;
                numAmigo = i+1;
            }
        }

        //Mostrar el resultado
        if (!encontrado) System.out.println("impossible");
        else System.out.println(numAmigo);

    }
}