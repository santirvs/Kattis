package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._5_TablaDeHash_Facil;


import java.util.*;

// Leer las categorias y guardarlas en un HashMap (String, Int)
// Si ya existe la categoria, incrementar el contador
// Al final, recorrer el HashMap y ver cuantas categorias tienen el mismo número de votos
// Guardarlas en una lista y mostrarlas ordenadas

// Caso #4: WA  --> Faltaba ordenar la llista de categorias ganadoras --> AC


public class CostumeContest {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int numAmigos = scan.nextInt();

        TreeMap<String, Integer> recuento = new TreeMap<String, Integer>();

        //Leer las categorias y guardarlas en el HashMap
        for (int i=0; i<numAmigos; i++) {
            String categoria = scan.next();
            if (recuento.containsKey(categoria)) {
                //Incrementar el recuento de la categoria
                recuento.put(categoria, recuento.get(categoria) + 1);
            } else {
                //Añadir la categoria al recuento con 1
                recuento.put(categoria, 1);
            }
        }

        //Recorrer el HashMap para buscar las categorias con el minimo número de ocurrencias
        // que será la que tenga más probabilidades de ganar
        int minOcurrencias = Integer.MAX_VALUE;
        List<String> categoriasGanadoras = new ArrayList<>();
        for (String categoria : recuento.keySet()) {
            if (recuento.get(categoria).intValue() < minOcurrencias) {
                minOcurrencias = recuento.get(categoria);
                categoriasGanadoras = new ArrayList<>();
                categoriasGanadoras.add(categoria);
            }
            else if (recuento.get(categoria) == minOcurrencias) {
                categoriasGanadoras.add(categoria);
            }
        }

        categoriasGanadoras.sort(null);

        for (String categoria : categoriasGanadoras) {
            System.out.println(categoria);
        }
    }

}

