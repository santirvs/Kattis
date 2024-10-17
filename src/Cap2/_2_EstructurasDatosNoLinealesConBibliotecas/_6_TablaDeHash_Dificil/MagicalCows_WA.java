package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._6_TablaDeHash_Dificil;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

// Usar un mapa de <Int,Int> con la clave el número de vacas y el value el número de granjas con ese número de vacas

// Caso #3 -> WA  --> Contador de granjas debe ser long:  2^50 !!!!
//                --> https://github.com/williamfiset/Algorithms/blob/master/src/main/java/com/williamfiset/algorithms/dp/examples/magicalcows/MagicalCows.java
//                --> Lo plantea con una tabla de frecuencias de granjas para un numero de vacas concreto
//                --> y va doblando el número de vacas de cada granja o doblando el número de granjas completas


public class MagicalCows_WA {

    public static void afegirGranges(HashMap<Integer, Long> llista, int key, Long value) {
        if (llista.containsKey(key)) {
            llista.put(key, llista.get(key) + value);
        }
        else
            llista.put(key, value);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int maxVacas = scan.nextInt();
        int numGranjas = scan.nextInt();
        int numVisitas = scan.nextInt();

        //Leer las vacas de cada granja
        HashMap<Integer, Long> vacas = new HashMap<Integer, Long>();
        for (int i = 0; i < numGranjas; i++) {
            int numVacas = scan.nextInt();
            if (vacas.containsKey(numVacas)) {
                vacas.put(numVacas, vacas.get(numVacas) + 1);
            } else {
                vacas.put(numVacas, 1L);
            }
        }

        //Leer los dias de visita
        List<Integer> dias = new ArrayList<Integer>();
        for (int i = 0; i < numVisitas; i++) {
            dias.add(scan.nextInt());
        }

        //Recorrer los dias de visita y mostrar el total de vacas
        for (int dia =0; dia <= 50; dia++) {
            long totalGranjas = 0;
            HashMap<Integer, Long> newVacas = new HashMap<Integer, Long>();
            for (int numVacas : vacas.keySet()) {
                long numGranjasDia = vacas.get(numVacas);
                totalGranjas += numGranjasDia;

                if (numVacas <= maxVacas/2) {
                    //Doblar el número de vacas de las granjas
                    afegirGranges(newVacas, numVacas*2, numGranjasDia);
                }
                else {
                    //Doblar el número de granjas
                    afegirGranges(newVacas, numVacas, numGranjasDia * 2);
                }

            }
            vacas = newVacas;
            if (dias.contains(dia)) {
                System.out.println(totalGranjas);
            }
        }

    }

}



/// FROM https://github.com/williamfiset/Algorithms/blob/master/src/main/java/com/williamfiset/algorithms/dp/examples/magicalcows/MagicalCows.java


/**
 * Solution to Magical Cows (https://open.kattis.com/problems/magicalcows)
 *
 * <p>Problem author: Graeme Zinck
 *
 * <p>Solution by: William Fiset
 *
 * <p>The main thing to realize with magical cows is that the total number of cows allowed on each
 * farm is bounded by C which is less than or equal to 1000, so you can keep track of all cows in a
 * frequency table for each farm size.
 *
 * <p>NOTE: You can ignore taking the floor/ceiling of the number of cows on a split since when you
 * double the number of cows you always get an even number.
 */

/*
import java.io.*;

public class MagicalCows_ANALYZING {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // The maximum number of days.
    static final int MAX_DAYS = 50;

    public static void main(String[] args) throws IOException {
        String[] line = br.readLine().split(" ");

        // The maximum number of cows on a farm
        final int C = Integer.parseInt(line[0]);

        // The initial number of farms
        final int N = Integer.parseInt(line[1]);

        // The number of queries
        final int M = Integer.parseInt(line[2]);

        // The dp table.
        long[][] dp = new long[MAX_DAYS + 1][C + 1];

        // Count the initial frequency of farms of different sizes
        for (int i = 0; i < N; i++) {
            int cows = Integer.parseInt(br.readLine());
            dp[0][cows]++;
        }

        for (int day = 0; day < MAX_DAYS; day++) {
            // For all farm sizes between 1 and `C`, double the number of cows.
            for (int i = 1; i <= C; i++) {
                if (i <= C / 2) {
                    // Cow count on farm with size `i` doubled, but the number of farms did not.
                    dp[day + 1][i * 2] += dp[day][i];
                } else {
                    // The number of cows per farm on the farm with size `i` exceeds the
                    // permitted limit, so double the number of farms.
                    dp[day + 1][i] += 2 * dp[day][i];
                }
            }
        }

        // Answer each query
        for (int i = 0; i < M; i++) {
            int day = Integer.parseInt(br.readLine());
            System.out.println(query(dp, day));
        }
    }

    // Find the number of farms on a particular day by summing all farms
    // of every frequency for that day.
    private static long query(long[][] dp, int day) {
        long farms = 0;
        long[] frequencies = dp[day];
        for (int i = 0; i < frequencies.length; i++) {
            farms += frequencies[i];
        }
        return farms;
    }
}
*/