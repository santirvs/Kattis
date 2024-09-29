package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._3_TablasDireccionamientoDirecto_Otros;

// Crear un array de habitaciones de tamaño N
// Marcar las habitaciones ya reservadas
// Buscar la primera habitación no reservada



import java.util.Scanner;

public class BookingARoom {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        // Número de habitaciones y creación del array de habitaciones
        int numHabitaciones = scan.nextInt();
        boolean[] habitaciones = new boolean[numHabitaciones+1];  // Se numeran de 1 a N
        int numReservadas = scan.nextInt();

        // Leer las habitaciones encontradas y marcarlos
        for (int i = 0; i < numReservadas; i++) {
            habitaciones[scan.nextInt()] = true;
        }

        // Buscar la primera habitación libre
        boolean encontrado = false;
        for (int i = 1; i <= numHabitaciones && !encontrado; i++) {
            if (!habitaciones[i]) {
                System.out.println(i);
                encontrado = true;
            }
        }

        // Si no se ha encontrado ninguna habitación libre
        if (!encontrado) {
            System.out.println("too late");
        }

        scan.close();
    }
}