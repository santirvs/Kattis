package Cap3._2_BusquedaCompleta._7_ProbarTodasRespuestasPosibles;

import java.util.*;

// No veo aquí la necesidad de probar las posibles respuestas...
// Leer el byte, aplicar la fórmula y mostrar el resultado para cada byte

// Pero se trata de descodificar y no de codificar!!!
// Así que la fórmula a aplicar es la inversa a la que da el enunciado y no es sencilla de deducir
// Lo más práctico es hacer un mapa de soluciones para los 256 posibles valores iniciales del byte
// aplicando la fórmula sencilla que da el enunciado y luego usar ese mapa para descodificar


public class JumbledCommunication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Construir un mapa de soluciones para los 256 posibles valores de byte
        Map<Integer, Integer> mapa = new HashMap<>();
        for (int i = 0; i < 256; i++) {
            // Aplicar la fórmula para obtener el valor del byte
            // Limitar el resultado a un byte (0-255)
            int byteValue = i ^ (i << 1) % 256;
            // Guardar el resultado en el mapa
            mapa.put(byteValue, i);
        }

        //Leer el número de bytes a descodificar
        int numBytes = sc.nextInt();

        for (int i = 0; i < numBytes; i++) {
            int byteValue = sc.nextInt();

            // Mostrar el resultado de la descodificación
            if (i!=0) System.out.print(" ");
            System.out.print(mapa.get(byteValue));

        }
        System.out.println();
    }
}
