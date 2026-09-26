package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class WhereOhWhereHasMyLittleDogGone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.UK);

        // 1. Leer las medidas del perro perdido
        double ears = scanner.nextDouble();
        double tail = scanner.nextDouble();
        double dogRatio = ears / tail;

        // 2. Leer el número de razas
        int n = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente

        List<String> matches = new ArrayList<String>();

        // 3. Procesar cada raza de la base de datos
        for (int i = 0; i < n; i++) {
            String breedName = scanner.nextLine();
            String[] parts = scanner.nextLine().split("\\s+");

            double ratioLow = Double.parseDouble(parts[0]);
            double ratioHigh = Double.parseDouble(parts[1]);
            double earLow = Double.parseDouble(parts[2]);
            double earHigh = Double.parseDouble(parts[3]);

            // 4. Comprobar si cumple ambas condiciones
            boolean ratioMatches = (dogRatio >= ratioLow && dogRatio <= ratioHigh);
            boolean earMatches = (ears >= earLow && ears <= earHigh);

            if (ratioMatches && earMatches) {
                matches.add(breedName);
            }
        }

        // 5. Imprimir resultados o "Mutt" si no hay coincidencias
        if (matches.isEmpty()) {
            System.out.println("Mutt");
        } else {
            for (String breed : matches) {
                System.out.println(breed);
            }
        }

        scanner.close();
    }
}
