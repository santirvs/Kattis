package Others.Easy.Puntuacion_2_0_a_2_9._2_6;

import java.util.Scanner;

public class NoonerizedSpumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNext()) {
            return;
        }

        // 1. Lectura de los 5 componentes de la expresión de entrada: X, op, Y, "=", Z
        String sX = scanner.next();
        String op = scanner.next();
        String sY = scanner.next();
        scanner.next(); // Ignorar el signo "="
        String sZ = scanner.next();
        scanner.close();

        // Almacenamos los números originales en un arreglo para facilitar las combinaciones
        String[] nums = new String[] { sX, sY, sZ };

        // 2. Fuerza bruta: Probar las 3 combinaciones posibles de pares de números (a, b)
        // Combinación 0: X e Y (índices 0 y 1)
        // Combinación 1: X y Z (índices 0 y 2)
        // Combinación 2: Y y Z (índices 1 y 2)
        for (int a = 0; a < 3; a++) {
            for (int b = a + 1; b < 3; b++) {
                String strA = nums[a];
                String strB = nums[b];

                // Un prefijo propio exige que la longitud sea mayor a 1
                // (debe quedar al menos un dígito en el prefijo y otro en el sufijo)
                if (strA.length() <= 1 || strB.length() <= 1) {
                    continue;
                }

                // 3. Recorrer todos los puntos de corte posibles en ambas cadenas
                for (int i = 1; i < strA.length(); i++) {
                    for (int j = 1; j < strB.length(); j++) {

                        // Generar los nuevos valores intercambiando los prefijos:
                        // - nuevoA = prefijo de B + sufijo de A
                        // - nuevoB = prefijo de A + sufijo de B
                        String newA = strB.substring(0, j) + strA.substring(i);
                        String newB = strA.substring(0, i) + strB.substring(j);

                        // Asignar los valores resultantes a los tres operandos de la ecuación
                        String candidateX = nums[0];
                        String candidateY = nums[1];
                        String candidateZ = nums[2];

                        if (a == 0 && b == 1) {
                            candidateX = newA;
                            candidateY = newB;
                        } else if (a == 0 && b == 2) {
                            candidateX = newA;
                            candidateZ = newB;
                        } else if (a == 1 && b == 2) {
                            candidateY = newA;
                            candidateZ = newB;
                        }

                        // 4. Validar la ecuación aritmética resultante
                        if (isValidEquation(candidateX, op, candidateY, candidateZ)) {
                            // Imprimir la única solución correcta encontrada y terminar
                            System.out.println(candidateX + " " + op + " " + candidateY + " = " + candidateZ);
                            return;
                        }
                    }
                }
            }
        }
    }

    /**
     * Valida de forma segura si los tres strings formados cumplen con la operación matemática
     * y se encuentran dentro de los rangos permitidos (enteros positivos menores que 2^31).
     */
    private static boolean isValidEquation(String sx, String op, String sy, String sz) {
        try {
            // Evitar desbordamientos descartando cadenas con más de 10 dígitos
            if (sx.length() > 10 || sy.length() > 10 || sz.length() > 10) {
                return false;
            }

            long x = Long.parseLong(sx);
            long y = Long.parseLong(sy);
            long z = Long.parseLong(sz);

            // Los números deben ser estrictamente positivos
            if (x <= 0 || y <= 0 || z <= 0) {
                return false;
            }

            // Evaluar según el operador correspondiente
            if (op.equals("+")) {
                return x + y == z;
            } else if (op.equals("*")) {
                return x * y == z;
            }
        } catch (NumberFormatException e) {
            // Si ocurre algún desbordamiento o error de conversión, se descarta el candidato
            return false;
        }
        return false;
    }
}