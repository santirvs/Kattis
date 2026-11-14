package Others.Easy.Puntuacion_2_0_a_2_9._2_5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AFuriousCocktail {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //Primera linea
        int numCocktails = Integer.parseInt(st.nextToken());
        int tiempoBeber = Integer.parseInt(st.nextToken());

        //Cargar los datos
        List<Integer> cocktails = new ArrayList<>();

        for (int i=0; i<numCocktails;i++) {
            st = new StringTokenizer(br.readLine());
            cocktails.add(Integer.parseInt(st.nextToken()));
        }

        //Ordenar el array
        Collections.sort(cocktails, Collections.reverseOrder());

        //Empezar por el de mayor tiempo e ir calculando cuanto tiempo restante nos queda
        //El tiempo de beber el primer cocktail no importa
        int tiempoRestante = cocktails.get(0);
        for (int i=1; i<numCocktails;i++) {
            tiempoRestante -= tiempoBeber;  // Restamos el tiempo que tardará en beber
            int duracion = cocktails.get(i);
            tiempoRestante = Math.min( tiempoRestante, duracion);
        }

        //Si queda tiempoRestante tras beber el último cocktail, tendremos el cocktail furioso activado
        if (tiempoRestante > 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}