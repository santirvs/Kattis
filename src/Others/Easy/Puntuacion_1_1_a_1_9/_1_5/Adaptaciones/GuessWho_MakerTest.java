package Others.Easy.Puntuacion_1_1_a_1_9._1_5.Adaptaciones;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GuessWho_MakerTest {
    final static int NUM_PERSONAJES = 65536;
    final static int NUM_ATRIBUTOS = 16;
    final static int NUM_PREGUNTAS = 14;

    public static void main(String[] args) throws IOException {
        // Sacar a un fichero
        FileWriter writer = new FileWriter("./src/Others/Easy/Puntuacion_1_1_a_1_9/_1_5/Adaptaciones/quiEsQui.x.in", false);

        writer.write(NUM_PERSONAJES + " " + NUM_ATRIBUTOS + " " + NUM_PREGUNTAS + "\n");

        for (int i=0; i<NUM_PERSONAJES; i++) {
            for (int j=0; j<NUM_ATRIBUTOS; j++) {
                if ((i & 1<<j) == 0) writer.write("N");
                else writer.write("S");
            }
            writer.write("\n");
        }

        Random r = new Random();

        for (int i=0; i<NUM_PREGUNTAS; i++) {
            String respuesta = r.nextBoolean() ? "S" : "N";
            writer.write((r.nextInt(NUM_ATRIBUTOS)+1) + " " + respuesta + "\n");
        }


        writer.flush();
        writer.close();
    }

}
