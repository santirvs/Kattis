package Cap3._3_DivideYVenceras._3_BusquedaTernariaYOtros;

// Estrategia de D&C. Búsqueda ternaria y otros

/** Kattis - sretan
 *
 * Original de: https://github.com/BrandonTang89/Competitive_Programming_4_Solutions/blob/main/Chapter_3_Problem_Solving_Paradigms/Divide_and_Conquer/kattis_sretan.py
 *
 * No veo como plantearlo usando búsqueda binaria o ternaria...
 *
 * Observamos la relación entre la secuencia de números de la suerte y la representación binaria.
 * Luego, basta con hacer la conversión.
 *
 * Tiempo: O(log(n)), Espacio: O(log(n))
 */
import java.util.Scanner;

public class Sretan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();

        // número de dígitos (longitud del número de la suerte)
        int numDigits = (int) Math.floor(Math.log(x + 1) / Math.log(2));

        // obtenemos la parte binaria correspondiente
        long remainder = (x + 1) - (1L << numDigits);
        String num = Long.toBinaryString(remainder);

        // reemplazamos 0 -> 4 y 1 -> 7
        num = num.replace('0', '4').replace('1', '7');

        // rellenamos con 4's si hace falta
        while (num.length() < numDigits) {
            num = "4" + num;
        }

        System.out.println(num);
    }
}
