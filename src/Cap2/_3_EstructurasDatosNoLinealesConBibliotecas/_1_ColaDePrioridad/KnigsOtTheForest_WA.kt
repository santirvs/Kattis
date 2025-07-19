package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._1_ColaDePrioridad


// Usar una primera cola de prioridad para ordenar los renos por año de nacimiento
// Usar una segunda cola de prioridad para ordenar los renos por fuerza
// Sacar de la cola de años los renos que nacieron en el año actual y añadirlos a la cola de fuerza
// Si Karl es el más fuerte, imprimir el año y salir

// Caso #3: WA --> No encuentro el caso de prueba que falla...
//             --> Adapto desde https://github.com/BrandonTang89/Competitive_Programming_4_Solutions/blob/main/Chapter_2_Data_Structures/Non-Linear_DS_with_Built-in_Libraries/kattis_knigsoftheforest.cpp


import java.util.*
import kotlin.math.max

class Reno: Comparable<Reno> {
    var fuerza: Int = 0
    var anyo: Int = 0

    constructor (fuerza: Int, anyo: Int) {
        this.fuerza = fuerza
        this.anyo = anyo
    }

    override fun compareTo(other: Reno): Int {
        return this.anyo - other.anyo
    }
}

class RenoComparatorByFuerza {
    companion object : Comparator<Reno> {
        override fun compare(r1: Reno, r2: Reno): Int {
            return r2.fuerza - r1.fuerza
        }
    }

}

fun main() {

    val scan = Scanner(System.`in`)

    val k = scan.nextInt()
    val n = scan.nextInt()

    val pqAnyo = PriorityQueue<Reno>()
    val pqFuerza = PriorityQueue<Reno>(RenoComparatorByFuerza)

    //Leer los datos de Karl y añadirlo a la cola de años
    val anyoKarl = scan.nextInt()
    val fuerzKarl = scan.nextInt()
    val karl = Reno(fuerzKarl, anyoKarl)
    pqAnyo.add(karl)
    var maxAnyo : Int = 2011

    //Leer los datos de los renos y crearlos
    for (i in 0 until (n+k-2)) {
        val anyo = scan.nextInt()
        val fuerza = scan.nextInt()
        val r = Reno(fuerza, anyo)
        pqAnyo.add(r)
        maxAnyo = max(maxAnyo, anyo)
    }

    //Primer anyo
    var anyo = 2011
    var encontrado = false
    while (!encontrado && anyo <= maxAnyo) {
        //Sacar de la cola de años los renos que nacieron en el año actual
        while (pqAnyo.isNotEmpty() && pqAnyo.peek().anyo == anyo) {
            pqFuerza.add(pqAnyo.poll())
        }

        //Si Karl es el más fuerte
        if (pqFuerza.isNotEmpty() && pqFuerza.peek().fuerza == karl.fuerza) {
            println(anyo)
            encontrado = true
        }
        else { //Sacar al reno más fuerte
            pqFuerza.poll()
        }

        //Siguiente año
        anyo++
    }

    //Si he recorrido todos los años y no he encontrado a Karl
    if (!encontrado) {
        println("unknown")
    }

}

