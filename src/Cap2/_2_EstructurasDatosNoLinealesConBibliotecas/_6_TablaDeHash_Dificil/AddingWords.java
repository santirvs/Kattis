package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._6_TablaDeHash_Dificil;

import java.util.*;

// Guardar las definiciones de una variable en un HashMap <String, Int> y a su vez, en un HashMap <Int, String>
// Si llega un calc, ir sumando o restando los valores de las variables y si alguno no existe, imprimir "unknown"
// El resultado debe buscarse en el HashMap <Int, String> y si no existe, imprimir "unknown"
// Si llega una def, añadir la variable al HashMap <String, Int> y si ya existe, actualizar su valor en el HashMap <Int, String>
//  y especialmente en el HashMap <String, Int> para evitar mantener valores obsoletos
// Si llega una clear, limpiar ambos HashMaps

public class AddingWords {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        HashMap<String, Integer> palabras = new HashMap<String, Integer>();
        HashMap<Integer, String> numeros = new HashMap<Integer,String>();

        //Leer cada una de las instrucciones
        while (scan.hasNext()) {
            String[] comando = scan.nextLine().split(" ");

            if (comando[0].equals("clear")) {
                palabras.clear();
                numeros.clear();
            } else if (comando[0].equals("def")) {
                String variable = comando[1];
                int valor = Integer.parseInt(comando[2]);
                //Eliminar un valor existente en ambos HashMaps
                //especialmente importante en numeros para evitar mantener valores obsoletos
                if (palabras.containsKey(variable)) {
                    int valorAnterior = palabras.get(variable);
                    palabras.remove(variable);
                    numeros.remove(valorAnterior);
                }
                palabras.put(variable, valor);
                numeros.put(valor, variable);
            } else if (comando[0].equals("calc")) {
                int resultado = 0;
                boolean desconocido = false;
                for (int i = 1; i < comando.length - 1; i++) {
                    if (i % 2 == 1) {
                        if (palabras.containsKey(comando[i])) {
                            if (i == 1) {
                                resultado = palabras.get(comando[i]);
                            } else {
                                if (comando[i - 1].equals("+")) {
                                    resultado += palabras.get(comando[i]);
                                } else {
                                    resultado -= palabras.get(comando[i]);
                                }
                            }
                        } else {
                            desconocido = true;
                        }
                    }
                }

                //Mostrar la ecuación
                System.out.print(String.join(" ", comando).substring(5) + " ");
                //Mostrar el resultado
                if (desconocido || !numeros.containsKey(resultado)) {
                    System.out.println("unknown");
                } else {
                    System.out.println(numeros.get(resultado));
                }
            }
        }

    }

}

