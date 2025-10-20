package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el número de casos
// Para cada caso
//  - Leer el nombre
//  - Leer el nivel de amistad
//  - Leer la fecha
//  Guardar la fecha en un HashMap <Amigo>
//  - Si ya existía la fecha y el amigo tiene un nivel de amistad menor, eliminarlo
//       y añadir el nuevo
//  - Si no existía la fecha, añadirla
//  - Al añadir al mapa, mantener un Set ordenado y eliminar / añadir los nombres
// Al final, mostrar el Set ordenado

import java.util.*;


public class BirthdayMemorization {

    static class Amigo {
        String nombre;
        int nivel;

        Amigo(String nombre, int nivel) {
            this.nombre = nombre;
            this.nivel = nivel;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la cantidad de concursantes
        int numAmigos = sc.nextInt();

        //Declarar el mapa String, Int
        Map<String, Amigo> mapa = new HashMap<>();
        TreeSet<String> lista =  new TreeSet<String>();

        //Leer los amigos
        for (int i=0; i<numAmigos; i++) {
            String nombre = sc.next();
            int nivel =  sc.nextInt();
            String fecha =  sc.next();

            //Añadir la localidad si no existe ya, si existe se incrementa en uno
            if (mapa.containsKey(fecha)) {
                Amigo existente = mapa.get(fecha);
                //Reemplazamos el amigo por uno con el que tenemos más nivel de amistad
                if (existente.nivel < nivel) {
                    lista.remove(existente.nombre);
                    existente.nombre = nombre;
                    existente.nivel = nivel;
                    lista.add(nombre);
                }
            }
            else {
                //Primer amigo en esa fecha
                mapa.put(fecha, new Amigo(nombre,nivel));
                lista.add(nombre);
            }

        }

        //Mostrar los nombres de la lista
        System.out.println(lista.size());
        for (String entry: lista) {
            System.out.println(entry);
        }


        sc.close();
    }
}

