package Cap3._3_DivideYVenceras._3_BusquedaTernariaYOtros;

/*
Sinceramente, no veo por dónde atacar este problema...

Original de: https://github.com/BrandonTang89/Competitive_Programming_4_Solutions/blob/main/Chapter_3_Problem_Solving_Paradigms/Divide_and_Conquer/kattis_cantor.py

Considera la entrada x y cómo encontrar su representación en base 3.
Nota que x = a0*3^-1 + a1*3^-2 + a2*3^-3 + ..., Observa entonces que 3x = a0 + a1*3^-1 + a2*3^-2 + ...
Y por lo tanto podemos extraer a0. Podemos repetir este proceso para los dígitos restantes, hasta que
empecemos a repetir dígitos. Nota el caso especial de x == 1. No tengo una prueba formal de esto, pero
creo que es correcto sugerir que los flotantes finitos en decimal corresponden a flotantes infinitamente
recurrentes en ternario y viceversa...

Tiempo: O(?), Memoria: O(1)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cantor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input.equals("END")) {
                break;
            }

            double x = Double.parseDouble(input);

            if (Math.abs(x - 1.0) < 1e-12) {
                System.out.println("MEMBER");
                continue;
            }

            double y = x;
            x *= 3;
            boolean isMember = ((int) x) != 1;
            x = x - (int) x;

            while (Math.abs(x - y) > 1e-9 && isMember) {
                x *= 3;
                isMember = ((int) x) != 1;
                x = x - (int) x;
            }

            System.out.println(isMember ? "MEMBER" : "NON-MEMBER");
        }
    }
}
