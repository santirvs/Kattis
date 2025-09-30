package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el número de registros. Ojo, que pueden ser 10^6 --> Usar FastScanner!
// Para cada registro
//   Leer el tipo de visitante (STU, VIS o FAC)
//   Leer la dirección (IN / OUT)
//   Leer la cantidad
//   Actualizar el contador del tipo
// Al final, los contadores deberían ser 0, sinó es que han quedado alguien dentro
// Mostrar NO STRAGGLERS o la cantidad

import java.util.Scanner;

public class NoStragglers {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Leer el número de registros
        int numRegistros = sc.nextInt();

        //Leer los registros y actualizar contadores
        // En este caso sería suficiente un contador general
        int numFacultativos = 0;
        int numVisitantes = 0;
        int numEstudiantes = 0;

        for (int i=0; i<numRegistros; i++) {
            String tipo = sc.next();
            String direccion = sc.next();
            int cantidad = sc.nextInt();

            // Si la direccion es de salida, se considera una cantidad negativa
            if (direccion.equals("OUT")) cantidad *= -1;

            switch (tipo) {
                case "STU" : numEstudiantes+=cantidad; break;
                case "VIS" : numVisitantes+=cantidad; break;
                case "FAC" : numFacultativos+=cantidad; break;
            }
        }

        //Mostrar el resultado
        int totalRezagados = numEstudiantes+numVisitantes+numFacultativos;

        if (totalRezagados == 0) System.out.println("NO STRAGGLERS");
        else System.out.println(totalRezagados);

        sc.close();
    }
}

