package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._1_ColaDePrioridad;

// Usar una cola con prioridad para recorrer el patrón de malabarismo
// Cada mano tiene una cola de instantes de tiempo en los que se lanza la pelota
// En cada instante de tiempo, sólo se puede lanzar una pelota con la misma mano. Si cae una segunda pelota
// en el mismo instante de tiempo y en la misma mano, ese patrón no es válido
// El patrón debe repetirse en un ciclo de duración mcm(suma lanzamientos_pares, suma lanzamientos_impares)

// Caso #2 --> WA --> Adapto la solución de https://github.com/BrandonTang89/Competitive_Programming_4_Solutions/blob/main/Chapter_2_Data_Structures/Non-Linear_DS_with_Built-in_Libraries/kattis_jugglingpatterns.cpp
//                -->

import java.util.PriorityQueue;
import java.util.Scanner;

public class JugglingPatterns_WA {

    public static int mcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return mcd(b, a % b);
    }

    public static int mcm(int a, int b) {
        int a2 = Math.max(a, b);
        int b2 = Math.min(a,b);
        if (b2 == 0) return a2;
        else return a2*b2/mcd(a2, b2);
    }

    public static void main(String[] args) throws Exception {
       Scanner scan = new Scanner(System.in);

        //Lectura de datos
        while (scan.hasNext()) {
            char[] lanzamientos = scan.nextLine().toCharArray();

            int sumaPares = 0;
            int sumaImpares = 0;
            int numBolasPatron = 0;

            PriorityQueue<Integer> bolasManoIzquierda = new PriorityQueue<>();
            PriorityQueue<Integer> bolasManoDerecha = new PriorityQueue<>();

            for (int i = 0; i < lanzamientos.length; i++) {
                if (('0' - lanzamientos[i]) % 2 == 0) {
                    sumaPares += (lanzamientos[i] - '0');
                } else {
                    sumaImpares += (lanzamientos[i] - '0');
                }

                numBolasPatron++;
            }

            //Revisar si el número de bolas es válido
            if ((sumaPares + sumaImpares) % numBolasPatron != 0) {
                System.out.println(new String(lanzamientos) + ": invalid # of balls");
                continue;
            }

            int numBolas = (sumaPares + sumaImpares) / numBolasPatron;

            //Repartir las bolas inicialmente entre la mano derecha y la mano izquierda
            for (int i = 0; i < numBolas && i < numBolasPatron; i++) {
                if (i % 2 == 0) {
                    bolasManoIzquierda.add(i);
                } else {
                    bolasManoDerecha.add(i);
                }
            }

            //Revisar si el patrón es válido
            int mcm = mcm(sumaPares, sumaImpares);
            //System.out.println("El mcm del patrón es: " + mcm + " sumaPares: " + sumaPares + " sumaImpares: " + sumaImpares + " numBolas: " + numBolas);

            //Seguir el patrón mcm veces
            // Si en algún instante de tiempo en que se lanza una bola es menor que el que se indica en la cola --> no es válido
            // Es necesario comprobar que se repite el patrón????
            // Al final, si se ha lanzado una bola en cada instante de tiempo, el patrón es válido
            boolean valido = true;
            boolean izquierda = true;
            int tiempo = 0;
            int indexPatron = 0;
            while (tiempo<mcm && valido) {
                int lanzamiento = lanzamientos[indexPatron % lanzamientos.length] - '0';

                //No toca lanzar bola, se cambia de turno
                if (lanzamiento == 0) {
                    izquierda = !izquierda;
                    indexPatron++;
                }
                else {
                    //Turno de la mano izquierda
                    if (izquierda) {
                        //No llegan bolas a la mano izquierda...  el patrón no es válido
                        if (bolasManoIzquierda.isEmpty()) {
                            valido = false;
                            break;
                        }
                        //Llega la bola en el instante de tiempo que toca, es el momento de lanzarla
                        if (bolasManoIzquierda.peek() == tiempo) {
                            bolasManoIzquierda.poll();
                            //Si la siguiente bola llega en el mismo instante de tiempo, el patrón no es válido
                            if (!bolasManoIzquierda.isEmpty() && bolasManoIzquierda.peek() == tiempo) {
                                valido = false;
                                break;
                            }
                            //Si el lanzamiento es par, se lanza hacia la misma mano
                            if (lanzamiento % 2 == 0) {
                                bolasManoIzquierda.add(tiempo + lanzamiento);
                            } else {
                                //Si el lanzamiento es impar, se lanza hacia la otra mano
                                bolasManoDerecha.add(tiempo + lanzamiento);
                            }
                            //Se avanza el patron y se cambia de mano
                            indexPatron++;
                            izquierda = !izquierda;
                        }
                    } else {
                        //Es turno de la mano derecha
                        //No llegan bolas a la mano derecha...  el patrón no es válido
                        if (bolasManoDerecha.isEmpty()) {
                            valido = false;
                            break;
                        }
                        //Llega la bola en el instante de tiempo que toca, es el momento de lanzarla
                        if (bolasManoDerecha.peek() == tiempo) {
                            bolasManoDerecha.poll();
                            //Si la siguiente bola llega en el mismo instante de tiempo, el patrón no es válido
                            if (!bolasManoDerecha.isEmpty() && bolasManoDerecha.peek() == tiempo) {
                                valido = false;
                                break;
                            }
                            //Si el lanzamiento es par, se lanza hacia la misma mano
                            if (lanzamiento % 2 == 0) {
                                bolasManoDerecha.add(tiempo + lanzamiento);
                            } else {
                                //Si el lanzamiento es impar, se lanza hacia la otra mano
                                bolasManoIzquierda.add(tiempo + lanzamiento);
                            }
                            //Se avanza el patron y se cambia de mano
                            indexPatron++;
                            izquierda = !izquierda;
                        }
                    }

                }
                //Avanzar el tiempo
                tiempo++;
            }

            //Si se ha completado un ciclo (mcm) y se han lanzado todas las bolas, el patrón es válido
            if (valido) {
                System.out.println(new String(lanzamientos) + ": valid with " +  numBolas + " balls");
            } else {
                System.out.println(new String(lanzamientos) + ": invalid pattern");
            }
        }

    }
}

