package Cap1._2_ProblemasAdHoc._16_PerderTiempo_Dificiles;

import java.util.*;

public class Sabor_TLE {

    public static class Foto {
        int parlamentario1;
        int parlamentario2;

        public Foto(int parlamentario1, int parlamentario2) {
            this.parlamentario1 = parlamentario1;
            this.parlamentario2 = parlamentario2;
        }

        public boolean equals(Object o) {
            if (o instanceof Foto) {
                Foto f = (Foto) o;
                return ((this.parlamentario1 == f.parlamentario1 && this.parlamentario2 == f.parlamentario2) ||
                        (this.parlamentario1 == f.parlamentario2 && this.parlamentario2 == f.parlamentario1) );
            }
            return false;
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer la entrada
        int numParlamentarios = scan.nextInt();
        scan.nextLine();

        //Asumir que todos los parlamentarios son del mismo partido 'A'
        char parlamento[] = new char[numParlamentarios];
        Arrays.fill(parlamento, 'A');

        Set<Foto> listaFotos = new HashSet<>();
        //Leer las fotografías
        for (int i=0; i<5; i++) {
            String[] foto = scan.nextLine().split("  ");

            //Numero de fotos en cada día
            int numFotos = foto.length-1;

            for (int f=1; f<=numFotos; f++) {
                //Obtener el parlamentario
                int parlamentario1 = Integer.parseInt(foto[f].split(" ")[0])-1;
                int parlamentario2 = Integer.parseInt(foto[f].split(" ")[1])-1;

                Foto nuevaFoto = new Foto(parlamentario1, parlamentario2);
                listaFotos.add(nuevaFoto);
            }
        }


        //Empezar a probar las combinaciones
        //Se empieza suponiendo que todos los parlamentarios son del partido 'A'
        //Y se cuenta el número de fotos donde coincide el partido de los parlamentarios
        //Nos apuntamos los que más exceden, si superan la cantidad de 2, los cambiamos de partido y repetimos
        boolean encontrado = false;

        while (!encontrado) {
            int maxFotos = 0;
            ArrayList<Integer> parlamentariosMaxFotos = new ArrayList<>();
            int[] apariciones = new int[numParlamentarios];
            for (Foto f : listaFotos) {
                if (parlamento[f.parlamentario1] == parlamento[f.parlamentario2]) {
                    apariciones[f.parlamentario1]++;
                    apariciones[f.parlamentario2]++;
                    if (apariciones[f.parlamentario1] > maxFotos || apariciones[f.parlamentario2] > maxFotos) {
                        maxFotos = Math.max(apariciones[f.parlamentario1], apariciones[f.parlamentario2]);
                        parlamentariosMaxFotos.clear();
                    }
                    if (apariciones[f.parlamentario1] == maxFotos) {
                        parlamentariosMaxFotos.add(f.parlamentario1);
                    }
                    if (apariciones[f.parlamentario2] == maxFotos) {
                        parlamentariosMaxFotos.add(f.parlamentario2);
                    }
                }
            }
            if (maxFotos <= 2) {
                encontrado = true;
            } else {
                for (int p : parlamentariosMaxFotos) {
                    if (parlamento[p] == 'A') {
                        parlamento[p] = 'B';
                    } else {
                        parlamento[p] = 'A';
                    }
                }
            }
        }

        //Mostrar el resultado
        for (int i=0; i<numParlamentarios; i++) {
            System.out.print(parlamento[i]);
        }
        System.out.println();

     }
}

/*  OK

#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false), cin.tie(NULL); // Fast IO
  int n;
  cin >> n;
  vector<vector<int>> G(n);
  for (int i = 0, p, k, l; i < 5; ++i) {
    cin >> p;
    while (p--) {
      cin >> k >> l;
      --k, --l;
      G[k].push_back(l), G[l].push_back(k);
    }
  }
  stack<int> S;
  vector<int> C(n, 0);
  for (int i = 0; i < n; ++i) S.push(i);
  while (!S.empty()) {
    array<int,2> cnt{0,0};
    int i = S.top();
    S.pop();
    for (int j : G[i]) ++cnt[C[j]];
    if (cnt[C[i]] <= 2) continue;
    C[i] ^= 1;
    for (int j : G[i]) S.push(j);
  }
  for (int c : C) cout << (c?'B':'A');
  cout << endl;
  return 0;
}

 */
