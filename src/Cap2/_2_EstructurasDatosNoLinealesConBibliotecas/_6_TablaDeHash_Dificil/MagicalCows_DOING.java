package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._6_TablaDeHash_Dificil;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

// No veo como usar un HashMap aquí...


public class MagicalCows_DOING {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int maxVacas = scan.nextInt();
        int numGranjas = scan.nextInt();
        int numVisitas = scan.nextInt();

        //Leer las vacas de cada granja
        HashMap<Integer, Integer> vacas = new HashMap<Integer, Integer>();
        for (int i = 0; i < numGranjas; i++) {
            int numVacas = scan.nextInt();
            if (vacas.containsKey(numVacas)) {
                vacas.put(numVacas, vacas.get(numVacas) + 1);
            } else {
                vacas.put(numVacas, 1);
            }
        }

        //Leer los dias de visita
        List<Integer> dias = new ArrayList<Integer>();
        for (int i = 0; i < numVisitas; i++) {
            dias.add(scan.nextInt());
        }

        //Ordenar los dias de visita
        dias.sort(null);

        //Recorrer los dias de visita y mostrar el total de vacas
        for (int dia =0; dia <= dias.get(dias.size() - 1); dia++) {
            int totalGranjas = 0;
            for (int numVacas : vacas.keySet()) {
                totalGranjas += vacas.get(numVacas);
                //Doblamos el número de granjas completas
                if (numVacas == maxVacas) {
                    vacas.put(maxVacas, vacas.get(numVacas) * 2);
                }
                else if (numVacas < maxVacas) {
                    totalGranjas += vacas.get(numVacas);
                    int numGranjasDia = vacas.get(numVacas);
                    //Eliminamos las vacas de la granja
                    vacas.remove(numVacas);
                    //Añadimos las vacas de la granja a la siguiente
                    numVacas = numVacas * 2;
                    if (numVacas <= maxVacas) {
                        vacas.put(numVacas, numGranjasDia);
                    } else {
                        vacas.put((numVacas+1)/2, numGranjasDia);
                        vacas.put((numVacas)/2, numGranjasDia);
                    }
                }

            }
            if (dias.contains(dia)) {
                System.out.println(totalGranjas);
            }
        }

    }

}

