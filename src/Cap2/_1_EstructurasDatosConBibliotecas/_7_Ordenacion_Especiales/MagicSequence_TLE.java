package Cap2._1_EstructurasDatosConBibliotecas._7_Ordenacion_Especiales;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/*
    Este caso es ideal para realizar una ordenación radix, dado que los elementos son enteros en un rango limitado C.

    En primer lugar hay que calcular la secuencia O(n)
    A continuación debe ordenarse. El algoritmo que se use determinará el coste de la ordenación.
    Finalmente, a partir de la secuencia ordenada, se calcular el valor de hash O(n)

    Empezaremos usando el algoritmo de ordenación quicksort, que tiene un coste O(n log n) en el peor caso.
    Grupo1: AC
    Grupo2: WA  en Test #5,6 y 7 --> S[i-1] * B cuando S y B pueden ser hasta 10^6 daría 10^12.
            Cambiado por long -->
    Grupo3: TLE en Test #8, con N >= 10^5 el coste de quicksort es O(n log n) y no es suficiente.
            Cambiado por radix sort  O(d*(n+k)) donde d es el número de dígitos de los números y k es la base del sistema numérico.
            Sigue dando TLE en Test #8. Aumento la base de 10 a 1000.
            No consigo que pase el Test #8. Envío el código del final
            He intentado pasarlo a Java sin éxito. Envío el código de Java
 */

public class MagicSequence_TLE {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numCasos = scan.nextInt();

        while (numCasos > 0) {
            //Lectura de los datos del caso
            int n = scan.nextInt();
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            int x = scan.nextInt();
            int y = scan.nextInt();

            //Generar la secuencia
            ArrayList<Long> secuencia = new ArrayList<>();
            long sAnt = a;
            long max = a;
            secuencia.add(sAnt);
            for (int i = 1; i < n; i++) {
                long s = (sAnt * b + a) % c;
                secuencia.add(s);
                sAnt = s;
                max = Math.max(max,s);
            }

            //Ordenar la secuencia
            //secuencia.sort(null);

            //Ordenar la secuencia mediante radix sort
            int numDigitos = (int) Math.floor(Math.log10(max)) + 1;
            for (int i = 0; i < numDigitos; i++) {
                //Counting sort
                //Contar las frecuencias de cada dígito
                int[] frecuencia = new int[10];
                for (int j = 0; j < secuencia.size(); j++) {
                    frecuencia[(int) (secuencia.get(j) / Math.pow(10, i)) % 10]++;
                }
                //Suma de prefijos de frecuencias
                for (int j = 1; j < frecuencia.length; j++) {
                    frecuencia[j] += frecuencia[j - 1];
                }
                //Recorrer la secuencia en orden inverso
                //establecer A[i] en la posición correcta indicada por frecuencia[A[i]]
                ArrayList<Long> secuenciaOrdenada = new ArrayList<>(secuencia);
                for (int j = secuencia.size() - 1; j >= 0; j--) {
                    int index = (int) (secuencia.get(j) / Math.pow(10, i)) % 10;
                    frecuencia[index]--;
                    secuenciaOrdenada.set(frecuencia[index], secuencia.get(j));
                }
                secuencia = secuenciaOrdenada;
            }


            //Calcular el valor de hash
            long hash = 0;
            for (int i = 0; i < n; i++) {
                hash = (hash*x+secuencia.get(i))%y;
            }

            //Imprimir el resultado
            System.out.println(hash);

            numCasos--;
        }

    }
}

/*

/* Kattis - Magic Sequence
//https://github.com/BrandonTang89/Competitive_Programming_4_Solutions/blob/main/Chapter_2_Data_Structures/Linear_DS_with_Built-in_Libraries/kattis_magic_sequence.cpp


This is a hard problem (at least to me).
Abridged problem statement: Generate a sequence of whole numbers using the rules S[0] = A, S[i] = (S[i-1]*b + a)%c. Sort the sequence and compute a hash value

Observation 1:
    Since n <= 1000000, a good (best) O(n log n) comparison based sorting algorithm will exceed the time limit.. thus we need to do a fancy O(n) sort
    As S[i] <= 1e9, the O(n+k) counting sort will perform even worse, thus we need to use the O(d(n+b)) radix sort.

Observation 2:
    As the S[i]s are relatively large, doing a base 10 radix sort is suboptimal and will result in a TLE verdict. By increasing the radix (base),
    we can reduce the number of digits used to represent S[i], thus resulting in lesser instances of counting sort being used. However.
    this comes at the cost of an increase in the time per counting sort

Observation 3:
    instead of convering each S[i] to a different base which is stored in a vector (or other container) which would result in a large amount of overhead
    from the conversion to the custom base and then back again to base 10, we can just use the expression "S[i]/(base**j)) % base" to get the jth digit
    where the least significant digit is the 0th digit.

Observation 4:
    to compute the expression S[i]/(base**j)) % base, the power and modulo operations are quite expensive (relatively speaking). While one might think to
    precompute base**j in O(base) time, it again creates some expensive non-critical code. The trick now is to select a base with is a power of 2, allowing
    the use of bitwise operations which have much faster execution time, getting rid of the power and modulo.

"Observation" 5:
    When choosing what base to choose, honestly I just tried different powers of 2 to see what went the fastest...
    Thinking logically, time complexity is O((n+b)/ln(b)), but various factors will affect the actual run time
    according to some internet people, selecting too high of a b (such as one that minimises (n+b)/ln(b)) will result in poor cacheing performance
    thus the best strat I found thus far is to try several different powers of 2 and attempt to find one that will AC the task

Futher optimisations:
    Avoiding the use of functions to reduce function overhead
    using the emplace_back method instead of push_back to avoid constuction of a temporary object
    Unsync IO for faster cin/cout (not too important tho)

Debugging:
    As R[i]*x in the hash function and S[i-1]*b in the generating function are computed, make use of long long where necessary (or where unsure)

Time: O((n+b)/ln(b)) Mem: O(n+b)
*/

/*
#include <bits/stdc++.h>
using namespace std;

long long n, a, b, c, x, y;
long long base, base_log2;
long long arr[1000009];
vector<long long>ve[1<<10]; //frequency arr for count sort, ve[i] contains the elements with i in the specific digit position

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;
    for (int tc=0;tc<T;tc++){
        cin >> n >> a >> b >> c >> x >> y;

        // Generate sequence
        long long max_val = a;
        arr[0] = a;
        for (long long i=1;i<n;i++){
            arr[i] = ((arr[i-1]*b)%c + a)%c;
            max_val = max(max_val, arr[i]);
        }

        // Select Custom Base (remember to adjust the frequency arr size if increasing base)
        base_log2 = 10;
        long long base = 1<<base_log2;
        long long max_d = (long long)((log(max_val))/(log(base)) + 1.5);

        // Radix sort in a custom base
        for (long long digit=0; digit<max_d; digit++){
            //Counting sort arr based on pos of digit in a custom base
            for (int i=0;i<n;i++){
                ve[(arr[i]>>(digit*base_log2))&(base-1)].emplace_back(arr[i]); // doing ve[(arr[i]/(base**digit)) % base] but more efficient
            }
            long long index = 0;
            for (int j=0; j<base;j++){
                for(auto i: ve[j]){
                    arr[index] = i;
                    index++;
                }
                ve[j].clear();
            }
        }

        // Compute Hash
        long long V = 0;
        for (int i=0;i<n;i++){
            V = ((long long)(V*x)+ arr[i])%y ;
        }
        cout << V << endl;
    }
    return 0;
}
 */