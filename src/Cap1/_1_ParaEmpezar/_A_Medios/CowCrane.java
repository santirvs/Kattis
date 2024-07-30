package Cap1._1_ParaEmpezar._A_Medios;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class CowCrane {

    public static int dist(int a, int b){
        return Math.abs(a-b);
    }

    public static String solve(int m, int l, int M, int L, int tm, int tl) {

        String res = "impossible";

        // Enumerar los trayectos válidos
        // e.g. start -> m -> M -> l -> L
        //      start -> m -> l -> L -> l -> M
        //      start -> l -> L -> m -> M
        //      start -> l -> m -> M -> m -> L
        int s = 0;
        if(dist(s,m)+dist(m,M) <= tm && dist(s,m)+dist(m,M)+dist(M,l)+dist(l,L) <= tl){
            res= "possible";
        }

        if(dist(s,l)+dist(l,L) <= tl && dist(s,l)+dist(l,L)+dist(L,m)+dist(m,M) <= tm){
            res= "possible";
        }

        if(dist(s,m)+dist(m,l)+dist(l,L) <= tl && dist(s,m)+dist(m,l)+dist(l,L)+dist(L,l)+dist(l,M) <= tm){
            res= "possible";
        }

        if(dist(s,l)+dist(l,m)+dist(m,M) <= tm && dist(s,l)+dist(l,m)+dist(m,M)+dist(M,m)+dist(m,L) <= tl){
            res= "possible";
        }

        return res;


    }


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Posicion inicial de la grua y tiempo empleado
        int posGrua = 0;
        int tiempo = 0;

        //Lectura de los datos del caso
        //Posicion inicial de cada vaca
        int posM = scan.nextInt();
        int posL = scan.nextInt();

        //Posicion final de cada vaca
        int posMF = scan.nextInt();
        int posLF = scan.nextInt();

        //Tiempo en que debe comer cada vaca
        int tM = scan.nextInt();
        int tL = scan.nextInt();

        //Impresion del resultado
        String resultado = solve(posM, posL, posMF, posLF, tM, tL);
        System.out.println(resultado);
    }
}



