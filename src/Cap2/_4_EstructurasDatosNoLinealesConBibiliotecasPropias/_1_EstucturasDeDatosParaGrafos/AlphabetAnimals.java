package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias._1_EstucturasDeDatosParaGrafos;

import java.util.*;

public class AlphabetAnimals {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String s = scan.nextLine();
        int n = scan.nextInt();
        scan.nextLine();

        HashMap<Character, ArrayList<String>> map = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            String x = scan.nextLine();
            Character c = x.charAt(0);
            if (map.containsKey(c)) {
                map.get(c).add(x);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(x);
                map.put(c, list);
            }
        }


        boolean trobat = false;
        char c = s.charAt(s.length() - 1);
        //No hi ha cap paraula amb la darrera lletra. Me l'invento!
        if (!map.containsKey(c)) {
            System.out.println("?");
            trobat = true;
        } else {
            ArrayList<String> possible = map.get(c);
            for (String t : possible) {
                char e = t.charAt(t.length() - 1);
                if (!map.containsKey(e) || (e == c && possible.size() == 1)) {
                    System.out.println(t + "!");
                    trobat = true;
                    break;
                }
            }
            if (!trobat)
                System.out.println(possible.get(0));
        }
    }
}
