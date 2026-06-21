package Others.Medium.Puntuacion_2_0_a_2_9._2_9;

import java.util.*;

//Ordenar las plataformas por su altura (de mayor a menor)
//La primera plataforma requiere columnas en sus posiciones inicio y final
//Al procesar la siguiente plataforma, incrementar los pilares en count(set) * (altura_anterior - altura_actual)
// y añadir al set de pilares las posiciones inicio y final
// Y así hasta que no queden más plataformas, pero habrá que extender los pilares necesarios hasta la altura 0

public class Platforme {

    public static class Plataforma implements Comparable<Plataforma> {
        int altura;
        int ini;
        int fin;

        Plataforma(int altura, int ini, int fin) {
            this.altura = altura;
            this.ini = ini;
            this.fin = fin;
        }

        @Override
        public int compareTo(Plataforma o) {
            int result = Integer.compare(this.altura, o.altura);
            if (result == 0) result = -1;
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Leer las plataformas
        int numPlataformas = sc.nextInt();
        Plataforma[] plats = new Plataforma[numPlataformas];
        for (int i=0; i<numPlataformas;i++) {
            int altura = sc.nextInt();
            int ini = sc.nextInt();
            int fin = sc.nextInt();

            plats[i] = new Plataforma(altura, ini, fin);
        }

        //Ordenar las plataformas
        Arrays.sort(plats);

        //Procesar las plataformas
        Set<Float> pilares = new HashSet<Float>();

        //Añadir los pilares de la primera plataforma
        Plataforma ultima = plats[plats.length-1];
        int ultimaAltura = ultima.altura;
        pilares.add(ultima.ini+0.5f);
        pilares.add(ultima.fin-0.5f);

        //Procesar el resto de plataformas
        int totalTramosPilar = 0;
        for (int i=plats.length-2; i>=0; i--) {
            Plataforma p = plats[i];

            totalTramosPilar += (ultimaAltura - p.altura) * pilares.size();

            //Eliminar los pilares que se soportaran en la nueva plataforma
            pilares.removeIf( x -> x >= p.ini && x<= p.fin );

            //Actualizar la nueva altura y añadir los pilares para la nueva plataforma
            ultimaAltura = p.altura;
            pilares.add(p.ini+0.5f);
            pilares.add(p.fin-0.5f);
        }

        //Procesar los pilares necesarios hasta el suelo
        totalTramosPilar += ultimaAltura  * pilares.size();


        //Mostrar el resultado
        System.out.println(totalTramosPilar);

    }

}