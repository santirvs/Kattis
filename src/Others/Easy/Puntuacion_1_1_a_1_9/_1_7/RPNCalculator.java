package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;

public class RPNCalculator {

    public static void main(String[] args) throws IOException {
        Deque<BigInteger> stack = new ArrayDeque<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                if ("quit".equals(line)) {
                    break;
                } else if ("dup".equals(line)) {
                    stack.push(stack.peek());
                } else if ("print".equals(line)) {
                    System.out.println(stack.peek());
                } else if ("pop".equals(line)) {
                    stack.pop();
                } else if ("swap".equals(line)) {
                    BigInteger b = stack.pop();
                    BigInteger a = stack.pop();
                    stack.push(b);
                    stack.push(a);
                } else if (isOperator(line)) {
                    // b es el tope de la pila (el más reciente), a es el siguiente
                    BigInteger b = stack.pop();
                    BigInteger a = stack.pop();
                    stack.push(applyOperator(a, b, line));
                } else {
                    stack.push(new BigInteger(line));
                }
            }
        }
    }

    private static boolean isOperator(String token) {
        return "+".equals(token)
                || "-".equals(token)
                || "*".equals(token)
                || "/".equals(token)
                || "^".equals(token);
    }

    private static BigInteger applyOperator(BigInteger a, BigInteger b, String op) {
        switch (op) {
            case "+":
                return a.add(b);
            case "-":
                return a.subtract(b);
            case "*":
                return a.multiply(b);
            case "/":
                return a.divide(b);
            case "^":
                return a.pow(b.intValue());
            default: return a;
        }
    }
}