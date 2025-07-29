package Cap3._2_BusquedaCompleta._5_Iterativos_Permutacion;

import java.util.*;

// Probar las 8! permutaciones de fechas
// Comprobar si la fecha es válida y superior o igual al año 2000
// Mostar la fecha más temprana posible
// Hay que vigilar no repetir fechas válidas, ya que pueden haber dígitos repetidos
// Para comparar fechas podemos hacer año * 10000 + mes * 100 + dia

public class Dreamer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Generar las permutaciones de los números del 0 al 7
        // Construir el array para generar las permutaciones [0...7]
        int[] numeros = new int[8];
        for (int i = 0; i < 8; i++) {
            numeros[i] = i;
        }
        List<List<Integer>> resultado = new ArrayList<>();
        permutar(numeros, 0, resultado);

        //Leer número de casos
        int numCasos = sc.nextInt();

        while (numCasos-- > 0) {
            //Leer los datos de la fecha
            int in_dia = sc.nextInt();
            int in_mes = sc.nextInt();
            int in_anyo = sc.nextInt();

            char[] fecha = String.format("%02d%02d%04d", in_dia, in_mes, in_anyo).toCharArray();

            int numFechasValidas = 0;
            int menorFecha = Integer.MAX_VALUE; // Para almacenar la fecha más temprana posible
            Set<Integer> fechasValidas = new HashSet<>(); //Para no repetir fechas válidas (en el caso de repetirse dígitos)

            // Comprobar cada una de las permutaciones
            for (List<Integer> perm : resultado) {
                int dia = 0;
                int mes = 0;
                int anyo = 0;
                dia += (fecha[perm.get(0)] - '0') * 10 + (fecha[perm.get(1)] - '0');
                mes += (fecha[perm.get(2)] - '0') * 10 + (fecha[perm.get(3)] - '0');
                anyo += (fecha[perm.get(4)] - '0') * 1000 + (fecha[perm.get(5)] - '0') * 100 +
                        (fecha[perm.get(6)] - '0') * 10 + (fecha[perm.get(7)] - '0');

                if (anyo >= 2000 && !fechasValidas.contains(anyo * 10000 + mes * 100 + dia) && esFechaValida(dia, mes, anyo)) {
                    numFechasValidas++;
                    menorFecha = Math.min(menorFecha, anyo * 10000 + mes * 100 + dia);
                    fechasValidas.add(anyo*10000 + mes * 100 + dia);
                }
            }

            // Mostrar el resultado
            System.out.print(numFechasValidas);
            if (numFechasValidas > 0) {
                // Convertir la fecha más temprana a formato dd/mm/yyyy
                int dia = menorFecha % 100;
                int mes = (menorFecha / 100) % 100;
                int anyo = menorFecha / 10000;

                // Formatear la fecha con ceros a la izquierda
                System.out.printf(" %02d %02d %04d", dia, mes, anyo);
            }
            System.out.println();

        }

    }

    private static boolean esFechaValida(int dia, int mes, int anyo) {
        // Comprobar si la fecha es válida
        if (mes < 1 || mes > 12) return false;
        if (dia < 1 || dia > 31) return false;
        if (mes == 2) {
            // Febrero, comprobar si es bisiesto
            if (dia > 29) return false;
            if (dia == 29 && !esBisiesto(anyo)) return false;
        } else // Meses con 30 días
            if (mes == 4 || mes == 6 || mes == 9 || mes == 11) if (dia > 30) return false;

        return true;
    }

    private static boolean esBisiesto(int anyo) {
        // Comprobar si el año es bisiesto
        return (anyo % 4 == 0 && anyo % 100 != 0) || (anyo % 400 == 0);
    }

    // Algoritmo de permutación por backtracking
    static void permutar(int[] numeros, int indice, List<List<Integer>> resultado) {
        if (indice == numeros.length) {
            List<Integer> lista = new ArrayList<>();
            for (int num : numeros) {
                lista.add(num);
            }
            resultado.add(lista);
        }

        for (int i = indice; i < numeros.length; i++) {
            intercambiar(numeros, indice, i);
            permutar(numeros, indice + 1, resultado);
            intercambiar(numeros, indice, i); // deshacer
        }
    }

    static void intercambiar(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
