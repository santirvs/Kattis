package Cap1._2_ProblemasAdHoc._10_NumerosRomanos;

import java.util.*;

public class RomanHolidays {


    static String decimalToRoman(int n) {
        String[] roman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] value = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

        StringBuilder sb = new StringBuilder();

        for (int i = 12; i >= 0; i--) {
            while (n >= value[i]) {
                sb.append(roman[i]);
                n -= value[i];
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();

        for (int i = 1; i <= 1000; i++)
            list.add(decimalToRoman(i));

        Collections.sort(list);

        HashMap<String, Integer> front = new HashMap<>();
        HashMap<String, Integer> back = new HashMap<>();

        for (int i = 0; i < 1000; i++) {
            front.put(list.get(i), i + 1);
            back.put(list.get(i), i - 1000);   // -1000 ... -1
        }

        int posM = front.get("M");   // 946 (1-indexado)

        int T = sc.nextInt();

        while (T-- > 0) {

            int n = sc.nextInt();

            int k = n / 1000;
            int r = n % 1000;

            if (r == 0) {
                // M, MM, MMM...
                System.out.println(posM * k);
                continue;
            }

            String s = decimalToRoman(r);

            char c = s.charAt(0);

            if (c == 'V' || c == 'X') {
                int ans = back.get(s) - k * (1000 - posM);
                System.out.println(ans);
            } else {
                int ans = front.get(s) + k * posM;
                System.out.println(ans);
            }
        }
    }
}
