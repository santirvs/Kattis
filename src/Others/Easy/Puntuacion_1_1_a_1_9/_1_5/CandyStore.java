package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer la cantidad de clientes y la cantidad de formularios
// Leer el nombre de los clientes y guardar sus iniciales en un HashMap<String, String> con el nombre del propio cliente o "ambiguous" si ya existe otro cliente con las mismas iniciales
// Leer las iniciales y decidir a cuantos clientes pueden pertenecer
// Si es 1 imprimir el nombre del cliente
// Si es más de 1 impimir "ambiguous"
// Si es 0 imprimir "nobody


import java.util.Locale;
import java.util.Scanner;


public class CandyStore {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        // Leer la cantidad de clientes y formularios
        int numClientes = sc.nextInt();
        int numFormularios = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea pendiente

        //Declarar el HashMap
        java.util.HashMap<String, String> inicialesMap = new java.util.HashMap<>();

        // Leer los nombres de los clientes y guardar sus iniciales
        for (int i = 0; i < numClientes; i++) {
            String nombreCliente = sc.nextLine();
            String[] partesNombre = nombreCliente.split(" ");
            String iniciales = "";
            for (String parte : partesNombre) {
                iniciales += parte.charAt(0);
            }
            if (inicialesMap.containsKey(iniciales)) {
                inicialesMap.put(iniciales, "ambiguous");
            } else {
                inicialesMap.put(iniciales, nombreCliente);
            }
        }

        // Leer las iniciales y decidir a cuantos clientes pueden pertenecer
        for (int i = 0; i < numFormularios; i++) {
            String inicialesFormulario = sc.nextLine();
            if (inicialesMap.containsKey(inicialesFormulario)) {
                System.out.println(inicialesMap.get(inicialesFormulario));
            } else {
                System.out.println("nobody");
            }
        }

        sc.close();
    }
}

