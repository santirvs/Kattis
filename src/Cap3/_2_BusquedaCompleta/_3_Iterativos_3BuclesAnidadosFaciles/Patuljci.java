package Cap3._2_BusquedaCompleta._3_Iterativos_3BuclesAnidadosFaciles;

// Fuerza bruta
// Buscar la única combinación de 7 enanos que sumen la altura de 100cm

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Patuljci {

     public static void main(String[] args) throws IOException {
         Scanner scan = new Scanner(System.in);
         // Guardar las alturas de los enanos

         List<Integer> alturas = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            alturas.add(scan.nextInt());
        }

        for (int e1=0; e1 < 3; e1++) {
            for (int e2 = e1 + 1; e2 < 4; e2++) {
                for (int e3 = e2 + 1; e3 < 5; e3++) {
                    for (int e4 = e3 + 1; e4 < 6; e4++) {
                        for (int e5 = e4 + 1; e5 < 7; e5++) {
                            for (int e6 = e5 + 1; e6 < 8; e6++) {
                                for (int e7 = e6 + 1; e7 < 9; e7++) {
                                    int suma = alturas.get(e1) + alturas.get(e2) + alturas.get(e3) +
                                            alturas.get(e4) + alturas.get(e5) + alturas.get(e6) +
                                            alturas.get(e7);
                                    if (suma == 100) {
                                        // Imprimir las alturas de los enanos seleccionados
                                        System.out.println(alturas.get(e1));
                                        System.out.println(alturas.get(e2));
                                        System.out.println(alturas.get(e3));
                                        System.out.println(alturas.get(e4));
                                        System.out.println(alturas.get(e5));
                                        System.out.println(alturas.get(e6));
                                        System.out.println(alturas.get(e7));
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

     }
}

