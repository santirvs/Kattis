package Cap1._1_ParaEmpezar._1_SoloESySecuencias;

import java.util.Scanner;

public class Planina {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int result = (int) Math.pow(2, n) + 1;
        System.out.println((int) Math.pow(result, 2));

    }
}