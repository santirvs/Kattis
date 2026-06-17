package Others.Medium.Puntuacion_3_0_a_3_9._3_2;

// El límite máximo para reiniciar el taladro es siempre N*3600 + 59


import java.util.Scanner;

public class HardRocksAndAtomicClocks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int instanteActual = sc.nextInt();
        int horaActual = instanteActual / 3600;
        int instanteMaximo = (horaActual+1) * 3600 + 59;

        int maxSegundosDurmiendo = instanteMaximo - instanteActual;
        int maxMinutosDurmiendo = maxSegundosDurmiendo / 60;

        System.out.println(maxMinutosDurmiendo);


        sc.close();
    }
}