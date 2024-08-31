package Cap2._1_EstructurasDatosConBibliotecas._6_Ordenacion_Dificiles;

import java.util.*;

public class AddEmUp {


    private static int valorGirado(int numero) {
        boolean girable = true;
        int nuevoNumero = 0;
        while (numero > 0) {
            int digito = numero % 10;
            if (digito == 3 || digito == 4 || digito == 7) {
                girable = false;
                break;
            } else {
                if (digito == 6) {
                    digito = 9;
                } else if (digito == 9) {
                    digito = 6;
                }
                nuevoNumero = nuevoNumero * 10 + digito;
            }
            numero /= 10;
        }
        if (girable) {
            return nuevoNumero;
        } else return -1;
    }


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numCartas = scan.nextInt();
        int suma = scan.nextInt();

        //Lectura de cartas
        ArrayList<Integer> listaCartas = new ArrayList<>();
        for (int i = 0; i < numCartas; i++) {
            int valor = scan.nextInt();
            listaCartas.add(valor);
            int valorGirado = valorGirado(valor);
            if (valorGirado != valor && valorGirado!=-1) {
                listaCartas.add(valorGirado);
            }
        }

        //Ordenar las cartas
        Collections.sort(listaCartas);

        //Dada una carta, buscar la otra carta que sume el número buscado
        //Dado que está ordenado buscamos mientras la carta sea menor o igual que la mitad de la suma
        boolean encontrado = false;
        for (int i=0; i<listaCartas.size() && listaCartas.get(i)<=(suma/2) && !encontrado; i++) {
            int posicion = Collections.binarySearch(listaCartas, suma - listaCartas.get(i));
            if (posicion >= 0 && posicion != i) {

                //Falta asegurar que no sea el mismo valor, pero girado
                if (listaCartas.get(i) == valorGirado(listaCartas.get(posicion))) {
                    //No es válido, a menos que haya más de una carta con ese valor
                    //que se debería encontrar en la posición siguiente
                    if (listaCartas.size()-1 > posicion && listaCartas.get(posicion+1) == listaCartas.get(posicion)) {
                        System.out.println("YES");
                        encontrado = true;
                    }
                } else {
                    System.out.println("YES");
                    encontrado = true;
                }
            }
        }

        if (!encontrado) {
            System.out.println("NO");
        }


    }


}