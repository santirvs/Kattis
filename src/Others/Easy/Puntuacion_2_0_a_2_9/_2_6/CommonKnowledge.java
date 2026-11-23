package Others.Easy.Puntuacion_2_0_a_2_9._2_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class CommonKnowledge {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) {
            return;
        }

        int n = Integer.parseInt(line.trim());

        /*
         * PLANTEAMIENTO DEL PROBLEMA:
         *
         * 1. Independencia entre dígitos:
         *    Cada una de las N posiciones de los marcadores de Alice y Bob es independiente.
         *    Si encontramos cuántos pares válidos (d_Alice, d_Bob) existen para 1 solo dígito,
         *    el número total de combinaciones para N dígitos será: (pares_por_dígito)^N.
         *
         * 2. Análisis del display de 7 segmentos (incluyendo siempre el segmento central):
         *
         *    - Visión de la MITAD SUPERIOR (segmentos: arriba, arriba-izq, arriba-der, centro):
         *      * {0}    -> arriba, arriba-izq, arriba-der            (ÚNICO)
         *      * {1}    -> arriba-der                                (ÚNICO)
         *      * {2, 3} -> arriba, arriba-der, centro                (AMBIGUO: 2 y 3 son iguales)
         *      * {4}    -> arriba-izq, arriba-der, centro            (ÚNICO)
         *      * {5, 6} -> arriba, arriba-izq, centro                (AMBIGUO: 5 y 6 son iguales)
         *      * {7}    -> arriba, arriba-der                        (ÚNICO)
         *      * {8, 9} -> arriba, arriba-izq, arriba-der, centro    (AMBIGUO: 8 y 9 son iguales)
         *      => Un dígito se reconoce sin ambigüedad por su mitad superior sii está en {0, 1, 4, 7}.
         *
         *    - Visión de la MITAD INFERIOR (segmentos: centro, abajo-izq, abajo-der, abajo):
         *      * {0}       -> abajo-izq, abajo-der, abajo            (ÚNICO)
         *      * {1, 7}    -> abajo-der (sin centro)                 (AMBIGUO: 1 y 7 son iguales)
         *      * {2}       -> centro, abajo-izq, abajo               (ÚNICO)
         *      * {3, 5, 9} -> centro, abajo-der, abajo               (AMBIGUO: 3, 5 y 9 son iguales)
         *      * {4}       -> centro, abajo-der                      (ÚNICO)
         *      * {6, 8}    -> centro, abajo-izq, abajo-der, abajo    (AMBIGUO: 6 y 8 son iguales)
         *      => Un dígito se reconoce sin ambigüedad por su mitad inferior sii está en {0, 2, 4}.
         *
         * 3. Condiciones de visibilidad de ambos jugadores (sin comunicación):
         *    - Bob ve la mitad superior de Bob (d_Bob) y la mitad superior de Alice (d_Alice).
         *      Para que Bob sepa ambos dígitos: d_Bob in {0, 1, 4, 7} y d_Alice in {0, 1, 4, 7}.
         *    - Alice ve la mitad inferior de Alice (d_Alice) y la mitad superior de Bob (d_Bob).
         *      Para que Alice sepa ambos dígitos: d_Alice in {0, 2, 4} y d_Bob in {0, 1, 4, 7}.
         *
         * 4. Intersección de condiciones por posición:
         *    - Opciones para d_Alice: {0, 1, 4, 7} ∩ {0, 2, 4} = {0, 4}      -> 2 opciones.
         *    - Opciones para d_Bob:   {0, 1, 4, 7} ∩ {0, 1, 4, 7} = {0, 1, 4, 7} -> 4 opciones.
         *
         *    Total de pares válidos por cada posición = 2 * 4 = 8.
         *
         * 5. Resultado para N dígitos:
         *    Total = 8^N.
         *    Usamos BigInteger para evitar cualquier desbordamiento incluso si N > 20
         *    (aunque para N <= 20 cabría en un long de 64 bits con 1L << (3 * n)).
         */
        BigInteger base = BigInteger.valueOf(8);
        BigInteger resultado = base.pow(n);

        System.out.println(resultado.toString());
    }
}