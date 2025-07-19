package Cap2._2_EstructurasDatosConBibliotecas._2_ArraysUnidimensionalesDificiles;

import java.util.Locale;
import java.util.Scanner;
public class BumperToBumperTraffic_WA {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int coche1 = scan.nextInt();
        int coche2 = scan.nextInt();

        //CocheDelante tiene la parte trasera del coche que va delante
        //CocheDetras tiene la parte delantera del coche que va detrás
        int cocheDelante = Math.max(coche1, coche2);
        int cocheDetras = Math.min(coche1, coche2) + 4;  //El coche mide 4.4m

        int movs = scan.nextInt();
        int[] movs1 = new int[movs+1];
        movs1[movs] = 2_000_000;
        for (int i=0; i<movs; i++) {
            movs1[i] = scan.nextInt();
        }
        movs = scan.nextInt();
        int[] movs2 = new int[movs+1];
        movs2[movs] = 2_000_000;
        for (int i=0; i<movs; i++) {
            movs2[i] = scan.nextInt();
        }

        //Asignar los movimientos al coche correspondiente
        int[] movsDelante;
        int[] movsDetras;
        if (cocheDelante == coche1) {
            movsDelante = movs1;
            movsDetras = movs2;
        }
        else {
            movsDelante = movs2;
            movsDetras = movs1;
        }

        //Recorrer los movimientos y calcular las posiciones
        int indexDelante = 0;
        int indexDetras = 0;
        boolean enMovimientoDelante = false;
        boolean enMovimientoDetras = false;
        boolean chocados = false;
        int tiempo = 0;
        while (indexDetras < movsDetras.length && indexDelante < movsDelante.length && !chocados) {
            int tiempoSiguiente = Math.min(movsDelante[indexDelante],movsDetras[indexDetras]);
            //Avanza los coches
            if (enMovimientoDelante) {
                cocheDelante += tiempoSiguiente - tiempo;
            }
            if (enMovimientoDetras) {
                cocheDetras += tiempoSiguiente - tiempo;
            }
            //Ha habido alcance?
            if (cocheDetras >= cocheDelante) {
                chocados=true;
                tiempo = tiempoSiguiente - (cocheDetras - cocheDelante);
            }
            //Para o arranca el coche de delante
            if (movsDelante[indexDelante] == tiempoSiguiente) {
                indexDelante++;
                enMovimientoDelante = !enMovimientoDelante;
            }
            //Para o arranca el coche de atras
            if (movsDetras[indexDetras] == tiempoSiguiente) {
                indexDetras++;
                enMovimientoDetras = !enMovimientoDetras;
            }
            if (!chocados)
                tiempo = tiempoSiguiente;
        }


        //Muestra el resultado
        if (chocados)
            System.out.println("bumper tap at time " + tiempo);
        else
            System.out.println("safe and sound");

    }

}


/*
'''
Kattis - traffic
One of those annoying implementation issues
I tried to do it the legit O(n) method but it was annoying. So heres a simulation that is O(max t) but still ACs
Time: O(max t), Mem: O(n)
'''
xs = list(map(int, input().split()))
t1s = map(int, input().split())
t2s = map(int, input().split())
x1 = xs[0]
x2 = xs[1]
if (x1 > x2):
    x1, x2 = x2, x1
    t1s, t2s = t2s, t1s

t1s = list(t1s)[1:]
t2s = list(t2s)[1:]

pos = x2 - x1 - 4
t1 = len(t1s)
t2 = len(t2s)
i1, i2 = 0, 0
moving1, moving2 = False, False
t = 0
while t <= 3e6:
    if i1 < t1 and t1s[i1] == t:
        moving1 = not moving1
        i1 += 1
    if i2 < t2 and t2s[i2] == t:
        moving2 = not moving2
        i2 += 1
    if moving1:
        pos -= 1
    if moving2:
        pos += 1

    if pos <= 0:
        print('bumper tap at time {}'.format(t+1))
        exit()

    t += 1
print('safe and sound')
 */


