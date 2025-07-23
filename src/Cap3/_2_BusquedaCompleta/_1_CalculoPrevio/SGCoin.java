package Cap3._2_BusquedaCompleta._1_CalculoPrevio;
import java.util.*;

// El enunciado aquí indica que el token tiene 7 ceros al final y es menor de 1_000_000_000.
// Eso nos deja un máximo de 100 tokens posibles (0, 10_000_000, 20_000_000, ..., 990_000_000).
// Por otro lado, no hay restricción con el tamaño del mensaje, así que podemos asumir que es un String de longitud arbitraria
// y en este caso, para facilitar el cálculo, podemos asumir que el mensaje es un String de longitud 1 (un único carácter) y será "0"
// Calcular el hash para cada uno de los casos posibles de hash (0, 10_000_000, 20_000_000, ..., 990_000_000) y guardar el token correspondiente


public class SGCoin {

    //Esta función calcula el hash (ya viene dada en el enunciado)
    static long H(long previousHash, String transaction, long token) {
        long v = previousHash;
        for (int i = 0; i < transaction.length(); i++) {
            v = (v * 31 + transaction.charAt(i)) % 1_000_000_007;
        }
        return (v * 7 + token) % 1_000_000_007;
    }

    // Clase auxiliar para almacenar el token y el hash
    static class Pair {
        int token;
        long hash;

        Pair(int token, long hash) {
            this.token = token;
            this.hash = hash;
        }
    }

    // Esta función genera un token para un hash dado y una transacción
    static Pair generate_token(long previousHash, String transaction) {
        for (int i = 0; i < 1_000_000_000; i++) {
            long h = H(previousHash, transaction, i);
            if (h % 100_000_000 == 0) {
                return new Pair(i, h);
            }
        }
        return new Pair(-1, -1);
    }

    //Ejecutar en modo generación o ejecución
    public static void main(String[] args) {
        //main_generate(args);
        main_execute(args);
    }

    // Generar los tokens y hashes para los valores de prev_h entre 0 y 100
    public static void main_generate(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long prev_h = scanner.nextLong();
        prev_h /= 10_000_000;

        Pair[] m = new Pair[101];

        // Exemple de generació automàtica de m[i] per prev_h entre 0 i 100:
        for (int i = 0; i <= 100; i++) {
            long hashInput = i * 10_000_000L;
            m[i] = generate_token(hashInput, "0");
            System.out.printf("m[%d] = new Pair(%d, %dL);\n", i, m[i].token, m[i].hash);
        }

        int token1 = m[(int) prev_h].token;
        long hash1 = m[(int) prev_h].hash;

        System.out.println("0 " + token1);

        hash1 /= 10_000_000;
        System.out.println("0 " + m[(int) hash1].token);
    }

    // Ejecutar el código con los valores predefinidos de m[i]
    public static void main_execute(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long prev_h = scanner.nextLong();
        prev_h /= 10_000_000;

        Pair[] m = new Pair[101];
        m[0] = new Pair(99999664, 100000000L);
        m[1] = new Pair(29999678, 200000000L);
        m[2] = new Pair(59999692, 400000000L);
        m[3] = new Pair(89999706, 600000000L);
        m[4] = new Pair(19999720, 700000000L);
        m[5] = new Pair(49999734, 900000000L);
        m[6] = new Pair(79999755, 100000000L);
        m[7] = new Pair(9999769, 200000000L);
        m[8] = new Pair(39999783, 400000000L);
        m[9] = new Pair(69999797, 600000000L);
        m[10] = new Pair(99999811, 800000000L);
        m[11] = new Pair(29999825, 900000000L);
        m[12] = new Pair(59999846, 100000000L);
        m[13] = new Pair(89999860, 300000000L);
        m[14] = new Pair(19999874, 400000000L);
        m[15] = new Pair(49999888, 600000000L);
        m[16] = new Pair(79999902, 800000000L);
        m[17] = new Pair(9999916, 900000000L);
        m[18] = new Pair(39999937, 100000000L);
        m[19] = new Pair(69999951, 300000000L);
        m[20] = new Pair(99999965, 500000000L);
        m[21] = new Pair(29999979, 600000000L);
        m[22] = new Pair(59999993, 800000000L);
        m[23] = new Pair(90000007, 1000000000L);
        m[24] = new Pair(20000028, 100000000L);
        m[25] = new Pair(50000042, 300000000L);
        m[26] = new Pair(80000056, 500000000L);
        m[27] = new Pair(10000070, 600000000L);
        m[28] = new Pair(40000084, 800000000L);
        m[29] = new Pair(70000098, 1000000000L);
        m[30] = new Pair(119, 100000000L);
        m[31] = new Pair(30000133, 300000000L);
        m[32] = new Pair(60000147, 500000000L);
        m[33] = new Pair(90000161, 700000000L);
        m[34] = new Pair(20000175, 800000000L);
        m[35] = new Pair(50000189, 1000000000L);
        m[36] = new Pair(80000210, 200000000L);
        m[37] = new Pair(10000224, 300000000L);
        m[38] = new Pair(40000238, 500000000L);
        m[39] = new Pair(70000252, 700000000L);
        m[40] = new Pair(266, 800000000L);
        m[41] = new Pair(30000280, 1000000000L);
        m[42] = new Pair(60000301, 200000000L);
        m[43] = new Pair(90000315, 400000000L);
        m[44] = new Pair(20000329, 500000000L);
        m[45] = new Pair(50000343, 700000000L);
        m[46] = new Pair(80000357, 900000000L);
        m[47] = new Pair(10000371, 1000000000L);
        m[48] = new Pair(40000392, 200000000L);
        m[49] = new Pair(70000406, 400000000L);
        m[50] = new Pair(420, 500000000L);
        m[51] = new Pair(30000434, 700000000L);
        m[52] = new Pair(60000448, 900000000L);
        m[53] = new Pair(90000469, 100000000L);
        m[54] = new Pair(20000483, 200000000L);
        m[55] = new Pair(50000497, 400000000L);
        m[56] = new Pair(80000511, 600000000L);
        m[57] = new Pair(10000525, 700000000L);
        m[58] = new Pair(40000539, 900000000L);
        m[59] = new Pair(70000560, 100000000L);
        m[60] = new Pair(574, 200000000L);
        m[61] = new Pair(30000588, 400000000L);
        m[62] = new Pair(60000602, 600000000L);
        m[63] = new Pair(90000616, 800000000L);
        m[64] = new Pair(20000630, 900000000L);
        m[65] = new Pair(50000651, 100000000L);
        m[66] = new Pair(80000665, 300000000L);
        m[67] = new Pair(10000679, 400000000L);
        m[68] = new Pair(40000693, 600000000L);
        m[69] = new Pair(70000707, 800000000L);
        m[70] = new Pair(721, 900000000L);
        m[71] = new Pair(30000742, 100000000L);
        m[72] = new Pair(60000756, 300000000L);
        m[73] = new Pair(90000770, 500000000L);
        m[74] = new Pair(20000784, 600000000L);
        m[75] = new Pair(50000798, 800000000L);
        m[76] = new Pair(80000812, 1000000000L);
        m[77] = new Pair(10000833, 100000000L);
        m[78] = new Pair(40000847, 300000000L);
        m[79] = new Pair(70000861, 500000000L);
        m[80] = new Pair(875, 600000000L);
        m[81] = new Pair(30000889, 800000000L);
        m[82] = new Pair(60000903, 1000000000L);
        m[83] = new Pair(90000924, 200000000L);
        m[84] = new Pair(20000938, 300000000L);
        m[85] = new Pair(50000952, 500000000L);
        m[86] = new Pair(80000966, 700000000L);
        m[87] = new Pair(10000980, 800000000L);
        m[88] = new Pair(40000994, 1000000000L);
        m[89] = new Pair(70001015, 200000000L);
        m[90] = new Pair(1029, 300000000L);
        m[91] = new Pair(30001043, 500000000L);
        m[92] = new Pair(60001057, 700000000L);
        m[93] = new Pair(90001071, 900000000L);
        m[94] = new Pair(20001085, 1000000000L);
        m[95] = new Pair(50001106, 200000000L);
        m[96] = new Pair(80001120, 400000000L);
        m[97] = new Pair(10001134, 500000000L);
        m[98] = new Pair(40001148, 700000000L);
        m[99] = new Pair(70001162, 900000000L);
        m[100] = new Pair(1176, 1000000000L);

        int token1 = m[(int) prev_h].token;
        long hash1 = m[(int) prev_h].hash;

        System.out.println("0 " + token1);

        hash1 /= 10_000_000;
        System.out.println("0 " + m[(int) hash1].token);
    }
}
