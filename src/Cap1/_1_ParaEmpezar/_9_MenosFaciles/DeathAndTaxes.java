package Cap1._1_ParaEmpezar._9_MenosFaciles;

import java.util.Locale;
import java.util.Scanner;

public class DeathAndTaxes {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Hasta que no se muera hay que ir leyendo las transacciones realizadas
        String transaccion = scan.next();
        int x = scan.nextInt();
        int numAcciones = 0;
        double precioMedio = 0;

        while (!transaccion.equals("die")) {
            switch(transaccion) {
                case "buy":
                    //actualizar el precio medio y el total de acciones
                    int y = scan.nextInt();
                    precioMedio = (precioMedio * numAcciones + x * y) / (numAcciones + x);
                    numAcciones += x;
                    break;
                case "sell":
                    //actualizar el total de acciones. El precio medio no cambia.
                    scan.nextInt();  //El precio de venta es irrelevante
                    numAcciones -=x;
                    break;
                case "split":
                    //se multiplican las acciones por x
                    //se divide el precio medio entre x
                    numAcciones *= x;
                    precioMedio /= x;
                    break;
                case "merge":
                    //se dividen las acciones por x. Si no es exacto, se redondea hacia abajo
                    //y se obliga a vender esas acciones
                    //se multiplican el precio medio por x
                    numAcciones /= x;
                    precioMedio *= x;
                    break;
            }

            //Siguiente transaccion
            transaccion = scan.next();
            x = scan.nextInt();
        }

        //Mostrar el resultado
        double beneficio = x - precioMedio;
        double impuestos = 0;
        if (beneficio > 0)
            impuestos = beneficio * 0.3;
        else
            impuestos = 0;

        System.out.println( numAcciones * (x - impuestos) );

    }
}

