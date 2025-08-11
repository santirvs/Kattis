package Cap3._2_BusquedaCompleta._8_SimulacionMatematicaFaciles;

// Búsqueda completa
// La solución es uno de los números de la lista.
// Así que se elige el número N y se comprueba si la suma de los demás coincide con el número elegido.


import java.util.Scanner;

public class SumOfTheOthers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            // Leer la línea de entrada
            String[] datos = scan.nextLine().split(" ");

            for (int i = 0; i < datos.length; i++) {
                int numeroElegido = Integer.parseInt(datos[i]);
                int sumaOtros = 0;

                // Calcular la suma de los demás números
                for (int j = 0; j < datos.length; j++) {
                    if (j != i) {
                        sumaOtros += Integer.parseInt(datos[j]);
                    }
                }

                // Comprobar si la suma de los demás es igual al número elegido
                if (sumaOtros == numeroElegido) {
                    System.out.println(numeroElegido);
                    break;  //Siguiente caso
                }
            }
        }
    }
}


