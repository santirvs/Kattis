package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._1_ColaDePrioridad


// Usar una primera cola de prioridad para ordenar los renos por año de nacimiento
// Usar una segunda cola de prioridad para ordenar los renos por fuerza
// Sacar de la cola de años los renos que nacieron en el año actual y añadirlos a la cola de fuerza
// Si Karl es el más fuerte, imprimir el año y salir

// Caso #3: WA --> No encuentro el caso de prueba que falla...
//             --> Adapto desde https://github.com/BrandonTang89/Competitive_Programming_4_Solutions/blob/main/Chapter_2_Data_Structures/Non-Linear_DS_with_Built-in_Libraries/kattis_knigsoftheforest.cpp
//             --> El original da AC, pero la adaptación me da RTE en el caso de prueba 3


import java.util.*
import kotlin.collections.ArrayList

class Reno2: Comparable<Reno2> {
    var fuerza: Int = 0
    var anyo: Int = 0

    constructor (fuerza: Int, anyo: Int) {
        this.fuerza = fuerza
        this.anyo = anyo
    }

    override fun compareTo(other: Reno2): Int {
        return this.anyo - other.anyo
    }
}

class RenoFuerza: Comparable<RenoFuerza> {
    var fuerza: Int
    var esKarl: Boolean

    constructor (fuerza: Int, esKarl: Boolean) {
        this.fuerza = fuerza
        this.esKarl = esKarl
    }

    override fun compareTo(other: RenoFuerza): Int {
        return other.fuerza - this.fuerza
    }
}




fun main() {

    val scan = Scanner(System.`in`)

    var n: Int
    var k: Int
    var contenders: ArrayList<Reno2> = arrayListOf<Reno2>()
    var pq: PriorityQueue<RenoFuerza> = PriorityQueue<RenoFuerza>()

    k = scan.nextInt()
    n = scan.nextInt()
    var year = scan.nextInt()
    var strength = scan.nextInt()
    year -= 2011
    var karl: Reno2 = Reno2(strength, year)
    var karl_in: Boolean = false;

    //Si Karl nació en 2011, añadirlo a la cola de fuerza
    if (karl.anyo == 0) {
        pq.add(RenoFuerza(karl.fuerza, true));
        karl_in = true;
    }


    for (i: Int in 0 until (n + k - 2)) {
        year = scan.nextInt()
        strength = scan.nextInt()
        contenders.add(Reno2(strength, year - 2011));
    }
    contenders.sort()

    var index: Int = 0
    while (contenders[index].anyo == 0) {
        pq.add(RenoFuerza(contenders[index].fuerza, false));
        index++;
    }

    var won: Boolean = false;
    for (i: Int in 0 until n) { // year i
        var winner: RenoFuerza = pq.peek()
        pq.poll()

        if (winner.esKarl) {
            println(i + 2011)
            won = true;
            break;
        }

        if (i+1 == karl.anyo && !karl_in){
            pq.add(RenoFuerza(karl.fuerza, true));
            karl_in = true;
        }
        else if (i!=n-1){
            //printf("Pushing moose with strength: %d\n", contenders[index].second);
            pq.add(RenoFuerza(contenders[index].fuerza, false));
            index++;
        }
    }
    if (!won)
        println("unknown")

}




// From: https://github.com/BrandonTang89/Competitive_Programming_4_Solutions/blob/main/Chapter_2_Data_Structures/Non-Linear_DS_with_Built-in_Libraries/kattis_knigsoftheforest.cpp

/* Kattis - Knigsoftheforest
A relatively basic question on the use of priority queue. Just beware of the edge case where karl joins in 2011
and you should be good to go :)

Time: O((n+k) log (n+k)) for the sorting by year, the actual processing is O(n log k) due to n years, log k insert into pq
Mem: O(n+k)
*/

/*
#include <bits/stdc++.h>
using namespace std;

int n, k;
vector<pair<int,int>> contenders; // (year, strength)
priority_queue<pair<int, bool>> pq; // (strength, is karl?)

int main(){
    cin >> k >> n;
    pair<int, int> karl;
    int year, strength;

    cin >> year >> strength;
    year -= 2011;
    karl = make_pair(year, strength);

    bool karl_in = false;
    if (karl.first == 0){
        pq.push(make_pair(karl.second, true));
        karl_in = true;
    }

    for (int i=0;i<(n+k-2);i++){
        cin >> year >> strength;
        contenders.push_back(make_pair(year-2011,strength));
    }
    sort(contenders.begin(), contenders.end());

    int index=0;
    for(;contenders[index].first==0; index++){
        //printf("Pushing moose with strength: %d\n", contenders[index].second);
        pq.push(make_pair(contenders[index].second, false));
    }

    bool won = false;
    for(int i=0;i<n;i++){ // year i
        pair<int,int> winner = pq.top();
        pq.pop();

        if (winner.second){
            cout << i+2011 << endl;
            won = true;
            break;
        }

        //printf("i: %d\n", i);

        if (i+1 == karl.first && !karl_in){
            //printf("Pushing karl\n");
            pq.push(make_pair(karl.second, true));
            karl_in = true;
        }
        else if (i!=n-1){
            //printf("Pushing moose with strength: %d\n", contenders[index].second);
            pq.push(make_pair(contenders[index].second, false));
            index++;
        }
    }
    if (!won)cout << "unknown\n";

    return 0;
}

 */
