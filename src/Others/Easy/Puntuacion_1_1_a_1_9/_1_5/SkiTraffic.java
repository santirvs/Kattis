package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer los datos, multiplicar el tiempo ideal si se cumplen las condiciones,
// presentar los resultados en formato HH:MM

import java.util.Scanner;


public class SkiTraffic {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //El caso és único y consta de 6 línieas
        //Linea1 :: Nombre de la montaña. Se ignora
        sc.nextLine();
        //Linea2 :: Tiempo en condiciones perfectas HHH:MM
        String[] tiempo = sc.nextLine().split(":");
        int minutos = Integer.parseInt(tiempo[0])*60 + Integer.parseInt(tiempo[1]);
        //Linea3 :: Dia de la semana. Sólo nos interesa saber si es fin de semana
        String diaSemana = sc.nextLine();
        boolean esFinDeSemana = diaSemana.equals("sat") || diaSemana.equals("sun");
        //Linea4 :: 1 -> mal tiempo
        boolean malTiempo = sc.nextInt() == 1;
        //Linea5 :: 1 -> nevada reciente
        boolean nevadaReciente = sc.nextInt() == 1;
        //Linea6 :: 1 -> es festivo
        boolean esFestivo = sc.nextInt() == 1;

        if (esFinDeSemana) minutos *=2;
        if (malTiempo) minutos *= 2;
        if (nevadaReciente) minutos *=3;
        if (esFestivo) minutos *=3;

        //Mostrar el tiempo final en HHH:MM
        System.out.printf("%d:%02d\n",minutos/60 ,minutos%60);

        sc.close();
    }
}

