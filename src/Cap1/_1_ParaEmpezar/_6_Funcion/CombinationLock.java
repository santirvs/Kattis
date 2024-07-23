package Cap1._1_ParaEmpezar._6_Funcion;

import java.util.*;

//El problema consiste en calcular el número de grados que se deben girar para abrir una cerradura de combinación
//con 4 números. La cerradura se abre girando a la derecha 2 vueltas completas y luego girando a la izquierda
//hasta el primer número. Luego se gira a la derecha hasta el segundo número y finalmente se gira a la izquierda
//hasta el tercer número. Se debe calcular el número de grados que se deben girar para abrir la cerradura.

//Hay que tener en cuenta que la cerradura tiene 40 posiciones y que cada número se encuentra en una posición
//determinada.

//Mirar bien la imagen del enunciado, ya que al girar el disco a la derecha, el número aumenta y al girar a la
//izquierda, el número disminuye. El puntero está fijo y lo que se mueve es el disco!!!

public class CombinationLock {

   public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        int posInicial = scan.nextInt();
        int pos1 = scan.nextInt();
        int pos2 = scan.nextInt();
        int pos3 = scan.nextInt();

        while (posInicial!=0 || pos1!=0 || pos2!=0 || pos3!=0) {

            int numGrados = 720+360; //2 vueltas iniciales más 1 vuelta entre el primer y el segundo numero
            int numGradosGiro = 0;
            int gradosPorDigito = 9;

            //Girar a la primera posición, sentido agujas del reloj
            numGradosGiro = (posInicial - pos1 + 40) % 40 * gradosPorDigito;
            numGrados += numGradosGiro;

            //Girar a la segunda posición, sentido antihorario
            numGradosGiro = (pos2 - pos1 + 40) % 40 * gradosPorDigito;
            numGrados += numGradosGiro;

            //Girar a la tercera posición, sentido agujas del reloj
            numGradosGiro = (pos2 - pos3 + 40) % 40 * gradosPorDigito;
            numGrados += numGradosGiro;

            System.out.println(numGrados);

            //Siguiente caso
            posInicial = scan.nextInt();
            pos1 = scan.nextInt();
            pos2 = scan.nextInt();
            pos3 = scan.nextInt();

        }

    }
}
