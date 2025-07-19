package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._1_ColaDePrioridad

// Usar una lista para las llegadas y otra para las salidas
//Llevar un contador de las personas que habría en el bar en cada momento que entre una persona
// y hasta el momento en el que marcharíamos


import java.util.*
import kotlin.math.max


fun main() {

    val scan = Scanner(System.`in`)

    //Leer el número de casos
    val numEntradas = scan.nextInt()
    val tiempoMaximo = scan.nextInt()


    //Definir las listas de llegadas y salidas
    val llegadas = mutableListOf<Int>()
    val salidas = mutableListOf<Int>()

    //Leer las entradas

    for (i in 0 until numEntradas) {

        //Leer el momento de llegada y añadirlo a la cola
        val tiempoLlegada = scan.nextInt()
        llegadas.add(tiempoLlegada)

        //Leer el momento de salida y añadirlo a la cola
        val tiempoSalida = scan.nextInt()
        salidas.add(tiempoSalida)

      }

    //Ordenar las llegadas y las salidas
    llegadas.sort()
    salidas.sort()

    //Inicializar el número de personas en el bar
    var numPersonas = 0
    var maxAmigos = 0
    var tiempo = 0
    var indexSalidas = 0
    var indexEntradas = 0
    while  (indexEntradas < numEntradas) {
        tiempo = llegadas[indexEntradas]
        numPersonas++
        indexEntradas++
        //Varias personas pueden llegar al mismo tiempo
        while (indexEntradas < numEntradas && llegadas[indexEntradas] == tiempo) {
            numPersonas++
            indexEntradas++
        }
        //Elimina las personas que hayan podido salir antes de la entrada
        while (indexSalidas < numEntradas && salidas[indexSalidas] < (tiempo-tiempoMaximo)) {
            numPersonas--
            indexSalidas++
        }
        //Actualizar el máximo de amigos
        maxAmigos = max(maxAmigos, numPersonas)

    }

    //Imprimir el resultado
    print(maxAmigos)
}

