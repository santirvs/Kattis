package Others.Easy.Puntuacion_1_1_a_1_9._1_8;


import java.util.Locale;
import java.util.Scanner;

public class DanielsDebuggingDisaster {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.UK);

        // Verificamos si hay entrada disponible
        if (!scanner.hasNextDouble()) {
            scanner.close();
            return;
        }

        // ==========================================
        // 1. Lectura de Datos de Entrada
        // ==========================================
        // p: Probabilidad de que una petición sea bloqueada por el firewall
        double p = scanner.nextDouble();

        // N: Número de peticiones consecutivas necesarias para un intento exitoso
        int N = scanner.nextInt();

        // K: Número máximo de intentos permitidos
        int K = scanner.nextInt();

        scanner.close();

        // ==========================================
        // 2. Planteamiento Matemático y Cálculo
        // ==========================================

        // Paso A: Probabilidad de que una sola petición tenga éxito.
        // Si 'p' falla, la probabilidad de éxito es (1.0 - p).
        double probSuccessSingleRequest = 1.0 - p;

        // Paso B: Probabilidad de que un intento completo (de N peticiones en fila) tenga éxito.
        // Dado que las peticiones son independientes, se eleva a la potencia N: (1 - p)^N
        double probSuccessSingleAttempt = Math.pow(probSuccessSingleRequest, N);

        // Paso C: Probabilidad de que un intento falle.
        // Es el complemento del éxito en un intento: 1 - P(éxito intento)
        double probFailSingleAttempt = 1.0 - probSuccessSingleAttempt;

        // Paso D: Probabilidad de que TODOS los K intentos fallen.
        // Como los intentos son independientes, elevamos el fallo del intento a la potencia K: (fallo)^K
        double probAllAttemptsFail = Math.pow(probFailSingleAttempt, K);

        // Paso E: Probabilidad total de que el programa tenga éxito.
        // El éxito global ocurre si NO todos los intentos fallan (es decir, al menos uno triunfa).
        double totalSuccessProbability = 1.0 - probAllAttemptsFail;

        // ==========================================
        // 3. Salida del Resultado
        // ==========================================
        System.out.println(totalSuccessProbability);
    }
}