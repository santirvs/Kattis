package Cap2._1_EstructurasDatosConBibliotecas._12_ListaColaDeque;

import Utils.Kattio;

// Utilizar una linked list para almacenar los números
// Eliminar por delante o por detras en el caso de tener activado el flag de reverse
// Pddría hacerse tambien con un array de int y dos indices para controlar el inicio y el final
// Case#2 TLE  --> Ya estoy usando Kattio.
//                  Paso a usar un vector de int y dos índices para controlar el inicio y el final
//                  Sigue dando TLE
//                  --> Paso a experimentar con https://github.com/shakeelsamsu/kattis/blob/master/src/integerlists.java
//                  ya que sospecho de un problema de entrada/salida lenta

public class IntegerLists_TLE {

    public static void main(String[] args) {
        //Scanner scan = new Scanner(System.in);
        //scan.useLocale(Locale.ENGLISH);
        Kattio scan = new Kattio(System.in);

        int numCasos = scan.getInt();
        while (numCasos > 0) {
            //Lectura de datos
            String operaciones = scan.getWord();
            int numElementos = scan.getInt();
            String elementos = scan.getWord();
            String[] listaElementos = elementos.substring(1, elementos.length() - 1).split(",");
            //Indices que controlan el inicio y el final
            int derecha = numElementos - 1;
            int izquierda = 0;

            //Proceso las operaciones
            boolean reverse = false;
            boolean error = false;
            for (int i = 0; i < operaciones.length() && !error; i++) {
                if (operaciones.charAt(i) == 'R') {
                    reverse = !reverse;
                } else if (operaciones.charAt(i) == 'D') {
                    if (reverse) {
                        derecha--;
                    } else {
                        izquierda++;
                    }
                    if (derecha < izquierda) {
                        error = true;
                    }
                }
            }

            //Imprimo el resultado
            if (error) {
                System.out.println("error");
            } else {
                System.out.print("[");
                if (reverse) {
                    for (int i = derecha; i >= izquierda; i--) {
                        System.out.print(listaElementos[i]);
                        if (i > 0) {
                            System.out.print(",");
                        }
                    }
                } else {
                    for (int i = izquierda; i <= derecha; i++) {
                        System.out.print(listaElementos[i]);
                        if (i < derecha) {
                            System.out.print(",");
                        }
                    }
                }
                System.out.println("]");
            }

            numCasos--;
        }



    }

}
