package Cap3._2_BusquedaCompleta._9_SimulacionMatematicaDificiles;

// Buscar por fuerza bruta
// Leer los datos de cada cortacésped y determinar si es posible cortar el césped una vez por semana
// Si lo es, quedarnos con el de menor importe
// Si están empatados, mostrarlos todos en el mismo orden de entrada

// v1. WA en Caso#5
// v2. Se busca el promedio de los cortes, por lo que la cantidad de ciclos a calcular no es un entero sino un double
//     y ya no es necesario calcular el tiempo restante de corte del último ciclo incompleto.

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseLawn {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        final int MINUTOS_POR_SEMANA = 10_080; // 7 días * 24 horas * 60 minutos

        // Leer la superficie del césped
        int superficie = scan.nextInt();
        // Leer el número de cortacéspedes
        int n = scan.nextInt();
        scan.nextLine();

        //Lista para almacenar los cortacéspedes y el precio del menor
        List<String> cortacespedes = new ArrayList<>();
        int precioMenor = Integer.MAX_VALUE;

        // Leer los datos de cada cortacésped
        for (int i = 0; i < n; i++) {
            String[] linea = scan.nextLine().split(",");
            String nombre = linea[0];
            int precio = Integer.parseInt(linea[1]);
            int velocidadCorte = Integer.parseInt(linea[2]);
            int tiempoCorte = Integer.parseInt(linea[3]);
            int tiempoRecarga = Integer.parseInt(linea[4]);

            // Calcular el tiempo de un ciclo completo de corte y recarga
            int tiempoCiclo = tiempoCorte + tiempoRecarga;
            // Calcular cuantos ciclos hay en una semana
            double ciclosPorSemana = (double)MINUTOS_POR_SEMANA / tiempoCiclo;

            // Calcular el área que se puede cortar en una semana
            double areaCortada = (ciclosPorSemana * velocidadCorte * tiempoCorte);

            // Si el área cortada es mayor o igual a la superficie, es posible cortar el césped en una semana
            if (areaCortada >= superficie) {
                // Si el precio es igual al menor, se añade a la lista
                if (precio == precioMenor) {
                    cortacespedes.add(nombre);
                }
                else if (precio < precioMenor) {
                    // Si el precio es menor, se actualiza la lista y el precio menor
                    cortacespedes.clear();
                    cortacespedes.add(nombre);
                    precioMenor = precio;
                }
            }
        }

        //Mostrar los cortacéspedes que cumplen las condiciones
        if (cortacespedes.isEmpty()) {
            System.out.println("no such mower");
        }
        else {
            for (String cortacesped : cortacespedes) {
                System.out.println(cortacesped);
            }
        }

    }
}


