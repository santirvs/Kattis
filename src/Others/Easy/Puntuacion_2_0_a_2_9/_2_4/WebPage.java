package Others.Easy.Puntuacion_2_0_a_2_9._2_4;

/*
    transformar los caracteres prohibidos a su equivalente válido
 */

import java.util.Scanner;

public class WebPage {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;

        String entrada = sc.nextLine();
        StringBuilder salida = new StringBuilder();

        for (int i = 0; i < entrada.length(); i++) {
            char car = entrada.charAt(i);

            // Filtro de caracteres islandeses y acentuados (independiente de si es Mayus/Minus)
            // No da buen resultado convertir a mayúsculas / minusculas estos caracteres
            if (car == 'Á' || car == 'á') salida.append("a");
            else if (car == 'Ð' || car == 'ð') salida.append("d");
            else if (car == 'É' || car == 'é') salida.append("e");
            else if (car == 'Í' || car == 'í') salida.append("i");
            else if (car == 'Ó' || car == 'ó' || car == 'Ö' || car == 'ö') salida.append("o");
            else if (car == 'Ú' || car == 'ú') salida.append("u");
            else if (car == 'Ý' || car == 'ý') salida.append("y");
            else if (car == 'Þ' || car == 'þ') salida.append("th"); // Corrección 1: 'th'
            else if (car == 'Æ' || car == 'æ') salida.append("ae"); // Corrección 2: 'ae'
            else {
                // Si es un carácter ASCII normal, lo pasamos a minúscula manualmente
                char minuscula = Character.toLowerCase(car);

                // Permitir letras Y dígitos (0-9)
                if ((minuscula >= 'a' && minuscula <= 'z') || (minuscula >= '0' && minuscula <= '9')) {
                    salida.append(minuscula);
                }
            }
        }

        // Agregar la extensión del dominio de Islandia (.is)
        salida.append(".is");
        System.out.println(salida.toString());
        sc.close();
    }
}