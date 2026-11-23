package Others.Easy.Puntuacion_1_1_a_1_9._1_8;

import java.util.Locale;
import java.util.Scanner;

public class Arrowhead1 {

    /**
     * Devuelve la semialtura (distancia desde el eje X hasta el borde superior)
     * del primer triángulo en una coordenada x dada (válido para 0 <= x <= l1).
     *
     * Planteamiento:
     * El triángulo 1 tiene su punta en (0, 0) y su base vertical en x = l1.
     * En x = l1, la altura total es b1, por lo que su semialtura es b1 / 2.
     * Por semejanza de triángulos (o ecuación de la recta que pasa por el origen),
     * la pendiente del borde superior es m1 = (b1 / 2) / l1.
     */
    static double semiAltura1(double x, int l1, int b1) {
        double pendiente1 = b1 / (2.0 * l1);
        return pendiente1 * x;
    }

    /**
     * Devuelve la semialtura del segundo triángulo en una coordenada x dada
     * (válido para x2 <= x <= x2 + l2).
     *
     * Planteamiento:
     * El triángulo 2 tiene su punta en (x2, 0) y su base vertical en x = x2 + l2.
     * Su pendiente superior es m2 = (b2 / 2) / l2, y como empieza en x2,
     * la distancia horizontal desde su punta es (x - x2).
     */
    static double semiAltura2(double x, int l2, int b2, int x2) {
        double pendiente2 = b2 / (2.0 * l2);
        return pendiente2 * (x - x2);
    }

    /**
     * En cualquier coordenada x donde ambos triángulos existan, la región
     * superpuesta (intersección) queda limitada por el borde que esté más abajo.
     * Por tanto, su semialtura es el mínimo de ambas semialturas.
     */
    static double minSemiAltura(double x, int l1, int b1, int l2, int b2, int x2) {
        return Math.min(semiAltura1(x, l1, b1), semiAltura2(x, l2, b2, x2));
    }

    /**
     * Calcula el área de la mitad superior de la intersección en un subintervalo [a, b]
     * dentro del cual las dos rectas superiores NO se cruzan.
     *
     * Planteamiento:
     * Si dos rectas no se cruzan en el interior de [a, b], la función min(f1(x), f2(x))
     * coincide con una única recta en todo ese tramo. El área bajo una recta en [a, b]
     * es exactamente un trapecio (o un triángulo si una de las alturas es 0):
     *   Área = ((base_menor + base_mayor) / 2) * altura_del_trapecio
     * Aquí, las "bases" verticales son las semialturas en x = a y x = b,
     * y la anchura del trapecio es (b - a).
     */
    static double areaTrapecioSuperior(double a, double b, int l1, int b1, int l2, int b2, int x2) {
        double semiAlturaEnA = minSemiAltura(a, l1, b1, l2, b2, x2);
        double semiAlturaEnB = minSemiAltura(b, l1, b1, l2, b2, x2);
        return ((semiAlturaEnA + semiAlturaEnB) / 2.0) * (b - a);
    }

    public static void main(String[] args) {
        // Usamos Locale.US para asegurar que la entrada/salida decimal use punto (.)
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        if (!sc.hasNextInt()) {
            return;
        }

        // Lectura de datos del triángulo 1 (punta en x = 0)
        int l1 = sc.nextInt();
        int b1 = sc.nextInt();

        // Lectura de datos del triángulo 2 (punta en x = x2)
        int l2 = sc.nextInt();
        int b2 = sc.nextInt();
        int x2 = sc.nextInt();

        // 1. Principio de inclusión-exclusión:
        //    Área total = Área(T1) + Área(T2) - Área(T1 ∩ T2)
        double area1 = (b1 * l1) / 2.0;
        double area2 = (b2 * l2) / 2.0;

        // 2. Determinar el intervalo horizontal [left, right] donde ambos triángulos coinciden:
        //    - El triángulo 1 ocupa [0, l1]
        //    - El triángulo 2 ocupa [x2, x2 + l2]
        //    La intersección en el eje X es [max(0, x2), min(l1, x2 + l2)]
        double left = Math.max(0.0, x2);
        double right = Math.min((double) l1, (double) x2 + l2);

        double areaSuperpuesta = 0.0;

        // Solo hay solapamiento si el intervalo tiene longitud positiva (left < right).
        // Si left >= right, los triángulos solo se tocan en un punto/borde o están separados.
        if (left < right) {
            double m1 = b1 / (2.0 * l1);
            double m2 = b2 / (2.0 * l2);

            double semiAreaSuperpuesta = 0.0;

            // 3. Comprobar si los bordes superiores de ambos triángulos se cruzan
            //    dentro de (left, right).
            //    Esto ocurre cuando el triángulo 2 tiene mayor pendiente que el 1 (m2 > m1)
            //    y alcanza al borde del triángulo 1 antes de llegar a 'right'.
            //    Igualamos ambas rectas:
            //      m1 * x = m2 * (x - x2)
            //      m1 * x = m2 * x - m2 * x2
            //      (m2 - m1) * x = m2 * x2  =>  x = (m2 * x2) / (m2 - m1)
            if (Math.abs(m2 - m1) > 1e-12) {
                double xInterseccion = (m2 * x2) / (m2 - m1);

                if (xInterseccion > left && xInterseccion < right) {
                    // Si se cruzan dentro del intervalo, dividimos el cálculo en dos trapecios:
                    // - De 'left' a 'xInterseccion' (manda el borde del triángulo 2)
                    // - De 'xInterseccion' a 'right' (manda el borde del triángulo 1)
                    semiAreaSuperpuesta += areaTrapecioSuperior(left, xInterseccion, l1, b1, l2, b2, x2);
                    semiAreaSuperpuesta += areaTrapecioSuperior(xInterseccion, right, l1, b1, l2, b2, x2);
                } else {
                    // Si el punto de corte cae fuera de (left, right), un único borde
                    // está por debajo en todo el intervalo: basta un solo trapecio.
                    semiAreaSuperpuesta += areaTrapecioSuperior(left, right, l1, b1, l2, b2, x2);
                }
            } else {
                // Si las pendientes son iguales (rectas paralelas), nunca se cruzan:
                // basta un solo trapecio en todo [left, right].
                semiAreaSuperpuesta += areaTrapecioSuperior(left, right, l1, b1, l2, b2, x2);
            }

            // 4. Como ambos triángulos son simétricos respecto al eje X,
            //    el área total superpuesta es el doble de la mitad superior.
            areaSuperpuesta = 2.0 * semiAreaSuperpuesta;
        }

        // 5. Resultado final restando la región contada dos veces
        double resultado = area1 + area2 - areaSuperpuesta;

        // Imprimimos con suficiente precisión decimal para cumplir la tolerancia del juez
        System.out.printf(Locale.US, "%.12f%n", resultado);
    }
}