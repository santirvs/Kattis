package Cap1._2_ProblemasAdHoc._7_VidaReal_Dificiles;


import java.util.Locale;
import java.util.Scanner;

public class BungeeJumping_WA {

        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            scan.useLocale(Locale.ENGLISH);

            //Leer los datos
            double cuerda_K = scan.nextDouble();
            double longitud_l = scan.nextDouble();
            double altura_s = scan.nextDouble();
            double peso_w = scan.nextDouble();

            while (cuerda_K!=0 || longitud_l!=0 || altura_s!=0 || peso_w!=0) {

                //Calcular la expansión de la cuerda en el momento en que se detiene
                //La cuerda se expande hasta que la fuerza de la cuerda iguala la fuerza con la que cae
                double delta_L = 9.81 * peso_w / cuerda_K;

                //Calcular la altura a la que se detiene (longitud de la cuerda + expansión)
                double altura = longitud_l + delta_L;

                //Calcular la velocidad a la que llega al suelo
                double velocidad = Math.sqrt(2 * 9.81 * altura);

                //Casos posibles
                //1.- El punto de rebote no llega al suelo
                //1 a.- La cuerda no se expande lo suficiente y se queda suspendido en el aire
                if (altura_s > altura) {
                    System.out.println("Stuck in the air.");
                }
                //1 b.- La cuerda se expande lo suficiente y llega al suelo a una velocidad inferior a 10 m/s
                else if (velocidad < 10) {
                    System.out.println("James Bond survives.");
                }
                else
                    System.out.println("Killed by the impact.");

                //Leer los datos
                cuerda_K = scan.nextDouble();
                longitud_l = scan.nextDouble();
                altura_s = scan.nextDouble();
                peso_w = scan.nextDouble();
            }


     }

}
