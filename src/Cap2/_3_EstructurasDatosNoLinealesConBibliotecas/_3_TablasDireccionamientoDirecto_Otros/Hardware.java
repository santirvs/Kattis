package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._3_TablasDireccionamientoDirecto_Otros;

// Para cada caso, crear una tabla DAT de tamaño 10 y marcar los dígitos que se encuentran
// para cada lista.
// Mostrar el número de dígitos que no se encuentran en la lista de dígitos


import java.util.Scanner;

public class Hardware {

    public static void marcarDigitos(int[] digitos, int numero) {
        while (numero > 0) {
            digitos[numero % 10]++;
            numero /= 10;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        // Número de obstáculos y creación del array de obstáculos
        int numOrdenes = scan.nextInt();
        scan.nextLine();

        // Para cada caso
        for (int i = 0; i < numOrdenes; i++) {
            //Crear la tabla DAT
            int[] digitos = new int[10];

            //Leer y escribir la calle y el número de órdenes
            System.out.println(scan.nextLine());
            int numDirecciones = scan.nextInt();
            System.out.println(numDirecciones + scan.nextLine());

            while (numDirecciones > 0) {
                //Leer la dirección
                String orden = scan.nextLine();

                //Mirar el tipo de orden
                if (orden.charAt(0) == '+') {
                    String[] partes = orden.split(" ");
                    int inicio = Integer.parseInt(partes[1]);
                    int fin = Integer.parseInt(partes[2]);
                    int intervalo = Integer.parseInt(partes[3]);
                    for(int j = inicio; j <= fin; j += intervalo) {
                        marcarDigitos(digitos, j);
                        numDirecciones--;
                    }
                }
                else {
                    marcarDigitos(digitos, Integer.parseInt(orden));
                    numDirecciones--;
                }
            }

            int totalDigitos = 0;
            // Mostrar los dígitos utilizados
            for (int j = 0; j <10; j++) {
                System.out.println("Make " + digitos[j] + " digit " + j);
                totalDigitos += digitos[j];
            }

            //Mostrar el mensaje final
            if (totalDigitos == 1) {
                System.out.println("In total 1 digit");
            }
            else
                System.out.println("In total " + totalDigitos + " digits");

        }


        scan.close();
    }
}