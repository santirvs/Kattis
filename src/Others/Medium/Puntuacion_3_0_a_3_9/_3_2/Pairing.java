package Others.Medium.Puntuacion_3_0_a_3_9._3_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pairing {

    public static void main(String[] args) throws IOException {
        // Fast I/O estándar para Java 1.7
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        StringTokenizer st = new StringTokenizer(line);
        long a1 = Long.parseLong(st.nextToken());
        long a2 = Long.parseLong(st.nextToken());
        long b1 = Long.parseLong(st.nextToken());
        long b2 = Long.parseLong(st.nextToken());

        long uncomfortable = 0;

        // PASO 1: Parejas ideales internacionales (a2 <-> b2)
        // El exceso de personas que querían cruzar pero no pudieron se queda en su propia empresa
        long remA2 = 0;
        long remB2 = 0;
        if (a2 > b2) {
            remA2 = a2 - b2;
        } else {
            remB2 = b2 - a2;
        }

        // PASO 2: Identificar si quedan empleados "impares" que querían quedarse en casa
        long sobraA1 = a1 % 2; // Puede ser 0 o 1
        long sobraB1 = b1 % 2; // Puede ser 0 o 1

        // PASO 3: Control de daños para Alpha
        // Si nos quedó un soltero en casa (sobraA1 == 1) y hay excedente de internacionales (remA2 > 0),
        // los juntamos. El de casa es feliz (quería Alpha), pero el internacional es INCÓMODO (+1).
        if (sobraA1 == 1 && remA2 > 0) {
            uncomfortable += 1;
            remA2--;
            sobraA1 = 0;
        }
        // Cualquier excedente restante de remA2 se debe emparejar entre sí en Alpha.
        // Ambos querían ir a Beta pero se quedaron en Alpha -> Ambos INCÓMODOS (+2 por pareja, o +1 por individuo).
        uncomfortable += remA2;

        // PASO 4: Control de daños para Beta
        // Mismo proceso: juntamos al soltero de casa con un internacional sobrante de Beta si existe.
        if (sobraB1 == 1 && remB2 > 0) {
            uncomfortable += 1;
            remB2--;
            sobraB1 = 0;
        }
        // El resto de remB2 se casa entre sí dentro de Beta -> Todos INCÓMODOS.
        uncomfortable += remB2;

        // PASO 5: El último recurso
        // Si remA2 y remB2 se agotaron, pero aún nos queda un soltero de casa en Alpha (sobraA1 == 1)
        // y un soltero de casa en Beta (sobraB1 == 1), no queda de otra que cruzarlos.
        // Ambos querían quedarse en casa y los obligamos a cambiar de empresa -> Ambos INCÓMODOS (+2).
        if (sobraA1 == 1 && sobraB1 == 1) {
            uncomfortable += 2;
        }

        // Imprimir el resultado mínimo de incómodos
        System.out.println(uncomfortable);
    }
}