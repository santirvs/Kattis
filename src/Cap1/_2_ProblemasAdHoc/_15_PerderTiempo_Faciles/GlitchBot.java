package Cap1._2_ProblemasAdHoc._15_PerderTiempo_Faciles;

import java.util.Locale;
import java.util.Scanner;

public class GlitchBot {

    public enum Direccion {NORTH, EAST, SOUTH, WEST};
    public static class Posicion {
        int x;
        int y;
        Direccion direccion = Direccion.NORTH;
        public Posicion(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void mover (String comando) {
            if (comando.equals("Forward")) {
                if (direccion == Direccion.NORTH) y++;
                else if (direccion == Direccion.SOUTH) y--;
                else if (direccion == Direccion.WEST) x--;
                else if (direccion == Direccion.EAST) x++;
            }
            else if (comando.equals("Right")) {
                if (direccion == Direccion.NORTH) direccion = Direccion.EAST;
                else if (direccion == Direccion.SOUTH) direccion = Direccion.WEST;
                else if (direccion == Direccion.WEST) direccion = Direccion.NORTH;
                else if (direccion == Direccion.EAST) direccion = Direccion.SOUTH;
            }
            else if (comando.equals("Left")) {
                if (direccion == Direccion.NORTH) direccion = Direccion.WEST;
                else if (direccion == Direccion.SOUTH) direccion = Direccion.EAST;
                else if (direccion == Direccion.WEST) direccion = Direccion.SOUTH;
                else if (direccion == Direccion.EAST) direccion = Direccion.NORTH;
            }
        }
    }

    public static void simularRobot(Posicion p, String[] instrucciones) {
        for (int i=0; i<instrucciones.length; i++) {
            p.mover(instrucciones[i]);
        }
    }
     public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer la entrada
        int destinoX = scan.nextInt();
        int destinoY = scan.nextInt();

        //Leer el número de instrucciones
        int n = scan.nextInt();

        //Leer las instrucciones
        String[] instrucciones = new String[n];
        for (int i=0; i<n; i++) {
            instrucciones[i] = scan.next();
        }

        boolean encontrado = false;
        int numInstruccion = 0;
        String instruccionCambiada = "";
        //Definir las coordenadas
        for (int i=0; i<n && !encontrado; i++) {
            //Cambiar la instruccion i por una de las variantes
            String instruccionOriginal = instrucciones[i];
            for (int j=0; j<2 && !encontrado; j++) {
                Posicion p = new Posicion (0,0);
                if (instrucciones[i].equals("Forward")) instrucciones[i] = "Left";
                else if (instrucciones[i].equals("Left")) instrucciones[i] = "Right";
                else if (instrucciones[i].equals("Right")) instrucciones[i] = "Forward";
                simularRobot(p, instrucciones);
                if (p.x == destinoX && p.y == destinoY) {
                    encontrado = true;
                    numInstruccion = i+1;
                    instruccionCambiada = instrucciones[i];
                }
            }
            //Restaurar la instruccion original
            instrucciones[i] = instruccionOriginal;
        }

        //Mostrar el resultado
         System.out.println(numInstruccion+ " " + instruccionCambiada);

    }
}


