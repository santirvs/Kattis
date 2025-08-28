package Cap3._3_DivideYVenceras._3_BusquedaTernariaYOtros;

// Estrategia de D&C. Búsqueda ternaria y otros

// Aplicar trigonometría para resolver el problema de la tirolina
// La longitud mínima de la cuerda es igual a la hipotenusa del triángulo formado por
// la diferencia de altura de los dos soportes y la distancia horizontal entre ellos.
// La longitud máxima es aquella en la que la cuerda tiene la altura mínima permitida
// en su punto más bajo, que ocurre en el punto medio entre los dos soportes.
// Usando el teorema de Pitágoras, la longitud máxima de la cuerda
// es igual a la hipotenusa del triángulo formado por la mitad de la distancia
// horizontal entre los dos soportes y la diferencia entre la altura mínima permitida
// y la altura de los soportes.

// Aplicar búsqueda ternaria para minimizar la longitud máxima de la cuerda
// que se necesita para conectar dos soportes a diferentes alturas,
// variando la posición horizontal del punto medio de la cuerda.

// v1. WA en el caso de prueba 2
// v2. AC. Corregido. Hay que guardarse el resultado mínimo de la búsqueda ternaria en ambos casos.

import java.util.Scanner;

public class Zipline {

    public static double hipotenusa(double a, double b) {
        return Math.sqrt(a * a + b * b);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Lectura del número de casos de prueba
        int numCasos = scan.nextInt();
        for (int caso = 0; caso < numCasos; caso++) {
            //Cada caso es independiente.
            //Leer los datos del caso
            double distanciaHorizontal = scan.nextDouble();
            double alturaSoporte1 = scan.nextDouble();
            double alturaSoporte2 = scan.nextDouble();
            double alturaMinima = scan.nextDouble();

            //Calcular la longitud mínima de la cuerda
            double deltaAltura = Math.abs(alturaSoporte1 - alturaSoporte2);
            double longitudMinima = hipotenusa(distanciaHorizontal, deltaAltura);
            //Imprimir la longitud mínima
            System.out.printf("%.6f ", longitudMinima);

            //Búsqueda ternaria para calcular la posición del punto medio
            //que minimiza la longitud máxima de la cuerda
            double lo = 0, hi = distanciaHorizontal;
            //Recalcular la altura de los soportes para que el punto más bajo esté a alturaMinima
            alturaSoporte1 -= alturaMinima;
            alturaSoporte2 -= alturaMinima;
            double resultado = Double.MAX_VALUE;
            for (int iter = 0; iter < 100; iter++) { // 100 iteraciones son suficientes para precisión de 10^-6
                double mid1 = lo + (hi - lo) / 3.0;
                double mid2 = hi - (hi - lo) / 3.0;
                double longitud1 = hipotenusa(mid1,alturaSoporte1) + hipotenusa(distanciaHorizontal-mid1, alturaSoporte2);
                double longitud2 = hipotenusa(mid2,alturaSoporte1) + hipotenusa(distanciaHorizontal-mid2, alturaSoporte2);
                if (longitud1 < longitud2) {
                    resultado = Math.min(resultado, longitud1);
                    hi = mid2;
                } else {
                    resultado = Math.min(resultado, longitud2);
                    lo = mid1;
                }
            }

            //Imprimir la longitud minima
            System.out.printf("%.8f\n", resultado);
        }
    }

}
