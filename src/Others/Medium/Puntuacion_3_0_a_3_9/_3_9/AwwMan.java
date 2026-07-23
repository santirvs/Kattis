package Others.Medium.Puntuacion_3_0_a_3_9._3_9;

import java.util.Scanner;


/**
 * Controlar los instantes de despertar, inicio de picar, duracion y vuelta (el mismo tiempo que la ida)
 * Todos los instantes deben ser módulo duración del dia
 *
 */
public class AwwMan {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numCasos = sc.nextInt();

        while (numCasos-- > 0) {
            long duracionDia = sc.nextLong();
            long duracionNoche = sc.nextLong();
            long instanteInicioNoche = duracionDia - duracionNoche + 1;

            long instanteDespertar = sc.nextLong();
            long instanteInicio = sc.nextLong();
            long duracion = sc.nextLong();

            long duracionTrayecto = instanteInicio - instanteDespertar;
            if (duracionTrayecto <0 ) duracionTrayecto = instanteInicio - instanteDespertar + duracionDia;

            //Sumar de una en una las duraciones para garantizar que no excedemos el rango del long
            long instanteLlegadaCasa = instanteInicio;                                              //Ida, empieza a picar
            instanteLlegadaCasa = (instanteLlegadaCasa + duracion) % duracionDia;                    //Acabo de picar
            instanteLlegadaCasa = (instanteLlegadaCasa + duracionTrayecto) % duracionDia;            //llego a casa

            if (instanteLlegadaCasa >= instanteInicioNoche) System.out.println("NO");
            else System.out.println("YES");

        }

    }
}