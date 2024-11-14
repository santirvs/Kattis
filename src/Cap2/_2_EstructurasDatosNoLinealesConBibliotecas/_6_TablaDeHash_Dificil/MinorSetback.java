package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._6_TablaDeHash_Dificil;

import java.util.*;

// Cada frecuencia leída debe convertirse a nota con la fórmula f = 440 * 2^(n/12)
// n = 12 * ln(f/440) / ln(2)
// Hay que ajustar la n al entero más cercano
// n = -1 --> Sol# (415.30) G#3
// n = 0 --> La (440)  A4
// n = 1 --> La# (466.16) A#4, Bb4

// Una vez se tengan las notas, se deben guardar en un HashSet
// Al acabar, deben comprobarse en cuantas escalas diferentes se han encontrado todas esas notas
// Si hay una única escala que las contiene, se imprime el nombre de la escala y las notas en el mismo orden de aparición

public class MinorSetback {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        //Definir las escalas
        HashMap<String, List<String>> escalas = new HashMap<String, List<String>>();
        escalas.put("G major", Arrays.asList("G", "A", "B", "C", "D", "E", "F#"));
        escalas.put("C major", Arrays.asList("C", "D", "E", "F", "G", "A", "B"));
        escalas.put("Eb major", Arrays.asList("Eb", "F", "G", "Ab", "Bb", "C", "D"));
        escalas.put("F# minor", Arrays.asList("F#", "G#", "A", "B", "C#", "D", "E"));
        escalas.put("G minor", Arrays.asList("G", "A", "Bb", "C", "D", "Eb", "F"));

        //Definir las notas
        HashMap<Integer,List<String>> notas = new HashMap<Integer, List<String>>();
        notas.put(0, Arrays.asList("A"));
        notas.put(1, Arrays.asList("A#", "Bb"));
        notas.put(2, Arrays.asList("B"));
        notas.put(3, Arrays.asList("C"));
        notas.put(4, Arrays.asList("C#", "Db"));
        notas.put(5, Arrays.asList("D"));
        notas.put(6, Arrays.asList("D#", "Eb"));
        notas.put(7, Arrays.asList("E"));
        notas.put(8, Arrays.asList("F"));
        notas.put(9, Arrays.asList("F#", "Gb"));
        notas.put(10, Arrays.asList("G"));
        notas.put(11, Arrays.asList("G#", "Ab"));

        ArrayList<Integer> melodia = new ArrayList<Integer>();

        int numNotas = scan.nextInt();

        //Leer las frecuencias y convertirlas a notas.
        //Añadir las notas a la melodia
        for (int i = 0; i < numNotas; i++) {
            double frecuencia = scan.nextDouble();
            int n = (int) Math.round(12 * Math.log(frecuencia / 440) / Math.log(2));
            while (n<0) n+=12;
            melodia.add(n % 12);
        }

        //Comprobar en cuantas escalas diferentes se han encontrado todas las notas
        int cantidadEscalas = 0;
        int numEscala = 0;

        for (int i = 0; i < escalas.size(); i++) {
            //Obtiene la escala
            List<String> escala = escalas.get(escalas.keySet().toArray()[i]);

            //Crea un set con todas las notas de la melodía
            //Atención: Si estamos en la escala 2 o 4, hay que usar bemol (si existe) en lugar de sostenido
            HashSet<String> notasMelodia= new HashSet<String>();
            for (int j = 0; j < melodia.size(); j++) {
                List<String> posiblesNotas = notas.get(melodia.get(j));
                if ( (i==2 || i==4) && posiblesNotas.size()==2) {
                    notasMelodia.add(posiblesNotas.get(1));
                } else {
                    notasMelodia.add(posiblesNotas.get(0));
                }
            }

            //Comprueba el set con las notas de la melodía coincide con el set de la escala
            if (new HashSet<String>(escala).containsAll(notasMelodia)) {
                cantidadEscalas++;
                numEscala = i;
            }

        }

        //Al salir, si solo hay una escala que contiene todas las notas, se imprime
        //el nombre de la escala y las notas en el mismo orden de aparición
        //Si no, se imprime "cannot determine the scale"
        if (cantidadEscalas != 1)
            System.out.println("cannot determine key");
        else {
            System.out.println(escalas.keySet().toArray()[numEscala]);
            for (int i = 0; i < melodia.size(); i++) {
                List<String> posiblesNotas = notas.get(melodia.get(i));
                if ( (numEscala==2 || numEscala==4) && posiblesNotas.size()==2) {
                    System.out.println(posiblesNotas.get(1));
                } else {
                    System.out.println(posiblesNotas.get(0));
                }
            }
        }

    }

}

