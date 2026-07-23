package Others.Medium.Puntuacion_4_0_a_4_9._4_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class VanishingParentheses {

    // Estructura para la clave de memoización
    private static class RangeKey {
        final int i;
        final int j;

        RangeKey(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RangeKey key = (RangeKey) o;
            return i == key.i && j == key.j;
        }

        @Override
        public int hashCode() {
            return 31 * i + j;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        boolean firstCase = true;

        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] tokens = line.split("\\s+");

            List<BigInteger> nums = new ArrayList<BigInteger>();
            List<Character> ops = new ArrayList<Character>();

            // Parseo de la línea dividiendo entre números y operadores
            for (int i = 0; i < tokens.length; i++) {
                if (i % 2 == 0) {
                    nums.add(new BigInteger(tokens[i]));
                } else {
                    ops.add(tokens[i].charAt(0));
                }
            }

            // Mapeo para memoización por cada caso de prueba
            Map<RangeKey, Set<BigInteger>> memo = new HashMap<RangeKey, Set<BigInteger>>();

            // Evaluamos toda la expresión de 0 a N-1
            Set<BigInteger> resultados = evaluar(0, nums.size() - 1, nums, ops, memo);

            // Control de la línea en blanco entre casos de prueba
            if (!firstCase) {
                System.out.println();
            }
            firstCase = false;

            // Imprimir resultados únicos en orden ascendente (TreeSet ya garantiza el orden)
            for (BigInteger res : resultados) {
                System.out.println(res);
            }
        }
    }

    private static Set<BigInteger> evaluar(int i, int j, List<BigInteger> nums, List<Character> ops, Map<RangeKey, Set<BigInteger>> memo) {
        RangeKey key = new RangeKey(i, j);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // TreeSet mantiene los elementos ordenados y sin duplicados
        Set<BigInteger> res = new TreeSet<BigInteger>();

        // Caso base: un único número
        if (i == j) {
            res.add(nums.get(i));
            memo.put(key, res);
            return res;
        }

        // Probar cada operador intermedio
        for (int k = i; k < j; k++) {
            char op = ops.get(k);
            Set<BigInteger> izq = evaluar(i, k, nums, ops, memo);
            Set<BigInteger> der = evaluar(k + 1, j, nums, ops, memo);

            for (BigInteger a : izq) {
                for (BigInteger b : der) {
                    if (op == '+') {
                        res.add(a.add(b));
                    } else if (op == '-') {
                        res.add(a.subtract(b));
                    } else if (op == '*') {
                        res.add(a.multiply(b));
                    }
                }
            }
        }

        memo.put(key, res);
        return res;
    }
}