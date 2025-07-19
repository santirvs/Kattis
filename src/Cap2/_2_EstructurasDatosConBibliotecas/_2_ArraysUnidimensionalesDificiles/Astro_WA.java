package Cap2._2_EstructurasDatosConBibliotecas._2_ArraysUnidimensionalesDificiles;

import java.util.Locale;
import java.util.Scanner;

public class Astro_WA {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        String[] diasSemana = {"Saturday", "Sunday","Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        //Leer la entrada
        String[] horaEstrella1 = scan.nextLine().split(":");
        String[] horaEstrella2 = scan.nextLine().split(":");;
        String[] frecuenciaEstrella1= scan.nextLine().split(":");;
        String[] frecuenciaEstrella2 = scan.nextLine().split(":");;

        //Definir los arrays
        int[] calendario = new int[60*24*7];

        int estrella1 = Integer.parseInt(horaEstrella1[0])*60 + Integer.parseInt(horaEstrella1[1]);
        int frecuencia1 = Integer.parseInt(frecuenciaEstrella1[0])*60 + Integer.parseInt(frecuenciaEstrella1[1]);
        int estrella2 = Integer.parseInt(horaEstrella2[0])*60 + Integer.parseInt(horaEstrella2[1]);
        int frecuencia2 = Integer.parseInt(frecuenciaEstrella2[0])*60 + Integer.parseInt(frecuenciaEstrella2[1]);
        boolean coincidencia = false;

        //Llenar el calendario para la estrella 1
        while (calendario[estrella1] == 0) {
            calendario[estrella1] = 1;
            estrella1 = (estrella1 + frecuencia1) % (60*24*7);
        }

        //Llenar el calendario para la estrella 2
        while ((calendario[estrella2] & 2) == 0 && !coincidencia) {
            if (calendario[estrella2] == 1) {
                coincidencia = true;
            } else {
                calendario[estrella2] = calendario[estrella2] + 2;
                estrella2 = (estrella2 + frecuencia2) % (60 * 24 * 7);
            }
        }

        if (!coincidencia) {
            System.out.println("Never");
        } else {
            int dia = estrella2 / (60 * 24);
            int hora = (estrella2 % (60 * 24)) / 60;
            int minuto = estrella2 % 60;
            System.out.println(diasSemana[dia]);
            System.out.println((hora < 10? "0"+hora : hora) + ":" + (minuto<10? "0"+minuto : minuto));
        }

    }
}
