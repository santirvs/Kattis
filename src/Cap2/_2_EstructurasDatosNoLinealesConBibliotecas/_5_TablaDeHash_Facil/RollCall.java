package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._5_TablaDeHash_Facil;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

// Leer los nombres y añadirlos a una lista de nombres con forma Apellido Nombre
// Añadir los nombres a un HashMap con el nombre como clave y un contador de nombres como valor
// Al final, recorrer la lista ordenada
// Si el contador de nombres es igual a 1, basta con imprimir el nombre
// Si el contador de nombres es mayor que 1, imprimir el nombre y el apellido

public class RollCall {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        HashMap<String, Integer> contadorNombres = new HashMap<String, Integer>();
        List<String> nombres = new ArrayList<String>();


        while (scan.hasNext()) {

            String[] linea = scan.nextLine().split(" ");
//            if (linea.length == 1) {
//                break;
//            }
            String nombre = linea[0];
            String apellido = linea[1];

            //Añadir a la lista de nombres apellido + nombre
            nombres.add(apellido + " " + nombre);

            //Añadir a la tabla de hash el nombre y su contador
            if (contadorNombres.containsKey(nombre)) {
                contadorNombres.put(nombre, contadorNombres.get(nombre) + 1);
            } else {
                contadorNombres.put(nombre, 1);
            }
        }

        //Ordenar la lista de nombres
        nombres.sort(null);

        //Recorrer la lista de nombres
        for (String alumno : nombres) {
            String[] linea = alumno.split(" ");
            String nombre = linea[1];
            String apellido = linea[0];

            //Si el contador de nombres es igual a 1, basta con imprimir el nombre
            if (contadorNombres.get(nombre) == 1) {
                System.out.println(nombre);
            } else {
                //Si el contador de nombres es mayor que 1, imprimir el nombre y el apellido
                System.out.println(nombre + " " + apellido);
            }
        }
    }

}

