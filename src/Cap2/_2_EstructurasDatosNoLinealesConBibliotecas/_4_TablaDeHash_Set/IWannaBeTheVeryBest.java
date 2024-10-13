package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._4_TablaDeHash_Set;


import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// Guardarse el índice del item con el valor más alto en cada especialidad
// Añadir el item al set
// Mostrar el tamaño del set

// Caso#2: RTE ---> uint32 --> LONG!!!  --> AC



public class IWannaBeTheVeryBest  {



    public static class Pokenom implements Comparable<Pokenom> {
        int id;
        long fuerza;

        Pokenom(int id, long fuerza) {
            this.id = id;
            this.fuerza = fuerza;
        }

        @Override
        public int compareTo(Pokenom o) {
            if ((o.fuerza - this.fuerza) > 0) return 1;
            else if ((o.fuerza - this.fuerza) < 0) return -1;
            else return 0;
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int numCasos = scan.nextInt();
        int numPokenoms = scan.nextInt();

        List<Pokenom> pokenomsAttack = new ArrayList<>();
        List<Pokenom> pokenomsDefense = new ArrayList<>();
        List<Pokenom> pokenomsHealth = new ArrayList<>();

        for (int i = 0; i < numCasos; i++) {
            pokenomsAttack.add(new Pokenom(i, scan.nextLong()));
            pokenomsDefense.add(new Pokenom(i, scan.nextLong()));
            pokenomsHealth.add(new Pokenom(i, scan.nextLong()));
        }

        pokenomsAttack.sort(Pokenom::compareTo);
        pokenomsDefense.sort(Pokenom::compareTo);
        pokenomsHealth.sort(Pokenom::compareTo);

        HashSet<Integer> pokenoms = new HashSet<>();
        for (int i=0; i < numPokenoms; i++) {
            pokenoms.add(pokenomsAttack.get(i).id);
            pokenoms.add(pokenomsDefense.get(i).id);
            pokenoms.add(pokenomsHealth.get(i).id);
        }

        System.out.println(pokenoms.size());

    }

}

