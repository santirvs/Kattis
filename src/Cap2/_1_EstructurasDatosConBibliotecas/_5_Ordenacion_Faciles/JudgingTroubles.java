package Cap2._1_EstructurasDatosConBibliotecas._5_Ordenacion_Faciles;

import java.util.*;

public class JudgingTroubles {

    public static class Veredicto implements Comparable<Veredicto> {
        String resultado;
        int cantidad;

        public Veredicto(String resultado, int cantidad) {
            this.resultado = resultado;
            this.cantidad = cantidad;
        }

        @Override
        public boolean equals(Object object)
        {
            boolean iguales = false;

            if (object != null && object instanceof Veredicto)
            {
                iguales = this.resultado.equals(((Veredicto) object).resultado);
            }

            return iguales;
        }


        @Override
        public int compareTo(Veredicto o) {
            return this.resultado.compareTo(o.resultado);
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numCasos = scan.nextInt();
        HashMap<String, Integer> veredictosDom = new HashMap<String, Integer>();
        HashMap<String, Integer> veredictosJuez = new HashMap<String, Integer>();

        for (int j = 0; j < numCasos; j++) {
            String veredicto = scan.next();
            if (veredictosDom.containsKey(veredicto)) {
                veredictosDom.put(veredicto, veredictosDom.get(veredicto) + 1);
            } else {
                veredictosDom.put(veredicto, 1);
            }
        }
        for (int j = 0; j < numCasos; j++) {
            String veredicto = scan.next();
            if (veredictosJuez.containsKey(veredicto)) {
                veredictosJuez.put(veredicto, veredictosJuez.get(veredicto) + 1);
            } else {
                veredictosJuez.put(veredicto, 1);
            }
        }

        //Mostrar el resultado
        int coincidencias = 0;
        for (Map.Entry<String, Integer> entry : veredictosDom.entrySet()) {
            if (veredictosJuez.containsKey(entry.getKey())) {
                coincidencias += Math.min(entry.getValue(), veredictosJuez.get(entry.getKey()));
            }
        }
        System.out.println(coincidencias);
    }


}