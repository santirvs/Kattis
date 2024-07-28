package Cap1._1_ParaEmpezar._A_Medios;

import java.util.Locale;
import java.util.Scanner;

public class BitsEqualizer {

   public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       int numCasos = scan.nextInt();
       scan.nextLine();

       for (int caso=1; caso <= numCasos ; caso++) {
           //Leer la secuencia de movimientos
           char[] cadena1 = scan.nextLine().toCharArray();
           char[] cadena2 = scan.nextLine().toCharArray();

           int zeroToOne = 0;
           int oneToZero = 0;
           int questionToZero = 0;
           int questionToOne = 0;


           //Analizar las diferencias entre las dos secuencias
           for(int i = 0; i < cadena1.length; i++) {
               //if(cadena1[i] == '0' && cadena2[i] == '0') a++;
               if(cadena1[i] == '0' && cadena2[i] == '1') zeroToOne++;
               if(cadena1[i] == '1' && cadena2[i] == '0') oneToZero++;
               //if(cadena1[i] == '1' && cadena2[i] == '1') d++;
               if(cadena1[i] == '?' && cadena2[i] == '0') questionToZero++;
               if(cadena1[i] == '?' && cadena2[i] == '1') questionToOne++;
           }

           //Calcular los cambios
           int cambios = 0;
           //Swaps entre dos números: podemos hacer tantos intercambios como el mínimo entre los dos
           cambios = Math.min(zeroToOne,oneToZero);
           zeroToOne -= cambios;
           oneToZero -= cambios;

           //Una vez llegados aquí, al menos uno de los dos es 0 de zeroToOne y oneToZero
           if(zeroToOne > 0) {
               //Si aún quedan zeros por cambiar a uno
               cambios += zeroToOne + questionToZero + questionToOne;
           }
           else {
               if(questionToOne < oneToZero) {
                   //CLAVE DEL ASUNTO!!!
                   //No se pueden hacer cambios de 1 a 0.
                   //Si aún faltan zeros solo se pueden hacer desde ? a 0. Si no tenemos suficientes ? para hacerlo, no se puede hacer el cambio
                   cambios = -1;
               }
               else {
                   //Si aún quedan unos por cambiar a cero
                   cambios += oneToZero+questionToZero+questionToOne;
               }
           }

           System.out.println("Case " + caso + ": " + cambios);

       }


   }

}


/*

#include <bits/stdc++.h>

using namespace std;

int main() {
    int cases;
    cin >> cases;
    for(int casenum = 0; casenum < cases; casenum++) {
        string s1, s2;
        cin >> s1 >> s2;

        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int e = 0;
        int f = 0;

        for(int i = 0; i < s1.size(); i++) {
            if(s1[i] == '0' && s2[i] == '0') a++;
            if(s1[i] == '0' && s2[i] == '1') b++;
            if(s1[i] == '1' && s2[i] == '0') c++;
            if(s1[i] == '1' && s2[i] == '1') d++;
            if(s1[i] == '?' && s2[i] == '0') e++;
            if(s1[i] == '?' && s2[i] == '1') f++;
        }

        int ans = 0;
        ans = min(b,c);
        b -= ans;
        c -= ans;

        if(b > 0) {
            ans += b + e + f;
        }
        else {
            if(f < c) {
                ans = -1;
            }
            else {
                ans += c;
                e -= c;

                ans += c;
                ans += e+f;
            }
        }

        cout << "Case " << casenum+1 << ": " << ans << endl;
    }
}
*/