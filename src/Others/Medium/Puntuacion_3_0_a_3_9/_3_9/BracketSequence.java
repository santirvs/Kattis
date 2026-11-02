package Others.Medium.Puntuacion_3_0_a_3_9._3_9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;


public class BracketSequence {

    static class FR {
        BufferedReader br;
        StringTokenizer st;

        public FR() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null; // Manejo de EOF
                    st = new StringTokenizer(line);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        float nextFloat() {
            return Float.parseFloat(next());
        }

        String nextLine() {
            String str = "";
            try {
                if (st != null && st.hasMoreElements()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {

        FR sc = new FR();

        int MODULO = 1_000_000_007;

        int numTokens = sc.nextInt();
        boolean sumando = true;
        long numOperandos = 0;
        Stack<Long> pilaOperandos = new Stack<>();

        for (int i=0; i<numTokens; i++) {
            String token = sc.next();

            if (token.equals("(")) {
                pilaOperandos.push(numOperandos);
                numOperandos=0;
                sumando = !sumando;
            } else if (token.equals(")")) {
                long valor = 0; //Elemento neutro de la suma
                if (!sumando) valor = 1;  //Elemento neutro de la multiplicación
                while (numOperandos-- > 0) {
                    if (sumando) valor+=pilaOperandos.pop();
                    else valor*=pilaOperandos.pop();
                    valor = valor % MODULO;
                }
                numOperandos = pilaOperandos.pop();
                sumando = !sumando;
                pilaOperandos.push(valor);
                numOperandos++;
            } else {
                //Es un número. Apilar
                pilaOperandos.push(Long.parseLong(token));
                numOperandos++;
            }
        }

        //Acabar de sumar todos los operandos de la pila
        long resultado = 0;
        while (!pilaOperandos.isEmpty()) {
            resultado += pilaOperandos.pop();
            resultado = resultado % MODULO;
        }


        System.out.println(resultado);

    }
}