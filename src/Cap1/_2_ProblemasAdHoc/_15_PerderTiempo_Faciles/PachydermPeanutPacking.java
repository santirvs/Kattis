package Cap1._2_ProblemasAdHoc._15_PerderTiempo_Faciles;

import java.util.Locale;
import java.util.Scanner;

public class PachydermPeanutPacking {

    public static class Package {
        double x1, y1, x2, y2;
        String tipo;

        public Package(double x1, double y1, double x2, double y2, String tipo) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.tipo = tipo;
        }

        public boolean contains(double x, double y) {
            return x >= x1 && x <= x2 && y >= y1 && y <= y2;
        }

    }

     public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

       //Leer la entrada
        int n = scan.nextInt();
        while (n != 0) {
            //Cargar las bolsas
            Package[] bolsas = new Package[n];
            for (int i = 0; i < n; i++) {
                double x1 = scan.nextDouble();
                double y1 = scan.nextDouble();
                double x2 = scan.nextDouble();
                double y2 = scan.nextDouble();
                String tipo = scan.next().trim();
                bolsas[i] = new Package(x1, y1, x2, y2, tipo);
            }

            //Leer los cacahuetes
            int m = scan.nextInt();
            for (int i = 0; i < m; i++) {
                double x = scan.nextDouble();
                double y = scan.nextDouble();
                String tipo = scan.nextLine().trim();
                boolean encontrado = false;
                for (int j = 0; j < n && !encontrado; j++) {
                    if (bolsas[j].contains(x,y)) {
                        encontrado = true;
                        System.out.print(tipo + " ");
                        if (tipo.equals(bolsas[j].tipo)) {
                            System.out.println("correct");
                        } else {
                            System.out.println(bolsas[j].tipo);
                        }
                    }
                }
                if (!encontrado) {
                    System.out.println(tipo + " floor");
                }
            }

            //Siguiente caso
            n = scan.nextInt();
            if (n!=0) System.out.println();
        }
    }
}


