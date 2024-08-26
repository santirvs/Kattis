package Cap2._1_EstructurasDatosConBibliotecas._1_ArraysUnidimensionales_Medios;

import java.util.Locale;
import java.util.Scanner;

public class DisastrousDowntime {



    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

       //Leer la entrada
        int numPeticiones = scan.nextInt();
        int maxPeticiones = scan.nextInt();
        scan.nextLine();

        //Lista de procesadores
        int[] tiempo = new int[100_001];

        //Leer las peticiones y registrar el tiempo en que se realizan
        for (int i=0; i<numPeticiones; i++) {
            int peticion = scan.nextInt();
            for (int t=0; t<1000 && peticion+t<=100_000; t++) {
                tiempo[peticion+t]++;
            }
       }

        //Buscar el máximo de transacciones en un milisegundo
        int maxTransacciones = 0;
        for (int i=0; i<tiempo.length; i++) {
            if (tiempo[i] > maxTransacciones) {
                maxTransacciones = tiempo[i];
            }
        }

        //Imprimir el número de procesadores necesarios
        System.out.println(maxTransacciones/maxPeticiones + (maxTransacciones%maxPeticiones == 0 ? 0 : 1));

    }
}
