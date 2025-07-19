package Cap2._2_EstructurasDatosConBibliotecas._10_Pila;

import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

//Crear las dos pilas: la pila1 recogerá los platos del camarero y la pila2 los platos que se van a lavar
//Los platos del camarero siempre se apilan en la pila1
//Los platos a lavar siempre se cogen de la pila 2
//En el momento que se necesite lavar un plato y la pila2 esté vacía, se cogen los platos de la pila1 y se pasan a la pila2

//Caso#2:RTE --> Puede ser que la pila2 inicialmente tenga platos, pero se necesiten coger más platos de los que hay en la pila2
//           --> Una vez vacía la pila2, deben traspasarse todos los platos de la pila 1 a la pila 2 y continuar
//           --> AC


public class Restaurant {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numOrders = scan.nextInt();
        boolean primero = true;
        while (numOrders!=0) {
            if (!primero) System.out.println("");
            else primero = false;

            scan.nextLine();

            //Crear las pilas
            Stack<Integer> pila1 = new Stack<>();
            Stack<Integer> pila2 = new Stack<>();

            //Procesar las ordenes
            for (int i = 0; i < numOrders; i++) {
                String[] orden = scan.nextLine().split(" ");
                int cantidad = Integer.parseInt(orden[1]);
                if (orden[0].equals("TAKE")) {
                    int totalPlatos = 0;
                    while (totalPlatos<cantidad) {
                        //Tomar los platos de la pila2
                        if (pila2.isEmpty()) {
                            //Si está vacía, se pasan los platos de la pila 1 a la pila 2
                            int sumaPlatos = 0;
                            while (!pila1.isEmpty()) {
                                pila2.push(pila1.pop());
                                sumaPlatos += pila2.peek();
                            }
                            System.out.println("MOVE 1->2 " + sumaPlatos);
                        }
                        //Tomar los platos de la pila2
                        while (!pila2.isEmpty() && totalPlatos < cantidad) {
                            totalPlatos += pila2.peek();
                            pila2.pop();
                        }
                        if (totalPlatos<cantidad) {
                            System.out.println("TAKE 2 " + totalPlatos);
                            cantidad -= totalPlatos;
                            totalPlatos = 0;
                        }
                    }
                    System.out.println("TAKE 2 " + cantidad);
                    //Si se han cogido más platos de los necesarios, habrá que devolverlos a la pila 2
                    if (cantidad < totalPlatos) {
                        pila2.push(totalPlatos-cantidad);
                    }
                }
                else if (orden[0].equals("DROP")) {
                    //Dejar los platos en la pila1
                    pila1.push(cantidad);
                    System.out.println("DROP 1 " + cantidad);
                }
            }

            //Siguiente caso
            numOrders = scan.nextInt();
        }

    }

}
