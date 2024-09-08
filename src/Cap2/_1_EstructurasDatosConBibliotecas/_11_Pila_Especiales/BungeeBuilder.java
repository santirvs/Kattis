package Cap2._1_EstructurasDatosConBibliotecas._11_Pila_Especiales;

import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

//No veo donde usar la pila...

//Recorrer los datos de las montañas
//Implementar una máquina de estados
// 1: Buscando Pico, hasta que no encuentre un valor inferior al anterior. Me guardo el anterior como punto máximo y el actual como punto mínimo
// 2: Buscando Extremo, hasta que no encuentre un valor igual o superior al máximo. Voy actualizando el valor mínimo
// 3: De nuevo buscando pico

//Caso #8: WA --> Me he dejado de controlar el caso de que no haya encontrado un pico al final del recorrido.
//            --> Implemento el caso de llegar al final del recorrido buscando extremo.
//            --> Ahora me da WA en el caso#6:  Una secuencia estrictamente decreciente da error. Sólo se actualiza el valle
//            --> en el caso que realmente sea un valle (altura actual mayor que la anterior)
//            --> Caso #6 y Caso #8: AC
//Caso #13 WA -->
public class BungeeBuilder {

    static final int BUSCANDO_PICO = 1;
    static final int BUSCANDO_EXTREMO = 2;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numMontes = scan.nextInt();
        int estado = BUSCANDO_PICO;
        int nivelValle = 0;
        int alturaMaxima = 0;
        int profundidadMaxima = 0;
        int picoMaximo = 0;
        int anterior = 0;

        //Recorrer las montañas
        for (int i=0; i<numMontes; i++) {
            //Altura del nuevo monte
            int altura = scan.nextInt();
            if (estado == BUSCANDO_PICO) {
                if (altura > alturaMaxima) {
                    //Seguir buscando pico
                    alturaMaxima = altura;
                }
                else {
                    //Encontrado el pico, hay que buscar el otro extremo
                    nivelValle = altura;
                    picoMaximo = altura;
                    estado = BUSCANDO_EXTREMO;
                }
            }
            else if (estado == BUSCANDO_EXTREMO) {
                if (altura >= alturaMaxima) {
                    //He encontrado donde poner el extremo del puente
                    //Calculo el nivel del valle más profundo y vuelvo a buscar un pico
                    profundidadMaxima = Math.max(profundidadMaxima, alturaMaxima - nivelValle);
                    alturaMaxima = altura;
                    estado = BUSCANDO_PICO;
                }
                else {
                    //Actualizo el nivel del valle y del pico máximo hasta el momento
                    picoMaximo = Math.max(picoMaximo, altura);
                    if (anterior < altura) {
                        nivelValle = Math.min(nivelValle,anterior);
                    }
                }
            }
            anterior = altura;
        }
        if (estado == BUSCANDO_EXTREMO) {
            //He llegado al final y no he encontrado un pico
            //Calculo el nivel del valle más profundo hasta ese momento
            profundidadMaxima = Math.max(profundidadMaxima, picoMaximo - nivelValle);
        }

        //Mostrar el resultado
        System.out.println(profundidadMaxima);
    }
}
