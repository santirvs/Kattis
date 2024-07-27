package Cap1._1_ParaEmpezar._9_MenosFaciles;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Prerequisites {

   public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Lectura de los datos del caso
        int cursos= scan.nextInt();

        while (cursos > 0 ) {
            int categorias = scan.nextInt();
            //Leer los cursos a los que se ha matriculado
            ArrayList cursosMatriculados = new ArrayList();
            for (int i=0; i<cursos; i++) {
                cursosMatriculados.add(scan.nextInt());
            }

            boolean algunaCategoriaNoCumple = false;

            //Leer las categorias de los cursos
            for (int i=0; i<categorias; i++) {
                int cursosCategoria = scan.nextInt();
                int cursosRequeridos = scan.nextInt();
                int cursosMatriculadosCategoria = 0;

                //Revisar si en cuantos cursos de la categoria se ha matriculado
                for (int j=0; j<cursosCategoria; j++) {
                    int curso = scan.nextInt();
                    if (cursosMatriculados.contains(curso)) {
                        cursosMatriculadosCategoria++;
                    }
                }

                if (cursosMatriculadosCategoria < cursosRequeridos)
                    algunaCategoriaNoCumple = true;

            }

            if (algunaCategoriaNoCumple) {
                System.out.println("no");
            } else {
                System.out.println("yes");
            }

            cursos= scan.nextInt();
        }

    }
}
