package Cap2._1_EstructurasDatosConBibliotecas._11_Pila_Especiales;

import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;
import Utils.Kattio;

// Bungee Builder
// Adaptado de https://github.com/BrandonTang89/Competitive_Programming_4_Solutions/blob/main/Chapter_2_Data_Structures/Linear_DS_with_Built-in_Libraries/kattis_bungeebuilder.cpp
//
// Se trata de buscar la montaña más alta y a partir de ella, buscar la mayor distancia que se puede saltar


// Caso#38:TLE  --> Uso Kattis  -> AC

public class BungeeBuilder {

    static class Pair{
        int first;
        int second;
        Pair(int f, int s){
            first = f;
            second = s;
        }
    }

    static Stack<Pair> s = new Stack<>();
    static int[] arr = new int[1000009];
    static int n, max_h, max_h_pos;
    static int max_jump=0;

    public static void process_mountain(int m){ // process the mountain at pos m
        //printf("m:%d\n", m);

        int max_j_at_m = 0;
        while (arr[m] >= s.peek().first){
            max_j_at_m = Math.max(arr[m] - s.peek().first + s.peek().second,max_j_at_m);
            //printf("Popping: %d %d\n", s.top().first, s.top().second);
            s.pop();

            if (s.empty())break;

        }
        s.push(new Pair(arr[m], max_j_at_m));
        //printf("Pushing: %d %d\n", arr[m], max_j_at_m);

        max_jump = Math.max(max_jump, max_j_at_m);
    }

    public static <Kattis> void main(String[] args) {
        //Scanner scan = new Scanner(System.in);
        //scan.useLocale(Locale.ENGLISH);

        Kattio scan = new Kattio(System.in);

        n = scan.getInt();
        arr[0] = scan.getInt();
        max_h = arr[0];
        max_h_pos = 0;

        for (int i = 1; i < n; i++) {
            arr[i] = scan.getInt();
            if (arr[i] > max_h) {
                max_h_pos = i;
                max_h = arr[i];
            }
        }

        //printf("max height pos: %d, max height: %d\n", max_h_pos, max_h);
        // Go from max height mountain towards the left
        s.push(new Pair(max_h, 0));
        for (int i = max_h_pos - 1; i >= 0; i--) {

            process_mountain(i);
        }
        while (!s.empty()) s.pop();
        s.push(new Pair(max_h, 0));
        for (int i = max_h_pos + 1; i < n; i++) {
            process_mountain(i);
        }

        System.out.println(max_jump);

    }



}
