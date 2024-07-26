package Cap1._1_ParaEmpezar._9_MenosFaciles;

import java.util.Locale;
import java.util.Scanner;

public class ClimbingStairs {

   public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Leer las restricciones
       int pasosNecesarios = scan.nextInt();
       int pasosRegistrationDesk = scan.nextInt();
       int pasosOficina = scan.nextInt();

       //Calcular los pasos necesarios
       //Si los pasosNecesarios son mayores que los pasos de la oficina y que los pasos de la registration desk
       // entonces hacemos el recorrido hasta completar los pasos necesarios y de allí vamos a la calle
       if (pasosNecesarios >= pasosOficina && pasosNecesarios >= pasosRegistrationDesk) {
              pasosNecesarios += pasosRegistrationDesk;
       }
       //Si los pasosNecesarios son menores que los pasos de la oficina pero mayores que los pasos de la registration desk
       // entonces hacemos el recorrido hasta llegar a la registration desk y de allí vamos a la calle
       else if (pasosNecesarios < pasosOficina && pasosNecesarios >= pasosRegistrationDesk) {
              pasosNecesarios = 2 * pasosOficina;
       }
       // Si los pasosNecesarios son menores que los pasos de la oficina pero mayores que los pasos de la registration desk
       // entonces hacemos el recorrido hasta llegar a la oficina y de allí vamos a la calle. Por el camino ya habremos hecho el registro
       else if (pasosNecesarios >= pasosOficina && pasosNecesarios < pasosRegistrationDesk) {
              pasosNecesarios = 2 *  pasosRegistrationDesk;
       }
       // Si los pasosNecesarios son menores que los pasos de la oficina y que los pasos de la registration desk
       // entonces hacemos el recorrido hasta el mayor de los valores entre oficina y registration desk
        else {
              pasosNecesarios = 2*Math.max(pasosOficina, pasosRegistrationDesk);
        }

        //El número de pasos de escalera debe ser par (todo lo que se sube, hay que bajarlo... )
        if (pasosNecesarios % 2 != 0)
            pasosNecesarios++;
        

        //Mostrar el resultado
        System.out.println(pasosNecesarios);

    }
}
