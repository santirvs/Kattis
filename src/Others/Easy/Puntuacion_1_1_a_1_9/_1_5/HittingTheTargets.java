package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer la cantidad de objetos
// Crear una lista de objetos
// Leer la cantidad de disparos
// Para cada disparo, cuantos objetos son alcanzados



import java.util.Scanner;

public class HittingTheTargets {

    static class Objeto {
        int x;
        int y;
        String tipo;
        int x2;
        int y2;
        int radio;
        Objeto(int x, int y, String tipo, int x2, int y2, int radio) {
            this.x = x;
            this.y=y;
            this.tipo = tipo;
            this.x2 = x2;
            this.y2=y2;
            this.radio = radio;
        }

        boolean esAlcanzado(int x, int y) {
            boolean result = false;
            if (tipo.equals("rectangle")) {
                if (this.x <= x && this.x2 >=x && this.y <=y && this.y2 >= y) {
                    result = true;
                }
            }
            else {
                int distX = Math.abs(x - this.x);
                int distY = Math.abs(y - this.y);
                if (Math.sqrt( distX*distX + distY*distY) <= this.radio ) {
                    result = true;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer la cantidad de objetos e inicializar el array
        int numObjetos = sc.nextInt();
        Objeto[] listaObjetos = new Objeto[numObjetos];

        //Leer los objetos
        int pos = 0;
        while (pos < numObjetos) {
            String tipo = sc.next();
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            if (tipo.equals("rectangle")) {
                int x2= sc.nextInt();
                int y2= sc.nextInt();
                listaObjetos[pos] = new Objeto(x1,y1,tipo,x2,y2,0);
            } else {
                int radi = sc.nextInt();
                listaObjetos[pos] = new Objeto(x1,y1,tipo,0,0,radi);
            }
            pos++;
        }

        //Leer la cantidad de disparos
        int numDisparos = sc.nextInt();
        while (numDisparos-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            //Recorrer la lista buscando los objetos alcanzados por el disparo
            int contador = 0;
            for (Objeto o:listaObjetos) {
                if (o.esAlcanzado(x,y)) contador++;
            }
            //Para cada disparo, mostrar la cantidad de objetos alcanzados
            System.out.println(contador);
        }
    }
}

