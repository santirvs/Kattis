package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._6_TablaDeHash_Dificil;

import java.util.*;

// Leer las instrucciones de un lenguaje BASIC
// Leer las instrucciones y ordenarlas en una tabla de hash
// Las variables se guardarán en otra tabla de hash
// El programa se acaba cuando no se procese la instrucción con la etiqueta más alta

public class BASICInterpreter {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        TreeMap<Integer, String> lineas = new TreeMap<Integer, String>();
        HashMap<String, Long> variables = new HashMap<String, Long>();

        //Lectura de las instrucciones
        while (scan.hasNext()) {
            int etiqueta = scan.nextInt();
            if (etiqueta == 0) break;  // Para pruebas interactivas
            String instruccion = scan.nextLine().trim();
            lineas.put(etiqueta, instruccion);

        }

        //Procesar las instrucciones
        int ultimaLinea = lineas.lastKey();

        //Guardarse un mapa con las etiquetas de las instrucciones a posiciones y viceveersa
        HashMap<Integer, Integer> labelToPos = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> posToLabel = new HashMap<Integer, Integer>();

        int i = 0;
        for (int numEtiqueta : lineas.keySet()) {
            posToLabel.put(i, numEtiqueta);
            labelToPos.put(numEtiqueta, i);
            i++;
        }


        int ip = 0;  //Instrucción Pointer
        int label = 0;

        // **********************************
        //MOSTRAR EL PROGRAMA ORDENADO
        // QUITAR ESTE CODIGO!!!
        if (false) {

            do {
                label = posToLabel.get(ip);
                String instruccion = lineas.get(label);
                String[] instruccionPartes = instruccion.split(" ");

                System.out.println(label + " " + instruccion);

                ip++;
            } while (label != ultimaLinea);
            // **********************************
        }

        //Ejecutar las instrucciones
        ip = 0;  //Instrucción Pointer
        do  {
            label = posToLabel.get(ip);
            String instruccion = lineas.get(label);
            String[] instruccionPartes = instruccion.split(" ");

            if (instruccionPartes[0].equals("LET")) {
                long resultado = calcular(instruccion.substring(8), variables);
                variables.put(instruccionPartes[1], resultado);
                ip++;
            } else if (instruccionPartes[0].equals("PRINT")) {
                if (instruccionPartes[1].startsWith("\"")) {
                    System.out.print(instruccion.substring(7, instruccion.length()-1));
                } else
                    System.out.print(recuperarValor(instruccionPartes[1], variables));
                ip++;
            } else if (instruccionPartes[0].equals("PRINTLN")) {
                if (instruccionPartes[1].startsWith("\"")) {
                    System.out.println(instruccion.substring(9, instruccion.length() - 1));
                } else
                    System.out.println(recuperarValor(instruccionPartes[1], variables));
                ip++;
            } else if (instruccionPartes[0].equals("IF")) {
                long var1 = recuperarValor(instruccionPartes[1], variables);
                long var2 = recuperarValor(instruccionPartes[3], variables);
                boolean saltar = false;
                switch (instruccionPartes[2]) {
                    case "=": saltar = var1 == var2; break;
                    case "<": saltar = var1 < var2; break;
                    case ">": saltar = var1 > var2; break;
                    case "<=": saltar = var1 <= var2; break;
                    case ">=": saltar = var1 >= var2; break;
                    case "<>": saltar = var1 != var2; break;
                }
                if (saltar) {
                    ip = labelToPos.get(Integer.parseInt(instruccionPartes[6]));
                } else {
                    ip++;
                }

            }

        } while (label != ultimaLinea);


    }

    private static long calcular(String substring, HashMap<String, Long> variables) {
        long result = 0;
        String[] arithmeticStatement = substring.split(" ");
        long var1 = recuperarValor(arithmeticStatement[0], variables);
        if (arithmeticStatement.length > 1) {
            long var2 = recuperarValor(arithmeticStatement[2], variables);

            if (arithmeticStatement[1].equals("+")) {
                result = var1 + var2;
            } else if (arithmeticStatement[1].equals("-")) {
                result = var1 - var2;
            } else if (arithmeticStatement[1].equals("*")) {
                result = var1 * var2;
            } else if (arithmeticStatement[1].equals("/")) {
                result = var1 / var2;
            }
        }
        else
            result = var1;

        return checkLimits(result);
    }

    private static long checkLimits(long result) {
        return (int) result;
    }

    private static long recuperarValor(String variable, HashMap<String, Long> variables) {
        if (variable.charAt(0) >= '0' && variable.charAt(0) <= '9' || variable.charAt(0) == '-')
            return Long.parseLong(variable);
        else
            return variables.get(variable);
    }

}

