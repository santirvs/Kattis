package Others.Easy.Puntuacion_2_0_a_2_9._2_1;

/*

https://open.kattis.com/problems/majstor
    Calcular la puntución es fácil,
    pero hay que hacer un conteo de frecuencias de las tiradas de los compañeros
    para estimar la máxima puntuación
 */


import java.util.Scanner;

public class Majstor {
    final static int PIEDRA = 0;
    final static int PAPEL = 1;
    final static int TIJERA = 2;
    final static char cPIEDRA = 'R';
    final static char cPAPEL = 'P';
    final static char cTIJERA = 'S';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Leer los datos
        int numRondas = sc.nextInt();
        String tiradas = sc.next();

        //Leer las tiradas de los amigos
        int numAmigos = sc.nextInt();
        String[] amigos = new String[numAmigos];
        for (int i=0; i<numAmigos;i++) {
            amigos[i]= sc.next();
        }

        //Calcular la puntuación y la tabla de frecuencias
        int puntuacion = 0;
        int[][]frecuencias = new int[numRondas][3];
        for (int i=0; i<numAmigos;i++) {
            for (int p=0;p<numRondas;p++) {
                char miTirada = tiradas.charAt(p);
                char suTirada = amigos[i].charAt(p);
                switch(suTirada) {
                    case cPAPEL : frecuencias[p][PAPEL]++; break;
                    case cTIJERA : frecuencias[p][TIJERA]++; break;
                    case cPIEDRA : frecuencias[p][PIEDRA]++; break;
                }
                puntuacion += puntos(miTirada, suTirada);
            }
        }

        //Buscar la puntuación máxima posible
        int maxPuntuacion = 0;
        for (int i=0; i< numRondas; i++) {
            int puntosPiedra = 0;
            int puntosPapel = 0;
            int puntosTijera = 0;

            puntosPiedra = frecuencias[i][PIEDRA] + 2*frecuencias[i][TIJERA];
            puntosPapel = frecuencias[i][PAPEL] + 2*frecuencias[i][PIEDRA];
            puntosTijera = frecuencias[i][TIJERA] + 2*frecuencias[i][PAPEL];

            maxPuntuacion += Math.max(puntosPiedra, Math.max(puntosPapel, puntosTijera));
        }

        //Mostrar el resultado
        System.out.println(puntuacion);
        System.out.println(maxPuntuacion);

    }

    static int puntos(char miTirada, char suTirada) {
        int puntuacion = 0;
        if (miTirada == suTirada) {
            //Empate: 1 punto
            puntuacion+=1;
        } else if (miTirada == cPAPEL && suTirada == cPIEDRA ||
                miTirada == cPIEDRA && suTirada == cTIJERA ||
                miTirada == cTIJERA && suTirada == cPAPEL ) {
            //Gano yo: 2 puntos
            puntuacion+=2;
        } else {
            //Gana el otro: 0 puntos
        }
        return puntuacion;
    }
}

