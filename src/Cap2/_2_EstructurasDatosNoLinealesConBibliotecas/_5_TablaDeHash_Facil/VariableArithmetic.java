package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._5_TablaDeHash_Facil;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

// Leer las expresiones y analizarlas
// Si es una asignación, añadir la variable a la tabla de hash con su valor
// Si es una operación, calcular el resultado y mostrarlo
// Para calcular la operación, recorrer la expresión y sumar los valores (si existen) o añadir las variables a una lista
// Al final, si hay variables en la lista, mostrarl el total (si no es cero) seguido de las variables ordenadas segun su aparición
// Si no hay variables en la lista, mostrar el total

// Caso 2: RTE  -- Han sido capaces de poner una operación de un solo miembro? Efectivamente!  --> AC

public class VariableArithmetic {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        HashMap<String, Integer> variables = new HashMap<String, Integer>();
        String entrada = scan.nextLine();
        while (entrada.equals("0") == false) {

            List<String> variablesNoDefinidas = new ArrayList<String>();

            String[] linea = entrada.split(" ");

            if (linea.length>1 && linea[1].equals("=")) {
                //Asignación
                variables.put(linea[0], Integer.parseInt(linea[2]));
            } else {
                //Operación
                int total = 0;
                for (int i = 0; i < linea.length; i = i + 2) {
                    if (variables.containsKey(linea[i])) {
                        total += variables.get(linea[i]);
                    } else {
                        try {
                            total += Integer.parseInt(linea[i]);
                        } catch (NumberFormatException e) {
                            variablesNoDefinidas.add(linea[i]);
                        }
                    }
                }

                if (variablesNoDefinidas.size() > 0) {
                    boolean primero = true;
                    if (total != 0) {
                        System.out.print(total);
                        primero = false;
                    }
                    for (String variable : variablesNoDefinidas) {
                        if (primero) primero = false;
                        else System.out.print(" + ");
                        System.out.print(variable);
                    }
                    System.out.println();
                } else {
                    System.out.println(total);
                }
            }

            entrada = scan.nextLine();

        }
    }

}

