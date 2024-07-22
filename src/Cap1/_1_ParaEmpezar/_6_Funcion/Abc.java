package Cap1._1_ParaEmpezar._6_Funcion;

import java.util.*;

public class Abc {

   public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer valores y ordenar
        List<Integer> valores = new ArrayList<Integer>();
        valores.add(scan.nextInt());
        valores.add(scan.nextInt());
        valores.add(scan.nextInt());
        scan.nextLine();
        Collections.sort(valores);

        //Mostrar según el orden leído
        String orden = scan.nextLine();
        for (int i = 0; i < orden.length(); i++) {
            if (i > 0) System.out.print(" ");
            if (orden.charAt(i) == 'A') {
                System.out.print(valores.get(0));
            }
            else if (orden.charAt(i) == 'B') {
                System.out.print(valores.get(1));
            }
            else {
                System.out.print(valores.get(2));
            }
        }
       System.out.println("");

    }
}
