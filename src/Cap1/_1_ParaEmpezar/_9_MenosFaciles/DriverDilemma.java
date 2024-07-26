package Cap1._1_ParaEmpezar._9_MenosFaciles;

import java.util.Locale;
import java.util.Scanner;

public class DriverDilemma {

   public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Lectura de los datos del caso
       double capacidad = scan.nextDouble()/2;  //galones de capacidad del tanque, que se encuentra a la mitad
       double perdida = scan.nextDouble();    //ratio de perdida en galones / hora
       double distancia = scan.nextDouble();  //millas por galon

       int velocidadMaxima = 0;
       boolean encontrado = false;
       //Lectura de la tabla
        for (int i=1; i <=6; i++) {
            int velocidad = scan.nextInt();
            double tiempo = distancia / velocidad;  //tiempo para llegar a la siguiente gasolinera a la velocidad indicada
            double perdidaTotal = tiempo * perdida; //perdida de gasolina en el trayecto
            double capacidadRestante = capacidad - perdidaTotal;  //galones disponibles no perdidos
            double mpg = scan.nextDouble();   //Rendimiento (millas por galon) a la velocidad indicada
            double distanciaMaxima = capacidadRestante * mpg;  //distancia que se puede recorrer con la gasolina restante
            if (distanciaMaxima > distancia) {
                encontrado = true;
                velocidadMaxima = velocidad;
            }
        }

        if (encontrado) {
            System.out.println("YES " + velocidadMaxima);
        } else {
            System.out.println("NO");
        }


    }
}
