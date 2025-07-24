package Cap3._2_BusquedaCompleta._2_Iterativos_2BuclesAnidados;

// Bucles anidados para incrementar el contador

import java.util.Scanner;

public class PrimaryRegister {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] registros = new int[8];
        int[] limites = {2, 3, 5, 7, 11, 13, 17, 19}; // Limites para cada registro

        // Leer los registros iniciales
        for (int i = 0; i < registros.length; i++) {
            registros[i] = scan.nextInt();
        }

        // Simular el incremento hasta desbordar los limites
        boolean desbordado = false;
        int contador = 0;
        while (!desbordado) {
            for (int i = 0; i < registros.length; i++) {
                registros[i]++; // Incrementar el registro actual

                // Si el registro actual se ha desbordado, reiniciarlo a 0 y seguir con el bucle
                if (registros[i] == limites[i]) {
                    registros[i] = 0;
                    if (i==registros.length - 1) {
                        desbordado = true; // Si es el último registro, se ha desbordado
                    }
                    continue;
                }
                else {
                    // Si no se ha desbordado, salir del bucle
                    break;
                }
            }

            if (!desbordado) contador++;
        }

        // Imprimir el resultado
        System.out.println(contador);


    }
}