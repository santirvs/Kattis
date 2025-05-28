package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias._3_EstructurasDatosRelativasArboles;

import java.util.*;

public class JustForSideKicks {
    static class FenwickTree {
        long[] tree;

        FenwickTree(int size) {
            tree = new long[size + 1];
        }

        private int LSB(int i) {
            return i & -i;
        }

        void add(int i, int v) {
            while (i < tree.length) {
                tree[i] += v;
                i += LSB(i);
            }
        }

        long query(int i) {
            long res = 0;
            while (i > 0) {
                res += tree[i];
                i -= LSB(i);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numGems = sc.nextInt();
        int numQueries = sc.nextInt();

        long[] V = new long[6]; // Valors dels tipus de gemmes
        for (int i = 0; i < 6; ++i) {
            V[i] = sc.nextLong();
        }

        FenwickTree[] ST = new FenwickTree[6];
        for (int i = 0; i < 6; ++i) {
            ST[i] = new FenwickTree(numGems);
        }

        String gemTypes = sc.next();
        int[] T = new int[numGems + 1]; // Tipus de cada gemma (1-indexat)
        for (int i = 1; i <= numGems; ++i) {
            T[i] = gemTypes.charAt(i - 1) - '1';
            ST[T[i]].add(i, 1);
        }

        while (numQueries-- > 0) {
            int cmd = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            switch (cmd) {
                case 1:
                    ST[T[a]].add(a, -1);
                    T[a] = b - 1;
                    ST[T[a]].add(a, 1);
                    break;
                case 2:
                    V[a - 1] = b;
                    break;
                case 3:
                    long res = 0;
                    for (int i = 0; i < 6; ++i) {
                        res += V[i] * (ST[i].query(b) - ST[i].query(a - 1));
                    }
                    System.out.println(res);
                    break;
            }
        }
        sc.close();
    }
}

