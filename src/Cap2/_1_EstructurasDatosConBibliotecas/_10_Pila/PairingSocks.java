package Cap2._1_EstructurasDatosConBibliotecas._10_Pila;

import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

public class PairingSocks {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numCalcetines = scan.nextInt()*2;

        //Creamos la pila auxiliar
        //La pila principal no es necesaria ya que viene del teclado y nunca necesitaremos devolver un calcetín a la pila original
        //No es necesario contar los movimientos. Si la pila está vacía se habrán hecho 2*n movimientos
        //Si la pila no está vacía, será imposible emparejar los calcetines
        Stack<Integer> aux = new Stack<>();

        for (int i=0; i<numCalcetines; i++) {
            int calcetin = scan.nextInt();
            //No se puede emparejar el calcetín actual con el top de la pila auxiliar (está vacía)
            if (aux.isEmpty()) {
                aux.push(calcetin);
            }
            else {
                //Si el calcetín actual es par con el top de la pila auxiliar, se emparejan
                if (aux.peek() == calcetin) {
                    aux.pop();
                }
                else {
                    //Si no se emparejan, se añade el calcetín a la pila auxiliar
                    aux.push(calcetin);
                }
            }
        }

        //Mostrar el resultado dependiendo de si la pila auxiliar ha quedado vacía o no
        if (aux.isEmpty()) {
            System.out.println(numCalcetines);
        }
        else {
            System.out.println("impossible");
        }
    }

}
