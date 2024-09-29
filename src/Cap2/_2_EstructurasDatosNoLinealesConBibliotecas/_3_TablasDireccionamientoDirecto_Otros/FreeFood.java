package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._3_TablasDireccionamientoDirecto_Otros;

// Crear un array de tamaño 365 (días del año)
// Marcor los días en que se sirve fruta gratis para cada evento
// Mostrar el número de días en que se sirve fruta gratis


import java.util.Scanner;

public class FreeFood {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        // Número de obstáculos y creación del array de obstáculos
        int numEventos = scan.nextInt();
        boolean[] calendario = new boolean[366];
        int numDias = 0;
        // Leer los obstáculos encontrados y marcarlos
        for (int i = 0; i < numEventos; i++) {
            int inicio = scan.nextInt();
            int fin = scan.nextInt();
            //Marcar todos los días que dura el evento
            for (int j = inicio; j <= fin; j++) {
                //Cuenta los días que voy marcando
                if (!calendario[j]) {
                    numDias++;
                }
                calendario[j] = true;
            }
        }

        //Mostrar el mensaje final
        System.out.println(numDias);

        scan.close();
    }
}