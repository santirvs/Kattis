package Cap3._3_DivideYVenceras._2_BiseccionBSTAFaciles;

// Estrategia de D&C. Bisección binaria

// Buscar la cantidad mínima y máxima de lluvia que puede causar una altura de agua h en un tanque con fugas.
// Se puede aplicar una búsqueda binaria sobre la cantidad de lluvia, desde 0 hasta un número máximo.

// Dibujar la gráfica de la altura del agua a lo largo del tiempo para entender el problema.
// Considerar tres casos: h < l, h == l y h > l
// Observe que si h < l, no habrán habido fugas.
// Si h > l, el agua sigue goteando desde que dejó de llover. Añadir la cantidad de agua que se pierde por la fuga al total de lluvia.
// Si h == l, el agua ha dejado de gotear en algún momento. Buscar la cantidad mínima y máxima de lluvia que puede causar una altura de agua h en un tanque con fugas.


import java.io.*;
import java.util.*;

public class RainFall2 {

    static double alturaFuga, velocidadFuga, duracionLluvia, tiempoHastaLectura, lectura;
    static final double EPS = 1e-9;

    // Función que calcula la altura del agua dado un valor de lluvia (rainfall)
    static double height(double rainfall) {
        double fallrate = rainfall / duracionLluvia;      // tasa de caída de lluvia
        double timeToLeak = alturaFuga / fallrate;           // tiempo en alcanzar altura l
        double leakTime = tiempoHastaLectura + (duracionLluvia - timeToLeak); // tiempo total de fuga
        double leakVol = leakTime * velocidadFuga;              // volumen perdido por fugas
        return rainfall - leakVol;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        // Lectura de los datos
        alturaFuga = sc.nextDouble();
        velocidadFuga = sc.nextDouble();
        duracionLluvia = sc.nextDouble();
        tiempoHastaLectura = sc.nextDouble();
        lectura = sc.nextDouble();

        // Caso sin fugas
        if (lectura + EPS < alturaFuga) {
            System.out.printf("%.10f %.10f%n", lectura, lectura);
            return;
        }

        // Casos con fugas
        // Búsqueda binaria para encontrar la cantidad mínima y máxima de lluvia
        double le = lectura, ri = 1e9;
        for (int i = 0; i < 100; i++) {  // Binary search. 100 iteraciones son suficientes para precisión de 1e-9
            double mid = (le + ri) / 2.0;
            if (height(mid) < lectura) {
                le = mid;
            } else {
                ri = mid;
            }
        }

        // Mostrar el resultado
        // Si la lectura es mayor que la altura de fuga, el rango es [le, le]
        // Si la lectura es igual a la altura de fuga, el rango es [alturaFuga, le]
        // Si la lectura es menor, es el caso sin fugas ya tratado
        if (lectura > alturaFuga + EPS) {
            System.out.printf("%.10f %.10f%n", le, le);
        } else {
            System.out.printf("%.10f %.10f%n", alturaFuga, ri);
        }
    }
}
