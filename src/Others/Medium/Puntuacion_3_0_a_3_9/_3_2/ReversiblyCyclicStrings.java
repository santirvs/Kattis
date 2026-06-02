package Others.Medium.Puntuacion_3_0_a_3_9._3_2;

import java.util.Scanner;

// ver ReversiblyCyclicString.md


public class ReversiblyCyclicStrings {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            if (scanner.hasNext()) {
                String s = scanner.next();
                System.out.println(isValid(s) ? 1 : 0);
            }

            scanner.close();
        }

        public static boolean isValid(String s) {
            int n = s.length();

            // Cadenas de longitud 1 o 2 siempre son verdaderas
            if (n <= 2) {
                return true;
            }

            // Creamos la cadena cíclica duplicada donde buscaremos
            String cyclic = s + s;

            // Caso 1: Probar la subcadena propia omitiendo el ÚLTIMO carácter
            String sub1 = s.substring(0, n - 1);
            String rev1 = new StringBuilder(sub1).reverse().toString();

            // Si el reverso de esta subcadena máxima no está en el ciclo, falla
            if (cyclic.indexOf(rev1) == -1) {
                return false;
            }

            // Caso 2: Probar la subcadena propia omitiendo el PRIMER carácter
            String sub2 = s.substring(1, n);
            String rev2 = new StringBuilder(sub2).reverse().toString();

            // Si el reverso de esta otra subcadena máxima no está en el ciclo, falla
            if (cyclic.indexOf(rev2) == -1) {
                return false;
            }

            // Si ambas subcadenas propias máximas pudieron revertirse y encontrarse,
            // todas las subcadenas más pequeñas contenidas en ellas también cumplirán la propiedad.
            return true;
        }
    }