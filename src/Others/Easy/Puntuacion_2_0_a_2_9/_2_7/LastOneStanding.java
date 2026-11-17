package Others.Easy.Puntuacion_2_0_a_2_9._2_7;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LastOneStanding {

    public static void main(String[] args) throws IOException {
        // Lectura rápida desde la entrada estándar
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. Leemos los atributos del Jugador 1: vida (h1), daño (d1) y recarga (t1)
        // Usamos long en todas las variables para evitar desbordamientos (overflow)
        // en caso de que h * t supere el límite de 32 bits (~2.14 * 10^9).
        String line1 = br.readLine();
        if (line1 == null) return;
        StringTokenizer st1 = new StringTokenizer(line1);
        long h1 = Long.parseLong(st1.nextToken());
        long d1 = Long.parseLong(st1.nextToken());
        long t1 = Long.parseLong(st1.nextToken());

        // 2. Leemos los atributos del Jugador 2: vida (h2), daño (d2) y recarga (t2)
        String line2 = br.readLine();
        if (line2 == null) return;
        StringTokenizer st2 = new StringTokenizer(line2);
        long h2 = Long.parseLong(st2.nextToken());
        long d2 = Long.parseLong(st2.nextToken());
        long t2 = Long.parseLong(st2.nextToken());

        // 3. Calculamos cuántos misiles necesita cada jugador para destruir al oponente.
        // Necesitamos la división entera redondeada hacia arriba: ceil(vida / daño).
        // Con enteros positivos, ceil(A / B) equivale exactamente a (A + B - 1) / B,
        // evitando el uso de double y posibles errores de precisión.
        long shotsByPlayer1 = (h2 + d1 - 1) / d1;
        long shotsByPlayer2 = (h1 + d2 - 1) / d2;

        // 4. Calculamos el instante exacto en el que cada jugador dispara su misil letal.
        // Como ambos empiezan cargados en t = 0:
        // - El 1.er disparo ocurre en t = 0 * t_recarga = 0
        // - El k-ésimo disparo ocurre en t = (k - 1) * t_recarga
        // Nota: Ambos misiles tardan 0.5s en llegar al objetivo. Como ese +0.5s se suma
        // a ambos tiempos de impacto, se cancela al compararlos y basta comparar los
        // instantes de disparo final.
        long finalShotTime1 = (shotsByPlayer1 - 1) * t1;
        long finalShotTime2 = (shotsByPlayer2 - 1) * t2;

        // 5. Determinamos el ganador comparando quién dispara antes su golpe mortal
        if (finalShotTime1 < finalShotTime2) {
            // El misil letal del Jugador 1 impacta 0.5s después de finalShotTime1,
            // antes de que impacte el del Jugador 2.
            System.out.println("player one");
        } else if (finalShotTime2 < finalShotTime1) {
            // El misil letal del Jugador 2 impacta antes que el del Jugador 1.
            System.out.println("player two");
        } else {
            // Ambos misiles letales se disparan en el mismo instante e impactan
            // simultáneamente 0.5s después, destruyéndose mutuamente.
            System.out.println("draw");
        }
    }
}