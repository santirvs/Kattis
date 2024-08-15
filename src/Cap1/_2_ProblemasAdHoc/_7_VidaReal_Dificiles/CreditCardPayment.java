package Cap1._2_ProblemasAdHoc._7_VidaReal_Dificiles;


import java.util.Locale;
import java.util.Scanner;

public class CreditCardPayment {

        public static double epsilon = 0.001;

        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            scan.useLocale(Locale.ENGLISH);

            double eps = 0.001;
            int t;
            double r, b, m;
            t = scan.nextInt();
            while (t>0) {
                t--;
                r = scan.nextDouble();
                b= scan.nextDouble();
                m = scan.nextDouble();
                r /= 100;
                boolean paid = false;
                for (int i = 1; i <= 1200; i++) {
                    double interest = b * r;
                    interest = Math.round(interest * 100) / 100.0;
                    b += interest;
                    b = Math.round(b * 100) / 100.0;
                    b -= m;
                    if (b < eps) {
                        System.out.println(i);
                        paid = true;
                        break;
                    }
                }
                if (!paid) System.out.println("impossible");
            }


     }

}
