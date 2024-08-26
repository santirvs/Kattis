package Cap2._1_EstructurasDatosConBibliotecas._1_ArraysUnidimensionales_Medios;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class DisastrousDowntime_TLE {


    public static class Procesador {
        ArrayList<Integer> peticiones;
        int maxPeticiones;

        public Procesador(int maxPeticiones) {
            this.maxPeticiones = maxPeticiones;
            this.peticiones = new ArrayList<Integer>();
        }

        public void liberaPeticiones(int peticion) {
            ArrayList<Integer> eliminar = new ArrayList<>();
            for (Integer i: peticiones) {
                if (i+1000 <= peticion) {
                    eliminar.add(i);
                }
                //Si no es inferior, entonces las siguientes tampoco lo serán
                else break;
            }
            for (Integer i: eliminar) {
                peticiones.remove(i);
            }
        }

        public boolean recibePeticion(int peticion) {
            if (this.peticiones.size() < this.maxPeticiones) {
                this.peticiones.add(peticion);
                return true;
            }
            return false;
        }

    }
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

       //Leer la entrada
        int numPeticiones = scan.nextInt();
        int maxPeticiones = scan.nextInt();
        scan.nextLine();

        //Lista de procesadores
        ArrayList<Procesador> procesadores = new ArrayList<>();

        //Leer las peticiones
        for (int i=0; i<numPeticiones; i++) {
            int peticion = scan.nextInt();

            //Liberar las peticiones en los procesadores que ya terminaron
            for (Procesador p : procesadores) {
                p.liberaPeticiones(peticion);
            }

            //Buscar un procesador que pueda recibir la petición
            boolean procesada = false;
            for (Procesador p : procesadores) {
                if (p.recibePeticion(peticion)) {
                    procesada = true;
                    break;
                }
            }

            //Si no se pudo procesar, crear un nuevo procesador
            if (!procesada) {
                Procesador nuevoProcesador = new Procesador(maxPeticiones);
                nuevoProcesador.recibePeticion(peticion);
                procesadores.add(nuevoProcesador);
            }
        }

        //Imprimir el número de procesadores
        System.out.println(procesadores.size());

    }
}
