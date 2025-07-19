package Cap2._2_EstructurasDatosConBibliotecas._2_ArraysUnidimensionalesDificiles;

import java.util.*;

public class PhysicalMusic_TLEv2 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        int tc = scan.nextInt();
        while(tc>0){
            tc--;
            int n = scan.nextInt();
            int[] arr = new int[n];
            Set<Integer> s = new TreeSet<>();
            for(int i=0;i<n;i++)
                arr[i] = scan.nextInt();
            int mini=n+1;
            for(int i=n-1;i>=0;i--){
                if(arr[i]>mini){
                    s.add(arr[i]);
                }
                mini=Math.min(mini,arr[i]);
            }
            System.out.println(s.size());
            for(int i:s){
                System.out.println(i);
            }
        }


    }
}
