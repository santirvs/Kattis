package Cap2._2_EstructurasDatosConBibliotecas._8_ManipulacionBits;

import Utils.Kattio;


//La idea de este problema es muy simple:
// Si el resultado de la matriz m[i,j] es a[i] AND a[j], entonces a[i] es el OR de todos los elementos de la fila i y de la columna j

//Caso #5:TLE --> Paso a usar Kattio  --> AC

public class DeathStar {

    public static void main(String[] args) {
        //Scanner scan = new Scanner(System.in);
        //scan.useLocale(Locale.ENGLISH);

        Kattio scan = new Kattio(System.in);

        //Lectura de datos
        int tamanyo = scan.getInt();
        int[] result = new int[tamanyo];

        //Leemos los datos de la matriz (no es necesario guardarlos)
        for (int i=0; i<tamanyo;i++) {
            for (int j=0; j<tamanyo;j++) {
                int numero = scan.getInt();
                //OR del numero leído con la fila i y la columna j
                result[i] = result[i] | numero;
                result[j] = result[j] | numero;
            }
        }

        //Imprimir el resultado
        for (int i=0; i<tamanyo;i++) {
            System.out.print((i!=0?" ":"") + result[i] );
        }

    }

}
