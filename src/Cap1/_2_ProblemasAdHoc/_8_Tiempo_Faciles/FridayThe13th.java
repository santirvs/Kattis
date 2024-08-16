package Cap1._2_ProblemasAdHoc._8_Tiempo_Faciles;


import java.util.Locale;
import java.util.Scanner;

public class FridayThe13th {

        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            scan.useLocale(Locale.ENGLISH);

            //Lectura de los datos del caso
            int numCasos = scan.nextInt();

            for (int i = 0; i < numCasos; i++) {
                int numDiasAnyo = scan.nextInt();
                int numMeses = scan.nextInt();
                int[] dias = new int[numMeses];
                //Leer los días de cada mes
                for (int j = 0; j < numMeses; j++) {
                    dias[j] = scan.nextInt();
                }
                //Calcular la cantidad de viernes 13
                //Cada año empieza en domingo, por lo que si el mes empieza en domingo y tiene más de 12 días, habrá un viernes 13
                int numViernes13 = 0;
                int diaInicioMes = 0;
                for (int j = 0; j < numMeses; j++) {
                    if (dias[j] >= 13 && diaInicioMes == 0)
                        numViernes13++;
                    diaInicioMes = (diaInicioMes + dias[j]) % 7;
                }

                //Mostrar el resultado
                System.out.println(numViernes13);
            }
        }

}
