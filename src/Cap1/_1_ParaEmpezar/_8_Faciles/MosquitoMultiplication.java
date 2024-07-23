package Cap1._1_ParaEmpezar._8_Faciles;

import java.util.Locale;
import java.util.Scanner;

public class MosquitoMultiplication {

   public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Mientras hayan datos
       while (scan.hasNext() ) {
           //Leer los datos de la primera semana
           int mosquitos = scan.nextInt();
           int pupas = scan.nextInt();
           int larvas = scan.nextInt();

           //Leer las tasas de supervivencia

           int huevosPorMosquito = scan.nextInt();
           int tasaSupervivenciaLarvas = scan.nextInt();
           int tasaSupervivenciaPupas= scan.nextInt();

           //Leer el número de semanas
           int semanas = scan.nextInt();

           for (int i=0; i<semanas; i++) {
               //Ciclo de vida de los mosquitos: huevos -> (1:1) larvas -> (*tsL) pupas -> (*tsP) mosquitos -> N huevos
               //Calcular los huevos
               int nuevasLarvas = mosquitos * huevosPorMosquito;
               //Calcular los nuevos mosquitos
               int nuevosMosquitos = pupas / tasaSupervivenciaPupas;
               //Calcular las  nuevas pupas
               int nuevasPupas = larvas / tasaSupervivenciaLarvas;

               larvas = nuevasLarvas;
               pupas=nuevasPupas;
               mosquitos = nuevosMosquitos;
           }

           //Mostrar el resultado
           System.out.println(mosquitos);
       }

    }
}

/*
#include <iostream>

using namespace std;

int main(){
    int m, p, l, e, r, s, n;
    while(cin >> m >> p >> l >> e >> r >> s >> n){
        while(n--){
            int nl = e*m;
            int np = l / r;
            int nm = p / s;
            l = nl;
            p = np;
            m = nm;
        }
        cout << m << endl;
    }
    return 0;
}

 */