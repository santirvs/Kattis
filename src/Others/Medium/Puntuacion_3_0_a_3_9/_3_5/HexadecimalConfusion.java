package Others.Medium.Puntuacion_3_0_a_3_9._3_5;

//Para cada digito que leamos, buscar sus mínimo (cambiar Bs por 8s y Ds por 0s)
// y sus máximos (cambiar 8s por Bs y 0s por Ds)
// Acumular por separado los máximos y los mínimos

import java.util.Scanner;

public class HexadecimalConfusion {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int sumaMaxima = 0;
        int sumaMinima = 0;

        int numValores = scan.nextInt();
        while (numValores-- > 0) {
            String num = scan.next();
            String max = num.replace('8','B').replace('0','D');
            //Caso especial, si max empieza por '0' debe ser una D
            if (max.startsWith("0")) {
                max = "D" + max.substring(1);
            }
            String min = num.replace('B','8').replace('D','0');
            //Caso especial si min empieza por 0 --> será siempre una D
            //excepto si es 0 que se representa como 0
            if (min.startsWith("0") && min.length()>1) {
                min = "D" + min.substring(1);
            }

            sumaMinima += Integer.parseInt(min, 16);
            sumaMaxima += Integer.parseInt(max, 16);

            //System.out.println("MIN: " + min + " --  MAX: " + max);
        }

        //Mostrar el resultado
        System.out.println(Integer.toHexString(sumaMaxima).toUpperCase());
        System.out.println(Integer.toHexString(sumaMinima).toUpperCase());

        scan.close();
    }
}