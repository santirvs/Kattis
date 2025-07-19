package Cap2._2_EstructurasDatosConBibliotecas._10_Pila;

import Utils.Kattio;

import java.util.ArrayList;
import java.util.HashMap;

// Adapto el código de https://github.com/BrandonTang89/Competitive_Programming_4_Solutions/blob/main/Chapter_2_Data_Structures/Linear_DS_with_Built-in_Libraries/kattis_dream.cpp
// ya que tengo un TLE y el planteamiento es parecido. Una vez más sospecho que el límite de tiempo para Java es insuficiente
// Efectivmente, el código de BrandonTang89 también da TLE una vez se adapta a Java.

public class AllJustADream_TLE2 {

    public static void main(String[] args) {
        //Scanner scan = new Scanner(System.in);
        //scan.useLocale(Locale.ENGLISH);
        Kattio scan = new Kattio(System.in);

        ArrayList<Integer> s = new ArrayList<>();       // s[position on stack] = event index
        int[] pos;                                      // pos[event index] = position on stack (0 indexed)
        HashMap<String, Integer> mp = new HashMap<>();  // mp[event string] = event index
        ArrayList<String> v = new ArrayList<>();        // v[event index] = event string


        //Lectura de datos
        int n = scan.getInt();
        pos = new int[n+1];
        pos[n] = -1;

        for (int e = 0; e < n; e++) {
            char c = scan.getWord().charAt(0);
            if (c == 'E') {
                String event = scan.getWord();
                if (!mp.containsKey(event) ) {
                    mp.put(event, v.size());
                    v.add(event);
                }
                s.add(mp.get(event));
                pos[mp.get(event)] = s.size() - 1;
            } else if (c == 'D') {
                int x = scan.getInt();
                for (int i = 0; i < x; i++) {
                    pos[s.get(s.size()-1)] = -1;
                    s.remove(s.size()-1);
                }
            } else {
                int x = scan.getInt();  // number of conditions
                boolean ploterror = false;
                int stack_lte = s.size();
                int stack_gte = -1;
                for (int i = 0; i < x; i++) {
                    String event = scan.getWord();
                    if (ploterror) continue;

                    boolean negate = false;
                    if (event.charAt(0)== '!') {
                        negate = true;
                        event = event.substring(1);
                    }

                    if (negate == false) {  // event must happen
                        if (!mp.containsKey(event)|| pos[mp.get(event)] == -1) {
                            ploterror = true;
                            continue;
                        }
                        int event_index = mp.get(event);
                        stack_gte = Math.max(stack_gte, pos[event_index]);  // we must not cross this one

                    } else {  // event must not happen
                        if (!mp.containsKey(event) || pos[mp.get(event)] == -1) {
                            continue;
                        }
                        stack_lte = Math.min(stack_lte, pos[mp.get(event)]);  // we must cross this one
                    }
                }

                if (ploterror) {
                    System.out.println("Plot Error");
                } else if (stack_lte > stack_gte) {
                    if ((int)s.size() == stack_lte) {
                        System.out.println("Yes");
                    } else {
                        System.out.println(s.size() - stack_lte + " Just A Dream");
                    }
                } else {
                    System.out.println("Plot Error");
                }
            }
        }


    }

}

