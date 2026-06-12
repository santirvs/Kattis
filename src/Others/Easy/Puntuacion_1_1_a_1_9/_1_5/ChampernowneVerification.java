package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

import java.util.Scanner;

public class ChampernowneVerification {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String number = sc.nextLine();
        int result =0;
        switch (number) {
            case "1" : result = 1; break;
            case "12" : result = 2; break;
            case "123" : result = 3; break;
            case "1234" : result = 4; break;
            case "12345" : result = 5; break;
            case "123456" : result = 6; break;
            case "1234567" : result = 7; break;
            case "12345678" : result = 8; break;
            case "123456789" : result = 9; break;
            default: result = -1;
        }

        System.out.println(result);

    }
}
