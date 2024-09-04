package Cap2._1_EstructurasDatosConBibliotecas._7_Ordenacion_Especiales;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/*
 Al hacer los casos de prueba, se puede observar que el mínimo de A y el máximo de B son los que suman el valor más pequeño
 pero no pasa el caso #3 --> WA

 Adaptando el código de C++

 */


public class Mali {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numCasos = scan.nextInt();
        int minA = Integer.MAX_VALUE;
        int maxB = Integer.MIN_VALUE;

        while (numCasos > 0) {
            //Lectura de los datos del caso
            int a = scan.nextInt();
            int b = scan.nextInt();
            minA = Math.min(minA, a);
            maxB = Math.max(maxB, b);
            numCasos--;
            //Mostrar el resultado
            System.out.println(minA+maxB);
        }

    }
}


/*
/*
Kattis - Mali

Observation 1:
    the most optimal pairing is repeatedly greedily pairing the smallest of A with the largest of B.

    proof:
        From any pairing, we attempt to re-pair b[n] (largest b) with a[0] (currently paired with b[j]):
            (a[0], b[j]) (a[i], b[n]) --> (a[0], b[n]) (a[i],b[j])
            if (a[i], b[n]) is the max pairing:
                re-pairing will not increase the max since
                    b[n] + a[0] <= b[n]+a[i] because i>0
                    a[i]+b[j] <= b[n]+a[i] because n>j

            else if (a[i], b[n]) is not the max pairing:
                re-pairing will not increase the max since
                    the max pair involves an a[k], k>i since the max must be greater than (a[i], b[n]) and all other b values are less than b[n]
                        thus k != 0
                    let the max pair be (a[k], b[l])
                    b[n]+a[0] <= b[n] + a[i] < a[k] + b[l] ; former because i > 0, latter because of assumption that initial pairing not max pair
                    a[i]+b[j] <=b[n]+a[i]  < a[k] + b[l] former because n>j, latter because of assumption that initial pairing not max pair

        Thus, we can safely make the pair (a[0], b[n]) and include them from our consideration,leaving us with n-1 a[i]s and b[i]s each.
        Repeating the above logic n times proves the theorem


    Design 1:
        use a frequency arr instead of just an array of A and B as the range of values is [1,100], which is extremely small
        this frequency array can also be used to do the matching (see details below)

Time: O(n * 100) = O(n), Mem: O(n)
*/
/*
#include <bits/stdc++.h>
using namespace std;

int n;
int f_a[101], f_b[101]; // f_a[i] is the number of is in a

int compute_max_sum(int num){
    int freq_a[101], freq_b[101];
    for (int i=1;i<=100;i++){
        freq_a[i] = f_a[i];
        freq_b[i] = f_b[i];
    }
    int index_a = 1, index_b = 100;
    int counter=0;
    int max_sum = 0;
    while(counter<num){
        while(freq_b[index_b] == 0){
            index_b--;
        }
        while (freq_a[index_a] == 0){
            index_a++;
        }
        int match_num = min(freq_a[index_a], freq_b[index_b]);

        freq_b[index_b] -= match_num;
        freq_a[index_a] -= match_num;

        max_sum = max(max_sum, index_b+index_a);
        counter += match_num;
    }

    return max_sum;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin>>n;
    for (int r=1;r<=n;r++){
        int a_c, b_c;
        cin >> a_c >> b_c;
        f_a[a_c]++;
        f_b[b_c]++;

        cout << compute_max_sum(r) << endl;
    }

    return 0;
}
 */