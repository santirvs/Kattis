package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._3_TablasDireccionamientoDirecto_Otros;

// Crear un array de obstaculos de tamaño N
// Marcor los obstáculos que se encuentran en la lista de obstáculos
// Mostrar el número de obstáculos que no se encuentran en la lista de obstáculos

// Caso 2: WA! - Es posible diga que ha encontrado algún obstáculo de manera repetida!


import java.util.Scanner;

public class SavePrincessPeach {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        // Número de obstáculos y creación del array de obstáculos
        int numObstaculos= scan.nextInt();
        boolean[] obstaculos = new boolean[numObstaculos];
        int numObstaculosEncontrados = scan.nextInt();

        // Leer los obstáculos encontrados y marcarlos
        for (int i = 0; i < numObstaculosEncontrados; i++) {
            obstaculos[scan.nextInt()] = true;
        }

        // Mostrar los obstáculos no encontrados
        numObstaculosEncontrados = 0;  //Reset del número de obstáculos encontrados. Puede que diga algun obstáculo más de una vez
        for (int i=0; i < numObstaculos; i++) {
            if (!obstaculos[i]) {
                System.out.println(i);
            }
            else {
                //Cuenta los obstáculos efectivamente encontrados
                numObstaculosEncontrados++;
            }
        }
        //Mostrar el mensaje final
        System.out.println("Mario got " + (numObstaculosEncontrados) + " of the dangerous obstacles.");

        scan.close();
    }
}