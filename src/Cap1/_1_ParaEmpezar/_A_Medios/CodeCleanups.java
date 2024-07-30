package Cap1._1_ParaEmpezar._A_Medios;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class CodeCleanups {

   public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Lectura de los datos del caso
       int numDirtyPushes = scan.nextInt();
       int ultimoClean = 0;
       int numCleans = 0;
       ArrayList<Integer> dirtyPushes = new ArrayList<>();
       ArrayList<Integer> tempPushes = new ArrayList<>();

       //Leer los dirty pushes
       for (int i = 0; i < numDirtyPushes; i++)
            dirtyPushes.add (scan.nextInt());

       //Analizar la secuencia de dirty pushes
       for (int i = 0; i < numDirtyPushes; i++)
       {
           int temp = 0;
           //Suma todos los dirty pushes anteriores desde el ultimo clean push
           for (int j = 0; j < tempPushes.size(); j++)
               temp += dirtyPushes.get(i) - ultimoClean - tempPushes.get(j);

           //Si la suma es menor de 20, se añade a la lista de dirty pushes, modificando el tiempo desde el último clean
           if (temp < 20)
               tempPushes.add(dirtyPushes.get(i) - ultimoClean);
           else
           {
               //Si la suma es mayor de 20, se hace un clean y se resetea la lista de dirty pushes
               ultimoClean = dirtyPushes.get(i);
               numCleans++;
               tempPushes.clear();
               tempPushes.add(dirtyPushes.get(i) - ultimoClean);
           }
       }

       //Mostrar resultado
       System.out.println(numCleans+1);

   }

}

/*
int main()
{
	ll i, j, k;

	ll cases;
	ll temp;
	ll lastClean = 0;
	ll cleans = 0;
	vector<ll> pushes;
	vector<ll> tempPushes;
	cin >> cases;

	for (i = 0; i < cases; i++)
	{
		cin >> temp;
		pushes.push_back(temp);
	}

	for (i = 0; i < cases; i++)
	{
		temp = 0;
		for (j = 0; j < tempPushes.size(); j++)
		{
			temp += pushes[i] - lastClean - tempPushes[j];

		}

		if (temp < 20)
		{
			tempPushes.push_back(pushes[i] - lastClean);
		}
		else
		{
			lastClean = pushes[i];
			cleans++;
			tempPushes.clear();
			tempPushes.push_back(pushes[i] - lastClean);
		}
	}
	cout << cleans + 1 << "\n";
	return 0;
}
 */