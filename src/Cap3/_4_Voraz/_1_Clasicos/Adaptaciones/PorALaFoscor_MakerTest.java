package Cap3._4_Voraz._1_Clasicos.Adaptaciones;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PorALaFoscor_MakerTest {

    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("./src/Cap3/_4_Voraz/_1_Clasicos/Adaptaciones/porALaFoscor.x.in", false);

        final int INICIO = 100;
        final int FIN = 10000;
        final int NUM_FAROLAS = 1000;

        writer.write(INICIO + " " + FIN + "\n");
        writer.write(NUM_FAROLAS + "\n");

        Random r = new Random();

        for (int i=0; i<NUM_FAROLAS; i++) {
            double inicio = r.nextDouble(FIN+100);
            double fin = inicio + r.nextDouble(10);

            writer.write(String.format("%.4f %.4f \n", inicio,fin));
        }

        writer.flush();
        writer.close();

    }

}
