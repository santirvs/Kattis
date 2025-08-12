package Cap3._2_BusquedaCompleta._9_SimulacionMatematicaDificiles;


/* Kattis - crackingrsa
  From: https://github.com/BrandonTang89/Competitive_Programming_4_Solutions/blob/main/Chapter_3_Problem_Solving_Paradigms/Complete_Search/kattis_crackingrsa.cpp
This is probably the most basic of rsa type questions.

Observation 1:
    Since n is small enough, we don't need any funny or super smart factorisation algorithm :)
    brute force suffices

Observation 2:
    by bezout's identity, since e and phi are coprime, there exist a, b such that a*e + b*phi = 1
    Taking mod on both sides, a*e = 1 mod phi, not that there a = d, ie we are trying to compute
    the modulo inverse, we can use the extended euclidean algorithm or...

    just brute force since the numbers are small!

Time: O(tc * n), Mem: O(1)
*/

// No he acabado de entender el enunciado... Hay teoría de números primos detrás de esto....
// Resumen:  Dados dos números n y e, encontrar p y q tal que p*q=n
//   y  e tal que (d * e) % phi == 1
//   phi = (p - 1) * (q - 1)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CrackingRSA {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long e = Long.parseLong(st.nextToken());

            long p = 0, q = 0;
            // Factorizar n (búsqueda bruta)
            // Buscar p y q tales que p * q = n son primos y p, q < 1000
            outer:
            for (p = 2; p < 1000; p++) {
                for (q = 2; q < 1000; q++) {
                    if (p * q == n) {
                        break outer;
                    }
                }
            }

            long phi = (p - 1) * (q - 1);

            // Encontrar d tal que (d * e) % phi == 1
            for (long d = 2; d < phi; d++) {
                if ((d * e) % phi == 1) {
                    out.println(d);
                    break;
                }
            }
        }

        out.flush();
    }
}
