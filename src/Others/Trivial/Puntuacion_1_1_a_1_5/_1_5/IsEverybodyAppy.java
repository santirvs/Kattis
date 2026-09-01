package Others.Trivial.Puntuacion_1_1_a_1_5._1_5;

// Apuntar las Apps en una lista e ir comprobando si cada app ya se encuentra instalada

import java.util.ArrayList;
import java.util.Scanner;


public class IsEverybodyAppy {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numHijos = sc.nextInt();
        ArrayList<String> appsInstaladas = new ArrayList<>();

        while (numHijos-- > 0) {
            int numApps = sc.nextInt();
            String[] apps = sc.nextLine().split(" ");  //Atención index =0 será ""
            boolean instalada = false;
            for (int i=1; i<=numApps && !instalada; i++) {
                if (!appsInstaladas.contains(apps[i])) {
                    appsInstaladas.add(apps[i]);
                    instalada = true;
                }
            }
        }

        //Imprimir el resultado
        boolean primero = true;
        for (String app: appsInstaladas) {
            if (primero) primero=false;
            else System.out.print(" ");
            System.out.print(app);
        }
        System.out.println("");

        sc.close();
    }
}

