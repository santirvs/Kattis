package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._1_ColaDePrioridad

// Usar una cola de prioridad (por precio, descendente) para las ventas
// Usar otra cola de prioridad (por precio, ascendente) para las compras
// Mientras haya ventas y compras y el precio de la venta sea menor o igual al de la compra, se van vendiendo


import java.util.*

class Orden: Comparable<Orden> {
    var precio: Int = 0
    var cantidad: Int = 0

    constructor (precio: Int, cantidad: Int) {
        this.cantidad = cantidad
        this.precio = precio
    }

    override fun compareTo(other: Orden): Int {
        return other.precio - this.precio
    }
}

class OrdenCompatorByPrecioDesc {
    companion object : Comparator<Orden> {
        override fun compare(r1: Orden, r2: Orden): Int {
            return r1.precio - r2.precio
        }
    }

}

fun main() {

    val scan = Scanner(System.`in`)

    //Leer el número de casos
    val numCasos = scan.nextInt()

    for (i in 0 until numCasos) {

        //Inicializar caso
        val numOrdenes = scan.nextInt()
        scan.nextLine()

        val pqCompras = PriorityQueue<Orden>()
        val pqVentas = PriorityQueue<Orden>(OrdenCompatorByPrecioDesc)
        var precioUltimaTransaccion : Int? = null

        //Leer las órdenes de cada caso
        for (orden in 0 until numOrdenes) {
            //Leer la orden
            val mandato: List<String> = scan.nextLine().split(" ")
            val operacion = mandato[0]
            val cantidad = mandato[1].toInt()
            val precio = mandato[4].toInt()

            //Añadir la orden a la lista correspondiente
            if (operacion == "buy") {
                pqCompras.add(Orden(precio, cantidad))
            } else {
                pqVentas.add(Orden(precio, cantidad))
            }

            //Mirar si se puede establecer una transacción
            while (pqCompras.isNotEmpty() && pqVentas.isNotEmpty() && pqVentas.peek().precio <= pqCompras.peek().precio) {
                val compra = pqCompras.poll()
                val venta = pqVentas.poll()
                val cantidadTransaccion = Math.min(compra.cantidad, venta.cantidad)
                compra.cantidad -= cantidadTransaccion
                venta.cantidad -= cantidadTransaccion
                precioUltimaTransaccion = venta.precio
                if (compra.cantidad > 0) {
                    pqCompras.add(compra)
                }
                if (venta.cantidad > 0) {
                    pqVentas.add(venta)
                }
            }

            //Imprimir los precios
            if (pqVentas.isEmpty()) {
                print("-")
            } else {
                print(pqVentas.peek().precio)
            }
            print(" ")
            if (pqCompras.isEmpty()) {
                print("-")
            } else {
                print(pqCompras.peek().precio)
            }
            print(" ")
            if (precioUltimaTransaccion == null) {
                println("-")
            } else {
                println(precioUltimaTransaccion)

            }


        }

    }
}

