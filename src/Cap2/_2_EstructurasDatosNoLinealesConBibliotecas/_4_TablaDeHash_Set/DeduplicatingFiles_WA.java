package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._4_TablaDeHash_Set;

import java.util.HashSet;
import java.util.Scanner;

// Apuntar en un array los hashes de cada cadena
// Caso 2: WA! ????  Creo que no he entendido bien qué es una colisión


public class DeduplicatingFiles_WA {

        public static int calcularHash(String cadena) {
            int hash = cadena.charAt(0);
            for (int i=1; i<cadena.length(); i++) {
                hash = hash ^ cadena.charAt(i);
            }
            return hash;
        }

       public static void main(String[] args)  {

        Scanner scan = new Scanner(System.in);

        int numFiles = scan.nextInt();


        while (numFiles!=0) {
            scan.nextLine();
            String[] files = new String[numFiles];

            //Leer los ficheros
            for (int i = 0; i < numFiles; i++) {
                files[i] = scan.nextLine();
            }

            //Calcular los hashes y las colisiones
            long collisions = 0;
            long repetidas = 0;
            HashSet<Integer> hashes = new HashSet<>();
            for (int i = 0; i < numFiles; i++) {
                int hash = calcularHash(files[i]);
                hashes.add(hash);
                //Calcula el hash del resto de cadenas
                for (int j = i + 1; j < numFiles; j++) {
                    int hash2 = calcularHash(files[j]);
                    //Si concuerdan los hashes, comprobar si los ficheros son iguales
                    if (hash == hash2) {
                        if (files[i].equals(files[j])) {
                            //Se trata del mismo contenido. El fichero está repetido!
                            repetidas ++;
                        }
                        else
                            //Mismo hash, distinto contenido: es una colisión
                            collisions++;
                    }
                }
            }

            System.out.println((numFiles-repetidas) + " " + collisions);

            numFiles = scan.nextInt();
        }

    }
}
