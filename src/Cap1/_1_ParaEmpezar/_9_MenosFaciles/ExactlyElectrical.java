package Cap1._1_ParaEmpezar._9_MenosFaciles;

import java.util.Locale;
import java.util.Scanner;

public class ExactlyElectrical {

   public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Lectura de los datos del caso
        int avInicio = scan.nextInt();
        int calleInicio = scan.nextInt();
        int avFin = scan.nextInt();
        int calleFin = scan.nextInt();
        int carga = scan.nextInt();

        //calcular la carga necesaria entre las dos coordenadas
        int cargaNecesaria = Math.abs(avInicio - avFin) + Math.abs(calleInicio - calleFin);

        if (carga == cargaNecesaria)
            System.out.println("Y");
        else if (carga > cargaNecesaria && (carga - cargaNecesaria) % 2 == 0)
            //Puede hacer una U, por lo que puede ir gastando unidades sobrantes, eso sí, de dos en dos
            System.out.println("Y");
        else
            System.out.println("N");

    }
}
