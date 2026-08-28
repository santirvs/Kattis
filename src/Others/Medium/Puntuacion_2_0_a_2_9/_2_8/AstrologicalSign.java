package Others.Medium.Puntuacion_2_0_a_2_9._2_8;

/**
 * Poca cosa tiene este problema...
 * Leer la fecha y clasificarla según el signo
 * Empezar por el mes ya que cada mes tiene dos signos posibles según el día
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AstrologicalSign {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int numCasos = sc.nextInt();

        while (numCasos-- > 0) {
            int dia = sc.nextInt();
            String mes = sc.next();

            String result ;

            switch (mes) {
                case "Jan" : result = dia >= 21 ? "Aquarius" : "Capricorn"; break;
                case "Feb" : result = dia >= 20 ? "Pisces" : "Aquarius"; break;
                case "Mar" : result = dia >= 21 ? "Aries" : "Pisces"; break;
                case "Apr" : result = dia >= 21 ? "Taurus" : "Aries"; break;
                case "May" : result = dia >= 21 ? "Gemini" : "Taurus"; break;
                case "Jun" : result = dia >= 22 ? "Cancer" : "Gemini"; break;
                case "Jul" : result = dia >= 23 ? "Leo" : "Cancer"; break;
                case "Aug" : result = dia >= 23 ? "Virgo" : "Leo"; break;
                case "Sep" : result = dia >= 22 ? "Libra" : "Virgo"; break;
                case "Oct" : result = dia >= 23 ? "Scorpio" : "Libra"; break;
                case "Nov" : result = dia >= 23 ? "Sagittarius" : "Scorpio"; break;
                case "Dec" : result = dia >= 22 ? "Capricorn" : "Sagittarius"; break;
                default: result = "Error";
            }

            System.out.println(result);
        }
    }
}