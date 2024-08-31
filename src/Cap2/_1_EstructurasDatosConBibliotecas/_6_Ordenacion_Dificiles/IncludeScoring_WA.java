package Cap2._1_EstructurasDatosConBibliotecas._6_Ordenacion_Dificiles;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class IncludeScoring_WA {

    static int[] puntos = { 100 ,75, 60, 50, 45, 40, 36, 32, 29, 26, 24, 22, 20, 18, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    public static int calcularPuntos(int posicion) {
        if (posicion < 30) {
            return puntos[posicion];
        } else {
            return 0;
        }
    }

    public static class Participante implements Comparable<Participante> {
        int numACs;
        int tiempoTotal;
        int ultimoAC;
        int posicionOriginal;
        int puntos;

        public Participante(int problemasAC, int tiempoTotal, int ultimoAC, int online, int posicion) {
            this.numACs = problemasAC;
            this.tiempoTotal = tiempoTotal;
            this.ultimoAC = ultimoAC;
            this.posicionOriginal = posicion;
            this.puntos = online;
        }

        @Override
        public int compareTo(Participante o) {
            //Primer criterio: mayor numACs
            if (this.numACs  == o.numACs) {
                //Segundo criterio: menor tiempoTotal
                if (this.tiempoTotal == o.tiempoTotal) {
                    //Tercer criterio: ultimoAC más temprano
                    return this.ultimoAC - o.ultimoAC;
                }
                else {
                    return this.tiempoTotal - o.tiempoTotal;
                }
            } else {
                return o.numACs - this.numACs;
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Participante) {
                Participante p = (Participante) obj;
                return this.numACs == p.numACs && this.tiempoTotal == p.tiempoTotal && this.ultimoAC == p.ultimoAC;
            } else {
                return false;
            }
        }
    }


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Datos del problema
        int numParticipantes = scan.nextInt();
        Participante[] listaParticipantes = new Participante[numParticipantes];

        //Leer los datos de los participantes
        for (int i = 0; i < numParticipantes; i++) {
            int numACs = scan.nextInt();
            int tiempoTotal = scan.nextInt();
            int ultimoAC = scan.nextInt();
            int online = scan.nextInt();

            Participante p = new Participante(numACs, tiempoTotal, ultimoAC, online, i);
            listaParticipantes[i] = p;
        }

        //Ordenar los participantes
        Arrays.sort(listaParticipantes);

        //Calcular los puntos
        for (int i=0; i<numParticipantes; i++) {
            int puntosEmpates = calcularPuntos(i);
            int numEmpatados = 1;
            while (i<numParticipantes-1 && listaParticipantes[i].equals(listaParticipantes[i+1])) {
                puntosEmpates += calcularPuntos(i+1);
                numEmpatados++;
                i++;
            }
            int puntosIndividuales = puntosEmpates / numEmpatados + ((puntosEmpates/numEmpatados)%numEmpatados != 0 ? 1 : 0);
            for (int j=i-numEmpatados+1; j<=i; j++) {
                listaParticipantes[j].puntos += puntosIndividuales;
            }
        }

        //Reordenar los participantes segun su posicion original
        Arrays.sort(listaParticipantes, (a, b) -> a.posicionOriginal - b.posicionOriginal);

        //Mostrar el resultado
        for (Participante p : listaParticipantes) {
            System.out.println(p.puntos);
        }


    }
}



/*
--- From: https://github.com/BrandonTang89/Competitive_Programming_4_Solutions/blob/main/Chapter_2_Data_Structures/Linear_DS_with_Built-in_Libraries/kattis_includesorting.hs
-- Kattis - includesorting
-- The n^2 solution here works fine enough. It is a trap to use deriving Eq since we should not match on the last number.
-- Everything else is quite standard.
main :: IO()
main = interact (unlines . map show . solve . map (map read . words) . tail . lines)

data Con = Con Int Int Int Int

instance Eq Con where
    (Con sx tx lx _) == (Con sy ty ly _) = (sx, -tx, -lx) == (sy, -ty, -ly) -- x == y if x does as well as y
instance Ord Con where
    (Con sx tx lx _) <= (Con sy ty ly _) = (sx, -tx, -lx) <= (sy, -ty, -ly) -- x <= y if x does worse (at least as bad) than y

solve :: [[Int]] -> [Int]
solve xs = let cs = [Con s t l i | [s, t, l, i] <- xs]
               getScore (Con s t l i) = i + getPts (length (filter (> (Con s t l i)) cs)) (length (filter (== (Con s t l i)) cs))
               in map getScore cs

getPts :: Int -> Int -> Int
getPts r nr = ((sum [tab (r + 1 + i) | i <- [0..nr-1]] - 1) `div` nr) + 1

tab :: Int -> Int
tab 0 = error "tab 0"
tab 1 = 100
tab 2 = 75
tab 3 = 60
tab 4 = 50
tab 5 = 45
tab 6 = 40
tab 7 = 36
tab 8 = 32
tab 9 = 29
tab 10 = 26
tab 11 = 24
tab 12 = 22
tab 13 = 20
tab 14 = 18
tab 15 = 16
tab 16 = 15
tab 17 = 14
tab 18 = 13
tab 19 = 12
tab 20 = 11
tab 21 = 10
tab 22 = 9
tab 23 = 8
tab 24 = 7
tab 25 = 6
tab 26 = 5
tab 27 = 4
tab 28 = 3
tab 29 = 2
tab 30 = 1
tab _ = 0
 */