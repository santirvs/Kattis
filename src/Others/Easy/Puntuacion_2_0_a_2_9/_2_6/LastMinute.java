package Others.Easy.Puntuacion_2_0_a_2_9._2_6;

import java.util.Scanner;

public class LastMinute {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long temasUnicos = sc.nextLong();
        long metodosUnicos = sc.nextLong();
        long temasReutilizables = sc.nextLong();
        long metodosReutilizables = sc.nextLong();

        long resultado = 0;
        // Todo depende de los temas y métodos reutilizables
        // Caso 1: Existen temas y métodos reutilizables
        // Se combinan temas y métodos reutilizables y se suman temas y métodos únicos
        if (temasReutilizables > 0 && metodosReutilizables > 0) {
            resultado = (temasReutilizables*metodosReutilizables)+temasUnicos+metodosUnicos;
        }

        //Caso 2: Sólo hay temas reutilizables
        //Se combinan los temas reutilizables con los métodos de uso único
        else if (temasReutilizables > 0 && metodosReutilizables == 0)  {
            resultado = metodosUnicos;
        }

        //Caso 3: Sólo hay métodos reutilizables
        //Cada método reutilizable puede usarse con cada uno de los temas únicos
        else if (temasReutilizables == 0 && metodosReutilizables > 0) {
            resultado = temasUnicos;
        }

        //Caso 4: No hay elementos reutilizables
        //Cada método reutilizable puede usarse con cada uno de los temas únicos
        else if (temasReutilizables == 0 && metodosReutilizables == 0) {
            resultado = Math.min(temasUnicos, metodosUnicos);
        }


        System.out.println(resultado);


        sc.close();
    }
}
