package Cap1._2_ProblemasAdHoc._9_Tiempo_Dificiles;


import java.util.*;

public class BirthdayBoy_RTE {

    public static class date implements Comparable<date> {
        int m, d;

        date(int m, int d) {
            this.m = m;
            this.d = d;
        }

        @Override
        public int compareTo(date o) {
            return (m == o.m) ? d - o.d : m - o.m;
        }

        public boolean equals(Object other) {
            date o = (date) other;
            return m == o.m && d == o.d;
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        ArrayList<Integer> days = new ArrayList<>(Arrays.asList(31,28,31,30,31,30,31,31,30,31,30,31));

        //Crear una lista con todas las fechas del año
        ArrayList<date> all = new ArrayList<>();
        for(int i = 0; i < 12; i++) {
            for(int j = 0; j < days.get(i); j++) {
                date d = new date(i+1,j+1);
                all.add(d);
            }
        }

        //Lista con las fechas de los compañeros
        ArrayList<date> coworker = new ArrayList<>();

        int n = scan.nextInt();
        for(int i = 0; i < n; i++) {
            scan.next(); //Ignorar el nombre

            String[] fecha = scan.next().split("-");
            date d = new date(Integer.parseInt(fecha[0]),Integer.parseInt(fecha[1]));
            coworker.add(d);
        }


        int ans = 0;
        ArrayList<date> best = new ArrayList<>();

        // for each start point
        for(int i=0; i<all.size(); i++) {
            date d = all.get(i);

            if (coworker.contains(d)) {
                continue;
            }

            int dayswithout = 0;
            int pos = 0;

            while(true) {
                pos++;
                if (i+pos >= all.size()) {
                    pos = -i;
                }
                d = all.get(i+pos);

                if(coworker.contains(d)) {
                    break;
                }

                // process here
                dayswithout++;
                if(dayswithout > ans) {
                    best.clear();
                }
                if(dayswithout >= ans) {
                    ans = dayswithout;
                    best.add(d);
                }

                if(pos == 0) {
                    break;
                }
            }

        }

        Collections.sort(best);
        date selectedDate = null;
        boolean after27Oct = false;
        date _27Oct = new date(10,27);

        for (date d : best) {
            int comparation = d.compareTo(_27Oct);
            if (selectedDate == null && comparation != 0) {
                selectedDate = d;
            } else if (!after27Oct && comparation > 0) {
                selectedDate = d;
            }

            if (comparation > 0) {
                after27Oct = true;
            }

        }


        System.out.printf("%02d-%02d\n", selectedDate.m, selectedDate.d);
    }
}

/*
#include <bits/stdc++.h>

using namespace std;

struct date {
    int m, d;
};

bool operator<(const date& d1, const date& d2) {
    if(d1.m == d2.m) {
        return d1.d < d2.d;
    }
    return d1.m < d2.m;
}

bool operator==(const date& d1, const date& d2) {
    return (d1.m == d2.m) && (d1.d == d2.d);
}

int main() {
    vector<int> days = {31,28,31,30,31,30,31,31,30,31,30,31};

    set<date> all;
    for(int i = 0; i < 12; i++) {
        for(int j = 0; j < days[i]; j++) {
            date d;
            d.m = i+1;
            d.d = j+1;
            all.insert(d);
        }
    }

    set<date> coworker;

    int n;
    cin >> n;

    for(int i = 0; i < n; i++) {
        string s;
        cin >> s;
        date d;
        cin >> d.m;
        cin.ignore();
        cin >> d.d;
        coworker.insert(d);
    }


    int ans = 0;
    set<date> best;

    // for each start point
    for(auto i : all) {
        auto it = all.find(i);
        if(coworker.count(i)) {
            continue;
        }

        int dayswithout = 0;

        while(true) {
            it = next(it);
            if(it == all.end()) {
                it = all.begin();
            }
            date d = *(it);

            if(coworker.count(d)) {
                break;
            }

            // process here
            dayswithout++;
            if(dayswithout > ans) {
                best.clear();
            }
            if(dayswithout >= ans) {
                ans = dayswithout;
                best.insert(d);
            }

            if(d == i) {
                break;
            }
        }

    }

    auto d1 = best.lower_bound({10,28});
    auto d2 = best.begin();
    date d;
    if(d1 != best.end()) {
        d = *d1;
    }
    else {
        d = *d2;
    }

    if(d.m < 10) cout << "0";
    cout << d.m;
    cout << "-";
    if(d.d < 10) cout << "0";
    cout << d.d;
    cout << endl;
}
 */
