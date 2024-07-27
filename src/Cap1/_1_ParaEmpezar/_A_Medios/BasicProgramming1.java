package Cap1._1_ParaEmpezar._A_Medios;

import java.util.Locale;
import java.util.Scanner;

public class BasicProgramming1 {

   public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Lectura de los datos del caso
       int n = scan.nextInt();
       int t = scan.nextInt();
       scan.nextLine();

       //Leer el array
       String[] as = scan.nextLine().split(" ");
       int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(as[i]);
        }

       //Realizar la operación
       switch (t) {
           case 1: System.out.println(7); break;
           case 2: System.out.println(a[0] > a[1] ? "Bigger" : a[0] == a[1] ? "Equal" : "Smaller"); break;
           case 3: int[] b = {a[0], a[1], a[2]};
                   java.util.Arrays.sort(b);
                   System.out.println(b[1]);
                   break;
           case 4: long sum = 0;
                   for (int i = 0; i < n; i++) {
                       sum += a[i];
                   }
                   System.out.println(sum);
                   break;
           case 5: long sumEven = 0;
                   for (int i = 0; i < n; i++) {
                       sumEven += a[i]%2==0 ? a[i]: 0;
                   }
                   System.out.println(sumEven);
                   break;
           case 6: for (int i = 0; i < n; i++) {
                       System.out.print((char)('a' + a[i]%26));
                   }
                   System.out.println();
                   break;
           case 7: int i = 0;
                   boolean[] visited = new boolean[n];
                   boolean blnOut = false;
                   boolean blnDone = false;
                   boolean blnVisitado = false;
                   while (!blnOut && !blnDone && !visited[i] ) {
                       visited[i] = true;
                       i = a[i];
                       if (i >= n) blnOut = true;
                       else if (i == n-1) blnDone = true;
                       else if (visited[i]) blnVisitado = true;
                   }
                   if (blnVisitado) System.out.println("Cyclic");
                   else if (blnOut) System.out.println("Out");
                   else if (blnDone) System.out.println("Done");
                   break;

       }
   }

}

