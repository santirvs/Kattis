package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._4_TablaDeHashSet;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

// Las soluciones enteras a 2018^2 = x^2 + y^2 son únicamente 12 !!!
// { 2018, -2018,     0,     0,  1118, 1118, -1680, 1680, 1680,-1680,-1118,-1118};
// {    0,     0 , 2018, -2018, -1680, 1680,  1118, 1118,-1118,-1118, 1680,-1680};

public class GreetingCard {

      public static class Punto  {
          int x;
          int y;

          Punto(int x, int y) {
              this.x = x;
              this.y = y;
          }

          @Override
          public boolean equals(Object startObject) {
              if (this == startObject) return true;
              if (startObject == null || getClass() != startObject.getClass()) return false;
              Punto star = (Punto) startObject;
              return x == star.x &&
                      y == star.y;
          }

          @Override
          public int hashCode() {
              return Objects.hash(x, y);
          }

      }

      public static void main(String[] args)  {

        Scanner scan = new Scanner(System.in);
        int[] dx = new int[] { 2018, -2018,     0,     0,  1118, 1118, -1680, 1680, 1680,-1680,-1118,-1118};
        int[] dy = new int[] {    0,     0 , 2018, -2018, -1680, 1680,  1118, 1118,-1118,-1118, 1680,-1680};

        HashSet<Punto> lista = new HashSet<Punto>();

        int numPuntos = scan.nextInt();
        long uniones = 0;
        for (int i=0; i<numPuntos; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int xx;
            int yy;

            Punto p;
            for (int j=0; j<12; j++) {
                xx = x + dx[j];
                yy = y + dy[j];
                p = new Punto(xx,yy);
                if (lista.contains(p) )
                    uniones++;
            }
            p = new Punto(x,y);
            lista.add(p);
        }

          System.out.println(uniones);

    }
}
