package Cap2._1_EstructurasDatosConBibliotecas._12_ListaColaDeque;

// Utilizar una linked list para almacenar los números
// Eliminar por delante o por detras en el caso de tener activado el flag de reverse
// Pddría hacerse tambien con un array de int y dos indices para controlar el inicio y el final
// Case#2 TLE  --> Ya estoy usando Kattio.
//                  Paso a usar un vector de int y dos índices para controlar el inicio y el final
//                  Sigue dando TLE
//                  --> Paso a experimentar con https://github.com/shakeelsamsu/kattis/blob/master/src/integerlists.java


// 0.- Sin modificar nada:  0.57s
// 1.- Dejo de usar la pila para imprimir los elementos en orden inverso: 0.70s
// 2.- Itero sobre la lista de elementos para imprimir el resultado en lugar de imprimir la lista entera : 0.63s
// 3.- Restauro la pila para imprimir los elementos en orden inverso  -> 0.68s .. 0.72s
// 4.- Dejo de usar el buffered output  -> TLE!!!
// 5.- Restauro el buffered output y paso a usar el Scanner -->  AC en 0.88s
// 6.- Restauro el buffered output -> 0.69s
// 7.- Añado el flush al final de cada caso -->  0.68s
// En este caso el problema es el out!!!!

import java.io.*;
import java.util.*;

public class IntegerLists {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        //Scanner in = new Scanner(System.in);

//        int n = in.nextInt(); in.nextLine();
        int n = Integer.parseInt(in.readLine());
        for(int i = 0; i < n; i++) {
            //char[] commands = in.nextLine().toCharArray();
            char[] commands = in.readLine().toCharArray();
            //int e = in.nextInt(); in.nextLine();
            int e = Integer.parseInt(in.readLine());
            //String temp = in.nextLine();
            String temp = in.readLine();
            String[] input = temp.length() > 2 ? temp.substring(1, temp.length() - 1).split(",") : new String[0];
            boolean front = true;
            boolean error = false;
            Deque<String> queue = new LinkedList<String>();
            for(String s : input) queue.add(s.trim());
            for(char c : commands) {
                if(c == 'R') front = !front;
                else {
                    if(queue.size() == 0) {
                        error = true;
                        break;
                    }
                    if(front) {
                        queue.removeFirst();
                    }
                    else {
                        queue.removeLast();
                    }
                }
            }
            if(error) out.print("error");
            else if(!front) {
                Iterator<String> itr = queue.iterator();
                Deque<String> rev = new LinkedList<String>();
                while(itr.hasNext()) {
                    rev.push(itr.next());
                }
                out.print(rev.toString().replace(" ", ""));
            }
            else {
                out.print("[");
                while (!queue.isEmpty()) {
                    out.print(queue.removeFirst());
                    if (!queue.isEmpty()) out.print(",");
                }
                out.print("]");
            }
            out.println();
            out.flush();
        }
        out.close();
    }
}