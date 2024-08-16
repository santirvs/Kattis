package Cap1._2_ProblemasAdHoc._7_VidaReal_Dificiles;


import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class WorkoutForADumbbell_WA {

    static public class Maquina {
        int uso;
        int descanso;
        int inicio;

        public Maquina(int uso, int descanso, int inicio) {
            this.uso = uso;
            this.descanso = descanso;
            this.inicio = inicio;
        }


        public int buscarLibre(int tiempo, int siguienteUso) {
            int resultado = tiempo;
            if (tiempo >= inicio) {
                int tiempoCiclo = (tiempo-inicio) % (uso+descanso);
                if (tiempoCiclo < uso) {
                    //Esperar a que acabe el uso
                    resultado = tiempo + uso - tiempoCiclo;
                    if (siguienteUso > descanso) {
                        inicio = resultado + siguienteUso;
                    } else {
                        //No se altera el inicio
                    }
                } else if (tiempoCiclo >= uso && tiempoCiclo < uso+descanso) {
                    //Inicio inmediato
                    resultado = tiempo;
                    if (siguienteUso  > descanso - tiempoCiclo+1) {
                        inicio = tiempo + siguienteUso;
                    }
                    else {
                        //No se altera el inicio
                    }
                } else {
                    //Justo ahora acaba el descanso, le deja usar la máquina
                    resultado = tiempo+uso;
                    if (siguienteUso > descanso) {
                        inicio = resultado + siguienteUso;
                    } else {
                        //No se altera el inicio
                    }
                }

            } else {
                //Cambiar el siguiente inicio
                if (resultado + siguienteUso > inicio) {
                    inicio = resultado + siguienteUso;
                }
            }
            return resultado;
        }
    }

        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            scan.useLocale(Locale.ENGLISH);

            //Leer el programa de entrenamiento de Jim
            int[] usos = new int[10];
            int[] descansos = new int[10];

            for (int i = 0; i < 10; i++) {
                usos[i] = scan.nextInt();
                descansos[i] = scan.nextInt();
            }

            //Leer el uso de cada máquina
            ArrayList<Maquina> maquinas = new ArrayList<Maquina>();
            for (int i=0; i<10; i++) {
                int uso = scan.nextInt();
                int descanso = scan.nextInt();
                int inicio  = scan.nextInt();
                Maquina m = new Maquina(uso, descanso, inicio);
                maquinas.add(m);
            }

            //Simular el entrenamiento
            int tiempo = 0;

            for (int ciclo=0; ciclo<3; ciclo++) {
                for (int i=0; i<10; i++) {
                    Maquina m = maquinas.get(i);
                    tiempo = m.buscarLibre(tiempo, usos[i]);
                    tiempo += usos[i];
                    //Si no es la última máquina en el último ciclo, añadir descanso
                    if (ciclo!=2 || i!=9) {
                        tiempo += descansos[i];
                    }
                }
            }

            //Imprimir el tiempo total
            System.out.println(tiempo);
     }

}
