package Others.Easy.Puntuacion_1_1_a_1_9._1_9;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BookshelfBottleneck {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1. Leer n (número de libros) y H (altura máxima del estante)
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;
        st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        long H = Long.parseLong(st.nextToken());

        long totalWidth = 0;

        // 2. Procesar cada libro individualmente
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            long minWidthForThisBook = -1;

            // 3. Probar las 3 posibles orientaciones según qué dimensión actúa como altura (h <= H)

            // Orientación 1: La altura es 'a'
            if (a <= H) {
                long w = Math.min(b, c); // El ancho que ocupa en el estante será la menor de las otras dos dimensiones
                if (minWidthForThisBook == -1 || w < minWidthForThisBook) {
                    minWidthForThisBook = w;
                }
            }

            // Orientación 2: La altura es 'b'
            if (b <= H) {
                long w = Math.min(a, c);
                if (minWidthForThisBook == -1 || w < minWidthForThisBook) {
                    minWidthForThisBook = w;
                }
            }

            // Orientación 3: La altura es 'c'
            if (c <= H) {
                long w = Math.min(a, b);
                if (minWidthForThisBook == -1 || w < minWidthForThisBook) {
                    minWidthForThisBook = w;
                }
            }

            // 4. Si ningún lado cumple con la restricción de altura, es imposible colocar el libro
            if (minWidthForThisBook == -1) {
                System.out.println("impossible");
                return;
            }

            // 5. Acumular el ancho mínimo necesario para este libro
            totalWidth += minWidthForThisBook;
        }

        // 6. Imprimir el ancho total requerido por todos los libros
        System.out.println(totalWidth);
    }
}


