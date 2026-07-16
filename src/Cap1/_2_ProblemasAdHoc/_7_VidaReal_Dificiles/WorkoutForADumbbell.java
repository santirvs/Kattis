package Cap1._2_ProblemasAdHoc._7_VidaReal_Dificiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WorkoutForADumbbell {

    static class Maquina {
        long uso;
        long descanso;
        long proximoInicio; // El instante exacto donde la otra persona iniciará su siguiente ciclo

        public Maquina(long uso, long descanso, long inicio) {
            this.uso = uso;
            this.descanso = descanso;
            this.proximoInicio = inicio;
        }

        public long usarMaquina(long tJim, long dJim) {
            // CASO 1: Jim llega antes de que la otra persona comience su ciclo.
            // Jim la usa inmediatamente.
            if (tJim < proximoInicio) {
                long tFinJim = tJim + dJim;
                if (tFinJim > proximoInicio) {
                    // Si interfiere con el inicio del otro, lo desplaza.
                    proximoInicio = tFinJim;
                }
                return tFinJim;
            }

            // CASO 2: Jim llega después o en el mismo instante en que inició el ciclo de la otra persona
            long duracionCiclo = uso + descanso;
            long tiempoDesdeInicio = tJim - proximoInicio;
            long ciclosCompletados = tiempoDesdeInicio / duracionCiclo;

            long inicioEsteCiclo = proximoInicio + ciclosCompletados * duracionCiclo;
            long finUsoEsteCiclo = inicioEsteCiclo + uso;

            if (tJim < finUsoEsteCiclo) {
                // El otro usuario está usando la máquina en este momento. Jim espera a que termine.
                long tFinJim = finUsoEsteCiclo + dJim;

                // El otro usuario termina su uso e inicia su descanso.
                long sgteInicioPlanificado = finUsoEsteCiclo + descanso;
                if (tFinJim > sgteInicioPlanificado) {
                    // Si Jim se pasa del tiempo de descanso del otro, este se retrasa.
                    proximoInicio = tFinJim;
                } else {
                    proximoInicio = sgteInicioPlanificado;
                }
                return tFinJim;
            } else {
                // El otro usuario está en su tiempo de descanso. Jim la usa de inmediato.
                long tFinJim = tJim + dJim;
                long sgteInicioPlanificado = inicioEsteCiclo + duracionCiclo;

                if (tFinJim > sgteInicioPlanificado) {
                    // El uso de Jim interfiere con el siguiente inicio planificado del otro.
                    proximoInicio = tFinJim;
                } else {
                    proximoInicio = sgteInicioPlanificado;
                }
                return tFinJim;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        if (line == null) return;
        StringTokenizer st = new StringTokenizer(line);

        long[] jimUso = new long[10];
        long[] jimDescanso = new long[10];
        for (int i = 0; i < 10; i++) {
            jimUso[i] = Long.parseLong(st.nextToken());
            jimDescanso[i] = Long.parseLong(st.nextToken());
        }

        Maquina[] maquinas = new Maquina[10];
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            long u = Long.parseLong(st.nextToken());
            long d = Long.parseLong(st.nextToken());
            long t = Long.parseLong(st.nextToken());
            maquinas[i] = new Maquina(u, d, t);
        }

        long tiempo = 0;

        for (int ronda = 0; ronda < 3; ronda++) {
            for (int i = 0; i < 10; i++) {
                tiempo = maquinas[i].usarMaquina(tiempo, jimUso[i]);

                if (!(ronda == 2 && i == 9)) {
                    tiempo += jimDescanso[i];
                }
            }
        }

        System.out.println(tiempo);
    }
}