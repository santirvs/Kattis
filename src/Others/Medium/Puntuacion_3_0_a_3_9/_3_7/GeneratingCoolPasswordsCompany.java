package Others.Medium.Puntuacion_3_0_a_3_9._3_7;

import java.util.Scanner;


/**
 * PROBLEMA: Generating Cool Passwords Company
 * ============================================================================
 * EXPLICACIÓN DEL PLANTEAMIENTO
 * ============================================================================
 * Necesitamos generar contraseñas con una longitud entre 8 y 12
 *  y que cumplan una serie de requisitos (una minúscula, una mayúscula, un dígito y un símbolo)
 *  Tenemos un total de 94 caracteres (ASCII 33..126)
 *  Para simplificar un problema podemos fijar un prefijo ej: Aa1+ que haga que se cumplan las restricciones
 *  y completar hasta la longitud mínima (aaaa). De esta forma sólo nos tenemos que preocupar de
 *  generar nuevas claves con este prefijo.
 *  Además, tenemos que asegurar una distancia de edición de 2. ¿Como hacerlo?
 *  Con la longitud del prefijo de 4 caracteres, podemos fijar la longitud total en 10 (entra en el rango) de
 *  forma que duplicaremos una subsecuencia de 3 caracteres. El password generado será prefijo(4)+secuencia(3)+secuencia(3)
 *  Si aseguramos que cada secuencia sea diferente, aseguraremos que cada par de claves tenga una diferencia de 1 caracter
 *  y como la secuencia se duplica, aseguramos que habrán como mínimo 2 diferencias
 *  Por lo tanto, se ha reducido el problema a generar secuencias diferentes (un triple bucle)
 *  La cantidad de claves a generar es como máximo de 1000 y tenemos 3 posiciones con 94 opciones cada una (94*94*94)
 *  tenemos suficientes combinaciones para alcanzar las 1000
 *
 */
public class GeneratingCoolPasswordsCompany {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numCombinaciones = sc.nextInt();

        String prefijo = "Aa1!";

        for (int i=33; i<=126 && numCombinaciones > 0; i++) {
            for (int j=33; j<=126 && numCombinaciones > 0; j++) {
                for (int k=33; k<=126 && numCombinaciones > 0; k++) {
                    String secuencia = Character.toString(i)+Character.toString(j)+Character.toString(k);
                    System.out.println(prefijo+secuencia+secuencia);
                    numCombinaciones--;
                }
            }

        }

    }
}