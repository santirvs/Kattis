package Cap1._2_ProblemasAdHoc._7_VidaReal_Dificiles;


import java.util.Locale;
import java.util.Scanner;

public class Tenis {


        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            scan.useLocale(Locale.ENGLISH);

            //Lectura de los datos del caso
            String jugador1 = scan.next();
            String jugador2 = scan.next();


            //Cantidad de partidos
            int numPartidos = scan.nextInt();
            scan.nextLine();
            while (numPartidos>0) {
                String[] resultados = scan.nextLine().split(" ");
                boolean correcto = true;
                int juegosJug1 = 0;
                int juegosJug2 = 0;

                //Revisar cada juego
                for (int i=0; i<resultados.length;i++) {
                    int puntosJug1 = Integer.parseInt(resultados[i].split(":")[0]);
                    int puntosJug2 = Integer.parseInt(resultados[i].split(":")[1]);

                    //Con las condiciones dadas, no se puede llegar al cuarto set
                    if (i>2) correcto=false;

                    //Si un jugador ha ganado 2 sets, no se pueden jugar más juegos
                    if (juegosJug1==2 || juegosJug2==2) {
                        correcto = false;
                    }

                    //Comprobamos que los puntos sean correctos
                    if (Math.abs(puntosJug1-puntosJug2) < 2) {
                        //No se ha llegado a la diferencia de 2 juegos
                        //Esto solo es posible si se llega a 6-6 y no es el tercer set
                        if (i<2 && !((puntosJug1 == 7 && puntosJug2 == 6) || (puntosJug1 == 6 && puntosJug2 == 7))) {
                            correcto = false;
                        } else if (i==2)
                            correcto = false;
                    }

                    if (i<2 && (puntosJug1 > 7 || puntosJug2 > 7)) {
                        //No se pueden superar los 7 juegos en los 2 primeros sets
                        correcto = false;
                    }

                    if (i<2 && puntosJug1 == 7 || puntosJug2 == 7) {
                        //Si se llega a 7 juegos, la diferencia no puede superar los 2 juegos
                        correcto = correcto && (Math.abs(puntosJug1-puntosJug2) <= 2);
                    }

                    if (puntosJug1 < 6 && puntosJug2 < 6) {
                        //No se pueden haber ganado menos de 6 juegos
                        correcto = false;
                    }

                    //Sumamos los juegos al vencedor
                    if (puntosJug1 > puntosJug2)
                        juegosJug1++;
                    else if (puntosJug2 > puntosJug1)
                        juegosJug2++;

                }

                //Revisar el partido
                if (!(juegosJug1 == 2 || juegosJug2 == 2)) {
                    correcto = false;
                }

                //Revisar si federer ha perdido algun set
                if ((jugador1.equals("federer") && juegosJug2 > 0) || (jugador2.equals("federer") && juegosJug1 > 0)) {
                    correcto = false;
                }

                //Mostrar el resultado
                if (correcto)
                    System.out.println("da");
                else
                    System.out.println("ne");

                numPartidos--;
            }

     }

}
