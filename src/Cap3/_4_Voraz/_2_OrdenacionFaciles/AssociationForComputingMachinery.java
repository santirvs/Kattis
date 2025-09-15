package Cap3._4_Voraz._2_OrdenacionFaciles;

// Estrategia Voraz. Clásicos.

// Estrategia voraz.
// Leer los tiempos estimados, ordenarlos de menor a mayor y mirar si se pueden completar todos antes del límite.
// Imprimir la cantidad de problemas resueltos y el tiempo total de penalización

// v1. WA en Caso de prueba 5

import java.util.*;

public class AssociationForComputingMachinery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int p = sc.nextInt();

        List<Integer> v = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            v.add(sc.nextInt());
        }
        sc.close();

        int currentTime = 0;
        int timeTaken = 0;

        if (v.get(p) >= 300) {
            System.out.println("0 0");
            return;
        }

        currentTime = v.get(p);
        timeTaken = v.get(p);

        v.remove(p); // elimina el elemento en la posición p
        Collections.sort(v);

        int solved = 0;
        for (int i = 0; i < v.size(); i++) {
            solved = i;
            currentTime += v.get(i);
            if (currentTime > 300) {
                System.out.println((i + 1) + " " + timeTaken);
                return;
            }
            timeTaken += currentTime;
        }

        System.out.println((solved + 2) + " " + timeTaken);
    }
}

