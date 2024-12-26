package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._8_BST_Equilibrado_Map;

import java.io.*;
import java.util.Comparator;
import java.util.TreeMap;

// TestCase #5: WA --> No es TreeSet ya que pueden haber elementos repetidos
//                     Se cambia por TreeMap<Quest,Integer> con la cantidad de elementos  --> AC

public class KattissQuest {

    static class Quest {
        int energy;
        int gold;

        public Quest(int energy, int gold) {
            this.energy = energy;
            this.gold = gold;
        }
    }

    public static class Comparador implements Comparator<Quest> {
        @Override
        public int compare(Quest q1, Quest q2) {
            int result = q2.energy - q1.energy;
            if (result == 0)
                result = q2.gold - q1.gold;
            return result;
        }
    }


    public static void main(String[] args) throws IOException {
        //Scanner scan = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        TreeMap<Quest,Integer> listaQuests = new TreeMap<>(new Comparador());

        int numCasos = Integer.parseInt(in.readLine());
        while (numCasos > 0) {
            String[] partes = in.readLine().split(" ");
            String comando = partes[0];
            if (comando.equals("add")) {
                int energia = Integer.parseInt(partes[1]);
                int oro = Integer.parseInt(partes[2]);
                Quest quest = new Quest(energia, oro);
                if (listaQuests.containsKey(quest)) {
                    listaQuests.put(quest, listaQuests.get(quest)+1);
                } else
                    listaQuests.put(quest,1);
            } else if (comando.equals("query")) {
                int energia = Integer.parseInt(partes[1]);
                long oro = 0;
                Quest quest = listaQuests.ceilingKey(new Quest(energia+1, 0));
                while (quest != null && quest.energy <= energia) {
                    oro += quest.gold;
                    energia -= quest.energy;
                    int qtty = listaQuests.get(quest) -1;
                    if (qtty == 0)
                        listaQuests.remove(quest);
                    else
                        listaQuests.put(quest, qtty);
                    quest = listaQuests.ceilingKey(new Quest(energia+1,0));
                }
                out.println(oro);
            }
            numCasos--;
        }

        out.flush();
        out.close();
        in.close();
    }
}