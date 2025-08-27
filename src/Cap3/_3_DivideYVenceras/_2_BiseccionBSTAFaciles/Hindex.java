package Cap3._3_DivideYVenceras._2_BiseccionBSTAFaciles;

// Estrategia de D&C. Bisección binaria

// Buscar la cantidad máxima de artículos que tienen x citas.

// Se puede aplicar una búsqueda binaria sobre el número de citas, desde 0 hasta el número de artículos.
// Para cada número de citas, se cuenta cuántos artículos tienen al menos ese número de citas.
// Si el número de artículos es mayor o igual que el número de citas, se intenta con
// un número mayor de citas; si no, se intenta con un número menor de citas.



import java.util.Scanner;

public class Hindex {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Lectura de los datos
        int numArticulos = sc.nextInt();

        // Leer las citas de cada artículo
        int[] citas = new int[numArticulos];
        for (int i = 0; i < numArticulos; i++) {
            citas[i] = sc.nextInt();
        }
        // Fin de la entrada
        sc.close();

        // Biseccion binaria para encontrar el H-index
        int left = 0; // Mínimo número de citas
        int right = numArticulos; // Máximo número de citas (número de artículos
        int result = 0; // Resultado final
        while (left <= right) {
            int mid = left + (right - left) / 2; // Punto medio del número de citas a probar

            // Contar cuántos artículos tienen al menos 'mid' citas
            int count = 0;
            for (int i = 0; i < numArticulos; i++) {
                if (citas[i] >= mid) {
                    count++;
                }
            }

            // Verificar si se puede alcanzar el H-index con 'mid' citas
            if (count >= mid) {
                result = mid; // Actualizar el resultado
                left = mid + 1; // Intentar con un número mayor de citas
            } else {
                right = mid - 1; // Intentar con un número menor de citas
            }
        }

        // Imprimir el H-index
        System.out.println(result);


    }


}
