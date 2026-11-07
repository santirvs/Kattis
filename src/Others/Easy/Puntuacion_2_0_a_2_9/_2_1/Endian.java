package Others.Easy.Puntuacion_2_0_a_2_9._2_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Endian {
    public static void main(String[] args) throws IOException {
        // Uso de BufferedReader para una lectura eficiente de la entrada estándar
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Línea 1: Formato de origen y destino (ej. "L B" o "B L")
        String line1 = reader.readLine();
        if (line1 == null || line1.trim().isEmpty()) {
            return;
        }
        String[] endians = line1.trim().split("\\s+");
        char fromEndian = endians[0].charAt(0);
        char toEndian = endians[1].charAt(0);

        // Línea 2: Número de bits (k)
        String line2 = reader.readLine();
        // k no es estrictamente necesario para procesar la cadena, pero consumimos la línea

        // Línea 3: Secuencia de bytes con su prefijo (ej. "0b..." o "0x...")
        String data = reader.readLine().trim();

        // Si los tipos de endianness son iguales, la salida es idéntica a la entrada
        if (fromEndian == toEndian) {
            System.out.println(data);
            return;
        }

        // Determinar prefijo y tamaño del bloque (byte) según el tipo de representación
        String prefix = data.substring(0, 2);
        String payload = data.substring(2);

        int charsPerByte;
        if (prefix.equals("0b")) {
            charsPerByte = 8; // En binario, 1 byte = 8 bits (caracteres)
        } else {
            charsPerByte = 2; // En hexadecimal, 1 byte = 2 nibbles (caracteres)
        }

        // Invertir el orden de los bytes
        StringBuilder result = new StringBuilder();
        result.append(prefix);

        int totalChars = payload.length();
        // Recorremos los bytes desde el último hasta el primero
        for (int i = totalChars - charsPerByte; i >= 0; i -= charsPerByte) {
            result.append(payload.substring(i, i + charsPerByte));
        }

        System.out.println(result.toString());
    }
}