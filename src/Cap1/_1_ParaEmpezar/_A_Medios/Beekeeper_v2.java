package Cap1._1_ParaEmpezar._A_Medios;

import java.util.Locale;
import java.util.Scanner;


public class Beekeeper_v2 {

    public static int count(String word) {
        int n = 0;
        int i = 0;
        while (i < word.length() - 1) {
            char c = word.charAt(i);
            if (c== 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c== 'y') {
                if (c == word.charAt(i + 1)) {
                    ++n; ++i;
                }
            }
            ++i;
        }

        return n;
    }

   public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Lectura de los datos del caso
       int numPalabras = scan.nextInt();

       while (numPalabras > 0 ) {
          scan.nextLine();
           int max = -1;
           String fav="";
           while (numPalabras>0) {
               numPalabras--;
               String word = scan.nextLine();
               int c = count(word);
               if (c > max) {
                   max = c;
                   fav = word;
               }
           }

           System.out.println(fav);

           //Siguiente caso
           numPalabras = scan.nextInt();
       }
   }

}


/*
#include <iostream>
#include <string>

int count(const std::string& word) {
    int n = 0;
    std::size_t i = 0;
    while (i < word.size() - 1) {
        if (word[i] == 'a' ||
                        word[i] == 'e' ||
                        word[i] == 'i' ||
                        word[i] == 'o' ||
                        word[i] == 'u' ||
            word[i] == 'y') {
            if (word[i] == word[i + 1]) {
                ++n; ++i;
            }
        }
        ++i;
    }

    return n;
}

int main() {
    while(1) {
        int n = 0;
        std::cin >> n;
        std::cin.ignore();

        if (n == 0)
            break;

        int max = -1;
        std::string fav;
        while (n--) {
            std::string word;
            std::getline(std::cin, word);
            const int c = count(word);
            if (c > max) {
                max = c;
                fav = word;
            }
        }

        std::cout << fav << std::endl;
    }

    return 0;
}
 */

