package Others.Easy.Puntuacion_2_0_a_2_9._2_4;


import java.util.*;

public class Log {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int numCasos = sc.nextInt();

        while (numCasos-- >0) {
            int numCanciones = sc.nextInt();
            sc.nextLine();
            String musico = sc.nextLine();
            int longMusico = longitud(musico);

            ArrayList<String> canciones = new ArrayList<>();
            while(numCanciones-- > 0) {
                String cancion = sc.nextLine();
                int longCancion = longitud(cancion);
                if (longCancion == longMusico)
                    canciones.add(cancion);
            }

            //Mostrar el resultado
            Collections.sort(canciones);
            System.out.println(musico + ":");
            for (String s : canciones) {
                System.out.println(s);
            }

        }

    }

    private static int longitud(String texto) {
        return texto.replace(" ", "").length();
    }

}