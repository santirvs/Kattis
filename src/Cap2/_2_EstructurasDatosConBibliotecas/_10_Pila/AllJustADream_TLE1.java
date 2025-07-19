package Cap2._2_EstructurasDatosConBibliotecas._10_Pila;

import Utils.Kattio;

import java.util.*;

//Crear una pila de Eventos
//En paralelo, crear una lista de Eventos
//Si llega un evento, lo añadimos a la pila y a la lista
//Si llega un dream, eliminamos de la pila y de la lista
//Si llega un escenario, revisamos que existan los eventos en la lista y que realmente no existan los que no existen
//Si se afirma que hay un evento que no existe en la lista, se imprime "Plot Error"
//Si se afirma que no hay un evento que existe en la lista, nos quedamos con el menor del número de eventos a deshacer
//Si se afirma que hay un evento que existe en la lista, nos quedamos con el mayor del número de eventos (esos no los podemos deshacer)

// Caso#3:TLE -> agilizar la lista!  30 eventos x escenario y hasta 50.000 eventos. 1.500.000 comparaciones!!!
// Empiezo por Usar Kattio  --> TLE
// Cambio Pila<Evento> y ArrayList<Evento> por Stack<String> y HashMap<String,Integer> --> AC

// Caso#4:TLE --> Cambio HashMap por TreeMap --> TLE en Caso#3, restauro HashMap
// Adapto el código de https://github.com/BrandonTang89/Competitive_Programming_4_Solutions/blob/main/Chapter_2_Data_Structures/Linear_DS_with_Built-in_Libraries/kattis_dream.cpp
// ya que tengo un TLE y el planteamiento es parecido. Una vez más sospecho que el límite de tiempo para Java es insuficiente
// Efectivmente, el código de BrandonTang89 también da TLE una vez se adapta a Java.

public class AllJustADream_TLE1 {

    public static void main(String[] args) {
        //Scanner scan = new Scanner(System.in);
        //scan.useLocale(Locale.ENGLISH);
        Kattio scan = new Kattio(System.in);

        //Lectura de datos
        int cantEventos = scan.getInt();

        //Contador de eventos, pila y lista
        int numEvento = 0;
        Stack<String> pila = new Stack<>();
        HashMap<String,Integer> lista = new HashMap<>();

        for (int i=1; i<=cantEventos;i++) {
            String tipoEvento = scan.getWord();
            if (tipoEvento.equals("E")) {
                numEvento++;
                String evento = scan.getWord();
                pila.push(evento);
                lista.put(evento,numEvento);
            }
            else if (tipoEvento.equals("D")) {
                int numEventosBorrar = scan.getInt();
                numEvento -= numEventosBorrar;
                for (int j=0; j<numEventosBorrar; j++) {
                    String e = pila.pop();
                    lista.remove(e);
                }
            }
            else {
                //Scenario
                int numEventos = scan.getInt();
                boolean plotError = false;
                int minEventos = Integer.MAX_VALUE;
                int maxEventos = Integer.MIN_VALUE;
                for (int j=0; j<numEventos; j++) {
                    String evento = scan.getWord();
                    if (evento.charAt(0) == '!') {
                        //El escenario no contiene el evento
                        evento = evento.substring(1);
                        if (lista.containsKey(evento)) {
                            //Si la lista contiene el evento, nos quedamos con el menor indice
                            minEventos = Math.min(minEventos,lista.get(evento));
                        }
                    }
                    else {
                        //El escenario contiene el evento
                        if (lista.containsKey(evento)) {
                            //La lista contiene el evento, nos quedamos con el mayor indice
                            maxEventos = Math.max(maxEventos, lista.get(evento));
                        }
                        else {
                            //La lista no contiene el evento
                            plotError = true;
                        }
                    }
                }
                if (plotError || minEventos < maxEventos) {
                    System.out.println("Plot Error");
                }
                else if (minEventos == Integer.MAX_VALUE) {
                    System.out.println("Yes");
                }
                else {
                    System.out.println((numEvento - minEventos + 1 )+ " Just A Dream");
                }
            }
        }


    }

}

