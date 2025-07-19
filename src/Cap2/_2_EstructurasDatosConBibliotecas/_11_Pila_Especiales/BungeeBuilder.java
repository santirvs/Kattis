package Cap2._2_EstructurasDatosConBibliotecas._11_Pila_Especiales;

import java.util.Stack;
import Utils.Kattio;

// Bungee Builder
// Adaptado de https://github.com/BrandonTang89/Competitive_Programming_4_Solutions/blob/main/Chapter_2_Data_Structures/Linear_DS_with_Built-in_Libraries/kattis_bungeebuilder.cpp
//
// Se trata de buscar la montaña más alta y a partir de ella, buscar la mayor distancia que se puede saltar
// Se buscará hacia la izquierda y hacia la derecha de la montaña más alta
// Se usará una pila para guardar las montañas que se van procesando guardando la altura de la montaña y el mayor salto que se puede hacer desde ella
// Al procesar una montaña, se irán eliminando de la pila las montañas que sean más bajas que la montaña actual, pero actualizaremos el mayor salto que se puede hacer
// desde la montaña actual
// Al salir quedará en la pila la montaña tratada y el mayor salto que se puede hacer desde ella
// La mayor distancia que se puede saltar será la mayor de todas las distancias que se pueden saltar desde cada montaña
// Al acabar la búsqueda hacia la izquierda, vaciaremos la pila y volveremos a buscar hacia la derecha


public class BungeeBuilder {

    static class Pico {
        int altura;
        int salto;
        Pico(int f, int s){
            altura = f;
            salto = s;
        }
    }

    //Variables estáticas para ahorrar espacio en la pila de llamadas
    static Stack<Pico> pila = new Stack<>();
    static int[] alturaMontanas;
    static int saltoMaximo =0;

    public static void process_mountain(int m){
        // Procesa la montaña en la posición m del array

        int maxSaltoDesdeEstaMontana = 0;
        //Mientras la altura de esta montaña sea mayor o igual a la existente en la pila
        while (!pila.isEmpty() && alturaMontanas[m] >= pila.peek().altura){
            //Actualizo la mayor distancia que se puede saltar: la ya existente o la que se puede saltar desde esta montaña
            //que se calcula como altura de la montaña (arr[m]) - altura de la montaña en la cima de la pila (s.peek().first) + la mayor distancia que se puede saltar desde la montaña en la cima de la pila (s.peek().second)
            maxSaltoDesdeEstaMontana = Math.max(alturaMontanas[m] - pila.peek().altura + pila.peek().salto,maxSaltoDesdeEstaMontana);
            //Elimino de la pila la montaña
            pila.pop();
        }

        // Aquí llegaré cuando la montaña en la cima de la pila sea más alta que la montaña actual o bien la pila esté vacía
        // Por lo tanto, podré hacer un salto desde la montaña actual y con una profundidad de maxSaltoDesdeEstaMontana
        pila.push(new Pico(alturaMontanas[m], maxSaltoDesdeEstaMontana));

        //Actualizo la mayor distancia que se puede saltar
        saltoMaximo = Math.max(saltoMaximo, maxSaltoDesdeEstaMontana);
    }

    public static void main(String[] args) {
        //Scanner scan = new Scanner(System.in);
        //scan.useLocale(Locale.ENGLISH);

        Kattio scan = new Kattio(System.in);

        int numMontanas, maxAltura, posMaxAltura;

        numMontanas = scan.getInt();
        alturaMontanas = new int[numMontanas];
        alturaMontanas[0] = scan.getInt();
        maxAltura = alturaMontanas[0];
        posMaxAltura = 0;

        //Leer la altura de cada una de las montañas.
        //Me guardo el índice y el valor de la montaña más alta
        for (int i = 1; i < numMontanas; i++) {
            alturaMontanas[i] = scan.getInt();
            if (alturaMontanas[i] > maxAltura) {
                posMaxAltura = i;
                maxAltura = alturaMontanas[i];
            }
        }

        // Desde la montaña más alta, busco hacia la izquierda
        pila.push(new Pico(maxAltura, 0));
        for (int i = posMaxAltura - 1; i >= 0; i--) {
            process_mountain(i);
        }
        //Vaciar la pila antes de buscar hacia la derecha
        pila.clear();

        //Desde la montaña más alta, busco hacia la derecha
        pila.push(new Pico(maxAltura, 0));
        for (int i = posMaxAltura + 1; i < numMontanas; i++) {
            process_mountain(i);
        }

        //Imprimo la mayor distancia que se puede saltar
        System.out.println(saltoMaximo);

    }

}
