package Cap2._2_EstructurasDatosConBibliotecas._10_Pila;

import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

//En lugar de ir movimiento y recalculando cada vez, se puedn ir guardando los movimientos en una pila
//Si se necesita deshacer un movimiento, se deshace el último movimiento
//Al final se suman los movimientos y se realiza el módulo entre el número de niños

public class GameOfThrowns {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numNinos = scan.nextInt();
        int numMovimientos = scan.nextInt();
        scan.nextLine();

        //Crear la pila de movimientos
        Stack<Integer> movimientos = new Stack<>();
        String[] movs = scan.nextLine().split(" ");
        int numUndos = 0;
        for (int i=0; i<numMovimientos; i++) {
            if (movs[i+numUndos].equals("undo")) {
                numUndos++;
                int cantUndos = Integer.parseInt(movs[i+numUndos]);
                for (int j=0; j<cantUndos; j++) {
                    movimientos.pop();
                }
            }
            else {
                movimientos.push(Integer.parseInt(movs[i+numUndos]));
            }
        }

        //Sumar los movimientos y realizar el módulo
        int suma = 0;
        while (!movimientos.isEmpty()) {
            suma += movimientos.pop();
        }
        suma = suma%numNinos;
        //Vigilar que la suma no sea negativa!
        if (suma >= 0)
            System.out.println(suma);
        else
            System.out.println(numNinos + suma);
    }

}
